package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f6875a = new j() {
        public final boolean a() {
            return true;
        }

        public final boolean b() {
            return true;
        }

        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final j f6876b = new j() {
        public final boolean a() {
            return false;
        }

        public final boolean a(a aVar) {
            return false;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public final boolean b() {
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final j f6877c = new j() {
        public final boolean a() {
            return false;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public final boolean b() {
            return true;
        }

        public final boolean a(a aVar) {
            return (aVar == a.DATA_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final j f6878d = new j() {
        public final boolean a() {
            return true;
        }

        public final boolean a(a aVar) {
            return false;
        }

        public final boolean b() {
            return false;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final j f6879e = new j() {
        public final boolean a() {
            return true;
        }

        public final boolean b() {
            return true;
        }

        public final boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public final boolean a(boolean z, a aVar, c cVar) {
            return ((z && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && cVar == c.TRANSFORMED;
        }
    };

    public abstract boolean a();

    public abstract boolean a(a aVar);

    public abstract boolean a(boolean z, a aVar, c cVar);

    public abstract boolean b();
}
