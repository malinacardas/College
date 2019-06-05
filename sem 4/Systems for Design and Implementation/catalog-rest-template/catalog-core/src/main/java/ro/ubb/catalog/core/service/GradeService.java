package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Grade;

import java.util.List;

public interface GradeService {
  List<Grade> getAllGrades();

  Grade saveGrade(Grade grade);

  Grade updateGrade(Long id, Grade convertDtoToModel);

  void deleteGrade(Long id);
}
