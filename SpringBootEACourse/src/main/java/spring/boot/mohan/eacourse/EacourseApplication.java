package spring.boot.mohan.eacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages="spring.boot.mohan.eacourse")
@EnableJms
//@EnableScheduling
public class EacourseApplication {

	public static void main(String[] args) {
            
            System.out.println("START >>>>>>>>>>>>>>>>>>>>>>  ");
            
		SpringApplication.run(EacourseApplication.class, args);
            
            System.out.println("END   >>>>>>>>>>>>>>>>>>>>>>   ");
            
	}        
        @Bean 
        public MessageConverter jacksonJmsMessageConverter(){
            MappingJackson2MessageConverter converter=new MappingJackson2MessageConverter();
            converter.setTargetType(MessageType.TEXT);
            converter.setTypeIdPropertyName("myArjun");
            return converter;           
        }
}
