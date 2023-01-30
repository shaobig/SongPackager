package shaobig.amateur.maker.directory;

import java.nio.file.Path;
import java.util.Collection;

public class PathCollectionDirectoryMaker implements CollectionDirectoryMaker<Path> {

    private DirectoryMaker<Path> directoryMaker;

    public PathCollectionDirectoryMaker() {
        this.directoryMaker = new PathDirectoryMaker();
    }

    public PathCollectionDirectoryMaker(DirectoryMaker<Path> directoryMaker) {
        this.directoryMaker = directoryMaker;
    }

    @Override
    public void makeDirectory(Collection<Path> resource) {
        resource.stream()
                .map(Path::getParent)
                .distinct()
                .forEach(getDirectoryMaker()::makeDirectory);
    }

    public DirectoryMaker<Path> getDirectoryMaker() {
        return directoryMaker;
    }

    public void setDirectoryMaker(DirectoryMaker<Path> directoryMaker) {
        this.directoryMaker = directoryMaker;
    }
}
