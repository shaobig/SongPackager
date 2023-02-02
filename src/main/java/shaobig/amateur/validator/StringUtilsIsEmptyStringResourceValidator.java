package shaobig.amateur.validator;

import org.apache.commons.lang3.StringUtils;

class StringUtilsIsEmptyStringResourceValidator implements ResourceValidator<String> {

    @Override
    public boolean validate(String resource) {
        return StringUtils.isNotEmpty(resource);
    }

}
