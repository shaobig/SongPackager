package shaobig.amateur.resolver;

import org.apache.commons.lang3.StringUtils;

import java.util.Set;

public class Mp3AlbumTagStringResourceResolver implements ResourceResolver<String> {

    private static final Set<String> PROHIBITED_SYMBOLS = Set.of("\\", "/", ":", "*", "?", "\"", "<", ">", "|", ".");

    @Override
    public String resolve(String resource) {
        return PROHIBITED_SYMBOLS.stream()
                .reduce(resource, (fullResource, symbol) -> fullResource.replace(symbol, StringUtils.EMPTY))
                .trim();
    }

}
