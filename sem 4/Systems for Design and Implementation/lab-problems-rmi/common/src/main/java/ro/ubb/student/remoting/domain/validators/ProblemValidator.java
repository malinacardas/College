package ro.ubb.student.remoting.domain.validators;



import ro.ubb.student.remoting.domain.Problem;

import java.util.Optional;
import java.util.stream.Stream;

public class ProblemValidator implements Validator<Problem> {

    @Override
    public void validate(Problem entity) throws ValidatorException {
        Boolean b = (entity.getId()== null || entity.getId()<0 || entity.getProblemStatement()==null || entity.getProblemStatement().get()=="" );
        Optional<Boolean> booleanOptional= Stream.of(b).filter(v -> !v).findAny();
        booleanOptional.orElseThrow(() -> new ValidatorException("Problem details are not valid!"));
    }
}
