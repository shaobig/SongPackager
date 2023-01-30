package shaobig.amateur.extension;

import shaobig.amateur.extension.matcher.FileExtensionMatcher;
import shaobig.amateur.extension.matcher.FilenameUtilsFileExtensionMatcher;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class PathBasicFileAttributesBiPredicate implements BiPredicate<Path, BasicFileAttributes> {

    private Extension extension;
    private FileExtensionMatcher matcher;

    public PathBasicFileAttributesBiPredicate(Extension extension) {
        this.extension = extension;
        this.matcher = new FilenameUtilsFileExtensionMatcher();
    }

    public PathBasicFileAttributesBiPredicate(Extension extension, FileExtensionMatcher matcher) {
        this.extension = extension;
        this.matcher = matcher;
    }

    @Override
    public boolean test(Path path, BasicFileAttributes basicFileAttributes) {
        if (basicFileAttributes.isDirectory()) {
            return false;
        }
        return getMatcher().isExtensionMatched(path.toFile(), getExtension());
    }

    public FileExtensionMatcher getMatcher() {
        return matcher;
    }

    public void setMatcher(FileExtensionMatcher matcher) {
        this.matcher = matcher;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }
}
