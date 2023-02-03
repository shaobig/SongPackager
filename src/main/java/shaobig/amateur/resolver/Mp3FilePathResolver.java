package shaobig.amateur.resolver;

import java.nio.file.Path;

public class Mp3FilePathResolver implements ResourceResolver<Path> {

    @Override
    public Path resolve(Path path) {
        return new Mp3FileDirectoryPathResolver().resolve(path);
    }

}
