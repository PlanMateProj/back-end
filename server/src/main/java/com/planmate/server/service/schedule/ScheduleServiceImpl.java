package com.planmate.server.service.schedule;

import com.planmate.server.domain.Schedule;
import com.planmate.server.dto.request.schedule.AddScheduleRequestDto;
import com.planmate.server.dto.response.schedule.AddScheduleResponseDto;
import com.planmate.server.exception.schedule.ScheduleNotFoundException;
import com.planmate.server.repository.ScheduleRepository;
import com.planmate.server.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    public AddScheduleResponseDto addDDay(final AddScheduleRequestDto addScheduleRequestDto) {
        return AddScheduleResponseDto.of(scheduleRepository.save(
            Schedule.builder()
                    .title(addScheduleRequestDto.getTitle())
                    .memberId(JwtUtil.getMemberId())
                    .targetDate(LocalDate.parse(addScheduleRequestDto.getTargetDate(), DateTimeFormatter.ISO_DATE))
                    .build()
        ));
    }

    @Override
    public void deleteDDay(final Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new ScheduleNotFoundException(id)
        );

        scheduleRepository.delete(schedule);
    }
}
