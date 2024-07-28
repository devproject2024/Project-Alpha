package net.one97.paytm.addmoney.addmoneysource.d.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.d.a.a;
import net.one97.paytm.addmoney.addmoneysource.d.b.a.b;
import net.one97.paytm.addmoney.addmoneysource.d.d.b;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.i;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;

public final class a implements a.C0842a, h {

    /* renamed from: a  reason: collision with root package name */
    a.b f48247a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<UpiProfileDefaultBank> f48248b;

    /* renamed from: c  reason: collision with root package name */
    int f48249c;

    /* renamed from: d  reason: collision with root package name */
    private final String f48250d = "SourceUpiPresenter";

    /* renamed from: e  reason: collision with root package name */
    private b f48251e;

    /* renamed from: f  reason: collision with root package name */
    private UpiProfileDefaultBank f48252f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f48253g;

    /* renamed from: h  reason: collision with root package name */
    private double f48254h;

    /* renamed from: i  reason: collision with root package name */
    private int f48255i;
    private int j;
    private int k;
    private net.one97.paytm.addmoney.utils.a l;

    public a(a.b bVar, double d2, b bVar2, net.one97.paytm.addmoney.utils.a aVar, int i2, int i3) {
        this.f48247a = bVar;
        this.f48254h = d2;
        this.f48251e = bVar2;
        this.l = aVar;
        this.f48248b = new ArrayList<>();
        this.f48249c = i2;
        this.f48255i = -1;
        this.j = i3;
        this.k = 0;
    }

    public final void a() {
        this.f48253g = this.f48251e.b("SourceUpiPresenter");
        if (!this.f48253g) {
            this.f48247a.b();
        } else if (this.j == SourceCardType.BHIM_UPI.getNumVal()) {
            this.f48247a.c();
        } else {
            int size = this.f48248b.size();
            this.f48248b.clear();
            this.f48247a.a(size);
            this.f48247a.a(true);
            this.f48251e.a((i) new i() {
                public final void a(UpiBaseDataModel upiBaseDataModel) {
                    a aVar = a.this;
                    if (upiBaseDataModel instanceof UpiProfileModel) {
                        aVar.f48247a.a(false);
                        UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                        if (!upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                            aVar.f48247a.a();
                            return;
                        }
                        UpiProfileModel.ProfileDetails profileDetail = upiProfileModel.getResponse().getProfileDetail();
                        if (profileDetail == null || profileDetail.getProfileVpaList() == null) {
                            aVar.f48247a.b(true);
                        } else if (profileDetail.getProfileVpaList().size() > 0) {
                            int size = aVar.f48248b.size();
                            aVar.f48248b.clear();
                            aVar.f48247a.a(size);
                            ArrayList arrayList = new ArrayList();
                            if (aVar.f48249c == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                                String str = null;
                                Iterator<UpiProfileDefaultBank> it2 = profileDetail.getProfileVpaList().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    UpiProfileDefaultBank next = it2.next();
                                    if (next.isPrimary()) {
                                        str = next.getVirtualAddress();
                                        break;
                                    }
                                }
                                if (profileDetail.getBankAccountList() != null) {
                                    Iterator<BankAccountDetails.BankAccount> it3 = profileDetail.getBankAccountList().iterator();
                                    while (it3.hasNext()) {
                                        BankAccountDetails.BankAccount next2 = it3.next();
                                        if (!next2.getIfsc().startsWith("PYTM")) {
                                            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                                            upiProfileDefaultBank.setDefaultInstrunment(false);
                                            upiProfileDefaultBank.setVirtualAddress(str);
                                            upiProfileDefaultBank.setDebitBank(next2);
                                            arrayList.add(upiProfileDefaultBank);
                                        }
                                    }
                                }
                            } else {
                                c a2 = c.a();
                                for (UpiProfileDefaultBank next3 : profileDetail.getProfileVpaList()) {
                                    next3.setDefaultInstrunment(false);
                                    if (next3.getDebitBank() != null) {
                                        if (!next3.getDebitBank().getIfsc().startsWith("PYTM")) {
                                            arrayList.add(next3);
                                        } else if (!(a2 == null || a2.f48963f == null || "ISSUED".equals(a2.f48963f.getIsaStatus()))) {
                                            arrayList.add(next3);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                aVar.f48247a.b(false);
                                aVar.f48248b.addAll(a.a((List<UpiProfileDefaultBank>) arrayList));
                                aVar.f48247a.b(aVar.f48248b.size());
                                return;
                            }
                            aVar.f48247a.b(true);
                        } else {
                            aVar.f48247a.b(true);
                        }
                    }
                }

                public final void a(NetworkCustomError networkCustomError) {
                    a.this.b(new NetworkCustomError(networkCustomError.toString()));
                }
            }, "SourceUpiPresenter");
        }
    }

    public final void b() {
        this.f48251e.a("SourceUpiPresenter");
    }

    public final void a(int i2, b.a aVar) {
        UpiProfileDefaultBank upiProfileDefaultBank = this.f48248b.get(i2);
        boolean isDefaultInstrunment = upiProfileDefaultBank.isDefaultInstrunment();
        aVar.f48275a.setChecked(isDefaultInstrunment);
        if (isDefaultInstrunment) {
            aVar.f48279e.setVisibility(0);
        } else {
            aVar.f48279e.setVisibility(8);
        }
        aVar.f48276b.setText(upiProfileDefaultBank.getDebitBank().getBankName());
        String bankLogoUrl = upiProfileDefaultBank.getDebitBank().getBankLogoUrl();
        if (!TextUtils.isEmpty(bankLogoUrl)) {
            w.a().a(bankLogoUrl).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(aVar.f48278d, (e) null);
        }
        String account = upiProfileDefaultBank.getDebitBank().getAccount();
        TextView textView = aVar.f48277c;
        String string = net.one97.paytm.addmoney.addmoneysource.d.d.b.this.f48270a.getString(R.string.uam_acc_no);
        Object[] objArr = new Object[1];
        if (!TextUtils.isEmpty(account) && account.length() > 4) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < account.length() - 4; i3++) {
                sb.append("X");
            }
            sb.append(account.substring(account.length() - 4));
            account = sb.toString();
        }
        objArr[0] = account;
        textView.setText(String.format(string, objArr));
        aVar.f48279e.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a */
            final /* synthetic */ int f48281a;

            public final void onClick(
/*
Method generation error in method: net.one97.paytm.addmoney.addmoneysource.d.d.b.a.1.onClick(android.view.View):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.addmoney.addmoneysource.d.d.b.a.1.onClick(android.view.View):void, class status: UNLOADED
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
        aVar.itemView.setOnClickListener(new View.OnClickListener(i2) {

            /* renamed from: a */
            final /* synthetic */ int f48283a;

            public final void onClick(
/*
Method generation error in method: net.one97.paytm.addmoney.addmoneysource.d.d.b.a.2.onClick(android.view.View):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.addmoney.addmoneysource.d.d.b.a.2.onClick(android.view.View):void, class status: UNLOADED
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

    public final int c() {
        return this.f48248b.size();
    }

    public final void a(int i2) {
        this.f48254h = this.f48247a.d();
        this.f48247a.c(this.f48248b.get(i2).isPrimary());
        this.f48252f = this.f48248b.get(i2);
        this.f48247a.a(this.f48252f);
    }

    public final void a(String str, double d2) {
        this.f48247a.c(false);
        this.f48252f = new UpiProfileDefaultBank();
        this.f48252f.setVirtualAddress(str);
        this.f48254h = d2;
        e();
    }

    public final void b(int i2) {
        int i3 = this.f48255i;
        if (i3 != -1) {
            if (i3 == i2) {
                this.f48248b.get(i3).setDefaultInstrunment(!this.f48248b.get(this.f48255i).isDefaultInstrunment());
                this.f48247a.c(this.f48255i);
                this.f48255i = -1;
                return;
            }
            this.f48248b.get(i3).setDefaultInstrunment(false);
            this.f48247a.c(this.f48255i);
        }
        this.f48248b.get(i2).setDefaultInstrunment(true);
        this.f48255i = i2;
        this.f48247a.c(i2);
    }

    public final void e() {
        if (this.l != null) {
            a(true);
            this.l.a(this);
        }
    }

    private void a(boolean z) {
        if (z) {
            this.k++;
            this.f48247a.d(true);
            return;
        }
        this.k--;
        if (this.k <= 0) {
            this.f48247a.d(false);
            this.k = 0;
        }
    }

    public final int d() {
        return this.f48249c;
    }

    public final int f() {
        return this.f48255i;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.f48247a != null) {
            a(false);
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                String a2 = net.one97.paytm.helper.a.b().a((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(a2) && this.l != null) {
                    a(true);
                    this.l.a(this, a2, Double.toString(this.f48254h), this.f48249c, "SourceUpiPresenter");
                }
            } else if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) iJRPaytmDataModel;
                String mid = cJRRechargePayment.getMID();
                String orderId = cJRRechargePayment.getOrderId();
                String str = cJRRechargePayment.getmTxnToken();
                c.a().f48962e = cJRRechargePayment;
                c.a().a(mid, orderId, str);
                a.b bVar = this.f48247a;
                HashMap hashMap = new HashMap();
                hashMap.put("mid", c.a().f48959b);
                hashMap.put("orderId", c.a().f48960c);
                hashMap.put("channelId", SDKConstants.WAP);
                hashMap.put("txnToken", c.a().f48961d);
                hashMap.put("paymentMode", "UPI");
                UpiProfileDefaultBank upiProfileDefaultBank = this.f48252f;
                if (upiProfileDefaultBank != null) {
                    hashMap.put(PayUtility.PAYER_ACCOUNT, upiProfileDefaultBank.getVirtualAddress());
                }
                bVar.a((HashMap<String, String>) hashMap);
            }
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        if (this.f48247a != null) {
            a(false);
            this.f48247a.a(false);
            if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
                this.f48247a.a(networkCustomError.getAlertMessage());
            } else {
                this.f48247a.a(networkCustomError);
            }
        }
    }

    static ArrayList<UpiProfileDefaultBank> a(List<UpiProfileDefaultBank> list) {
        HashMap hashMap = new HashMap();
        for (UpiProfileDefaultBank next : list) {
            if (next.getDebitBank() != null) {
                String account = next.getDebitBank().getAccount();
                if (!TextUtils.isEmpty(account)) {
                    if (!hashMap.containsKey(account)) {
                        hashMap.put(account, next);
                    } else if (next.isPrimary()) {
                        hashMap.put(account, next);
                    }
                }
            }
        }
        ArrayList<UpiProfileDefaultBank> arrayList = new ArrayList<>();
        for (UpiProfileDefaultBank add : hashMap.values()) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
