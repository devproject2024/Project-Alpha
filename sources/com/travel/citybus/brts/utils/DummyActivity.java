package com.travel.citybus.brts.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.travel.citybus.R;
import com.travel.citybus.brts.BCLLSuccessBookingActivity;
import com.travel.citybus.brts.d.a;
import com.travel.citybus.brts.f;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class DummyActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private com.travel.citybus.brts.d.a f23380a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23381b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23382c;

    /* renamed from: d  reason: collision with root package name */
    private String f23383d;

    /* renamed from: e  reason: collision with root package name */
    private String f23384e = "";

    /* renamed from: f  reason: collision with root package name */
    private HashMap f23385f;

    private View a(int i2) {
        if (this.f23385f == null) {
            this.f23385f = new HashMap();
        }
        View view = (View) this.f23385f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f23385f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<CJROrderSummary> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DummyActivity f23386a;

        a(DummyActivity dummyActivity) {
            this.f23386a = dummyActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJROrderSummary cJROrderSummary = (CJROrderSummary) obj;
            this.f23386a.a(false);
            if (cJROrderSummary != null) {
                System.out.println(String.valueOf(cJROrderSummary));
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        getWindow().addFlags(128);
        setContentView(R.layout.activity_dummy);
        if (getIntent() != null) {
            if (getIntent().hasExtra(BCLLSuccessBookingActivity.isFromPayment)) {
                this.f23381b = getIntent().getBooleanExtra(BCLLSuccessBookingActivity.isFromPayment, false);
            }
            if (getIntent().hasExtra("is_from_pg_page")) {
                this.f23382c = getIntent().getBooleanExtra("is_from_pg_page", false);
            }
            if (getIntent().hasExtra("order_id")) {
                this.f23383d = getIntent().getStringExtra("order_id");
                k.a((Object) f.d(), "TransportBrtsController.getInstance()");
                com.travel.citybus.a e2 = f.e();
                k.a((Object) e2, "TransportBrtsController.…ransportBrtsEventListener");
                String b2 = e2.b();
                k.a((Object) b2, "TransportBrtsController.…ntListener.orderDetailUrl");
                this.f23384e = b2;
                String str = this.f23384e;
                this.f23384e = str + this.f23383d;
            }
        }
        ai a2 = new al(this).a(com.travel.citybus.brts.d.a.class);
        k.a((Object) a2, "ViewModelProvider(this).…aryViewModel::class.java)");
        this.f23380a = (com.travel.citybus.brts.d.a) a2;
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            com.travel.citybus.brts.d.a aVar = this.f23380a;
            if (aVar == null) {
                k.a("orderSummaryViewModel");
            }
            String str2 = this.f23384e;
            boolean z = this.f23382c;
            k.c(str2, "url");
            k.c(context, "context");
            com.travel.citybus.brts.c.a aVar2 = com.travel.citybus.brts.c.a.f23202a;
            com.travel.citybus.brts.c.a.a(str2, context, z, new a.C0452a(aVar));
            a(true);
        } else {
            com.paytm.utility.b.b(context, "Error", getString(R.string.check_your_network));
        }
        com.travel.citybus.brts.d.a aVar3 = this.f23380a;
        if (aVar3 == null) {
            k.a("orderSummaryViewModel");
        }
        q qVar = this;
        aVar3.f23370a.observe(qVar, new a(this));
        com.travel.citybus.brts.d.a aVar4 = this.f23380a;
        if (aVar4 == null) {
            k.a("orderSummaryViewModel");
        }
        aVar4.f23371b.observe(qVar, new b(this));
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        LinearLayout linearLayout = (LinearLayout) a(R.id.processingLayout);
        k.a((Object) linearLayout, "processingLayout");
        linearLayout.setVisibility(z ? 0 : 8);
    }

    public final void onDestroy() {
        super.onDestroy();
        if (getWindow() != null) {
            Window window = getWindow();
            if (window == null) {
                k.a();
            }
            window.clearFlags(67108864);
            Window window2 = getWindow();
            if (window2 == null) {
                k.a();
            }
            window2.clearFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            Window window3 = getWindow();
            if (window3 == null) {
                k.a();
            }
            window3.clearFlags(128);
        }
    }

    static final class b<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DummyActivity f23387a;

        b(DummyActivity dummyActivity) {
            this.f23387a = dummyActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f23387a.a(false);
        }
    }
}
