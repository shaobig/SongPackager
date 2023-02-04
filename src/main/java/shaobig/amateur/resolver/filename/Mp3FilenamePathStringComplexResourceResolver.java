package shaobig.amateur.resolver.filename;

import org.apache.commons.lang3.StringUtils;
import shaobig.amateur.resolver.ComplexResourceResolver;
import shaobig.amateur.resolver.ResourceResolver;

import java.nio.file.Path;
import java.util.List;

public class Mp3FilenamePathStringComplexResourceResolver extends ComplexResourceResolver<Path, String> {

    private static final List<ResourceResolver<String>> DEFAULT_FILE_RESOURCE_RESOLVERS = List.of(
            new FirstLetterStringResourceResolver(),
            new ArtistHyphenSongNameStringResourceResolver()
    );

    public Mp3FilenamePathStringComplexResourceResolver() {
        super(DEFAULT_FILE_RESOURCE_RESOLVERS);
    }

    public Mp3FilenamePathStringComplexResourceResolver(List<ResourceResolver<String>> resourceResolvers) {
        super(resourceResolvers);
    }

    @Override
    public Path resolve(Path path) {
        return getResourceResolverList().stream()
                .map(stringResourceResolver -> stringResourceResolver.resolve(path.getFileName().toString()))
                .reduce(Path.of(StringUtils.EMPTY), Path::resolve, (path1, path2) -> path1);
    }

}
