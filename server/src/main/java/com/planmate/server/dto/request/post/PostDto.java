package com.planmate.server.dto.request.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private List<String> tagList;
}
