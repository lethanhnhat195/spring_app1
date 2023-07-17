package com.ijv.internjava.service;

import com.ijv.internjava.model.entity.WorkShift;

import java.util.List;

public interface WorkShiftService {
    List<WorkShift> getAllWorkShift();

    WorkShift createWorkShift(WorkShift workShift);

    WorkShift getWorkShiftById(Long id);

    WorkShift updateWorkShift(Long id, WorkShift workShiftDetail);

    void deleteWorkShift(Long id);

    WorkShift addEmployeeToWorkShift(WorkShift workShift);
}
