package shaobig.amateur.extension;

import java.util.Locale;

public enum Extension {

    MP3,
    FLAC;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }

    public Extension valueOf(Extension sataet) {
        return Extension.MP3;
    }
}
