package com.planmate.server.controller;

import com.planmate.server.dto.request.subject.SubjectCreateDto;
import com.planmate.server.service.subject.SubjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/subject")
public class SubjectController {

    private SubjectService subjectService;

    @PostMapping("/create")
    @ApiOperation("새 과목을 생성")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "새 과목 생성 성공"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "새 과목을 생성하는데 실패함")
    })
    public void subjectCreate(@RequestBody SubjectCreateDto subjectCreateDto){
        subjectService.subjectCreate(subjectCreateDto);

    }

    @DeleteMapping("/remove/{subjectId}")
    @ApiOperation("과목 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "과목 삭제 성공"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "과목을 삭제하는데 실패함")
    })
    public void subjectDeleteById(@PathVariable("subjectId") Long Id){
        subjectService.subjectDeleteById(Id);

    }

}
