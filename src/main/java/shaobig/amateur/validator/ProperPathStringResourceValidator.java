package shaobig.amateur.validator;

import java.util.Set;

class ProperPathStringResourceValidator implements ResourceValidator<String> {

    private Set<String> forbiddenSymbols;

    public ProperPathStringResourceValidator(Set<String> forbiddenSymbols) {
        this.forbiddenSymbols = forbiddenSymbols;
    }

    @Override
    public boolean validate(String resource) {
        return getForbiddenSymbols().stream()
                .noneMatch(resource::contains);
    }

    public Set<String> getForbiddenSymbols() {
        return forbiddenSymbols;
    }

    public void setForbiddenSymbols(Set<String> forbiddenSymbols) {
        this.forbiddenSymbols = forbiddenSymbols;
    }
}
