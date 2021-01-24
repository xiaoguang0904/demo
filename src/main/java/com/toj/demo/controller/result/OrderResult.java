package com.toj.demo.controller.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author TOJ ZHANG
 * @version 1.0
 * @date 2021/1/23
 **/
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class OrderResult {
    // 結果フラグ(SUCCESS:成功/FAILED：失敗)
    private String result;
    // オーダーID
    private String id;
    // オーダー叙述
    private String desc;
}
