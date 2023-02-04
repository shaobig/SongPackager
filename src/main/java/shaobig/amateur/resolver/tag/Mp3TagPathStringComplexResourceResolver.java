package shaobig.amateur.resolver.tag;

import org.apache.commons.lang3.StringUtils;
import shaobig.amateur.resolver.ComplexResourceResolver;
import shaobig.amateur.resolver.ResourceResolver;

import java.nio.file.Path;
import java.util.List;

public class Mp3TagPathStringComplexResourceResolver extends ComplexResourceResolver<Path, String> {

    private static final List<ResourceResolver<String>> DEFAULT_TAG_RESOURCE_RESOLVERS = List.of(
            new Mp3FileTagStringResolver()
    );

    public Mp3TagPathStringComplexResourceResolver() {
        super(DEFAULT_TAG_RESOURCE_RESOLVERS);
    }

    public Mp3TagPathStringComplexResourceResolver(List<ResourceResolver<String>> resourceResolvers) {
        super(resourceResolvers);
    }

    @Override
    public Path resolve(Path path) {
        return getResourceResolverList().stream()
                .map(stringResourceResolver -> stringResourceResolver.resolve(path.toString()))
                .reduce(Path.of(StringUtils.EMPTY), Path::resolve, (path1, path2) -> path1);
    }

}
