package com.shailesh.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.shailesh.config.DayOfWeekIntegerConverter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@SqlResultSetMapping(name = "getShopClosingTimeOn", classes = {
//		@ConstructorResult(targetClass = LocalTime.class, columns = { @ColumnResult(name = "closing_time") }) })



@Entity
@Table(name = "opening_hours")
@Getter
@Setter
@Builder
public class OpeningHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private LocalTime closingTime;

	@Column(name = "day")
	@Convert(converter = DayOfWeekIntegerConverter.class)
	private DayOfWeek day;

}