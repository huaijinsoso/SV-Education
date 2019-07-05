package com.education.demo.service;

import com.education.demo.entity.CityUser;
import com.education.demo.entity.Page;

import java.util.List;

public interface CityUserService {
     List<CityUser> queryCityUser(CityUser cityUser);

    CityUser queryCityUserById(int id);

     boolean operationCityUser(CityUser cityUser);

     boolean deleteCityUser(int id);

     Page findCityUser4Page(CityUser cityUser , Page page);
}
