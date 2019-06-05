package ro.ubb.student.remoting.domain.validators;


import ro.ubb.student.remoting.domain.Grade;

import java.util.Optional;
import java.util.stream.Stream;

public class GradeValidator implements Validator<Grade> {
    @Override
    public void validate(Grade entity) throws ValidatorException {
        Boolean b = (entity.getId()== null  || entity.getId()<0 || entity.getValue().get() < -1 || entity.getValue().get() > 10 || entity.getToStudent().get() == null || entity.getForProblem().get() == null);
        Optional<Boolean> booleanOptional= Stream.of(b).filter(v -> !v).findAny();
        booleanOptional.orElseThrow(() -> new ValidatorException("Grade details are not valid!"));
    }
}
