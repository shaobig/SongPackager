package shaobig.amateur.resolver;

public interface ResourceResolver<T> {

    T resolve(T resource);

}
