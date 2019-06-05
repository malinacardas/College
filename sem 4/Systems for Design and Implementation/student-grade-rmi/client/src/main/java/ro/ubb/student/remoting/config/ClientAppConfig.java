package ro.ubb.student.remoting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.ubb.student.remoting.service.ProblemService;
import ro.ubb.student.remoting.service.ProblemServiceImplementation;
import ro.ubb.student.remoting.ui.Console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ClientAppConfig {

    @Bean
    ProblemServiceImplementation problemServiceImplementation(){
        return new ProblemServiceImplementation();
    }

    @Bean
    Console console(){
        return new Console();
    }

    @Bean
    RmiProxyFactoryBean rmiProblemProxyFactoryBean(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(ProblemService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/ProblemService");
        return rmiProxyFactoryBean;
    }

    @Bean
    ExecutorService executorService(){
        return Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
    }


}
