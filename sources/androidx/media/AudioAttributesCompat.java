package androidx.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.c;

public class AudioAttributesCompat implements c {

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f3749b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f3750c = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};

    /* renamed from: a  reason: collision with root package name */
    a f3751a;

    static int a(int i2, int i3) {
        if ((i2 & 1) == 1) {
            return 7;
        }
        if ((i2 & 4) == 4) {
            return 6;
        }
        switch (i3) {
            case 0:
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3749b = sparseIntArray;
        sparseIntArray.put(5, 1);
        f3749b.put(6, 2);
        f3749b.put(7, 2);
        f3749b.put(8, 1);
        f3749b.put(9, 1);
        f3749b.put(10, 1);
    }

    AudioAttributesCompat() {
    }

    public int hashCode() {
        return this.f3751a.hashCode();
    }

    public String toString() {
        return this.f3751a.toString();
    }

    static String a(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage ".concat(String.valueOf(i2));
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        a aVar = this.f3751a;
        if (aVar != null) {
            return aVar.equals(audioAttributesCompat.f3751a);
        }
        if (audioAttributesCompat.f3751a == null) {
            return true;
        }
        return false;
    }
}
