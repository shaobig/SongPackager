package shaobig.amateur.main;

import shaobig.amateur.extension.Extension;
import shaobig.amateur.maker.file.FileMaker;
import shaobig.amateur.packager.ResourcePackager;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path sourcePath = Path.of(args[0]);
        Path targetPath = Path.of(args[1]);
        Extension extension = Extension.MP3;

        FileMaker fileMaker = new ResourcePackager(extension);
        fileMaker.makeFile(sourcePath, targetPath);
    }
}
