package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.b.d;
import com.google.android.gms.b.e;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.maps.a.f;
import com.google.android.gms.maps.a.i;
import com.google.android.gms.maps.a.p;
import com.google.android.gms.maps.a.u;
import com.google.android.gms.maps.a.v;
import java.util.ArrayList;
import java.util.List;

public class h extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final b f11549a = new b(this);

    static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f11550a;

        /* renamed from: b  reason: collision with root package name */
        private final f f11551b;

        public a(Fragment fragment, f fVar) {
            this.f11551b = (f) s.a(fVar);
            this.f11550a = (Fragment) s.a(fragment);
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                Bundle bundle3 = new Bundle();
                u.a(bundle2, bundle3);
                this.f11551b.a(d.a(activity), bundle3);
                u.a(bundle3, bundle2);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                Bundle arguments = this.f11550a.getArguments();
                if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                    u.a(bundle2, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
                }
                this.f11551b.a(bundle2);
                u.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                com.google.android.gms.b.b a2 = this.f11551b.a(d.a(layoutInflater), d.a(viewGroup), bundle2);
                u.a(bundle2, bundle);
                return (View) d.a(a2);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void a() {
            try {
                this.f11551b.f();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b() {
            try {
                this.f11551b.a();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void c() {
            try {
                this.f11551b.b();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void d() {
            try {
                this.f11551b.g();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void e() {
            try {
                this.f11551b.c();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void f() {
            try {
                this.f11551b.d();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void g() {
            try {
                this.f11551b.e();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                this.f11551b.b(bundle2);
                u.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void a(f fVar) {
            try {
                this.f11551b.a((p) new n(fVar));
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }
    }

    static class b extends com.google.android.gms.b.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private final Fragment f11552d;

        /* renamed from: e  reason: collision with root package name */
        private e<a> f11553e;

        /* renamed from: f  reason: collision with root package name */
        private Activity f11554f;

        /* renamed from: g  reason: collision with root package name */
        private final List<f> f11555g = new ArrayList();

        b(Fragment fragment) {
            this.f11552d = fragment;
        }

        public final void a(e<a> eVar) {
            this.f11553e = eVar;
            h();
        }

        private final void h() {
            if (this.f11554f != null && this.f11553e != null && this.f8274a == null) {
                try {
                    d.a(this.f11554f);
                    this.f11553e.a(new a(this.f11552d, v.a((Context) this.f11554f).b(d.a(this.f11554f))));
                    for (f a2 : this.f11555g) {
                        ((a) this.f8274a).a(a2);
                    }
                    this.f11555g.clear();
                } catch (RemoteException e2) {
                    throw new com.google.android.gms.maps.model.d(e2);
                } catch (com.google.android.gms.common.e unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(Activity activity) {
            this.f11554f = activity;
            h();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11549a.a(activity);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.f11549a.a(activity);
            this.f11549a.a(activity, new Bundle(), bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11549a.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f11549a.a(layoutInflater, viewGroup, bundle);
    }

    public void onStart() {
        super.onStart();
        this.f11549a.a();
    }

    public void onResume() {
        super.onResume();
        this.f11549a.b();
    }

    public void onPause() {
        this.f11549a.c();
        super.onPause();
    }

    public void onStop() {
        this.f11549a.d();
        super.onStop();
    }

    public void onDestroyView() {
        this.f11549a.e();
        super.onDestroyView();
    }

    public void onDestroy() {
        this.f11549a.f();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.f11549a.g();
        super.onLowMemory();
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(h.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(h.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f11549a.b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
