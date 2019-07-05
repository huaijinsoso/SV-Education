package com.education.demo.controller;


import com.education.demo.entity.CityUser;
import com.education.demo.entity.Page;

import com.education.demo.service.CityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cityUserController")
public class CityUserController extends BaseController{
    @Autowired
    private CityUserService cityUserService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryCityUserList(CityUser cityUser) {
        Page page = getPage();
        page = cityUserService.findCityUser4Page(cityUser, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optCityUser(CityUser cityUser) {

        try {
            cityUserService.operationCityUser(cityUser);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delCityUser(int id) {
        try {
            cityUserService.deleteCityUser(id);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editCityUser(int id) {
        return cityUserService.queryCityUserById(id);
    }
}
