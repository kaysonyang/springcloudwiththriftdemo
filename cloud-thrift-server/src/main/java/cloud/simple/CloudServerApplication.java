package cloud.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by 02 on 2016/8/9.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class CloudServerApplication{
    public static void main(String[] args) {
        SpringApplication.run(CloudServerApplication.class, args);
    }
}
