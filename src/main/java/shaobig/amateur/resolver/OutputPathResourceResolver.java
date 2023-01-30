package shaobig.amateur.resolver;

import java.nio.file.Path;

public class OutputPathResourceResolver implements ResourceResolver<Path> {

    private Path outputPath;
    private ResourceResolver<Path> extensionPathResolver;

    public OutputPathResourceResolver(Path outputPath, ResourceResolver<Path> extensionPathResolver) {
        this.outputPath = outputPath;
        this.extensionPathResolver = extensionPathResolver;
    }

    @Override
    public Path resolve(Path resource) {
        return getOutputPath().resolve(getExtensionPathResolver().resolve(resource));
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

    public void setExtensionPathResolver(ResourceResolver<Path> extensionPathResolver) {
        this.extensionPathResolver = extensionPathResolver;
    }
}
