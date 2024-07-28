package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.quick_pay.Payload;
import net.one97.paytm.common.entity.quick_pay.QuickListResponse;
import net.one97.paytm.common.entity.quick_pay.QuickPayAddResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.hometabs.HomeTabItem;
import net.one97.paytm.landingpage.hometabs.a;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.widget.datetimepicker.b.b;
import net.one97.paytm.quickpay.widget.datetimepicker.view.DateTimeView;
import org.json.JSONException;
import org.json.JSONObject;

public class QuickPaymentResultActivity extends QuickPaymentActivity implements View.OnClickListener, b {
    /* access modifiers changed from: private */
    public String A = "";
    /* access modifiers changed from: private */
    public StandingInstructionList B;
    private View.OnClickListener C = new View.OnClickListener() {
        public final void onClick(View view) {
            if (!view.isSelected()) {
                Object tag = view.getTag();
                if (tag instanceof HomeTabItem) {
                    QuickPaymentResultActivity.a(QuickPaymentResultActivity.this, ((HomeTabItem) tag).getUrlType());
                } else {
                    q.c();
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private HomeTabItem[] f60034a;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, View> f60035c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ImageView f60036d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f60037e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f60038f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f60039g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f60040h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f60041i;
    private TextView j;
    private TextView k;
    private LinearLayout l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private long x;
    private LinearLayout y;
    /* access modifiers changed from: private */
    public int z;

    public void onCreate(Bundle bundle) {
        String str;
        Cursor query;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_quick_pay_result);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        b(getResources().getColor(R.color.white));
        this.f60037e = (TextView) findViewById(R.id.account_header_tv);
        this.f60038f = (TextView) findViewById(R.id.qpr_account_holder_name_tv);
        this.f60039g = (TextView) findViewById(R.id.qpr_account_no_tv);
        this.f60040h = (TextView) findViewById(R.id.qpr_ifsc_tv);
        this.f60041i = (TextView) findViewById(R.id.qpr_amount_tv);
        this.f60036d = (ImageView) findViewById(R.id.qpr_bank_icon_iv);
        this.j = (TextView) findViewById(R.id.qpr_bank_name_tv);
        this.l = (LinearLayout) findViewById(R.id.qpr_pay_now_ll);
        this.k = (TextView) findViewById(R.id.qpr_pay_now_message_tv);
        this.y = (LinearLayout) findViewById(R.id.date_tym_lyt);
        this.y.addView(new DateTimeView(this, getSupportFragmentManager(), this).getDateView());
        a.a();
        this.f60034a = a.b();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.parent_layout_bottom);
        int i2 = 0;
        while (true) {
            HomeTabItem[] homeTabItemArr = this.f60034a;
            str = null;
            if (i2 >= homeTabItemArr.length) {
                break;
            }
            HomeTabItem homeTabItem = homeTabItemArr[i2];
            View inflate = getLayoutInflater().inflate(R.layout.home_tab_item_layout, (ViewGroup) null, false);
            inflate.setTag(homeTabItem);
            inflate.setOnClickListener(this.C);
            ((ImageView) inflate.findViewById(R.id.tab_img)).setImageDrawable(homeTabItem.getIcon());
            TextView textView = (TextView) inflate.findViewById(R.id.tab_txt);
            textView.setText(homeTabItem.getText());
            textView.setTextColor(androidx.core.content.b.b(this, homeTabItem.getTextColorResource()));
            this.f60035c.put(homeTabItem.getUrlType(), inflate);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
            linearLayout.addView(inflate, i2);
            i2++;
        }
        linearLayout.setVisibility(8);
        findViewById(R.id.qp_back_iv).setOnClickListener(this);
        findViewById(R.id.qpr_pay_now_ll).setOnClickListener(this);
        findViewById(R.id.qp_add_tv).setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("si_id")) {
                this.x = intent.getLongExtra("si_id", 0);
            }
            if (intent.hasExtra("pay_mode")) {
                this.m = intent.getStringExtra("pay_mode");
                if (intent.hasExtra("name")) {
                    this.t = intent.getStringExtra("name");
                }
                if (intent.hasExtra("tag_url")) {
                    this.u = intent.getStringExtra("tag_url");
                }
                if (intent.hasExtra("amount")) {
                    this.n = intent.getStringExtra("amount");
                    this.f60041i.setText(String.format(getString(R.string.qpr_amount), new Object[]{this.n}));
                    this.k.setVisibility(0);
                    this.k.setText(String.format(getString(R.string.qpr_pay_now_message), new Object[]{this.n}));
                } else {
                    this.k.setVisibility(8);
                }
                if ("bank_account".equalsIgnoreCase(this.m)) {
                    if (intent.hasExtra("holder_name")) {
                        this.o = intent.getStringExtra("holder_name");
                        this.f60038f.setText(this.o);
                        this.f60037e.setText(String.format(getString(R.string.quick_pay_header_success_screen), new Object[]{this.t}));
                    }
                    if (intent.hasExtra(PayUtility.ACCOUNT_NUMBER)) {
                        this.q = intent.getStringExtra(PayUtility.ACCOUNT_NUMBER);
                        this.f60039g.setText(String.format(getString(R.string.qpr_account_number), new Object[]{this.q}));
                    }
                    if (intent.hasExtra("ifsc_code")) {
                        this.p = intent.getStringExtra("ifsc_code");
                        this.f60040h.setText(String.format(getString(R.string.qpr_ifsc_code), new Object[]{this.p}));
                        ImageView imageView = this.f60036d;
                        String str2 = this.p;
                        Drawable a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.ic_default_bank);
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.toUpperCase().startsWith("ICIC")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.icici);
                            } else if (str2.toUpperCase().startsWith("KOT")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.kotak);
                            } else if (str2.toUpperCase().startsWith("UTI")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.axis);
                            } else if (str2.toUpperCase().startsWith("HDF")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.hdfc);
                            } else if (str2.toUpperCase().startsWith("SBI")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.sbi);
                            } else if (str2.toUpperCase().startsWith("PNB")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.pnb);
                            } else if (str2.toUpperCase().startsWith("UPI")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.ic_bhim);
                            } else if (str2.toUpperCase().startsWith("PYT")) {
                                a2 = androidx.core.content.b.a((Context) this, (int) R.drawable.paytm_logo_money_transfer);
                            }
                        }
                        imageView.setImageDrawable(a2);
                    }
                    if (intent.hasExtra("bannk_name")) {
                        this.w = intent.getStringExtra("bannk_name");
                        this.j.setText(this.w);
                    }
                } else if ("wallet".equalsIgnoreCase(this.m)) {
                    this.f60036d.setImageResource(R.drawable.ic_wallet);
                    if (!TextUtils.isEmpty(this.t)) {
                        this.f60037e.setText(String.format(getString(R.string.quick_pay_header_success_screen), new Object[]{this.t}));
                    }
                    if (intent.hasExtra("mobile_number")) {
                        this.v = intent.getStringExtra("mobile_number");
                        String str3 = this.v;
                        if ((Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.READ_CONTACTS") == 0) && (query = getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str3)), new String[]{"display_name"}, (String) null, (String[]) null, (String) null)) != null) {
                            if (query.moveToFirst()) {
                                str = query.getString(query.getColumnIndex("display_name"));
                            }
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                        }
                        if (!TextUtils.isEmpty(str)) {
                            this.f60038f.setVisibility(0);
                            this.f60038f.setText(str);
                        } else {
                            this.f60038f.setVisibility(8);
                        }
                        this.f60039g.setText(String.format(getString(R.string.qpr_mobile_number), new Object[]{this.v}));
                        this.f60040h.setVisibility(8);
                    }
                } else if ("vpa".equalsIgnoreCase(this.m)) {
                    this.f60036d.setImageResource(R.drawable.ic_bhim_upi1);
                    if (intent.hasExtra("vpa_address")) {
                        this.r = intent.getStringExtra("vpa_address");
                        this.f60039g.setText(String.format(getString(R.string.qpr_upi_address), new Object[]{this.r}));
                        this.f60040h.setVisibility(8);
                    }
                    if (intent.hasExtra("holder_name")) {
                        this.s = intent.getStringExtra("holder_name");
                        this.f60038f.setText(this.s);
                        this.f60037e.setText(String.format(getString(R.string.quick_pay_header_success_screen), new Object[]{this.t}));
                    }
                }
            }
            this.B = net.one97.paytm.quickpay.b.a.a((Context) this, String.valueOf(this.x));
        }
        d.a().a("/personal-payments/success", "homescreen", (Activity) this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.qp_back_iv) {
            onBackPressed();
        } else if (id == R.id.qpr_pay_now_ll) {
            if ("bank_account".equalsIgnoreCase(this.m)) {
                String a2 = a(true, this.q, this.o, this.p, this.w, this.n);
                if (!TextUtils.isEmpty(a2)) {
                    d.b().a((Context) this, a2);
                }
            } else if ("vpa".equalsIgnoreCase(this.m)) {
                String a3 = a(false, this.r, this.s, (String) null, (String) null, this.n);
                if (!TextUtils.isEmpty(a3)) {
                    d.b().a((Context) this, a3);
                }
            } else {
                Intent intent = new Intent();
                intent.putExtra("PHONE_NUMBER", this.v);
                intent.putExtra("NAME", this.t);
                if (!TextUtils.isEmpty(this.n)) {
                    intent.putExtra("AMOUNT", this.n);
                }
                d.a().a(intent, (Activity) this);
            }
        } else if (id != R.id.qp_add_tv) {
        } else {
            if (TextUtils.isEmpty(this.A)) {
                Toast.makeText(this, "Please select Month/Week to set reminder", 1).show();
                return;
            }
            String a4 = d.b().a("updateQuickPaymentUrl");
            if (URLUtil.isValidUrl(a4)) {
                String str = a4 + "?siId=" + this.x + "&type=QUICK_PAYMENTS";
                HashMap hashMap = new HashMap();
                hashMap.put("Authorization", d.a().b((Context) this));
                try {
                    this.B.setEnablePaymentsReminder(true);
                    this.B.setReminderTimeRange("9-23");
                    if (this.z != 0) {
                        if (this.z != 2 || TextUtils.isEmpty(this.A)) {
                            if (this.z != 1 || TextUtils.isEmpty(this.A)) {
                                a("", "Please select reminder");
                                return;
                            }
                            this.B.setReminderDateIndex((String) null);
                            this.B.setReminderDayOfWeek(this.A);
                            this.B.setReminderFrequency("weekly");
                            this.B.getStartDate();
                            this.B.getNextReminderDate();
                            this.B.setStartDate((String) null);
                            this.B.setNextReminderDate((String) null);
                            JSONObject jSONObject = new JSONObject(new f().b(this.B));
                            a((Context) this, getResources().getString(R.string.loading));
                            d.a(this, str, new com.paytm.network.listener.b() {
                                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                    if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                                        QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                                        if (quickPayAddResponse.getResponseCode() == 200) {
                                            QuickPaymentResultActivity quickPaymentResultActivity = QuickPaymentResultActivity.this;
                                            QuickPaymentResultActivity.b(quickPaymentResultActivity, quickPaymentResultActivity.B.getId());
                                            return;
                                        }
                                        QuickPaymentResultActivity.this.a();
                                        String responseMessage = quickPayAddResponse.getResponseMessage();
                                        if (TextUtils.isEmpty(responseMessage)) {
                                            responseMessage = "Something went wrong";
                                        }
                                        QuickPaymentResultActivity.this.a("Error", responseMessage);
                                        return;
                                    }
                                    QuickPaymentResultActivity.this.a();
                                    QuickPaymentResultActivity.this.a("Error", "Something went wrong");
                                }

                                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                    QuickPaymentResultActivity.this.a();
                                    QuickPaymentResultActivity.this.a("Error", "Something went wrong");
                                }
                            }, hashMap, (Map<String, String>) null, a.C0715a.PUT, jSONObject.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
                        }
                    }
                    this.B.setReminderDayOfWeek((String) null);
                    this.B.setReminderDateIndex(this.A);
                    this.B.setReminderFrequency("monthly");
                    this.B.getStartDate();
                    this.B.getNextReminderDate();
                    this.B.setStartDate((String) null);
                    this.B.setNextReminderDate((String) null);
                    JSONObject jSONObject2 = new JSONObject(new f().b(this.B));
                    a((Context) this, getResources().getString(R.string.loading));
                    d.a(this, str, new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                                QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                                if (quickPayAddResponse.getResponseCode() == 200) {
                                    QuickPaymentResultActivity quickPaymentResultActivity = QuickPaymentResultActivity.this;
                                    QuickPaymentResultActivity.b(quickPaymentResultActivity, quickPaymentResultActivity.B.getId());
                                    return;
                                }
                                QuickPaymentResultActivity.this.a();
                                String responseMessage = quickPayAddResponse.getResponseMessage();
                                if (TextUtils.isEmpty(responseMessage)) {
                                    responseMessage = "Something went wrong";
                                }
                                QuickPaymentResultActivity.this.a("Error", responseMessage);
                                return;
                            }
                            QuickPaymentResultActivity.this.a();
                            QuickPaymentResultActivity.this.a("Error", "Something went wrong");
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            QuickPaymentResultActivity.this.a();
                            QuickPaymentResultActivity.this.a("Error", "Something went wrong");
                        }
                    }, hashMap, (Map<String, String>) null, a.C0715a.PUT, jSONObject2.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public final void a(String str, int i2) {
        this.A = str;
        this.z = i2;
    }

    static /* synthetic */ void a(QuickPaymentResultActivity quickPaymentResultActivity, String str) {
        Intent intent = new Intent(quickPaymentResultActivity, AJRMainActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        if (!str.isEmpty()) {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, str);
        } else {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        }
        intent.putExtra("started_activity_from_recharge", true);
        quickPaymentResultActivity.startActivity(intent);
        quickPaymentResultActivity.finish();
    }

    static /* synthetic */ void b(QuickPaymentResultActivity quickPaymentResultActivity, String str) {
        String a2 = d.b().a("getQuickPaymentsUrl");
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b((Context) quickPaymentResultActivity));
            com.paytm.network.a a3 = d.a(quickPaymentResultActivity, a2 + "&siId=" + str, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    String str;
                    QuickPaymentResultActivity.this.a();
                    if (iJRPaytmDataModel != null) {
                        QuickListResponse quickListResponse = (QuickListResponse) iJRPaytmDataModel;
                        Payload payload = quickListResponse.getPayload();
                        if (payload == null || payload.getStandingInstructionList() == null || payload.getStandingInstructionList().size() <= 0) {
                            String responseMessage = quickListResponse.getResponseMessage();
                            if (TextUtils.isEmpty(responseMessage)) {
                                responseMessage = "Something went wrong";
                            }
                            QuickPaymentResultActivity.this.a("Error", responseMessage);
                            return;
                        }
                        StandingInstructionList standingInstructionList = payload.getStandingInstructionList().get(0);
                        if (standingInstructionList != null) {
                            net.one97.paytm.quickpay.b.a.a((Context) QuickPaymentResultActivity.this, standingInstructionList);
                            if (QuickPaymentResultActivity.this.z == 0 || QuickPaymentResultActivity.this.z == 2) {
                                str = QuickPaymentResultActivity.this.A + " " + QuickPaymentResultActivity.this.getString(R.string.every_month);
                            } else {
                                str = QuickPaymentResultActivity.this.A + " " + QuickPaymentResultActivity.this.getString(R.string.every_week);
                            }
                            QuickPaymentResultActivity quickPaymentResultActivity = QuickPaymentResultActivity.this;
                            Dialog dialog = new Dialog(quickPaymentResultActivity);
                            dialog.setContentView(R.layout.reminder_success_creation_lyt);
                            dialog.setCanceledOnTouchOutside(false);
                            ((TextView) dialog.findViewById(R.id.qp_dialog_message_tv)).setText(str);
                            if (!quickPaymentResultActivity.isFinishing()) {
                                dialog.getWindow().setLayout(-1, -2);
                                dialog.show();
                                new Handler().postDelayed(new Runnable(dialog, quickPaymentResultActivity) {

                                    /* renamed from: a */
                                    final /* synthetic */ Dialog f59988a;

                                    /* renamed from: b */
                                    final /* synthetic */ Activity f59989b;

                                    public final void run(
/*
Method generation error in method: net.one97.paytm.quickpay.activity.QuickPaymentActivity.1.run():void, dex: classes6.dex
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.1.run():void, class status: UNLOADED
                                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                    
*/
                                }, 2000);
                                return;
                            }
                            return;
                        }
                        String responseMessage2 = quickListResponse.getResponseMessage();
                        if (TextUtils.isEmpty(responseMessage2)) {
                            responseMessage2 = "Something went wrong";
                        }
                        QuickPaymentResultActivity.this.a("Error", responseMessage2);
                        return;
                    }
                    QuickPaymentResultActivity.this.a("Error", "Something went wrong");
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    QuickPaymentResultActivity.this.a();
                    QuickPaymentResultActivity.this.a("Error", "Something went wrong");
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new QuickListResponse(), a.c.PAYMENTS, a.b.SILENT);
            if (com.paytm.utility.a.m(quickPaymentResultActivity)) {
                a3.a();
            }
        }
    }
}
