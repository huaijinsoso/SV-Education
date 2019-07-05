package com.education.demo.controller;

import com.education.demo.entity.Page;
import com.education.demo.entity.ProSchedule;
import com.education.demo.service.ProScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/proScheduleController")
public class ProScheduleController extends BaseController{
    @Autowired
    private ProScheduleService proScheduleService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryProScheduleList(ProSchedule proSchedule) {
        Page page = getPage();
        page = proScheduleService.findProSchedule4Page(proSchedule, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optProSchedule(ProSchedule proSchedule) {

        try {
            proScheduleService.operationProSchedule(proSchedule);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delProSchedule(int id) {
        try {
            proScheduleService.deleteProSchedule(id);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editProSchedule(int id) {
        return proScheduleService.queryProScheduleById(id);
    }
}
