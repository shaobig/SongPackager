package shaobig.amateur.scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.extension.Extension;
import shaobig.amateur.scanner.predicate.ExtensionPathBasicFileAttributesBiPredicateFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtensionDirectoryScanner implements DirectoryScanner {

    private static final Logger LOGGER = LogManager.getLogger(ExtensionDirectoryScanner.class);

    private static final int MAX_DEPTH = 1;

    private Extension extension;

    public ExtensionDirectoryScanner(Extension extension) {
        this.extension = extension;
    }

    @Override
    public Collection<Path> scan(Path path) {
        LOGGER.info("Scan directory '{}'", path);
        try (Stream<Path> pathStream = Files.find(path, MAX_DEPTH, new ExtensionPathBasicFileAttributesBiPredicateFactory(getExtension()).getBiPredicate())) {
            return pathStream.collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            String errorMessage = String.format("Can't scan resources by '%s' path", path);
            LOGGER.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

}
