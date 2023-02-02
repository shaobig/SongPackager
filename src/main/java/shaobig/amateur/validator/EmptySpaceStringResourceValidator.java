package shaobig.amateur.validator;

class EmptySpaceStringResourceValidator implements ResourceValidator<String> {

    @Override
    public boolean validate(String resource) {
        return resource.equals(resource.trim());
    }

}
