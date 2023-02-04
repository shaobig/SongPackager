package shaobig.amateur.resolver.tag;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.resolver.ResourceResolver;
import shaobig.amateur.validator.ID3v2ResourceValidator;
import shaobig.amateur.validator.ResourceValidator;

import java.io.IOException;

class Mp3FileTagStringResolver implements ResourceResolver<String> {

    private static final Logger LOGGER = LogManager.getLogger(Mp3FileTagStringResolver.class);

    private ResourceValidator<ID3v2> id3v2ResourceValidator;

    public Mp3FileTagStringResolver() {
        this.id3v2ResourceValidator = new ID3v2ResourceValidator();
    }

    public Mp3FileTagStringResolver(ResourceValidator<ID3v2> id3v2ResourceValidator) {
        this.id3v2ResourceValidator = id3v2ResourceValidator;
    }

    @Override
    public String resolve(String path) {
        try {
            Mp3File mp3File = new Mp3File(path);
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            if (!getId3v2ResourceValidator().validate(id3v2Tag)) {
                return StringUtils.EMPTY;
            }
            String year = id3v2Tag.getYear();
            String album = id3v2Tag.getAlbum();
            return year.concat(" - ").concat(album);
        } catch (IOException e) {
            LOGGER.error("Can't read the tags");
            return StringUtils.EMPTY;
        } catch (InvalidDataException | UnsupportedTagException e) {
            LOGGER.error("Not enough necessary tags");
            return StringUtils.EMPTY;
        }
    }

    public ResourceValidator<ID3v2> getId3v2ResourceValidator() {
        return id3v2ResourceValidator;
    }

    public void setId3v2ResourceValidator(ResourceValidator<ID3v2> id3v2ResourceValidator) {
        this.id3v2ResourceValidator = id3v2ResourceValidator;
    }
}
