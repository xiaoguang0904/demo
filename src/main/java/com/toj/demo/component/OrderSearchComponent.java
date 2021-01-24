package com.toj.demo.component;

import com.toj.demo.dao.OrderDao;
import com.toj.demo.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *　オーダー検索コンポーネント
 * @version 1.0
 * @author TOJ ZHANG
 * @date 2021/1/23
 */
@Component
@RequiredArgsConstructor
public class OrderSearchComponent {
    private final OrderDao orderDao;

    /**
     * DBからオーダーエンティティを取得
     * @param id　オーダー番号
     * @return オーダー情報
     */
    public Order selectOrders(Integer id) {
        return orderDao.selectByPrimaryKey(id);
    }

}
