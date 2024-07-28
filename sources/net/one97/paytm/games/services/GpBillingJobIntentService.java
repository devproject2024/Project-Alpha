package net.one97.paytm.games.services;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.GamesSafeJobIntentService;
import com.android.billingclient.api.g;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import net.one97.paytm.games.d.a;
import net.one97.paytm.games.e.d;
import net.one97.paytm.games.e.e;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.GpPostTxnDataRequest;
import net.one97.paytm.games.model.GpPostTxnDataResponse;
import net.one97.paytm.games.model.GpTxnDatum;
import net.one97.paytm.games.model.core.CJRSignupUser;
import org.json.JSONException;
import org.json.JSONObject;

public class GpBillingJobIntentService extends GamesSafeJobIntentService implements b, a.C0594a {
    private static final String j = GpBillingJobIntentService.class.getSimpleName();
    private final int k = 200;
    private final int l = 201;
    private final int m = 202;
    private final int n = 203;
    private final int o = 401;
    private final int p = KeyList.IntentRequestKey.INTENT_USER_CENTER_RESULT_ACTION_CLEAR;
    private int q;
    private int r = 200;
    /* access modifiers changed from: private */
    public a s;
    private List<g> t;
    private List<g> u = new ArrayList();
    private JSONObject v;
    private String w;
    private int x = 401;
    private Queue<String> y = new LinkedList();

    public void onCreate() {
        super.onCreate();
        if (this.s == null) {
            this.s = new a(this, this);
        }
    }

    private static void a(Context context, Intent intent) {
        a(context, (Class<?>) GpBillingJobIntentService.class, 1000, intent);
    }

    public final void a(Intent intent) {
        this.q = intent.getIntExtra("work_id", -1);
        int i2 = this.q;
        if (i2 == 101) {
            this.w = intent.getStringExtra("sps_id");
            try {
                this.v = new JSONObject(d.a((Context) this).b());
                if (this.w == null) {
                    this.x = KeyList.IntentRequestKey.INTENT_USER_CENTER_RESULT_ACTION_CLEAR;
                    Iterator<String> keys = this.v.keys();
                    while (keys.hasNext()) {
                        this.y.add(keys.next());
                    }
                }
                if (this.w == null) {
                    this.w = this.y.poll();
                }
                c();
                d();
                f();
            } catch (JSONException e2) {
                e2.getStackTrace();
            }
        } else if (i2 == 102) {
            try {
                this.v = new JSONObject(d.a((Context) this).a());
                e();
                a aVar = this.s;
                if (aVar != null && aVar.f35575d == 0) {
                    this.r = 202;
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            if (GpBillingJobIntentService.this.s != null) {
                                a a2 = GpBillingJobIntentService.this.s;
                                a2.a((Runnable) new Runnable() {
                                    public final void run(
/*
Method generation error in method: net.one97.paytm.games.d.a.5.run():void, dex: classes13.dex
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.games.d.a.5.run():void, class status: UNLOADED
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
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
                                });
                            }
                        }
                    });
                    d();
                    f();
                }
            } catch (JSONException e3) {
                e3.getStackTrace();
            }
        }
    }

    private void c() {
        String str = this.w;
        if (str == null) {
            this.r = 203;
            return;
        }
        String optString = this.v.optString(str);
        if (!f.a((Object) optString)) {
            net.one97.paytm.games.e.a.a((Context) this, (HashMap<String, String>) (HashMap) new com.google.gson.f().a(optString, new com.google.gson.b.a<HashMap<String, String>>() {
            }.getType()), (b) this, j, a.b.SILENT);
        }
    }

    private void d() {
        while (this.r != 203) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void e() {
        while (this.r != 201) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void f() {
        this.t = null;
        this.r = 201;
        this.u = new ArrayList();
        this.w = null;
        this.v = null;
        this.x = 401;
        this.y = new LinkedList();
    }

    public final void Y_() {
        this.r = 201;
    }

    public final void a(int i2, List<g> list) {
        if (i2 != 0 || list == null || list.isEmpty()) {
            this.r = 203;
            return;
        }
        this.t = list;
        List<g> list2 = this.t;
        if (list2 == null || list2.size() == 0 || this.v == null) {
            this.r = 203;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (g next : this.t) {
            try {
                CJRSignupUser a2 = net.one97.paytm.games.b.a.a();
                String str = (a2 == null || f.a((Object) a2.masked_msisdn)) ? null : a2.masked_msisdn;
                if (!this.v.keys().hasNext()) {
                    arrayList.add(new GpTxnDatum(next, (String) null, (String) null, str));
                } else {
                    String str2 = (String) this.v.opt(next.a());
                    if (str2 != null) {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (!jSONObject.optBoolean("is_verified")) {
                            arrayList.add(new GpTxnDatum(next, jSONObject.optString("sku_type"), jSONObject.optString("sps_txn_id"), str));
                        } else {
                            this.u.add(next);
                        }
                    }
                }
            } catch (JSONException e2) {
                q.b(e2.getMessage());
                this.r = 203;
                return;
            }
        }
        this.t.removeAll(this.u);
        if (arrayList.size() == 0) {
            g();
            return;
        }
        GpPostTxnDataRequest gpPostTxnDataRequest = new GpPostTxnDataRequest();
        gpPostTxnDataRequest.setFlag(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT);
        gpPostTxnDataRequest.setPackageName(getPackageName());
        gpPostTxnDataRequest.setResponseCode(i2);
        gpPostTxnDataRequest.setResponseMessage(e.a(i2));
        gpPostTxnDataRequest.setItems(arrayList);
        net.one97.paytm.games.e.a.a(this, gpPostTxnDataRequest, this, 4, j, a.b.SILENT);
    }

    private void g() {
        List<g> list = this.u;
        if (list == null || list.size() == 0) {
            this.r = 203;
            return;
        }
        for (g b2 : this.u) {
            this.s.a(b2.b());
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        List<g> list;
        JSONObject jSONObject;
        if (iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof GpPostTxnDataResponse) {
                if (((GpPostTxnDataResponse) iJRPaytmDataModel).getCode() == 2001) {
                    List<g> list2 = this.t;
                    if (!(list2 == null || list2.size() == 0 || (jSONObject = this.v) == null || !jSONObject.keys().hasNext())) {
                        for (g next : this.t) {
                            String optString = this.v.optString(next.a());
                            if (optString != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(optString);
                                    jSONObject2.put("is_verified", true);
                                    this.v.put(next.a(), jSONObject2.toString());
                                } catch (JSONException e2) {
                                    q.b(e2.getMessage());
                                }
                            }
                        }
                    }
                    List<g> list3 = this.u;
                    if (list3 == null || (list = this.t) == null) {
                        this.u = this.t;
                    } else {
                        list3.addAll(list);
                    }
                    this.t = null;
                    g();
                    return;
                }
                this.r = 203;
            }
            if (iJRPaytmDataModel instanceof GpCommonBaseResponse) {
                if (((GpCommonBaseResponse) iJRPaytmDataModel).getCode() == 2001) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(d.a((Context) this).b());
                        if (jSONObject3.remove(this.w) != null) {
                            d.a((Context) this).b(jSONObject3.toString());
                        }
                        if (this.x == 402) {
                            if (this.y.size() == 0) {
                                this.r = 203;
                                return;
                            }
                            this.w = this.y.poll();
                            c();
                            return;
                        }
                    } catch (JSONException e3) {
                        e3.getStackTrace();
                    }
                }
                this.r = 203;
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof GpPostTxnDataResponse) {
            this.r = 203;
            return;
        }
        if (iJRPaytmDataModel instanceof GpCommonBaseResponse) {
            if (this.x != 402) {
                this.r = 203;
            } else if (this.y.size() == 0) {
                this.r = 203;
                return;
            } else {
                this.w = this.y.poll();
                c();
                return;
            }
        }
        this.r = 203;
    }

    public void onDestroy() {
        super.onDestroy();
        net.one97.paytm.games.d.a aVar = this.s;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.putExtra("work_id", 102);
        a(context, intent);
        Intent intent2 = new Intent();
        intent2.putExtra("work_id", 101);
        a(context, intent2);
    }

    public final void a(String str, int i2) {
        g gVar;
        JSONObject jSONObject;
        List<g> list;
        if (str != null && (list = this.u) != null && list.size() != 0) {
            Iterator<g> it2 = this.u.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                gVar = it2.next();
                if (gVar.b().equals(str)) {
                    break;
                }
            }
        }
        gVar = null;
        if (i2 == 0 && gVar != null && (jSONObject = this.v) != null && jSONObject.keys().hasNext()) {
            this.v.remove(gVar.a());
            d.a((Context) this).a(this.v.toString());
        }
        if (gVar != null) {
            this.u.remove(gVar);
        }
        if (this.u.size() == 0) {
            this.r = 203;
        }
    }
}
