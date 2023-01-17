package com.sbszc.eduspringbootcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Example to test the overriding properties by layers:
 * cli arguments ->
 * external file ->
 * config service profiles in order ->
 * config service default profile ->
 * profiles in order ->
 * default profile
 */
@RestController
@RefreshScope
public class OverrideExampleController {

    @Value("${my.value1:my.value1 not found}")
    public String myValue1;

    @Value("${my.value2:my.value2 not found}")
    public String myValue2;

    @Value("${my.value3:my.value3 not found}")
    public String myValue3;

    @Value("${my.value4:my.value4 not found}")
    public String myValue4;

    @Value("${my.value5:my.value5 not found}")
    public String myValue5;

    @Value("${my.value6:my.value6 not found}")
    public String myValue6;

    @Value("${my.value7:my.value7 not found}")
    public String myValue7;

    @Value("${my.value8:my.value8 not found}")
    public String myValue8;

    @GetMapping("override-example")
    public Map<String, String> values() {
        var map = new LinkedHashMap<String, String>();
        map.put("myValue1", myValue1);
        map.put("myValue2", myValue2);
        map.put("myValue3", myValue3);
        map.put("myValue4", myValue4);
        map.put("myValue5", myValue5);
        map.put("myValue6", myValue6);
        map.put("myValue7", myValue7);
        map.put("myValue8", myValue8);
        return map;
    }
}
