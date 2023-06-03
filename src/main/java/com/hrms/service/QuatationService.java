package com.hrms.service;

import java.util.List;

import com.hrms.dao.model.Quatation;

public interface QuatationService {
	public Integer insertQuatation(Quatation quatation);
	public List<Quatation> getQuatations();
	public Quatation getQuatation(Integer quatationId);
	public void updateQuatation(Quatation quatation);
	public void deleteQuatation(Integer quatationId);
}
