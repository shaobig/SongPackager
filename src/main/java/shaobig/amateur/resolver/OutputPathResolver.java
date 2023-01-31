package shaobig.amateur.resolver;

import java.nio.file.Path;

public class OutputPathResolver implements ResourceResolver<Path> {

    private Path outputPath;
    private ResourceResolver<Path> extensionPathResolver;
    private ResourceResolver<Path> tagPathResolver;

    public OutputPathResolver(Path outputPath, ResourceResolver<Path> extensionPathResolver, ResourceResolver<Path> tagPathResolver) {
        this.outputPath = outputPath;
        this.extensionPathResolver = extensionPathResolver;
        this.tagPathResolver = tagPathResolver;
    }

    @Override
    public Path resolve(Path path) {
        return getOutputPath()
                .resolve(getExtensionPathResolver().resolve(path))
                .resolve(getTagPathResolver().resolve(path))
                .resolve(path.toFile().getName());
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

    public ResourceResolver<Path> getExtensionPathResolver() {
        return extensionPathResolver;
    }

    public void setExtensionPathResolver(ResourceResolver<Path>  extensionPathResolver) {
        this.extensionPathResolver = extensionPathResolver;
    }

    public ResourceResolver<Path> getTagPathResolver() {
        return tagPathResolver;
    }

    public void setTagPathResolver(ResourceResolver<Path>  tagPathResolver) {
        this.tagPathResolver = tagPathResolver;
    }
}
