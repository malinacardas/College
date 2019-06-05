package ro.ubb.student.remoting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ro.ubb.student.remoting.domain.Problem;
import ro.ubb.student.remoting.domain.validators.ProblemValidator;
import ro.ubb.student.remoting.domain.validators.StudentValidator;
import ro.ubb.student.remoting.domain.validators.Validator;
import ro.ubb.student.remoting.repository.PagingRepository;
import ro.ubb.student.remoting.repository.impl.PagingProblemRepository;
import ro.ubb.student.remoting.service.ProblemService;
import ro.ubb.student.remoting.service.ProblemServiceServerImplementation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ServerAppConfig {
    @Bean
    RmiServiceExporter rmiProblemServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("ProblemService");
        exporter.setServiceInterface(ProblemService.class);
        exporter.setService(problemService());
        return exporter;
    }

    @Bean
    ProblemService problemService() {
        return new ProblemServiceServerImplementation(studentRepo(), executorService());

    }

    @Bean
    ExecutorService executorService() {
        return Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
    }

    @Bean
    PagingRepository<Long, Problem> studentRepo() {
        return new PagingProblemRepository(problemValidator());
    }

    @Bean
    Validator<Problem> problemValidator() {
        return new ProblemValidator();
    }

}
