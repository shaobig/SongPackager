package shaobig.amateur.resolver;

import java.nio.file.Path;
import java.util.Locale;

class Mp3FilenameResourceResolver implements ResourceResolver<Path> {

    @Override
    public Path resolve(Path resource) {
        String fileName = resource.toFile().getName();
        return Path.of("")
                .resolve(fileName.substring(0, 1))
                .resolve(fileName.substring(0, fileName.indexOf("-") - 1).toUpperCase(Locale.ROOT))
                .resolve(fileName);
    }

}
