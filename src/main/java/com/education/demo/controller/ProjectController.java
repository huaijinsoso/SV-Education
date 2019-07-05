package com.education.demo.controller;

import com.education.demo.entity.Project;
import com.education.demo.entity.Page;
import com.education.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projectController")
public class ProjectController extends BaseController{
    @Autowired
    private ProjectService projectService;

    @RequestMapping("list")
    @ResponseBody
    public Object queryProjectList(Project project) {
        Page page = getPage();
        page = projectService.findProject4Page(project, page);
        return this.setResultData(page.getRecords(), page.getGridObjectData());//转换成JSON
    }

    @RequestMapping("opt")
    @ResponseBody
    public Object optProject(Project project) {

        try {
            projectService.operationProject(project);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("del")
    @ResponseBody
    public Object delProject(int projectId) {
        try {
            projectService.deleteProject(projectId);
            return this.setSucceedResultMessage("成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.setFailedResultMessage("失败");
        }

    }

    @RequestMapping("edit")
    @ResponseBody
    public Object editProject(int projectId) {
        return projectService.queryProjectById(projectId);
    }
}
