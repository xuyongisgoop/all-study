package com.xuyong.study.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum RedirectUrlTypeEnum {
    VOID_URL(0, "无效回调"),
    SHOP_URL(1, "门店回调"),
    ORDER_URL(2, "运单回调"),
    NOTIFY_URL(3, "异常报备"),
    ;


    private Integer code;
    private String desc;

    RedirectUrlTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    private static final Map<Integer, RedirectUrlTypeEnum> LOOKUP = new HashMap<>();

    static {
        for (RedirectUrlTypeEnum item : RedirectUrlTypeEnum.values()) {
            LOOKUP.put(item.getCode(), item);
        }
    }

    public static RedirectUrlTypeEnum getByCode(int code) {
        return Optional.ofNullable(LOOKUP.get(code)).orElse(null);
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
