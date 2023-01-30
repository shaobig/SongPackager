package shaobig.amateur.maker.file;

import java.nio.file.Path;
import java.util.Map;

public interface MapFileMaker {

    void makeFiles(Map<Path, Path> pathMap);

}
