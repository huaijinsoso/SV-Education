package com.education.demo.controller;

import com.education.demo.entity.Specialty;
import com.education.demo.entity.Page;
import com.education.demo.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SpecialtyController")
public class SpecialtyController extends BaseController{
    @Autowired
    private SpecialtyService specialtyService;

    @RequestMapping("list")
    @ResponseBody
    public Object querySpecialtyList(Specialty specialty) {
        Page page = getPage();
        page = specialtyService.findSpecialty4Page(specialty, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optSpecialty(Specialty specialty) {

        try {
            specialtyService.operationSpecialty(specialty);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delSpecialty(int speConId) {
        try {
            specialtyService.deleteSpecialty(speConId);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editSpecialty(int speConId) {
        return specialtyService.querySpecialtyById(speConId);
    }
    
}
