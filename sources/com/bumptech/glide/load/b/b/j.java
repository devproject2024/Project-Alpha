package com.bumptech.glide.load.b.b;

import androidx.core.g.e;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.g;
import com.bumptech.glide.g.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final g<com.bumptech.glide.load.g, String> f6803a = new g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final e.a<a> f6804b = com.bumptech.glide.g.a.a.a(10, new a.C0091a<a>() {
        public final /* synthetic */ Object a() {
            return b();
        }

        private static a b() {
            try {
                return new a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });

    public final String a(com.bumptech.glide.load.g gVar) {
        String b2;
        synchronized (this.f6803a) {
            b2 = this.f6803a.b(gVar);
        }
        if (b2 == null) {
            b2 = b(gVar);
        }
        synchronized (this.f6803a) {
            this.f6803a.b(gVar, b2);
        }
        return b2;
    }

    private String b(com.bumptech.glide.load.g gVar) {
        a aVar = (a) com.bumptech.glide.g.j.a(this.f6804b.a(), "Argument must not be null");
        try {
            gVar.updateDiskCacheKey(aVar.f6806a);
            return k.a(aVar.f6806a.digest());
        } finally {
            this.f6804b.a(aVar);
        }
    }

    static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f6806a;

        /* renamed from: b  reason: collision with root package name */
        private final b f6807b = new b.a();

        a(MessageDigest messageDigest) {
            this.f6806a = messageDigest;
        }

        public final b e_() {
            return this.f6807b;
        }
    }
}
