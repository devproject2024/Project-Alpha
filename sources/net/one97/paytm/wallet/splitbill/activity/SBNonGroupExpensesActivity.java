package net.one97.paytm.wallet.splitbill.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.utility.a;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.j;
import net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse.SBNonGroupExpensesBaseResponse;
import net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse.SBRequestHistory;

public class SBNonGroupExpensesActivity extends PaytmActivity implements j.a {

    /* renamed from: a  reason: collision with root package name */
    private ShimmerFrameLayout f72019a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f72020b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f72021c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f72022d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f72023e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f72024f = true;

    /* renamed from: g  reason: collision with root package name */
    private int f72025g = 0;

    /* renamed from: h  reason: collision with root package name */
    private List<SBRequestHistory> f72026h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private LottieAnimationView f72027i;
    private j j;
    /* access modifiers changed from: private */
    public RecyclerView k;
    private Button l;
    private Button m;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_non_group_expenses);
        this.f72019a = (ShimmerFrameLayout) findViewById(R.id.shimmer_lyt);
        this.f72020b = (RelativeLayout) findViewById(R.id.lyt_no_group_expenses);
        this.f72023e = (ImageView) findViewById(R.id.split_back_button);
        this.f72027i = (LottieAnimationView) findViewById(R.id.lav_lottie_loader);
        this.f72021c = (RelativeLayout) findViewById(R.id.sb_no_internet_layout);
        this.f72022d = (RelativeLayout) findViewById(R.id.sb_technical_issue_layout);
        this.l = (Button) findViewById(R.id.no_internet_try_again);
        this.m = (Button) findViewById(R.id.technical_error_try_again);
        this.k = (RecyclerView) findViewById(R.id.data_history_widget_rv);
        this.k.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.k.setItemAnimator(new g());
        this.j = new j(this, this);
        this.k.setAdapter(this.j);
        this.f72023e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBNonGroupExpensesActivity.this.finish();
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.c((Context) SBNonGroupExpensesActivity.this)) {
                    SBNonGroupExpensesActivity.this.b();
                    return;
                }
                SBNonGroupExpensesActivity.this.f72021c.setVisibility(0);
                SBNonGroupExpensesActivity.this.k.setVisibility(8);
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.c((Context) SBNonGroupExpensesActivity.this)) {
                    SBNonGroupExpensesActivity.this.b();
                    return;
                }
                SBNonGroupExpensesActivity.this.f72021c.setVisibility(0);
                SBNonGroupExpensesActivity.this.k.setVisibility(8);
            }
        });
    }

    public void onResume() {
        super.onResume();
        a(true);
        if (b.c((Context) this)) {
            b();
            return;
        }
        this.f72021c.setVisibility(0);
        a(false);
        this.k.setVisibility(8);
    }

    public final void b() {
        String str;
        if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getNonGroupExpensesUrl"))) {
            str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getNonGroupExpensesUrl") + "?limit=10&offset=0";
        } else {
            str = "https://prms.paytmbank.com/prms/ext/v1/user/requests?limit=10&offset=0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        hashMap2.put("fetchstrategy", "NGRP");
        hashMap2.put("user-token", a.q(this));
        new net.one97.paytm.network.a(str, new SBNonGroupExpensesBaseResponse(), hashMap, hashMap2, a.c.WALLET, a.b.SILENT, SBNonGroupExpensesActivity.class.getSimpleName()).c().observeForever(new z() {
            public final void onChanged(Object obj) {
                SBNonGroupExpensesActivity.this.b((f) obj);
            }
        });
    }

    private void a(SBNonGroupExpensesBaseResponse sBNonGroupExpensesBaseResponse, boolean z) {
        if (sBNonGroupExpensesBaseResponse == null || sBNonGroupExpensesBaseResponse.getResponse() == null || sBNonGroupExpensesBaseResponse.getResponse().getRequestHistoryList() == null) {
            this.k.setVisibility(8);
            this.f72021c.setVisibility(8);
            this.f72022d.setVisibility(0);
            return;
        }
        this.f72020b.setVisibility(8);
        this.f72021c.setVisibility(8);
        this.k.setVisibility(0);
        if (!sBNonGroupExpensesBaseResponse.getResponse().getNextPage().booleanValue()) {
            this.f72024f = false;
        } else {
            this.f72025g = Integer.valueOf(sBNonGroupExpensesBaseResponse.getResponse().getOffset()).intValue();
        }
        if (sBNonGroupExpensesBaseResponse.getResponse().getRequestHistoryList().size() != 0) {
            if (!z) {
                this.f72026h.clear();
            }
            this.f72026h.addAll(sBNonGroupExpensesBaseResponse.getResponse().getRequestHistoryList());
            this.j.f71843b = net.one97.paytm.wallet.splitbill.e.a.a(this.f72026h);
            this.j.notifyDataSetChanged();
            return;
        }
        this.f72020b.setVisibility(0);
    }

    public final void a() {
        String str;
        if (this.f72024f) {
            net.one97.paytm.common.widgets.a.a(this.f72027i);
            int i2 = this.f72025g;
            if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getNonGroupExpensesUrl"))) {
                str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getNonGroupExpensesUrl") + "?limit=10&offset=0";
            } else {
                str = "https://prms.paytmbank.com/prms/ext/v1/user/requests?limit=10&offset=".concat(String.valueOf(i2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            HashMap hashMap2 = new HashMap();
            hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
            hashMap2.put("fetchstrategy", "NGRP");
            hashMap2.put("user-token", com.paytm.utility.a.q(this));
            new net.one97.paytm.network.a(str, new SBNonGroupExpensesBaseResponse(), hashMap, hashMap2, a.c.WALLET, a.b.SILENT, SBNonGroupExpensesActivity.class.getSimpleName()).c().observeForever(new z() {
                public final void onChanged(Object obj) {
                    SBNonGroupExpensesActivity.this.a((f) obj);
                }
            });
        }
    }

    private void a(boolean z) {
        if (z) {
            this.f72019a.setVisibility(0);
            this.f72019a.a();
            this.k.setVisibility(8);
            return;
        }
        this.f72019a.setVisibility(8);
        this.f72019a.b();
        this.k.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(false);
            net.one97.paytm.common.widgets.a.b(this.f72027i);
            this.f72020b.setVisibility(8);
            this.f72021c.setVisibility(8);
            if (fVar.f55797b instanceof SBNonGroupExpensesBaseResponse) {
                a((SBNonGroupExpensesBaseResponse) fVar.f55797b, true);
                return;
            }
            this.k.setVisibility(8);
            this.f72021c.setVisibility(8);
            this.f72022d.setVisibility(0);
        } else if (fVar.f55796a == h.ERROR) {
            a(false);
            net.one97.paytm.common.widgets.a.b(this.f72027i);
            net.one97.paytm.network.g gVar = fVar.f55798c;
            if (gVar == null) {
                return;
            }
            if (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this, gVar.f55801c, SBNonGroupExpensesActivity.class.getName(), (Bundle) null, false);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(false);
            net.one97.paytm.common.widgets.a.b(this.f72027i);
            this.f72020b.setVisibility(8);
            this.f72021c.setVisibility(8);
            if (fVar.f55797b instanceof SBNonGroupExpensesBaseResponse) {
                a((SBNonGroupExpensesBaseResponse) fVar.f55797b, false);
                return;
            }
            this.k.setVisibility(8);
            this.f72021c.setVisibility(8);
            this.f72022d.setVisibility(0);
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.network.g gVar = fVar.f55798c;
            a(false);
            net.one97.paytm.common.widgets.a.b(this.f72027i);
            this.k.setVisibility(8);
            this.f72021c.setVisibility(8);
            this.f72022d.setVisibility(0);
            if (gVar == null) {
                return;
            }
            if (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this, gVar.f55801c, SBNonGroupExpensesActivity.class.getName(), (Bundle) null, false);
            }
        }
    }
}
