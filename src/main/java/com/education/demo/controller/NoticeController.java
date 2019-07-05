package com.education.demo.controller;

import com.education.demo.entity.Notice;
import com.education.demo.entity.Page;
import com.education.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/noticeController")
public class NoticeController extends BaseController{
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryNoticeList(Notice notice) {
        Page page = getPage();
        page = noticeService.findNotice4Page(notice, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optNotice(Notice notice) {

        try {
            noticeService.operationNotice(notice);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delNotice(int id) {
        try {
            noticeService.deleteNotice(id);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editNotice(int id) {
        return noticeService.queryNoticeById(id);
    }
}
