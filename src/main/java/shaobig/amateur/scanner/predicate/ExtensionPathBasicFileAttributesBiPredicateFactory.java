package shaobig.amateur.scanner.predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.extension.Extension;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class ExtensionPathBasicFileAttributesBiPredicateFactory implements BiPredicateFactory<Path, BasicFileAttributes> {

    private static final Logger LOGGER = LogManager.getLogger(ExtensionPathBasicFileAttributesBiPredicateFactory.class);

    private Extension extension;

    public ExtensionPathBasicFileAttributesBiPredicateFactory(Extension extension) {
        this.extension = extension;
    }

    @Override
    public BiPredicate<Path, BasicFileAttributes> getBiPredicate() {
        if (getExtension() == null) {
            LOGGER.warn("The extension is not provided. Searching for all files in the directory");
            return new EveryFileExtensionPathBasicFileAttributesBiPredicate();
        }
        return new FileExtensionPathBasicFileAttributesBiPredicate(getExtension());
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }
}
