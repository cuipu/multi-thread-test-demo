package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class TestDemoApplicationTests {

    @Value("#{'${test.list}'.split(',')}")
    private List<String> testList;

    @Value("#{${test.map1}}")
    private Map<String,String> map1;

    @Value("#{${test.map2}}")
    private Map<String,Integer> map2;


    @Test
    void contextLoads() {
        System.out.println(testList);
        System.out.println(map1);
        System.out.println(map2);

        //ThreadLocal
    }

}
