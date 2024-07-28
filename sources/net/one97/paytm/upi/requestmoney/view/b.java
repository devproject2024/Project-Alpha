package net.one97.paytm.upi.requestmoney.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.requestmoney.a.a;
import net.one97.paytm.upi.requestmoney.view.a;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public class b extends h implements View.OnClickListener, a.b {

    /* renamed from: a  reason: collision with root package name */
    public static int f69376a = 4;

    /* renamed from: b  reason: collision with root package name */
    public int f69377b = 0;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f69378c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f69379d;

    /* renamed from: e  reason: collision with root package name */
    private Dialog f69380e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<UpiBaseDataModel> f69381f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f69382g;

    /* renamed from: h  reason: collision with root package name */
    private int f69383h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f69384i = -1;
    /* access modifiers changed from: private */
    public com.google.android.material.bottomsheet.a j;
    private TextView k;
    private a.C1399a l;
    private a m;
    private ShimmerFrameLayout n;
    private ShimmerFrameLayout o;
    private FrameLayout p;
    private FrameLayout q;
    private ArrayList<UpiDBTransactionModel> r;

    public interface a {
        void a(ArrayList<BeneficiaryEntity> arrayList);

        void j();
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.l = (a.C1399a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.m = (a) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_request_money_beneficiary_txn, viewGroup, false);
        this.f69378c = (RecyclerView) inflate.findViewById(R.id.beneficiary_list);
        this.f69378c.setItemAnimator((RecyclerView.f) null);
        this.f69379d = (RelativeLayout) inflate.findViewById(R.id.saved_accounts_parent_layout);
        this.k = (TextView) inflate.findViewById(R.id.tv_view_all);
        this.n = (ShimmerFrameLayout) inflate.findViewById(R.id.beneficiary_shimmer_layout);
        this.o = (ShimmerFrameLayout) inflate.findViewById(R.id.self_shimmer_layout);
        this.p = (FrameLayout) inflate.findViewById(R.id.progress_layout_beneficiary);
        this.q = (FrameLayout) inflate.findViewById(R.id.progress_layout_self_account);
        this.k.setOnClickListener(this);
        this.f69378c.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f69378c.setNestedScrollingEnabled(false);
        this.f69382g = new a(getActivity(), this.f69381f, new a.C1403a() {
            public final void a(int i2) {
                int unused = b.this.f69384i = i2;
                b.a(b.this);
            }
        });
        this.f69378c.setAdapter(this.f69382g);
        if (getArguments() != null) {
            String string = getArguments().getString("title");
            if (!TextUtils.isEmpty(string)) {
                ((TextView) inflate.findViewById(R.id.tv_saved_contacts)).setText(String.valueOf(string));
            }
        }
        if (getArguments() != null) {
            this.r = getArguments().getParcelableArrayList("recent_txn");
        }
        getActivity();
        this.l = new net.one97.paytm.upi.requestmoney.presenter.a(this, g.c());
        ArrayList<UpiDBTransactionModel> arrayList = this.r;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.l.a(this.r);
        }
        this.l.e();
        return inflate;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onClick(View view) {
        if (view.getId() != R.id.tv_view_all) {
            return;
        }
        if (this.k.getText().toString().equalsIgnoreCase(getString(R.string.money_transfer_view_all))) {
            this.k.setText(getString(R.string.money_transfer_view_less));
            this.k.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a((Context) getActivity(), R.drawable.mt_up_arrow), (Drawable) null);
            a aVar = this.f69382g;
            aVar.f69339d = true;
            aVar.notifyItemRangeInserted(f69376a, this.f69381f.size() - f69376a);
            ArrayList<UpiBaseDataModel> arrayList = this.f69381f;
            if (arrayList != null && this.f69383h != arrayList.size()) {
                this.f69377b += 25;
                this.l.a(this.f69377b, this.f69383h - 25);
                return;
            }
            return;
        }
        this.k.setText(getString(R.string.money_transfer_view_all));
        this.k.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a((Context) getActivity(), R.drawable.ic_down_arrow), (Drawable) null);
        a aVar2 = this.f69382g;
        aVar2.f69339d = false;
        aVar2.notifyItemRangeRemoved(f69376a, this.f69381f.size() - f69376a);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || "410".equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
            k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            b.class.getName();
            kVar.e(activity);
            return;
        }
        CustomDialog.showAlert(getActivity(), "Error", upiCustomVolleyError.getAlertMessage());
    }

    public final void a(ArrayList<BeneficiaryEntity> arrayList, int i2) {
        a aVar;
        if (arrayList.size() == 0 && (aVar = this.m) != null) {
            aVar.j();
        }
        if (this.f69377b == 0) {
            this.f69381f.clear();
            this.f69383h = i2;
            if (arrayList.size() > f69376a) {
                this.k.setVisibility(0);
                this.k.setText(getString(R.string.money_transfer_view_all));
                this.k.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a((Context) getActivity(), R.drawable.ic_down_arrow), (Drawable) null);
            } else {
                this.k.setVisibility(8);
            }
            this.f69381f.addAll(arrayList);
            a aVar2 = this.f69382g;
            aVar2.f69339d = false;
            aVar2.notifyItemRangeInserted(0, f69376a);
            this.f69379d.setVisibility(0);
            boolean z = true;
            if (getActivity() != null) {
                z = PaytmUpiPrefUtil.getPref(getActivity().getApplicationContext()).b("is_beneficiary_animation_shown", false, true);
            }
            if (!z) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        b.b(b.this);
                        a c2 = b.this.f69382g;
                        if (c2.getItemCount() > 0) {
                            c2.f69336a.a("0");
                            new Handler().postDelayed(new Runnable() {
                                public final void run(
/*
Method generation error in method: net.one97.paytm.upi.requestmoney.view.a.1.run():void, dex: classes7.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.requestmoney.view.a.1.run():void, class status: UNLOADED
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
                }, 1000);
            }
        } else {
            int size = this.f69381f.size();
            this.f69381f.addAll(arrayList);
            this.f69382g.notifyItemRangeInserted(size, arrayList.size());
        }
        a aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(arrayList);
        }
    }

    public final void a(boolean z) {
        if (z) {
            if (this.f69380e == null) {
                this.f69380e = UpiAppUtils.getWalletStyleProgressDialog(getActivity());
            }
            Dialog dialog = this.f69380e;
            if (dialog != null && !dialog.isShowing()) {
                this.f69380e.show();
                return;
            }
            return;
        }
        Dialog dialog2 = this.f69380e;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f69380e.dismiss();
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.p.setVisibility(0);
            this.n.startShimmerAnimation();
            return;
        }
        this.p.setVisibility(8);
        this.n.stopShimmerAnimation();
    }

    public final void a() {
        UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_DELETE_SAVED_BANK, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "", "", "");
        this.f69381f.remove(this.f69384i);
        if (this.k.getVisibility() != 0 || !this.k.getText().toString().equalsIgnoreCase(getString(R.string.money_transfer_view_all))) {
            this.f69382g.f69339d = true;
        } else {
            this.f69382g.f69339d = false;
        }
        this.f69382g.notifyItemRemoved(this.f69384i);
        if (this.f69381f.size() <= f69376a) {
            this.k.setVisibility(8);
        }
        ArrayList<UpiBaseDataModel> arrayList = this.f69381f;
        if (arrayList != null && arrayList.size() == 0) {
            this.f69379d.setVisibility(8);
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            CustomDialog.showCustomAlert(getActivity(), getResources().getString(R.string.error), str);
        } else {
            CustomDialog.showCustomAlert(getActivity(), getResources().getString(R.string.error), getResources().getString(R.string.upi_some_went_wrong));
        }
    }

    static /* synthetic */ void a(b bVar) {
        View inflate = LayoutInflater.from(bVar.getActivity()).inflate(R.layout.confirm_delete_bottom_sheet, (ViewGroup) null);
        bVar.j = new com.google.android.material.bottomsheet.a(bVar.getActivity());
        bVar.j.setContentView(inflate);
        bVar.j.setCancelable(false);
        bVar.j.setCanceledOnTouchOutside(false);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        from.setState(3);
        bVar.j.show();
        bVar.j.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
            }
        });
        ((TextView) inflate.findViewById(R.id.recent_delete_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.j.dismiss();
                b.e(b.this);
            }
        });
        ((TextView) inflate.findViewById(R.id.recent_cancel_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.j.dismiss();
            }
        });
    }

    static /* synthetic */ void b(b bVar) {
        if (bVar.getActivity() != null) {
            PaytmUpiPrefUtil.getPref(bVar.getActivity().getApplicationContext()).a("is_beneficiary_animation_shown", true, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void e(net.one97.paytm.upi.requestmoney.view.b r5) {
        /*
            java.util.ArrayList<net.one97.paytm.upi.common.UpiBaseDataModel> r0 = r5.f69381f
            int r1 = r5.f69384i
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.upi.common.models.BeneficiaryEntity r0 = (net.one97.paytm.upi.common.models.BeneficiaryEntity) r0
            java.lang.String r0 = r0.beneficiaryId
            java.util.ArrayList<net.one97.paytm.upi.common.UpiBaseDataModel> r1 = r5.f69381f
            int r2 = r5.f69384i
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.upi.common.models.BeneficiaryEntity r1 = (net.one97.paytm.upi.common.models.BeneficiaryEntity) r1
            net.one97.paytm.upi.common.models.BeneficiaryEntity$InstrumentPreferences r1 = r1.instrumentPreferences
            net.one97.paytm.upi.common.models.BeneficiaryEntity$OtherBank r1 = r1.otherBank
            r2 = 0
            if (r1 == 0) goto L_0x0036
            java.util.ArrayList<net.one97.paytm.upi.common.UpiBaseDataModel> r1 = r5.f69381f
            int r3 = r5.f69384i
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.upi.common.models.BeneficiaryEntity r1 = (net.one97.paytm.upi.common.models.BeneficiaryEntity) r1
            net.one97.paytm.upi.common.models.BeneficiaryEntity$InstrumentPreferences r1 = r1.instrumentPreferences
            net.one97.paytm.upi.common.models.BeneficiaryEntity$OtherBank r1 = r1.otherBank
            java.util.ArrayList<net.one97.paytm.upi.common.models.BeneficiaryEntity$OtherBankAccount> r1 = r1.accounts
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.upi.common.models.BeneficiaryEntity$OtherBankAccount r1 = (net.one97.paytm.upi.common.models.BeneficiaryEntity.OtherBankAccount) r1
            java.lang.String r1 = r1.uuid
            goto L_0x0064
        L_0x0036:
            java.util.ArrayList<net.one97.paytm.upi.common.UpiBaseDataModel> r1 = r5.f69381f
            int r3 = r5.f69384i
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.upi.common.models.BeneficiaryEntity r1 = (net.one97.paytm.upi.common.models.BeneficiaryEntity) r1
            net.one97.paytm.upi.common.models.BeneficiaryEntity$InstrumentPreferences r1 = r1.instrumentPreferences
            net.one97.paytm.upi.common.models.BeneficiaryEntity$UPI r1 = r1.upi
            if (r1 == 0) goto L_0x0062
            r1 = 1
            java.util.ArrayList<net.one97.paytm.upi.common.UpiBaseDataModel> r3 = r5.f69381f
            int r4 = r5.f69384i
            java.lang.Object r3 = r3.get(r4)
            net.one97.paytm.upi.common.models.BeneficiaryEntity r3 = (net.one97.paytm.upi.common.models.BeneficiaryEntity) r3
            net.one97.paytm.upi.common.models.BeneficiaryEntity$InstrumentPreferences r3 = r3.instrumentPreferences
            net.one97.paytm.upi.common.models.BeneficiaryEntity$UPI r3 = r3.upi
            java.util.ArrayList<net.one97.paytm.upi.common.models.BeneficiaryEntity$UPIAccount> r3 = r3.accounts
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.upi.common.models.BeneficiaryEntity$UPIAccount r3 = (net.one97.paytm.upi.common.models.BeneficiaryEntity.UPIAccount) r3
            java.lang.String r3 = r3.uuid
            r1 = r3
            r3 = 1
            goto L_0x0065
        L_0x0062:
            java.lang.String r1 = ""
        L_0x0064:
            r3 = 0
        L_0x0065:
            androidx.fragment.app.FragmentActivity r4 = r5.getActivity()
            boolean r4 = net.one97.paytm.upi.util.UpiAppUtils.isNetworkAvailable(r4)
            if (r4 == 0) goto L_0x0075
            net.one97.paytm.upi.requestmoney.a.a$a r5 = r5.l
            r5.a(r1, r0, r3)
            return
        L_0x0075:
            r5.a((boolean) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.requestmoney.view.b.e(net.one97.paytm.upi.requestmoney.view.b):void");
    }
}
