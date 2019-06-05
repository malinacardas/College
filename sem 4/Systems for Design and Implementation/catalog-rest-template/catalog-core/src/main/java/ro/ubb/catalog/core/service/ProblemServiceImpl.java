package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Problem;
import ro.ubb.catalog.core.model.Student;
import ro.ubb.catalog.core.repository.ProblemRepository;
import ro.ubb.catalog.core.repository.StudentRepository;

import java.net.PortUnreachableException;
import java.util.List;
import java.util.Optional;

/**
 * author: radu
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    private static final Logger log =
            LoggerFactory.getLogger(ProblemServiceImpl.class);

    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public List<Problem> getAllProblems(){
        log.trace("get All Problems---method entered");
        List<Problem> result=problemRepository.findAll();
        log.trace("get all problems result={}", result);
        return result;
    }



    @Override
    public Problem saveProblem(Problem problem){
        log.trace("--save problem",problem);
        Problem savedProblem=this.problemRepository.save(problem);
        return savedProblem;
    }


    @Override
    @Transactional
    public Problem updateProblem(Long id, Problem problem){
        log.trace("update problem", id, problem);
        Optional<Problem> optionalProblem=problemRepository.findById(id);
        Problem result=optionalProblem.orElse(problem);

        //result.setName(student.getName());
        //result.setGrade(student.getGrade());

        log.trace("updateStudent: result={}", result);

        return result;
    }

    @Override
    public void deleteProblem(Long id){
        log.trace("deleteProblem", id);
        problemRepository.deleteById(id);
        log.trace("deleted problem--method finished");
    }



}
