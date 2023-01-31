package shaobig.amateur.maker.directory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathDirectoryMaker implements DirectoryMaker<Path> {

    private static final Logger LOGGER = LogManager.getLogger(PathDirectoryMaker.class);

    @Override
    public void makeDirectory(Path path) {
        try {
            Files.createDirectories(path);
        }
        catch (IOException e) {
            LOGGER.error("Can't create the directory '{}'", path);
        }
    }

}
