package eu.deltasource.kat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KatApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(KatApplication.class, args);

//        for (String bean : applicationContext.getBeanDefinitionNames()) {
//            System.out.println("----------------");
//            System.out.println(bean);
//        }
    }

}
