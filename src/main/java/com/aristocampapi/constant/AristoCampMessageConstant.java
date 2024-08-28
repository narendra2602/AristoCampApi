package com.aristocampapi.constant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
  
@Component 
@PropertySource("classpath:aristocamp-msg.properties")
public class AristoCampMessageConstant {
	
	@Value("${upload_message}")
	public String message;

	@Value("${chart_target_color}")
	public String target;
	
	@Value("${chart_sale_color}")
	public String sale;
	
	@Value("${chart_lys_color}")
	public String lys;

	
	@Value("#{${division}}")
	public Map<String, String> divisionMap;

}
