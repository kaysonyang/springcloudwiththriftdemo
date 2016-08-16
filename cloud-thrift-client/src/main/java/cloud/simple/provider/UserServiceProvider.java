package cloud.simple.provider;

import cloud.simple.config.EurekaConfig;
import cloud.simple.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class UserServiceProvider {

	public UserService.Client getBalanceUserService(){
		Map<String, UserService.Client> serviceMap = EurekaConfig.serviceMap;
		//以负载均衡的方式获取服务实例
		for (Map.Entry<String, UserService.Client> entry : serviceMap.entrySet()) {
			System.out.println("可供选择服务:"+entry.getKey());
		}
		int rand=new Random().nextInt(serviceMap.size());
		String[] mkeys = serviceMap.keySet().toArray(new String[serviceMap.size()]);

		return serviceMap.get(mkeys[rand]);
	}
	

}
