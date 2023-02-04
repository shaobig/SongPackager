package shaobig.amateur.resolver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shaobig.amateur.resolver.filename.Mp3FilenamePathStringComplexResourceResolver;
import shaobig.amateur.resolver.tag.Mp3TagPathStringComplexResourceResolver;

import java.nio.file.Path;

public class OutputPathResolver implements ResourceResolver<Path> {

    private static final Logger LOGGER = LogManager.getLogger(OutputPathResolver.class);

    private Path outputPath;
    private ComplexResourceResolver<Path, String> filePathResolver;
    private ComplexResourceResolver<Path, String> tagPathResolver;

    public OutputPathResolver(Path outputPath) {
        this.outputPath = outputPath;
        this.filePathResolver = new Mp3FilenamePathStringComplexResourceResolver();
        this.tagPathResolver = new Mp3TagPathStringComplexResourceResolver();
    }

    public OutputPathResolver(Path outputPath, ComplexResourceResolver<Path, String> filePathResolver, ComplexResourceResolver<Path, String> tagPathResolver) {
        this.outputPath = outputPath;
        this.filePathResolver = filePathResolver;
        this.tagPathResolver = tagPathResolver;
    }

    @Override
    public Path resolve(Path path) {
        LOGGER.info("Resolve path for '{}'", path);
        Path outputPath = getOutputPath()
                .resolve(getFilePathResolver().resolve(path))
                .resolve(getTagPathResolver().resolve(path))
                .resolve(path.toFile().getName());
        LOGGER.info("Set the file path to '{}'", outputPath);
        return outputPath;
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

    public ComplexResourceResolver<Path, String> getFilePathResolver() {
        return filePathResolver;
    }

    public void setFilePathResolver(ComplexResourceResolver<Path, String> filePathResolver) {
        this.filePathResolver = filePathResolver;
    }

    public ComplexResourceResolver<Path, String> getTagPathResolver() {
        return tagPathResolver;
    }

    public void setTagPathResolver(ComplexResourceResolver<Path, String> tagPathResolver) {
        this.tagPathResolver = tagPathResolver;
    }
}
