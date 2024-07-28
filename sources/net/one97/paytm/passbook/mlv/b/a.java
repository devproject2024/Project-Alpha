package net.one97.paytm.passbook.mlv.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.s;
import kotlin.x;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mlv.MLVAmount;
import net.one97.paytm.passbook.beans.mlv.MLVCardTemplate;
import net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail;
import net.one97.paytm.passbook.beans.mlv.MerchantLogoInfo;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;
import net.one97.paytm.passbook.customview.CircularImageView;
import net.one97.paytm.passbook.mlv.a.c;
import net.one97.paytm.passbook.mlv.d.a;
import net.one97.paytm.passbook.utility.j;

public final class a extends net.one97.paytm.passbook.utility.b implements net.one97.paytm.passbook.mgv.a.a, c.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MLVUserCardDetail> f58045a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private UserMLVTemplateDetail f58046b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.passbook.mlv.a.c f58047c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.passbook.mlv.e.c f58048d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f58049e;

    public final View a(int i2) {
        if (this.f58049e == null) {
            this.f58049e = new HashMap();
        }
        View view = (View) this.f58049e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f58049e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f58049e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58052a;

        c(a aVar) {
            this.f58052a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            net.one97.paytm.passbook.mlv.a.c a2 = this.f58052a.f58047c;
            if ((a2 != null ? a2.getItemCount() : 0) > 1) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f58052a.a(R.id.loadMoreView);
                k.a((Object) lottieAnimationView, "loadMoreView");
                a.a(lottieAnimationView, bool);
                return;
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f58052a.a(R.id.centerScreenLoader);
            k.a((Object) lottieAnimationView2, "centerScreenLoader");
            a.a(lottieAnimationView2, bool);
        }
    }

    static final class d<T> implements z<s<? extends Integer, ? extends IJRPaytmDataModel, ? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58053a;

        d(a aVar) {
            this.f58053a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = (s) obj;
            if (sVar != null && !j.a(this.f58053a.getContext(), (NetworkCustomError) sVar.getThird())) {
                this.f58053a.getClass().getSimpleName();
                j.a((Activity) this.f58053a.getActivity(), (Throwable) sVar.getThird());
            }
        }
    }

    static final class e<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58054a;

        e(a aVar) {
            this.f58054a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                str = this.f58054a.getString(R.string.some_went_wrong);
            }
            net.one97.paytm.passbook.mapping.c.a(this.f58054a.getContext(), this.f58054a.getString(R.string.error), str);
        }
    }

    static final class f<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58055a;

        f(a aVar) {
            this.f58055a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.e eVar = (net.one97.paytm.passbook.mapping.a.e) obj;
            if (eVar != null) {
                this.f58055a.a((DialogInterface.OnClickListener) new C1107a(this, eVar), (DialogInterface.OnClickListener) new b(this, eVar));
            }
        }

        /* renamed from: net.one97.paytm.passbook.mlv.b.a$f$a  reason: collision with other inner class name */
        static final class C1107a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f58056a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f58057b;

            C1107a(f fVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f58056a = fVar;
                this.f58057b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                net.one97.paytm.passbook.mlv.e.c b2 = this.f58056a.f58055a.f58048d;
                if (b2 != null) {
                    b2.a(this.f58057b);
                }
            }
        }

        static final class b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f58058a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f58059b;

            b(f fVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f58058a = fVar;
                this.f58059b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                FragmentActivity activity = this.f58058a.f58055a.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    static final class g<T> implements z<ArrayList<MLVUserCardDetail>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58060a;

        g(a aVar) {
            this.f58060a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            a aVar = this.f58060a;
            k.a((Object) arrayList, "it");
            aVar.f58045a = arrayList;
            if (this.f58060a.f58045a == null) {
                net.one97.paytm.passbook.mapping.c.a(this.f58060a.getActivity(), this.f58060a.getString(R.string.error), this.f58060a.getString(R.string.no_mlv_found), new DialogInterface.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ g f58061a;

                    {
                        this.f58061a = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        FragmentActivity activity = this.f58061a.f58060a.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
                return;
            }
            net.one97.paytm.passbook.mlv.a.c a2 = this.f58060a.f58047c;
            if (a2 != null) {
                a2.a(arrayList);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.passbook_loyality_voucher_fragment, viewGroup, false);
        this.f58048d = (net.one97.paytm.passbook.mlv.e.c) am.a((Fragment) this).a(net.one97.paytm.passbook.mlv.e.c.class);
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        y<x> yVar;
        y<ArrayList<MLVUserCardDetail>> yVar2;
        y<net.one97.paytm.passbook.mapping.a.e> yVar3;
        y<String> yVar4;
        y<s<Integer, IJRPaytmDataModel, NetworkCustomError>> yVar5;
        y<Boolean> yVar6;
        MLVCardTemplate mlvCardTemplate;
        MerchantLogoInfo merchantLogoInfo;
        String str;
        MLVAmount totalBalance;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        MLVCardTemplate mLVCardTemplate = null;
        if (arguments != null && arguments.containsKey("data")) {
            Bundle arguments2 = getArguments();
            this.f58046b = (UserMLVTemplateDetail) (arguments2 != null ? arguments2.getSerializable("data") : null);
        }
        TextView textView = (TextView) a(R.id.amountTv);
        if (textView != null) {
            Context context = getContext();
            if (context != null) {
                int i2 = R.string.rs_balance_without_space;
                Object[] objArr = new Object[1];
                UserMLVTemplateDetail userMLVTemplateDetail = this.f58046b;
                objArr[0] = net.one97.paytm.passbook.utility.c.b((userMLVTemplateDetail == null || (totalBalance = userMLVTemplateDetail.getTotalBalance()) == null) ? null : totalBalance.getAmount());
                str = context.getString(i2, objArr);
            } else {
                str = null;
            }
            textView.setText(str);
        }
        TextView textView2 = (TextView) a(R.id.nameTv);
        k.a((Object) textView2, "nameTv");
        int i3 = R.string.loyality_cash_template;
        Object[] objArr2 = new Object[1];
        a.C1111a aVar = net.one97.paytm.passbook.mlv.d.a.f58098a;
        UserMLVTemplateDetail userMLVTemplateDetail2 = this.f58046b;
        objArr2[0] = a.C1111a.a(userMLVTemplateDetail2 != null ? userMLVTemplateDetail2.getMlvCardTemplate() : null);
        textView2.setText(getString(i3, objArr2));
        UserMLVTemplateDetail userMLVTemplateDetail3 = this.f58046b;
        String merchantImageName = (userMLVTemplateDetail3 == null || (mlvCardTemplate = userMLVTemplateDetail3.getMlvCardTemplate()) == null || (merchantLogoInfo = mlvCardTemplate.getMerchantLogoInfo()) == null) ? null : merchantLogoInfo.getMerchantImageName();
        if (!TextUtils.isEmpty(merchantImageName)) {
            w.a().a(merchantImageName).a(R.drawable.pass_merchant_icon_xxhdpi).a((ImageView) (CircularImageView) a(R.id.mgvIcon));
        }
        ((ImageView) a(R.id.ivBack)).setOnClickListener(new C1106a(this));
        ((TextView) a(R.id.tv_pay)).setOnClickListener(new b(this));
        TextView textView3 = (TextView) a(R.id.tv_pay);
        k.a((Object) textView3, "tv_pay");
        int i4 = R.string.loyality_pay_with_template;
        Object[] objArr3 = new Object[1];
        a.C1111a aVar2 = net.one97.paytm.passbook.mlv.d.a.f58098a;
        UserMLVTemplateDetail userMLVTemplateDetail4 = this.f58046b;
        objArr3[0] = a.C1111a.a(userMLVTemplateDetail4 != null ? userMLVTemplateDetail4.getMlvCardTemplate() : null);
        textView3.setText(getString(i4, objArr3));
        TextView textView4 = (TextView) a(R.id.tvPaymentAt);
        k.a((Object) textView4, "tvPaymentAt");
        int i5 = R.string.pass_loyalty_for_payments_at;
        Object[] objArr4 = new Object[1];
        a.C1111a aVar3 = net.one97.paytm.passbook.mlv.d.a.f58098a;
        UserMLVTemplateDetail userMLVTemplateDetail5 = this.f58046b;
        if (userMLVTemplateDetail5 != null) {
            mLVCardTemplate = userMLVTemplateDetail5.getMlvCardTemplate();
        }
        objArr4[0] = a.C1111a.a(mLVCardTemplate);
        textView4.setText(getString(i5, objArr4));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvEarnedVouchers);
        k.a((Object) recyclerView, "rvEarnedVouchers");
        recyclerView.setLayoutManager(linearLayoutManager);
        this.f58047c = new net.one97.paytm.passbook.mlv.a.c(this);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvEarnedVouchers);
        k.a((Object) recyclerView2, "rvEarnedVouchers");
        recyclerView2.setAdapter(this.f58047c);
        ArrayList<MLVUserCardDetail> arrayList = this.f58045a;
        net.one97.paytm.passbook.mlv.a.c cVar = this.f58047c;
        if (cVar != null) {
            cVar.a(arrayList);
        }
        net.one97.paytm.passbook.mlv.a.c cVar2 = this.f58047c;
        if (cVar2 != null) {
            cVar2.f58025b = this;
        }
        net.one97.paytm.passbook.mlv.e.c cVar3 = this.f58048d;
        if (!(cVar3 == null || (yVar6 = cVar3.f58126d) == null)) {
            yVar6.observe(this, new c(this));
        }
        net.one97.paytm.passbook.mlv.e.c cVar4 = this.f58048d;
        if (!(cVar4 == null || (yVar5 = cVar4.f58129g) == null)) {
            yVar5.observe(this, new d(this));
        }
        net.one97.paytm.passbook.mlv.e.c cVar5 = this.f58048d;
        if (!(cVar5 == null || (yVar4 = cVar5.f58130h) == null)) {
            yVar4.observe(this, new e(this));
        }
        net.one97.paytm.passbook.mlv.e.c cVar6 = this.f58048d;
        if (!(cVar6 == null || (yVar3 = cVar6.f58127e) == null)) {
            yVar3.observe(this, new f(this));
        }
        net.one97.paytm.passbook.mlv.e.c cVar7 = this.f58048d;
        if (!(cVar7 == null || (yVar2 = cVar7.f58128f) == null)) {
            yVar2.observe(this, new g(this));
        }
        net.one97.paytm.passbook.mlv.e.c cVar8 = this.f58048d;
        if (!(cVar8 == null || (yVar = cVar8.f58125c) == null)) {
            yVar.observe(this, new h(this));
        }
        a();
    }

    /* renamed from: net.one97.paytm.passbook.mlv.b.a$a  reason: collision with other inner class name */
    static final class C1106a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58050a;

        C1106a(a aVar) {
            this.f58050a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f58050a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58051a;

        b(a aVar) {
            this.f58051a = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.d.b().a("paytmmp://cash_wallet?featuretype=scanner", (Activity) this.f58051a.getActivity());
        }
    }

    public final void b(int i2) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("mgvUserCardDetail", this.f58045a.get(i2));
        bundle.putSerializable("userTemplateDetail", this.f58046b);
        cVar.setArguments(bundle);
        cVar.show(getChildFragmentManager(), c.class.getName());
    }

    public final void b() {
        a();
    }

    private final void a() {
        MLVCardTemplate mlvCardTemplate;
        String id;
        net.one97.paytm.passbook.mlv.e.c cVar;
        UserMLVTemplateDetail userMLVTemplateDetail = this.f58046b;
        if (userMLVTemplateDetail != null && (mlvCardTemplate = userMLVTemplateDetail.getMlvCardTemplate()) != null && (id = mlvCardTemplate.getId()) != null && (cVar = this.f58048d) != null) {
            cVar.a(id);
        }
    }

    static final class h<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58062a;

        h(a aVar) {
            this.f58062a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity = this.f58062a.getActivity();
            if (activity != null) {
                activity.getClass().getCanonicalName();
                j.a(activity, new NetworkCustomError(), true, false);
            }
        }
    }
}
