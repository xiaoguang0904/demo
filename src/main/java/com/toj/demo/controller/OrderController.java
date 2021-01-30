package com.toj.demo.controller;

import com.toj.demo.controller.result.OrderResult;
import com.toj.demo.entity.TojOrder;
import com.toj.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
public class OrderController {
    private final OrderService service;

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
            TojOrder order = service.searchOrder(id);
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
     * オーダー作成
     * @param tojOrder オーダ情報
     * @return 結果
     */
    @RequestMapping(value="/add",method = { GET, POST })
    public OrderResult add(@RequestBody TojOrder tojOrder){
        // 検索結果を新規
        OrderResult result = new OrderResult();

        try {
            // オーダ情報を追加
            service.addOrder(tojOrder);
            // 成功の場合
            result.setResult("SUCCESS");
        } catch(Exception e) {
            // 異常発生の場合
            result.setResult("FAILED");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * オーダー更新
     * @param tojOrder オーダ情報
     * @return 結果
     */
    @RequestMapping(value="/update",method = { GET, POST })
    public OrderResult update(@RequestBody TojOrder tojOrder){
        // 検索結果を更新
        OrderResult result = new OrderResult();

        try {
            // オーダ情報を追加
            service.updateOrder(tojOrder);
            // 成功の場合
            result.setResult("SUCCESS");
        } catch(Exception e) {
            // 異常発生の場合
            result.setResult("FAILED");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * オーダー削除
     * @param id オーダ情報番号
     * @return 結果
     */
    @RequestMapping(value="/delete",method = { GET, POST })
    public OrderResult delete(@RequestParam(value="id",required = true) Integer id){
        // 検索結果を新規
        OrderResult result = new OrderResult();

        try {
            // オーダ情報を削除
            service.deleteOrder(id);
            // 成功の場合
            result.setResult("SUCCESS");
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
    private OrderResult convertOrderResult(TojOrder order,OrderResult result){
        result.setId(String.valueOf(order.getOrderNo()));
        result.setDesc(order.getOrderDesc());
        result.setResult("SUCCESS");

        return result;
    }
}
