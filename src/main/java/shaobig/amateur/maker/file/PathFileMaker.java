package shaobig.amateur.maker.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PathFileMaker implements FileMaker {

    private static final Logger LOGGER = LogManager.getLogger(PathFileMaker.class);

    @Override
    public void makeFile(Path sourcePath, Path targetPath) {
        try {
            LOGGER.info("Make a file in '{}'", targetPath);
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            LOGGER.error("Can't create the file '{}'", targetPath);
        }
    }
}
