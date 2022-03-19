package com.sbszc.eduspringbootcloudconfigclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class EduSpringBootCloudConfigClientController {

	@Value("${my.value1:my.value1 not found}")
	public String myValue1;
	
	@Value("${my.value2:my.value2 not found}")
	public String myValue2;
	
	@Value("${my.value3:my.value3 not found}")
	public String myValue3;
	
	@Value("${my.value4:my.value4 not found}")
	public String myValue4;
	
	@GetMapping
	public List<String> myvalues() {
		return Arrays.asList(myValue1, myValue2, myValue3, myValue4);
	}
}
