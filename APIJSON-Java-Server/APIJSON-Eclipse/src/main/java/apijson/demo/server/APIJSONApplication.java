/*Copyright ©2016 TommyLemon(https://github.com/TommyLemon/APIJSON)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package apijson.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import zuo.biao.apijson.server.Structure;

/**application
 * @author Lemon
 */
@SpringBootApplication
public class APIJSONApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(APIJSONApplication.class, args);

		try {
			Function.test();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Structure.init();
		
		try {
			Structure.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	//支持JavaScript跨域请求<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/** 
	 * 跨域过滤器 
	 * @return 
	 */  
	@Bean  
	public CorsFilter corsFilter() {  
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
		source.registerCorsConfiguration("/**", buildConfig()); // 4  
		return new CorsFilter(source);  
	}  
	/**CORS跨域配置
	 * @return
	 */
	private CorsConfiguration buildConfig() {  
		CorsConfiguration corsConfiguration = new CorsConfiguration();  
		corsConfiguration.addAllowedOrigin("*");  
		corsConfiguration.addAllowedHeader("*");  
		corsConfiguration.addAllowedMethod("*");  
		return corsConfiguration;  
	}  
	//支持JavaScript跨域请求 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}