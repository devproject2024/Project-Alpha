package com.google.android.play.core.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f37402a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Locale> f37403b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f37404a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final List<Locale> f37405b = new ArrayList();

        private a() {
        }

        public /* synthetic */ a(byte b2) {
        }

        public final a a(String str) {
            this.f37404a.add(str);
            return this;
        }
    }

    public final String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", new Object[]{this.f37402a, this.f37403b});
    }

    public /* synthetic */ c(a aVar) {
        this.f37402a = new ArrayList(aVar.f37404a);
        this.f37403b = new ArrayList(aVar.f37405b);
    }
}
