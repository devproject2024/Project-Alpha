package net.one97.paytm.savedPaymentItem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.AJRProfileActivity;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRSavedCards;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.savedPaymentItem.e;
import net.one97.paytm.upi.registration.view.v;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.c.a;

public class AJRSavedPaymentActivity extends PaytmActivity implements b, e.a {

    /* renamed from: a  reason: collision with root package name */
    private byte f64994a = 0;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f64995b;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.locale.b.e.a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_saved_payment);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().b(true);
        ((CollapsingToolbarLayout) findViewById(R.id.header)).setTitle(getString(R.string.saved_payment_method));
        this.f64995b = (RelativeLayout) findViewById(R.id.lyt_progress_bar);
        e eVar = (e) getSupportFragmentManager().c(e.class.getSimpleName());
        if (eVar == null) {
            eVar = new e();
            eVar.setArguments(new Bundle());
        }
        getSupportFragmentManager().a().b(R.id.activity_profile_lyt_frame, eVar, e.class.getSimpleName()).b();
        c.a();
        if (c.a("upi_enabled", false) && getSupportFragmentManager().c(v.class.getSimpleName()) == null) {
            getSupportFragmentManager().a().b(R.id.fl_upi_container, v.b("saved_payment", true), v.class.getSimpleName()).c();
        }
        getSupportFragmentManager().a().b(R.id.add_money_container_fl, new a(), a.class.getSimpleName()).c();
        b();
        byte b2 = this.f64994a;
        if (b2 == 0) {
            a(true);
        } else if (b2 == 2) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.savedcard_error_heading), getResources().getString(R.string.savedcard_error_message));
        }
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void b() {
        if (com.paytm.utility.a.m(this)) {
            t.b((Context) this);
            d.a(this, c(), this, (Map<String, String>) null, new HashMap(), a.C0715a.POST, (String) null, new CJRSavedCards(), a.c.PAYMENTS, a.b.SILENT).a();
            return;
        }
        c.a();
        a(d.a(this, c.j(), this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRSavedCards(), a.c.PAYMENTS, a.b.SILENT));
    }

    private String c() {
        c.a();
        String j = c.j();
        String b2 = t.b((Context) this);
        try {
            return Uri.parse(j).buildUpon().appendQueryParameter("JsonData", "{\"SSOToken\":\"" + b2 + "\"}").build().toString();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
            return null;
        }
    }

    public final void a() {
        b();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRSavedCards) {
            this.f64994a = 1;
            CJRSavedCards cJRSavedCards = (CJRSavedCards) iJRPaytmDataModel;
            if (this.f64994a == 1) {
                a(false);
            }
            Fragment c2 = getSupportFragmentManager().c(e.class.getSimpleName());
            if (c2 instanceof e) {
                e eVar = (e) c2;
                if (eVar.f65024b != null && cJRSavedCards != null) {
                    eVar.f65023a = cJRSavedCards;
                    if (eVar.f65023a.getSavedCardList().size() <= 0 || !(eVar.getActivity() instanceof AJRSavedPaymentActivity)) {
                        eVar.f65025c.setVisibility(0);
                        eVar.f65026d.setVisibility(8);
                    } else {
                        eVar.f65025c.setVisibility(8);
                        eVar.f65026d.setVisibility(0);
                    }
                    b bVar = eVar.f65024b;
                    CJRSavedCards cJRSavedCards2 = eVar.f65023a;
                    boolean z = eVar.f65027e;
                    bVar.f65000b = cJRSavedCards2;
                    bVar.notifyDataSetChanged();
                    if (z) {
                        new Handler().postDelayed(new Runnable() {
                            public final void run(
/*
Method generation error in method: net.one97.paytm.savedPaymentItem.b.2.run():void, dex: classes7.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.savedPaymentItem.b.2.run():void, class status: UNLOADED
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
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            
*/
                        }, 500);
                    }
                    eVar.f65027e = false;
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            a(false);
            this.f64995b.setVisibility(8);
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.network_error_message));
            sb.append(" ");
            sb.append(networkCustomError.getUrl());
            if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                new Bundle();
                r.a((Activity) this, (Exception) networkCustomError, AJRProfileActivity.class.getName(), (Bundle) null);
            } else if (networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
                runOnUiThread(new Runnable(networkCustomError) {
                    private final /* synthetic */ NetworkCustomError f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        AJRSavedPaymentActivity.this.a(this.f$1);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return;
        }
        if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
            com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
        } else if (networkCustomError.getMessage() == null || networkCustomError.getAlertMessage() == null) {
            this.f64994a = 2;
        } else {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
        }
    }

    private void a(boolean z) {
        if (this.f64995b != null && !isFinishing()) {
            if (z) {
                this.f64995b.setVisibility(0);
            } else {
                this.f64995b.setVisibility(8);
            }
        }
    }

    private void a(com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(aVar) {
            private final /* synthetic */ com.paytm.network.a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRSavedPaymentActivity.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.paytm.network.a aVar, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (com.paytm.utility.a.m(this)) {
            aVar.a();
        } else {
            a(aVar);
        }
    }
}
