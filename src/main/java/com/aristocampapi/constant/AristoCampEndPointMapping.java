package com.aristocampapi.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
@Component
public class AristoCampEndPointMapping {
	
	@Value("${mrc_base_path}")
	public String mrcBasePath;
	
	

}
