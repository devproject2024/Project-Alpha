package net.one97.paytm.passbook.mgv.activity;

import android.app.Activity;
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
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.mgv.AccountTransactionInfo;
import net.one97.paytm.passbook.beans.mgv.UserCardDetail;
import net.one97.paytm.passbook.beans.mgv.UserTemplateDetail;
import net.one97.paytm.passbook.mgv.a.b;
import net.one97.paytm.passbook.utility.j;

public final class MGVTransactionsActivity extends BaseActivity implements net.one97.paytm.passbook.mgv.a.a {

    /* renamed from: a  reason: collision with root package name */
    public UserTemplateDetail f57944a;

    /* renamed from: b  reason: collision with root package name */
    public UserCardDetail f57945b;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.passbook.mgv.a.b f57946c;

    /* renamed from: d  reason: collision with root package name */
    public UserCardDetail f57947d;

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.passbook.mgv.c.b f57948e;

    /* renamed from: f  reason: collision with root package name */
    private g f57949f = new g(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f57950g;

    public final View a(int i2) {
        if (this.f57950g == null) {
            this.f57950g = new HashMap();
        }
        View view = (View) this.f57950g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57950g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionsActivity f57952a;

        b(MGVTransactionsActivity mGVTransactionsActivity) {
            this.f57952a = mGVTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (this.f57952a.a().getItemCount() > 1) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f57952a.a(R.id.loadMoreView);
                k.a((Object) lottieAnimationView, "loadMoreView");
                MGVTransactionsActivity.a(lottieAnimationView, bool);
                return;
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f57952a.a(R.id.centerScreenLoader);
            k.a((Object) lottieAnimationView2, "centerScreenLoader");
            MGVTransactionsActivity.a(lottieAnimationView2, bool);
        }
    }

    static final class c<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionsActivity f57953a;

        c(MGVTransactionsActivity mGVTransactionsActivity) {
            this.f57953a = mGVTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.e eVar = (net.one97.paytm.passbook.mapping.a.e) obj;
            if (eVar != null) {
                this.f57953a.a((DialogInterface.OnClickListener) new a(this, eVar), (DialogInterface.OnClickListener) new b(this, eVar));
            }
        }

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f57954a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f57955b;

            a(c cVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f57954a = cVar;
                this.f57955b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                net.one97.paytm.passbook.mgv.c.b bVar = this.f57954a.f57953a.f57948e;
                if (bVar == null) {
                    k.a("viewModel");
                }
                bVar.a(this.f57955b);
            }
        }

        static final class b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f57956a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f57957b;

            b(c cVar, net.one97.paytm.passbook.mapping.a.e eVar) {
                this.f57956a = cVar;
                this.f57957b = eVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f57956a.f57953a.finish();
            }
        }
    }

    static final class d<T> implements z<ArrayList<AccountTransactionInfo>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionsActivity f57958a;

        d(MGVTransactionsActivity mGVTransactionsActivity) {
            this.f57958a = mGVTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            MGVTransactionsActivity.a(this.f57958a, (ArrayList) obj);
        }
    }

    static final class e<T> implements z<s<? extends Integer, ? extends IJRPaytmDataModel, ? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionsActivity f57959a;

        e(MGVTransactionsActivity mGVTransactionsActivity) {
            this.f57959a = mGVTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = (s) obj;
            if (sVar != null && !j.a((Context) this.f57959a, (NetworkCustomError) sVar.getThird())) {
                this.f57959a.getClass().getSimpleName();
                j.a((Activity) this.f57959a, (Throwable) sVar.getThird());
            }
        }
    }

    static final class f<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionsActivity f57960a;

        f(MGVTransactionsActivity mGVTransactionsActivity) {
            this.f57960a = mGVTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                str = this.f57960a.getString(R.string.some_went_wrong);
            }
            MGVTransactionsActivity mGVTransactionsActivity = this.f57960a;
            net.one97.paytm.passbook.mapping.c.a((Context) mGVTransactionsActivity, mGVTransactionsActivity.getString(R.string.error), str);
        }
    }

    public final net.one97.paytm.passbook.mgv.a.b a() {
        net.one97.paytm.passbook.mgv.a.b bVar = this.f57946c;
        if (bVar == null) {
            k.a("adapter");
        }
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_mgv_transactions);
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.passbook.mgv.c.b.class);
        k.a((Object) a2, "ViewModelProviders.of(th…onsViewModel::class.java)");
        this.f57948e = (net.one97.paytm.passbook.mgv.c.b) a2;
        Serializable serializableExtra = getIntent().getSerializableExtra("data");
        if (serializableExtra != null) {
            this.f57945b = (UserCardDetail) serializableExtra;
            Serializable serializableExtra2 = getIntent().getSerializableExtra("userTemplateDetail");
            if (serializableExtra2 != null) {
                this.f57944a = (UserTemplateDetail) serializableExtra2;
                Serializable serializableExtra3 = getIntent().getSerializableExtra("mgvUserCardDetail");
                if (serializableExtra3 != null) {
                    this.f57947d = (UserCardDetail) serializableExtra3;
                    ((ImageView) a(R.id.ivBack)).setOnClickListener(new a(this));
                    RecyclerView recyclerView = (RecyclerView) a(R.id.transactionsRv);
                    k.a((Object) recyclerView, "transactionsRv");
                    recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
                    UserTemplateDetail userTemplateDetail = this.f57944a;
                    if (userTemplateDetail == null) {
                        k.a("mUserTemplateDetail");
                    }
                    UserCardDetail userCardDetail = this.f57945b;
                    if (userCardDetail == null) {
                        k.a("mUserCardDetail");
                    }
                    this.f57946c = new net.one97.paytm.passbook.mgv.a.b(userTemplateDetail, userCardDetail, this);
                    RecyclerView recyclerView2 = (RecyclerView) a(R.id.transactionsRv);
                    k.a((Object) recyclerView2, "transactionsRv");
                    net.one97.paytm.passbook.mgv.a.b bVar = this.f57946c;
                    if (bVar == null) {
                        k.a("adapter");
                    }
                    recyclerView2.setAdapter(bVar);
                    net.one97.paytm.passbook.mgv.a.b bVar2 = this.f57946c;
                    if (bVar2 == null) {
                        k.a("adapter");
                    }
                    bVar2.f57895b = this.f57949f;
                    net.one97.paytm.passbook.mgv.c.b bVar3 = this.f57948e;
                    if (bVar3 == null) {
                        k.a("viewModel");
                    }
                    q qVar = this;
                    bVar3.f57979c.observe(qVar, new b(this));
                    net.one97.paytm.passbook.mgv.c.b bVar4 = this.f57948e;
                    if (bVar4 == null) {
                        k.a("viewModel");
                    }
                    bVar4.f57980d.observe(qVar, new c(this));
                    net.one97.paytm.passbook.mgv.c.b bVar5 = this.f57948e;
                    if (bVar5 == null) {
                        k.a("viewModel");
                    }
                    bVar5.f57981e.observe(qVar, new d(this));
                    net.one97.paytm.passbook.mgv.c.b bVar6 = this.f57948e;
                    if (bVar6 == null) {
                        k.a("viewModel");
                    }
                    bVar6.f57982f.observe(qVar, new e(this));
                    net.one97.paytm.passbook.mgv.c.b bVar7 = this.f57948e;
                    if (bVar7 == null) {
                        k.a("viewModel");
                    }
                    bVar7.f57983g.observe(qVar, new f(this));
                    net.one97.paytm.passbook.mgv.c.b bVar8 = this.f57948e;
                    if (bVar8 == null) {
                        k.a("viewModel");
                    }
                    UserCardDetail userCardDetail2 = this.f57945b;
                    if (userCardDetail2 == null) {
                        k.a("mUserCardDetail");
                    }
                    String templateId = userCardDetail2.getTemplateId();
                    UserCardDetail userCardDetail3 = this.f57945b;
                    if (userCardDetail3 == null) {
                        k.a("mUserCardDetail");
                    }
                    String createTime = userCardDetail3.getCreateTime();
                    UserCardDetail userCardDetail4 = this.f57945b;
                    if (userCardDetail4 == null) {
                        k.a("mUserCardDetail");
                    }
                    String cardNo = userCardDetail4.getCardNo();
                    UserCardDetail userCardDetail5 = this.f57945b;
                    if (userCardDetail5 == null) {
                        k.a("mUserCardDetail");
                    }
                    bVar8.a(templateId, createTime, cardNo, userCardDetail5);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mgv.UserCardDetail");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mgv.UserTemplateDetail");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mgv.UserCardDetail");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionsActivity f57951a;

        a(MGVTransactionsActivity mGVTransactionsActivity) {
            this.f57951a = mGVTransactionsActivity;
        }

        public final void onClick(View view) {
            this.f57951a.onBackPressed();
        }
    }

    public static final class g implements b.C1099b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MGVTransactionsActivity f57961a;

        g(MGVTransactionsActivity mGVTransactionsActivity) {
            this.f57961a = mGVTransactionsActivity;
        }

        public final void a(int i2, int i3) {
            if (i3 != i2) {
                Intent intent = new Intent(this.f57961a, MGVTransactionDetailActivity.class);
                intent.putExtra("data", this.f57961a.a().a(i2));
                UserCardDetail userCardDetail = this.f57961a.f57947d;
                if (userCardDetail == null) {
                    k.a("mCardDetail");
                }
                intent.putExtra("mgvUserCardDetail", userCardDetail);
                UserTemplateDetail userTemplateDetail = this.f57961a.f57944a;
                if (userTemplateDetail == null) {
                    k.a("mUserTemplateDetail");
                }
                intent.putExtra("userTemplateDetail", userTemplateDetail);
                this.f57961a.startActivity(intent);
            }
        }
    }

    public final void b() {
        net.one97.paytm.passbook.mgv.c.b bVar = this.f57948e;
        if (bVar == null) {
            k.a("viewModel");
        }
        UserCardDetail userCardDetail = this.f57945b;
        if (userCardDetail == null) {
            k.a("mUserCardDetail");
        }
        String templateId = userCardDetail.getTemplateId();
        UserCardDetail userCardDetail2 = this.f57945b;
        if (userCardDetail2 == null) {
            k.a("mUserCardDetail");
        }
        String createTime = userCardDetail2.getCreateTime();
        UserCardDetail userCardDetail3 = this.f57945b;
        if (userCardDetail3 == null) {
            k.a("mUserCardDetail");
        }
        String cardNo = userCardDetail3.getCardNo();
        UserCardDetail userCardDetail4 = this.f57945b;
        if (userCardDetail4 == null) {
            k.a("mUserCardDetail");
        }
        bVar.a(templateId, createTime, cardNo, userCardDetail4);
    }

    public static final /* synthetic */ void a(MGVTransactionsActivity mGVTransactionsActivity, ArrayList arrayList) {
        if (arrayList != null) {
            net.one97.paytm.passbook.mgv.a.b bVar = mGVTransactionsActivity.f57946c;
            if (bVar == null) {
                k.a("adapter");
            }
            k.c(arrayList, "data");
            bVar.f57894a = arrayList;
            net.one97.paytm.passbook.mgv.a.b bVar2 = mGVTransactionsActivity.f57946c;
            if (bVar2 == null) {
                k.a("adapter");
            }
            bVar2.f57896c = arrayList.size() == 0;
            net.one97.paytm.passbook.mgv.a.b bVar3 = mGVTransactionsActivity.f57946c;
            if (bVar3 == null) {
                k.a("adapter");
            }
            bVar3.notifyDataSetChanged();
        }
    }
}
