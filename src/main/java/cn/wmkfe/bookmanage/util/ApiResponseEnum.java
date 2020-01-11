package cn.wmkfe.bookmanage.util;

public enum ApiResponseEnum {
	
	SUCCESS("0", "成功"),
	ERROR_PARAM("-2", "参数错误"),
	ERROR_DATA_EMPTY("-3", "无数据"),
	LOGIN_ERR("-4", "用户名或密码错误！"),
	FAIL("-1", "失败");
	
	private String code;
	private String name;

	private ApiResponseEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getMsg(String code) {
		for (ApiResponseEnum responseEnum : ApiResponseEnum.values()) {
			if (responseEnum.getCode().equals(code)) {
				return responseEnum.getName();
			}
		}
		return null;
	}
}
