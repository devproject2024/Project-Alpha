package net.one97.paytm.passbook.mlv.b;

import android.app.Activity;
import android.app.Dialog;
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
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.s;
import kotlin.x;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mlv.MLVAccountTransactionInfo;
import net.one97.paytm.passbook.beans.mlv.MLVAmount;
import net.one97.paytm.passbook.beans.mlv.MLVUserCardDetail;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;
import net.one97.paytm.passbook.mlv.a.a;
import net.one97.paytm.passbook.mlv.activity.MLVTransactionDetailActivity;
import net.one97.paytm.passbook.utility.j;

public final class c extends net.one97.paytm.i.f implements net.one97.paytm.passbook.mgv.a.a, a.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MLVAccountTransactionInfo> f58081a = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.passbook.mlv.a.a f58082b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.passbook.mlv.e.b f58083c;

    /* renamed from: d  reason: collision with root package name */
    private MLVUserCardDetail f58084d;

    /* renamed from: e  reason: collision with root package name */
    private UserMLVTemplateDetail f58085e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f58086f;

    public final View b(int i2) {
        if (this.f58086f == null) {
            this.f58086f = new HashMap();
        }
        View view = (View) this.f58086f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f58086f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58088a;

        b(c cVar) {
            this.f58088a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            net.one97.paytm.passbook.mlv.a.a a2 = this.f58088a.f58082b;
            if ((a2 != null ? a2.getItemCount() : 0) > 1) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f58088a.b(R.id.loadMoreView);
                k.a((Object) lottieAnimationView, "loadMoreView");
                c.a(lottieAnimationView, bool);
                return;
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f58088a.b(R.id.centerScreenLoader);
            k.a((Object) lottieAnimationView2, "centerScreenLoader");
            c.a(lottieAnimationView2, bool);
        }
    }

    /* renamed from: net.one97.paytm.passbook.mlv.b.c$c  reason: collision with other inner class name */
    static final class C1110c<T> implements z<s<? extends Integer, ? extends IJRPaytmDataModel, ? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58089a;

        C1110c(c cVar) {
            this.f58089a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = (s) obj;
            if (sVar != null && !j.a(this.f58089a.getContext(), (NetworkCustomError) sVar.getThird())) {
                this.f58089a.getClass().getSimpleName();
                j.a((Activity) this.f58089a.getActivity(), (Throwable) sVar.getThird());
            }
        }
    }

    static final class d<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58090a;

        d(c cVar) {
            this.f58090a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                str = this.f58090a.getString(R.string.some_went_wrong);
            }
            net.one97.paytm.passbook.mapping.c.a(this.f58090a.getContext(), this.f58090a.getString(R.string.error), str);
        }
    }

    static final class e<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58091a;

        e(c cVar) {
            this.f58091a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.e eVar = (net.one97.paytm.passbook.mapping.a.e) obj;
            if (eVar != null) {
                net.one97.paytm.passbook.mapping.a.a(eVar, this.f58091a.getActivity(), new a(this, eVar));
            }
        }

        static final class a implements DialogInterface.OnCancelListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f58092a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f58093b;

            a(e eVar, net.one97.paytm.passbook.mapping.a.e eVar2) {
                this.f58092a = eVar;
                this.f58093b = eVar2;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.f58092a.f58091a.dismiss();
            }
        }
    }

    static final class f<T> implements z<ArrayList<MLVAccountTransactionInfo>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58094a;

        f(c cVar) {
            this.f58094a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            c cVar = this.f58094a;
            k.a((Object) arrayList, "it");
            cVar.f58081a = arrayList;
            if (this.f58094a.f58081a == null) {
                net.one97.paytm.passbook.mapping.c.a(this.f58094a.getActivity(), this.f58094a.getString(R.string.error), this.f58094a.getString(R.string.no_mlv_found), new DialogInterface.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ f f58095a;

                    {
                        this.f58095a = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        FragmentActivity activity = this.f58095a.f58094a.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
                return;
            }
            net.one97.paytm.passbook.mlv.a.a a2 = this.f58094a.f58082b;
            if (a2 != null) {
                a2.a(arrayList);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.pass_mlv_transaction_history, viewGroup, false);
        this.f58083c = (net.one97.paytm.passbook.mlv.e.b) am.a((Fragment) this).a(net.one97.paytm.passbook.mlv.e.b.class);
        return inflate;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        y<x> yVar;
        y<ArrayList<MLVAccountTransactionInfo>> yVar2;
        y<net.one97.paytm.passbook.mapping.a.e> yVar3;
        y<String> yVar4;
        y<s<Integer, IJRPaytmDataModel, NetworkCustomError>> yVar5;
        y<Boolean> yVar6;
        MLVAmount totalAmount;
        MLVAmount availableAmount;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        if (arguments != null && arguments.containsKey("mgvUserCardDetail")) {
            Bundle arguments2 = getArguments();
            this.f58084d = (MLVUserCardDetail) (arguments2 != null ? arguments2.getSerializable("mgvUserCardDetail") : null);
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null && arguments3.containsKey("userTemplateDetail")) {
            Bundle arguments4 = getArguments();
            this.f58085e = (UserMLVTemplateDetail) (arguments4 != null ? arguments4.getSerializable("userTemplateDetail") : null);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = (RecyclerView) b(R.id.rvTransactionHistory);
        k.a((Object) recyclerView, "rvTransactionHistory");
        recyclerView.setLayoutManager(linearLayoutManager);
        this.f58082b = new net.one97.paytm.passbook.mlv.a.a(this, this.f58085e);
        RecyclerView recyclerView2 = (RecyclerView) b(R.id.rvTransactionHistory);
        k.a((Object) recyclerView2, "rvTransactionHistory");
        recyclerView2.setAdapter(this.f58082b);
        ArrayList<MLVAccountTransactionInfo> arrayList = this.f58081a;
        net.one97.paytm.passbook.mlv.a.a aVar = this.f58082b;
        if (aVar != null) {
            aVar.a(arrayList);
        }
        net.one97.paytm.passbook.mlv.a.a aVar2 = this.f58082b;
        if (aVar2 != null) {
            aVar2.f57997b = this;
        }
        MLVUserCardDetail mLVUserCardDetail = this.f58084d;
        String expiredTime = mLVUserCardDetail != null ? mLVUserCardDetail.getExpiredTime() : null;
        if (expiredTime != null) {
            try {
                MLVUserCardDetail mLVUserCardDetail2 = this.f58084d;
                String amount = (mLVUserCardDetail2 == null || (availableAmount = mLVUserCardDetail2.getAvailableAmount()) == null) ? null : availableAmount.getAmount();
                MLVUserCardDetail mLVUserCardDetail3 = this.f58084d;
                if (!(mLVUserCardDetail3 == null || (totalAmount = mLVUserCardDetail3.getTotalAmount()) == null)) {
                    str = totalAmount.getAmount();
                }
                if (!TextUtils.isEmpty(amount)) {
                    if ((amount != null ? Long.parseLong(amount) : 0) > 0) {
                        String string = getString(R.string.rs_balance, net.one97.paytm.passbook.utility.c.b(amount));
                        String string2 = getString(R.string.rs_balance, net.one97.paytm.passbook.utility.c.b(str));
                        long j = net.one97.paytm.passbook.mapping.a.j(expiredTime, "yyyy-MM-dd HH:mm:ss");
                        String a2 = net.one97.paytm.passbook.mapping.a.a(j, "d MMM yyyy");
                        if (System.currentTimeMillis() > j) {
                            TextView textView = (TextView) b(R.id.tv_text_expire);
                            k.a((Object) textView, "tv_text_expire");
                            textView.setVisibility(8);
                        } else {
                            TextView textView2 = (TextView) b(R.id.tv_text_expire);
                            k.a((Object) textView2, "tv_text_expire");
                            textView2.setText(getString(R.string.balance_text_expire, string, string2, a2));
                            TextView textView3 = (TextView) b(R.id.tv_text_expire);
                            k.a((Object) textView3, "tv_text_expire");
                            textView3.setVisibility(0);
                        }
                    }
                }
            } catch (NumberFormatException | ParseException unused) {
            }
        }
        ((ImageView) b(R.id.iv_close)).setOnClickListener(new a(this));
        net.one97.paytm.passbook.mlv.e.b bVar = this.f58083c;
        if (!(bVar == null || (yVar6 = bVar.f58114c) == null)) {
            yVar6.observe(this, new b(this));
        }
        net.one97.paytm.passbook.mlv.e.b bVar2 = this.f58083c;
        if (!(bVar2 == null || (yVar5 = bVar2.f58117f) == null)) {
            yVar5.observe(this, new C1110c(this));
        }
        net.one97.paytm.passbook.mlv.e.b bVar3 = this.f58083c;
        if (!(bVar3 == null || (yVar4 = bVar3.f58118g) == null)) {
            yVar4.observe(this, new d(this));
        }
        net.one97.paytm.passbook.mlv.e.b bVar4 = this.f58083c;
        if (!(bVar4 == null || (yVar3 = bVar4.f58115d) == null)) {
            yVar3.observe(this, new e(this));
        }
        net.one97.paytm.passbook.mlv.e.b bVar5 = this.f58083c;
        if (!(bVar5 == null || (yVar2 = bVar5.f58116e) == null)) {
            yVar2.observe(this, new f(this));
        }
        net.one97.paytm.passbook.mlv.e.b bVar6 = this.f58083c;
        if (!(bVar6 == null || (yVar = bVar6.f58113b) == null)) {
            yVar.observe(this, new g(this));
        }
        a();
    }

    public final void b() {
        a();
    }

    public final void a(int i2) {
        if (this.f58081a.size() > 0) {
            Intent intent = new Intent(getActivity(), MLVTransactionDetailActivity.class);
            intent.putExtra("mglUserCardDetail", this.f58084d);
            intent.putExtra("userTemplateDetail", this.f58085e);
            intent.putExtra("data", this.f58081a.get(i2));
            startActivity(intent);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58087a;

        a(c cVar) {
            this.f58087a = cVar;
        }

        public final void onClick(View view) {
            this.f58087a.dismiss();
        }
    }

    public static void a(LottieAnimationView lottieAnimationView, Boolean bool) {
        k.c(lottieAnimationView, "walletLoader");
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            lottieAnimationView.setVisibility(0);
            net.one97.paytm.passbook.utility.a.a(lottieAnimationView);
            return;
        }
        lottieAnimationView.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(lottieAnimationView);
    }

    private final void a() {
        String cardNo;
        net.one97.paytm.passbook.mlv.e.b bVar;
        MLVUserCardDetail mLVUserCardDetail = this.f58084d;
        if (mLVUserCardDetail != null && (cardNo = mLVUserCardDetail.getCardNo()) != null && (bVar = this.f58083c) != null) {
            bVar.a(cardNo);
        }
    }

    static final class g<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f58096a;

        g(c cVar) {
            this.f58096a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity = this.f58096a.getActivity();
            if (activity != null) {
                activity.getClass().getCanonicalName();
                j.a(activity, new NetworkCustomError(), true, false);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f58086f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
