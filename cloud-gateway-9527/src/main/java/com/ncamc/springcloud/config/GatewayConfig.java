package com.ncamc.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    /*
    * 配置一个ID为: path_route_ncamc的路由规则
    * 当访问地址http://localhost:9527/guonei 时会自动转发到地址 http://news.baidu.com/guonei
    * 在这里写代码，功能等同于在yml文件里写配置
    * */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route_ncamc",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                        .build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route_ncamc",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();
    }
}
