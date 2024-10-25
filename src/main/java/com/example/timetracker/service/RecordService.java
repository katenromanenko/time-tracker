package com.example.timetracker.service;

import com.example.timetracker.model.Record;
import com.example.timetracker.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    public Optional<Record> findById(Long id) {
        return recordRepository.findById(id);
    }

    public List<Record> findByUserId(Long userId) {
        return recordRepository.findByUserId(userId);
    }

    public List<Record> findByProjectId(Long projectId) {
        return recordRepository.findByProjectId(projectId);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}

