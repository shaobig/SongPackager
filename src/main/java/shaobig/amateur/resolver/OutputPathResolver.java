package shaobig.amateur.resolver;

import java.nio.file.Path;

public class OutputPathResolver implements PathResolver {

    private Path outputPath;
    private PathResolver extensionPathResolver;

    public OutputPathResolver(Path outputPath, PathResolver extensionPathResolver) {
        this.outputPath = outputPath;
        this.extensionPathResolver = extensionPathResolver;
    }

    @Override
    public Path resolvePath(Path resource) {
        return getOutputPath()
                .resolve(getExtensionPathResolver().resolvePath(resource));
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

    public PathResolver getExtensionPathResolver() {
        return extensionPathResolver;
    }

    public void setExtensionPathResolver(PathResolver extensionPathResolver) {
        this.extensionPathResolver = extensionPathResolver;
    }
}
