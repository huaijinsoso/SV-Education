package com.education.demo.service.impl;

import com.education.demo.dao.CityUserDao;
import com.education.demo.entity.CityUser;
import com.education.demo.entity.Page;
import com.education.demo.service.CityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityUserServiceImpl implements CityUserService {

    @Autowired
    private CityUserDao cityUserDao;

    @Override
    public List<CityUser> queryCityUser(CityUser cityUser) {
        return (List<CityUser>)cityUserDao.selectByPage(cityUser);
    }

    @Override
    public CityUser queryCityUserById(int id) {
        return cityUserDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationCityUser(CityUser cityUser) {
        if(0 == cityUser.getCuserId()){
            return cityUserDao.insert(cityUser) > 0 ? true : false;
        } else {
            return cityUserDao.updateByPrimaryKey(cityUser) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteCityUser(int id) {
        return cityUserDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findCityUser4Page(CityUser cityUser, Page page) {
        cityUser.setPage(page.getPage());
        cityUser.setRows(page.getRows());
        page.setRecords(cityUserDao.selectCityUserCount());
        page.setGridObjectData(cityUserDao.selectByPage(cityUser));
        return page;
    }
}
