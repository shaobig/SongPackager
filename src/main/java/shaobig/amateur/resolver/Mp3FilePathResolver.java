package shaobig.amateur.resolver;

import java.nio.file.Path;

class Mp3FilePathResolver implements PathResolver {

    @Override
    public Path resolvePath(Path resource) {
        return Path.of("").resolve(new Mp3FilenamePathResolver().resolvePath(resource));
    }

}
