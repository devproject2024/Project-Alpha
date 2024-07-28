package net.one97.paytm.wallet.splitbill.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.t;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.z;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.c;
import net.one97.paytm.wallet.splitbill.b.e;
import net.one97.paytm.wallet.splitbill.c.g;
import net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse.SBBillDetailResponse;
import net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse.SBBillDetailsBaseResponse;
import net.one97.paytm.wallet.splitbill.model.BillDetailsAPIResponse.SBSubRequest;

public class SBBillDetailActivity extends PaytmActivity implements e, g.a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f71952a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f71953b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f71954c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f71955d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f71956e;

    /* renamed from: f  reason: collision with root package name */
    private c f71957f;

    /* renamed from: g  reason: collision with root package name */
    private z f71958g;

    /* renamed from: h  reason: collision with root package name */
    private SBBillDetailsBaseResponse f71959h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public SBBillDetailResponse f71960i;
    private ArrayList<SBSubRequest> j;
    private ImageView k;
    private RelativeLayout l;
    private LinearLayout m;
    /* access modifiers changed from: private */
    public LinearLayout n;
    private net.one97.paytm.wallet.splitbill.e.c o;
    private String p;
    private String q;
    private boolean r = false;
    /* access modifiers changed from: private */
    public boolean s = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_bill_detail_activity);
        this.f71958g = new z(this);
        this.f71958g.setCancelable(false);
        this.f71958g.setCanceledOnTouchOutside(false);
        this.f71952a = (TextView) findViewById(R.id.Bill_name);
        this.f71953b = (TextView) findViewById(R.id.bill_amount);
        this.f71954c = (TextView) findViewById(R.id.bill_member);
        this.f71955d = (TextView) findViewById(R.id.bill_date);
        this.f71956e = (RecyclerView) findViewById(R.id.billmemberrecycler);
        this.f71956e.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.k = (ImageView) findViewById(R.id.split_back_button);
        this.m = (LinearLayout) findViewById(R.id.ll_outer_most_container);
        this.l = (RelativeLayout) findViewById(R.id.tint_layout);
        this.n = (LinearLayout) findViewById(R.id.status_ticker_view);
        this.o = new net.one97.paytm.wallet.splitbill.e.c(this, this);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBBillDetailActivity.a(SBBillDetailActivity.this);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBBillDetailActivity.this.finish();
            }
        });
        c();
    }

    private void c() {
        if (getIntent() != null && getIntent().hasExtra("bill_id")) {
            this.p = getIntent().getStringExtra("bill_id");
            if (!this.r) {
                this.r = getIntent().getBooleanExtra("is_from_edit_bill", false);
            }
        }
        a(true);
        if (this.p == null || !b.c((Context) this)) {
            a(false);
        } else {
            b(this.p);
        }
    }

    private void b(String str) {
        String str2;
        if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getRequestDetailURL"))) {
            str2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getRequestDetailURL") + str;
        } else {
            str2 = "https://prms.paytmbank.com/prms/ext/v1/request/".concat(String.valueOf(str));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", a.q(this));
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        new net.one97.paytm.network.a(str2, new SBBillDetailsBaseResponse(), hashMap, hashMap2).c().observeForever(new androidx.lifecycle.z() {
            public final void onChanged(Object obj) {
                SBBillDetailActivity.this.a((f) obj);
            }
        });
    }

    private static String a(SBBillDetailResponse sBBillDetailResponse) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (sBBillDetailResponse != null && sBBillDetailResponse.getSubRequest() != null) {
            String createdBy = sBBillDetailResponse.getCreatedBy();
            Iterator<SBSubRequest> it2 = sBBillDetailResponse.getSubRequest().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                SBSubRequest next = it2.next();
                if (next.getUserId().equalsIgnoreCase(createdBy)) {
                    str = next.getName();
                    break;
                }
            }
        }
        str = "";
        sb.append("Bill added by " + str + " | " + net.one97.paytm.wallet.splitbill.e.b.c(sBBillDetailResponse.getCreatedDate()));
        return sb.toString();
    }

    private String b(SBBillDetailResponse sBBillDetailResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("Paid by ");
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        this.s = false;
        Iterator<SBSubRequest> it2 = sBBillDetailResponse.getSubRequest().iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            SBSubRequest next = it2.next();
            if (Float.parseFloat(next.getAmount()) > 0.0f) {
                if ("you".equalsIgnoreCase(next.getName())) {
                    this.s = true;
                    this.q = next.getUserId();
                    sb.append("You ");
                } else {
                    i2++;
                    arrayList.add(next.getName());
                }
            }
        }
        if (!this.s) {
            sb2.append(((String) arrayList.get(0)) + " ");
            if (i2 != 1) {
                if (i2 != 2) {
                    sb2.append("and " + (i2 - 1) + "others");
                } else {
                    sb2.append("and 1 other");
                }
            }
        } else if (i2 != 0) {
            if (i2 != 1) {
                sb2.append("and " + i2 + " others");
            } else {
                sb2.append("and 1 other");
            }
        }
        sb.append(sb2);
        sb.append(" | ");
        if (sBBillDetailResponse.getSplitTag().equalsIgnoreCase("EQUAL")) {
            sb.append("Split Equally");
        } else {
            sb.append("Split Unequally");
        }
        return sb.toString();
    }

    private void a(boolean z) {
        if (z) {
            d();
        } else {
            e();
        }
    }

    private void d() {
        z zVar = this.f71958g;
        if (zVar != null && !zVar.isShowing()) {
            this.f71958g.show();
        }
    }

    private void e() {
        z zVar = this.f71958g;
        if (zVar != null && zVar.isShowing()) {
            this.f71958g.dismiss();
        }
    }

    public final void a(String str) {
        a(false, str);
    }

    public final void a() {
        this.n.removeAllViews();
        this.n.addView(this.o.a(false));
        this.n.setVisibility(0);
        this.o.a("No Internet Available", "", false);
    }

    private void a(boolean z, String str) {
        this.n.removeAllViews();
        if (z) {
            this.n.addView(this.o.a(false));
            this.n.setVisibility(0);
            this.o.a(getResources().getString(R.string.bill_update_success), "", true);
        } else {
            this.n.addView(this.o.a(true));
            this.n.setVisibility(0);
            this.o.a("Could not delete bill, please retry", str, false);
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (SBBillDetailActivity.this.n != null) {
                    SBBillDetailActivity.this.n.setVisibility(8);
                }
            }
        }, 3000);
    }

    public final void b() {
        this.n.setVisibility(8);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 109) {
            this.p = intent.getStringExtra("bill_id");
            this.r = true;
            c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a(false);
            if (fVar.f55797b instanceof SBBillDetailsBaseResponse) {
                this.f71959h = (SBBillDetailsBaseResponse) fVar.f55797b;
                this.f71960i = this.f71959h.getResponse();
                this.j = this.f71960i.getSubRequest();
                this.m.setVisibility(0);
                this.f71952a.setText(this.f71960i.getName());
                TextView textView = this.f71953b;
                textView.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + b.c(this.f71960i.getTotalAmount().doubleValue()));
                this.f71954c.setText(b(this.f71960i));
                this.f71955d.setText(a(this.f71960i));
                this.f71957f = new c(this.j, this, this.q);
                this.f71956e.setAdapter(this.f71957f);
                if (this.r) {
                    a(true, "");
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            a(false);
            net.one97.paytm.network.g gVar = fVar.f55798c;
            if (gVar == null) {
                return;
            }
            if (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this, gVar.f55801c, SBBillDetailActivity.class.getName(), (Bundle) null, false);
            }
        }
    }

    static /* synthetic */ void a(SBBillDetailActivity sBBillDetailActivity) {
        t tVar = new t(sBBillDetailActivity, sBBillDetailActivity.l);
        tVar.b().inflate(R.menu.sb_bill_option_menu, tVar.f1796a);
        tVar.f1798c = new t.b() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.sb_edit_bill) {
                    Intent intent = new Intent(SBBillDetailActivity.this, SBEnterBillActivity.class);
                    intent.putExtra("edit_bill", true);
                    intent.putExtra("bill_detail_response", SBBillDetailActivity.this.f71960i);
                    SBBillDetailActivity.this.startActivityForResult(intent, 109);
                    ArrayList arrayList = new ArrayList();
                    if (SBBillDetailActivity.this.s) {
                        arrayList.add("1");
                    } else {
                        arrayList.add("0");
                    }
                    net.one97.paytm.wallet.splitbill.e.b.a(SBBillDetailActivity.this, "split_bill", "splitbill_edit", arrayList, "", "/splitbill/editBill", "split_bill");
                } else if (itemId == R.id.sb_delete_bill) {
                    SBBillDetailActivity.d(SBBillDetailActivity.this);
                }
                return true;
            }
        };
        tVar.f1797b.a();
    }

    static /* synthetic */ void d(SBBillDetailActivity sBBillDetailActivity) {
        g a2 = g.a();
        String str = sBBillDetailActivity.p;
        boolean z = sBBillDetailActivity.s;
        a2.f72157a = str;
        a2.f72158b = sBBillDetailActivity;
        a2.f72159c = z;
        a2.show(sBBillDetailActivity.getSupportFragmentManager(), "bottom_sheet_delete_confirmation");
    }
}
