package com.ncamc.demoreactor.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/*
* 响应式编程Reactor实现
* 响应式编程操作中,Reactor是满足Reactive规范框架的
* Reactor有两个核心类,Mono和Flux,这两个类实现接口Publisher,提供丰富操作符.
* Flux对象实现发布者,返回N个元素,Mono实现发布者,返回0个或者1个元素
*
* Flux和Mono都是数据流的发布者,使用Mono和Flux都可以发出三种数据信号:
* 元素值,错误信号,完成信号.
* 错误信号和完成信号都代表终止信号,终止信号用于告诉订阅者数据流结束了,错误信号终止数据流同时把错误信息传递给订阅者
*
* 三种信号:
*
* 错误信号和完成信号都是终止信号,不能共存
* 如果没有发送任何元素值,而是直接发送错误或者完成信号,则表示是空数据流
* 如果没有错误信号,没有完成信号,表示是无限数据流
*
* 调用just或者其他的方法只是声明数据流,数据流并没有发出,只有进行了订阅之后才会触发数据流,不订阅是什么都不会发生的
*
* 操作符:
* 对数据流进行一道道的操作,称之为操作符,比如工厂流水线
* map把元素映射为新的元素{1,2,3,...} -> {1,4,9,...}
*
* flatmap元素映射为流{a,b,c;x,y,z;...} -> {abc,xyz,...}
* 把每个元素转换成流,把转换之后的多个流合并成一个流,再做输出
*
* */
public class TestReactor {
    public static void main(String[] args) {
        //just方法可以直接声明
        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);

        //其他方法
        Integer[] array = {1,2,3,4};
        Flux.fromArray(array);

        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);

        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);

    }
}
