package shaobig.amateur.resolver;

import java.nio.file.Path;
import java.util.Locale;

class Mp3FileDirectoryPathResolver implements ResourceResolver<Path> {

    @Override
    public Path resolve(Path path) {
        String fileName = path.toFile().getName();
        return Path.of("")
                .resolve(fileName.substring(0, 1))
                .resolve(fileName.substring(0, fileName.indexOf(" - ")).toUpperCase(Locale.ROOT));
    }

}
