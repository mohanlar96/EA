package exam3.exam;

import exam3.exam.entities.*;
import exam3.exam.service.AuthorService;
import exam3.exam.service.ReceiptService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class ExamApplication {

	public static void main(String[] args) {
            
            System.out.println("START >>>>>>>>>>>>>>>");
		
                ConfigurableApplicationContext context=SpringApplication.run(ExamApplication.class, args);
                
                
                System.out.println("NO1");                
                Author a1=new Author();
                a1.setName("Mohan");
                a1.setExperience(4);
                
                Book b=new Book();
                b.setTitle("Java Hello world");
                b.setNumberOfPages(100);
                List<Book> bookLists=new ArrayList<Book>();
                bookLists.add(b);
                a1.setBooks(bookLists);
                Address iowa=new Address();
                iowa.setCity("Fairfield");
                iowa.setState("Iowa");
                a1.setAddress(iowa);
                
                context.getBean(AuthorService.class).addAuthor(a1);
                
                System.out.println("An Author Have been save");
                
                System.out.println("Receive is created current time");
                Receipt receipt= new Receipt();
                receipt.setId(1l);
                receipt.setDate(new Date());
                receipt.setAmount(10.00);
                context.getBean(ReceiptService.class).createReceipt(receipt);
              
                
            System.out.println("END >>>>>>");
	}
        
        @Bean 
        public MessageConverter jacksonJmsMessageConverter(){
            MappingJackson2MessageConverter converter=new MappingJackson2MessageConverter();
            converter.setTargetType(MessageType.TEXT);
            converter.setTypeIdPropertyName("exam3");
            return converter;           
        }

}
