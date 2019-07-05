package com.education.demo.service;


import com.education.demo.entity.Page;
import com.education.demo.entity.City;

import java.util.List;

public interface CityService {
	
	
	
	 List<City> queryCity(City city);
	
	 City queryCityById(int id);
	
	 boolean operationCity(City city);
	
	 boolean deleteCity(int id);
	
	 Page findCity4Page(City city , Page page);

}
