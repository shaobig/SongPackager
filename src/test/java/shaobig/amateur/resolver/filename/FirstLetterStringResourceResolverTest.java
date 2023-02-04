package shaobig.amateur.resolver.filename;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shaobig.amateur.resolver.FirstLetterStringResourceResolver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstLetterStringResourceResolverTest {

    private FirstLetterStringResourceResolver stringResourceResolver;

    @BeforeEach
    void setUp() {
        this.stringResourceResolver = new FirstLetterStringResourceResolver();
    }

    static Stream<Arguments> resolveInput() {
        return Stream.of(
                Arguments.of(" ", " "),
                Arguments.of("a", "a"),
                Arguments.of("A", "A"),
                Arguments.of("abc", "a"),
                Arguments.of("ABC", "A"),
                Arguments.of("Abc", "A")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "resolveInput")
    void resolve(String sourceResource, String expected) {
        String actual = stringResourceResolver.resolve(sourceResource);

        assertEquals(expected, actual);
    }

}
