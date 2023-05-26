package com.planmate.server.service.Subject;

import com.planmate.server.dto.request.subject.SubjectCreateDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SubjectService {

    public void subjectCreate(SubjectCreateDto subjectCreateDto);
    public void subjectDeleteById(Long Id);


}
