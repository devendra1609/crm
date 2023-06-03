package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.config.TokenProvider;
import com.hrms.dao.model.AuthToken;
import com.hrms.dao.model.LoginUser;
import com.hrms.dao.model.User;
import com.hrms.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
	@Autowired
	private UserService userService;
	
	//@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUserName(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
	
	@PostMapping("/insertUser")
	public ResponseEntity<Integer> insertUser(@RequestBody User user)
	{
		try {
			Integer id=userService.insertUser(user);
			return new ResponseEntity<Integer>(id,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers(){
		try {
			return new ResponseEntity<List<User>>(userService.getUsers(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id){
		try {
			
			return new ResponseEntity<User>(userService.getUser(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateUser")
	public ResponseEntity<Void> updateUser(@RequestBody User user){
		try {
			userService.updateUser(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id )
	{
		try {
			userService.deleteUser(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
