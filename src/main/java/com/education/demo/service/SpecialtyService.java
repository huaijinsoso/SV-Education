package com.education.demo.service;

import com.education.demo.entity.Specialty;
import com.education.demo.entity.Page;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> querySpecialty(Specialty specialty);

    Specialty querySpecialtyById(int id);

    boolean operationSpecialty(Specialty specialty);

    boolean deleteSpecialty(int id);

    Page findSpecialty4Page(Specialty specialty , Page page);
}
