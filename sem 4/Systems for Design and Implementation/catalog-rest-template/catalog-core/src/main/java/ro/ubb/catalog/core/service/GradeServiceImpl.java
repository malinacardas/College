package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Grade;
import ro.ubb.catalog.core.repository.ClientRepository;
import ro.ubb.catalog.core.repository.GradeRepository;

import java.util.List;
import java.util.Optional;

/**
 * author: radu
 */
@Service
public class GradeServiceImpl implements GradeService {
  private static final Logger log =
    LoggerFactory.getLogger(GradeServiceImpl.class);

  @Autowired
  private GradeRepository gradeRepository;

  @Override
  public List<Grade> getAllGrades() {
    log.trace("getAllStudents --- method entered");

    List<Grade> result = gradeRepository.findAll();

    log.trace("getAllStudents: result={}", result);

    return result;
  }

  @Override
  public Grade saveGrade(Grade grade) {
    log.trace("-----saveStudent------ student={}", grade);

    Grade savedGrade = this.gradeRepository.save(grade);

    //todo log result...

    return savedGrade;
  }

  @Override
  @Transactional
  public Grade updateGrade(Long id, Grade grade) {
    log.trace("updateStudent: id={},student={}", id, grade);

    Optional<Grade> optionalStudent = gradeRepository.findById(id);
    Grade result = optionalStudent.orElse(grade);
    //result.setName(client.getName());
    //result.setSerialNumber(client.getSerialNumber());

    log.trace("updateStudent: result={}", result);

    return result;


  }

  @Override
  public void deleteGrade(Long id) {
    log.trace("deleteStudent: id={}", id);
    gradeRepository.deleteById(id);

    log.trace("deleteStudent --- method finished");
  }


}
