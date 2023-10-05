package cn.bugstack.chatgpt.data.infrastructure.dao;

import cn.bugstack.chatgpt.data.domain.order.model.entity.OrderEntity;
import cn.bugstack.chatgpt.data.infrastructure.po.OpenAIOrderPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 订单Dao
 * @create 2023-10-05 13:27
 */
@Mapper
public interface IOpenAIOrderDao {

    OpenAIOrderPO queryUnpaidOrder(OpenAIOrderPO openAIOrderPOReq);

    void insert(OpenAIOrderPO order);

    void updateOrderPayInfo(OpenAIOrderPO openAIOrderPO);

    int changeOrderPaySuccess(OpenAIOrderPO openAIOrderPO);

    OpenAIOrderPO queryOrder(String orderId);

    int updateOrderStatusDeliverGoods(String orderId);

}
