package ro.ubb.student.remoting.service;



import ro.ubb.student.remoting.domain.Problem;
import ro.ubb.student.remoting.paging.Pageable;

import java.util.List;
import java.util.Set;


public interface ProblemService {




    /**
     * Getter for the problems in the repo
     *
     * @return a Set of problems from the repository
     */


    List<Problem> getAllProblems();//TODO:List


    /**
     * Saves the given Problem in the repo.
     *
     * @param problem must not be null or already in the repo.
     */
    String ADD_PROBLEM = "addProblem";

    Boolean addProblem(Problem problem);


    /**
     * Updates a problem with the provided problem
     *
     * @param student the problem to be updated, also it represents the latest version of the object to be updated
     */

    String UPDATE_PROBLEM = "updateProblem";

    Boolean updateProblem(Problem problem);

    /**
     * Deletes a problem with the id equal to the one given
     *
     * @param id Long
     */

    String DELETE_PROBLEM = "deleteProblem";

    Boolean deleteProblem(Long id);


    String EXISTS = "exists";

    Boolean exists(Long id);

    String SET_PAGEABLE = "setPageable";

    Boolean setPageable(Pageable pageable);

    String GET_NEXT_PROBLEMS = "getNextProblems";

    List<Problem> getNextProblems();

}
