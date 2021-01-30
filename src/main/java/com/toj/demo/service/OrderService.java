package com.toj.demo.service;

import com.toj.demo.component.OrderComponent;
import com.toj.demo.entity.TojOrder;
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
public class OrderService {
    private final OrderComponent component;

    /**
     * オーダー検索
     * @param id　オーダー番号
     * @return オーダー情報
     */
    public TojOrder searchOrder(Integer id){
        return component.selectOrder(id);
    }

    /**
     * オーダー作成
     * @param tojOrder オーダ情報
     * @return オーダー情報
     */
    public int addOrder(TojOrder tojOrder){
        return component.addOrder(tojOrder);
    }

    /**
     * オーダー削除
     * @param id　オーダー番号
     * @return 更新数
     */
    public int deleteOrder(Integer id){
        return component.deleteOrder(id);
    }

    /**
     * オーダー更新
     * @param tojOrder　オーダー番号
     * @return 更新数
     */
    public int updateOrder(TojOrder tojOrder){
        return component.updateOrder(tojOrder);
    }
}
