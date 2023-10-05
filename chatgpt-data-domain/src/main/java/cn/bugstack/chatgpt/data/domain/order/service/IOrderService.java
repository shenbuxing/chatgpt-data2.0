package cn.bugstack.chatgpt.data.domain.order.service;

import cn.bugstack.chatgpt.data.domain.order.model.aggregates.CreateOrderAggregate;
import cn.bugstack.chatgpt.data.domain.order.model.entity.PayOrderEntity;
import cn.bugstack.chatgpt.data.domain.order.model.entity.ShopCartEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 订单服务
 * 1. 用户下单 createOrder
 * @create 2023-10-05 10:49
 */
public interface IOrderService {

    /**
     * 用户下单，通过购物车信息，返回下单后的支付单
     *
     * @param shopCartEntity 简单购物车
     * @return 支付单实体对象
     */
    PayOrderEntity createOrder(ShopCartEntity shopCartEntity);

    /**
     * 变更；订单支付成功
     */
    boolean changeOrderPaySuccess(String orderId, String transactionId, BigDecimal totalAmount, Date payTime);

    /**
     * 查询订单信息
     *
     * @param orderId 订单ID
     * @return 查询结果
     */
    CreateOrderAggregate queryOrder(String orderId);

    /**
     * 订单商品发货
     *
     * @param orderId 订单ID
     */
    void deliverGoods(String orderId);

}