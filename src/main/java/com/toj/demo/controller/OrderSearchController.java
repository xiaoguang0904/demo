package com.toj.demo.controller;

import com.toj.demo.controller.result.OrderResult;
import com.toj.demo.entity.Order;
import com.toj.demo.service.OrderSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * オーダー検索コントローラー
 * @version 1.0
 * @author TOJ ZHANG
 * @date 2021/1/23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderSearchController {
    private final OrderSearchService service;

    /**
     * オーダー検索処理
     * @param id オーダーID
     * @return 検索結果
     */
    @RequestMapping(value="/search",method = { GET, POST })
    public OrderResult search(@RequestParam(value="id",required = true) Integer id){
        // 検索結果を新規
        OrderResult result = new OrderResult();

        try {
            // 検索処理を行う
            Order order = service.searchOrder(id);
            // オーダーエンティティを検索結果へ変換
            convertOrderResult(order,result);
        } catch(Exception e) {
            // 異常発生の場合
            result.setResult("FAILED");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * オーダーエンティティを検索結果へ変換
     * @param order DBから取得したオーダー情報
     * @param result 検索結果
     * @return 検索結果
     */
    private OrderResult convertOrderResult(Order order,OrderResult result){
        result.setId(String.valueOf(order.getOrderNo()));
        result.setDesc(order.getOrderDesc());
        result.setResult("SUCCESS");

        return result;
    }
}
