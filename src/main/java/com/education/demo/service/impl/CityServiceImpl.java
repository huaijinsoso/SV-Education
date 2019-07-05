package com.education.demo.service.impl;

import java.util.List;


import com.education.demo.dao.CityDao;
import com.education.demo.entity.Page;
import com.education.demo.entity.City;
import com.education.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao cityDao;

	@Override
	public List<City> queryCity(City city) {
		return (List<City>)cityDao.selectByPage(city);
	}

	@Override
	public boolean operationCity(City city) {
		if(0 == city.getCityId()){
			return cityDao.insert(city) > 0 ? true : false;
		} else {
			return cityDao.updateByPrimaryKey(city) > 0 ? true : false;
		}
		
	}

	@Override
	public boolean deleteCity(int id) {
		return cityDao.deleteByPrimaryKey(id)> 0 ? true : false;
	}

	@Override
	public City queryCityById(int id) {
		return cityDao.selectByPrimaryKey(id);
	}

	@Override
	public Page findCity4Page(City city, Page page) {
		city.setPage(page.getPage());
		city.setRows(page.getRows());
		page.setRecords(cityDao.selectCityCount());
		page.setGridObjectData(cityDao.selectByPage(city));
		return page;
	}

}
