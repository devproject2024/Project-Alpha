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
import com.google.android.gms.b.e;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.maps.a.d;
import com.google.android.gms.maps.a.h;
import com.google.android.gms.maps.a.u;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final b f11506a;

    public MapView(Context context) {
        super(context);
        this.f11506a = new b(this, context, (GoogleMapOptions) null);
        setClickable(true);
    }

    static class a implements h {

        /* renamed from: a  reason: collision with root package name */
        final d f11507a;

        /* renamed from: b  reason: collision with root package name */
        private final ViewGroup f11508b;

        /* renamed from: c  reason: collision with root package name */
        private View f11509c;

        public a(ViewGroup viewGroup, d dVar) {
            this.f11507a = (d) s.a(dVar);
            this.f11508b = (ViewGroup) s.a(viewGroup);
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                this.f11507a.a(bundle2);
                u.a(bundle2, bundle);
                this.f11509c = (View) com.google.android.gms.b.d.a(this.f11507a.e());
                this.f11508b.removeAllViews();
                this.f11508b.addView(this.f11509c);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public final void a() {
            try {
                this.f11507a.f();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b() {
            try {
                this.f11507a.a();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void c() {
            try {
                this.f11507a.b();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void d() {
            try {
                this.f11507a.g();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void e() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public final void f() {
            try {
                this.f11507a.c();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void g() {
            try {
                this.f11507a.d();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                this.f11507a.b(bundle2);
                u.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }
    }

    static class b extends com.google.android.gms.b.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f11510d;

        /* renamed from: e  reason: collision with root package name */
        private final Context f11511e;

        /* renamed from: f  reason: collision with root package name */
        private e<a> f11512f;

        /* renamed from: g  reason: collision with root package name */
        private final GoogleMapOptions f11513g;

        /* renamed from: h  reason: collision with root package name */
        private final List<e> f11514h = new ArrayList();

        b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f11510d = viewGroup;
            this.f11511e = context;
            this.f11513g = googleMapOptions;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:? A[ExcHandler: e (unused com.google.android.gms.common.e), SYNTHETIC, Splitter:B:4:0x000a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.google.android.gms.b.e<com.google.android.gms.maps.MapView.a> r4) {
            /*
                r3 = this;
                r3.f11512f = r4
                com.google.android.gms.b.e<com.google.android.gms.maps.MapView$a> r4 = r3.f11512f
                if (r4 == 0) goto L_0x0065
                T r4 = r3.f8274a
                if (r4 != 0) goto L_0x0065
                android.content.Context r4 = r3.f11511e     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.d.a(r4)     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                android.content.Context r4 = r3.f11511e     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.a.y r4 = com.google.android.gms.maps.a.v.a((android.content.Context) r4)     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                android.content.Context r0 = r3.f11511e     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.b.b r0 = com.google.android.gms.b.d.a(r0)     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.GoogleMapOptions r1 = r3.f11513g     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.a.d r4 = r4.a((com.google.android.gms.b.b) r0, (com.google.android.gms.maps.GoogleMapOptions) r1)     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                if (r4 != 0) goto L_0x0024
                return
            L_0x0024:
                com.google.android.gms.b.e<com.google.android.gms.maps.MapView$a> r0 = r3.f11512f     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.MapView$a r1 = new com.google.android.gms.maps.MapView$a     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                android.view.ViewGroup r2 = r3.f11510d     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                r1.<init>(r2, r4)     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                r0.a(r1)     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                java.util.List<com.google.android.gms.maps.e> r4 = r3.f11514h     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
            L_0x0036:
                boolean r0 = r4.hasNext()     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                if (r0 == 0) goto L_0x0058
                java.lang.Object r0 = r4.next()     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.e r0 = (com.google.android.gms.maps.e) r0     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                T r1 = r3.f8274a     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.MapView$a r1 = (com.google.android.gms.maps.MapView.a) r1     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                com.google.android.gms.maps.a.d r1 = r1.f11507a     // Catch:{ RemoteException -> 0x0051, e -> 0x0065 }
                com.google.android.gms.maps.j r2 = new com.google.android.gms.maps.j     // Catch:{ RemoteException -> 0x0051, e -> 0x0065 }
                r2.<init>(r0)     // Catch:{ RemoteException -> 0x0051, e -> 0x0065 }
                r1.a((com.google.android.gms.maps.a.k) r2)     // Catch:{ RemoteException -> 0x0051, e -> 0x0065 }
                goto L_0x0036
            L_0x0051:
                r4 = move-exception
                com.google.android.gms.maps.model.d r0 = new com.google.android.gms.maps.model.d     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                r0.<init>(r4)     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                throw r0     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
            L_0x0058:
                java.util.List<com.google.android.gms.maps.e> r4 = r3.f11514h     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                r4.clear()     // Catch:{ RemoteException -> 0x005e, e -> 0x0065 }
                return
            L_0x005e:
                r4 = move-exception
                com.google.android.gms.maps.model.d r0 = new com.google.android.gms.maps.model.d
                r0.<init>(r4)
                throw r0
            L_0x0065:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.MapView.b.a(com.google.android.gms.b.e):void");
        }
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11506a = new b(this, context, GoogleMapOptions.a(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11506a = new b(this, context, GoogleMapOptions.a(context, attributeSet));
        setClickable(true);
    }
}
