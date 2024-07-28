package net.one97.paytm.addmoney.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.paytm.utility.b;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.Serializable;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.a.c;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.UpiConstants;

public class UPIInstantMoneyTransferCardView extends LinearLayout implements c.b {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.addmoney.common.c.c f48490a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48491b;

    /* renamed from: c  reason: collision with root package name */
    public String f48492c;

    /* renamed from: d  reason: collision with root package name */
    private a f48493d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f48494e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f48495f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f48496g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f48497h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f48498i;
    private TextView j;
    private TextView k;
    private TextView l;
    private AccountProviderBody.AccountProvider m;
    private AccountProviderBody.AccountProvider n;
    private AccountProviderBody.AccountProvider o;
    private AccountProviderBody.AccountProvider p;
    private AccountProviderBody.AccountProvider q;
    private View.OnClickListener r;

    public interface a {
        Fragment a();
    }

    public UPIInstantMoneyTransferCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public UPIInstantMoneyTransferCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public UPIInstantMoneyTransferCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f48491b = false;
        this.r = new View.OnClickListener() {
            public final void onClick(View view) {
                UPIInstantMoneyTransferCardView.this.a(view);
            }
        };
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_layout_upi_instant_money_transfer_addmoney, this, false);
        removeAllViews();
        addView(inflate);
        this.f48490a = new net.one97.paytm.addmoney.common.c.c(this);
        inflate.findViewById(R.id.item1_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.item2_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.item3_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.item4_ll).setOnClickListener(this.r);
        inflate.findViewById(R.id.other_bank_ll).setOnClickListener(this.r);
        this.f48494e = (ImageView) inflate.findViewById(R.id.icon1);
        this.f48495f = (ImageView) inflate.findViewById(R.id.icon2);
        this.f48496g = (ImageView) inflate.findViewById(R.id.icon3);
        this.f48497h = (ImageView) inflate.findViewById(R.id.icon4);
        this.f48498i = (TextView) inflate.findViewById(R.id.item1_tv);
        this.j = (TextView) inflate.findViewById(R.id.item2_tv);
        this.k = (TextView) inflate.findViewById(R.id.item3_tv);
        this.l = (TextView) inflate.findViewById(R.id.item4_tv);
        setVisibility(0);
        if (b.c(getContext())) {
            net.one97.paytm.addmoney.common.c.c cVar = this.f48490a;
            net.one97.paytm.helper.a.b().j();
            net.one97.paytm.helper.a.b().j();
            g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)).a((a.C1389a) new a.C1389a() {
                public final void onSuccess(
/*
Method generation error in method: net.one97.paytm.addmoney.common.c.c.1.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void, dex: classes3.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.addmoney.common.c.c.1.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void, class status: UNLOADED
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

                public final void onError(
/*
Method generation error in method: net.one97.paytm.addmoney.common.c.c.1.onError(net.one97.paytm.upi.common.UpiCustomVolleyError):void, dex: classes3.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.addmoney.common.c.c.1.onError(net.one97.paytm.upi.common.UpiCustomVolleyError):void, class status: UNLOADED
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
            }, "AddMoneyDataProvider", net.one97.paytm.addmoney.common.c.c.class.getSimpleName());
        } else if (getContext() != null && (getContext() instanceof Activity) && getVisibility() == 0) {
            j.a((Activity) getContext());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (view.getId() == R.id.item1_ll) {
            this.f48490a.a(this.m);
        } else if (view.getId() == R.id.item2_ll) {
            this.f48490a.a(this.n);
        } else if (view.getId() == R.id.item3_ll) {
            this.f48490a.a(this.o);
        } else if (view.getId() == R.id.item4_ll) {
            this.f48490a.a(this.p);
        } else if (view.getId() == R.id.other_bank_ll) {
            this.f48490a.a();
        }
    }

    public void setListener(a aVar) {
        this.f48493d = aVar;
    }

    public void setFavoriteBanks(int i2, AccountProviderBody.AccountProvider accountProvider, int i3, AccountProviderBody.AccountProvider accountProvider2, int i4, AccountProviderBody.AccountProvider accountProvider3, int i5, AccountProviderBody.AccountProvider accountProvider4) {
        this.m = accountProvider;
        this.n = accountProvider2;
        this.o = accountProvider3;
        this.p = accountProvider4;
        a(i2, accountProvider, this.f48494e, this.f48498i);
        a(i3, accountProvider2, this.f48495f, this.j);
        a(i4, accountProvider3, this.f48496g, this.k);
        a(i5, accountProvider4, this.f48497h, this.l);
    }

    private void a(int i2, AccountProviderBody.AccountProvider accountProvider, ImageView imageView, TextView textView) {
        if (i2 == -1) {
            a(imageView, accountProvider.getBankLogoUrl());
        } else {
            imageView.setImageDrawable(androidx.core.content.b.a(getContext(), i2));
        }
        textView.setText(accountProvider.getAccountProvider());
    }

    private static void a(ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            w.a().a(str).a(R.drawable.pass_ic_paytm_payments_bank_addmoney).b(R.drawable.pass_ic_paytm_payments_bank_addmoney).a(imageView, (e) null);
        } else {
            imageView.setImageResource(R.drawable.pass_ic_paytm_payments_bank_addmoney);
        }
    }

    public final void b() {
        if (getContext() == null) {
            return;
        }
        if (this.f48491b) {
            a aVar = this.f48493d;
            if (aVar != null) {
                BankVpaCreationActivity.a(aVar.a(), (AccountProviderBody.AccountProvider) AddMoneyUtils.a((Object) this.q, AccountProviderBody.AccountProvider.class), this.f48492c, 0);
                return;
            }
            return;
        }
        Intent intent = new Intent(getContext(), UpiRegistrationActivity.class);
        intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, (Serializable) AddMoneyUtils.a((Object) this.q, AccountProviderBody.AccountProvider.class));
        a aVar2 = this.f48493d;
        if (aVar2 != null) {
            aVar2.a().startActivityForResult(intent, 0);
        }
    }

    public final void a(String str) {
        Toast.makeText(getContext(), str, 0).show();
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        this.q = accountProvider;
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a(getContext(), "android.permission.READ_PHONE_STATE") == 0) {
            b();
        } else {
            ((Activity) getContext()).requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 16);
        }
    }

    public final void a() {
        if (this.f48493d != null) {
            this.f48493d.a().startActivityForResult(new Intent(getContext(), AccountProviderActivity.class), 2304);
        }
    }
}
