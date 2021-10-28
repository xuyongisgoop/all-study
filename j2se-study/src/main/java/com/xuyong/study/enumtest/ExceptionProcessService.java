package com.xuyong.study.enumtest;

/**
 * Created by xuyong on 2019-07-03
 */
public abstract class ExceptionProcessService {

    public void createFeedback(String code, String deliveryId, Long orderId) {
        ExceptionProcessType exceptionProcessType = Enum.valueOf(ExceptionProcessType.class, code);
        preProcess(exceptionProcessType);
        create();
        postProcess(exceptionProcessType);
    }

    private void preProcess(ExceptionProcessType exceptionProcessType) {
        // step1 校验订单是否存在（需要涉及到调用订单信息查询接口--评估php还是java提供）

        // step2 校验骑手和订单是否匹配

        // step3 获取该骑手已经有的报备了的code

        // step4 获取该订单已经报备了的code

        // step5 校验骑手一天内该类型报备是否超过配置的最大次数 （异常报备除了用户联系不到其他都是8次、无责取消是5次，用户联系不到是5次）

        // step6 校验是否满足订单报备次数 （单个订单的报备次数正常无限制，只有商户出餐慢或投诉商户出餐慢不能超过3次）

        // step7 校验是否符合满足当前的状态

        // step8 特殊的校验逻辑
        specialValidate();
    }

    protected abstract void specialValidate();

    private void create() {
        // 对于商户出餐慢，根据时段+天气+背单数+客单价算出来的权重分，设置is_liability和liability_time

        // 对于商户出餐慢，拼装一些个性的入参data
    }

    // step1 校验是否需要发送woos
    // step2 校验是否需要发送hermes
    // step3 是否需要调用风控
    // step4 是否需要更新骑手T和出餐时长（需要涉及到调用更新订单信息的接口--评估php还是java提供）
    // step5 是否需要更新用户的地址（需要涉及到调用更新订单信息的接口--评估php还是java提供）
    // step6 是否需要更新redis
    protected abstract void postProcess(ExceptionProcessType exceptionProcessType);

    public void getFeedbackMenu() {
        // 获取异常处理大的目录结构

        // 获取所有的报备code枚举，根据各种条件拼装到对应的目录下
    }

}
