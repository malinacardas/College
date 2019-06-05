package ro.ubb.catalog;

import ro.ubb.catalog.domain.Student;
import ro.ubb.catalog.domain.validators.StudentValidator;
import ro.ubb.catalog.domain.validators.Validator;
import ro.ubb.catalog.repository.Repository;
import ro.ubb.catalog.repository.StudentFileRepository;
import ro.ubb.catalog.service.StudentService;
import ro.ubb.catalog.ui.Console;


/**
 * Created by radu.
 * <p>
 * <p>
 * Catalog App
 * </p>
 * <p>
 * <p>
 * I1:
 * </p>
 * <ul>
 * <li>F1: add student</li>
 * <li>F2: print all students</li>
 * <li>in memory repo</li>
 * </ul>
 * <p>
 * <p>
 * I2:
 * </p>
 * <ul>
 * <li>in file repo</li>
 * <li>F3: print students whose name contain a given string</li>
 * </ul>
 */

public class Main {
    public static void main(String args[]) {
        //in-memory repo
//         Validator<Student> studentValidator = new StudentValidator();
//         Repository<Long, Student> studentRepository = new InMemoryRepository<>(studentValidator);
//         StudentService studentService = new StudentService(studentRepository);
//         Console console = new Console(studentService);
//         console.runConsole();

        //file repo
//        try {
//            System.out.println(new File(".").getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //in file repo
        Validator<Student> studentValidator = new StudentValidator();
        Repository<Long, Student> studentRepository = new StudentFileRepository(studentValidator, "./data/students");
        StudentService studentService = new StudentService(studentRepository);
        Console console = new Console(studentService);
        console.runConsole();



        System.out.println("Hello World!");
    }
}
out/production/classes/repository/ProblemRepository.class
out/production/classes/repository/InMemoryRepository.class
out/production/classes/domain/Student.class
out/production/classes/domain/BaseEntity.class
out/production/classes/Main.class
.idea/workspace.xml
src/main/java/ui/Console.java
src/main/java/service/StudentService.java
src/main/java/repository/ProblemRepository.java
out/production/classes/repository/ProblemFileRepository.class
out/production/classes/domain/validators/RepositoryException.class
out/production/classes/domain/validators/FileRepositoryException.class
src/main/java/repository/InMemoryRepository.java
src/main/java/problems.txt
src/main/java/domain/validators/RepositoryException.java
src/main/java/domain/validators/FileRepositoryException.java
src/main/java/domain/files/studentsFile
src/main/java/domain/files/inputFile
out/production/classes/repository/StudentFileRepository.class
src/main/java/domain/Student.java
src/main/java/domain/BaseEntity.java
src/main/java/Main.java
out/production/classes/ui/Console.class
src/main/java/students.txt
src/main/java/repository/StudentFileRepository.java
src/main/java/repository/ProblemFileRepository.java
out/production/classes/service/StudentService.class
