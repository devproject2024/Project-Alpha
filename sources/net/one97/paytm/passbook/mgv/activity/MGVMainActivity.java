package net.one97.paytm.passbook.mgv.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.s;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.mgv.CardTemplate;
import net.one97.paytm.passbook.beans.mgv.UserCardDetail;
import net.one97.paytm.passbook.beans.mgv.UserTemplateDetail;
import net.one97.paytm.passbook.mgv.a.c;
import net.one97.paytm.passbook.mgv.c.a;
import net.one97.paytm.passbook.utility.j;

public final class MGVMainActivity extends BaseActivity implements net.one97.paytm.passbook.mgv.a.a, c.C1100c {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.mgv.a.c f57918a;

    /* renamed from: b  reason: collision with root package name */
    private String f57919b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public UserTemplateDetail f57920c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.passbook.mgv.c.a f57921d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f57922e;

    public final View a(int i2) {
        if (this.f57922e == null) {
            this.f57922e = new HashMap();
        }
        View view = (View) this.f57922e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57922e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVMainActivity f57924a;

        b(MGVMainActivity mGVMainActivity) {
            this.f57924a = mGVMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (this.f57924a.a().getItemCount() > 1) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f57924a.a(R.id.loadMoreView);
                k.a((Object) lottieAnimationView, "loadMoreView");
                MGVMainActivity.a(lottieAnimationView, bool);
                return;
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f57924a.a(R.id.centerScreenLoader);
            k.a((Object) lottieAnimationView2, "centerScreenLoader");
            MGVMainActivity.a(lottieAnimationView2, bool);
        }
    }

    static final class c<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVMainActivity f57925a;

        c(MGVMainActivity mGVMainActivity) {
            this.f57925a = mGVMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.e eVar = (net.one97.paytm.passbook.mapping.a.e) obj;
            if (eVar != null) {
                this.f57925a.a((DialogInterface.OnClickListener) new a(this, eVar), (DialogInterface.OnClickListener) new b(this, eVar));
            }
        }

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f57926a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f57927b;

            a(c cVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f57926a = cVar;
                this.f57927b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                MGVMainActivity.a(this.f57926a.f57925a).a(this.f57927b);
            }
        }

        static final class b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f57928a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f57929b;

            b(c cVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f57928a = cVar;
                this.f57929b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f57928a.f57925a.finish();
            }
        }
    }

    static final class d<T> implements z<ArrayList<UserCardDetail>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVMainActivity f57930a;

        d(MGVMainActivity mGVMainActivity) {
            this.f57930a = mGVMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            MGVMainActivity.a(this.f57930a, (ArrayList) obj);
        }
    }

    static final class e<T> implements z<s<? extends Integer, ? extends IJRPaytmDataModel, ? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVMainActivity f57931a;

        e(MGVMainActivity mGVMainActivity) {
            this.f57931a = mGVMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = (s) obj;
            if (sVar != null && !j.a((Context) this.f57931a, (NetworkCustomError) sVar.getThird())) {
                this.f57931a.getClass().getSimpleName();
                j.a((Activity) this.f57931a, (Throwable) sVar.getThird());
            }
        }
    }

    static final class f<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVMainActivity f57932a;

        f(MGVMainActivity mGVMainActivity) {
            this.f57932a = mGVMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                str = this.f57932a.getString(R.string.some_went_wrong);
            }
            MGVMainActivity mGVMainActivity = this.f57932a;
            net.one97.paytm.passbook.mapping.c.a((Context) mGVMainActivity, mGVMainActivity.getString(R.string.error), str);
        }
    }

    static final class g<T> implements z<UserTemplateDetail> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVMainActivity f57933a;

        g(MGVMainActivity mGVMainActivity) {
            this.f57933a = mGVMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f57933a.f57920c = (UserTemplateDetail) obj;
            if (this.f57933a.f57920c == null) {
                MGVMainActivity mGVMainActivity = this.f57933a;
                net.one97.paytm.passbook.mapping.c.a(mGVMainActivity, mGVMainActivity.getString(R.string.error), this.f57933a.getString(R.string.no_template_found), new DialogInterface.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ g f57934a;

                    {
                        this.f57934a = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f57934a.f57933a.finish();
                    }
                });
                return;
            }
            net.one97.paytm.passbook.mgv.c.a a2 = MGVMainActivity.a(this.f57933a);
            UserTemplateDetail b2 = this.f57933a.f57920c;
            if (b2 == null) {
                k.a();
            }
            a2.a(b2.getCardTemplate().getId());
            UserTemplateDetail b3 = this.f57933a.f57920c;
            if (b3 != null) {
                this.f57933a.a().a(b3);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.passbook.mgv.c.a a(MGVMainActivity mGVMainActivity) {
        net.one97.paytm.passbook.mgv.c.a aVar = mGVMainActivity.f57921d;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public final net.one97.paytm.passbook.mgv.a.c a() {
        net.one97.paytm.passbook.mgv.a.c cVar = this.f57918a;
        if (cVar == null) {
            k.a("adapter");
        }
        return cVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_mgvmain);
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.passbook.mgv.c.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ainViewModel::class.java)");
        this.f57921d = (net.one97.paytm.passbook.mgv.c.a) a2;
        Intent intent = getIntent();
        String str = null;
        this.f57920c = (UserTemplateDetail) (intent != null ? intent.getSerializableExtra("data") : null);
        if (this.f57920c == null) {
            Intent intent2 = getIntent();
            if (intent2 != null) {
                str = intent2.getStringExtra("id");
            }
            this.f57919b = str;
            if (this.f57919b == null) {
                finish();
                return;
            }
        }
        ((ImageView) a(R.id.ivBack)).setOnClickListener(new a(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvPurchasedVouchers);
        k.a((Object) recyclerView, "rvPurchasedVouchers");
        recyclerView.setLayoutManager(linearLayoutManager);
        this.f57918a = new net.one97.paytm.passbook.mgv.a.c(this);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvPurchasedVouchers);
        k.a((Object) recyclerView2, "rvPurchasedVouchers");
        net.one97.paytm.passbook.mgv.a.c cVar = this.f57918a;
        if (cVar == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(cVar);
        UserTemplateDetail userTemplateDetail = this.f57920c;
        if (userTemplateDetail != null) {
            net.one97.paytm.passbook.mgv.a.c cVar2 = this.f57918a;
            if (cVar2 == null) {
                k.a("adapter");
            }
            cVar2.a(userTemplateDetail);
        }
        net.one97.paytm.passbook.mgv.a.c cVar3 = this.f57918a;
        if (cVar3 == null) {
            k.a("adapter");
        }
        cVar3.f57906a = this;
        net.one97.paytm.passbook.mgv.c.a aVar = this.f57921d;
        if (aVar == null) {
            k.a("viewModel");
        }
        q qVar = this;
        aVar.f57965c.observe(qVar, new b(this));
        net.one97.paytm.passbook.mgv.c.a aVar2 = this.f57921d;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        aVar2.f57966d.observe(qVar, new c(this));
        net.one97.paytm.passbook.mgv.c.a aVar3 = this.f57921d;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        aVar3.f57967e.observe(qVar, new d(this));
        net.one97.paytm.passbook.mgv.c.a aVar4 = this.f57921d;
        if (aVar4 == null) {
            k.a("viewModel");
        }
        aVar4.f57968f.observe(qVar, new e(this));
        net.one97.paytm.passbook.mgv.c.a aVar5 = this.f57921d;
        if (aVar5 == null) {
            k.a("viewModel");
        }
        aVar5.f57969g.observe(qVar, new f(this));
        net.one97.paytm.passbook.mgv.c.a aVar6 = this.f57921d;
        if (aVar6 == null) {
            k.a("viewModel");
        }
        aVar6.f57970h.observe(qVar, new g(this));
        if (this.f57920c != null) {
            net.one97.paytm.passbook.mgv.c.a aVar7 = this.f57921d;
            if (aVar7 == null) {
                k.a("viewModel");
            }
            UserTemplateDetail userTemplateDetail2 = this.f57920c;
            if (userTemplateDetail2 == null) {
                k.a();
            }
            aVar7.a(userTemplateDetail2.getCardTemplate().getId());
            return;
        }
        net.one97.paytm.passbook.mgv.c.a aVar8 = this.f57921d;
        if (aVar8 == null) {
            k.a("viewModel");
        }
        String str2 = this.f57919b;
        if (str2 == null) {
            k.a();
        }
        k.c(str2, "mTemplateId");
        if (!aVar8.j) {
            net.one97.paytm.passbook.mgv.b.a aVar9 = net.one97.paytm.passbook.mgv.b.a.f57962a;
            Application application = aVar8.getApplication();
            k.a((Object) application, "getApplication()");
            aVar8.a(net.one97.paytm.passbook.mgv.b.a.a(application, new a.c(aVar8, str2), new a.d(aVar8)));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVMainActivity f57923a;

        a(MGVMainActivity mGVMainActivity) {
            this.f57923a = mGVMainActivity;
        }

        public final void onClick(View view) {
            this.f57923a.onBackPressed();
        }
    }

    public final void b(int i2) {
        net.one97.paytm.passbook.mgv.a.c cVar = this.f57918a;
        if (cVar == null) {
            k.a("adapter");
        }
        UserCardDetail userCardDetail = cVar.f57907b.get(i2);
        k.a((Object) userCardDetail, "mUserCardsList.get(index)");
        Intent intent = new Intent(this, MGVTransactionsActivity.class);
        Serializable serializable = userCardDetail;
        intent.putExtra("data", serializable);
        intent.putExtra("userTemplateDetail", this.f57920c);
        intent.putExtra("mgvUserCardDetail", serializable);
        startActivity(intent);
    }

    public final void b() {
        net.one97.paytm.passbook.mgv.c.a aVar = this.f57921d;
        if (aVar == null) {
            k.a("viewModel");
        }
        UserTemplateDetail userTemplateDetail = this.f57920c;
        if (userTemplateDetail == null) {
            k.a();
        }
        aVar.a(userTemplateDetail.getCardTemplate().getId());
    }

    public final void c() {
        net.one97.paytm.passbook.d.b().a("paytmmp://cash_wallet?featuretype=scanner", (Activity) this);
    }

    public final void d() {
        CardTemplate cardTemplate;
        String storeFrontUrl;
        UserTemplateDetail userTemplateDetail = this.f57920c;
        if (userTemplateDetail != null && (cardTemplate = userTemplateDetail.getCardTemplate()) != null && (storeFrontUrl = cardTemplate.getStoreFrontUrl()) != null) {
            if (storeFrontUrl.length() > 0) {
                net.one97.paytm.passbook.d.b().a(storeFrontUrl, (Activity) this);
            }
        }
    }

    public static final /* synthetic */ void a(MGVMainActivity mGVMainActivity, ArrayList arrayList) {
        if (arrayList != null) {
            net.one97.paytm.passbook.mgv.a.c cVar = mGVMainActivity.f57918a;
            if (cVar == null) {
                k.a("adapter");
            }
            k.c(arrayList, "data");
            cVar.f57907b = arrayList;
        }
        net.one97.paytm.passbook.mgv.a.c cVar2 = mGVMainActivity.f57918a;
        if (cVar2 == null) {
            k.a("adapter");
        }
        cVar2.f57908c = arrayList != null && arrayList.size() == 0;
        net.one97.paytm.passbook.mgv.a.c cVar3 = mGVMainActivity.f57918a;
        if (cVar3 == null) {
            k.a("adapter");
        }
        cVar3.notifyDataSetChanged();
    }
}
