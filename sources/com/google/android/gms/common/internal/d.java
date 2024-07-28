package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Account f8816a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Scope> f8817b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Scope> f8818c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<com.google.android.gms.common.api.a<?>, b> f8819d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8820e;

    /* renamed from: f  reason: collision with root package name */
    final String f8821f;

    /* renamed from: g  reason: collision with root package name */
    public final com.google.android.gms.signin.a f8822g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f8823h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f8824i;
    private final int j;
    private final View k;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f8834a;
    }

    public d(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b> map, int i2, View view, String str, String str2, com.google.android.gms.signin.a aVar, boolean z) {
        this.f8816a = account;
        this.f8817b = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f8819d = map == null ? Collections.emptyMap() : map;
        this.k = view;
        this.j = i2;
        this.f8820e = str;
        this.f8821f = str2;
        this.f8822g = aVar;
        this.f8823h = z;
        HashSet hashSet = new HashSet(this.f8817b);
        for (b bVar : this.f8819d.values()) {
            hashSet.addAll(bVar.f8834a);
        }
        this.f8818c = Collections.unmodifiableSet(hashSet);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Account f8825a;

        /* renamed from: b  reason: collision with root package name */
        public androidx.a.b<Scope> f8826b;

        /* renamed from: c  reason: collision with root package name */
        public String f8827c;

        /* renamed from: d  reason: collision with root package name */
        public String f8828d;

        /* renamed from: e  reason: collision with root package name */
        private Map<com.google.android.gms.common.api.a<?>, b> f8829e;

        /* renamed from: f  reason: collision with root package name */
        private int f8830f = 0;

        /* renamed from: g  reason: collision with root package name */
        private View f8831g;

        /* renamed from: h  reason: collision with root package name */
        private com.google.android.gms.signin.a f8832h = com.google.android.gms.signin.a.f12429a;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8833i;

        public final d a() {
            return new d(this.f8825a, this.f8826b, this.f8829e, this.f8830f, this.f8831g, this.f8827c, this.f8828d, this.f8832h, this.f8833i);
        }
    }
}
