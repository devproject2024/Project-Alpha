package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.i.h;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.k;
import net.one97.paytm.wallet.splitbill.activity.SBNonGroupExpensesActivity;
import net.one97.paytm.wallet.splitbill.activity.SBSearchContactListActivity;
import net.one97.paytm.wallet.splitbill.activity.SBUserHistoryActivity;
import net.one97.paytm.wallet.splitbill.d.a;
import net.one97.paytm.wallet.splitbill.e.b;
import net.one97.paytm.wallet.splitbill.e.c;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementBaseResponse;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementResponse;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSnapShotPojo;

public class e extends h implements View.OnClickListener, k.a, net.one97.paytm.wallet.splitbill.b.e {
    private Handler A;
    private Runnable B;

    /* renamed from: a  reason: collision with root package name */
    private ImageView f72136a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f72137b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f72138c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f72139d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f72140e;

    /* renamed from: f  reason: collision with root package name */
    private k f72141f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f72142g;

    /* renamed from: h  reason: collision with root package name */
    private a f72143h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<SBUserSnapShotPojo> f72144i = new ArrayList<>();
    private SBUserSettlementBaseResponse j;
    private RelativeLayout k;
    private RelativeLayout l;
    private boolean m = false;
    private boolean n = true;
    private int o = 0;
    private LottieAnimationView p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private Double v;
    private boolean w;
    private boolean x = false;
    /* access modifiers changed from: private */
    public LinearLayout y;
    private c z;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f72137b = activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        SBUserSettlementBaseResponse sBUserSettlementBaseResponse;
        View inflate = layoutInflater.inflate(R.layout.sb_complete_detail_fragment, (ViewGroup) null);
        if (getArguments() != null && getArguments().containsKey("from")) {
            this.q = getArguments().getString("from");
            if ("mark_as_paid".equalsIgnoreCase(this.q)) {
                this.w = getArguments().getBoolean("mark_as_paid_status", false);
                this.r = getArguments().getString("mark_as_paid_message");
                this.s = getArguments().getString("mark_as_paid_sub_message");
            }
        }
        this.f72136a = (ImageView) inflate.findViewById(R.id.split_back_button);
        this.f72142g = (LinearLayout) inflate.findViewById(R.id.new_bill);
        this.f72142g.setOnClickListener(this);
        this.f72136a = (ImageView) inflate.findViewById(R.id.split_back_button);
        this.f72136a.setOnClickListener(this);
        this.p = (LottieAnimationView) inflate.findViewById(R.id.lav_lottie_loader);
        this.f72140e = (RecyclerView) inflate.findViewById(R.id.rv_user_settlement);
        this.f72140e.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.f72141f = new k(this.f72137b, this);
        this.f72140e.setAdapter(this.f72141f);
        this.f72139d = (TextView) inflate.findViewById(R.id.tvTotalPay);
        this.f72138c = (TextView) inflate.findViewById(R.id.tvTotalReceive);
        this.k = (RelativeLayout) inflate.findViewById(R.id.receivedByYouHolder);
        this.l = (RelativeLayout) inflate.findViewById(R.id.lyt_all_settled_up);
        this.y = (LinearLayout) inflate.findViewById(R.id.status_ticker_view);
        this.z = new c(this.f72137b, this);
        this.f72143h = a.a((Context) this.f72137b);
        Object a2 = net.one97.paytm.p2p.theme.e.a(this.f72143h.f72229a, "user_settlement_data");
        if (a2 instanceof SBUserSettlementBaseResponse) {
            sBUserSettlementBaseResponse = (SBUserSettlementBaseResponse) a2;
        } else {
            sBUserSettlementBaseResponse = new SBUserSettlementBaseResponse();
        }
        this.j = sBUserSettlementBaseResponse;
        SBUserSettlementBaseResponse sBUserSettlementBaseResponse2 = this.j;
        if (!(sBUserSettlementBaseResponse2 == null || sBUserSettlementBaseResponse2.getResponse() == null || this.j.getResponse().getUserSnapShotPojos() == null)) {
            if (this.j.getResponse().getNextPage() != null) {
                this.n = this.j.getResponse().getNextPage().booleanValue();
            }
            for (SBUserSnapShotPojo next : this.j.getResponse().getUserSnapShotPojos()) {
                this.t = next.getPayerId();
                if (!"0.0".equalsIgnoreCase(next.getAmount())) {
                    this.f72144i.add(next);
                    this.o++;
                }
            }
        }
        SBUserSettlementBaseResponse sBUserSettlementBaseResponse3 = this.j;
        if (!(sBUserSettlementBaseResponse3 == null || sBUserSettlementBaseResponse3.getResponse() == null || this.j.getResponse().getToPay() == null || this.j.getResponse().getToReceive() == null)) {
            if (Double.parseDouble(this.j.getResponse().getToPay()) <= 0.0d) {
                this.f72139d.setText("₹0");
            } else {
                this.f72139d.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + b.a(Double.valueOf(Double.parseDouble(this.j.getResponse().getToPay()))));
            }
            if (Double.parseDouble(this.j.getResponse().getToReceive()) <= 0.0d) {
                this.f72138c.setText("₹0");
            } else {
                this.f72138c.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + b.a(Double.valueOf(Double.parseDouble(this.j.getResponse().getToReceive()))));
            }
        }
        ArrayList<SBUserSnapShotPojo> arrayList = this.f72144i;
        if (arrayList == null || arrayList.size() <= 0) {
            this.l.setVisibility(0);
            this.f72141f.a((List<SBUserSnapShotPojo>) this.f72144i, false);
            this.f72141f.notifyDataSetChanged();
        } else {
            this.l.setVisibility(8);
            this.f72140e.setVisibility(0);
            if (this.f72144i.size() > 6) {
                this.f72141f.a(this.f72144i.subList(0, 6), true);
            } else {
                k kVar = this.f72141f;
                ArrayList<SBUserSnapShotPojo> arrayList2 = this.f72144i;
                kVar.a(arrayList2.subList(0, arrayList2.size()), false);
            }
            this.f72141f.notifyDataSetChanged();
        }
        if ("bill_delete_success".equalsIgnoreCase(this.q)) {
            this.x = false;
            this.y.removeAllViews();
            this.y.setVisibility(0);
            this.y.addView(this.z.a(false));
            this.z.a(this.f72137b.getString(R.string.bill_delete_success), "", true);
        } else if ("bill_submit_success".equalsIgnoreCase(this.q)) {
            this.x = false;
            this.y.removeAllViews();
            this.y.setVisibility(0);
            this.y.addView(this.z.a(false));
            this.z.a(this.f72137b.getString(R.string.bill_submit_success), "", true);
        } else if ("bill_update_success".equalsIgnoreCase(this.q)) {
            this.x = false;
            this.y.removeAllViews();
            this.y.setVisibility(0);
            this.y.addView(this.z.a(false));
            this.z.a(this.f72137b.getString(R.string.bill_update_success), "", true);
        } else if ("mark_as_paid".equalsIgnoreCase(this.q)) {
            this.x = false;
            this.y.removeAllViews();
            this.y.setVisibility(0);
            this.y.addView(this.z.a(false));
            if (this.w) {
                this.z.a(this.r, this.s, true);
            } else {
                this.z.a(this.r, this.s, false);
            }
        } else {
            this.y.setVisibility(8);
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (e.this.y != null) {
                    e.this.y.setVisibility(8);
                }
            }
        }, 3000);
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.split_back_button) {
            this.f72137b.finish();
        } else if (id == R.id.new_bill) {
            Intent intent = new Intent(this.f72137b, SBSearchContactListActivity.class);
            intent.putExtra("show_group_widget", false);
            intent.putExtra("non_group_bill", true);
            intent.putExtra("your_id", this.t);
            this.f72137b.startActivity(intent);
            ArrayList arrayList = new ArrayList();
            arrayList.add("splitBillHome");
            b.a(this.f72137b, "split_bill", "new_splitbill", arrayList, "", "/splitbill/new", "split_bill");
        }
    }

    public final void a() {
        String str;
        net.one97.paytm.common.widgets.a.a(this.p);
        if (this.n) {
            int i2 = this.o;
            if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f72137b, "getUserSettlementUrl"))) {
                str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f72137b, "getUserSettlementUrl") + "?limit=10&offset=" + i2;
            } else {
                str = "https://prms.paytmbank.com/prms/ext/v1/user/expenses?limit=10&offset=".concat(String.valueOf(i2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("user-token", com.paytm.utility.a.q(this.f72137b));
            hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
            new net.one97.paytm.network.a(str, new SBUserSettlementBaseResponse(), hashMap, hashMap2).c().observeForever(new z() {
                public final void onChanged(Object obj) {
                    e.this.a((f) obj);
                }
            });
            return;
        }
        net.one97.paytm.common.widgets.a.b(this.p);
    }

    public final void aJ_() {
        ArrayList arrayList = new ArrayList();
        if (!this.m) {
            arrayList.add("viewLess");
            this.m = true;
            if (this.f72144i.size() > 6) {
                this.f72141f.a((List<SBUserSnapShotPojo>) this.f72144i, true);
            } else {
                this.f72141f.a((List<SBUserSnapShotPojo>) this.f72144i, false);
            }
            this.f72141f.notifyDataSetChanged();
        } else {
            arrayList.add("viewMore");
            this.m = false;
            this.f72141f.a(this.f72144i.subList(0, 6), true);
            this.f72141f.notifyDataSetChanged();
        }
        b.a(this.f72137b, "split_bill", "splitbill_userView", arrayList, "", "/splitbill/viewMore", "split_bill");
    }

    public final void c() {
        startActivity(new Intent(getActivity(), SBNonGroupExpensesActivity.class));
        b.a(this.f72137b, "split_bill", "view_splitbills", (ArrayList<String>) null, "", "/splitbill/viewbill", "split_bill");
    }

    public final void d() {
        startActivity(new Intent(getActivity(), SBUserHistoryActivity.class));
        b.a(this.f72137b, "split_bill", "splitbill_history", (ArrayList<String>) null, "", "/splitbill/history", "split_bill");
    }

    public final void e() {
        Intent webViewIntent = net.one97.paytm.wallet.communicator.b.a().getWebViewIntent(getActivity());
        webViewIntent.putExtra("url", "https://docs.google.com/forms/d/e/1FAIpQLSdSFYDRbt8WQVuAArbGw1ppAK85hDI012PGpsozLrHL7Oz6_A/viewform?usp=sf_link");
        webViewIntent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "Share Your Feedback");
        this.f72137b.startActivity(webViewIntent);
        b.a(this.f72137b, "split_bill", "splitbill_feedback", (ArrayList<String>) null, "", "/splitbill/feedback", "split_bill");
    }

    public final void a(String str, boolean z2, String str2, Double d2) {
        this.y.setVisibility(0);
        this.y.removeAllViews();
        if (z2) {
            this.y.addView(this.z.a(false));
            this.z.a(str, "Payment reminder sent successfully", true);
            this.x = false;
        } else {
            this.y.addView(this.z.a(true));
            this.x = true;
            this.u = str2;
            this.v = d2;
            this.z.a("Could Not Send Reminder", str, false);
        }
        this.A = new Handler();
        this.B = new Runnable() {
            public final void run() {
                e.this.f();
            }
        };
        this.A.postDelayed(this.B, 3000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        LinearLayout linearLayout = this.y;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void b() {
        this.y.setVisibility(8);
        if (this.x && this.f72141f != null && this.u != null && this.v != null) {
            this.A.removeCallbacks(this.B);
            this.f72141f.a(this.u, this.v);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar.f55797b instanceof SBUserSettlementBaseResponse) {
                net.one97.paytm.common.widgets.a.b(this.p);
                SBUserSettlementBaseResponse sBUserSettlementBaseResponse = (SBUserSettlementBaseResponse) fVar.f55797b;
                if (sBUserSettlementBaseResponse.getResponse().getUserSnapShotPojos() != null && sBUserSettlementBaseResponse.getResponse().getUserSnapShotPojos().size() != 0) {
                    SBUserSettlementResponse response = sBUserSettlementBaseResponse.getResponse();
                    if (response.getNextPage() != null) {
                        this.n = response.getNextPage().booleanValue();
                    } else {
                        this.n = false;
                    }
                    for (SBUserSnapShotPojo add : response.getUserSnapShotPojos()) {
                        this.f72144i.add(add);
                        this.o++;
                    }
                    this.f72141f.a((List<SBUserSnapShotPojo>) this.f72144i, true);
                }
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            net.one97.paytm.common.widgets.a.b(this.p);
            g gVar = fVar.f55798c;
            if (fVar.f55797b == null) {
                return;
            }
            if (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this.f72137b, gVar.f55801c, e.class.getName(), (Bundle) null, false);
            }
        }
    }
}
