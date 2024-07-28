package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public class bn extends IOException {
    private cm zzkw = null;

    public bn(String str) {
        super(str);
    }

    static bn zzbl() {
        return new bn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static bn zzbm() {
        return new bn("Protocol message contained an invalid tag (zero).");
    }

    static bo zzbn() {
        return new bo("Protocol message tag had invalid wire type.");
    }

    static bn zzbo() {
        return new bn("Failed to parse the message.");
    }

    static bn zzbp() {
        return new bn("Protocol message had invalid UTF-8.");
    }

    public final bn zzg(cm cmVar) {
        this.zzkw = cmVar;
        return this;
    }
}
