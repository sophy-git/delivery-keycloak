package com.example.delivery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@Controller
public class DeliveryController {

    @ResponseBody
    @GetMapping("/delivery")
    public DeferredResult<String> checkStock() {
        DeferredResult<String> deferredResult = new DeferredResult<>();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10_000);
                deferredResult.setResult("배송 끝났습니다.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                deferredResult.setErrorResult("배송 중 오류가 발생했습니다.");
            }
        });

        return deferredResult;
    }

}
