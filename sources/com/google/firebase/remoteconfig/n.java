package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.g;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f39428a;

    /* renamed from: b  reason: collision with root package name */
    public final long f39429b;

    /* renamed from: c  reason: collision with root package name */
    public final long f39430c;

    /* synthetic */ n(a aVar, byte b2) {
        this(aVar);
    }

    private n(a aVar) {
        this.f39428a = aVar.f39431a;
        this.f39429b = aVar.f39432b;
        this.f39430c = aVar.f39433c;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f39431a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f39432b = 60;

        /* renamed from: c  reason: collision with root package name */
        long f39433c = g.f39375a;

        public final a a(long j) {
            if (j >= 0) {
                this.f39433c = j;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j + " is an invalid argument");
        }

        public final n a() {
            return new n(this, (byte) 0);
        }
    }
}
