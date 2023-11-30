package org.zerock.ex04.javatest;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public class JavaTests {

    @Test
    public void mapTest1(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i+10);
        }
        System.out.println(list);
    }

    @Test
    public void mapTest2(){
        List<Integer> list = IntStream.rangeClosed(0,9).mapToObj(i -> i+10).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void javaMapTest1(){
        Map<String,String> map = new HashMap<>();
        map.put("lastname","hong");
        map.put("firstname","gildong");
        log.info(map.get("lastname")); //hong
        map.forEach((k,v) -> {
            log.info(k);
            log.info(v);
        });
        for(Map.Entry<String,String> data : map.entrySet()){
            log.info(data.getKey());
            log.info(data.getValue());
        }


    }

}
