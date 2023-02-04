package shaobig.amateur.resolver;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class PathStringComplexResourceResolver extends ComplexResourceResolver<Path, String> {

    private static final Logger LOGGER = LogManager.getLogger(PathStringComplexResourceResolver.class);

    public PathStringComplexResourceResolver(List<ResourceResolver<String>> resourceResolvers) {
        super(resourceResolvers);
    }

    @Override
    public Path resolve(Path path) {
        String fileName = path.toString();
        List<String> resolvedResources = getResourceResolverList().stream()
                .map(stringResourceResolver -> stringResourceResolver.resolve(fileName))
                .collect(Collectors.toList());
        Path outputPath = resolvedResources.stream()
                .reduce(Path.of(StringUtils.EMPTY), Path::resolve, (path1, path2) -> path1);
        if (resolvedResources.contains(StringUtils.EMPTY)) {
            LOGGER.warn("Save the file to the root directory: '{}'", outputPath);
        }
        return outputPath;
    }
}
