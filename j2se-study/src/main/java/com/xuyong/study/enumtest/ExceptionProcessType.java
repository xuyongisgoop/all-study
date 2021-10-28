package com.xuyong.study.enumtest;

import java.util.Arrays;
import java.util.List;

public enum ExceptionProcessType {
    PROCESS_FEEDBACK_CUSTOMER_UNACCESSIBLE() {
        {
            super.categoryType = "FEEDBACK";
            super.deliveryCheckCount = 8;
            super.orderCheckCount = 5;
            super.displayOrderStatus = Arrays.asList(1, 2, 3);
            super.displayOrderType = 1;
        }
    },
    PROCESS_FEEDBACK_CUSTOMER_ADDRESS_CHANGE() {
        {
            super.categoryType = "FEEDBACK";
            super.deliveryCheckCount = 8;
            super.orderCheckCount = -1;
            super.displayOrderStatus = Arrays.asList(1, 2, 3);
            super.displayOrderType = 1;
        }
    },
    PROCESS_CANCELED_GOODS_OVERWEIGHT() {
        {
            super.categoryType = "FEEDBACK";
            super.deliveryCheckCount = 8;
            super.orderCheckCount = -1;
            super.displayOrderStatus = Arrays.asList(1, 2, 3);
            super.displayOrderType = 1;
        }
    };

    //前置处理
    protected String categoryType;
    protected String code;
    protected String codeName;
    protected String codeId;
    protected Integer initStatus;
    protected Integer deliveryCheckCount;
    protected Integer orderCheckCount;
    protected List<Integer> displayOrderStatus;
    protected Integer displayOrderType;

    //后置处理
    protected Boolean ifSendWoos;
    protected Boolean ifSendHermes;

    public String getCategoryType() {
        return categoryType;
    }

    public Integer getDeliveryCheckCount() {
        return deliveryCheckCount;
    }

    public Integer getOrderCheckCount() {
        return orderCheckCount;
    }

    public List<Integer> getDisplayOrderStatus() {
        return displayOrderStatus;
    }

    public Integer getDisplayOrderType() {
        return displayOrderType;
    }

    public Boolean getIfSendWoos() {
        return ifSendWoos;
    }

    public Boolean getIfSendHermes() {
        return ifSendHermes;
    }

    public Integer getInitStatus() {
        return initStatus;
    }
}
