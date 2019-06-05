package ro.ubb.student.remoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.student.remoting.domain.Problem;
import ro.ubb.student.remoting.paging.Pageable;
import ro.ubb.student.remoting.service.ProblemService;

import java.util.List;

public class ProblemServiceImplementation implements ProblemService{

    @Autowired
    private ProblemService problemService;

    @Override
    public List<Problem> getAllProblems() {
        return this.problemService.getAllProblems();
    }

    @Override
    public Boolean addProblem(Problem problem) {
        return this.problemService.addProblem(problem);
    }

    @Override
    public Boolean updateProblem(Problem problem) {
        return this.problemService.updateProblem(problem);
    }

    @Override
    public Boolean deleteProblem(Long id) {
        return this.problemService.deleteProblem(id);
    }

    @Override
    public Boolean exists(Long id) {
        return this.problemService.exists(id);
    }

    @Override
    public Boolean setPageable(Pageable pageable) {
        return null;
    }

    @Override
    public List<Problem> getNextProblems() {
        return null;
    }
}