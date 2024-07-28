package com.travel.travels.b;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.R;
import com.travel.d;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.i.h;

public final class b extends h implements com.travel.common.a.b {

    /* renamed from: a  reason: collision with root package name */
    private CJRCatalogItem f28478a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f28479b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f28480c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            Serializable serializable = null;
            if ((arguments != null ? arguments.getSerializable("catalogItem") : null) instanceof CJRCatalogItem) {
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    serializable = arguments2.getSerializable("catalogItem");
                }
                if (serializable != null) {
                    this.f28478a = (CJRCatalogItem) serializable;
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRCatalogItem");
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_container, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f28479b) {
            a();
            this.f28479b = false;
        }
    }

    /* renamed from: com.travel.travels.b.b$b  reason: collision with other inner class name */
    static final class C0494b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f28482a;

        C0494b(b bVar) {
            this.f28482a = bVar;
        }

        public final void run() {
            if (!this.f28482a.isAdded() || this.f28482a.isDetached()) {
                this.f28482a.f28479b = true;
            } else {
                this.f28482a.a();
            }
        }
    }

    public final void onVisibleToUser(boolean z) {
        new Handler().post(new C0494b(this));
    }

    public final void onVisibilityGone() {
        this.f28479b = false;
        new Handler().post(new a(this));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f28481a;

        a(b bVar) {
            this.f28481a = bVar;
        }

        public final void run() {
            if (this.f28481a.isAdded() && !this.f28481a.isDetached()) {
                b.c(this.f28481a);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        k.a((Object) d.a(), "TravelController.getInstance()");
        com.travel.common.b b2 = d.b();
        k.a((Object) b2, "TravelController.getInstance().travelListener");
        Fragment b3 = b2.b();
        if (getFragmentManager() != null) {
            j fragmentManager = getFragmentManager();
            if (fragmentManager == null) {
                k.a();
            }
            q a2 = fragmentManager.a();
            k.a((Object) a2, "fragmentManager!!.beginTransaction()");
            Bundle bundle = new Bundle();
            bundle.putSerializable("bundle_extra_category_item", this.f28478a);
            bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
            bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
            bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
            bundle.putBoolean("disable-pagination", true);
            bundle.putBoolean("is-offer", true);
            k.a((Object) b3, "fragment");
            b3.setArguments(bundle);
            a2.a(R.id.fragmentContainer, b3);
            a2.b();
        }
    }

    public static final /* synthetic */ void c(b bVar) {
        if (bVar.getFragmentManager() != null) {
            j fragmentManager = bVar.getFragmentManager();
            if (fragmentManager == null) {
                k.a();
            }
            Fragment c2 = fragmentManager.c(R.id.fragmentContainer);
            if (c2 != null) {
                j fragmentManager2 = bVar.getFragmentManager();
                if (fragmentManager2 == null) {
                    k.a();
                }
                q a2 = fragmentManager2.a();
                k.a((Object) a2, "fragmentManager!!.beginTransaction()");
                a2.a(c2);
                a2.b();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f28480c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
