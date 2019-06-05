package ro.ubb.student.remoting;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.student.remoting.ui.Console;

public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.student.remoting.config"
                );
        Console console = context.getBean(Console.class);
        console.runConsole();
    }
}
