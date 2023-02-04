package shaobig.amateur.resolver;

public class FirstLetterStringResourceResolver implements ResourceResolver<String> {

    @Override
    public String resolve(String resource) {
        return resource.substring(0, 1);
    }

}
