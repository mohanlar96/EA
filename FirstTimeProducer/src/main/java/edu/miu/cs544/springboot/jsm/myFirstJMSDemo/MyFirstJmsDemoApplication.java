package edu.miu.cs544.springboot.jsm.myFirstJMSDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class MyFirstJmsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstJmsDemoApplication.class, args);
	}
        
        @Bean 
        public MessageConverter jacksonJmsMessageConverter(){
            MappingJackson2MessageConverter converter=new MappingJackson2MessageConverter();
            converter.setTargetType(MessageType.TEXT);
            converter.setTypeIdPropertyName("myArjun");
            return converter;           
        }

}
