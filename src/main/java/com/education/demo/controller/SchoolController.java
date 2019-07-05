package com.education.demo.controller;

import com.education.demo.entity.School;
import com.education.demo.entity.Page;
import com.education.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/schoolController")
public class SchoolController extends BaseController{
    @Autowired
    private SchoolService schoolService;

    @RequestMapping("list")
    @ResponseBody
    public Object querySchoolList(School school) {
        Page page = getPage();
        page = schoolService.findSchool4Page(school, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optSchool(School school) {

        try {
            schoolService.operationSchool(school);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delSchool(int schoolId) {
        try {
            schoolService.deleteSchool(schoolId);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editSchool(int schoolId) {
        return schoolService.querySchoolById(schoolId);
    }
}
