package com.toj.demo.component;

import com.toj.demo.dao.TojOrderDao;
import com.toj.demo.entity.TojOrder;
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
public class OrderComponent {
    private final TojOrderDao tojOrderDao;

    /**
     * DBからオーダーエンティティを取得
     * @param id　オーダー番号
     * @return オーダー情報
     */
    public TojOrder selectOrder(Integer id) {
        return tojOrderDao.selectByPrimaryKey(id);
    }

    /**
     * DBからオーダーエンティティを追加
     * @param tojOrder　オーダー情報
     * @return 変更数
     */
    public int addOrder(TojOrder tojOrder) {
        return tojOrderDao.insert(tojOrder);
    }


    /**
     * オーダーエンティティを削除
     * @param id　オーダー番号
     * @return オーダー情報
     */
    public int deleteOrder(Integer id) {
        return tojOrderDao.deleteByPrimaryKey(id);
    }


    /**
     * オーダーエンティティを更新
     * @param tojOrder　オーダー
     * @return 更新レコード
     */
    public int updateOrder(TojOrder tojOrder) {
        return tojOrderDao.updateByPrimaryKey(tojOrder);
    }

}
