package com.planmate.server.service.subject;

import com.planmate.server.dto.request.subject.SubjectCreateDto;

public interface SubjectService {

    public void subjectCreate(SubjectCreateDto subjectCreateDto);
    public void subjectDeleteById(Long Id);
}
