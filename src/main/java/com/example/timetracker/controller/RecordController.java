package com.example.timetracker.controller;

import com.example.timetracker.model.Record;
import com.example.timetracker.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record savedRecord = recordService.saveRecord(record);
        return ResponseEntity.ok(savedRecord);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable Long id) {
        Optional<Record> record = recordService.findById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Record>> getRecordsByUserId(@PathVariable Long userId) {
        List<Record> records = recordService.findByUserId(userId);
        return ResponseEntity.ok(records);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Record>> getRecordsByProjectId(@PathVariable Long projectId) {
        List<Record> records = recordService.findByProjectId(projectId);
        return ResponseEntity.ok(records);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}

