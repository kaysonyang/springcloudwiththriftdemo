package cloud.simple.config;

import cloud.simple.interfaces.UserService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 02 on 2016/8/9.
 */
@Component
public class EurekaConfig {
    @Value("${service.name}")
    String serviceName;
    // thrift实例列表
    public static Map<String, UserService.Client> serviceMap = new HashMap<String, UserService.Client>();
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostConstruct
    private  void init(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        System.out.println(serviceInstance.getServiceId() + "@"
                + serviceInstance.getHost() + ":"
                + serviceInstance.getPort());
        List<String> currChilds =  discoveryClient.getServices();

        currChilds.stream().parallel().filter(instanceName -> instanceName.equals(serviceName))
                .filter(instanceName -> !serviceMap.containsKey(instanceName))
           .forEach(instanceName -> {serviceMap.put(instanceName, createUserService(instanceName));
                   System.out.println("instanceName: "+instanceName);
           });


    }

    // 创建一个服务实例
    private UserService.Client createUserService(String serviceInstanceName) {
        EurekaDiscoveryClient.EurekaServiceInstance serviceInstance =  (EurekaDiscoveryClient.EurekaServiceInstance)discoveryClient.getInstances(serviceInstanceName).get(0);

        //String ip = serviceInstanceName.split("-")[1];
        String ip = serviceInstance.getInstanceInfo().getIPAddr();
        TSocket transport = new TSocket(ip, 7911);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        return new UserService.Client(new TBinaryProtocol(transport));
    }
}
