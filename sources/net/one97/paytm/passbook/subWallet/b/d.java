package net.one97.paytm.passbook.subWallet.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRLedgerResponse;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.subWallet.c.b;
import net.one97.paytm.passbook.subWallet.c.c;
import net.one97.paytm.passbook.utility.l;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public class d extends h implements b.C1135b, net.one97.paytm.passbook.utility.d, l {
    private static d k;

    /* renamed from: a  reason: collision with root package name */
    private Activity f58843a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f58844b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f58845c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressDialog f58846d;

    /* renamed from: e  reason: collision with root package name */
    private String f58847e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f58848f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f58849g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f58850h;

    /* renamed from: i  reason: collision with root package name */
    private LinkedHashMap<String, ArrayList<CJRTransaction>> f58851i;
    private LinkedHashMap j;
    private c l;
    private int m;
    private LottieAnimationView n;
    private CJRSubWallet o;
    private boolean p;
    private boolean q;
    private boolean r = false;

    public final void a(String str) {
    }

    public final void a(net.one97.paytm.passbook.utility.h hVar) {
    }

    public final void b() {
    }

    public final void b(net.one97.paytm.passbook.utility.h hVar) {
    }

    public final String c() {
        return null;
    }

    public final void e() {
    }

    public final void f() {
    }

    public final boolean g() {
        return false;
    }

    public final boolean i() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f58843a = getActivity();
        k = this;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m = getArguments().getInt("sub_wallet_type");
        this.o = (CJRSubWallet) getArguments().getSerializable("subwallet-list");
        this.p = getArguments().getBoolean(UpiConstants.INTENT_EXTRA_CST_MINIMIZE_TRANSACTION);
        this.q = getArguments().getBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST);
        this.l = new c(this, this.f58843a, this.m, this.o);
        this.f58844b = (LinearLayout) view.findViewById(R.id.loader_ll);
        this.n = (LottieAnimationView) view.findViewById(R.id.wallet_loader);
        if (this.m == n.GIFT_VOUCHER.getValue()) {
            getResources().getStringArray(R.array.passbook_tabs_gift_voucher);
        } else {
            getResources().getStringArray(R.array.passbook_tabs);
        }
        String string = getArguments().getString("walletTransactiontype");
        j childFragmentManager = getChildFragmentManager();
        childFragmentManager.a().b(R.id.subwallet_summury_container, new e(this.f58843a.getApplicationContext(), this.m, this.o, string), (String) null).c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pass_fragment_passbook_sub_wallet, (ViewGroup) null);
    }

    public void onStart() {
        super.onStart();
        net.one97.paytm.passbook.d.b().s();
        net.one97.paytm.passbook.d.b();
    }

    public void onStop() {
        net.one97.paytm.passbook.d.b().r();
        super.onStop();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public final ArrayList<CJRTransaction> c(String str) {
        LinkedHashMap<String, ArrayList<CJRTransaction>> linkedHashMap = this.f58851i;
        if (linkedHashMap != null) {
            return linkedHashMap.get(str);
        }
        if (!com.paytm.utility.b.c((Context) this.f58843a) && this.f58843a != null) {
            if (this.j == null && this.l != null) {
                try {
                    this.j = null;
                } catch (Exception unused) {
                }
            }
            LinkedHashMap linkedHashMap2 = this.j;
            if (linkedHashMap2 != null) {
                return (ArrayList) linkedHashMap2.get(str);
            }
        }
        return null;
    }

    public final String a(String str, String str2, String str3) {
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat(str, Locale.ENGLISH).parse(str3));
        } catch (Exception unused) {
            return "";
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        this.f58847e = str;
        this.f58848f = jSONObject;
        this.f58850h = true;
        c cVar = this.l;
        ((b.C1135b) cVar.f57072a).l();
        if (!TextUtils.isEmpty(m.a(cVar.f58885b.getApplicationContext()).b("sso_token=", "", true))) {
            net.one97.paytm.passbook.d.b().a(cVar.f58885b, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.passbook.subWallet.c.c.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes6.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.passbook.subWallet.c.c.1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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
Method generation error in method: net.one97.paytm.passbook.subWallet.c.c.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes6.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.passbook.subWallet.c.c.1.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
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
            }, a.c.PASSBOOK);
        } else {
            ((b.C1135b) cVar.f57072a).k();
        }
    }

    public final void d() {
        if (!this.p && !this.r) {
            this.l.f58886c += this.l.f58887d;
        }
    }

    public final void b(String str) {
        try {
            new HashMap();
            this.f58843a.getApplicationContext();
        } catch (Exception unused) {
        }
        new b(this.f58843a, str, new net.one97.paytm.passbook.subWallet.a() {
            public final void a(String str) {
                net.one97.paytm.passbook.d.b().b(str);
            }
        }).show();
    }

    public static d a() {
        return k;
    }

    public void onDestroy() {
        super.onDestroy();
        k = null;
        System.gc();
    }

    public final void a(CJRPGTokenList cJRPGTokenList) {
        String str = this.f58847e;
        JSONObject jSONObject = this.f58848f;
        String a2 = net.one97.paytm.passbook.d.b().a(cJRPGTokenList);
        "walletSSOToken :: ".concat(String.valueOf(a2));
        com.paytm.utility.b.j();
        if (!TextUtils.isEmpty(a2)) {
            if (this.f58850h) {
                this.f58850h = false;
                this.l.a(str, jSONObject, a2);
            }
        } else if (!this.f58843a.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f58843a);
            String string = getResources().getString(R.string.title_401_410);
            builder.setTitle(string).setMessage(getResources().getString(R.string.message_401_410)).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    d.a(d.this);
                }
            });
            builder.show();
        }
        h();
        m();
        k();
    }

    public final void a(IJRDataModel iJRDataModel) {
        CJRLedgerResponse cJRLedgerResponse = (CJRLedgerResponse) iJRDataModel;
        if (this.f58849g) {
            this.f58849g = false;
        }
        if (cJRLedgerResponse != null) {
            net.one97.paytm.passbook.mapping.c.a((Context) this.f58843a, (String) null, cJRLedgerResponse.getDisplayMessage());
        }
    }

    public final void h() {
        this.f58844b.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.n);
    }

    public final void a(Throwable th) {
        if (!this.f58843a.isFinishing()) {
            Activity activity = this.f58843a;
            PassbookSubwalletActivity.class.getName();
            net.one97.paytm.passbook.utility.j.a(activity, th);
        }
    }

    public final void j() {
        this.f58844b.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.n);
    }

    public final void k() {
        ProgressDialog progressDialog = this.f58846d;
        if (progressDialog != null && progressDialog.isShowing() && !this.f58843a.isFinishing()) {
            this.f58846d.dismiss();
            this.f58846d = null;
        }
    }

    public final void a(String str, JSONObject jSONObject, String str2) {
        if (isAdded() && getActivity() != null && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener(str, jSONObject, str2) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ JSONObject f$2;
                private final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    d.this.a(this.f$1, this.f$2, this.f$3, dialogInterface, i2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, JSONObject jSONObject, String str2, DialogInterface dialogInterface, int i2) {
        this.l.a(str, jSONObject, str2);
    }

    public final void l() {
        try {
            if (this.f58845c == null) {
                this.f58845c = net.one97.paytm.passbook.mapping.c.f(this.f58843a);
            }
            if (this.f58845c != null && !this.f58845c.isShowing()) {
                this.f58845c.show();
            }
        } catch (Exception unused) {
        }
    }

    public final void m() {
        try {
            if (this.f58845c != null && this.f58845c.isShowing()) {
                this.f58845c.dismiss();
            }
        } catch (Exception unused) {
            boolean z = com.paytm.utility.b.v;
        }
    }

    static /* synthetic */ void a(d dVar) {
        c cVar = dVar.l;
        try {
            if (com.paytm.utility.b.c((Context) cVar.f58885b)) {
                net.one97.paytm.passbook.d.b().a(cVar.f58885b, cVar.f58885b.getClass().getName(), true, false);
            }
        } catch (Exception unused) {
        }
        Intent intent = new Intent(dVar.f58843a, net.one97.paytm.passbook.d.b().f());
        intent.putExtra("parent_activity", net.one97.paytm.passbook.d.b().g());
        intent.putExtra("authError", true);
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        dVar.startActivityForResult(intent, 3);
    }
}
