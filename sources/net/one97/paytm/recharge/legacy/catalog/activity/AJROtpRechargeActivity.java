package net.one97.paytm.recharge.legacy.catalog.activity;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.paytm.utility.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ab;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.aj;
import net.one97.paytm.recharge.common.e.al;
import net.one97.paytm.recharge.common.g.a;
import net.one97.paytm.recharge.common.utils.CJRSmsReceiver;
import net.one97.paytm.recharge.common.widget.b;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.CJRSendOTP;
import net.one97.paytm.recharge.model.CJRValidateOTP;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class AJROtpRechargeActivity extends PaytmActivity implements ab, aj, al {

    /* renamed from: a  reason: collision with root package name */
    private b f62782a;

    /* renamed from: b  reason: collision with root package name */
    private CJRSmsReceiver f62783b;

    /* renamed from: c  reason: collision with root package name */
    private a f62784c;

    /* renamed from: d  reason: collision with root package name */
    private String f62785d;

    /* renamed from: e  reason: collision with root package name */
    private String f62786e;

    /* renamed from: f  reason: collision with root package name */
    private final int f62787f = 1;

    /* renamed from: g  reason: collision with root package name */
    private final int f62788g = 2;

    /* renamed from: h  reason: collision with root package name */
    private final int f62789h = 3;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(CJRRechargeUtilities.INSTANCE.getRestringValue(context));
    }

    public void onCreate(Bundle bundle) {
        com.paytm.utility.b.e((Activity) this);
        setRequestedOrientation(1);
        super.onCreate(bundle);
        setContentView(R.layout.activity_otp_recharge);
        this.f62784c = new a(this, this);
        this.f62785d = getIntent().getStringExtra("user_mobile");
        this.f62786e = getIntent().getStringExtra("action_type");
        if (!TextUtils.isEmpty(this.f62785d) && !TextUtils.isEmpty(this.f62786e)) {
            String str = this.f62786e;
            b bVar = this.f62782a;
            if (bVar != null && bVar.isShowing()) {
                this.f62782a.dismiss();
            }
            this.f62782a = new b(this, str, this.f62785d, this.f62786e, this);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(this.f62782a.getWindow().getAttributes());
            layoutParams.width = -1;
            this.f62782a.setCancelable(false);
            this.f62782a.show();
            this.f62782a.setCanceledOnTouchOutside(false);
            this.f62782a.getWindow().setAttributes(layoutParams);
            b();
        }
    }

    public final void b(String str, String str2) {
        b bVar;
        String e2;
        if (!isFinishing() && (bVar = this.f62782a) != null && bVar.isShowing() && (e2 = com.paytm.utility.b.e(str, str2)) != null) {
            b bVar2 = this.f62782a;
            if (!TextUtils.isEmpty(e2) && e2.trim().length() == 6) {
                for (int i2 = 0; i2 < e2.length(); i2++) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        if (i2 == 5 && bVar2.l != null) {
                                            bVar2.l.setText(String.valueOf(e2.charAt(i2)));
                                        }
                                    } else if (bVar2.k != null) {
                                        bVar2.k.setText(String.valueOf(e2.charAt(i2)));
                                    }
                                } else if (bVar2.j != null) {
                                    bVar2.j.setText(String.valueOf(e2.charAt(i2)));
                                }
                            } else if (bVar2.f62140i != null) {
                                bVar2.f62140i.setText(String.valueOf(e2.charAt(i2)));
                            }
                        } else if (bVar2.f62139h != null) {
                            bVar2.f62139h.setText(String.valueOf(e2.charAt(i2)));
                        }
                    } else if (bVar2.f62138g != null) {
                        bVar2.f62138g.setText(String.valueOf(e2.charAt(i2)));
                    }
                }
            }
            a();
        }
    }

    public void onStop() {
        a();
        super.onStop();
    }

    public final void a(String str) {
        a aVar;
        if (!isFinishing()) {
            if (!com.paytm.utility.b.c((Context) this) || (aVar = this.f62784c) == null) {
                b bVar = this.f62782a;
                if (bVar != null && bVar.isShowing()) {
                    this.f62782a.a(1, (String) null, getResources().getString(R.string.no_internet), true);
                    this.f62782a.a(true);
                    this.f62782a.b(true);
                    return;
                }
                return;
            }
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a(ACTION_TYPE.OTP, ERROR_TYPE.UNDEFINED);
            c cVar = c.f62654a;
            String aG = c.aG();
            if (TextUtils.isEmpty(aG)) {
                aG = "https://accounts.paytm.com/v3/api/sendOtp";
            }
            if (URLUtil.isValidUrl(aG)) {
                String e2 = com.paytm.utility.b.e((Context) aVar.f61403a, aG);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("Authorization", com.paytm.utility.b.m());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("loginId", str);
                    jSONObject.put("actionType", "REGISTER");
                } catch (JSONException unused) {
                }
                if (com.paytm.utility.b.c((Context) aVar.f61403a)) {
                    aVar.f61403a.getApplicationContext();
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("send_otp_api", e2, (ai) aVar, (IJRPaytmDataModel) new CJRSendOTP(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), (Object) a2));
                }
            }
        }
    }

    public final void a(String str, String str2) {
        a aVar;
        if (!isFinishing()) {
            if (!com.paytm.utility.b.c((Context) this) || (aVar = this.f62784c) == null) {
                b bVar = this.f62782a;
                if (bVar != null && bVar.isShowing()) {
                    this.f62782a.a(2, (String) null, getResources().getString(R.string.no_internet), true);
                    this.f62782a.b(true);
                    return;
                }
                return;
            }
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a(ACTION_TYPE.OTP, ERROR_TYPE.UNDEFINED);
            c cVar = c.f62654a;
            String aF = c.aF();
            if (TextUtils.isEmpty(aF)) {
                aF = "https://accounts.paytm.com/v3/api/validateOtp";
            }
            if (URLUtil.isValidUrl(aF)) {
                String e2 = com.paytm.utility.b.e((Context) aVar.f61403a, aF);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("Authorization", com.paytm.utility.b.m());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("otp", str);
                    jSONObject.put("state", str2);
                } catch (JSONException unused) {
                }
                if (com.paytm.utility.b.c((Context) aVar.f61403a)) {
                    aVar.f61403a.getApplicationContext();
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c("verify_otp_api", e2, (ai) aVar, (IJRPaytmDataModel) new CJRValidateOTP(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), (Object) a2));
                }
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            setResult(-1);
        } else {
            setResult(0);
        }
        finish();
    }

    private void a() {
        try {
            if (this.f62783b != null) {
                unregisterReceiver(this.f62783b);
                this.f62783b.f61476a = null;
                this.f62783b = null;
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    private void b() {
        try {
            if (!isFinishing()) {
                if ((!s.a() || s.d((Context) this)) && this.f62783b == null) {
                    this.f62783b = new CJRSmsReceiver();
                    this.f62783b.f61476a = this;
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                    intentFilter.setPriority(1000);
                    registerReceiver(this.f62783b, intentFilter);
                }
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public final void a(CJRSendOTP cJRSendOTP) {
        b bVar;
        if (cJRSendOTP != null && (bVar = this.f62782a) != null && bVar.isShowing()) {
            String message = cJRSendOTP.getMessage();
            String status = cJRSendOTP.getStatus();
            String state = cJRSendOTP.getState();
            String responseCode = cJRSendOTP.getResponseCode();
            if (TextUtils.isEmpty(status) || !status.trim().equalsIgnoreCase("SUCCESS")) {
                this.f62782a.a(3, responseCode, message, true);
                return;
            }
            this.f62782a.a(2, responseCode, message, false);
            b bVar2 = this.f62782a;
            try {
                if (!TextUtils.isEmpty(state)) {
                    bVar2.n = state;
                }
                bVar2.c(false);
                bVar2.b(true);
                TextView textView = bVar2.m;
                textView.setText(" (00:" + String.format("%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(30000))}) + ")");
                bVar2.a(false);
                bVar2.m.setVisibility(0);
                new CountDownTimer() {
                    public final void onTick(
/*
Method generation error in method: net.one97.paytm.recharge.common.widget.b.1.onTick(long):void, dex: classes6.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.recharge.common.widget.b.1.onTick(long):void, class status: UNLOADED
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
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/

                    public final void onFinish(
/*
Method generation error in method: net.one97.paytm.recharge.common.widget.b.1.onFinish():void, dex: classes6.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.recharge.common.widget.b.1.onFinish():void, class status: UNLOADED
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
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                }.start();
            } catch (Exception unused) {
            }
            b();
        }
    }

    public final void a(CJRValidateOTP cJRValidateOTP) {
        b bVar;
        b bVar2;
        if (cJRValidateOTP != null && (bVar = this.f62782a) != null && bVar.isShowing()) {
            String responseCode = cJRValidateOTP.getResponseCode();
            String message = cJRValidateOTP.getMessage();
            String status = cJRValidateOTP.getStatus();
            if (!TextUtils.isEmpty(status) && status.trim().equalsIgnoreCase("SUCCESS")) {
                this.f62782a.c(false);
                a(true);
            }
            if (!TextUtils.isEmpty(responseCode) && (bVar2 = this.f62782a) != null && bVar2.isShowing()) {
                if (!responseCode.equals("708")) {
                    this.f62782a.a(2, responseCode, message, true);
                    this.f62782a.b(true);
                    return;
                }
                this.f62782a.a(3, responseCode, message, true);
            }
        }
    }
}
