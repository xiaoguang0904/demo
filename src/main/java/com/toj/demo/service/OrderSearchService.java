package com.toj.demo.service;

import com.toj.demo.component.OrderSearchComponent;
import com.toj.demo.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *　オーダー検索サービス
 * @version 1.0
 * @author TOJ ZHANG
 * @date 2021/1/23
 */
@Service
@RequiredArgsConstructor
public class OrderSearchService {
    private final OrderSearchComponent component;

    /**
     * オーダー検索
     * @param id　オーダー番号
     * @return オーダー情報
     */
    public Order searchOrder(Integer id){


        return component.selectOrders(id);
    }
}
