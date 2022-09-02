package cl.mayne.productos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.fasterxml.jackson.annotation.JsonInclude;


@SpringBootApplication
public class Application {

    // silence console logging
//    @Value("${logging.level.root:OFF}")
//    String message = "";

    /*
     * Create required HandlerMapping, to avoid several default HandlerMapping instances being created
     */
    @Bean
    public HandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    /*
     * Create required HandlerAdapter, to avoid several default HandlerAdapter instances being created
     */
    @Bean
    public HandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }
    
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    	List<MediaType> supportedMediaTypes = new ArrayList<>();
    	supportedMediaTypes.add(MediaType.APPLICATION_JSON);

    	Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    	builder.serializationInclusion(JsonInclude.Include.NON_NULL);

    	MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter(builder.build());
    	jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
    	return jsonConverter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}