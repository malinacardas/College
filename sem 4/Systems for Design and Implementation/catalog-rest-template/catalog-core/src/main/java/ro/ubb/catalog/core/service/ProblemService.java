package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Problem;

import java.util.List;

/**
 * author: radu
 */
public interface ProblemService {
    List<Problem> getAllProblems();

    Problem saveProblem(Problem problem);

    Problem updateProblem(Long id, Problem convertDtoToModel);
    void deleteProblem(Long id);

}
