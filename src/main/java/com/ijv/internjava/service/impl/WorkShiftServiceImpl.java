package com.ijv.internjava.service.impl;

import com.ijv.internjava.exception.ResourceNotFoundException;

import com.ijv.internjava.model.entity.WorkShift;
import com.ijv.internjava.repository.WorkShiftRepository;
import com.ijv.internjava.service.EmployeeService;
import com.ijv.internjava.service.WorkShiftService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WorkShiftServiceImpl implements WorkShiftService {

    private WorkShiftRepository workShiftRepository;
    private EmployeeService service;

    @Override
    public List<WorkShift> getAllWorkShift() {
        List<WorkShift> workShifts = workShiftRepository.findAll();
        return workShifts;
    }


    @Override
    public WorkShift createWorkShift(WorkShift workShift) {
        return workShiftRepository.save(workShift);
    }

    @Override
    public WorkShift getWorkShiftById(Long id) {
        WorkShift workShift = workShiftRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        return workShift;
    }

    @Override
    public WorkShift updateWorkShift(Long id, WorkShift workShiftDetail) {
        Optional<WorkShift> optionalWorkShift = workShiftRepository.findById(id);

        if (optionalWorkShift.isPresent()) {
            WorkShift workShift = optionalWorkShift.get();

            workShift.setName(workShiftDetail.getName());
            workShift.setWorkingFromTime(workShiftDetail.getWorkingFromTime());
            workShift.setWorkingToTime(workShiftDetail.getWorkingToTime());
            workShift.setDescription(workShiftDetail.getDescription());


            WorkShift updateWorkShift = workShiftRepository.save(workShift);
            return updateWorkShift;
        } else {
            throw new ResourceNotFoundException("Employee not exist with id : " + id);
        }
    }

    @Override
    public void deleteWorkShift(Long id) {
        workShiftRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        workShiftRepository.deleteById(id);
    }



    @Override
    public WorkShift addEmployeeToWorkShift(WorkShift workShift) {
        WorkShift addEmployeeToWorkShift = workShiftRepository.save(workShift);

        Employee employee = new Employee();

        service.createEmployee(employee);
        return addEmployeeToWorkShift;

    }

}
