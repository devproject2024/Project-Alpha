package net.one97.paytm.passbook.mlv.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.s;
import kotlin.x;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mlv.MerchantItem;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;
import net.one97.paytm.passbook.mlv.a.b;
import net.one97.paytm.passbook.mlv.activity.MLVMainActivity;
import net.one97.paytm.passbook.utility.j;

public final class b extends net.one97.paytm.passbook.utility.b implements net.one97.paytm.passbook.mgv.a.a, b.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserMLVTemplateDetail> f58063a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.passbook.mlv.e.a f58064b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.passbook.mlv.a.b f58065c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f58066d;

    public final View a(int i2) {
        if (this.f58066d == null) {
            this.f58066d = new HashMap();
        }
        View view = (View) this.f58066d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f58066d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f58066d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    /* renamed from: net.one97.paytm.passbook.mlv.b.b$b  reason: collision with other inner class name */
    static final class C1108b<T> implements z<ArrayList<MerchantItem>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58068a;

        C1108b(b bVar) {
            this.f58068a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mlv.a.b a2;
            ArrayList<MerchantItem> arrayList = (ArrayList) obj;
            q.b(arrayList.toString());
            if (arrayList != null && arrayList.size() > 0 && (a2 = this.f58068a.f58065c) != null) {
                k.c(arrayList, "merchantItemList");
                a2.f58008b = arrayList;
                a2.notifyDataSetChanged();
            }
        }
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58070a;

        d(b bVar) {
            this.f58070a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            net.one97.paytm.passbook.mlv.a.b a2 = this.f58070a.f58065c;
            if ((a2 != null ? a2.getItemCount() : 0) > 1) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f58070a.a(R.id.loadMoreView);
                k.a((Object) lottieAnimationView, "loadMoreView");
                b.a(lottieAnimationView, bool);
            } else {
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f58070a.a(R.id.centerScreenLoader);
                k.a((Object) lottieAnimationView2, "centerScreenLoader");
                b.a(lottieAnimationView2, bool);
            }
            if (!bool.booleanValue()) {
                LottieAnimationView lottieAnimationView3 = (LottieAnimationView) this.f58070a.a(R.id.loadMoreView);
                k.a((Object) lottieAnimationView3, "loadMoreView");
                b.a(lottieAnimationView3, Boolean.FALSE);
                LottieAnimationView lottieAnimationView4 = (LottieAnimationView) this.f58070a.a(R.id.centerScreenLoader);
                k.a((Object) lottieAnimationView4, "centerScreenLoader");
                b.a(lottieAnimationView4, Boolean.FALSE);
            }
        }
    }

    static final class e<T> implements z<s<? extends Integer, ? extends IJRPaytmDataModel, ? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58071a;

        e(b bVar) {
            this.f58071a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = (s) obj;
            if (sVar != null && !j.a(this.f58071a.getContext(), (NetworkCustomError) sVar.getThird())) {
                this.f58071a.getClass().getSimpleName();
                j.a((Activity) this.f58071a.getActivity(), (Throwable) sVar.getThird());
            }
        }
    }

    static final class f<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58072a;

        f(b bVar) {
            this.f58072a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                str = this.f58072a.getString(R.string.some_went_wrong);
            }
            net.one97.paytm.passbook.mapping.c.a(this.f58072a.getContext(), this.f58072a.getString(R.string.error), str);
        }
    }

    static final class g<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58073a;

        g(b bVar) {
            this.f58073a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.e eVar = (net.one97.paytm.passbook.mapping.a.e) obj;
            if (eVar != null) {
                this.f58073a.a((DialogInterface.OnClickListener) new a(this, eVar), (DialogInterface.OnClickListener) new C1109b(this, eVar));
            }
        }

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f58074a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f58075b;

            a(g gVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f58074a = gVar;
                this.f58075b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                b.b(this.f58074a.f58073a).a(this.f58075b);
            }
        }

        /* renamed from: net.one97.paytm.passbook.mlv.b.b$g$b  reason: collision with other inner class name */
        static final class C1109b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f58076a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f58077b;

            C1109b(g gVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f58076a = gVar;
                this.f58077b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                FragmentActivity activity = this.f58076a.f58073a.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    static final class h<T> implements z<ArrayList<UserMLVTemplateDetail>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58078a;

        h(b bVar) {
            this.f58078a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mlv.a.b a2;
            this.f58078a.f58063a = (ArrayList) obj;
            if (this.f58078a.f58063a == null) {
                net.one97.paytm.passbook.mapping.c.a(this.f58078a.getActivity(), this.f58078a.getString(R.string.error), this.f58078a.getString(R.string.no_mlv_template_found), new DialogInterface.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ h f58079a;

                    {
                        this.f58079a = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        FragmentActivity activity = this.f58079a.f58078a.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
                return;
            }
            ArrayList c2 = this.f58078a.f58063a;
            if (c2 != null && (a2 = this.f58078a.f58065c) != null) {
                a2.a(c2);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.passbook.mlv.e.a b(b bVar) {
        net.one97.paytm.passbook.mlv.e.a aVar = bVar.f58064b;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.passbook_loyality_fragment, viewGroup, false);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.mlv.e.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ateViewModel::class.java)");
        this.f58064b = (net.one97.paytm.passbook.mlv.e.a) a2;
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        net.one97.paytm.passbook.mlv.a.b bVar;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) a(R.id.ivBack)).setOnClickListener(new a(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvPurchasedVouchers);
        k.a((Object) recyclerView, "rvPurchasedVouchers");
        recyclerView.setLayoutManager(linearLayoutManager);
        this.f58065c = new net.one97.paytm.passbook.mlv.a.b(this);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvPurchasedVouchers);
        k.a((Object) recyclerView2, "rvPurchasedVouchers");
        recyclerView2.setAdapter(this.f58065c);
        ArrayList<UserMLVTemplateDetail> arrayList = this.f58063a;
        if (!(arrayList == null || (bVar = this.f58065c) == null)) {
            bVar.a(arrayList);
        }
        net.one97.paytm.passbook.mlv.a.b bVar2 = this.f58065c;
        if (bVar2 != null) {
            bVar2.f58009c = this;
        }
        ((TextView) a(R.id.knowMoreTv)).setOnClickListener(new c(this));
        net.one97.paytm.passbook.mlv.e.a aVar = this.f58064b;
        if (aVar == null) {
            k.a("viewModel");
        }
        androidx.lifecycle.q qVar = this;
        aVar.f58101c.observe(qVar, new d(this));
        net.one97.paytm.passbook.mlv.e.a aVar2 = this.f58064b;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        aVar2.f58106h.observe(qVar, new e(this));
        net.one97.paytm.passbook.mlv.e.a aVar3 = this.f58064b;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        aVar3.f58107i.observe(qVar, new f(this));
        net.one97.paytm.passbook.mlv.e.a aVar4 = this.f58064b;
        if (aVar4 == null) {
            k.a("viewModel");
        }
        aVar4.f58102d.observe(qVar, new g(this));
        net.one97.paytm.passbook.mlv.e.a aVar5 = this.f58064b;
        if (aVar5 == null) {
            k.a("viewModel");
        }
        aVar5.f58104f.observe(qVar, new h(this));
        net.one97.paytm.passbook.mlv.e.a aVar6 = this.f58064b;
        if (aVar6 == null) {
            k.a("viewModel");
        }
        aVar6.f58103e.observe(qVar, new i(this));
        net.one97.paytm.passbook.mlv.e.a aVar7 = this.f58064b;
        if (aVar7 == null) {
            k.a("viewModel");
        }
        aVar7.f58105g.observe(qVar, new C1108b(this));
        net.one97.paytm.passbook.mlv.e.a aVar8 = this.f58064b;
        if (aVar8 == null) {
            k.a("viewModel");
        }
        aVar8.a();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58067a;

        a(b bVar) {
            this.f58067a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f58067a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58069a;

        c(b bVar) {
            this.f58069a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.d.b().a((Context) this.f58069a.getActivity(), net.one97.paytm.passbook.d.b().a("mlvKnowMoreUrl"), this.f58069a.getString(R.string.pass_loyality_gv_text));
        }
    }

    public final void b() {
        net.one97.paytm.passbook.mlv.e.a aVar = this.f58064b;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.a();
    }

    public final void b(int i2) {
        Intent intent = new Intent(getContext(), MLVMainActivity.class);
        ArrayList<UserMLVTemplateDetail> arrayList = this.f58063a;
        intent.putExtra("data", arrayList != null ? arrayList.get(i2) : null);
        startActivity(intent);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 3) {
            this.f58063a = null;
            net.one97.paytm.passbook.mlv.e.a aVar = this.f58064b;
            if (aVar == null) {
                k.a("viewModel");
            }
            aVar.f58099a = 0;
            aVar.j.clear();
            aVar.k = false;
            aVar.l = false;
            net.one97.paytm.passbook.mlv.e.a aVar2 = this.f58064b;
            if (aVar2 == null) {
                k.a("viewModel");
            }
            aVar2.a();
        }
    }

    static final class i<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58080a;

        i(b bVar) {
            this.f58080a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity = this.f58080a.getActivity();
            if (activity != null) {
                activity.getClass().getCanonicalName();
                j.a(activity, new NetworkCustomError(), true, true);
            }
        }
    }
}
