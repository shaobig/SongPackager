package shaobig.amateur.scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import shaobig.amateur.extension.Extension;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExtensionDirectoryScannerTest {

    private static final Path SOURCE_PATH = Path.of("src/test/resources/shaobig/amateur/scanner");

    private ExtensionDirectoryScanner extensionDirectoryScanner;

    @BeforeEach
    void setUp() {
        extensionDirectoryScanner = new ExtensionDirectoryScanner(Mockito.mock(Extension.class));
    }

    @Test
    void scanNullableExtension() {
        extensionDirectoryScanner.setExtension(null);

        Collection<Path> actual = extensionDirectoryScanner.scan(SOURCE_PATH);

        Collection<Path> expected = List.of(
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_1.mp3"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_2.mp3"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_1.flac"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_2.flac"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_1.wav"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_2.wav")
        );
        assertTrue(expected.containsAll(actual));
    }

    static Stream<Arguments> scanInput() {
        Collection<Path> mp3Collection = List.of(
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_1.mp3"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_2.mp3")
        );
        Collection<Path> flacCollection = List.of(
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_1.flac"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_2.flac")
        );
        Collection<Path> wavCollection = List.of(
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_1.wav"),
                Path.of("src/test/resources/shaobig/amateur/scanner/test_file_2.wav")
        );

        return Stream.of(
                Arguments.of(Extension.MP3, mp3Collection),
                Arguments.of(Extension.FLAC, flacCollection),
                Arguments.of(Extension.WAV, wavCollection)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "scanInput")
    void scan(Extension sourceExtension, Collection<Path> expected) {
        extensionDirectoryScanner.setExtension(sourceExtension);

        Collection<Path> actual = extensionDirectoryScanner.scan(SOURCE_PATH);

        assertTrue(expected.containsAll(actual));
    }

    @Test
    void scanNotExistingPath() {
        Path sourcePath = Path.of("src/test/resources/shaobig/amateur/scanner/not_existing_folder");
        assertThrows(RuntimeException.class, () -> extensionDirectoryScanner.scan(sourcePath));
    }

}
