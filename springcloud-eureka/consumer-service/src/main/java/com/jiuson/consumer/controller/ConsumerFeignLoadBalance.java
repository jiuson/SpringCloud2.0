package com.jiuson.consumer.controller;

import com.jiuson.consumer.feign.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/loadBalance")
public class ConsumerFeignLoadBalance {

    @Autowired
    private ProviderFeignClient providerFeignClient;

    /**
     * 测试@FeignClient(value = "provider-service", configuration = FeignConfiguration.class)能不能实现负载均衡
     * 为客户端指定configuration，而不是使用默认的
     * 答案是可以，FeignClient的负载均衡是默认自带的，不受自定义的configuration影响
     * @return
     */
    @GetMapping("/getProvider")
    public String getProvider(){
        return "this provider service port is:" + providerFeignClient.getProvideServicePort();
    }
}
