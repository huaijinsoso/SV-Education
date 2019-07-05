package com.education.demo.controller;


import com.education.demo.entity.Teacher;
import com.education.demo.entity.Page;
import com.education.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teacherController")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryTeacherList(Teacher teacher) {
        Page page = getPage();
        page = teacherService.findTeacher4Page(teacher, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optTeacher(Teacher teacher) {

        try {
            teacherService.operationTeacher(teacher);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delTeacher(int teacherId) {
        try {
            teacherService.deleteTeacher(teacherId);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editTeacher(int teacherId) {
        return teacherService.queryTeacherById(teacherId);
    }
}
