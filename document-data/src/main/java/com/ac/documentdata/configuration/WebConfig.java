package com.ac.documentdata.configuration;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.plugins.ECSPlugin;

@Configuration
@EnableAutoConfiguration
public class WebConfig {
	
	@Bean
	public Filter TracingFilter() {
		return new AWSXRayServletFilter("doc-info-service");
	//	return new AWSXRayServletFilter(new DynamicSegmentNamingStrategy("doc-info-service", "*.example.com"));
	}

	static {
		AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard().withPlugin(new ECSPlugin());
		AWSXRay.setGlobalRecorder(builder.build());
		
	}
	
	

	

}

