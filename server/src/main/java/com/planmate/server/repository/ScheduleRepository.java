package com.planmate.server.repository;

import com.planmate.server.domain.Schedule;
import com.planmate.server.dto.response.schedule.AddScheduleResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {}
