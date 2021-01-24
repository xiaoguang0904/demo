package com.toj.demo.dao;

import com.toj.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.toj.demo.entity.Order
 */
@Mapper
public interface OrderDao {
    /**
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer orderNo);

    /**
     * @mbg.generated
     */
    int insert(Order record);

    /**
     * @mbg.generated
     */
    int insertSelective(Order record);

    /**
     * @mbg.generated
     */
    Order selectByPrimaryKey(Integer orderNo);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(Order record);
}