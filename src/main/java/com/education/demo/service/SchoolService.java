package com.education.demo.service;

import com.education.demo.entity.School;
import com.education.demo.entity.Page;

import java.util.List;

public interface SchoolService {
    List<School> querySchool(School school);

    School querySchoolById(int id);

    boolean operationSchool(School school);

    boolean deleteSchool(int id);

    Page findSchool4Page(School school , Page page);
}
