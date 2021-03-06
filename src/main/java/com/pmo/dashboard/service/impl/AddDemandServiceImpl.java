package com.pmo.dashboard.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pmo.dashboard.dao.AddDemandMapper;
import com.pmo.dashboard.dao.HSBCDeptMapper;
import com.pmo.dashboard.entity.AddDemand;
import com.pom.dashboard.service.AddDemandService;

@Service
public class AddDemandServiceImpl implements AddDemandService{

	@Resource
	AddDemandMapper addDemandMapper;
	
	@Resource
	HSBCDeptMapper hsbcDeptMapper;
	
	@Override
	public boolean addDemand(AddDemand demand) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hsbcSubDeptName", demand.getHsbcSubDept());
		params.put("hsbcDeptName",demand.getHsbcDept() );
		String hsbcSubDeptId = hsbcDeptMapper.queryHsbcSubDeptId(params);
		demand.setHsbcSubDeptId(hsbcSubDeptId);
		if(addDemandMapper.addDemand(demand)>0){
			return true;
		}
		return false;
	}
	
}