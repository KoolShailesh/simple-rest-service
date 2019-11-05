package com.shailesh.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class EnumRequest {

	@NotNull
	@JsonProperty("day")
	private WeekDay day;

	@JsonProperty("tvprogram")
	private String tvProgram;

	@JsonProperty("channel")
	private String channel;

}
