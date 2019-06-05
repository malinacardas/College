package ro.ubb.student.remoting.ui;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.student.remoting.ServiceException;
import ro.ubb.student.remoting.domain.Problem;
import ro.ubb.student.remoting.domain.validators.ValidatorException;
import ro.ubb.student.remoting.service.ProblemServiceImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

public class Console{
    @Autowired
    private ProblemServiceImplementation problemService;

    @Autowired
    private ExecutorService executorService;

    public Console(){

    }

    public void printAllProblems(){
        CompletableFuture<List<Problem>> problems= CompletableFuture.supplyAsync(()->problemService.getAllProblems(),executorService);
        problems.thenAccept(m->m.forEach(System.out::println));

    }

    private static void printMainMenu() {
        String menu = ""
                + "1. Add\n"
                + "2. Delete\n"
                + "3. Update\n"
                + "4. Filter\n"
                + "5. Show\n"
                + "6. Reports\n"
                + "0. Exit\n"
                + "Please enter your option: \n";

        System.out.println(menu);
    }

    private static void printAddMenu() {
        String menu = ""
                + "1. Add a new problem\n"
                + "Please enter your option: \n";
        System.out.println(menu);
    }

    @SuppressWarnings("Duplicates")
    private void addMenu() {
        printAddMenu();
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            String option = null;
            try {
                option = bufferRead.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Optional<String> opt = Optional.ofNullable(option);

            opt.filter(o -> o.equals("1")).ifPresent(o -> {
                Problem problem = readProblem();
                Optional<Problem> m = Optional.ofNullable(problem);
                m.ifPresent(mov -> CompletableFuture.supplyAsync(() -> this.problemService.addProblem(mov), executorService).thenRun(() -> {
                }));
            });
        } catch (ValidatorException ex) {
            System.out.println(ex.toString());
        }
    }


    private static void printDeleteMenu() {
        String menu = ""
                + "1. Delete a problem\n"
                + "2. Delete a student\n"
                + "Please enter your option: \n";
        System.out.println(menu);

    }

    private void deleteMenu() {
        printDeleteMenu();
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            String option = bufferRead.readLine();
            Optional<String> opt = Optional.ofNullable(option);
            opt.filter(o -> o.equals("1")).ifPresent(o -> {
                Long idProblem = readId("problem", "delete");
                CompletableFuture.supplyAsync(() -> problemService.deleteProblem(idProblem), executorService).thenRun(() -> {
                });
            });


        } catch (ValidatorException | IOException ex) {
            System.out.println(ex.toString());
        }
    }

    private static void printUpdateMenu() {
        String menu = ""
                + "1. Update a problem\n"
                + "2. Update a student\n"
                + "Please enter your option: \n";
        System.out.println(menu);

    }

    @SuppressWarnings("Duplicates")
    private void updateMenu() {
        printUpdateMenu();
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            String option = bufferRead.readLine();
            Optional<String> opt = Optional.ofNullable(option);

            opt.filter(o -> o.equals("1")).ifPresent(o -> {
                Problem problem1 = readProblem();
                Optional<Problem> m1 = Optional.ofNullable(problem1);
                m1.ifPresent(v -> {
                    try {
                        CompletableFuture.supplyAsync(() -> this.problemService.updateProblem(problem1), executorService).thenRun(() -> {
                        });
                    } catch (ValidatorException e) {
                        e.printStackTrace();
                    }
                });
            });


        } catch (ValidatorException | IOException ex) {
            System.out.println(ex.toString());
        }
    }

    private static void printShowMenu() {
        String menu = ""
                + "1. Show all the problems\n"
                + "Please enter your option: \n";
        System.out.println(menu);
    }

    private void showMenu() {
        printShowMenu();
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            String option = bufferRead.readLine();
            Optional<String> opt = Optional.ofNullable(option);

            opt.filter(o -> o.equals("1")).ifPresent(o -> printAllProblems());

        } catch (ValidatorException | IOException ex) {
            System.out.println(ex.toString());
        }
    }



    private static void printFilterMenu() {
        String menu = ""
                + "1. Filter movies by director\n"
                + "2. Filter movies by year\n"
                + "3. Filter clients by name\n"
                + "4. Filter clients by age\n"
                + "5. Count movies filtered by year\n"
                + "6. Sort clients by name\n"
                + "Please enter your option: \n";
        System.out.println(menu);

    }


    public void runConsole() {
        Stream.generate(() -> {
            printMainMenu();
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            boolean flag = true;
            try {
                String option = bufferRead.readLine();
                Optional<String> opt = Optional.ofNullable(option);
                opt.filter(o -> o.equals("1")).ifPresent(o -> addMenu());
                opt.filter(o -> o.equals("2")).ifPresent(o -> deleteMenu());
                opt.filter(o -> o.equals("3")).ifPresent(o -> updateMenu());
                //opt.filter(o -> o.equals("4")).ifPresent(o -> filterMenu());
                opt.filter(o -> o.equals("5")).ifPresent(o -> showMenu());
                //opt.filter(o -> o.equals("6")).ifPresent(o -> reportsMenu());
                flag = opt.filter(o -> o.equals("0")).isEmpty();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ValidatorException ex) {
                System.out.println(ex.toString());
            }
            return flag;
        }).takeWhile(Boolean::booleanValue).forEach(a -> {
        });
    }


    /**
     * Reads and returns string representing the value which was read from the user input.
     *
     * @param operation represents the operation which benefits from the reading of the ID (e.g. filter by year, filter by name)
     * @return s String - representing a unique repository entity ID
     */
    private String readString(String operation) {
        String s = "";
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please give a value in order to " + operation + ":");
            s = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * Reads and returns an ID representing the value which was read from the user input.
     *
     * @param entity    represents the entity for which the ID was read (as String), used for logs (e.g. {@link Problem} , {@link })
     * @param operation represents the operation which benefits from the reading of the ID (e.g. delete, update)
     * @return ID - representing a unique repository entity ID
     */
    private Long readId(String entity, String operation) {
        System.out.println("Please give the id for the " + entity + " to " + operation + ": ");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Long.valueOf(bufferRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format!");
        }
        return null;
    }


    /**
     * Reads the fields of a Client in order to create a new {@link Client} Instance
     *
     * @return The newly created Client Instance or null in case a movie could not be created
     */

    /**
     * Reads the fields of a movie and creates one
     *
     * @return Movie or null in case a movie could not be created
     */
    private Problem readProblem() {
        System.out.println("Read problem (statement)");
        Long id = readId("problem", "insert");
        Optional<Long> o = Optional.ofNullable(id);

        o.orElseThrow(() -> new ValidatorException("Invalid id"));

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please give the statement of the problem:");
            String statement = bufferRead.readLine();

            Problem problem = new Problem(statement);
            problem.setId(id);

            return problem;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid type of input!!");
        }
        return null;
    }



}