package com.example.spring_crud_demo1.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
    }

    @Transactional
    public void create(String summary, String description) {
        issueRepository.insert(summary, description);
    }

    public IssueEntity findById(int id) {
        return issueRepository.findById(id);
    }

    @Transactional
    public void delete(int id) {
        issueRepository.delete(id);
    }

    @Transactional
    public void update(String summary, String description, int id) {
        issueRepository.update(summary, description, id);
    }

}
