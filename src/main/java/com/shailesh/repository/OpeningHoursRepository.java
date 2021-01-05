package com.shailesh.repository;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shailesh.domain.OpeningHours;

public interface OpeningHoursRepository extends CrudRepository<OpeningHours, Long> {

	
	
	
	@Query(value = "SELECT closing_time FROM opening_hours WHERE day = :#{#day_of_week.getValue()}", nativeQuery = true)
    public LocalTime getShopClosingTimeOn(@Param("day_of_week") DayOfWeek dayOfWeek);

}
