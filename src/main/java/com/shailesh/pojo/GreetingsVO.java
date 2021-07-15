package com.shailesh.pojo;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class GreetingsVO {
	
	@DecimalMin(value = "${spring.myapp.mybigdecimal}")
	private BigDecimal money;
	
	@NotNull
	private String item;

}
