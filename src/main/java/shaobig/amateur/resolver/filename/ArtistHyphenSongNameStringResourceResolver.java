package shaobig.amateur.resolver.filename;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.resolver.ResourceResolver;

import java.util.Locale;

class ArtistHyphenSongNameStringResourceResolver implements ResourceResolver<String> {

    private static final Logger LOGGER = LogManager.getLogger(ArtistHyphenSongNameStringResourceResolver.class);

    private static final String DEFAULT_DELIMITER = " - ";

    private String delimiter;

    public ArtistHyphenSongNameStringResourceResolver() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public ArtistHyphenSongNameStringResourceResolver(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String resolve(String resource) {
        if (!resource.contains(getDelimiter())) {
            LOGGER.warn("Can't find the delimiter '{}' in the '{}' name", getDelimiter(), resource);
            return StringUtils.EMPTY;
        }
        return resource.substring(0, resource.indexOf(getDelimiter())).toUpperCase(Locale.ROOT);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
