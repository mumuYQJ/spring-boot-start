package com.csdj.springbootsecurity.healthIndicator;

import com.csdj.springbootsecurity.component.MyHahaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyHahaHealthIndicator extends AbstractHealthIndicator {
    //implements HealthIndicator

    @Autowired
    private MyHahaComponent myHahaComponent;

//    @Override
//    public Health health() {
//        String check = myHahaComponent.check();
//        if (check.equals("1")) {
//            return Health.status(Status.UP)
//                    .withDetail("Code","200")
//                    .withDetail("msg","健康状态良好")
//                    .build();
//        }
//        return Health.status(Status.DOWN)
//                .withDetail("Code","500")
//                .withDetail("msg","已死亡")
//                .build();
//    }


    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("Code","500");
        objectMap.put("msg","死亡");
        objectMap.put("a","a");

        String check = myHahaComponent.check();
        if (check.equals("1")) {
            builder.status(Status.UP)
                    .withDetail("Code","200")
                    .build();
        } else {
            builder.status(Status.DOWN)
                    .withDetails(objectMap)
                    .build();
        }
    }
}
