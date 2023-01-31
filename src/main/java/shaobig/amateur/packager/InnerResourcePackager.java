package shaobig.amateur.packager;

import shaobig.amateur.maker.directory.CollectionDirectoryMaker;
import shaobig.amateur.maker.file.FileMaker;
import shaobig.amateur.maker.file.MapFileMaker;
import shaobig.amateur.resolver.ResourceResolver;
import shaobig.amateur.scanner.DirectoryScanner;

import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

class InnerResourcePackager implements FileMaker {

    private DirectoryScanner directoryScanner;
    private ResourceResolver<Path> pathResolver;
    private CollectionDirectoryMaker<Path> collectionDirectoryMaker;
    private MapFileMaker mapFileMaker;

    public InnerResourcePackager(DirectoryScanner directoryScanner, ResourceResolver<Path> pathResolver, CollectionDirectoryMaker<Path> collectionDirectoryMaker, MapFileMaker mapFileMaker) {
        this.directoryScanner = directoryScanner;
        this.pathResolver = pathResolver;
        this.collectionDirectoryMaker = collectionDirectoryMaker;
        this.mapFileMaker = mapFileMaker;
    }

    @Override
    public void makeFile(Path sourcePath, Path targetPath) {
        Map<Path, Path> pathMap = getDirectoryScanner().scan(sourcePath).stream()
                .collect(Collectors.toMap(path -> path, getResourceResolver()::resolve));

        getCollectionDirectoryMaker().makeDirectory(pathMap.values());
        getMapFileMaker().makeFiles(pathMap);
    }

    public DirectoryScanner getDirectoryScanner() {
        return directoryScanner;
    }

    public void setDirectoryScanner(DirectoryScanner directoryScanner) {
        this.directoryScanner = directoryScanner;
    }

    public CollectionDirectoryMaker<Path> getCollectionDirectoryMaker() {
        return collectionDirectoryMaker;
    }

    public void setCollectionDirectoryMaker(CollectionDirectoryMaker<Path> collectionDirectoryMaker) {
        this.collectionDirectoryMaker = collectionDirectoryMaker;
    }

    public MapFileMaker getMapFileMaker() {
        return mapFileMaker;
    }

    public void setMapFileMaker(MapFileMaker mapFileMaker) {
        this.mapFileMaker = mapFileMaker;
    }

    public ResourceResolver<Path> getResourceResolver() {
        return pathResolver;
    }

    public void setResourceResolver(ResourceResolver<Path> pathResolver) {
        this.pathResolver = pathResolver;
    }
}
