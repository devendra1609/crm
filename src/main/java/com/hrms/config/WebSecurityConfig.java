package com.hrms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/authenticate", "/users/insertUser", "/users/getUsers", "/users/getUser/{id}", "/users/updateUser", "/users/deleteUser/{id}", "/roles/insert", "/roles/get", "/roles/get/{userTypeId}", "/roles/update", "/roles/delete/{userTypeId}","/customer/insert","/getCustomers","/getCustomer/{customerId}","/updateCustomer","/deleteCustomer/{customerId}","/insertAddCategory","/getAddcategories","/getAddCategory/{categoryId}","/updateAddCategory","/deleteAddCategory/{categoryId}","/insertBranch","/getBranches","/getBranch/{branchId}","/updateBranch","/deleteBranch/{branchId}" ,"/insertinvoice" ,"/getinvoices" ,"/getinvoice/{invoiceId}" ,"/updateinvoice" ,"/deleteinvoice/{invoiceId}" ,"/insertLeaveType" ,"/getLeaveTypes" ,"/getLeaveType/{leaveTypeId}" ,"/updateLeaveType","/deleteLeaveType/{leaveTypeId}" ,"/insertProduct","/getProducts" ,"/getProduct/{productId}" ,"/updateProduct" ,"/deleteProduct/{productId}" ,"/insertproductstock" ,"/getproductstocks" ,"/getproductstock/{productstockid}" ,"/updateproductstock" ,"/deleteproductstock/{productStockId}" ,"/insertQuatation" ,"/getQuatations" ,"/getquatation/{quatationId}" ,"/updatequatation" ,"/deleteQuatation/{quatationId}" ,"/insertshipment" ,"/getshipments" ,"/getshipment/{shipmentId}" ,"/updateshipment" ,"/deleteshipment/{shipmentId}").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }


}
