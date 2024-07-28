package net.one97.paytm.passbook.cashbackVoucher;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRCashWalletResponse;
import net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse;
import net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse;
import net.one97.paytm.passbook.cashbackVoucher.a;
import net.one97.paytm.passbook.cashbackVoucher.c;
import net.one97.paytm.passbook.cashbackVoucher.d;
import net.one97.paytm.passbook.landing.repositories.e;
import net.one97.paytm.passbook.mapping.a.f;

public final class CashbackVoucherActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public a f57127a;

    /* renamed from: b  reason: collision with root package name */
    public c f57128b;

    /* renamed from: c  reason: collision with root package name */
    boolean f57129c;

    /* renamed from: d  reason: collision with root package name */
    boolean f57130d;

    /* renamed from: e  reason: collision with root package name */
    public f<ListAllTemplateResponse> f57131e;

    /* renamed from: f  reason: collision with root package name */
    public f<MlvTemplateListResponse> f57132f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f57133g;

    public final View a(int i2) {
        if (this.f57133g == null) {
            this.f57133g = new HashMap();
        }
        View view = (View) this.f57133g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57133g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<f<? extends ListAllTemplateResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackVoucherActivity f57135a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRCashWalletResponse f57136b;

        b(CashbackVoucherActivity cashbackVoucherActivity, CJRCashWalletResponse cJRCashWalletResponse) {
            this.f57135a = cashbackVoucherActivity;
            this.f57136b = cJRCashWalletResponse;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f<ListAllTemplateResponse> fVar = (f) obj;
            CashbackVoucherActivity cashbackVoucherActivity = this.f57135a;
            cashbackVoucherActivity.f57129c = true;
            k.a((Object) fVar, "it");
            k.c(fVar, "<set-?>");
            cashbackVoucherActivity.f57131e = fVar;
            if (this.f57135a.f57130d) {
                this.f57135a.a().a(this.f57135a.b(), this.f57135a.c(), this.f57136b);
            }
        }
    }

    static final class c<T> implements z<f<? extends MlvTemplateListResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackVoucherActivity f57137a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRCashWalletResponse f57138b;

        c(CashbackVoucherActivity cashbackVoucherActivity, CJRCashWalletResponse cJRCashWalletResponse) {
            this.f57137a = cashbackVoucherActivity;
            this.f57138b = cJRCashWalletResponse;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f<MlvTemplateListResponse> fVar = (f) obj;
            CashbackVoucherActivity cashbackVoucherActivity = this.f57137a;
            cashbackVoucherActivity.f57130d = true;
            k.a((Object) fVar, "it");
            k.c(fVar, "<set-?>");
            cashbackVoucherActivity.f57132f = fVar;
            if (this.f57137a.f57129c) {
                this.f57137a.a().a(this.f57137a.b(), this.f57137a.c(), this.f57138b);
            }
        }
    }

    public final a a() {
        a aVar = this.f57127a;
        if (aVar == null) {
            k.a("mUIHandler");
        }
        return aVar;
    }

    public final f<ListAllTemplateResponse> b() {
        f<ListAllTemplateResponse> fVar = this.f57131e;
        if (fVar == null) {
            k.a("mgvResponse");
        }
        return fVar;
    }

    public final f<MlvTemplateListResponse> c() {
        f<MlvTemplateListResponse> fVar = this.f57132f;
        if (fVar == null) {
            k.a("mlvResponse");
        }
        return fVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_cashback_voucher);
        this.f57127a = new a(this);
        ai a2 = am.a((FragmentActivity) this).a(c.class);
        k.a((Object) a2, "ViewModelProviders.of(th…herViewModel::class.java)");
        this.f57128b = (c) a2;
        ((AppCompatImageView) a(R.id.ivBackArrow)).setOnClickListener(new a(this));
        a aVar = this.f57127a;
        if (aVar == null) {
            k.a("mUIHandler");
        }
        d.a aVar2 = new d.a(R.string.pass_cbv_title_1, Integer.valueOf(R.string.pass_cbv_subtitle_1), R.string.pass_cbv_button_1, R.drawable.pass_cb_vouchers_pager_1, net.one97.paytm.passbook.d.b().a("pass2CBVoucherBrandsDeeplink"), "#0c00aced");
        d.a aVar3 = new d.a(R.string.pass_cbv_title_2, (Integer) null, R.string.pass_cbv_button_2, R.drawable.pass_cb_vouchers_pager_2, net.one97.paytm.passbook.d.b().a("pass2CBVoucherDealsDeeplink"), "#19ffad00");
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        aVar.f57139a.add(Integer.valueOf(R.color.pass_inactive_dot));
        aVar.f57139a.add(Integer.valueOf(R.color.pass_inactive_dot));
        d dVar = new d(aVar.f57141c, arrayList);
        ViewPager viewPager = (ViewPager) aVar.f57141c.a(R.id.viewPagerCBVouchers);
        k.a((Object) viewPager, "activity.viewPagerCBVouchers");
        viewPager.setAdapter(dVar);
        ViewPager viewPager2 = (ViewPager) aVar.f57141c.a(R.id.viewPagerCBVouchers);
        k.a((Object) viewPager2, "activity.viewPagerCBVouchers");
        viewPager2.setPageMargin(20);
        aVar.a(0);
        ((ViewPager) aVar.f57141c.a(R.id.viewPagerCBVouchers)).addOnPageChangeListener(new a.b(aVar));
        if (this.f57127a == null) {
            k.a("mUIHandler");
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.lottieLoader);
        k.a((Object) lottieAnimationView, "lottieLoader");
        a.a(lottieAnimationView, true);
        c cVar = this.f57128b;
        if (cVar == null) {
            k.a("mViewModel");
        }
        net.one97.paytm.passbook.landing.repositories.d.f57772b.b().observeForever(new c.a(cVar));
        c cVar2 = this.f57128b;
        if (cVar2 == null) {
            k.a("mViewModel");
        }
        e.f57775b.b().observeForever(new c.b(cVar2));
        Serializable serializableExtra = getIntent().getSerializableExtra("cashWalletResponseKey");
        if (!(serializableExtra instanceof CJRCashWalletResponse)) {
            serializableExtra = null;
        }
        CJRCashWalletResponse cJRCashWalletResponse = (CJRCashWalletResponse) serializableExtra;
        c cVar3 = this.f57128b;
        if (cVar3 == null) {
            k.a("mViewModel");
        }
        cVar3.f57154a.observeForever(new b(this, cJRCashWalletResponse));
        c cVar4 = this.f57128b;
        if (cVar4 == null) {
            k.a("mViewModel");
        }
        cVar4.f57155b.observeForever(new c(this, cJRCashWalletResponse));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashbackVoucherActivity f57134a;

        a(CashbackVoucherActivity cashbackVoucherActivity) {
            this.f57134a = cashbackVoucherActivity;
        }

        public final void onClick(View view) {
            this.f57134a.onBackPressed();
        }
    }
}
