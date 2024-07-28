package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

public class gp extends IOException {
    private hn zzcmk = null;

    public gp(String str) {
        super(str);
    }

    public final gp zzg(hn hnVar) {
        this.zzcmk = hnVar;
        return this;
    }

    static gp zzve() {
        return new gp("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static gp zzvf() {
        return new gp("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static gp zzvg() {
        return new gp("Protocol message contained an invalid tag (zero).");
    }

    static gs zzvh() {
        return new gs("Protocol message tag had invalid wire type.");
    }

    static gp zzvi() {
        return new gp("Failed to parse the message.");
    }

    static gp zzvj() {
        return new gp("Protocol message had invalid UTF-8.");
    }
}
