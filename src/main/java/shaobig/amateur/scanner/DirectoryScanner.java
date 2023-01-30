package shaobig.amateur.scanner;

import java.nio.file.Path;
import java.util.Collection;

public interface DirectoryScanner {

    Collection<Path> scan(Path path);

}
