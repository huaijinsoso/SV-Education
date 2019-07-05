package com.education.demo.controller;

import com.education.demo.entity.Cooperation;
import com.education.demo.entity.Page;
import com.education.demo.service.CooperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cooperationController")
public class CooperationController extends BaseController{
    @Autowired
    private CooperationService cooperationService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryCooperationList(Cooperation cooperation) {
        Page page = getPage();
        page = cooperationService.findCooperation4Page(cooperation, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optCooperation(Cooperation cooperation) {

        try {
            cooperationService.operationCooperation(cooperation);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delCooperation(int id) {
        try {
            cooperationService.deleteCooperation(id);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editCooperation(int id) {
        return cooperationService.queryCooperationById(id);
    }
}
