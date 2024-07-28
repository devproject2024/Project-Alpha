package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.R;
import androidx.navigation.g;
import androidx.navigation.h;
import androidx.navigation.k;
import androidx.navigation.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class NavHostFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private h f3884a;

    /* renamed from: b  reason: collision with root package name */
    private int f3885b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3886c;

    public static h a(Fragment fragment) {
        h hVar;
        h hVar2;
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).a();
            }
            Fragment fragment3 = fragment2.requireFragmentManager().n;
            if (fragment3 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment3).a();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            View view2 = view;
            while (true) {
                hVar = null;
                if (view2 == null) {
                    break;
                }
                Object tag = view2.getTag(R.id.nav_controller_view_tag);
                if (tag instanceof WeakReference) {
                    hVar2 = (h) ((WeakReference) tag).get();
                } else if (tag instanceof h) {
                    hVar2 = (h) tag;
                } else {
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    hVar = hVar2;
                    break;
                }
                ViewParent parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            if (hVar != null) {
                return hVar;
            }
            throw new IllegalStateException("View " + view + " does not have a NavController set");
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    public final h a() {
        h hVar = this.f3884a;
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.f3886c) {
            requireFragmentManager().a().e(this).b();
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        this.f3884a = new h(requireContext());
        this.f3884a.f3904g.a((s<? extends k>) new b(requireContext(), getChildFragmentManager(), getId()));
        int i2 = 0;
        Bundle bundle3 = null;
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f3886c = true;
                requireFragmentManager().a().e(this).b();
            }
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            h hVar = this.f3884a;
            if (bundle2 != null) {
                bundle2.setClassLoader(hVar.f3898a.getClassLoader());
                hVar.f3900c = bundle2.getBundle("android-support-nav:controller:navigatorState");
                hVar.f3901d = bundle2.getIntArray("android-support-nav:controller:backStackIds");
                hVar.f3902e = bundle2.getParcelableArray("android-support-nav:controller:backStackArgs");
            }
        }
        int i3 = this.f3885b;
        if (i3 != 0) {
            this.f3884a.a(i3, (Bundle) null);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            i2 = arguments.getInt("android-support-nav:fragment:graphId");
        }
        if (arguments != null) {
            bundle3 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
        }
        if (i2 != 0) {
            this.f3884a.a(i2, bundle3);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        frameLayout.setId(getId());
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            if (view.getParent() != null) {
                view = (View) view.getParent();
            }
            view.setTag(R.id.nav_controller_view_tag, this.f3884a);
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavHostFragment);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavHostFragment_navGraph, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false);
        if (resourceId != 0) {
            this.f3885b = resourceId;
        }
        if (z) {
            this.f3886c = true;
        }
        obtainStyledAttributes.recycle();
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2;
        super.onSaveInstanceState(bundle);
        h hVar = this.f3884a;
        ArrayList arrayList = new ArrayList();
        Bundle bundle3 = new Bundle();
        for (Map.Entry next : hVar.f3904g.f3965b.entrySet()) {
            String str = (String) next.getKey();
            Bundle c2 = ((s) next.getValue()).c();
            if (c2 != null) {
                arrayList.add(str);
                bundle3.putBundle(str, c2);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle2 = new Bundle();
            bundle3.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle2.putBundle("android-support-nav:controller:navigatorState", bundle3);
        } else {
            bundle2 = null;
        }
        if (!hVar.f3903f.isEmpty()) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            int[] iArr = new int[hVar.f3903f.size()];
            Parcelable[] parcelableArr = new Parcelable[hVar.f3903f.size()];
            int i2 = 0;
            for (g next2 : hVar.f3903f) {
                iArr[i2] = next2.f3896a.f3921e;
                parcelableArr[i2] = next2.f3897b;
                i2++;
            }
            bundle2.putIntArray("android-support-nav:controller:backStackIds", iArr);
            bundle2.putParcelableArray("android-support-nav:controller:backStackArgs", parcelableArr);
        }
        if (bundle2 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", bundle2);
        }
        if (this.f3886c) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
    }
}
