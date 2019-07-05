package com.education.demo.service.impl;

import com.education.demo.dao.ProjectDao;
import com.education.demo.entity.Project;
import com.education.demo.entity.Page;
import com.education.demo.entity.Project;
import com.education.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    
    @Override
    public List<Project> queryProject(Project project) {
        return (List<Project>)projectDao.selectByPage(project);
    }

    @Override
    public Project queryProjectById(int id) {
        return projectDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationProject(Project project) {
        if(0 == project.getProjectId()){
            return projectDao.insert(project) > 0 ? true : false;
        } else {
            return projectDao.updateByPrimaryKey(project) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteProject(int id) {
        return projectDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findProject4Page(Project project, Page page) {
        project.setPage(page.getPage());
        project.setRows(page.getRows());
        page.setRecords(projectDao.selectProjectCount());
        page.setGridObjectData(projectDao.selectByPage(project));
        return page;
    }
}
