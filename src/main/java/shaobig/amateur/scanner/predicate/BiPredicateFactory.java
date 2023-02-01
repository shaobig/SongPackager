package shaobig.amateur.scanner.predicate;

import java.util.function.BiPredicate;

interface BiPredicateFactory<T, V> {

    BiPredicate<T, V> getBiPredicate();

}
