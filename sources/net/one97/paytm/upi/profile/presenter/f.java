package net.one97.paytm.upi.profile.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.gson.u;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.CheckBalanceV4Response;
import net.one97.paytm.upi.common.upi.AccountBalanceModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.a.g;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.util.ApiCallDataSource;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class f implements g.a {

    /* renamed from: a  reason: collision with root package name */
    b f68059a;

    /* renamed from: b  reason: collision with root package name */
    g.b f68060b;

    /* renamed from: c  reason: collision with root package name */
    a f68061c;

    /* renamed from: d  reason: collision with root package name */
    UserUpiDetails f68062d;

    /* renamed from: e  reason: collision with root package name */
    String f68063e;

    /* renamed from: f  reason: collision with root package name */
    String f68064f;

    /* renamed from: g  reason: collision with root package name */
    private String f68065g = "UpiProfileAccountDetailPresenter";

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.upi.profile.b.b f68066h;

    /* renamed from: i  reason: collision with root package name */
    private final String f68067i = "UpiProfileAccountDetailPresenter";

    public f(net.one97.paytm.upi.profile.b.b bVar, b bVar2, a aVar, g.b bVar3, UserUpiDetails userUpiDetails) {
        this.f68066h = bVar;
        this.f68060b = bVar3;
        this.f68063e = bVar3.getClass().getSimpleName();
        this.f68061c = aVar;
        this.f68062d = userUpiDetails;
        this.f68059a = bVar2;
        this.f68060b.a(this);
    }

    public final void e() {
        this.f68060b.a(this.f68062d);
        this.f68066h.a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (f.this.f68060b != null && (upiBaseDataModel instanceof UpiProfileModel)) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") && "0".equalsIgnoreCase(upiProfileModel.getRespCode()) && upiProfileModel.getResponse() != null && upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() != null) {
                        for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                            if (next.isPrimary()) {
                                f.this.f68064f = next.getVirtualAddress();
                                if (!f.this.f68062d.getBankAccountList().get(0).getAccount().equalsIgnoreCase(next.getDebitBank().getAccount())) {
                                    f.this.f68060b.j();
                                    return;
                                }
                            }
                        }
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (f.this.f68060b != null && UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                    f.this.f68060b.g();
                }
            }
        }, this.f68065g, this.f68063e);
    }

    public final void a() {
        if (!this.f68061c.a()) {
            this.f68060b.i();
            return;
        }
        this.f68060b.a();
        if (this.f68062d.getSelectedBankAccount().getIfsc().contains("PYTM")) {
            final BankAccountDetails.BankAccount selectedBankAccount = this.f68062d.getSelectedBankAccount();
            net.one97.paytm.upi.profile.b.b bVar = this.f68066h;
            selectedBankAccount.getAccount();
            bVar.a((a.C1382a) new a.C1382a() {
                public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                    if (f.this.f68060b != null) {
                        if (upiBaseDataModel instanceof CJRAccountSummary) {
                            CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                            if (cJRAccountSummary == null || cJRAccountSummary.getStatus() == null || !cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                                f.this.f68060b.a((UpiCustomVolleyError) null, "");
                                return;
                            }
                            AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                            g.b bVar = f.this.f68060b;
                            String valueOf = String.valueOf(accountBalanceModel.getTotalBalance());
                            String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
                            selectedBankAccount.getAccountType();
                            bVar.a(valueOf, valueOf2);
                            return;
                        }
                        f.this.f68060b.a((UpiCustomVolleyError) null, "");
                    }
                }

                public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                    if (f.this.f68060b == null) {
                        return;
                    }
                    if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                        f.this.f68060b.c();
                        f.this.f68060b.g();
                        return;
                    }
                    f.this.f68060b.a(upiCustomVolleyError, "");
                }
            });
            return;
        }
        this.f68059a.b((a.C1389a) new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (f.this.f68060b != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        f fVar = f.this;
                        fVar.f68059a.d(new a.C1389a((String) ((BaseUpiResponse) upiBaseDataModel).getMobileAppData()) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ String f68075a;

                            {
                                this.f68075a = r2;
                            }

                            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                                if (f.this.f68060b != null) {
                                    if (upiBaseDataModel instanceof UpiToken) {
                                        f fVar = f.this;
                                        String str = this.f68075a;
                                        String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                                        fVar.f68060b.c();
                                        String upiSequenceNo = UpiUtils.getUpiSequenceNo();
                                        fVar.f68061c.a(upiSequenceNo, str, upiToken, 0, fVar.f68062d.getSelectedBankAccount(), new CLRemoteResultReceiver(new UpiProfileAccountDetailPresenter$5(fVar, new Handler(), upiSequenceNo)));
                                        return;
                                    }
                                    f.this.f68060b.a((UpiCustomVolleyError) null, "");
                                }
                            }

                            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                                if (f.this.f68060b == null) {
                                    return;
                                }
                                if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                                    f.this.f68060b.c();
                                    f.this.f68060b.g();
                                    return;
                                }
                                f.this.f68060b.a(upiCustomVolleyError, upiCustomVolleyError.getAlertTitle());
                            }
                        }, "UpiProfileAccountDetailPresenter", fVar.f68063e);
                        return;
                    }
                    f.this.f68060b.h();
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (f.this.f68060b != null) {
                    f.this.f68060b.h();
                }
            }
        }, "UpiProfileAccountDetailPresenter", this.f68063e);
    }

    private void a(List<GetCredentialsResponse> list, String str) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse next : list) {
            if ("MPIN".equalsIgnoreCase(next.getSubtype())) {
                userMpinDetails.setMpin(next.getData().getCode() + AppConstants.COMMA + next.getData().getKi() + AppConstants.COMMA + next.getData().getEncryptedBase64String());
            }
        }
        this.f68060b.a();
        net.one97.paytm.upi.profile.b.b bVar = this.f68066h;
        UserUpiDetails userUpiDetails = this.f68062d;
        AnonymousClass7 r2 = new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (f.this.f68060b != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            f.this.f68060b.a((UpiCustomVolleyError) null, baseUpiResponse.getResponse());
                        } else if (baseUpiResponse.getMobileAppData() instanceof UpiCheckBalanceModel) {
                            UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) baseUpiResponse.getMobileAppData();
                            BankAccountDetails.BankAccount selectedBankAccount = f.this.f68062d.getSelectedBankAccount();
                            g.b bVar = f.this.f68060b;
                            String totalBal = upiCheckBalanceModel.getTotalBal();
                            String availableBalance = upiCheckBalanceModel.getAvailableBalance();
                            selectedBankAccount.getAccountType();
                            bVar.a(totalBal, availableBalance);
                        }
                    } else {
                        f.this.f68060b.a((UpiCustomVolleyError) null, "");
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (f.this.f68060b == null) {
                    return;
                }
                if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                    f.this.f68060b.c();
                    f.this.f68060b.g();
                    return;
                }
                f.this.f68060b.a(upiCustomVolleyError, "");
            }
        };
        String str2 = this.f68063e;
        net.one97.paytm.upi.profile.b.b.a aVar = bVar.f67823a;
        b.AnonymousClass26 r4 = new a.C1382a(r2) {

            /* renamed from: a */
            final /* synthetic */ a.C1382a f67869a;

            public final void onSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.26.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.26.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void, class status: UNLOADED
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
Method generation error in method: net.one97.paytm.upi.profile.b.b.26.onError(net.one97.paytm.upi.common.UpiCustomVolleyError):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.26.onError(net.one97.paytm.upi.common.UpiCustomVolleyError):void, class status: UNLOADED
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
        if (TextUtils.isEmpty(userUpiDetails.getSelectedBankAccount().getAccRefId())) {
            aVar.a(r4, "UpiProfileAccountDetailPresenter", UpiRequestBuilder.CheckAccountBalanceV2.getCheckAccountBalanceV2(), UpiRequestBuilder.CheckAccountBalanceV2.getParams(aVar.f67892a, str, userUpiDetails, userMpinDetails), UpiRequestBuilder.getHeaders(aVar.f67892a), 21, str2);
            return;
        }
        com.paytm.network.b postRequestCommonNetworkCallBuilder = ApiCallDataSource.postRequestCommonNetworkCallBuilder();
        postRequestCommonNetworkCallBuilder.f42882f = UpiRequestBuilder.getHeadersWithApplicationJson(aVar.f67892a);
        postRequestCommonNetworkCallBuilder.f42880d = UpiRequestBuilder.CheckAccountBalance.getCheckAccountBalanceV4(aVar.f67892a);
        postRequestCommonNetworkCallBuilder.f42884h = UpiRequestBuilder.CheckAccountBalance.getRequestBody(aVar.f67892a, str, userUpiDetails, userMpinDetails).toString();
        postRequestCommonNetworkCallBuilder.f42885i = new CheckBalanceV4Response((UpiCheckBalanceModel) null, "", "", "");
        postRequestCommonNetworkCallBuilder.j = new com.paytm.network.listener.b(r4, str) {

            /* renamed from: a */
            final /* synthetic */ a.C1382a f67969a;

            /* renamed from: b */
            final /* synthetic */ String f67970b;

            public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.41.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.41.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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

            public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.upi.profile.b.b.a.41.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes7.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.profile.b.b.a.41.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
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
        postRequestCommonNetworkCallBuilder.l().a();
    }

    private void b(List<GetCredentialsResponse> list, String str) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse next : list) {
            if ("MPIN".equalsIgnoreCase(next.getSubtype())) {
                userMpinDetails.setOldMpin(next.getData().getCode() + AppConstants.COMMA + next.getData().getKi() + AppConstants.COMMA + next.getData().getEncryptedBase64String());
            } else if ("NMPIN".equalsIgnoreCase(next.getSubtype())) {
                userMpinDetails.setNewMpin(next.getData().getCode() + AppConstants.COMMA + next.getData().getKi() + AppConstants.COMMA + next.getData().getEncryptedBase64String());
            }
        }
        this.f68060b.b();
        this.f68066h.a(str, userMpinDetails, this.f68062d, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (f.this.f68060b != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            f.this.f68060b.b((UpiCustomVolleyError) null, baseUpiResponse.getResponse());
                        } else {
                            f.this.f68060b.d();
                        }
                    } else {
                        f.this.f68060b.b((UpiCustomVolleyError) null, "");
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (f.this.f68060b == null) {
                    return;
                }
                if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                    f.this.f68060b.c();
                    f.this.f68060b.g();
                    return;
                }
                f.this.f68060b.b(upiCustomVolleyError, "");
            }
        });
    }

    public final void b() {
        this.f68060b.b(this.f68062d);
    }

    public final void c() {
        this.f68060b.e();
        this.f68066h.a(this.f68062d, (a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (f.this.f68060b != null) {
                    if (upiBaseDataModel instanceof BaseUpiResponse) {
                        BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                        if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                            f.this.f68060b.c((UpiCustomVolleyError) null, baseUpiResponse.getResponse());
                        } else {
                            f.this.f68060b.f();
                        }
                    } else {
                        f.this.f68060b.c((UpiCustomVolleyError) null, (String) null);
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (f.this.f68060b == null) {
                    return;
                }
                if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                    f.this.f68060b.c();
                    f.this.f68060b.g();
                    return;
                }
                f.this.f68060b.c(upiCustomVolleyError, (String) null);
            }
        }, "UpiProfileAccountDetailPresenter", this.f68063e);
    }

    public final void d() {
        this.f68060b.a(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f68062d.getBankAccountList().get(0));
        final UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, this.f68064f).setBankAccountList(arrayList).build();
        this.f68066h.a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.DEBIT, build, new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    f.this.f68060b.a(false);
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || !"0".equals(baseUpiResponse.getResponse())) {
                        f.this.f68060b.d((UpiCustomVolleyError) null, baseUpiResponse.getMessage());
                    } else {
                        f.this.f68060b.c(build);
                    }
                } else {
                    f.this.f68060b.a(false);
                    f.this.f68060b.d((UpiCustomVolleyError) null, "");
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (f.this.f68060b != null) {
                    f.this.f68060b.a(false);
                    if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                        f.this.f68060b.c();
                        f.this.f68060b.g();
                        return;
                    }
                    f.this.f68060b.d(upiCustomVolleyError, "");
                }
            }
        }, this.f68065g, this.f68063e);
        this.f68066h.a(UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.CREDIT, this.f68062d, new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
                    f.this.f68060b.g();
                }
            }
        }, this.f68065g, this.f68063e);
    }

    public final void f() {
        this.f68060b = null;
    }

    static /* synthetic */ void a(f fVar, int i2, Bundle bundle, String str) {
        String string = bundle.getString("error");
        if (string == null || string.isEmpty()) {
            HashMap hashMap = (HashMap) bundle.getSerializable("credBlocks");
            ArrayList arrayList = new ArrayList();
            for (String str2 : hashMap.keySet()) {
                try {
                    GetCredentialsResponse getCredentialsResponse = (GetCredentialsResponse) new com.google.gson.f().a((String) hashMap.get(str2), GetCredentialsResponse.class);
                    getCredentialsResponse.setSubtype(str2);
                    arrayList.add(getCredentialsResponse);
                } catch (u e2) {
                    e2.printStackTrace();
                }
            }
            PaytmLogs.d("getCredentials", hashMap.toString());
            PaytmLogs.d("getCredentialsList", arrayList.toString());
            if (i2 == 0) {
                fVar.a(arrayList, str);
            } else if (i2 == 1) {
                fVar.b(arrayList, str);
            }
        } else {
            try {
                JSONObject jSONObject = new JSONObject(string);
                jSONObject.getString(CLConstants.FIELD_ERROR_CODE);
                jSONObject.getString(CLConstants.FIELD_ERROR_TEXT);
                fVar.f68060b.h();
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }
}
