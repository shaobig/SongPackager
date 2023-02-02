package shaobig.amateur.validator;

public interface ResourceValidator<T> {

    boolean validate(T resource);

}
