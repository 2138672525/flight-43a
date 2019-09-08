package com.haina.flight;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UtilTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> l2 = Lists.newArrayList();
        List<String> l3 = Lists.newLinkedList();

        //lpush list aa
        list.add("aa");

        //接口只能继承(extends)接口
        //接口不可以实现(implements)接口
        System.out.println(CollectionUtils.isEmpty(list));

        Map<String, String> map = Maps.newHashMap();
        //hset map43b k1 v1
        map.put("abc", "123");

        String str = " ";
        System.out.println(StringUtils.isBlank(str));
        //a-b-c-d-e
        String a = "a";
        String b = "b";
        String c = null;
        String d = "d";
        String e = "e";
        String tmp = "-";
        //System.out.println(a + tmp + b+tmp);
        System.out.println(Joiner.on(tmp).skipNulls().join(a,b,c,d,e));

        String abc = "asdf_deft_zxcv";
        String[] arr = abc.split("_");
        for(String cc : arr){
            System.out.println(cc);
        }

        Iterable<String> split = Splitter.on("_").split(abc);
        for(String cc : split){
            System.out.println(cc);
        }
    }
}









