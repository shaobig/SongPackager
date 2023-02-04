package shaobig.amateur.resolver.filename;

import shaobig.amateur.resolver.ResourceResolver;

class FirstLetterStringResourceResolver implements ResourceResolver<String> {

    @Override
    public String resolve(String resource) {
        return resource.substring(0, 1);
    }

}
