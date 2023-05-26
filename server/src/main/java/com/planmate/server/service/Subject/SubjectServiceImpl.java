package com.planmate.server.service.Subject;


import com.planmate.server.domain.Subject;
import com.planmate.server.dto.request.subject.SubjectCreateDto;
import com.planmate.server.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Transactional
public class SubjectServiceImpl implements SubjectService{

    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(final SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void subjectCreate(SubjectCreateDto subjectCreateDto){
        Subject subject = createSubjectEntity(subjectCreateDto);
        subjectRepository.save(subject);

    }
    @Override
    public void subjectDeleteById(Long Id){
        subjectRepository.deleteById(Id);
    }

    private Subject createSubjectEntity(SubjectCreateDto subjectCreateDto) {
        return Subject.builder()
                .id(subjectCreateDto.getId())
                .name(subjectCreateDto.getName())
                .type(subjectCreateDto.getType())
                .dDay(subjectCreateDto.getDDay())
                .build();
    }


}
