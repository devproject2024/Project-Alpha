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
import com.google.android.gms.maps.a.c;
import com.google.android.gms.maps.a.h;
import com.google.android.gms.maps.a.k;
import com.google.android.gms.maps.a.u;
import com.google.android.gms.maps.a.v;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final b f11533a = new b(this);

    public static SupportMapFragment a() {
        return new SupportMapFragment();
    }

    static class a implements h {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f11534a;

        /* renamed from: b  reason: collision with root package name */
        private final c f11535b;

        public a(Fragment fragment, c cVar) {
            this.f11535b = (c) s.a(cVar);
            this.f11534a = (Fragment) s.a(fragment);
        }

        public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                u.a(bundle2, bundle3);
                this.f11535b.a(d.a(activity), googleMapOptions, bundle3);
                u.a(bundle3, bundle2);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                Bundle arguments = this.f11534a.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    u.a(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.f11535b.a(bundle2);
                u.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                com.google.android.gms.b.b a2 = this.f11535b.a(d.a(layoutInflater), d.a(viewGroup), bundle2);
                u.a(bundle2, bundle);
                return (View) d.a(a2);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void a() {
            try {
                this.f11535b.f();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b() {
            try {
                this.f11535b.a();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void c() {
            try {
                this.f11535b.b();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void d() {
            try {
                this.f11535b.g();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void e() {
            try {
                this.f11535b.c();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void f() {
            try {
                this.f11535b.d();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void g() {
            try {
                this.f11535b.e();
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                u.a(bundle, bundle2);
                this.f11535b.b(bundle2);
                u.a(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }

        public final void a(e eVar) {
            try {
                this.f11535b.a((k) new m(eVar));
            } catch (RemoteException e2) {
                throw new com.google.android.gms.maps.model.d(e2);
            }
        }
    }

    static class b extends com.google.android.gms.b.a<a> {

        /* renamed from: d  reason: collision with root package name */
        final List<e> f11536d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private final Fragment f11537e;

        /* renamed from: f  reason: collision with root package name */
        private e<a> f11538f;

        /* renamed from: g  reason: collision with root package name */
        private Activity f11539g;

        b(Fragment fragment) {
            this.f11537e = fragment;
        }

        public final void a(e<a> eVar) {
            this.f11538f = eVar;
            h();
        }

        private final void h() {
            if (this.f11539g != null && this.f11538f != null && this.f8274a == null) {
                try {
                    d.a(this.f11539g);
                    c a2 = v.a((Context) this.f11539g).a(d.a(this.f11539g));
                    if (a2 != null) {
                        this.f11538f.a(new a(this.f11537e, a2));
                        for (e a3 : this.f11536d) {
                            ((a) this.f8274a).a(a3);
                        }
                        this.f11536d.clear();
                    }
                } catch (RemoteException e2) {
                    throw new com.google.android.gms.maps.model.d(e2);
                } catch (com.google.android.gms.common.e unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(Activity activity) {
            this.f11539g = activity;
            h();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11533a.a(activity);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.f11533a.a(activity);
            GoogleMapOptions a2 = GoogleMapOptions.a(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", a2);
            this.f11533a.a(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11533a.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a2 = this.f11533a.a(layoutInflater, viewGroup, bundle);
        a2.setClickable(true);
        return a2;
    }

    public void onResume() {
        super.onResume();
        this.f11533a.b();
    }

    public void onPause() {
        this.f11533a.c();
        super.onPause();
    }

    public void onStart() {
        super.onStart();
        this.f11533a.a();
    }

    public void onStop() {
        this.f11533a.d();
        super.onStop();
    }

    public void onDestroyView() {
        this.f11533a.e();
        super.onDestroyView();
    }

    public void onDestroy() {
        this.f11533a.f();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.f11533a.g();
        super.onLowMemory();
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f11533a.b(bundle);
    }

    public final void a(e eVar) {
        s.b("getMapAsync must be called on the main thread.");
        b bVar = this.f11533a;
        if (bVar.f8274a != null) {
            ((a) bVar.f8274a).a(eVar);
        } else {
            bVar.f11536d.add(eVar);
        }
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
