package androidx.media;

import android.media.AudioAttributes;

final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f3828a;

    /* renamed from: b  reason: collision with root package name */
    int f3829b = -1;

    b() {
    }

    public final int hashCode() {
        return this.f3828a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f3828a.equals(((b) obj).f3828a);
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3828a;
    }
}
