package shaobig.amateur.resolver;

import java.nio.file.Path;
import java.util.List;

public class OutputPathResolver implements ResourceResolver<Path> {

    private static final List<ResourceResolver<String>> DEFAULT_FILE_RESOURCE_RESOLVERS = List.of(
            new FirstLetterStringResourceResolver(),
            new ArtistHyphenSongNameStringResourceResolver()
    );

    private static final List<ResourceResolver<String>> DEFAULT_TAG_RESOURCE_RESOLVERS = List.of(
            new Mp3FileTagStringResolver()
    );

    private Path outputPath;
    private ResourceResolver<Path> filePathResolver;
    private ResourceResolver<Path> tagPathResolver;

    public OutputPathResolver(Path outputPath) {
        this.outputPath = outputPath;
        this.filePathResolver = new PathStringComplexResourceResolver(DEFAULT_FILE_RESOURCE_RESOLVERS);
        this.tagPathResolver = new PathStringComplexResourceResolver(DEFAULT_TAG_RESOURCE_RESOLVERS);
    }

    public OutputPathResolver(Path outputPath, ResourceResolver<Path> filePathResolver, ResourceResolver<Path> tagPathResolver) {
        this.outputPath = outputPath;
        this.filePathResolver = filePathResolver;
        this.tagPathResolver = tagPathResolver;
    }

    @Override
    public Path resolve(Path path) {
        return getOutputPath()
                .resolve(getFilePathResolver().resolve(path))
                .resolve(getTagPathResolver().resolve(path))
                .resolve(path.toFile().getName());
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

    public ResourceResolver<Path> getFilePathResolver() {
        return filePathResolver;
    }

    public void setFilePathResolver(ResourceResolver<Path> filePathResolver) {
        this.filePathResolver = filePathResolver;
    }

    public ResourceResolver<Path> getTagPathResolver() {
        return tagPathResolver;
    }

    public void setTagPathResolver(ResourceResolver<Path> tagPathResolver) {
        this.tagPathResolver = tagPathResolver;
    }
}
