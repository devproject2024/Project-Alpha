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
import com.paytm.utility.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.m;
import net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse.SBPagingInfo;
import net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse.SBUserHistoryBaseResponse;
import net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse.SBUserHistoryItem;
import net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse.a;

public class SBUserHistoryActivity extends PaytmActivity implements m.a {

    /* renamed from: a  reason: collision with root package name */
    private ShimmerFrameLayout f72083a;

    /* renamed from: b  reason: collision with root package name */
    private SBUserHistoryBaseResponse f72084b;

    /* renamed from: c  reason: collision with root package name */
    private SBPagingInfo f72085c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f72086d;

    /* renamed from: e  reason: collision with root package name */
    private List<a> f72087e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private m f72088f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f72089g;

    /* renamed from: h  reason: collision with root package name */
    private Button f72090h;

    /* renamed from: i  reason: collision with root package name */
    private Button f72091i;
    /* access modifiers changed from: private */
    public RelativeLayout j;
    /* access modifiers changed from: private */
    public RelativeLayout k;
    /* access modifiers changed from: private */
    public RelativeLayout l;
    private LottieAnimationView m;
    private int n = 0;
    private int o = 0;
    private List<SBUserHistoryItem> p = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_activity_user_history);
        this.f72083a = (ShimmerFrameLayout) findViewById(R.id.shimmer_lyt);
        this.f72086d = (RecyclerView) findViewById(R.id.user_transaction_recycler);
        this.f72086d.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f72088f = new m(this, this);
        this.f72086d.setItemAnimator(new g());
        this.f72086d.setAdapter(this.f72088f);
        this.f72089g = (ImageView) findViewById(R.id.split_back_button);
        this.j = (RelativeLayout) findViewById(R.id.lyt_list_and_loader);
        this.m = (LottieAnimationView) findViewById(R.id.lav_lottie_loader);
        this.k = (RelativeLayout) findViewById(R.id.sb_technical_issue_layout);
        this.l = (RelativeLayout) findViewById(R.id.sb_no_internet_layout);
        this.f72090h = (Button) findViewById(R.id.no_internet_try_again);
        this.f72091i = (Button) findViewById(R.id.technical_error_try_again);
        this.f72089g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBUserHistoryActivity.this.finish();
            }
        });
        this.f72090h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.c((Context) SBUserHistoryActivity.this)) {
                    SBUserHistoryActivity.this.a(0);
                    return;
                }
                SBUserHistoryActivity.this.j.setVisibility(8);
                SBUserHistoryActivity.this.k.setVisibility(8);
                SBUserHistoryActivity.this.l.setVisibility(0);
            }
        });
        this.f72091i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.c((Context) SBUserHistoryActivity.this)) {
                    SBUserHistoryActivity.this.a(0);
                    return;
                }
                SBUserHistoryActivity.this.j.setVisibility(8);
                SBUserHistoryActivity.this.k.setVisibility(8);
                SBUserHistoryActivity.this.l.setVisibility(0);
            }
        });
        a(true);
        if (b.c((Context) this)) {
            a(0);
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        String str;
        if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getUserHistoryURL"))) {
            str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getUserHistoryURL") + "?limit=10&offset=" + i2;
        } else {
            str = "https://prms.paytmbank.com/prms/ext/v1/activity?limit=10&offset=".concat(String.valueOf(i2));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", com.paytm.utility.a.q(this));
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        new net.one97.paytm.network.a(str, new SBUserHistoryBaseResponse(), hashMap, hashMap2).c().observeForever(new z() {
            public final void onChanged(Object obj) {
                SBUserHistoryActivity.this.a((f) obj);
            }
        });
    }

    public final void a() {
        if (this.n < this.o) {
            net.one97.paytm.common.widgets.a.a(this.m);
            a(this.n);
            return;
        }
        net.one97.paytm.common.widgets.a.b(this.m);
    }

    private void a(boolean z) {
        if (z) {
            this.f72083a.setVisibility(0);
            this.f72083a.a();
            this.f72086d.setVisibility(8);
            return;
        }
        this.f72083a.setVisibility(8);
        this.f72083a.b();
        this.f72086d.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(false);
            net.one97.paytm.common.widgets.a.b(this.m);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            if (fVar.f55797b instanceof SBUserHistoryBaseResponse) {
                this.f72084b = (SBUserHistoryBaseResponse) fVar.f55797b;
                SBUserHistoryBaseResponse sBUserHistoryBaseResponse = this.f72084b;
                if (sBUserHistoryBaseResponse == null || sBUserHistoryBaseResponse.getResponse() == null) {
                    this.j.setVisibility(8);
                    this.k.setVisibility(0);
                    return;
                }
                this.f72085c = this.f72084b.getResponse().getPagingInfo();
                SBPagingInfo sBPagingInfo = this.f72085c;
                if (sBPagingInfo != null) {
                    this.o = sBPagingInfo.getTotal().intValue();
                }
                if (this.f72084b.getResponse().getResponse() != null) {
                    this.n += this.f72084b.getResponse().getResponse().size();
                    this.p.addAll(this.f72084b.getResponse().getResponse());
                }
                List<SBUserHistoryItem> list = this.p;
                if (list == null || list.size() <= 0) {
                    this.j.setVisibility(8);
                    this.k.setVisibility(0);
                    return;
                }
                List<SBUserHistoryItem> list2 = this.p;
                TreeMap treeMap = new TreeMap();
                ArrayList arrayList = new ArrayList();
                if (list2 != null) {
                    for (SBUserHistoryItem next : list2) {
                        String format = new SimpleDateFormat("MMMM yyyy ").format(new Date(Long.parseLong(next.getCreateDate())));
                        if (treeMap.containsKey(format)) {
                            ((List) treeMap.get(format)).add(next);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(next);
                            treeMap.put(String.valueOf(format), arrayList2);
                        }
                    }
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    arrayList.add(new a(true, (SBUserHistoryItem) null, (String) entry.getKey()));
                    for (SBUserHistoryItem aVar : (List) entry.getValue()) {
                        arrayList.add(new a(false, aVar, ""));
                    }
                }
                this.f72087e = arrayList;
                this.j.setVisibility(0);
                m mVar = this.f72088f;
                mVar.f71920a = this.f72087e;
                mVar.notifyDataSetChanged();
                return;
            }
            this.j.setVisibility(8);
            this.k.setVisibility(0);
        } else if (fVar.f55796a == h.ERROR) {
            a(false);
            net.one97.paytm.common.widgets.a.b(this.m);
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            net.one97.paytm.network.g gVar = fVar.f55798c;
            if (gVar == null) {
                return;
            }
            if (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this, gVar.f55801c, SBUserHistoryActivity.class.getName(), (Bundle) null, false);
            }
        }
    }
}
