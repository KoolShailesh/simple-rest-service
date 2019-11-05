package com.shailesh.pojo;

public enum WeekDay {

	SUNDAY(0),MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6);

	private WeekDay(int day) {
		this.day = day;

	}

	private int day;

	public int getDay() {
		return day;
	}
}
