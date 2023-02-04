package shaobig.amateur.resolver;

import java.util.List;

public abstract class ComplexResourceResolver<T, V> implements ResourceResolver<T> {

    private List<ResourceResolver<V>> resourceResolverList;

    public ComplexResourceResolver(List<ResourceResolver<V>> resourceResolverList) {
        this.resourceResolverList = resourceResolverList;
    }

    public List<ResourceResolver<V>> getResourceResolverList() {
        return resourceResolverList;
    }

    public void setResourceResolverList(List<ResourceResolver<V>> resourceResolverList) {
        this.resourceResolverList = resourceResolverList;
    }
}
