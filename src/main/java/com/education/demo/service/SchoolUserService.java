package com.education.demo.service;

import com.education.demo.entity.Page;
import com.education.demo.entity.SchoolUser;

import java.util.List;

public interface SchoolUserService {
    List<SchoolUser> querySchoolUser(SchoolUser schoolUser);

    SchoolUser querySchoolUserById(int id);

    boolean operationSchoolUser(SchoolUser schoolUser);

    boolean deleteSchoolUser(int id);

    Page findSchoolUser4Page(SchoolUser schoolUser , Page page);
}
