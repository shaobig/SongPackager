package shaobig.amateur.main;

import shaobig.amateur.extension.Extension;
import shaobig.amateur.maker.file.FileMaker;
import shaobig.amateur.packager.ResourcePackager;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        FileMaker fileMaker = new ResourcePackager(Extension.MP3);
        fileMaker.makeFile(Path.of(args[0]), Path.of(args[1]));
    }
}
