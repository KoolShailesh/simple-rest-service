package com.shailesh.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class LocalDateResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3245396460005774338L;

	@JsonProperty("mymessage")
	private String myMessage;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = Shape.STRING)
	@JsonProperty("localdatetime")
	private LocalDateTime localDateTime;
	
	
	@JsonFormat(pattern = "dd-MM-yyyy",shape = Shape.STRING)
	@JsonProperty("localdate")
	private LocalDate localDate;

}
