package shaobig.amateur.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.validator.tag.Tag;

import java.util.Set;

class TagResourceValidator implements ResourceValidator<Tag> {

    private static final Logger LOGGER = LogManager.getLogger(TagResourceValidator.class);

    private static final Set<String> FORBIDDEN_SYMBOLS = Set.of("\\", "/", ":", "*", "?", "\"", "<", ">", "|", ".");

    private static final ResourceValidator<String> IS_EMPTY_RESOURCE_VALIDATOR = new StringUtilsIsEmptyStringResourceValidator();
    private static final ResourceValidator<String> PROPER_PATH_RESOURCE_VALIDATOR = new ProperPathStringResourceValidator(FORBIDDEN_SYMBOLS);
    private static final ResourceValidator<String> EMPTY_SYMBOL_RESOURCE_VALIDATOR = new EmptySpaceStringResourceValidator();

    @Override
    public boolean validate(Tag tag) {
        if (!IS_EMPTY_RESOURCE_VALIDATOR.validate(tag.getValue())) {
            LOGGER.warn("The {} tag is not provided", tag.getTagTypeInLowerCase());
            return false;
        }
        if (!PROPER_PATH_RESOURCE_VALIDATOR.validate(tag.getValue())) {
            LOGGER.warn("The {} tag '{}' contains one of the following symbols: '{}'", tag.getTagTypeInLowerCase(), tag.getValue(), FORBIDDEN_SYMBOLS);
            return false;
        }
        if (!EMPTY_SYMBOL_RESOURCE_VALIDATOR.validate(tag.getValue())) {
            LOGGER.warn("The {} tag '{}' contains at least one empty symbol", tag.getTagTypeInLowerCase(), tag.getValue());
            return false;
        }
        return true;
    }

}
