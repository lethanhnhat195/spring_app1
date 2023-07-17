package com.ijv.internjava.controller;


import com.ijv.internjava.model.entity.WorkShift;
import com.ijv.internjava.service.WorkShiftService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/work-shift")
public class WorkShiftController {

    @Autowired
    private WorkShiftService workShiftService;

     //get all work-shift
    @GetMapping("/list")
    public ResponseEntity<List<WorkShift>> getAllWorkShifts() {
        List<WorkShift> workShifts = workShiftService.getAllWorkShift();
        return ResponseEntity.ok(workShifts);
    }


    // create work-shift rest api
    @PostMapping("/add")
    public ResponseEntity<WorkShift> createWorkShift(@RequestBody WorkShift workShift) {
        WorkShift createWorkShift = workShiftService.createWorkShift(workShift);
        return ResponseEntity.ok(createWorkShift);
    }
    // get work-shift
    @GetMapping("/{id}")
    public ResponseEntity<WorkShift> getWorkShiftById(@PathVariable Long id) {
        WorkShift workShift = workShiftService.getWorkShiftById(id);
        return ResponseEntity.ok(workShift);
    }
    //update employee rest api
    @PutMapping("update/{id}")
    public ResponseEntity<WorkShift> updateWorkShift(@PathVariable Long id,@RequestBody WorkShift workShiftDetails) {
        WorkShift updateWorkShift = workShiftService.updateWorkShift(id, workShiftDetails);
        return ResponseEntity.ok(updateWorkShift);
    }

    // delete employee rest api
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteWorkShift(@PathVariable Long id) {
        workShiftService.deleteWorkShift(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/add-employee-to-work-shift")
    public ResponseEntity<WorkShift> addEmployeeToWorkShift(@RequestBody WorkShift workShift) {
            WorkShift addEmployeeToWorkShift = workShiftService.addEmployeeToWorkShift(workShift);
        return ResponseEntity.ok(addEmployeeToWorkShift);
    }
}
