package shaobig.amateur.resolver;

import java.nio.file.Path;

public class ResourceResolverFactory {

    public static ResourceResolver<Path> getResourceResolver() {
        return new Mp3FileResourceResolver();
    }

}
