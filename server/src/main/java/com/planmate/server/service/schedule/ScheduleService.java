package com.planmate.server.service.schedule;

import com.planmate.server.dto.request.schedule.AddScheduleRequestDto;
import com.planmate.server.dto.response.schedule.AddScheduleResponseDto;

public interface ScheduleService {
    public AddScheduleResponseDto addDDay(AddScheduleRequestDto addScheduleRequestDto);
}
