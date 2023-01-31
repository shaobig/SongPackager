package shaobig.amateur.resolver;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Path;

public class Mp3TagPathResolver implements ResourceResolver<Path> {

    private static final Path EMPTY_PATH = Path.of("");

    private ResourceResolver<String> stringResourceResolver;

    public Mp3TagPathResolver() {
        this.stringResourceResolver = new Mp3AlbumTagStringResourceResolver();
    }

    public Mp3TagPathResolver(ResourceResolver<String> stringResourceResolver) {
        this.stringResourceResolver = stringResourceResolver;
    }

    @Override
    public Path resolve(Path path) {
        try {
            Mp3File mp3File = new Mp3File(path);
            if (!mp3File.hasId3v2Tag()) {
                return EMPTY_PATH;
            }
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            String year = id3v2Tag.getYear();
            String album = id3v2Tag.getAlbum();
            if (StringUtils.isEmpty(year) || StringUtils.isEmpty(album)) {
                return EMPTY_PATH;
            }
            return Path.of(year.concat(" - ").concat(getStringResourceResolver().resolve(album)));
        } catch (InvalidDataException | UnsupportedTagException | IOException e) {
            return EMPTY_PATH;
        }
    }

    public ResourceResolver<String> getStringResourceResolver() {
        return stringResourceResolver;
    }

    public void setStringResourceResolver(ResourceResolver<String> stringResourceResolver) {
        this.stringResourceResolver = stringResourceResolver;
    }
}
