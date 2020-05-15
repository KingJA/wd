package com.kingja.wd.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:g:/wd/");
//		http://localhost:8080/upload/1a26a5664bb44ec79af008827cac3949/face/wxac52c4041a066f3d
// .o6zAJs7DHD-qFv7NH73XhNPxQguo.yb9nbdyt3CX5b00770ba6c84e2e34bc180f611e8cc94.jpg
//		registry.addResourceHandler("/upload/**").addResourceLocations("file:g:/wd");
//		http://localhost:8080/upload/wd/1a26a5664bb44ec79af008827cac3949/face/wxac52c4041a066f3d
// .o6zAJs7DHD-qFv7NH73XhNPxQguo.yb9nbdyt3CX5b00770ba6c84e2e34bc180f611e8cc94.jpg

    }


//	@Autowired
//	AccessInterceptor accessInterceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(accessInterceptor);
//	}
//
//
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**");
//			}
//		};
//	}
}
