package shaobig.amateur.validator;

import com.mpatric.mp3agic.ID3v2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.validator.tag.Tag;
import shaobig.amateur.validator.tag.TagType;

import java.util.Optional;

public class ID3v2ResourceValidator implements ResourceValidator<ID3v2> {

    private static final Logger LOGGER = LogManager.getLogger(ID3v2ResourceValidator.class);

    private ResourceValidator<Tag> tagResourceValidator;

    public ID3v2ResourceValidator() {
        this.tagResourceValidator = new TagResourceValidator();
    }

    public ID3v2ResourceValidator(ResourceValidator<Tag> tagResourceValidator) {
        this.tagResourceValidator = tagResourceValidator;
    }

    @Override
    public boolean validate(ID3v2 id3v2) {
        if (Optional.ofNullable(id3v2).isEmpty()) {
            LOGGER.warn("Can't find the MP3 tags ID3V2");
            return false;
        }
        return getTagResourceValidator().validate(new Tag(TagType.ALBUM, id3v2.getAlbum()))
                && getTagResourceValidator().validate(new Tag(TagType.YEAR, id3v2.getYear()));
    }

    public ResourceValidator<Tag> getTagResourceValidator() {
        return tagResourceValidator;
    }

    public void setTagResourceValidator(ResourceValidator<Tag> tagResourceValidator) {
        this.tagResourceValidator = tagResourceValidator;
    }
}
