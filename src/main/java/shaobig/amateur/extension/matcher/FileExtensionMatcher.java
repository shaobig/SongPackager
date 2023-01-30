package shaobig.amateur.extension.matcher;

import shaobig.amateur.extension.Extension;

import java.io.File;

public interface FileExtensionMatcher {

    boolean isExtensionMatched(File file, Extension extension);

}
