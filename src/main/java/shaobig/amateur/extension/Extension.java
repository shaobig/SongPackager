package shaobig.amateur.extension;

import java.util.Locale;

public enum Extension {

    MP3,
    FLAC,
    WAV;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }

}
