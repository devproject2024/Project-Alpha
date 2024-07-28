package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.b.d;
import com.google.android.gms.b.e;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.maps.a.g;
import com.google.android.gms.maps.a.i;
import com.google.android.gms.maps.a.u;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final b f11524a;

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.f11524a = new b(this, context);
    }

    static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        final g f11525a;

        /* renamed from: b  reason: collision with root package name */
        private final ViewGroup f11526b;

        /* renamed from: c  reason: collision with root package name */
        private View f11527c;

        public a(ViewGroup viewGroup, g gVar) {
            this.f11525a = (g) s.a(gVar);
            this.f11526b = (ViewGroup) s.a(viewGroup);
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                this.f11525a.a(bundle2);
                u.a(bundle2, bundle);
                this.f11527c = (View) d.a(this.f11525a.e());
                this.f11526b.removeAllViews();
                this.f11526b.addView(this.f11527c);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void a() {
            try {
                this.f11525a.f();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b() {
            try {
                this.f11525a.a();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void c() {
            try {
                this.f11525a.b();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void d() {
            try {
                this.f11525a.g();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void e() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void f() {
            try {
                this.f11525a.c();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void g() {
            try {
                this.f11525a.d();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                this.f11525a.b(bundle2);
                u.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11524a = new b(this, context);
    }

    static class b extends com.google.android.gms.b.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f11528d;

        /* renamed from: e  reason: collision with root package name */
        private final Context f11529e;

        /* renamed from: f  reason: collision with root package name */
        private e<a> f11530f;

        /* renamed from: g  reason: collision with root package name */
        private final StreetViewPanoramaOptions f11531g;

        /* renamed from: h  reason: collision with root package name */
        private final List<f> f11532h = new ArrayList();

        b(ViewGroup viewGroup, Context context) {
            this.f11528d = viewGroup;
            this.f11529e = context;
            this.f11531g = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:20:? A[ExcHandler: e (unused com.google.android.gms.common.e), SYNTHETIC, Splitter:B:4:0x000a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.google.android.gms.b.e<com.google.android.gms.maps.StreetViewPanoramaView.a> r4) {
            /*
                r3 = this;
                r3.f11530f = r4
                com.google.android.gms.b.e<com.google.android.gms.maps.StreetViewPanoramaView$a> r4 = r3.f11530f
                if (r4 == 0) goto L_0x0062
                T r4 = r3.f8274a
                if (r4 != 0) goto L_0x0062
                android.content.Context r4 = r3.f11529e     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.d.a(r4)     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                android.content.Context r4 = r3.f11529e     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.a.y r4 = com.google.android.gms.maps.a.v.a((android.content.Context) r4)     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                android.content.Context r0 = r3.f11529e     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.b.b r0 = com.google.android.gms.b.d.a(r0)     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.StreetViewPanoramaOptions r1 = r3.f11531g     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.a.g r4 = r4.a((com.google.android.gms.b.b) r0, (com.google.android.gms.maps.StreetViewPanoramaOptions) r1)     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.b.e<com.google.android.gms.maps.StreetViewPanoramaView$a> r0 = r3.f11530f     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.StreetViewPanoramaView$a r1 = new com.google.android.gms.maps.StreetViewPanoramaView$a     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                android.view.ViewGroup r2 = r3.f11528d     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                r1.<init>(r2, r4)     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                r0.a(r1)     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                java.util.List<com.google.android.gms.maps.f> r4 = r3.f11532h     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
            L_0x0033:
                boolean r0 = r4.hasNext()     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                if (r0 == 0) goto L_0x0055
                java.lang.Object r0 = r4.next()     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.f r0 = (com.google.android.gms.maps.f) r0     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                T r1 = r3.f8274a     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.StreetViewPanoramaView$a r1 = (com.google.android.gms.maps.StreetViewPanoramaView.a) r1     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                com.google.android.gms.maps.a.g r1 = r1.f11525a     // Catch:{ RemoteException -> 0x004e, e -> 0x0062 }
                com.google.android.gms.maps.l r2 = new com.google.android.gms.maps.l     // Catch:{ RemoteException -> 0x004e, e -> 0x0062 }
                r2.<init>(r0)     // Catch:{ RemoteException -> 0x004e, e -> 0x0062 }
                r1.a((com.google.android.gms.maps.a.p) r2)     // Catch:{ RemoteException -> 0x004e, e -> 0x0062 }
                goto L_0x0033
            L_0x004e:
                r4 = move-exception
                com.google.android.gms.maps.model.d r0 = new com.google.android.gms.maps.model.d     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                r0.<init>(r4)     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                throw r0     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
            L_0x0055:
                java.util.List<com.google.android.gms.maps.f> r4 = r3.f11532h     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                r4.clear()     // Catch:{ RemoteException -> 0x005b, e -> 0x0062 }
                return
            L_0x005b:
                r4 = move-exception
                com.google.android.gms.maps.model.d r0 = new com.google.android.gms.maps.model.d
                r0.<init>(r4)
                throw r0
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.StreetViewPanoramaView.b.a(com.google.android.gms.b.e):void");
        }
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11524a = new b(this, context);
    }
}
