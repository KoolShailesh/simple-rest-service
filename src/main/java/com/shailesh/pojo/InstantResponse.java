package com.shailesh.pojo;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class InstantResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3245396460005774338L;

	@JsonProperty("mymessage")
	private String myMessage;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "UTC")
	@JsonProperty("instant")
	private Instant instant;

}
