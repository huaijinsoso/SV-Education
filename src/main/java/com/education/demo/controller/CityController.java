package com.education.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.education.demo.entity.Page;
import com.education.demo.entity.City;
import com.education.demo.service.CityService;


@Controller
@RequestMapping("/cityController")
public class CityController extends BaseController {
    
    @Autowired
    private CityService cityService;
    
    @RequestMapping("list")
    @ResponseBody
    public Object queryCityList(City city) {
        Page page = getPage();
        page = cityService.findCity4Page(city, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }
    
    @RequestMapping("opt")
    @ResponseBody
    public Object optCity(City city) {
        
        try {
            cityService.operationCity(city);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }
        
    }
    
    @RequestMapping("del")
    @ResponseBody
    public Object delCity(int cityId) {
        try {
            cityService.deleteCity(cityId);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }
        
    }
    
    @RequestMapping("edit")
    @ResponseBody
    public Object editCity(int cityId) {
        return cityService.queryCityById(cityId);
    }
    
}
