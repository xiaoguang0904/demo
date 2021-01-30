package com.toj.demo.dao;

import com.toj.demo.entity.TojOrder;

/**
 * @Entity com.toj.demo.entity.TojOrder
 */
public interface TojOrderDao {
    /**
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer orderNo);

    /**
     * @mbg.generated
     */
    int insert(TojOrder record);

    /**
     * @mbg.generated
     */
    int insertSelective(TojOrder record);

    /**
     * @mbg.generated
     */
    TojOrder selectByPrimaryKey(Integer orderNo);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TojOrder record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(TojOrder record);
}