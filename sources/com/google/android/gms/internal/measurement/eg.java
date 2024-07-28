package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class eg extends IOException {
    private ff zza = null;

    public eg(String str) {
        super(str);
    }

    static eg zza() {
        return new eg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static eg zzb() {
        return new eg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static eg zzc() {
        return new eg("CodedInputStream encountered a malformed varint.");
    }

    static eg zzd() {
        return new eg("Protocol message contained an invalid tag (zero).");
    }

    static eg zze() {
        return new eg("Protocol message end-group tag did not match expected tag.");
    }

    static ef zzf() {
        return new ef("Protocol message tag had invalid wire type.");
    }

    static eg zzg() {
        return new eg("Failed to parse the message.");
    }

    static eg zzh() {
        return new eg("Protocol message had invalid UTF-8.");
    }
}
