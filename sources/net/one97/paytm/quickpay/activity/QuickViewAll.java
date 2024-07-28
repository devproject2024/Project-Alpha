package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.quick_pay.DeleteQuickPayResponse;
import net.one97.paytm.common.entity.quick_pay.Payload;
import net.one97.paytm.common.entity.quick_pay.QuickListResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.common.entity.recharge.CJRMarkAsPaidResponse;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.a.d;
import net.one97.paytm.quickpay.utilities.a;
import net.one97.paytm.quickpay.utilities.i;
import net.one97.paytm.quickpay.utilities.j;
import net.one97.paytm.recharge.common.utils.v;
import net.one97.paytm.utils.ao;
import net.one97.paytm.utils.r;
import net.one97.paytm.wallet.newdesign.utils.AppExecutor;

public class QuickViewAll extends QuickPaymentActivity implements View.OnClickListener, d.b, d.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f60045a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<IJRDataModel> f60046c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f60047d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f60048e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f60049f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f60050g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f60051h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public IJRPaytmDataModel f60052i;
    private final int j = CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE;
    private final int k = 205;
    private final String l = "is_refresh_needed";
    private final String m = "key_is_delete_automatic";
    private Future n;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(getResources().getColor(R.color.color_f3f7f8));
        setContentView((int) R.layout.activity_quick_view_all);
        findViewById(R.id.add_new_ll).setOnClickListener(this);
        if (getIntent().getExtras() != null) {
            this.f60046c = (ArrayList) getIntent().getExtras().getSerializable("QuickPaymentList");
            if (this.f60046c == null) {
                this.f60046c = net.one97.paytm.quickpay.d.a.a().b();
            }
            List<IJRDataModel> list = this.f60046c;
            if (list == null || list.size() <= 0) {
                this.f60046c = new ArrayList();
            } else {
                this.f60046c.remove(0);
            }
        }
        this.f60045a = (RecyclerView) findViewById(R.id.rvViewAll);
        this.f60051h = (TextView) findViewById(R.id.txt_empty_view);
        this.f60045a.setLayoutManager(new LinearLayoutManager(this));
        this.f60047d = new d(this, this.f60046c, this, this);
        List<IJRDataModel> list2 = this.f60046c;
        if (list2 == null || list2.size() <= 0) {
            this.f60051h.setVisibility(0);
            this.f60045a.setVisibility(8);
        } else {
            this.f60051h.setVisibility(8);
            this.f60045a.setVisibility(0);
            this.f60045a.setAdapter(this.f60047d);
        }
        this.f60048e = (ImageView) findViewById(R.id.ivBackBtn);
        this.f60048e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QuickViewAll.this.finish();
            }
        });
        if (!net.one97.paytm.quickpay.d.a.a().f60096c) {
            net.one97.paytm.quickpay.d.a.a().f60096c = true;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    d a2 = QuickViewAll.this.f60047d;
                    if (a2.f59868e != null && a2.getItemCount() > 0) {
                        j jVar = a2.f59868e;
                        synchronized (jVar.f60141e) {
                            jVar.f60137a.put("0", 2);
                            if (jVar.f60138b.containsKey("0")) {
                                jVar.f60138b.get("0").a(true);
                            } else if (jVar.f60140d) {
                                jVar.a("0", jVar.f60138b.get("0"));
                            }
                        }
                        new Handler().postDelayed(new Runnable() {
                            public final void run(
/*
Method generation error in method: net.one97.paytm.quickpay.a.d.3.run():void, dex: classes6.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.a.d.3.run():void, class status: UNLOADED
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
                }
            }, 900);
        }
        b();
    }

    private void b() {
        if (com.paytm.utility.a.m(this)) {
            String a2 = net.one97.paytm.common.b.d.b().a("updated_auto_subscription_url");
            net.one97.paytm.common.b.d.a(this, com.paytm.utility.a.c(this, a2), new b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    IJRPaytmDataModel unused = QuickViewAll.this.f60052i = iJRPaytmDataModel;
                    ArrayList<String> a2 = net.one97.paytm.common.b.d.a().a(iJRPaytmDataModel);
                    if (!a2.isEmpty() && QuickViewAll.this.f60047d != null) {
                        QuickViewAll.this.f60047d.a(a2);
                    }
                }
            }, com.paytm.utility.a.a((HashMap<String, String>) new HashMap(), (Context) this), (Map<String, String>) null, a.C0715a.GET, (String) null, net.one97.paytm.common.b.d.a().F(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    public void onBackPressed() {
        if (this.f60050g) {
            setResult(-1);
        }
        super.onBackPressed();
    }

    public void onResume() {
        super.onResume();
        this.n = AppExecutor.getExecutor().runOnBgThread(new Runnable() {
            public final void run() {
                QuickViewAll.this.c();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        net.one97.paytm.quickpay.d.a.a().a(net.one97.paytm.quickpay.b.a.a(this));
        AppExecutor.getExecutor().runOnUiThread(new Runnable() {
            public final void run() {
                QuickViewAll.this.d();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f60046c = net.one97.paytm.quickpay.d.a.a().b();
        this.f60047d = new d(this, this.f60046c, this, this);
        List<IJRDataModel> list = this.f60046c;
        if (list == null || list.size() <= 0) {
            this.f60051h.setVisibility(0);
            this.f60045a.setVisibility(8);
            return;
        }
        this.f60051h.setVisibility(8);
        this.f60045a.setVisibility(0);
        this.f60045a.setAdapter(this.f60047d);
        if (this.f60052i != null) {
            this.f60047d.a(net.one97.paytm.common.b.d.a().a(this.f60052i));
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.add_new_ll) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    QuickViewAll.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (com.paytm.utility.a.p(QuickViewAll.this)) {
                                QuickViewAll.this.startActivity(new Intent(QuickViewAll.this, PaymentReminderCreationActivity.class));
                                return;
                            }
                            QuickViewAll.a(QuickViewAll.this, PaymentReminderCreationActivity.class.getName(), QuickViewAll.this.getString(R.string.hello_sign_in));
                        }
                    });
                }
            }, 400);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if ((i2 == 204 || i2 == 205) && i3 == -1) {
            new StringBuilder("mainapp -> is_refresh_needed -> ").append(intent.hasExtra("is_refresh_needed") && intent.getBooleanExtra("is_refresh_needed", false));
            if ((intent != null && intent.hasExtra("is_refresh_needed") && intent.getBooleanExtra("is_refresh_needed", false)) || (intent.hasExtra("key_is_delete_automatic") && intent.getBooleanExtra("key_is_delete_automatic", false))) {
                b();
            }
        }
    }

    public final void c(final int i2) {
        net.one97.paytm.quickpay.utilities.b a2 = net.one97.paytm.quickpay.utilities.b.a(new net.one97.paytm.quickpay.c.b() {
            public final void a(int i2) {
                if (i2 == 2) {
                    QuickViewAll.this.finish();
                } else if (i2 == 4 && QuickViewAll.this.f60047d != null) {
                    d a2 = QuickViewAll.this.f60047d;
                    int i3 = i2;
                    if (a2.f59868e != null) {
                        a2.f59868e.a(String.valueOf(i3));
                    }
                    QuickViewAll.this.f60047d.a(net.one97.paytm.quickpay.d.a.a().b());
                }
            }
        }, (StandingInstructionList) this.f60046c.get(i2), getSupportFragmentManager());
        ao.a(QuickViewAll.class, "onMoreClick");
        a2.show(getSupportFragmentManager().a(), (String) null);
    }

    public final void d(int i2) {
        String str;
        final IJRDataModel iJRDataModel = this.f60046c.get(i2);
        String str2 = "";
        String str3 = "null";
        final boolean z = false;
        if (iJRDataModel instanceof StandingInstructionList) {
            StandingInstructionList standingInstructionList = (StandingInstructionList) iJRDataModel;
            str2 = standingInstructionList.getSupportingData() != null ? standingInstructionList.getSupportingData().getTagName() : str3;
            str = standingInstructionList != null ? standingInstructionList.getReminderDisplayName() : str3;
        } else if (iJRDataModel instanceof CJRFrequentOrder) {
            CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) iJRDataModel;
            if (!TextUtils.isEmpty(cJRFrequentOrder.getPayLabel())) {
                str3 = cJRFrequentOrder.getPayLabel();
            }
            if (cJRFrequentOrder.getConfiguration() != null && !TextUtils.isEmpty(cJRFrequentOrder.getConfiguration().get("recharge_number"))) {
                str2 = cJRFrequentOrder.getConfiguration().get("recharge_number");
            }
            CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
            if (frequentOrderProduct != null && !TextUtils.isEmpty(frequentOrderProduct.getRemindable()) && frequentOrderProduct.getRemindable().equalsIgnoreCase("2")) {
                z = true;
            }
            str = str2;
            str2 = str3;
        } else {
            str = str2;
        }
        this.f60049f = net.one97.paytm.quickpay.utilities.a.a((net.one97.paytm.quickpay.c.a) new net.one97.paytm.quickpay.c.a() {
            public final void a(int i2) {
                if (i2 == 1) {
                    IJRDataModel iJRDataModel = iJRDataModel;
                    if (iJRDataModel instanceof StandingInstructionList) {
                        QuickViewAll.a(QuickViewAll.this, (StandingInstructionList) iJRDataModel);
                    } else if ((iJRDataModel instanceof CJRFrequentOrder) && com.paytm.utility.a.m(QuickViewAll.this)) {
                        QuickViewAll quickViewAll = QuickViewAll.this;
                        quickViewAll.a((Context) quickViewAll, quickViewAll.getResources().getString(R.string.loading));
                        if (z) {
                            new v(QuickViewAll.this, new v.a() {
                                public final void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
                                    QuickViewAll.this.a();
                                    if (1007 == i2) {
                                        net.one97.paytm.quickpay.d.a.a().f();
                                        if (QuickViewAll.this.f60046c != null && QuickViewAll.this.f60046c.size() > 0 && cJRFrequentOrder != null) {
                                            QuickViewAll.this.f60046c.remove(cJRFrequentOrder);
                                            QuickViewAll.this.f60047d.notifyDataSetChanged();
                                        }
                                    }
                                }

                                public final void a() {
                                    QuickViewAll.this.a();
                                }
                            }).b(QuickViewAll.this, (CJRFrequentOrder) iJRDataModel);
                        } else {
                            new v(QuickViewAll.this, new v.a() {
                                public final void a(int i2, CJRFrequentOrder cJRFrequentOrder) {
                                    QuickViewAll.this.a();
                                    if (1007 == i2) {
                                        net.one97.paytm.quickpay.d.a.a().f();
                                        if (QuickViewAll.this.f60046c != null && QuickViewAll.this.f60046c.size() > 0 && cJRFrequentOrder != null) {
                                            QuickViewAll.this.f60046c.remove(cJRFrequentOrder);
                                            QuickViewAll.this.f60047d.notifyDataSetChanged();
                                        }
                                    }
                                }

                                public final void a() {
                                    QuickViewAll.this.a();
                                }
                            }).a((Context) QuickViewAll.this, (CJRFrequentOrder) iJRDataModel);
                        }
                    }
                    if (QuickViewAll.this.f60047d != null) {
                        QuickViewAll.this.f60047d.notifyDataSetChanged();
                    }
                }
            }
        }, str2, str);
        ao.a(QuickViewAll.class, "onDeleteClick");
        this.f60049f.show(getSupportFragmentManager().a(), (String) null);
    }

    public final void e(final int i2) {
        final StandingInstructionList standingInstructionList = (StandingInstructionList) this.f60046c.get(i2);
        this.f60049f = net.one97.paytm.quickpay.utilities.a.a((net.one97.paytm.quickpay.c.a) new net.one97.paytm.quickpay.c.a() {
            public final void a(int i2) {
                if (i2 == 5 || i2 == 5) {
                    QuickViewAll.a(QuickViewAll.this, standingInstructionList.getId(), "QUICK_PAYMENTS", !standingInstructionList.isMarkedAsPaid(), i2);
                }
            }
        }, standingInstructionList.getSupportingData() != null ? standingInstructionList.getSupportingData().getTagName() : "null", !standingInstructionList.isMarkedAsPaid() ? 2 : 3);
        ao.a(QuickViewAll.class, "onMarkAsPaid");
        this.f60049f.show(getSupportFragmentManager().a(), (String) null);
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder) {
        net.one97.paytm.common.b.d.a().b((Context) this, cJRFrequentOrder);
    }

    public final void b(CJRFrequentOrder cJRFrequentOrder) {
        net.one97.paytm.common.b.d.a().a((Context) this, cJRFrequentOrder, this.f60052i);
    }

    public final void a(final IJRDataModel iJRDataModel, final int i2, final String str) {
        if (!(iJRDataModel instanceof CJRFrequentOrder)) {
            return;
        }
        if (com.paytm.utility.a.m(this)) {
            this.f60049f = net.one97.paytm.quickpay.utilities.a.a((net.one97.paytm.quickpay.c.a) new net.one97.paytm.quickpay.c.a() {
                public final void a(int i2) {
                    if (i2 == 5) {
                        if (QuickViewAll.this.f60049f != null) {
                            QuickViewAll.this.f60049f.dismiss();
                        }
                        QuickViewAll.a(QuickViewAll.this, iJRDataModel, i2, str);
                    }
                }
            }, "null", 2);
            ao.a(QuickViewAll.class, "showConfirmMarkAsPaidBottomSheet");
            this.f60049f.show(getSupportFragmentManager().a(), (String) null);
            return;
        }
        net.one97.paytm.quickpay.utilities.d.a(this, getString(R.string.no_connection), getString(R.string.no_internet));
    }

    public void onDestroy() {
        Future future = this.n;
        if (future != null && !future.isCancelled() && !this.n.isDone()) {
            this.n.cancel(true);
        }
        super.onDestroy();
    }

    public final void a(int i2) {
        IJRDataModel iJRDataModel = this.f60046c.get(i2);
        if (iJRDataModel instanceof CJRFrequentOrder) {
            net.one97.paytm.common.b.d.a().a((CJRFrequentOrder) iJRDataModel, (Activity) this, i2);
        } else if (!(iJRDataModel instanceof StandingInstructionList)) {
            net.one97.paytm.common.b.d.a().a(iJRDataModel, (Context) this);
        }
    }

    static /* synthetic */ void a(QuickViewAll quickViewAll, String str, String str2) {
        Intent b2 = net.one97.paytm.common.b.d.a().b((Activity) quickViewAll);
        if (str != null) {
            b2.putExtra("resultant activity", str);
            com.paytm.utility.a.c();
        }
        b2.putExtra("sign_in_sign_up_with_step_2", true);
        if (!TextUtils.isEmpty(str2)) {
            b2.putExtra("sign_in_title", str2);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            b2.putExtra("sign_up_title", (String) null);
        }
        b2.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        quickViewAll.startActivityForResult(b2, 111);
    }

    static /* synthetic */ void a(QuickViewAll quickViewAll, final StandingInstructionList standingInstructionList) {
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", net.one97.paytm.common.b.d.a().b((Context) quickViewAll));
        hashMap.put("Content-Type", "application/json");
        if (com.paytm.utility.a.m(quickViewAll)) {
            quickViewAll.a((Context) quickViewAll, quickViewAll.getResources().getString(R.string.loading));
            net.one97.paytm.common.b.d.a(quickViewAll, net.one97.paytm.common.b.d.b().a("deactivateQuickPaymentUrl") + "?siId=" + standingInstructionList.getId() + "&siType=" + standingInstructionList.getType(), new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    QuickViewAll.this.a();
                    if (iJRPaytmDataModel instanceof DeleteQuickPayResponse) {
                        DeleteQuickPayResponse deleteQuickPayResponse = (DeleteQuickPayResponse) iJRPaytmDataModel;
                        if (deleteQuickPayResponse.getResponseCode() == 200) {
                            standingInstructionList.setStatus(i.DEACTIVATE.getStatus());
                            net.one97.paytm.quickpay.b.a.a((Context) QuickViewAll.this, standingInstructionList);
                            net.one97.paytm.quickpay.d.a.a().a(standingInstructionList);
                            QuickViewAll.this.f60049f.dismiss();
                            List unused = QuickViewAll.this.f60046c = net.one97.paytm.quickpay.d.a.a().b();
                            if (QuickViewAll.this.f60046c == null || QuickViewAll.this.f60046c.size() <= 0) {
                                QuickViewAll.this.f60051h.setVisibility(0);
                                QuickViewAll.this.f60045a.setVisibility(8);
                            } else {
                                QuickViewAll.this.f60051h.setVisibility(8);
                                QuickViewAll.this.f60045a.setVisibility(0);
                            }
                            QuickViewAll.this.f60047d.a((List<IJRDataModel>) QuickViewAll.this.f60046c);
                            Toast.makeText(QuickViewAll.this, "Deleted Successfully", 1).show();
                            return;
                        }
                        String responseMessage = deleteQuickPayResponse.getResponseMessage();
                        if (TextUtils.isEmpty(responseMessage)) {
                            responseMessage = "Something went wrong";
                        }
                        net.one97.paytm.quickpay.utilities.d.a(QuickViewAll.this, "Error", responseMessage);
                        return;
                    }
                    net.one97.paytm.quickpay.utilities.d.a(QuickViewAll.this, "Error", "Something went wrong");
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    QuickViewAll.this.a();
                    if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                        net.one97.paytm.quickpay.utilities.d.a(QuickViewAll.this, "Error", "Something went wrong");
                    } else {
                        r.a(QuickViewAll.this, (String) null, (Bundle) null, false, false);
                    }
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.PUT, (String) null, new DeleteQuickPayResponse(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    static /* synthetic */ void a(QuickViewAll quickViewAll, final String str, String str2, boolean z, final int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", net.one97.paytm.common.b.d.a().b((Context) quickViewAll));
        hashMap.put("Content-Type", "application/json");
        String a2 = net.one97.paytm.common.b.d.a().a(str, str2, z);
        if (!TextUtils.isEmpty(a2)) {
            String a3 = c.a((Context) quickViewAll, false);
            if (!TextUtils.isEmpty(a3) && a3.contains("?")) {
                a2 = a2 + a3.replace("?", AppConstants.AND_SIGN);
            }
            String str3 = a2;
            if (com.paytm.utility.a.m(quickViewAll)) {
                quickViewAll.a((Context) quickViewAll, quickViewAll.getResources().getString(R.string.loading));
                net.one97.paytm.common.b.d.a(quickViewAll, str3, new b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        QuickViewAll.this.a();
                        if (iJRPaytmDataModel instanceof DeleteQuickPayResponse) {
                            DeleteQuickPayResponse deleteQuickPayResponse = (DeleteQuickPayResponse) iJRPaytmDataModel;
                            if (deleteQuickPayResponse.getResponseCode() == 200) {
                                QuickViewAll.a(QuickViewAll.this, str, i2);
                                return;
                            }
                            String responseMessage = deleteQuickPayResponse.getResponseMessage();
                            if (TextUtils.isEmpty(responseMessage)) {
                                responseMessage = "Something went wrong";
                            }
                            net.one97.paytm.quickpay.utilities.d.a(QuickViewAll.this, "Error", responseMessage);
                            return;
                        }
                        net.one97.paytm.quickpay.utilities.d.a(QuickViewAll.this, "Error", "Something went wrong");
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        QuickViewAll.this.a();
                        if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                            net.one97.paytm.quickpay.utilities.d.a(QuickViewAll.this, "Error", "Something went wrong");
                        } else {
                            r.a(QuickViewAll.this, (String) null, (Bundle) null, false, false);
                        }
                    }
                }, hashMap, (Map<String, String>) null, a.C0715a.PUT, (String) null, new DeleteQuickPayResponse(), a.c.PAYMENTS, a.b.SILENT).a();
            }
        }
    }

    static /* synthetic */ void a(QuickViewAll quickViewAll, String str, final int i2) {
        String a2 = net.one97.paytm.common.b.d.b().a("getQuickPaymentsUrl");
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", net.one97.paytm.common.b.d.a().b((Context) quickViewAll));
            com.paytm.network.a a3 = net.one97.paytm.common.b.d.a(quickViewAll, a2 + "&siId=" + str, new b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    QuickViewAll.this.a();
                    if (iJRPaytmDataModel != null) {
                        QuickListResponse quickListResponse = (QuickListResponse) iJRPaytmDataModel;
                        Payload payload = quickListResponse.getPayload();
                        if (payload == null || payload.getStandingInstructionList() == null || payload.getStandingInstructionList().size() <= 0) {
                            String responseMessage = quickListResponse.getResponseMessage();
                            if (TextUtils.isEmpty(responseMessage)) {
                                responseMessage = "Something went wrong";
                            }
                            QuickViewAll.this.a("Error", responseMessage);
                            return;
                        }
                        int i2 = 0;
                        StandingInstructionList standingInstructionList = payload.getStandingInstructionList().get(0);
                        if (standingInstructionList != null) {
                            net.one97.paytm.quickpay.b.a.a((Context) QuickViewAll.this, standingInstructionList);
                            if (QuickViewAll.this.f60047d != null) {
                                d a2 = QuickViewAll.this.f60047d;
                                int i3 = i2;
                                boolean isMarkedAsPaid = standingInstructionList.isMarkedAsPaid();
                                if (a2.f59864a != null) {
                                    while (true) {
                                        if (i2 < a2.f59864a.size()) {
                                            if (i2 == i3 && (a2.f59864a.get(i2) instanceof StandingInstructionList)) {
                                                ((StandingInstructionList) a2.f59864a.get(i2)).setMarkedAsPaid(isMarkedAsPaid);
                                                break;
                                            }
                                            i2++;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                a2.notifyDataSetChanged();
                            }
                            if (QuickViewAll.this.f60049f != null) {
                                QuickViewAll.this.f60049f.dismiss();
                                return;
                            }
                            return;
                        }
                        String responseMessage2 = quickListResponse.getResponseMessage();
                        if (TextUtils.isEmpty(responseMessage2)) {
                            responseMessage2 = "Something went wrong";
                        }
                        QuickViewAll.this.a("Error", responseMessage2);
                        return;
                    }
                    QuickViewAll.this.a("Error", "Something went wrong");
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    QuickViewAll.this.a();
                    QuickViewAll.this.a("Error", "Something went wrong");
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new QuickListResponse(), a.c.PAYMENTS, a.b.SILENT);
            if (com.paytm.utility.a.m(quickViewAll)) {
                a3.a();
            }
        }
    }

    static /* synthetic */ void a(QuickViewAll quickViewAll, IJRDataModel iJRDataModel, final int i2, String str) {
        String a2 = net.one97.paytm.common.b.d.a().a((CJRFrequentOrder) iJRDataModel, str);
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, net.one97.paytm.common.b.d.a().b((Context) quickViewAll));
            net.one97.paytm.common.b.d.a(quickViewAll, net.one97.paytm.common.b.d.b().a("rechargeMarkAsPaidUrl"), new b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    CJRMarkAsPaidResponse cJRMarkAsPaidResponse = (CJRMarkAsPaidResponse) iJRPaytmDataModel;
                    if (cJRMarkAsPaidResponse.getStatus() == 200) {
                        String message = cJRMarkAsPaidResponse.getMessage();
                        if (!TextUtils.isEmpty(message) && message.equalsIgnoreCase(com.appsflyer.internal.referrer.Payload.RESPONSE_OK) && QuickViewAll.this.f60046c != null) {
                            boolean unused = QuickViewAll.this.f60050g = true;
                            d a2 = QuickViewAll.this.f60047d;
                            List<IJRDataModel> b2 = QuickViewAll.this.f60046c;
                            int i2 = i2;
                            a2.f59864a = b2;
                            IJRDataModel iJRDataModel = a2.f59864a.get(i2);
                            if (iJRDataModel != null && (iJRDataModel instanceof CJRFrequentOrder)) {
                                CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) iJRDataModel;
                                cJRFrequentOrder.setMarkAsPaidShown(false);
                                cJRFrequentOrder.setFirstLoad(false);
                                cJRFrequentOrder.setCjrBillDetails((CJRBillDetails) null);
                            }
                            a2.notifyDataSetChanged();
                        }
                    }
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.POST, a2, new CJRMarkAsPaidResponse(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }
}
