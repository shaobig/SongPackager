package shaobig.amateur.maker.directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathDirectoryMaker implements DirectoryMaker<Path> {

    @Override
    public void makeDirectory(Path path) {
        try {
            Files.createDirectories(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
