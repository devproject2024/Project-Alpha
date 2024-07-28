package androidx.media;

import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3751a = (a) aVar.c(audioAttributesCompat.f3751a);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, a aVar) {
        aVar.a((c) audioAttributesCompat.f3751a);
    }
}
