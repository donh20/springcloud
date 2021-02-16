package com.ncamc.springcloud.service.impl;

import com.ncamc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问，肯定ok
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " PaymenyInfo_OK,id: " + id + "\t " + "O(∩_∩)O哈哈~";
    }
    /**
     * paymentInfo_TimeOut 方法不可用或者异常了;去执行 paymentInfo_TimeOutHandler
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5000;
        //int timeNumber = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " PaymenyInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~" + " 耗时" + timeNumber + "毫秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 8001系统繁忙系统报错 paymentInfo_TimeOutHandler,请稍后再试id: " + id + "\t " + "o(╥﹏╥)o";

    }
}