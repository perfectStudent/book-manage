package cn.wmkfe.bookmanage.config;

import cn.wmkfe.bookmanage.handler.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter(){
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                super.addInterceptors(registry);
                registry.addInterceptor(new MyHandler())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/login.html","/checkLogin");
            }
        };
        return adapter;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
