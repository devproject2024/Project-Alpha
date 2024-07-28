package net.one97.paytm.upi.registration.presenter;

import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.android.volley.Response;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.g.d;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.registration.a.g;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.registration.view.f;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public final class g implements g.a {

    /* renamed from: a  reason: collision with root package name */
    g.b f68658a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<BankAccountDetails.BankAccount> f68659b;

    /* renamed from: c  reason: collision with root package name */
    UpiProfileDefaultBank f68660c;

    /* renamed from: d  reason: collision with root package name */
    List<AccountProviderBody.AccountProvider> f68661d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final String f68662e = "MoneyTransferLinkedAccountPresenter";

    /* renamed from: f  reason: collision with root package name */
    private b f68663f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f68664g;

    /* renamed from: h  reason: collision with root package name */
    private f.a f68665h;

    /* renamed from: i  reason: collision with root package name */
    private a f68666i;
    private String j;

    public final void e() {
    }

    public g(g.b bVar, b bVar2, net.one97.paytm.upi.profile.b.b bVar3, a aVar) {
        this.f68658a = bVar;
        this.j = bVar.getClass().getSimpleName();
        this.f68663f = bVar2;
        this.f68664g = bVar3;
        this.f68666i = aVar;
        this.f68658a.a(this);
    }

    public final void a() {
        if (this.f68658a.i()) {
            net.one97.paytm.upi.profile.b.b bVar = this.f68664g;
            AnonymousClass1 r2 = new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    g.this.f68658a.a(false, "");
                    if (upiBaseDataModel instanceof UpiProfileModel) {
                        UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                        if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                            if (!(upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() == null)) {
                                for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                                    if (next.isPrimary()) {
                                        g gVar = g.this;
                                        gVar.f68660c = next;
                                        gVar.f68658a.a(next.getVirtualAddress());
                                    }
                                }
                                if (g.this.f68660c == null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList().size() > 0) {
                                    g.this.f68660c = upiProfileModel.getResponse().getProfileDetail().getProfileVpaList().get(0);
                                    g.this.f68658a.a(g.this.f68660c.getVirtualAddress());
                                }
                            }
                            if (upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getBankAccountList() != null) {
                                g.this.f68659b = upiProfileModel.getResponse().getProfileDetail().getBankAccountList();
                                g.this.f68658a.b(g.this.f68659b);
                            }
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (g.this.f68658a != null) {
                        g.this.f68658a.a(false, "");
                        g.this.f68658a.a(upiCustomVolleyError);
                    }
                }
            };
            net.one97.paytm.upi.profile.b.b.a aVar = bVar.f67823a;
            b.AnonymousClass14 r4 = new a.C1382a(r2) {

                /* renamed from: a */
                final /* synthetic */ a.C1382a f67841a;

                public final void onSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.14.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.14.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void, class status: UNLOADED
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

                public final void onError(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.14.onError(net.one97.paytm.upi.common.UpiCustomVolleyError):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.14.onError(net.one97.paytm.upi.common.UpiCustomVolleyError):void, class status: UNLOADED
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
            };
            HashMap hashMap = new HashMap();
            hashMap.put("Session-Token", i.a().f66980a);
            hashMap.put("Device-Id", UpiUtils.getDeviceId(aVar.f67892a));
            hashMap.put("channel", UpiRequestBuilder.PAYTM_CHANNEL);
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            String str = UpiGTMLoader.getInstance().getUpiPmsBaseUrl() + UpiGTMLoader.getInstance().getUpiProfileUrl();
            net.one97.paytm.upi.g.a aVar2 = new net.one97.paytm.upi.g.a(UpiAppUtils.addAuthDefaultParams(aVar.f67892a, str) + "&fetchInactiveProfile=true&seq-no=" + UpiUtils.getUpiSequenceNo(), new Response.Listener<UpiBaseDataModel>(r4) {

                /* renamed from: a */
                final /* synthetic */ a.C1382a f67983a;

                public final /* synthetic */ void onResponse(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.5.onResponse(java.lang.Object):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.5.onResponse(java.lang.Object):void, class status: UNLOADED
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
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
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
            }, new Response.ErrorListener(r4) {

                /* renamed from: a */
                final /* synthetic */ a.C1382a f67985a;

                public final void onErrorResponse(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.6.onErrorResponse(com.android.volley.VolleyError):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.6.onErrorResponse(com.android.volley.VolleyError):void, class status: UNLOADED
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
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
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
            }, new UpiProfileModel(), hashMap);
            aVar2.setTag("MoneyTransferLinkedAccountPresenter");
            d.a(aVar2);
            return;
        }
        this.f68658a.a(true, "");
        this.f68664g.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                g.this.f68658a.a(false, "");
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                        if (!(upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() == null)) {
                            for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                                if (next.isPrimary()) {
                                    g gVar = g.this;
                                    gVar.f68660c = next;
                                    gVar.f68658a.a(next.getVirtualAddress());
                                    g.b bVar = g.this.f68658a;
                                    next.getVirtualAddress();
                                    bVar.c();
                                }
                            }
                            if (g.this.f68660c == null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList().size() > 0) {
                                g.this.f68660c = upiProfileModel.getResponse().getProfileDetail().getProfileVpaList().get(0);
                                g.this.f68658a.a(g.this.f68660c.getVirtualAddress());
                            }
                        }
                        if (upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getBankAccountList() != null) {
                            g.this.f68659b = new ArrayList<>();
                            Iterator<BankAccountDetails.BankAccount> it2 = upiProfileModel.getResponse().getProfileDetail().getBankAccountList().iterator();
                            while (it2.hasNext()) {
                                BankAccountDetails.BankAccount next2 = it2.next();
                                if (!"ppb_landing".equalsIgnoreCase(g.this.f68658a.j()) || !"PYTM0123456".equalsIgnoreCase(next2.getIfsc())) {
                                    g.this.f68659b.add(next2);
                                }
                            }
                            g.this.f68658a.a(g.this.f68659b);
                        }
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (g.this.f68658a != null) {
                    g.this.f68658a.a(false, "");
                    if (!"514".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                        g.this.f68658a.a(upiCustomVolleyError);
                    }
                }
            }
        }, "MoneyTransferLinkedAccountPresenter", this.j);
    }

    public final void c() {
        this.f68663f.a((a.C1389a) new a.C1389a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof AccountProviderBody.AccountProviderDetails) {
                    AccountProviderBody.AccountProviderDetails accountProviderDetails = (AccountProviderBody.AccountProviderDetails) upiBaseDataModel;
                    if (accountProviderDetails.getProviders() != null && accountProviderDetails.getProviders().size() > 0) {
                        g gVar = g.this;
                        List<AccountProviderBody.AccountProvider> providers = accountProviderDetails.getProviders();
                        int size = providers.size();
                        gVar.f68661d.clear();
                        HashSet hashSet = new HashSet();
                        for (int i2 = 0; i2 < size; i2++) {
                            AccountProviderBody.AccountProvider accountProvider = providers.get(i2);
                            String ifsc = accountProvider.getIfsc();
                            if (UpiConstants.FAVORITE_BANKS.SBI_BANK.getIfscCode().equalsIgnoreCase(ifsc) || UpiConstants.FAVORITE_BANKS.ICICI_BANK.getIfscCode().equalsIgnoreCase(ifsc) || UpiConstants.FAVORITE_BANKS.HDFC_BANK.getIfscCode().equalsIgnoreCase(ifsc) || UpiConstants.FAVORITE_BANKS.AXIS_BANK.getIfscCode().equalsIgnoreCase(ifsc)) {
                                gVar.f68661d.add(accountProvider);
                                hashSet.add(Integer.valueOf(i2));
                            }
                        }
                        if (gVar.f68661d.size() < 4) {
                            for (int i3 = 0; i3 < size; i3++) {
                                if (!hashSet.contains(Integer.valueOf(i3))) {
                                    gVar.f68661d.add(providers.get(i3));
                                    if (gVar.f68661d.size() == 4) {
                                        break;
                                    }
                                }
                            }
                        }
                        AccountProviderBody.AccountProvider accountProvider2 = new AccountProviderBody.AccountProvider();
                        accountProvider2.setId(H5BridgeContext.INVALID_ID);
                        gVar.f68661d.add(accountProvider2);
                        gVar.f68658a.a(gVar.f68661d);
                    }
                }
            }
        }, "MoneyTransferLinkedAccountPresenter", this.j);
    }

    public final void f() {
        net.one97.paytm.upi.registration.b.a.b bVar = this.f68663f;
        if (bVar != null) {
            bVar.c("MoneyTransferLinkedAccountPresenter");
        }
        net.one97.paytm.upi.profile.b.b bVar2 = this.f68664g;
        if (bVar2 != null) {
            bVar2.a("MoneyTransferLinkedAccountPresenter");
        }
    }

    public final void a(int i2, f.a aVar) {
        BankAccountDetails.BankAccount bankAccount = this.f68659b.get(i2);
        aVar.f68850a.setText(bankAccount.getBankName());
        String account = bankAccount.getAccount();
        UpiConstants.BANK_ACCOUNT_TYPE valueOf = UpiConstants.BANK_ACCOUNT_TYPE.valueOf(bankAccount.getAccountType());
        if (f.this.f68848d == null || !f.this.f68848d.equalsIgnoreCase("UpiLanding")) {
            aVar.f68851b.setText(f.this.f68847c.getString(valueOf.getAccDisplayStringId(), new Object[]{UpiUtils.maskAccNumberWithSpace(account)}));
        } else {
            aVar.f68851b.setText(UpiAppUtils.getAccountNoV4Format(f.this.f68847c, UpiAppUtils.toCamelCase(aVar.f68850a.getText().toString()), account));
        }
        String bankLogoUrl = bankAccount.getBankLogoUrl();
        if (!TextUtils.isEmpty(bankLogoUrl)) {
            w.a().a(bankLogoUrl).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(aVar.f68855f, (e) null);
        }
        boolean z = !bankAccount.isMpinSet() && !"PYTM0123456".equalsIgnoreCase(bankAccount.getIfsc());
        if (z) {
            aVar.f68852c.setText(f.this.f68847c.getString(R.string.upi_set_mpin));
        } else {
            aVar.f68852c.setText(f.this.f68847c.getString(R.string.check_balance));
        }
        aVar.f68852c.setTextColor(androidx.core.content.b.c(f.this.f68847c, R.color.color_00b9f5));
        aVar.f68852c.setOnClickListener(new View.OnClickListener(z, i2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f68859a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f68860b;

            {
                this.f68859a = r2;
                this.f68860b = r3;
            }

            public final void onClick(View view) {
                if (!f.this.f68847c.getString(R.string.check_balance).equalsIgnoreCase(a.this.f68852c.getText().toString()) && !f.this.f68847c.getString(R.string.upi_set_mpin).equalsIgnoreCase(a.this.f68852c.getText().toString())) {
                    return;
                }
                if (!UpiAppUtils.isNetworkAvailable(f.this.f68847c)) {
                    CustomDialog.showAlert(f.this.f68847c, f.this.f68847c.getResources().getString(R.string.no_connection), f.this.f68847c.getResources().getString(R.string.no_internet));
                } else if (this.f68859a) {
                    f.this.f68846b.e(this.f68860b);
                    CJRSendGTMTag.sendNewCustomGTMEvents(f.this.f68847c, GAConstants.CATEGORY.UPI_ONB_V1, "set_mpin_clicked", a.this.f68850a.getText().toString(), "", "", GAConstants.SCREEN_NAME.UPI_LANDING_PAGE, "wallet");
                } else {
                    CJRSendGTMTag.sendNewCustomGTMEvents(f.this.f68847c, CJRGTMConstants.UPI_EVENT_CATEGORY, "check_balance_clicked", "", "", "", "/bhim-upi/bank-details", "wallet");
                    CJRSendGTMTag.sendNewCustomGTMEvents(f.this.f68847c, GAConstants.CATEGORY.UPI_ONB_V1, "check_balance_clicked", a.this.f68850a.getText().toString(), "", "", GAConstants.SCREEN_NAME.UPI_LANDING_PAGE, "wallet");
                    f.this.f68846b.b(this.f68860b, a.this);
                }
            }
        });
        aVar.f68858i.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f68862a;

            {
                this.f68862a = r2;
            }

            public final void onClick(View view) {
                f.this.f68846b.a(this.f68862a);
            }
        });
        aVar.f68854e.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f68864a;

            {
                this.f68864a = r2;
            }

            public final void onClick(View view) {
                y yVar = f.this.f68845a;
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.getAdapterPosition());
                yVar.b(sb.toString());
                f.this.f68846b.b(this.f68864a);
            }
        });
        aVar.f68853d.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f68866a;

            {
                this.f68866a = r2;
            }

            public final void onClick(View view) {
                y yVar = f.this.f68845a;
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.getAdapterPosition());
                yVar.b(sb.toString());
                if (UpiAppUtils.isNetworkAvailable(f.this.f68847c)) {
                    f.this.f68846b.c(this.f68866a);
                } else {
                    CustomDialog.showAlert(f.this.f68847c, f.this.f68847c.getString(R.string.no_connection), f.this.f68847c.getResources().getString(R.string.no_internet));
                }
            }
        });
        if (this.f68660c != null) {
            if (bankAccount.getAccount() == null || this.f68660c.getDebitBank() == null || this.f68660c.getDebitBank().getAccount() == null) {
                aVar.a(false);
            } else {
                aVar.a(bankAccount.getAccount().equalsIgnoreCase(this.f68660c.getDebitBank().getAccount()));
            }
        }
        ArrayList<BankAccountDetails.BankAccount> arrayList = this.f68659b;
        if (arrayList != null && arrayList.size() == 1) {
            aVar.f68854e.setVisibility(8);
            aVar.f68853d.setVisibility(8);
        }
    }

    public final int b() {
        ArrayList<BankAccountDetails.BankAccount> arrayList = this.f68659b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void b(int i2, f.a aVar) {
        BankAccountDetails.BankAccount bankAccount = this.f68659b.get(i2);
        if (bankAccount == null || bankAccount.isMpinSet() || !"PYTM0123456".equalsIgnoreCase(bankAccount.getIfsc())) {
            a(bankAccount);
            this.f68665h = aVar;
            return;
        }
        this.f68658a.b(bankAccount);
        this.f68665h = aVar;
    }

    public final void e(int i2) {
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setVirtualAddress(this.f68660c.getVirtualAddress());
        upiProfileDefaultBank.setDebitBank(this.f68659b.get(i2));
        this.f68658a.a(upiProfileDefaultBank);
    }

    public final void a(int i2) {
        this.f68658a.a(this.f68659b.get(i2));
    }

    public final void b(final int i2) {
        ArrayList<BankAccountDetails.BankAccount> arrayList = this.f68659b;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.f68659b.get(i2));
            UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, this.f68660c.getVirtualAddress()).setBankAccountList(arrayList2).setSelectedBankIdx(0).build();
            this.f68658a.d();
            this.f68664g.a(build, (a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (g.this.f68658a != null) {
                        if (upiBaseDataModel instanceof BaseUpiResponse) {
                            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                            if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                                g.this.f68658a.b((UpiCustomVolleyError) null, baseUpiResponse.getResponse());
                            } else {
                                g.this.f68658a.a(i2);
                            }
                        } else {
                            g.this.f68658a.b((UpiCustomVolleyError) null, (String) null);
                        }
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (g.this.f68658a != null) {
                        g.this.f68658a.b(upiCustomVolleyError, (String) null);
                    }
                }
            }, "MoneyTransferLinkedAccountPresenter", this.j);
        }
    }

    public final void c(int i2) {
        ArrayList<BankAccountDetails.BankAccount> arrayList = this.f68659b;
        if (arrayList != null && arrayList.size() > 0) {
            BankAccountDetails.BankAccount bankAccount = this.f68659b.get(i2);
            a(bankAccount, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT);
            a(bankAccount, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.CREDIT);
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        this.f68658a.c(bankAccount);
    }

    /* access modifiers changed from: package-private */
    public final void a(List<GetCredentialsResponse> list, String str, final BankAccountDetails.BankAccount bankAccount) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse next : list) {
            if ("MPIN".equalsIgnoreCase(next.getSubtype())) {
                userMpinDetails.setMpin(next.getData().getCode() + AppConstants.COMMA + next.getData().getKi() + AppConstants.COMMA + next.getData().getEncryptedBase64String());
            }
        }
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setVirtualAddress(this.f68660c.getVirtualAddress());
        upiProfileDefaultBank.setDebitBank(bankAccount);
        this.f68658a.a(true);
        this.f68664g.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    g.this.f68658a.a(false);
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                        g.this.f68658a.a((UpiCustomVolleyError) null, baseUpiResponse.getResponse());
                        return;
                    }
                    try {
                        if (baseUpiResponse.getMobileAppData() instanceof UpiCheckBalanceModel) {
                            UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) baseUpiResponse.getMobileAppData();
                            g gVar = g.this;
                            String totalBal = upiCheckBalanceModel.getTotalBal();
                            String availableBalance = upiCheckBalanceModel.getAvailableBalance();
                            bankAccount.getAccountType();
                            gVar.a(totalBal, availableBalance);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    g.this.f68658a.a(false);
                    g.this.f68658a.a((UpiCustomVolleyError) null, "");
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                g.this.f68658a.a(false);
                g.this.f68658a.a(upiCustomVolleyError, "");
            }
        }, "MoneyTransferLinkedAccountPresenter", this.j);
    }

    public final void a(String str, String str2) {
        f.a aVar = this.f68665h;
        if (aVar != null) {
            aVar.f68856g.setVisibility(0);
            aVar.f68852c.setText(f.this.f68847c.getString(R.string.upi_new_balance, new Object[]{UpiAppUtils.priceToString(str2)}));
            aVar.f68852c.setTextColor(androidx.core.content.b.c(f.this.f68847c, R.color.color_222222));
            aVar.f68856g.setOnClickListener(new View.OnClickListener(str, str2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f68868a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ String f68869b;

                {
                    this.f68868a = r2;
                    this.f68869b = r3;
                }

                public final void onClick(View view) {
                    UpiUtils.addBalanceSheet(this.f68868a, this.f68869b, ((AppCompatActivity) f.this.f68847c).getSupportFragmentManager());
                }
            });
            this.f68665h = null;
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        UpiProfileDefaultBank upiProfileDefaultBank;
        g.b bVar = this.f68658a;
        if (bVar != null && (upiProfileDefaultBank = this.f68660c) != null) {
            bVar.a(accountProvider, upiProfileDefaultBank.getVirtualAddress());
        }
    }

    private void a(BankAccountDetails.BankAccount bankAccount, final UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bankAccount);
        UpiProfileDefaultBank upiProfileDefaultBank = this.f68660c;
        final UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank != null ? upiProfileDefaultBank.getVirtualAddress() : "").setBankAccountList(arrayList).build();
        this.f68658a.f();
        this.f68664g.a(profile_vpa_account_type, build, new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (g.this.f68658a != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            g.this.f68658a.e();
                        } else {
                            g.this.f68658a.a(build, profile_vpa_account_type);
                        }
                    } else {
                        g.this.f68658a.e();
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (g.this.f68658a != null) {
                    g.this.f68658a.e();
                }
            }
        }, "MoneyTransferLinkedAccountPresenter", this.j);
    }

    public final void d() {
        this.f68658a.g();
    }

    public final void g() {
        this.f68658a.a(true, "");
        this.f68663f.e(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                g.this.f68658a.a(false, "");
                UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                if (upiAvailabilityModel != null && upiAvailabilityModel.getResponse() != null) {
                    if (upiAvailabilityModel.getResponse().isUpiUser()) {
                        g.this.a();
                    } else {
                        g.this.f68658a.h();
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (g.this.f68658a != null) {
                    g.this.f68658a.a(false, "");
                }
            }
        }, "MoneyTransferLinkedAccountPresenter", this.j);
    }

    public final void d(int i2) {
        UpiProfileDefaultBank upiProfileDefaultBank = this.f68660c;
        if (upiProfileDefaultBank != null && upiProfileDefaultBank.getVirtualAddress() != null) {
            this.f68658a.a(this.f68661d.get(i2), this.f68660c.getVirtualAddress());
        }
    }
}
