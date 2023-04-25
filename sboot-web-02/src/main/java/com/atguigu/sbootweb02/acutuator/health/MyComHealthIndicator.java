package com.atguigu.sbootweb02.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真是的检查方法
     *
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb。获取连接进行测试
        Map<String, Object> map = new HashMap<>();
        if (1 == 1) {
            builder.status(Status.UP);//健康
            map.put("count", 1);
            map.put("ms", 100);
        } else {
            builder.status(Status.DOWN);//不健康
            map.put("err","连接超时");
            map.put("ms",3000);
        }
        builder.withDetail("code",100);
    }
}
