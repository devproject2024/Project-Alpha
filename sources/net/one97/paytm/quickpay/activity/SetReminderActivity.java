package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.quick_pay.Payload;
import net.one97.paytm.common.entity.quick_pay.QuickListResponse;
import net.one97.paytm.common.entity.quick_pay.QuickPayAddResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.quick_pay.SupportingData;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.activity.QuickPaymentActivity;
import net.one97.paytm.quickpay.b.a;
import net.one97.paytm.quickpay.utilities.f;
import net.one97.paytm.quickpay.widget.datetimepicker.b.b;
import net.one97.paytm.quickpay.widget.datetimepicker.view.DateTimeView;
import net.one97.paytm.utils.r;
import org.json.JSONException;
import org.json.JSONObject;

public class SetReminderActivity extends QuickPaymentActivity implements View.OnClickListener, b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f60081a;

    /* renamed from: c  reason: collision with root package name */
    private long f60082c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f60083d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f60084e;

    /* renamed from: f  reason: collision with root package name */
    private String f60085f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f60086g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f60087h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f60088i;
    /* access modifiers changed from: private */
    public StandingInstructionList j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.reminder_quick_payment_lyt);
        b(getResources().getColor(R.color.white));
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("si_id")) {
                this.f60082c = intent.getLongExtra("si_id", 0);
                this.j = a.a((Context) this, String.valueOf(this.f60082c));
            }
            if (intent.hasExtra("tag_url")) {
                this.f60084e = intent.getStringExtra("tag_url");
            }
            if (intent.hasExtra("tag_name")) {
                this.f60085f = intent.getStringExtra("tag_name");
            }
            if (intent.hasExtra("is_called_post_txn_screen")) {
                this.k = intent.getBooleanExtra("is_called_post_txn_screen", false);
            }
            if (intent.hasExtra("quick_mobile_number")) {
                this.l = intent.getStringExtra("quick_mobile_number");
            }
            if (intent.hasExtra("quick_pay_mode")) {
                this.m = intent.getStringExtra("quick_pay_mode");
                if (this.m.equalsIgnoreCase(f.WALLET.getPayMode())) {
                    this.l = intent.getStringExtra("quick_mobile_number");
                } else if (this.m.equalsIgnoreCase(f.IMPS.getPayMode())) {
                    this.n = intent.getStringExtra(PayUtility.ACCOUNT_NUMBER);
                    this.o = intent.getStringExtra("ifsc_code");
                    this.p = intent.getStringExtra("account_holder_name");
                    this.q = intent.getStringExtra(PayUtility.BANK_NAME);
                } else if (this.m.equalsIgnoreCase(f.UPI.getPayMode())) {
                    this.r = intent.getStringExtra("vpa");
                    this.p = intent.getStringExtra("account_holder_name");
                }
            }
            if (intent.hasExtra("quick_amount")) {
                this.s = intent.getStringExtra("quick_amount");
            }
        }
        this.f60086g = (TextView) findViewById(R.id.sra_name_tv);
        this.f60087h = (ImageView) findViewById(R.id.sra_icon_iv);
        if (!TextUtils.isEmpty(this.f60085f)) {
            this.f60086g.setText(String.format(getString(R.string.sra_header_message), new Object[]{this.f60085f}));
        }
        if (TextUtils.isEmpty(this.f60084e)) {
            this.f60087h.setImageResource(R.drawable.ic_other);
        } else {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
            a2.f43753a = this.f60084e;
            b.a.C0750a.a(a2, this.f60087h, (com.paytm.utility.b.b.b) null, 2);
        }
        this.f60088i = (LinearLayout) findViewById(R.id.date_tym_lyt);
        this.f60088i.addView(new DateTimeView(this, getSupportFragmentManager(), this).getDateView());
        findViewById(R.id.qp_add_tv).setOnClickListener(this);
        findViewById(R.id.sra_back_iv).setOnClickListener(this);
        d.a().a("/personal-payments/reminder", "homescreen", (Activity) this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sra_back_iv) {
            finish();
        } else if (id == R.id.qp_add_tv) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("success");
            arrayList.add(this.f60085f);
            int i2 = this.f60081a;
            arrayList.add((i2 == 0 || i2 == 2) ? "Monthy" : "Weekly");
            try {
                d.a().a((Context) this, "set_reminder_button_clicked", (ArrayList<String>) arrayList);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
            if (this.k) {
                this.j = new StandingInstructionList();
                String a2 = d.b().a("addQuickPaymentUrl");
                if (URLUtil.isValidUrl(a2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("Authorization", d.a().b((Context) this));
                    try {
                        this.j.setEnablePaymentsReminder(true);
                        this.j.setReminderTimeRange("9-23");
                        if (this.f60081a != 0) {
                            if (this.f60081a != 2 || TextUtils.isEmpty(this.f60083d)) {
                                if (this.f60081a != 1 || TextUtils.isEmpty(this.f60083d)) {
                                    a("", "Please select reminder");
                                    return;
                                }
                                this.j.setReminderDateIndex((String) null);
                                this.j.setReminderDayOfWeek(this.f60083d);
                                this.j.setReminderFrequency("weekly");
                                this.j.setType("QUICK_PAYMENTS");
                                this.j.setReminderDisplayName(this.f60085f);
                                this.j.setAmount(this.s);
                                this.j.getStartDate();
                                this.j.getNextReminderDate();
                                this.j.setStartDate((String) null);
                                this.j.setNextReminderDate((String) null);
                                SupportingData supportingData = new SupportingData();
                                supportingData.setTagName(this.f60085f);
                                supportingData.setTagUrl(this.f60084e);
                                supportingData.setTagId((String) null);
                                supportingData.setPaymentType("personal");
                                supportingData.setBeneficiaryMobileNumber(this.l);
                                supportingData.setBeneficiaryAccountNumber(this.n);
                                supportingData.setBeneficiaryIfscCode(this.o);
                                supportingData.setBeneficiaryName(this.p);
                                supportingData.setBeneficiaryBankName(this.q);
                                supportingData.setBeneficiaryUpiAddress(this.r);
                                supportingData.setStoreFrontTitle(this.f60085f);
                                this.j.setSupportingData(supportingData);
                                JSONObject jSONObject = new JSONObject(new com.google.gson.f().b(this.j));
                                a((Context) this, getResources().getString(R.string.loading));
                                d.a(this, a2, new com.paytm.network.listener.b() {
                                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                        SetReminderActivity.this.a();
                                        if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                                            QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                                            if (quickPayAddResponse.getResponseCode() == 200) {
                                                SetReminderActivity.this.j.setId(String.valueOf(quickPayAddResponse.getPayload().getSiId()));
                                                SetReminderActivity setReminderActivity = SetReminderActivity.this;
                                                a.a((Context) setReminderActivity, setReminderActivity.j);
                                                net.one97.paytm.quickpay.d.a.a().a(a.a(SetReminderActivity.this));
                                                SetReminderActivity setReminderActivity2 = SetReminderActivity.this;
                                                String string = setReminderActivity2.getResources().getString(R.string.qp_saved_successfully);
                                                AnonymousClass1 r1 = new QuickPaymentActivity.a() {
                                                    public final void a() {
                                                        SetReminderActivity.this.setResult(-1);
                                                        SetReminderActivity.this.finish();
                                                    }
                                                };
                                                Dialog dialog = new Dialog(setReminderActivity2);
                                                dialog.setContentView(R.layout.reminder_success_creation_lyt);
                                                dialog.setCanceledOnTouchOutside(false);
                                                ((TextView) dialog.findViewById(R.id.qp_message_tv)).setText(string);
                                                if (!setReminderActivity2.isFinishing()) {
                                                    dialog.getWindow().setLayout(-1, -2);
                                                    dialog.show();
                                                    new Handler().postDelayed(new Runnable(dialog, r1) {

                                                        /* renamed from: a */
                                                        final /* synthetic */ Dialog f59991a;

                                                        /* renamed from: b */
                                                        final /* synthetic */ a f59992b;

                                                        public final void run(
/*
Method generation error in method: net.one97.paytm.quickpay.activity.QuickPaymentActivity.2.run():void, dex: classes6.dex
                                                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.2.run():void, class status: UNLOADED
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
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
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
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                            SetReminderActivity.this.a("Error", quickPayAddResponse.getResponseMessage());
                                            return;
                                        }
                                        SetReminderActivity.this.a("Error", "Something went wrong");
                                    }

                                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                        SetReminderActivity.this.a();
                                        if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                                            SetReminderActivity.this.a("Error", "Something went wrong");
                                        } else {
                                            r.a(SetReminderActivity.this, (String) null, (Bundle) null, false, false);
                                        }
                                    }
                                }, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
                            }
                        }
                        this.j.setReminderDayOfWeek((String) null);
                        this.j.setReminderDateIndex(this.f60083d);
                        this.j.setReminderFrequency("monthly");
                        this.j.setType("QUICK_PAYMENTS");
                        this.j.setReminderDisplayName(this.f60085f);
                        this.j.setAmount(this.s);
                        this.j.getStartDate();
                        this.j.getNextReminderDate();
                        this.j.setStartDate((String) null);
                        this.j.setNextReminderDate((String) null);
                        SupportingData supportingData2 = new SupportingData();
                        supportingData2.setTagName(this.f60085f);
                        supportingData2.setTagUrl(this.f60084e);
                        supportingData2.setTagId((String) null);
                        supportingData2.setPaymentType("personal");
                        supportingData2.setBeneficiaryMobileNumber(this.l);
                        supportingData2.setBeneficiaryAccountNumber(this.n);
                        supportingData2.setBeneficiaryIfscCode(this.o);
                        supportingData2.setBeneficiaryName(this.p);
                        supportingData2.setBeneficiaryBankName(this.q);
                        supportingData2.setBeneficiaryUpiAddress(this.r);
                        supportingData2.setStoreFrontTitle(this.f60085f);
                        this.j.setSupportingData(supportingData2);
                        JSONObject jSONObject2 = new JSONObject(new com.google.gson.f().b(this.j));
                        a((Context) this, getResources().getString(R.string.loading));
                        d.a(this, a2, new com.paytm.network.listener.b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                SetReminderActivity.this.a();
                                if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                                    QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                                    if (quickPayAddResponse.getResponseCode() == 200) {
                                        SetReminderActivity.this.j.setId(String.valueOf(quickPayAddResponse.getPayload().getSiId()));
                                        SetReminderActivity setReminderActivity = SetReminderActivity.this;
                                        net.one97.paytm.quickpay.b.a.a((Context) setReminderActivity, setReminderActivity.j);
                                        net.one97.paytm.quickpay.d.a.a().a(net.one97.paytm.quickpay.b.a.a(SetReminderActivity.this));
                                        SetReminderActivity setReminderActivity2 = SetReminderActivity.this;
                                        String string = setReminderActivity2.getResources().getString(R.string.qp_saved_successfully);
                                        AnonymousClass1 r1 = new QuickPaymentActivity.a() {
                                            public final void a() {
                                                SetReminderActivity.this.setResult(-1);
                                                SetReminderActivity.this.finish();
                                            }
                                        };
                                        Dialog dialog = new Dialog(setReminderActivity2);
                                        dialog.setContentView(R.layout.reminder_success_creation_lyt);
                                        dialog.setCanceledOnTouchOutside(false);
                                        ((TextView) dialog.findViewById(R.id.qp_message_tv)).setText(string);
                                        if (!setReminderActivity2.isFinishing()) {
                                            dialog.getWindow().setLayout(-1, -2);
                                            dialog.show();
                                            new Handler().postDelayed(new Runnable(dialog, r1) {

                                                /* renamed from: a */
                                                final /* synthetic */ Dialog f59991a;

                                                /* renamed from: b */
                                                final /* synthetic */ a f59992b;

                                                /*  JADX ERROR: Method generation error
                                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.2.run():void, class status: UNLOADED
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
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                /*  JADX ERROR: Method generation error: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.2.run():void, class status: UNLOADED
                                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.2.run():void, class status: UNLOADED
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
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                public final void run(
/*
Method generation error in method: net.one97.paytm.quickpay.activity.QuickPaymentActivity.2.run():void, dex: classes6.dex
                                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.2.run():void, class status: UNLOADED
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
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                    SetReminderActivity.this.a("Error", quickPayAddResponse.getResponseMessage());
                                    return;
                                }
                                SetReminderActivity.this.a("Error", "Something went wrong");
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                SetReminderActivity.this.a();
                                if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                                    SetReminderActivity.this.a("Error", "Something went wrong");
                                } else {
                                    r.a(SetReminderActivity.this, (String) null, (Bundle) null, false, false);
                                }
                            }
                        }, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject2.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
                    } catch (JSONException e3) {
                        q.b(e3.getMessage());
                    }
                }
            } else {
                String a3 = d.b().a("updateQuickPaymentUrl");
                if (URLUtil.isValidUrl(a3)) {
                    String str = a3 + "?siId=" + this.f60082c + "&type=QUICK_PAYMENTS";
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Authorization", d.a().b((Context) this));
                    try {
                        this.j.setEnablePaymentsReminder(true);
                        this.j.setReminderTimeRange("9-23");
                        if (this.f60081a != 0) {
                            if (this.f60081a != 2 || TextUtils.isEmpty(this.f60083d)) {
                                if (this.f60081a != 1 || TextUtils.isEmpty(this.f60083d)) {
                                    a("", "Please select reminder");
                                    return;
                                }
                                this.j.setReminderDateIndex((String) null);
                                this.j.setReminderDayOfWeek(this.f60083d);
                                this.j.setReminderFrequency("weekly");
                                this.j.getStartDate();
                                this.j.getNextReminderDate();
                                this.j.setStartDate((String) null);
                                this.j.setNextReminderDate((String) null);
                                JSONObject jSONObject3 = new JSONObject(new com.google.gson.f().b(this.j));
                                a((Context) this, getResources().getString(R.string.loading));
                                d.a(this, str, new com.paytm.network.listener.b() {
                                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                        if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                                            QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                                            if (quickPayAddResponse.getResponseCode() == 200) {
                                                SetReminderActivity setReminderActivity = SetReminderActivity.this;
                                                SetReminderActivity.a(setReminderActivity, setReminderActivity.j.getId());
                                                return;
                                            }
                                            SetReminderActivity.this.a();
                                            String responseMessage = quickPayAddResponse.getResponseMessage();
                                            if (TextUtils.isEmpty(responseMessage)) {
                                                responseMessage = "Something went wrong";
                                            }
                                            SetReminderActivity.this.a("Error", responseMessage);
                                            return;
                                        }
                                        SetReminderActivity.this.a();
                                        SetReminderActivity.this.a("Error", "Something went wrong");
                                    }

                                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                        SetReminderActivity.this.a();
                                        if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                                            SetReminderActivity.this.a("Error", "Something went wrong");
                                        } else {
                                            r.a(SetReminderActivity.this, (String) null, (Bundle) null, false, false);
                                        }
                                    }
                                }, hashMap2, (Map<String, String>) null, a.C0715a.PUT, jSONObject3.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
                            }
                        }
                        this.j.setReminderDayOfWeek((String) null);
                        this.j.setReminderDateIndex(this.f60083d);
                        this.j.setReminderFrequency("monthly");
                        this.j.getStartDate();
                        this.j.getNextReminderDate();
                        this.j.setStartDate((String) null);
                        this.j.setNextReminderDate((String) null);
                        JSONObject jSONObject32 = new JSONObject(new com.google.gson.f().b(this.j));
                        a((Context) this, getResources().getString(R.string.loading));
                        d.a(this, str, new com.paytm.network.listener.b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                                    QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                                    if (quickPayAddResponse.getResponseCode() == 200) {
                                        SetReminderActivity setReminderActivity = SetReminderActivity.this;
                                        SetReminderActivity.a(setReminderActivity, setReminderActivity.j.getId());
                                        return;
                                    }
                                    SetReminderActivity.this.a();
                                    String responseMessage = quickPayAddResponse.getResponseMessage();
                                    if (TextUtils.isEmpty(responseMessage)) {
                                        responseMessage = "Something went wrong";
                                    }
                                    SetReminderActivity.this.a("Error", responseMessage);
                                    return;
                                }
                                SetReminderActivity.this.a();
                                SetReminderActivity.this.a("Error", "Something went wrong");
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                SetReminderActivity.this.a();
                                if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                                    SetReminderActivity.this.a("Error", "Something went wrong");
                                } else {
                                    r.a(SetReminderActivity.this, (String) null, (Bundle) null, false, false);
                                }
                            }
                        }, hashMap2, (Map<String, String>) null, a.C0715a.PUT, jSONObject32.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
                    } catch (JSONException e4) {
                        q.b(e4.getMessage());
                    }
                }
            }
        }
    }

    public final void a(String str, int i2) {
        this.f60083d = str;
        this.f60081a = i2;
    }

    static /* synthetic */ void a(SetReminderActivity setReminderActivity, String str) {
        String a2 = d.b().a("getQuickPaymentsUrl");
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b((Context) setReminderActivity));
            com.paytm.network.a a3 = d.a(setReminderActivity, a2 + "&siId=" + str, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    String str;
                    SetReminderActivity.this.a();
                    if (iJRPaytmDataModel != null) {
                        QuickListResponse quickListResponse = (QuickListResponse) iJRPaytmDataModel;
                        Payload payload = quickListResponse.getPayload();
                        if (payload == null || payload.getStandingInstructionList() == null || payload.getStandingInstructionList().size() <= 0) {
                            String responseMessage = quickListResponse.getResponseMessage();
                            if (TextUtils.isEmpty(responseMessage)) {
                                responseMessage = "Something went wrong";
                            }
                            SetReminderActivity.this.a("Error", responseMessage);
                            return;
                        }
                        StandingInstructionList standingInstructionList = payload.getStandingInstructionList().get(0);
                        if (standingInstructionList != null) {
                            net.one97.paytm.quickpay.b.a.a((Context) SetReminderActivity.this, standingInstructionList);
                            if (SetReminderActivity.this.f60081a == 0 || SetReminderActivity.this.f60081a == 2) {
                                str = SetReminderActivity.this.f60083d + " " + SetReminderActivity.this.getString(R.string.every_month);
                            } else {
                                str = SetReminderActivity.this.f60083d + " " + SetReminderActivity.this.getString(R.string.every_week);
                            }
                            String string = SetReminderActivity.this.getString(R.string.reminder_sucess_dialog_subtile, new Object[]{str});
                            SetReminderActivity setReminderActivity = SetReminderActivity.this;
                            Dialog dialog = new Dialog(setReminderActivity);
                            dialog.setContentView(R.layout.reminder_edit_success_screen);
                            dialog.setCanceledOnTouchOutside(false);
                            ((TextView) dialog.findViewById(R.id.qp_dialog_message_tv)).setText(string);
                            if (!setReminderActivity.isFinishing()) {
                                dialog.getWindow();
                                dialog.show();
                                new Handler().postDelayed(new Runnable(dialog, setReminderActivity) {

                                    /* renamed from: a */
                                    final /* synthetic */ Dialog f59997a;

                                    /* renamed from: b */
                                    final /* synthetic */ Activity f59998b;

                                    public final void run(
/*
Method generation error in method: net.one97.paytm.quickpay.activity.QuickPaymentActivity.4.run():void, dex: classes6.dex
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.4.run():void, class status: UNLOADED
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
                        SetReminderActivity.this.a("Error", responseMessage2);
                        return;
                    }
                    SetReminderActivity.this.a("Error", "Something went wrong");
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    SetReminderActivity.this.a();
                    SetReminderActivity.this.a("Error", "Something went wrong");
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new QuickListResponse(), a.c.PAYMENTS, a.b.SILENT);
            a3.a();
            if (com.paytm.utility.a.m(setReminderActivity)) {
                a3.a();
            }
        }
    }
}
