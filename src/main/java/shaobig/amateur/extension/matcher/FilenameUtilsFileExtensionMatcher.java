package shaobig.amateur.extension.matcher;

import shaobig.amateur.extension.Extension;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Locale;

public class FilenameUtilsFileExtensionMatcher implements FileExtensionMatcher {

    @Override
    public boolean isExtensionMatched(File file, Extension extension) {
        return FilenameUtils.isExtension(file.getName(), extension.name().toLowerCase(Locale.ROOT));
    }

}
