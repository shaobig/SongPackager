package shaobig.amateur.resolver;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

public class OutputPathResolver implements ResourceResolver<Path> {

    private static final Logger LOGGER = LogManager.getLogger(OutputPathResolver.class);

    private Path outputPath;
    private ResourceResolver<Path> filenamePathResolver;
    private ResourceResolver<Path> tagPathResolver;

    public OutputPathResolver(Path outputPath, ResourceResolver<Path> filenamePathResolver, ResourceResolver<Path> tagPathResolver) {
        this.outputPath = outputPath;
        this.filenamePathResolver = filenamePathResolver;
        this.tagPathResolver = tagPathResolver;
    }

    @Override
    public Path resolve(Path path) {
        Path filenamePath = getFilenamePathResolver().resolve(path);
        Path tagPath = getTagPathResolver().resolve(path);
        Path fullOutputPath = getOutputPath().resolve(filenamePath)
                .resolve(tagPath)
                .resolve(path.toFile().getName());
        if (tagPath.toString().equals(StringUtils.EMPTY)) {
            LOGGER.warn("Save the file to the root directory: '{}'", fullOutputPath);
        }
        return fullOutputPath;
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

    public ResourceResolver<Path> getFilenamePathResolver() {
        return filenamePathResolver;
    }

    public void setFilenamePathResolver(ResourceResolver<Path> filenamePathResolver) {
        this.filenamePathResolver = filenamePathResolver;
    }

    public ResourceResolver<Path> getTagPathResolver() {
        return tagPathResolver;
    }

    public void setTagPathResolver(ResourceResolver<Path>  tagPathResolver) {
        this.tagPathResolver = tagPathResolver;
    }
}
