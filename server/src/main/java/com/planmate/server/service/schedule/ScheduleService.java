package com.planmate.server.service.schedule;

import com.planmate.server.dto.request.schedule.AddScheduleRequestDto;
import com.planmate.server.dto.request.schedule.ScheduleEditRequestDto;
import com.planmate.server.dto.response.schedule.ScheduleResponseDto;

public interface ScheduleService {
    public ScheduleResponseDto addDDay(AddScheduleRequestDto addScheduleRequestDto);
    public void deleteDDay(Long id);
    public ScheduleResponseDto modifySchedule(ScheduleEditRequestDto editRequestDto);
}
