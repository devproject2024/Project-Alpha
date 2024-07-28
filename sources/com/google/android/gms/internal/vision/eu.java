package com.google.android.gms.internal.vision;

import java.io.IOException;

public class eu extends IOException {
    private ft zzxn = null;

    public eu(String str) {
        super(str);
    }

    public final eu zzg(ft ftVar) {
        this.zzxn = ftVar;
        return this;
    }

    static eu zzgm() {
        return new eu("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static eu zzgn() {
        return new eu("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static eu zzgo() {
        return new eu("CodedInputStream encountered a malformed varint.");
    }

    static eu zzgp() {
        return new eu("Protocol message contained an invalid tag (zero).");
    }

    static eu zzgq() {
        return new eu("Protocol message end-group tag did not match expected tag.");
    }

    static et zzgr() {
        return new et("Protocol message tag had invalid wire type.");
    }

    static eu zzgs() {
        return new eu("Failed to parse the message.");
    }

    static eu zzgt() {
        return new eu("Protocol message had invalid UTF-8.");
    }
}
