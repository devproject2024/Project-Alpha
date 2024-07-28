package net.one97.paytm.upgradeKyc.editprofile.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.v;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import com.paytm.network.a;
import com.paytm.utility.b.b;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.l;
import kotlin.g.b.y;
import kotlin.x;
import net.one97.paytm.i.h;
import net.one97.paytm.landingpage.R;

public final class k extends h {

    /* renamed from: a  reason: collision with root package name */
    private final g f65892a = v.a(this, y.b(j.class), new a(this), new b(this));

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65893b;

    private View a(int i2) {
        if (this.f65893b == null) {
            this.f65893b = new HashMap();
        }
        View view = (View) this.f65893b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65893b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: private */
    public final j a() {
        return (j) this.f65892a.getValue();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        b.a aVar = com.paytm.utility.b.b.f43744a;
        Context requireContext = requireContext();
        kotlin.g.b.k.a((Object) requireContext, "requireContext()");
        b.a.C0750a a2 = b.a.a(requireContext);
        String str = a().o;
        if (str == null) {
            kotlin.g.b.k.a("profileUri");
        }
        a2.f43753a = str;
        b.a.C0750a a3 = b.a.C0750a.a(a2, a.c.HOME.name());
        a3.l = true;
        b.a.C0750a.a(a3, (AppCompatImageView) a(R.id.profileIv), (com.paytm.utility.b.b.b) null, 2);
        ((ImageView) a(R.id.profileBackIv)).setOnClickListener(new c(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f65894a;

        c(k kVar) {
            this.f65894a = kVar;
        }

        public final void onClick(View view) {
            this.f65894a.a().z.setValue(x.f47997a);
        }
    }

    public static final class a extends l implements kotlin.g.a.a<an> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final an invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            an viewModelStore = requireActivity.getViewModelStore();
            kotlin.g.b.k.a((Object) viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class b extends l implements kotlin.g.a.a<al.b> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final al.b invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            al.b defaultViewModelProviderFactory = requireActivity.getDefaultViewModelProviderFactory();
            kotlin.g.b.k.a((Object) defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65893b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
