package shaobig.amateur.scanner;

import shaobig.amateur.extension.Extension;
import shaobig.amateur.extension.PathBasicFileAttributesBiPredicate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ExtensionDirectoryScanner implements DirectoryScanner {

    private static final int MAX_DEPTH = 1;

    private Extension extension;

    public ExtensionDirectoryScanner(Extension extension) {
        this.extension = extension;
    }

    @Override
    public Collection<Path> scan(Path path) {
        try {
            return Files.find(path, MAX_DEPTH, new PathBasicFileAttributesBiPredicate(getExtension()))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            throw new RuntimeException("Can't fetch all data");
        }
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

}
