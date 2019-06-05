package ro.ubb.student.remoting.domain.validators;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
