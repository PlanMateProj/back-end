package com.planmate.server.service.subject;

import com.planmate.server.domain.Subject;
import com.planmate.server.dto.request.subject.SubjectCreateDto;
import com.planmate.server.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(final SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void subjectCreate(SubjectCreateDto subjectCreateDto){
        Subject subject = Subject.builder()
                .id(subjectCreateDto.getId())
                .name(subjectCreateDto.getName())
                .type(subjectCreateDto.getType())
                .dDay(subjectCreateDto.getDDay())
                .build();
        subjectRepository.save(subject);

    }
    @Override
    public void subjectDeleteById(Long Id){
        subjectRepository.deleteById(Id);
    }


}
