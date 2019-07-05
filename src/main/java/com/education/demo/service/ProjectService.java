package com.education.demo.service;

import com.education.demo.entity.Project;
import com.education.demo.entity.Page;

import java.util.List;

public interface ProjectService {
    List<Project> queryProject(Project project);

    Project queryProjectById(int id);

    boolean operationProject(Project project);

    boolean deleteProject(int id);

    Page findProject4Page(Project project , Page page);
}
