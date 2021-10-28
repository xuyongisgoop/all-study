package com.xuyong.study.string;

public enum PTAppOrderPushMessageEnum {

    /**
     *已接单
     */
    MSG_TYPE_ORDER_RECEIVE(1,"【蜂鸟跑腿】订单状态更新", "您的订单（{goods_source_name}#{order_sn}）已被接单，请及时查看！", "pt_pickup_message.m4a", false),

    /**
     * 已到店
     */
    MSG_TYPE_ORDER_REACH(2,"【蜂鸟跑腿】订单状态更新", "您的订单（{goods_source_name}#{order_sn}）骑手已到达，请及时查看！", "pt_pickup_message.m4a", false),

    /**
     * 已送达
     */
    MSG_TYPE_ORDER_FINISH(3,"【蜂鸟跑腿】订单状态更新", "您的订单（{goods_source_name}#{order_sn}））已完成！【快来参加充值送券～】", "pt_pickup_message.m4a", false),

    /**
     * 订单被系统取消
     */
    MSG_TYPE_ORDER_SYSTEM_CANCEL(4,"【蜂鸟跑腿】订单状态更新", "您的订单（{goods_source_name}#{order_sn}）已被取消，请及时查看！", "pt_pickup_message.m4a", false),

    /**
     * 已取餐
     */
    MSG_TYPE_ORDER_PICKUP(6,"【蜂鸟跑腿】订单状态更新", "您的订单（{goods_source_name}#{order_sn}）骑手已取餐并开始配送，请及时查看！", "pt_pickup_message.m4a", false),

    /**
     * 商户触发二次呼单
     */
    MSG_TYPE_ORDER_MERCHANT_PUSH_AGAIN(17,"【蜂鸟跑腿】订单状态更新", "{goods_source}{order_sn}，已为您优先调度，请耐心等待～", "pt_pickup_message.m4a", false),

    /**
     * apollo取消触发二次呼单
     */
    MSG_TYPE_ORDER_APOLLO_PUSH_AGAIN(18,"【蜂鸟跑腿】订单状态更新", "{goods_source}{order_sn}，您的订单被取消，正在为您重新分配骑手", "pt_pickup_message.m4a", false),
    ;

    /**
     * 消息类型
     */
    private Integer messageType;

    /**
     * 标题
     */
    private String title;

    /**
     * 文案
     */
    private String text;

    /**
     * 声音
     */
    private String sound;

    /**
     * 强制弹出？
     */
    private Boolean force;

    PTAppOrderPushMessageEnum(Integer messageType, String title, String text, String sound, Boolean force) {
        this.messageType = messageType;
        this.title = title;
        this.text = text;
        this.sound = sound;
        this.force = force;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Boolean getForce() {
        return force;
    }

    public void setForce(Boolean force) {
        this.force = force;
    }
}