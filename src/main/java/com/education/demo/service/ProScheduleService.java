package com.education.demo.service;

import com.education.demo.entity.ProSchedule;
import com.education.demo.entity.Page;

import java.util.List;

public interface ProScheduleService {
    List<ProSchedule> queryProSchedule(ProSchedule proSchedule);

    ProSchedule queryProScheduleById(int id);

    boolean operationProSchedule(ProSchedule proSchedule);

    boolean deleteProSchedule(int id);

    Page findProSchedule4Page(ProSchedule proSchedule , Page page);
}
