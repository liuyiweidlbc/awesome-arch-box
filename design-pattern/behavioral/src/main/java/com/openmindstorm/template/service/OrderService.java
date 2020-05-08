package com.openmindstorm.template.service;

public abstract class OrderService {

    /**
     * 模板不可修改
     */
    public final void createOrder(){
        checkOrder();
        processCreate();
        asyncNotify();
    }

    /**
     * 校验是否用户已下过相似的订单
     */
    protected abstract void checkOrder();

    /**
     * 各自定制的下单处理过程
     */
    protected abstract void processCreate();

    /**
     * 系统异步通知处理
     */
    protected abstract void asyncNotify();

}
