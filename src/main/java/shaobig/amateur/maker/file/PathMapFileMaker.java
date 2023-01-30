package shaobig.amateur.maker.file;

import java.nio.file.Path;
import java.util.Map;

public class PathMapFileMaker implements MapFileMaker {

    private FileMaker fileMaker;

    public PathMapFileMaker() {
        this.fileMaker = new PathFileMaker();
    }

    public PathMapFileMaker(FileMaker fileMaker) {
        this.fileMaker = fileMaker;
    }

    @Override
    public void makeFiles(Map<Path, Path> pathMap) {
        pathMap.forEach(getFileMaker()::makeFile);
    }

    public FileMaker getFileMaker() {
        return fileMaker;
    }

    public void setFileMaker(FileMaker fileMaker) {
        this.fileMaker = fileMaker;
    }
}
