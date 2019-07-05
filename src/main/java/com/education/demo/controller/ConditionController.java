package com.education.demo.controller;

import com.education.demo.entity.Condition;
import com.education.demo.entity.Page;
import com.education.demo.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/conditionController")
public class ConditionController extends BaseController{
    @Autowired
    private ConditionService conditionService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryConditionList(Condition condition) {
        Page page = getPage();
        page = conditionService.findCondition4Page(condition, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optCondition(Condition condition) {

        try {
            conditionService.operationCondition(condition);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delCondition(int conditionId) {
        try {
            conditionService.deleteCondition(conditionId);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editCondition(int conditionId) {
        return conditionService.queryConditionById(conditionId);
    }
}
