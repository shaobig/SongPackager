package shaobig.amateur.resolver;

import java.nio.file.Path;

class Mp3FileResourceResolver implements ResourceResolver<Path> {

    @Override
    public Path resolve(Path resource) {
        return Path.of("").resolve(new Mp3FilenameResourceResolver().resolve(resource));
    }

}
