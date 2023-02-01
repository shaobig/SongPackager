package shaobig.amateur.scanner.predicate;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

class EveryFileExtensionPathBasicFileAttributesBiPredicate implements BiPredicate<Path, BasicFileAttributes> {

    @Override
    public boolean test(Path path, BasicFileAttributes basicFileAttributes) {
        return !basicFileAttributes.isDirectory();
    }

}
