package com.education.demo.controller;

import com.education.demo.entity.SchoolUser;
import com.education.demo.entity.Page;
import com.education.demo.service.SchoolUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/schoolUserController")
public class SchoolUserController extends BaseController {
    
    @Autowired
    private SchoolUserService schoolUserService;

    @RequestMapping("list")
    @ResponseBody
    public Object querySchoolUserList(SchoolUser schoolUser) {
        Page page = getPage();
        page = schoolUserService.findSchoolUser4Page(schoolUser, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optSchoolUser(SchoolUser schoolUser) {

        try {
            schoolUserService.operationSchoolUser(schoolUser);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delSchoolUser(int id) {
        try {
            schoolUserService.deleteSchoolUser(id);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editSchoolUser(int id) {
        return schoolUserService.querySchoolUserById(id);
    }
}
