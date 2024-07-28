package com.travel.train.k;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import com.travel.train.model.trainticket.CJRTrainCity;
import kotlin.g.b.k;

public final class g implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private a f27665a;

    public enum b {
        LS,
        REVIEWITINERARY,
        BOOKING,
        PNR_STATUS,
        V2_HOME,
        LIVE_STATUS,
        SEARCHBYTRAIN,
        SELECT_CITY
    }

    public g(a aVar) {
        k.c(aVar, "builder");
        this.f27665a = aVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        T t;
        k.c(cls, "modelClass");
        T t2 = null;
        switch (h.f27674a[this.f27665a.f27673h.ordinal()]) {
            case 1:
                if (cls.isAssignableFrom(f.class)) {
                    com.travel.train.a.a aVar = this.f27665a.f27666a;
                    if (aVar != null) {
                        t2 = new f(aVar);
                    }
                    return (ai) t2;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            case 2:
                if (cls.isAssignableFrom(a.class)) {
                    com.travel.train.a.a aVar2 = this.f27665a.f27666a;
                    if (aVar2 != null) {
                        t2 = new a(aVar2);
                    }
                    return (ai) t2;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            case 3:
                if (cls.isAssignableFrom(c.class)) {
                    com.travel.train.a.a aVar3 = this.f27665a.f27666a;
                    if (aVar3 != null) {
                        t2 = new c(aVar3, this.f27665a.f27667b);
                    }
                    return (ai) t2;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            case 4:
                if (cls.isAssignableFrom(com.travel.train.l.a.class)) {
                    com.travel.train.a.a aVar4 = this.f27665a.f27666a;
                    if (aVar4 != null) {
                        t2 = new com.travel.train.l.a(aVar4);
                    }
                    return (ai) t2;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            case 5:
                if (cls.isAssignableFrom(d.class)) {
                    com.travel.train.a.a aVar5 = this.f27665a.f27666a;
                    if (aVar5 != null) {
                        t2 = new d(aVar5);
                    }
                    return (ai) t2;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            case 6:
                if (cls.isAssignableFrom(e.class)) {
                    com.travel.train.a.a aVar6 = this.f27665a.f27666a;
                    if (aVar6 != null) {
                        t2 = new e(aVar6);
                    }
                    return (ai) t2;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            case 7:
                if (cls.isAssignableFrom(b.class)) {
                    com.travel.train.a.a aVar7 = this.f27665a.f27666a;
                    if (aVar7 != null) {
                        t2 = new b(aVar7);
                    }
                    return (ai) t2;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            case 8:
                if (cls.isAssignableFrom(com.travel.train.l.b.class)) {
                    com.travel.train.a.a aVar8 = this.f27665a.f27666a;
                    if (aVar8 != null) {
                        Application application = this.f27665a.f27668c;
                        if (application == null) {
                            k.a("mApplication");
                        }
                        t = new com.travel.train.l.b(aVar8, application, this.f27665a.f27669d, this.f27665a.f27670e, this.f27665a.f27671f, this.f27665a.f27672g);
                    } else {
                        t = null;
                    }
                    return (ai) t;
                }
                throw new IllegalArgumentException("ViewModel Not Found");
            default:
                throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(cls)));
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        com.travel.train.a.a f27666a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f27667b;

        /* renamed from: c  reason: collision with root package name */
        public Application f27668c;

        /* renamed from: d  reason: collision with root package name */
        public String f27669d;

        /* renamed from: e  reason: collision with root package name */
        public String f27670e;

        /* renamed from: f  reason: collision with root package name */
        public CJRTrainCity f27671f;

        /* renamed from: g  reason: collision with root package name */
        public String f27672g;

        /* renamed from: h  reason: collision with root package name */
        b f27673h;

        public a(b bVar) {
            k.c(bVar, "type");
            this.f27673h = bVar;
        }

        public final a a(com.travel.train.a.a aVar) {
            k.c(aVar, "repository");
            this.f27666a = aVar;
            return this;
        }
    }
}
