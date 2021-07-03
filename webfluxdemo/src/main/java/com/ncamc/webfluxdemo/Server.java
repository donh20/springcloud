package com.ncamc.webfluxdemo;

import com.ncamc.webfluxdemo.handler.UserHandler;
import com.ncamc.webfluxdemo.service.Impl.UserServiceImpl;
import com.ncamc.webfluxdemo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //创建路由
    public RouterFunction<ServerResponse> routingFunction() {
        //创建handler对象
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        //设置路由
        return RouterFunction.route(GET("/users/{id}").and(accept((MediaType) APPLICATION_JSON)),handler::getUserById)
                .andRoute(GET("/users").and(accept((MediaType) APPLICATION_JSON)),handler::getAllUsers));
        )
    }
    //创建服务器完成适配
    public void createReactorServer() {
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }
}
