package net.one97.paytm.paymentsBank.slfd.interestprojection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.h.c;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.h;
import net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse;
import net.one97.paytm.paymentsBank.model.slfd.SlfdModel;
import net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.d.a;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDProjectionListModel;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InterestProjectionActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f19144a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f19145b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f19146c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f19147d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19148e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f19149f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f19150g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f19151h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f19152i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private String q;
    private Double r;
    private h s;
    private a t;
    private boolean u;
    private boolean v;
    private SlfdModel w;
    private boolean x;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(f.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_interest_projection);
        this.f19144a = (RecyclerView) findViewById(R.id.rv_timeline_interest_projection);
        this.f19146c = (RelativeLayout) findViewById(R.id.rl_timeline_wrapper);
        this.f19145b = (RelativeLayout) findViewById(R.id.rl_view_complete_table);
        this.f19147d = (RelativeLayout) findViewById(R.id.rl_progress_bar_wrapper);
        this.f19148e = (TextView) findViewById(R.id.tv_fd_amount);
        this.f19149f = (TextView) findViewById(R.id.tv_fd_number);
        this.f19150g = (TextView) findViewById(R.id.tv_view_history);
        this.f19151h = (TextView) findViewById(R.id.tv_hd_interest_amount);
        this.f19152i = (TextView) findViewById(R.id.tv_interest_amount);
        this.j = (TextView) findViewById(R.id.tv_interest_rate);
        this.k = (TextView) findViewById(R.id.tv_days);
        this.l = (TextView) findViewById(R.id.tv_hd_interest_amount_matu);
        this.m = (TextView) findViewById(R.id.tv_interest_amount_matu);
        this.n = (TextView) findViewById(R.id.tv_interest_rate_matu);
        this.o = (TextView) findViewById(R.id.tv_days_matu);
        TextView textView = (TextView) findViewById(R.id.tv_btm_heading);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lyt_break_fd_btn);
        this.p = (TextView) findViewById(R.id.tv_maturity_date);
        findViewById(R.id.iv_back_arrow).setOnClickListener(this);
        this.s = new h(this);
        this.s.f18513a = getString(R.string.please_wait_progress_msg);
        this.f19144a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f19144a.setNestedScrollingEnabled(false);
        this.f19145b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InterestProjectionActivity.this.c(view);
            }
        });
        this.f19150g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InterestProjectionActivity.this.b(view);
            }
        });
        if (getIntent().getBooleanExtra("redirect_time_line", false)) {
            this.q = getIntent().getStringExtra("fd_id");
            this.x = getIntent().getBooleanExtra("expand_timeline", false);
        } else {
            this.q = getIntent().getStringExtra("order_id");
        }
        SpannableString spannableString = new SpannableString(getString(R.string.pb_note));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_ffa400)), 0, spannableString.length(), 33);
        textView.setText(spannableString);
        int i2 = R.string.pb_note_desc_int;
        Object[] objArr = new Object[1];
        d.a();
        if (!TextUtils.isEmpty(d.a("slfdRedeemMaxLimit"))) {
            d.a();
            str = d.a("slfdRedeemMaxLimit");
        } else {
            str = "Rs.10,000";
        }
        objArr[0] = str;
        SpannableString spannableString2 = new SpannableString(getString(i2, objArr));
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_222222)), 0, spannableString2.length(), 33);
        textView.append(spannableString2);
        this.t = a.a(this);
        this.t.f19202a = this;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InterestProjectionActivity.this.a(view);
            }
        });
        this.f19147d.setVisibility(0);
        String str2 = j.a().equals("ICA") ? "ica" : "isa";
        a aVar = this.t;
        String str3 = this.q;
        $$Lambda$InterestProjectionActivity$1brtTeFMGPR0zgrXxatm3mRNROQ r5 = new g.b() {
            public final void onResponse(Object obj) {
                InterestProjectionActivity.this.b(obj);
            }
        };
        $$Lambda$InterestProjectionActivity$8OeCoW70WBB4jiKFy9ripCA_8U r6 = new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                InterestProjectionActivity.this.b(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", aVar.getClass().getSimpleName());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userToken", com.paytm.utility.a.q(aVar.f19202a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("Authorization", jSONObject.toString());
        hashMap.put("Content-Type", "application/json");
        hashMap.put("client", "App");
        d.b();
        Uri.Builder buildUpon = Uri.parse(d.a("fdInterestProjection")).buildUpon();
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter("caId", c.d(aVar.f19202a));
        }
        buildUpon.appendQueryParameter("fdId", str3);
        buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, str2);
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), (g.b) r5, (g.a) r6, (IJRPaytmDataModel) new FDProjectionListModel(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        aVar.f19202a.getApplicationContext();
        new net.one97.paytm.bankCommon.g.c();
        net.one97.paytm.bankCommon.g.c.a(aVar2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f19146c.setVisibility(8);
        this.f19144a.setVisibility(0);
        RecyclerView recyclerView = this.f19144a;
        try {
            recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(recyclerView.getContext(), R.anim.pb_layout_animation_fall_down));
            recyclerView.getAdapter().notifyDataSetChanged();
            recyclerView.scheduleLayoutAnimation();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        net.one97.paytm.paymentsBank.slfd.interestprojection.b.a aVar = new net.one97.paytm.paymentsBank.slfd.interestprojection.b.a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("fd_id", this.q);
        bundle.putDouble("slfd_amount", this.r.doubleValue());
        aVar.setArguments(bundle);
        aVar.show(getSupportFragmentManager(), aVar.getTag());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.w != null) {
            this.s.a();
            net.one97.paytm.paymentsBank.slfd.interestprojection.d.a aVar = this.t;
            aVar.f19204c = this.w;
            this.r.doubleValue();
            aVar.b((g.b) new g.b() {
                public final void onResponse(Object obj) {
                    InterestProjectionActivity.this.c(obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    InterestProjectionActivity.this.c(i2, iJRPaytmDataModel, networkCustomError);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Object obj) {
        this.s.b();
        if (obj instanceof ValidateAmountLimit) {
            ValidateAmountLimit validateAmountLimit = (ValidateAmountLimit) obj;
            if (validateAmountLimit.getLimitBreached()) {
                b.b((Context) this, getString(R.string.error), validateAmountLimit.getMessage());
                return;
            }
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            String string = getString(R.string.fd_passcode_title);
            SlfdModel slfdModel = this.w;
            k.c(this, "ctx");
            k.c(string, "title");
            k.c(slfdModel, "slfdModel");
            Intent intent = new Intent(this, BankPasscodeActivity.class);
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", string);
            intent.putExtra("r_token", true);
            intent.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
            intent.putExtra("A", slfdModel);
            startActivityForResult(intent, 121);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.s.b();
        net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Object obj) {
        this.f19147d.setVisibility(8);
        try {
            if (obj instanceof FDProjectionListModel) {
                FDProjectionListModel fDProjectionListModel = (FDProjectionListModel) obj;
                if (!ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(fDProjectionListModel.getStatus())) {
                    if (!"400".equalsIgnoreCase(fDProjectionListModel.getStatus())) {
                        for (FDProjectionListModel.FdInterestProjectionDtoList next : fDProjectionListModel.getFdInterestProjectionDtoList()) {
                            if (next.getLabel().equalsIgnoreCase("_CURRENT_DATE")) {
                                this.f19151h.setText(getString(R.string.pb_interest_amount));
                                this.f19152i.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(next.getInterestEarned()))}));
                                this.j.setText(getString(R.string.pb_interest_rate, new Object[]{next.getInterestRate()}));
                                this.k.setText(next.getDisplayName());
                            }
                            if (next.getLabel().equalsIgnoreCase("_MATURITY_DATE")) {
                                this.l.setText(getString(R.string.pb_interest_amount));
                                this.m.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(next.getInterestEarned()))}));
                                this.n.setText(getString(R.string.pb_interest_rate, new Object[]{next.getInterestRate()}));
                                this.o.setText(next.getDisplayName());
                                this.p.setText(getString(R.string.pb_fd_maturity_date, new Object[]{next.getDate()}));
                            }
                        }
                        this.f19144a.setAdapter(new net.one97.paytm.paymentsBank.slfd.interestprojection.a.d(this, a(fDProjectionListModel.getFdInterestProjectionDtoList())));
                        this.w = new SlfdModel();
                        this.w.setNetInvestedAmount(fDProjectionListModel.getNetInvestedAmount().doubleValue());
                        this.w.setFdId(fDProjectionListModel.getFdId());
                        this.w.setBookingAmount(fDProjectionListModel.getNetInvestedAmount().doubleValue());
                        this.w.setInterestEarned(fDProjectionListModel.getInterestEarned().doubleValue());
                        this.q = fDProjectionListModel.getFdId();
                        this.r = fDProjectionListModel.getNetInvestedAmount();
                        this.f19148e.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(this.r)}));
                        this.f19149f.setText(getString(R.string.pb_fixed_deposit_number, new Object[]{this.q}));
                        for (int i2 = 0; i2 < fDProjectionListModel.getFdCategory().size(); i2++) {
                            if (fDProjectionListModel.getFdCategory().get(i2).equals("2001")) {
                                this.v = true;
                            } else if (fDProjectionListModel.getFdCategory().get(i2).equals("2000")) {
                                this.u = true;
                            }
                        }
                        if (this.u && this.v) {
                            SpannableString spannableString = new SpannableString(getString(R.string.pb_fd_partially_transferred_auto_renewed_tag));
                            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_222222)), 0, spannableString.length(), 33);
                            this.f19150g.setText(spannableString);
                            a();
                        } else if (this.v) {
                            SpannableString spannableString2 = new SpannableString(getString(R.string.pb_fd_partially_transferred_tag));
                            spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_222222)), 0, spannableString2.length(), 33);
                            this.f19150g.setText(spannableString2);
                            a();
                        } else if (this.u) {
                            SpannableString spannableString3 = new SpannableString(getString(R.string.pb_fd_auto_renewed_tag));
                            spannableString3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_222222)), 0, spannableString3.length(), 33);
                            this.f19150g.setText(spannableString3);
                            a();
                        } else {
                            this.f19150g.setVisibility(8);
                        }
                        if (this.x) {
                            this.f19145b.performClick();
                            return;
                        }
                        return;
                    }
                }
                b.b((Context) this, getString(R.string.error), fDProjectionListModel.getMessage());
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f19147d.setVisibility(8);
        net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }

    private static List<FDProjectionListModel.FdInterestProjectionDtoList> a(List<FDProjectionListModel.FdInterestProjectionDtoList> list) {
        ArrayList<FDProjectionListModel.FdInterestProjectionDtoList> arrayList = new ArrayList<>(list);
        FDProjectionListModel.FdInterestProjectionDtoList fdInterestProjectionDtoList = new FDProjectionListModel.FdInterestProjectionDtoList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            FDProjectionListModel.FdInterestProjectionDtoList fdInterestProjectionDtoList2 = (FDProjectionListModel.FdInterestProjectionDtoList) it2.next();
            if (fdInterestProjectionDtoList2.getLabel().equalsIgnoreCase("_MATURITY_DATE")) {
                fdInterestProjectionDtoList = fdInterestProjectionDtoList2;
                break;
            }
        }
        boolean z = false;
        for (FDProjectionListModel.FdInterestProjectionDtoList fdInterestProjectionDtoList3 : arrayList) {
            if (fdInterestProjectionDtoList3.getDisplayName().equalsIgnoreCase(fdInterestProjectionDtoList.getDisplayName()) && "_CURRENT_DATE".equalsIgnoreCase(fdInterestProjectionDtoList3.getLabel())) {
                z = true;
            }
        }
        int size = arrayList.size();
        if (z) {
            arrayList.remove(size - 1);
        }
        return arrayList;
    }

    private void a() {
        SpannableString spannableString = new SpannableString(" " + getString(R.string.pb_view_history));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_00b9f5)), 0, spannableString.length(), 33);
        this.f19150g.append(spannableString);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back_arrow) {
            onBackPressed();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 != 121) {
            finish();
        } else if (intent == null || TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
            finish();
        } else {
            this.s.a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fd_id", this.q);
                jSONObject.put("amount", this.t.f19203b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            net.one97.paytm.paymentsBank.slfd.interestprojection.d.a aVar = this.t;
            aVar.a(jSONArray, aVar.f19203b, intent.getStringExtra("passcode"), new g.b() {
                public final void onResponse(Object obj) {
                    InterestProjectionActivity.this.a(obj);
                }
            }, new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    InterestProjectionActivity.this.a(i2, iJRPaytmDataModel, networkCustomError);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        this.s.b();
        if (obj instanceof SlfdCreateRedeemResponse) {
            SlfdCreateRedeemResponse slfdCreateRedeemResponse = (SlfdCreateRedeemResponse) obj;
            if (slfdCreateRedeemResponse.getStatus().equalsIgnoreCase("success")) {
                Intent intent = new Intent(this, FDPostTransactionActivity.class);
                intent.putExtra("order_id", slfdCreateRedeemResponse.getOrderId());
                startActivity(intent);
                finish();
                return;
            }
            b.b((Context) this, getString(R.string.error), slfdCreateRedeemResponse.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.s.b();
        net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }
}
