package com.planmate.server.dto.request.subject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectCreateDto {

    private long id;
    private String name;
    private int type;
    private int dDay;

}
