package com.likai.admin.constant;

public enum LoginResultEnum {

	/**
	 * 登录成功
	 */
	SUCCESS("S99999"),

	/**
	 * 登录失败
	 */
	FAIL("F00001");

	private String value;

	public String getValue() {
		return value;
	}

	LoginResultEnum(String value) {
		this.value = value;
	}

}
