package net.one97.paytm.wallet.splitbill.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.z;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.a.n;
import net.one97.paytm.wallet.splitbill.b.e;
import net.one97.paytm.wallet.splitbill.e.c;
import net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse.SBRequestHistory;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementBaseResponse;
import net.one97.paytm.wallet.splitbill.model.UserToUserExpensesAPIResponse.SBUserToUserExpensesBaseResponse;
import net.one97.paytm.wallet.splitbill.model.b;
import net.one97.paytm.wallet.utility.a;

public class SBUserToUserDetailActivity extends PaytmActivity implements n.a, e {
    private Handler A;
    private Handler B;
    private Runnable C;
    private Runnable D;

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f72095a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f72096b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private n f72097c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f72098d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f72099e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f72100f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Button f72101g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f72102h;

    /* renamed from: i  reason: collision with root package name */
    private z f72103i;
    private ArrayList<String> j = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };
    private RoboTextView k;
    private RoboTextView l;
    private LinearLayout m;
    private LinearLayout n;
    private c o;
    private SBUserToUserExpensesBaseResponse p;
    private LottieAnimationView q;
    /* access modifiers changed from: private */
    public String r;
    /* access modifiers changed from: private */
    public String s;
    private LinearLayout t;
    private boolean u = false;
    private String v = "";
    /* access modifiers changed from: private */
    public String w;
    private List<SBRequestHistory> x = new ArrayList();
    /* access modifiers changed from: private */
    public Double y;
    /* access modifiers changed from: private */
    public String z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sb_user_to_user_activity);
        this.f72103i = new z(this);
        this.f72103i.setCancelable(false);
        this.f72103i.setCanceledOnTouchOutside(false);
        this.f72100f = (TextView) findViewById(R.id.beneficiary_circle_txt);
        this.f72102h = (ImageView) findViewById(R.id.split_back_button);
        this.f72098d = (TextView) findViewById(R.id.user_name);
        this.f72099e = (TextView) findViewById(R.id.user_member);
        this.f72101g = (Button) findViewById(R.id.pay_remind_for);
        this.k = (RoboTextView) findViewById(R.id.billwithuser);
        this.l = (RoboTextView) findViewById(R.id.usermarkaspaid);
        this.l.setText("Mark as Paid");
        this.m = (LinearLayout) findViewById(R.id.status_ticker_view);
        this.o = new c(this, this);
        this.t = (LinearLayout) findViewById(R.id.ll_outer_most_container);
        this.q = (LottieAnimationView) findViewById(R.id.lav_lottie_loader);
        this.n = (LinearLayout) findViewById(R.id.lyt_buttons);
        this.f72095a = (RecyclerView) findViewById(R.id.user_transaction_recycler);
        this.f72095a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f72097c = new n(this, this);
        this.f72095a.setAdapter(this.f72097c);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(SBUserToUserDetailActivity.this, SBMarkAsPaidActivity.class);
                intent.putExtra("fromHome", false);
                intent.putExtra("amount", SBUserToUserDetailActivity.this.y);
                intent.putExtra("mode", "MANUAL");
                if (SBUserToUserDetailActivity.this.w != null) {
                    intent.putExtra("user_name", SBUserToUserDetailActivity.this.w);
                }
                if (SBUserToUserDetailActivity.this.y.doubleValue() >= 0.0d) {
                    intent.putExtra("payerId", SBUserToUserDetailActivity.this.r);
                    intent.putExtra("payeeId", SBUserToUserDetailActivity.this.s);
                } else {
                    intent.putExtra("payerId", SBUserToUserDetailActivity.this.s);
                    intent.putExtra("payeeId", SBUserToUserDetailActivity.this.r);
                }
                SBUserToUserDetailActivity.this.startActivityForResult(intent, 107);
                ArrayList arrayList = new ArrayList();
                arrayList.add("user2user");
                arrayList.add(SBUserToUserDetailActivity.this.r);
                SBUserToUserDetailActivity sBUserToUserDetailActivity = SBUserToUserDetailActivity.this;
                net.one97.paytm.wallet.splitbill.e.b.a(sBUserToUserDetailActivity, "split_bill", "splitbill_markPay", arrayList, String.valueOf(Math.abs(sBUserToUserDetailActivity.y.doubleValue())), "/splitbill/user2user", "split_bill");
            }
        });
        this.f72102h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBUserToUserDetailActivity.this.finish();
            }
        });
        this.f72101g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (SBUserToUserDetailActivity.this.f72101g.getText().toString().startsWith(Events.Label.PAY)) {
                    Intent intent = new Intent();
                    intent.putExtra("PHONE_NUMBER", SBUserToUserDetailActivity.this.z);
                    intent.putExtra("AMOUNT", net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(SBUserToUserDetailActivity.this.y.doubleValue()))));
                    intent.putExtra("SOURCE", "SPLIT_BILL");
                    intent.putExtra("PAYER_ID", SBUserToUserDetailActivity.this.s);
                    intent.putExtra("PAYEE_ID", SBUserToUserDetailActivity.this.r);
                    intent.setFlags(268468224);
                    a.a(intent, (Activity) SBUserToUserDetailActivity.this);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("user2user");
                    arrayList.add(SBUserToUserDetailActivity.this.r);
                    SBUserToUserDetailActivity sBUserToUserDetailActivity = SBUserToUserDetailActivity.this;
                    net.one97.paytm.wallet.splitbill.e.b.a(sBUserToUserDetailActivity, "split_bill", "splitbill_pay", arrayList, String.valueOf(sBUserToUserDetailActivity.y), "/splitbill/pay", "split_bill");
                } else if (SBUserToUserDetailActivity.this.f72101g.getText().toString().startsWith("Remind")) {
                    SBUserToUserDetailActivity sBUserToUserDetailActivity2 = SBUserToUserDetailActivity.this;
                    sBUserToUserDetailActivity2.a(sBUserToUserDetailActivity2.r, SBUserToUserDetailActivity.this.y);
                }
            }
        });
        if (getIntent() != null && getIntent().hasExtra("user_id") && getIntent().hasExtra("your_id")) {
            this.r = getIntent().getStringExtra("user_id");
            this.s = getIntent().getStringExtra("your_id");
        }
    }

    public final void a() {
        String str;
        if (this.u) {
            net.one97.paytm.common.widgets.a.a(this.q);
            String str2 = this.v;
            if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getUserToUserSettlements"))) {
                str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getUserToUserSettlements") + "?limit=10&offset=" + str2;
            } else {
                str = "https://prms.paytmbank.com/prms/ext/v1/user-to-user/expenses?limit=10&offset=".concat(String.valueOf(str2));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            HashMap hashMap2 = new HashMap();
            hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
            hashMap2.put("uid", this.r);
            hashMap2.put("user-token", com.paytm.utility.a.q(this));
            new net.one97.paytm.network.a(str, new SBUserToUserExpensesBaseResponse(), hashMap, hashMap2).c().observeForever(new androidx.lifecycle.z() {
                public final void onChanged(Object obj) {
                    SBUserToUserDetailActivity.this.b((f) obj);
                }
            });
            return;
        }
        net.one97.paytm.common.widgets.a.b(this.q);
    }

    private void a(String str) {
        this.u = this.p.getResponse().getNextPage().booleanValue();
        if (this.u) {
            this.v = this.p.getResponse().getOffset();
        }
        n nVar = this.f72097c;
        List<b> list = this.f72096b;
        String str2 = this.r;
        nVar.f71932c = list;
        nVar.f71930a = str;
        nVar.f71931b = str2;
        nVar.notifyDataSetChanged();
    }

    public void onResume() {
        String str;
        super.onResume();
        a(true);
        if (com.paytm.utility.b.c((Context) this)) {
            if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getUserToUserSettlements"))) {
                str = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getUserToUserSettlements") + "?limit=10";
            } else {
                str = "https://prms.paytmbank.com/prms/ext/v1/user-to-user/expenses?limit=10";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            HashMap hashMap2 = new HashMap();
            hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
            hashMap2.put("uid", this.r);
            hashMap2.put("user-token", com.paytm.utility.a.q(this));
            new net.one97.paytm.network.a(str, new SBUserToUserExpensesBaseResponse(), hashMap, hashMap2).c().observeForever(new androidx.lifecycle.z() {
                public final void onChanged(Object obj) {
                    SBUserToUserDetailActivity.this.a((f) obj);
                }
            });
            return;
        }
        a(false);
    }

    /* access modifiers changed from: private */
    public void a(String str, Double d2) {
        String stringFromGTM = !TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getSendReminderURL")) ? net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "getSendReminderURL") : "https://prms.paytmbank.com/prms/ext/v1/reminder/user";
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", net.one97.paytm.wallet.splitbill.e.b.class.getSimpleName());
        hashMap.put("userId", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", com.paytm.utility.a.q(this));
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("content-type", "application/json");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        new net.one97.paytm.network.b(stringFromGTM, new SBUserSettlementBaseResponse(), hashMap, hashMap2, (String) null).c().observeForever(new androidx.lifecycle.z(d2, str) {
            private final /* synthetic */ Double f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onChanged(Object obj) {
                SBUserToUserDetailActivity.this.a(this.f$1, this.f$2, (f) obj);
            }
        });
    }

    private void a(String str, boolean z2) {
        if (z2) {
            this.m.removeAllViews();
            this.m.addView(this.o.a(false));
            this.m.setVisibility(0);
            this.o.a(str, "Payment reminder sent successfully", true);
        } else {
            this.m.removeAllViews();
            this.m.addView(this.o.a(true));
            this.m.setVisibility(0);
            this.o.a("Could Not Send Reminder", str, false);
        }
        this.A = new Handler();
        this.C = new Runnable() {
            public final void run() {
                SBUserToUserDetailActivity.this.d();
            }
        };
        this.A.postDelayed(this.C, 3000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void b() {
        Runnable runnable;
        this.m.setVisibility(8);
        Handler handler = this.A;
        if (handler != null && (runnable = this.C) != null) {
            handler.removeCallbacks(runnable);
            a(this.r, this.y);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 107 && i3 == -1) {
            String stringExtra = intent.getStringExtra("mark_as_paid_message");
            String stringExtra2 = intent.getStringExtra("mark_as_paid_sub_message");
            if (intent.getBooleanExtra("mark_as_paid_status", false)) {
                this.m.removeAllViews();
                this.m.addView(this.o.a(false));
                this.m.setVisibility(0);
                this.o.a(stringExtra, stringExtra2, true);
            } else {
                this.m.removeAllViews();
                this.m.addView(this.o.a(true));
                this.m.setVisibility(0);
                this.o.a(stringExtra, stringExtra2, false);
            }
            this.B = new Handler();
            this.D = new Runnable() {
                public final void run() {
                    SBUserToUserDetailActivity.this.c();
                }
            };
            this.B.postDelayed(this.D, 3000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void a(boolean z2) {
        if (z2) {
            z zVar = this.f72103i;
            if (zVar != null && !zVar.isShowing()) {
                this.f72103i.show();
                return;
            }
            return;
        }
        z zVar2 = this.f72103i;
        if (zVar2 != null && zVar2.isShowing()) {
            this.f72103i.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Double d2, String str, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if ((fVar.f55797b instanceof SBUserSettlementBaseResponse) && ((SBUserSettlementBaseResponse) fVar.f55797b).getSuccess() != null) {
                if (((SBUserSettlementBaseResponse) fVar.f55797b).getSuccess().booleanValue()) {
                    a("Reminder sent for ₹".concat(String.valueOf(d2)), true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("user2user");
                    arrayList.add(str);
                    arrayList.add("success");
                    net.one97.paytm.wallet.splitbill.e.b.a(this, "split_bill", "splitbill_remind", arrayList, String.valueOf(d2), "/splitbill/remind", "split_bill");
                    return;
                }
                a(((SBUserSettlementBaseResponse) fVar.f55797b).getMessage() != null ? ((SBUserSettlementBaseResponse) fVar.f55797b).getMessage() : "", false);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("user2user");
                arrayList2.add(str);
                arrayList2.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                net.one97.paytm.wallet.splitbill.e.b.a(this, "split_bill", "splitbill_remind", arrayList2, String.valueOf(d2), "/splitbill/remind", "split_bill");
            }
        } else if (fVar.f55796a == h.ERROR) {
            g gVar = fVar.f55798c;
            a(gVar.f55801c.getMessage(), false);
            if (gVar != null && (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                net.one97.paytm.wallet.communicator.b.a().handleError(this, gVar.f55801c, SBUserToUserDetailActivity.class.getName(), (Bundle) null, false);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("user2user");
            arrayList3.add(str);
            arrayList3.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            net.one97.paytm.wallet.splitbill.e.b.a(this, "split_bill", "splitbill_remind", arrayList3, String.valueOf(d2), "/splitbill/remind", "split_bill");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if (fVar.f55797b instanceof SBUserToUserExpensesBaseResponse) {
                a(false);
                this.p = (SBUserToUserExpensesBaseResponse) fVar.f55797b;
                if (!(this.p.getResponse() == null || this.p.getResponse().getRequestHistoryList() == null)) {
                    this.x.clear();
                    this.x.addAll(this.p.getResponse().getRequestHistoryList());
                    this.f72096b = net.one97.paytm.wallet.splitbill.e.a.a(this.x);
                    this.t.setVisibility(0);
                    this.w = this.p.getResponse().getUserName();
                    this.y = this.p.getResponse().getNetBalance();
                    if (this.y.doubleValue() < 0.0d) {
                        TextView textView = this.f72099e;
                        textView.setText("You need to pay " + net.one97.paytm.wallet.splitbill.e.b.d(this.w) + " ₹" + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(this.y.doubleValue()))) + " to settle up");
                        this.f72101g.setText("Pay Now");
                    } else if (this.y.doubleValue() > 0.0d) {
                        TextView textView2 = this.f72099e;
                        textView2.setText(net.one97.paytm.wallet.splitbill.e.b.d(this.w) + " needs to pay you ₹" + net.one97.paytm.wallet.splitbill.e.b.a(Double.valueOf(Math.abs(this.y.doubleValue()))) + " to settle up");
                        this.f72101g.setText("Remind Now");
                    } else {
                        this.f72099e.setText("All Bills Settled Up");
                        this.f72099e.setTextColor(Color.parseColor("#15be4f"));
                        this.f72101g.setText("Split New Bill");
                        this.n.setVisibility(8);
                    }
                    this.f72098d.setText(net.one97.paytm.wallet.splitbill.e.b.d(this.w));
                    if (this.y.doubleValue() == 0.0d) {
                        RoboTextView roboTextView = this.k;
                        roboTextView.setText("History with " + net.one97.paytm.wallet.splitbill.e.b.d(this.w));
                    } else {
                        RoboTextView roboTextView2 = this.k;
                        roboTextView2.setText("Bills with " + net.one97.paytm.wallet.splitbill.e.b.d(this.w));
                    }
                    this.f72100f.setText(a.d(this.w));
                    this.f72100f.setBackgroundColor(Color.parseColor(this.j.get(new Random().nextInt(10))));
                    a(this.p.getResponse().getUserName());
                }
                SBUserToUserExpensesBaseResponse sBUserToUserExpensesBaseResponse = this.p;
                if (sBUserToUserExpensesBaseResponse != null && sBUserToUserExpensesBaseResponse.getResponse() != null && this.p.getResponse().getUserMobile() != null) {
                    this.z = this.p.getResponse().getUserMobile();
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            a(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            net.one97.paytm.common.widgets.a.b(this.q);
            if (fVar.f55797b instanceof SBUserToUserExpensesBaseResponse) {
                net.one97.paytm.common.widgets.a.b(this.q);
                this.p = (SBUserToUserExpensesBaseResponse) fVar.f55797b;
                if (this.p.getResponse() != null && this.p.getResponse().getRequestHistoryList() != null) {
                    this.x.addAll(this.p.getResponse().getRequestHistoryList());
                    this.f72096b = net.one97.paytm.wallet.splitbill.e.a.a(this.x);
                    a(this.p.getResponse().getUserName());
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.common.widgets.a.b(this.q);
        }
    }
}
