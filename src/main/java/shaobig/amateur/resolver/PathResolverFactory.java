package shaobig.amateur.resolver;

public class PathResolverFactory {

    public static PathResolver getPathResolver() {
        return new Mp3FilePathResolver();
    }

}
