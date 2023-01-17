package com.sbszc.eduspringbootcloudconfigclient.valueexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Example to test value injection in different manners
 */
@RestController
public class ValueExampleController {
    //use ${} to look for a property. optionally, you can specify a default value in case the property is not found
    @Value("${nonexistentValue:default value}")
    private String defaultValue;

    //all values are string by default
    //but if you specify a type, it'll try to convert string to the right type
    @Value("foo")
    private String stringValue;

    @Value("2.5")
    private Double doubleValue;

    @Value("true")
    private Boolean booleanValue;

    @Value("Ω")
    private Character charValue;

    //if you specify an array or list type, it'll try to convert string to the right type
    @Value("foo, 0.0, false")
    private String[] array;

    @Value("${list:x, x, x}")
    private List<String> list;

    @Value("0.6, 1.0, 0")
    private List<Double> listOfDoubles;

    //for maps, you have to use Spring Expression Language (Spel)
    @Value("#{${map:{var1:0.0, var2:'x'}}}")
    private Map<String, Object> map;

    @Value("#{{var1:0.6, var2:1.7}}")
    private Map<String, Double> mapOfDoubles;

    //you can group properties within a beam
    @Autowired
    private DbProperties dbProperties;

    //you shouldn't use it, but environment object gives you more control in certain cases
    @Autowired
    private Environment environment;

    @GetMapping("value-example")
    public List values() {
        return Arrays.asList(
                defaultValue,
                stringValue,
                doubleValue,
                booleanValue,
                charValue,
                array,
                list,
                listOfDoubles,
                map,
                mapOfDoubles,
                dbProperties,
                environment.getProperty("nonexistentValue", "default value"),
                environment.getActiveProfiles(),
                environment.toString()
        );
    }
}
