package com.education.demo.service;

import com.education.demo.entity.Cooperation;
import com.education.demo.entity.Page;

import java.util.List;

public interface CooperationService {
     List<Cooperation> queryCooperation(Cooperation cooperation);

     Cooperation queryCooperationById(int id);

     boolean operationCooperation(Cooperation cooperation);

     boolean deleteCooperation(int id);

     Page findCooperation4Page(Cooperation cooperation , Page page);
}
