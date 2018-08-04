package com.example.serverclient.controller;

import com.example.serverclient.model.User;
import com.example.serverclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @Author:王泽龙
 * @Description:
 * @Date: 18-7-29 上午11:47
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/hello/{id}",method = RequestMethod.GET)
    public String index(@PathVariable("id") int id){
//        getLocalServiceInstance()方法不推荐使用，因此推荐下面这个方法
//        ServiceInstance instance = client.getLocalServiceInstance();
//        logger.info("/hello,host:"+instance.getHost()+", service_id:"+instance.getServiceId());
//        return "Hello World";
//        client.getServices().forEach(id -> {
//            client.getInstances(id).forEach(instance -> {
//                logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
//            });
//        });
        User user = userService.getUserById(id);
        return user.toString();
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String getAll(){
        List<User> list = userService.getAllUser();
        return list.toString();
    }
}