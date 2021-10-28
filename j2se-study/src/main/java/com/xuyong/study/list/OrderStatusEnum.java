package com.xuyong.study.list;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by nancy on 18/6/19.
 */
public enum OrderStatusEnum {
    CREATED(0, "订单生成" , 1),
    PUSHED(1, "推送apollo成功(待配送)", 2),
    ASSIGN(20, "分配骑手", 3),
    ARRIVE(80, "骑手到店", 4),
    DELIVERING(2, "配送中", 5),
    DELIVERED(3, "已送达", 6),
    CANCELLED(4, "商户取消订单", 7),
    ABNORMAL(5, "配送异常", 8),
    PUSH_FAILED(6, "第三方平台推单失败", 9);

    private Integer status;
    private String desc;
    private Integer sort;

    OrderStatusEnum(Integer status, String desc, Integer sort) {
        this.status = status;
        this.desc = desc;
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getSort() {
        return sort;
    }

    public static OrderStatusEnum getByStatus(Integer status) {
        return Arrays.stream(values()).filter(s -> Objects.equals(s.getStatus(), status)).findAny().orElse(null);
    }
}
