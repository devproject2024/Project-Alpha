package com.google.firebase.perf.internal;

import com.paytm.contactsSdk.constant.ContactsConstant;

enum aa {
    NETWORK(ContactsConstant.NETWORK, 10, 700, 10, 70),
    TRACE("trace", 10, 300, 10, 30);
    
    private final String zzex;
    private final int zzey;
    private final int zzez;
    private final int zzfa;
    private final int zzfb;

    private aa(String str, int i2, int i3, int i4, int i5) {
        this.zzex = str;
        this.zzey = 10;
        this.zzez = i3;
        this.zzfa = 10;
        this.zzfb = i5;
    }

    public final int zzbr() {
        return this.zzey;
    }

    public final int zzbs() {
        return this.zzez;
    }

    public final int zzbt() {
        return this.zzfa;
    }

    public final int zzbu() {
        return this.zzfb;
    }

    public final String zzbv() {
        return String.valueOf(this.zzex).concat("_flimit_time");
    }

    public final String zzbw() {
        return String.valueOf(this.zzex).concat("_flimit_events");
    }

    public final String zzbx() {
        return String.valueOf(this.zzex).concat("_blimit_time");
    }

    public final String zzby() {
        return String.valueOf(this.zzex).concat("_blimit_events");
    }

    public final String toString() {
        return name();
    }
}
