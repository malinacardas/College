package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Problem;
import ro.ubb.catalog.core.service.ClientService;
import ro.ubb.catalog.core.service.ProblemService;
import ro.ubb.catalog.web.converter.ClientConverter;
import ro.ubb.catalog.web.converter.ProblemConverter;
import ro.ubb.catalog.web.dto.ClientDto;
import ro.ubb.catalog.web.dto.ClientsDto;
import ro.ubb.catalog.web.dto.ProblemDto;
import ro.ubb.catalog.web.dto.ProblemsDto;

import java.util.List;
import java.util.Set;

/**
 * author: radu
 */

@RestController
public class ProblemController {
    private static final Logger log =
            LoggerFactory.getLogger(ProblemController.class);

    @Autowired
    private ProblemService problemService;

    @Autowired
    private ProblemConverter problemConverter;

    @RequestMapping(value = "/problems", method = RequestMethod.GET)
        //@GetMapping("/clients")
    ProblemsDto getAllProblems() {
        log.trace("getAllStudents --- method entered");

        List<Problem> problems = problemService.getAllProblems();
        Set<ProblemDto> dtos = problemConverter.convertModelsToDtos(problems);
        ProblemsDto result = new ProblemsDto(dtos);

        log.trace("getAllStudents: result={}", result);

        return result;
    }

    @RequestMapping(value = "/problems", method = RequestMethod.POST)
    ProblemDto saveProblem (@RequestBody ProblemDto dto) {
        log.trace("saveStudent: dto={}", dto);

        Problem saved = this.problemService.saveProblem(
                problemConverter.convertDtoToModel(dto)
        );
        ProblemDto result = problemConverter.convertModelToDto(saved);

        log.trace("saveStudent: result={}", result);

        return result;
    }

    @RequestMapping(value = "/problem/{id}", method = RequestMethod.PUT)
    ProblemDto updateProblem(@PathVariable Long id,
                           @RequestBody ProblemDto dto) {
        log.trace("updateStudent: id={},dto={}", id, dto);

        Problem update = problemService.updateProblem(
                id,
                problemConverter.convertDtoToModel(dto));
        ProblemDto result = problemConverter.convertModelToDto(update);

        return result;
    }

    @RequestMapping(value = "/problems/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteProblem(@PathVariable Long id) {
        log.trace("deleteStudent: id={}", id);

        problemService.deleteProblem(id);

        log.trace("deleteStudent --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
