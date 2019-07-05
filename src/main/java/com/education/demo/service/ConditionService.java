package com.education.demo.service;

import com.education.demo.entity.Condition;
import com.education.demo.entity.Page;

import java.util.List;

public interface ConditionService {
    List<Condition> queryCondition(Condition condition);

    Condition queryConditionById(int id);

    boolean operationCondition(Condition condition);

    boolean deleteCondition(int id);

    Page findCondition4Page(Condition condition , Page page);
}
