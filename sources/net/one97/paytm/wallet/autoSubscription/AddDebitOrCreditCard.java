package net.one97.paytm.wallet.autoSubscription;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.binRequest.CJRBinRequest;
import net.one97.paytm.addmoney.common.binRequest.CJRBinRequestBody;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.Head;
import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.helper.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.autoSubscription.b;
import net.one97.paytm.wallet.c.d;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRBinResponse;
import net.one97.paytm.wallet.utility.f;

public class AddDebitOrCreditCard extends PaytmActivity implements View.OnClickListener, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f69933a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f69934b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f69935c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public EditText f69936d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f69937e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f69938f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f69939g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f69940h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f69941i;
    /* access modifiers changed from: private */
    public LinearLayout j;
    /* access modifiers changed from: private */
    public LinearLayout k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public int q;
    /* access modifiers changed from: private */
    public int r;
    private Context s;
    private ArrayList<String> t;
    /* access modifiers changed from: private */
    public ArrayList<IJRDataModel> u = new ArrayList<>();
    private final String v = AddDebitOrCreditCard.class.getName();
    private boolean w = false;
    private TextWatcher x = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (!TextUtils.isEmpty(charSequence)) {
                AddDebitOrCreditCard.this.f69937e.setVisibility(0);
            } else {
                AddDebitOrCreditCard.this.f69937e.setVisibility(8);
            }
            if (charSequence.length() <= 6) {
                String unused = AddDebitOrCreditCard.this.l = "";
                AddDebitOrCreditCard.this.j.setAlpha(1.0f);
                AddDebitOrCreditCard.this.k.setAlpha(1.0f);
                AddDebitOrCreditCard.this.f69938f.setImageDrawable((Drawable) null);
                AddDebitOrCreditCard.this.f69939g.setVisibility(8);
            } else if (AddDebitOrCreditCard.this.r < 7) {
                AddDebitOrCreditCard.a(AddDebitOrCreditCard.this, charSequence.toString().replace(" ", ""));
            }
            int unused2 = AddDebitOrCreditCard.this.r = charSequence.length();
        }

        public final void afterTextChanged(Editable editable) {
            String unused = AddDebitOrCreditCard.this.m = editable.toString().replace(" ", "");
            if (AddDebitOrCreditCard.this.p > 0 && AddDebitOrCreditCard.this.m.length() > AddDebitOrCreditCard.this.p - (AddDebitOrCreditCard.this.p / 5) && editable.toString().replace(" ", "").length() >= 6) {
                editable.delete(AddDebitOrCreditCard.this.p - (AddDebitOrCreditCard.this.p / 5), editable.length());
            }
            int i2 = 0;
            while (i2 < editable.length()) {
                if (' ' == editable.charAt(i2)) {
                    int i3 = i2 + 1;
                    if (i3 % 5 != 0 || i3 == editable.length()) {
                        editable.delete(i2, i3);
                    }
                }
                i2++;
            }
            for (int i4 = 4; i4 < editable.length(); i4 += 5) {
                if ("0123456789".indexOf(editable.charAt(i4)) >= 0) {
                    editable.insert(i4, " ");
                }
            }
            if (AddDebitOrCreditCard.this.f69934b.getSelectionStart() > 0 && editable.charAt(AddDebitOrCreditCard.this.f69934b.getSelectionStart() - 1) == ' ') {
                AddDebitOrCreditCard.this.f69934b.setSelection(AddDebitOrCreditCard.this.f69934b.getSelectionStart() - 1);
            }
            if (editable.toString().length() != AddDebitOrCreditCard.this.p || TextUtils.isEmpty(AddDebitOrCreditCard.this.m)) {
                AddDebitOrCreditCard.this.f69940h.setText(AddDebitOrCreditCard.this.getString(R.string.enter_card_number));
                AddDebitOrCreditCard.this.f69940h.setTextColor(androidx.core.content.b.c(AddDebitOrCreditCard.this, R.color.color_444444));
                AddDebitOrCreditCard.this.f69934b.setBackground(AddDebitOrCreditCard.this.getResources().getDrawable(R.drawable.white_background_with_border_addmoney));
            } else if (!SDKConstants.MAESTRO.equalsIgnoreCase(AddDebitOrCreditCard.this.l)) {
                AddDebitOrCreditCard.this.f69936d.requestFocus();
            }
        }
    };
    private TextWatcher y = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AddDebitOrCreditCard.this.f69941i.setText(AddDebitOrCreditCard.this.getResources().getString(R.string.expiry_validity_date));
            AddDebitOrCreditCard.this.f69941i.setTextColor(androidx.core.content.b.c(AddDebitOrCreditCard.this, R.color.color_444444));
            AddDebitOrCreditCard.this.f69936d.setBackground(AddDebitOrCreditCard.this.getResources().getDrawable(R.drawable.white_background_with_border_addmoney));
            StringBuilder sb = new StringBuilder(charSequence);
            if (sb.length() > 0 && sb.length() == 3 && '/' == sb.charAt(sb.length() - 1)) {
                sb.delete(sb.length() - 1, sb.length());
            }
            if (sb.length() > 0 && sb.length() == 3 && Character.isDigit(sb.charAt(sb.length() - 1))) {
                sb.insert(sb.length() - 1, "/");
            }
            AddDebitOrCreditCard.this.f69936d.removeTextChangedListener(this);
            AddDebitOrCreditCard.this.f69936d.setText(sb);
            AddDebitOrCreditCard.this.f69936d.setSelection(sb.length());
            AddDebitOrCreditCard.this.f69936d.addTextChangedListener(this);
            if (sb.length() == 5 && AddDebitOrCreditCard.this.j.isEnabled()) {
                AddDebitOrCreditCard.this.f69935c.requestFocus();
            }
        }
    };

    public void attachBaseContext(Context context) {
        super.attachBaseContext(a.b().a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = this;
        setContentView(R.layout.add_debit_credit_card_lyt_addmoney);
        int color = getResources().getColor(R.color.white);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(color);
            }
        }
        if (getIntent().hasExtra("CARD_ID_LIST")) {
            this.t = getIntent().getStringArrayListExtra("CARD_ID_LIST");
        }
        if (getIntent().hasExtra("skip_verify_call")) {
            this.w = getIntent().getBooleanExtra("skip_verify_call", false);
        }
        this.f69934b = (EditText) findViewById(R.id.editText);
        this.f69937e = (ImageView) findViewById(R.id.iv_clear);
        this.f69939g = (TextView) findViewById(R.id.tv_low_success);
        this.j = (LinearLayout) findViewById(R.id.ll_new_card_cvv);
        this.k = (LinearLayout) findViewById(R.id.ll_expiry);
        this.f69935c = (EditText) findViewById(R.id.et_new_card_cvv);
        this.f69938f = (ImageView) findViewById(R.id.iv_card_logo);
        this.f69940h = (TextView) findViewById(R.id.tv_enter_card_number);
        this.f69936d = (EditText) findViewById(R.id.et_expiry_validity);
        this.f69941i = (TextView) findViewById(R.id.tv_expiry_validity);
        this.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
        this.f69936d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        this.f69935c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        this.f69934b.addTextChangedListener(this.x);
        this.f69936d.addTextChangedListener(this.y);
        this.f69935c.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() == AddDebitOrCreditCard.this.q) {
                    AddDebitOrCreditCard addDebitOrCreditCard = AddDebitOrCreditCard.this;
                    AddDebitOrCreditCard.a(addDebitOrCreditCard, (View) addDebitOrCreditCard.f69935c);
                }
            }
        });
        findViewById(R.id.tv_cvv_help).setOnClickListener(this);
        findViewById(R.id.et_expiry_validity).setOnClickListener(this);
        findViewById(R.id.rl_proceed_to_pay).setOnClickListener(this);
        findViewById(R.id.back_arrow).setOnClickListener(this);
        this.f69937e.setOnClickListener(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1021) {
            String stringExtra = intent.getStringExtra("order_id");
            boolean booleanExtra = intent.getBooleanExtra(AppConstants.IS_CANCEL, false);
            if ("true".equalsIgnoreCase(intent.getStringExtra("retry_allowed"))) {
                String stringExtra2 = intent.getStringExtra("error_message");
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = getResources().getString(R.string.auto_card_not_auto_debit);
                }
                com.paytm.utility.b.b((Context) this, "Error", stringExtra2);
            } else if (booleanExtra) {
                com.paytm.utility.b.b((Context) this, "", getResources().getString(R.string.auto_card_not_auto_debit));
            } else if (!this.w) {
                AnonymousClass1 r5 = new h() {
                    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel instanceof CJROrderSummary) {
                            String paymentStatus = ((CJROrderSummary) iJRPaytmDataModel).getPaymentStatus();
                            if (paymentStatus.equalsIgnoreCase("SUCCESS")) {
                                AddDebitOrCreditCard.a(AddDebitOrCreditCard.this);
                                return;
                            }
                            paymentStatus.equalsIgnoreCase("FAILED");
                            AddDebitOrCreditCard addDebitOrCreditCard = AddDebitOrCreditCard.this;
                            com.paytm.utility.b.b((Context) addDebitOrCreditCard, "", addDebitOrCreditCard.getResources().getString(R.string.auto_card_not_auto_debit));
                        }
                    }

                    public final void b(NetworkCustomError networkCustomError) {
                        AddDebitOrCreditCard addDebitOrCreditCard = AddDebitOrCreditCard.this;
                        com.paytm.utility.b.b((Context) addDebitOrCreditCard, "", addDebitOrCreditCard.getResources().getString(R.string.auto_card_not_auto_debit));
                    }
                };
                String str = a.b().f("orderdetail") + stringExtra;
                f fVar = f.f72321a;
                String a2 = f.a(com.paytm.utility.b.b((Context) this, str) + "&actions=1");
                f fVar2 = f.f72321a;
                String b2 = f.b(a2);
                com.paytm.network.b a3 = net.one97.paytm.addmoney.common.a.a();
                a3.f42880d = b2;
                a3.f42885i = new CJROrderSummary();
                a3.o = "AutoSubscriptionUtil";
                a3.j = new com.paytm.network.listener.b(this, r5) {

                    /* renamed from: a */
                    final /* synthetic */ Activity f69956a;

                    /* renamed from: b */
                    final /* synthetic */ h f69957b;

                    public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.wallet.autoSubscription.a.2.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes7.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.wallet.autoSubscription.a.2.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
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

                    public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.wallet.autoSubscription.a.2.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.wallet.autoSubscription.a.2.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
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
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
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
                };
                com.paytm.network.a l2 = a3.l();
                if (com.paytm.utility.b.c((Context) this)) {
                    k.a(this).a();
                    l2.a();
                    return;
                }
                com.paytm.utility.b.b((Context) this, "", getResources().getString(R.string.auto_card_not_auto_debit));
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("order_id", stringExtra);
                intent2.putExtra(SDKConstants.AI_KEY_CARD_NUMBER, this.o);
                setResult(-1, intent2);
                finish();
            }
        }
    }

    public void onClick(View view) {
        d dVar;
        int id = view.getId();
        if (id == R.id.back_arrow) {
            com.paytm.utility.b.c((Activity) this);
            onBackPressed();
        } else if (id == R.id.iv_clear) {
            this.f69934b.getText().clear();
        } else if (id == R.id.tv_cvv_help) {
            if (TextUtils.isEmpty(this.l)) {
                dVar = d.a(d.b.ALL);
            } else if (!this.l.equalsIgnoreCase(SDKConstants.AMEX)) {
                dVar = d.a(d.b.NON_AMEX);
            } else {
                dVar = d.a(d.b.AMEX);
            }
            dVar.show(getSupportFragmentManager(), (String) null);
        } else if (id == R.id.et_expiry_validity) {
            EditText editText = this.f69936d;
            editText.setSelection(editText.getText().length());
        } else if (id == R.id.rl_proceed_to_pay) {
            com.paytm.utility.b.c((Activity) this);
            int length = this.f69934b.getText().length();
            if (TextUtils.isEmpty(this.f69934b.getText()) || length < 17 || length > 23) {
                this.f69940h.setText(this.s.getString(R.string.enter_valid_card_number));
                this.f69940h.setTextColor(androidx.core.content.b.c(this.s, R.color.color_fd5c5c));
                this.f69934b.setBackground(androidx.core.content.b.a(this.s, R.drawable.red_background_with_border_addmoney));
                return;
            }
            String str = this.l;
            if (str == null) {
                this.f69934b.setBackground(androidx.core.content.b.a(this.s, R.drawable.white_background_with_border_addmoney));
                this.f69940h.setText(this.s.getString(R.string.enter_card_number));
                this.f69940h.setTextColor(androidx.core.content.b.c(this.s, R.color.color_444444));
            } else if ((!str.equalsIgnoreCase(SDKConstants.DINERS) || length == 17) && ((!this.l.equalsIgnoreCase(SDKConstants.AMEX) || length == 18) && (((!this.l.equalsIgnoreCase("DISCOVER") && !this.l.equalsIgnoreCase(SDKConstants.VISA) && !this.l.equalsIgnoreCase(SDKConstants.MASTER) && !this.l.equalsIgnoreCase("RUPAY")) || length == 19) && (!this.l.equalsIgnoreCase(SDKConstants.MAESTRO) || length == 23)))) {
                this.f69934b.setBackground(androidx.core.content.b.a(this.s, R.drawable.white_background_with_border_addmoney));
                this.f69940h.setText(this.s.getString(R.string.enter_card_number));
                this.f69940h.setTextColor(androidx.core.content.b.c(this.s, R.color.color_444444));
                if (!this.l.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                    if (!TextUtils.isEmpty(this.f69936d.getText().toString()) && this.f69936d.getText().length() >= 5) {
                        String[] split = this.f69936d.getText().toString().split("/");
                        boolean z = true;
                        split[1] = b(split[1]);
                        Calendar instance = Calendar.getInstance();
                        if (Integer.valueOf(split[0]).intValue() > 12 || (Integer.valueOf(split[1]).intValue() <= instance.get(1) && (Integer.valueOf(split[1]).intValue() != instance.get(1) || Integer.valueOf(split[0]).intValue() <= instance.get(2)))) {
                            z = false;
                        }
                        if (z) {
                            if (this.f69935c.getText().length() < this.q) {
                                Toast.makeText(this.s, this.s.getString(R.string.enter_valid_cvv), 0).show();
                                return;
                            }
                        }
                    }
                    this.f69941i.setText(this.s.getString(R.string.invalid_expiry_date));
                    this.f69941i.setTextColor(androidx.core.content.b.c(this.s, R.color.color_fd5c5c));
                    this.f69936d.setBackground(androidx.core.content.b.a(this.s, R.drawable.red_background_with_border_addmoney));
                    return;
                }
                c();
            } else {
                this.f69940h.setText(this.s.getString(R.string.enter_valid_card_number));
                this.f69940h.setTextColor(androidx.core.content.b.c(this.s, R.color.color_fd5c5c));
                this.f69934b.setBackground(androidx.core.content.b.a(this.s, R.drawable.red_background_with_border_addmoney));
            }
        }
    }

    private void c() {
        a.a(this, this.v, new h() {
            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                String str;
                if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRRechargePayment)) {
                    CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                    String r = AddDebitOrCreditCard.this.n;
                    AddDebitOrCreditCard addDebitOrCreditCard = AddDebitOrCreditCard.this;
                    String unused = addDebitOrCreditCard.o = addDebitOrCreditCard.f69934b.getText().toString().replace(" ", "");
                    String obj = AddDebitOrCreditCard.this.f69935c.getText().toString();
                    AddDebitOrCreditCard.this.f69936d.getText();
                    String[] split = AddDebitOrCreditCard.this.f69936d.getText().toString().split("/");
                    if (!SDKConstants.MAESTRO.equalsIgnoreCase(AddDebitOrCreditCard.this.l)) {
                        str = "|" + AddDebitOrCreditCard.this.o + "|" + obj + "|" + split[0] + AddDebitOrCreditCard.b(split[1]);
                    } else {
                        str = "|" + AddDebitOrCreditCard.this.o + "||";
                    }
                    String str2 = str;
                    AddDebitOrCreditCard addDebitOrCreditCard2 = AddDebitOrCreditCard.this;
                    HashMap<String, String> a2 = AddMoneyUtils.a("otp", cJRRechargePayment.getmTxnToken(), cJRRechargePayment.getMID(), cJRRechargePayment.getOrderId(), r.equalsIgnoreCase(SDKConstants.DEBIT) ? SDKConstants.DEBIT : SDKConstants.CREDIT, str2, "1");
                    Intent f2 = a.b().f((Activity) addDebitOrCreditCard2);
                    cJRRechargePayment.setmPGParams(a2);
                    cJRRechargePayment.setmPGUrlToHit(a.b().f("processTxnAddMoneyURL") + "?mid=" + cJRRechargePayment.getMID() + "&orderId=" + cJRRechargePayment.getmOrderId());
                    f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                    f2.putExtra("auto_add_money", true);
                    addDebitOrCreditCard2.startActivityForResult(f2, 1021);
                }
            }

            public final void b(NetworkCustomError networkCustomError) {
                if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    AddDebitOrCreditCard addDebitOrCreditCard = AddDebitOrCreditCard.this;
                    AddMoneyUtils.a(addDebitOrCreditCard, networkCustomError, addDebitOrCreditCard.getClass().getName(), Boolean.FALSE);
                }
                if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                    AddDebitOrCreditCard addDebitOrCreditCard2 = AddDebitOrCreditCard.this;
                    AddDebitOrCreditCard.a(addDebitOrCreditCard2, addDebitOrCreditCard2.getString(R.string.error), networkCustomError.getAlertMessage());
                    return;
                }
                AddDebitOrCreditCard addDebitOrCreditCard3 = AddDebitOrCreditCard.this;
                AddDebitOrCreditCard.a(addDebitOrCreditCard3, addDebitOrCreditCard3.getString(R.string.error), "Something went wrong");
            }
        });
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        String valueOf = String.valueOf(Calendar.getInstance().get(1) / 100);
        StringBuilder sb = new StringBuilder(str);
        sb.insert(0, valueOf);
        return sb.toString();
    }

    private void a(Context context, String str) {
        ProgressDialog progressDialog = this.f69933a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f69933a = new ProgressDialog(context);
            try {
                this.f69933a.setProgressStyle(0);
                this.f69933a.setMessage(str);
                this.f69933a.setCancelable(false);
                this.f69933a.setCanceledOnTouchOutside(false);
                this.f69933a.show();
            } catch (IllegalArgumentException e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a() {
        try {
            if (this.f69933a != null && this.f69933a.isShowing() && !isFinishing()) {
                this.f69933a.dismiss();
                this.f69933a = null;
            }
        } catch (Exception e2) {
            a.b().a(e2);
        }
    }

    public final void b() {
        c();
    }

    static /* synthetic */ void a(AddDebitOrCreditCard addDebitOrCreditCard) {
        addDebitOrCreditCard.a((Context) addDebitOrCreditCard, addDebitOrCreditCard.getString(R.string.please_wait_fetch_card));
        String str = a.b().f("fetch_subscription_cards") + com.paytm.utility.b.n((Context) addDebitOrCreditCard) + "/DC";
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", com.paytm.utility.a.q(addDebitOrCreditCard));
        hashMap.put("token_type", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.USER);
        hashMap.put("Content-Type", "application/json");
        if (com.paytm.utility.b.c((Context) addDebitOrCreditCard)) {
            com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
            a2.f42882f = hashMap;
            a2.f42880d = str;
            a2.f42885i = new CJRAvailableInstrumentsAddMoney();
            a2.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    AddDebitOrCreditCard.this.a();
                    if (iJRPaytmDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard) {
                        AddDebitOrCreditCard.this.a();
                        CJRAvailableInstrumentsAddMoney cJRAvailableInstrumentsAddMoney = (CJRAvailableInstrumentsAddMoney) iJRPaytmDataModel;
                        if (!(cJRAvailableInstrumentsAddMoney == null || cJRAvailableInstrumentsAddMoney.getData() == null || cJRAvailableInstrumentsAddMoney.getData().size() <= 0)) {
                            AddDebitOrCreditCard.this.u.addAll(cJRAvailableInstrumentsAddMoney.getData());
                        }
                    }
                    AddDebitOrCreditCard.u(AddDebitOrCreditCard.this);
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AddDebitOrCreditCard.u(AddDebitOrCreditCard.this);
                }
            };
            a2.l().a();
        }
    }

    static /* synthetic */ void a(AddDebitOrCreditCard addDebitOrCreditCard, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) addDebitOrCreditCard.getSystemService("input_method");
        if (view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    static /* synthetic */ void a(AddDebitOrCreditCard addDebitOrCreditCard, String str) {
        HashMap hashMap = new HashMap();
        CJRBinRequest cJRBinRequest = new CJRBinRequest();
        Head head = new Head(SDKConstants.SSO, com.paytm.utility.a.q(addDebitOrCreditCard), "M", "roboso21355757629213", "1", "V1");
        head.setRequestTimeStamp("1");
        CJRBinRequestBody cJRBinRequestBody = new CJRBinRequestBody();
        cJRBinRequestBody.setBin(str);
        cJRBinRequestBody.setIndutryTypeId(SDKConstants.KEY_RETAIL);
        cJRBinRequestBody.setDeviceId(com.paytm.utility.b.A((Context) addDebitOrCreditCard));
        cJRBinRequestBody.setChannelId("WEB");
        cJRBinRequestBody.setSignature("1");
        cJRBinRequestBody.setRequestType("OFFLINE");
        cJRBinRequestBody.setOrderId("123456");
        cJRBinRequest.setBody(cJRBinRequestBody);
        cJRBinRequest.setHead(head);
        String a2 = AddMoneyUtils.a((Object) cJRBinRequest);
        hashMap.put("Content-Type", "application/json");
        String f2 = a.b().f("offline_pg_fetch_bin_URL");
        com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
        b2.f42882f = hashMap;
        b2.f42880d = f2;
        b2.f42884h = a2;
        b2.f42885i = new CJRBinResponse();
        b2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                CJRBinResponse cJRBinResponse;
                if ((iJRPaytmDataModel instanceof CJRBinResponse) && (cJRBinResponse = (CJRBinResponse) iJRPaytmDataModel) != null && cJRBinResponse.getBody() != null && cJRBinResponse.getBody().getBinDetail() != null) {
                    HasLowSuccess hasLowSuccess = cJRBinResponse.getBody().getBinDetail().getHasLowSuccess();
                    if (hasLowSuccess != null) {
                        AddDebitOrCreditCard.a(AddDebitOrCreditCard.this, hasLowSuccess);
                    }
                    String unused = AddDebitOrCreditCard.this.l = cJRBinResponse.getBody().getBinDetail().getChannelName().toLowerCase();
                    String unused2 = AddDebitOrCreditCard.this.n = cJRBinResponse.getBody().getBinDetail().getPaymentMode();
                    AddDebitOrCreditCard.q(AddDebitOrCreditCard.this);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                AddDebitOrCreditCard.class.getSimpleName();
                q.d(networkCustomError.getMessage());
            }
        };
        b2.l().a();
    }

    static /* synthetic */ void a(AddDebitOrCreditCard addDebitOrCreditCard, HasLowSuccess hasLowSuccess) {
        if (hasLowSuccess.getStatus()) {
            addDebitOrCreditCard.f69939g.setVisibility(0);
            addDebitOrCreditCard.f69939g.setText(hasLowSuccess.getMsg());
        }
    }

    static /* synthetic */ void q(AddDebitOrCreditCard addDebitOrCreditCard) {
        if (addDebitOrCreditCard.l.equalsIgnoreCase(SDKConstants.MAESTRO)) {
            addDebitOrCreditCard.j.setAlpha(0.4f);
            addDebitOrCreditCard.j.setEnabled(false);
            addDebitOrCreditCard.f69935c.setEnabled(false);
            addDebitOrCreditCard.k.setAlpha(0.4f);
            addDebitOrCreditCard.k.setEnabled(false);
            addDebitOrCreditCard.f69936d.setEnabled(false);
        } else {
            addDebitOrCreditCard.j.setAlpha(1.0f);
            addDebitOrCreditCard.j.setEnabled(true);
            addDebitOrCreditCard.f69935c.setEnabled(true);
            addDebitOrCreditCard.k.setAlpha(1.0f);
            addDebitOrCreditCard.k.setEnabled(true);
            addDebitOrCreditCard.f69936d.setEnabled(true);
        }
        if (addDebitOrCreditCard.l.equalsIgnoreCase(SDKConstants.VISA)) {
            addDebitOrCreditCard.f69938f.setImageDrawable(androidx.core.content.b.a((Context) addDebitOrCreditCard, R.drawable.visa_logo_addmoney));
            addDebitOrCreditCard.f69935c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
            addDebitOrCreditCard.p = 19;
            addDebitOrCreditCard.q = 3;
        } else if (addDebitOrCreditCard.l.equalsIgnoreCase(SDKConstants.MASTER)) {
            addDebitOrCreditCard.f69935c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
            addDebitOrCreditCard.f69938f.setImageDrawable(androidx.core.content.b.a((Context) addDebitOrCreditCard, R.drawable.ic_mastercard_logo_addmoney));
            addDebitOrCreditCard.p = 19;
            addDebitOrCreditCard.q = 3;
        } else if (addDebitOrCreditCard.l.equalsIgnoreCase(SDKConstants.DINERS)) {
            addDebitOrCreditCard.f69938f.setImageDrawable(androidx.core.content.b.a((Context) addDebitOrCreditCard, R.drawable.diners_addmoney));
            addDebitOrCreditCard.f69935c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(17)});
            addDebitOrCreditCard.p = 17;
            addDebitOrCreditCard.q = 3;
        } else if (addDebitOrCreditCard.l.equalsIgnoreCase(SDKConstants.MAESTRO)) {
            addDebitOrCreditCard.j.setEnabled(false);
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
            addDebitOrCreditCard.f69938f.setImageDrawable(androidx.core.content.b.a((Context) addDebitOrCreditCard, R.drawable.maestro_icon_addmoney));
            addDebitOrCreditCard.p = 23;
        } else if (addDebitOrCreditCard.l.equalsIgnoreCase(SDKConstants.AMEX)) {
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
            addDebitOrCreditCard.f69935c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            addDebitOrCreditCard.f69938f.setImageDrawable(androidx.core.content.b.a((Context) addDebitOrCreditCard, R.drawable.amex_addmoney));
            addDebitOrCreditCard.p = 23;
            addDebitOrCreditCard.q = 4;
        } else if (addDebitOrCreditCard.l.equalsIgnoreCase("JCB")) {
            addDebitOrCreditCard.f69935c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
            addDebitOrCreditCard.f69938f.setImageDrawable(androidx.core.content.b.a((Context) addDebitOrCreditCard, R.drawable.jcb_addmoney));
            addDebitOrCreditCard.p = 19;
            addDebitOrCreditCard.q = 3;
        } else if (addDebitOrCreditCard.l.equalsIgnoreCase("RUPAY")) {
            addDebitOrCreditCard.f69935c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
            addDebitOrCreditCard.f69938f.setImageDrawable(androidx.core.content.b.a((Context) addDebitOrCreditCard, R.drawable.rupay_addmoney));
            addDebitOrCreditCard.p = 19;
            addDebitOrCreditCard.q = 3;
        } else {
            addDebitOrCreditCard.p = 23;
            addDebitOrCreditCard.f69934b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
            addDebitOrCreditCard.q = 3;
        }
        addDebitOrCreditCard.f69938f.setVisibility(0);
    }

    static /* synthetic */ void a(AddDebitOrCreditCard addDebitOrCreditCard, String str, String str2) {
        final com.paytm.utility.h hVar = new com.paytm.utility.h(addDebitOrCreditCard);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.setCanceledOnTouchOutside(false);
        hVar.a(-3, addDebitOrCreditCard.getResources().getString(R.string.p2p_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.cancel();
            }
        });
        hVar.show();
    }

    static /* synthetic */ void u(AddDebitOrCreditCard addDebitOrCreditCard) {
        if (a.b().g("isCreditCardEnabledForSubscription")) {
            addDebitOrCreditCard.a((Context) addDebitOrCreditCard, addDebitOrCreditCard.getString(R.string.please_wait_fetch_card));
            String str = a.b().f("fetch_subscription_cards") + com.paytm.utility.b.n((Context) addDebitOrCreditCard) + "/CC";
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", com.paytm.utility.a.q(addDebitOrCreditCard));
            hashMap.put("token_type", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.USER);
            hashMap.put("Content-Type", "application/json");
            if (com.paytm.utility.b.c((Context) addDebitOrCreditCard)) {
                com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
                a2.f42882f = hashMap;
                a2.f42880d = str;
                a2.f42885i = new CJRAvailableInstrumentsAddMoneyCreditCard();
                a2.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        CJRAvailableInstrumentsAddMoneyCreditCard cJRAvailableInstrumentsAddMoneyCreditCard;
                        AddDebitOrCreditCard.this.a();
                        if ((iJRPaytmDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard) && (cJRAvailableInstrumentsAddMoneyCreditCard = (CJRAvailableInstrumentsAddMoneyCreditCard) iJRPaytmDataModel) != null && cJRAvailableInstrumentsAddMoneyCreditCard.getData() != null && cJRAvailableInstrumentsAddMoneyCreditCard.getData().size() > 0) {
                            AddDebitOrCreditCard.this.u.addAll(cJRAvailableInstrumentsAddMoneyCreditCard.getData());
                        }
                        AddDebitOrCreditCard.v(AddDebitOrCreditCard.this);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        AddDebitOrCreditCard.this.a();
                        AddDebitOrCreditCard.v(AddDebitOrCreditCard.this);
                        AddDebitOrCreditCard.class.getSimpleName();
                        q.d(networkCustomError.getMessage());
                    }
                };
                a2.l().a();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney$Card} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney$Card} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney$Card} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void v(net.one97.paytm.wallet.autoSubscription.AddDebitOrCreditCard r5) {
        /*
            java.util.ArrayList<java.lang.String> r0 = r5.t
            r1 = 0
            if (r0 == 0) goto L_0x0040
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r5.u
            if (r0 == 0) goto L_0x0040
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r0.next()
            net.one97.paytm.common.entity.IJRDataModel r2 = (net.one97.paytm.common.entity.IJRDataModel) r2
            boolean r3 = r2 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card
            if (r3 == 0) goto L_0x002d
            net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard$Card r2 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard.Card) r2
            java.util.ArrayList<java.lang.String> r3 = r5.t
            java.lang.String r4 = r2.getSavedCardId()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x000d
        L_0x002b:
            r1 = r2
            goto L_0x000d
        L_0x002d:
            boolean r3 = r2 instanceof net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card
            if (r3 == 0) goto L_0x000d
            net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney$Card r2 = (net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney.Card) r2
            java.util.ArrayList<java.lang.String> r3 = r5.t
            java.lang.String r4 = r2.getSavedCardId()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x000d
            goto L_0x002b
        L_0x0040:
            if (r1 == 0) goto L_0x0054
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r2 = "ENTITY"
            r0.putExtra(r2, r1)
            r1 = -1
            r5.setResult(r1, r0)
            r5.finish()
            return
        L_0x0054:
            android.content.res.Resources r0 = r5.getResources()
            int r1 = net.one97.paytm.addmoney.R.string.auto_not_supported_card
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = ""
            com.paytm.utility.b.b((android.content.Context) r5, (java.lang.String) r1, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.autoSubscription.AddDebitOrCreditCard.v(net.one97.paytm.wallet.autoSubscription.AddDebitOrCreditCard):void");
    }
}
