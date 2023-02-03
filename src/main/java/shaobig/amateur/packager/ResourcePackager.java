package shaobig.amateur.packager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.extension.Extension;
import shaobig.amateur.maker.directory.CollectionDirectoryMaker;
import shaobig.amateur.maker.directory.PathCollectionDirectoryMaker;
import shaobig.amateur.maker.file.FileMaker;
import shaobig.amateur.maker.file.MapFileMaker;
import shaobig.amateur.maker.file.PathMapFileMaker;
import shaobig.amateur.resolver.OutputPathResolver;
import shaobig.amateur.resolver.ResourceResolver;
import shaobig.amateur.scanner.DirectoryScanner;
import shaobig.amateur.scanner.ExtensionDirectoryScanner;

import java.nio.file.Path;

public class ResourcePackager implements FileMaker {

    private static final Logger LOGGER = LogManager.getLogger(ResourcePackager.class);

    private Extension extension;

    public ResourcePackager(Extension extension) {
        this.extension = extension;
    }

    @Override
    public void makeFile(Path sourcePath, Path targetPath) {
        LOGGER.info("Copy files from '{}' to '{}'", sourcePath, targetPath);

        DirectoryScanner directoryScanner = new ExtensionDirectoryScanner(getExtension());
        ResourceResolver<Path> pathResourceResolver = new OutputPathResolver(targetPath);
        CollectionDirectoryMaker<Path> collectionDirectoryMaker = new PathCollectionDirectoryMaker();
        MapFileMaker mapFileMaker = new PathMapFileMaker();

        FileMaker fileMaker = new InnerResourcePackager(directoryScanner, pathResourceResolver, collectionDirectoryMaker, mapFileMaker);
        fileMaker.makeFile(sourcePath, targetPath);
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }
}
