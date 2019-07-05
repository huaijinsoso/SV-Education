package com.education.demo.controller;

import com.education.demo.entity.Student;
import com.education.demo.entity.Page;
import com.education.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/studentController")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryStudentList(Student student) {
        Page page = getPage();
        page = studentService.findStudent4Page(student, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optStudent(Student student) {

        try {
            studentService.operationStudent(student);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delStudent(int id) {
        try {
            studentService.deleteStudent(id);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editStudent(int id) {
        return studentService.queryStudentById(id);
    }
}
