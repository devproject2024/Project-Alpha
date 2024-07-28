package net.one97.paytm.p2b.view.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.P2B.CJRP2bCheckTxnStatus;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.common.entity.wallet.CJRP2BStatusResponse;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse;
import net.one97.paytm.common.entity.wallet.CJRValidateTransaction;
import net.one97.paytm.common.entity.wallet.P2BCommissionMetaObject;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.p2b.data.a;
import net.one97.paytm.p2b.data.a.a;
import net.one97.paytm.p2b.e.c;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.p2b.view.CustomView.P2bShimmerAnimationLayout;
import net.one97.paytm.upi.util.UpiUtils;

public final class j extends net.one97.paytm.i.h implements View.OnClickListener, net.one97.paytm.p2b.b.f {
    private TextView A;
    private ConstraintLayout B;
    private ConstraintLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private ConstraintLayout F;
    private TextView G;
    private TextView H;
    private ImageView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private TextView V;
    private net.one97.paytm.p2b.d.j W;
    private String X;
    private LinearLayout Y;
    private P2bShimmerAnimationLayout Z;

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.p2b.e.c f13046a;
    private Group aa;
    private TextView ab;
    /* access modifiers changed from: private */
    public TextView ac;
    private ImageView ad;
    private TextView ae;
    private TextView af;
    private LinearLayout ag;
    private HashMap ah;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f13047b;

    /* renamed from: c  reason: collision with root package name */
    final int f13048c;

    /* renamed from: d  reason: collision with root package name */
    TextView f13049d;

    /* renamed from: e  reason: collision with root package name */
    ConstraintLayout f13050e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f13051f;

    /* renamed from: g  reason: collision with root package name */
    Handler f13052g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    private ImageView f13053h;

    /* renamed from: i  reason: collision with root package name */
    private Dialog f13054i;
    private ConstraintLayout j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private ConstraintLayout p;
    private ConstraintLayout q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private TextView y;
    private TextView z;

    static final class c<T> implements z<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13057a;

        c(j jVar) {
            this.f13057a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            j.a(this.f13057a, (IJRDataModel) obj);
        }
    }

    static final class d<T> implements z<net.one97.paytm.p2b.data.a<CJRP2BStatus>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13058a;

        d(j jVar) {
            this.f13058a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.p2b.data.b bVar;
            net.one97.paytm.p2b.data.a aVar = (net.one97.paytm.p2b.data.a) obj;
            if (aVar != null) {
                bVar = aVar.f12729a;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                int i2 = k.f13077a[bVar.ordinal()];
                if (i2 == 1) {
                    j.a(this.f13058a);
                } else if (i2 == 2) {
                    j.a(this.f13058a, (CJRP2BStatus) aVar.f12730b);
                } else if (i2 == 3) {
                    j.a(this.f13058a, aVar.f12731c);
                }
            }
        }
    }

    public j() {
        h.a aVar = net.one97.paytm.p2b.d.h.f12718a;
        int a2 = net.one97.paytm.p2b.d.h.b(h.a.a()).a("w2bPostPayMaxPollingCount", 9);
        h.a aVar2 = net.one97.paytm.p2b.d.h.f12718a;
        this.f13048c = a2 * net.one97.paytm.p2b.d.h.b(h.a.a()).a("w2bPostPayPollingDuration", 5);
    }

    public final void a() {
        b();
    }

    public final void onClick(View view) {
        net.one97.paytm.p2b.e.c cVar;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.viewDetailTv;
        if (valueOf != null && valueOf.intValue() == i2) {
            ConstraintLayout constraintLayout = this.j;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(Color.parseColor("#21c17a"));
            }
            TextView textView = this.k;
            if (textView != null) {
                textView.setText(getString(R.string.p2b_money_sen_sucessfully));
            }
            ImageView imageView = this.l;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            ConstraintLayout constraintLayout2 = this.C;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
            ConstraintLayout constraintLayout3 = this.F;
            if (constraintLayout3 != null) {
                constraintLayout3.setVisibility(8);
            }
            ConstraintLayout constraintLayout4 = this.p;
            if (constraintLayout4 != null) {
                constraintLayout4.setVisibility(0);
            }
            ConstraintLayout constraintLayout5 = this.B;
            if (constraintLayout5 != null) {
                constraintLayout5.setVisibility(8);
            }
            ConstraintLayout constraintLayout6 = this.q;
            if (constraintLayout6 != null) {
                constraintLayout6.setVisibility(8);
            }
            e();
            net.one97.paytm.p2b.d.j jVar = this.W;
            if (jVar != null) {
                jVar.a(true, true);
            }
            net.one97.paytm.p2b.d.j jVar2 = this.W;
            if (jVar2 != null) {
                jVar2.a(Boolean.TRUE);
            }
            net.one97.paytm.p2b.d.j jVar3 = this.W;
            if (jVar3 != null) {
                jVar3.a(false);
                return;
            }
            return;
        }
        int i3 = R.id.iv_share;
        if (valueOf != null && valueOf.intValue() == i3) {
            net.one97.paytm.p2b.d.j jVar4 = this.W;
            if (jVar4 != null) {
                jVar4.c();
                return;
            }
            return;
        }
        int i4 = R.id.tryAgainTv;
        if (valueOf != null && valueOf.intValue() == i4 && isAdded() && (cVar = this.f13046a) != null) {
            y<net.one97.paytm.p2b.data.a<CJRP2BStatus>> yVar = cVar.f12789e;
            a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
            yVar.setValue(a.C0168a.a());
            net.one97.paytm.p2b.data.a.b bVar = cVar.f12785a;
            if (bVar != null) {
                bVar.a(new c.b(cVar), "", "", "", false, cVar.w);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.p2b_fragment_post_detail_view, viewGroup, false);
        TextView textView = null;
        this.ag = inflate != null ? (LinearLayout) inflate.findViewById(R.id.slab_layout) : null;
        this.f13053h = inflate != null ? (ImageView) inflate.findViewById(R.id.cross_iv) : null;
        this.j = inflate != null ? (ConstraintLayout) inflate.findViewById(R.id.statusBannerCl) : null;
        this.k = inflate != null ? (TextView) inflate.findViewById(R.id.statusMsgTv) : null;
        this.l = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_success) : null;
        this.m = inflate != null ? (TextView) inflate.findViewById(R.id.toTv) : null;
        this.n = inflate != null ? (TextView) inflate.findViewById(R.id.tv_amount_details) : null;
        this.o = inflate != null ? (TextView) inflate.findViewById(R.id.amount_in_words_details) : null;
        this.p = inflate != null ? (ConstraintLayout) inflate.findViewById(R.id.successTxnDetailContainer) : null;
        this.B = inflate != null ? (ConstraintLayout) inflate.findViewById(R.id.pendingTxnDetailContainer) : null;
        this.q = inflate != null ? (ConstraintLayout) inflate.findViewById(R.id.failedTxnDetailContainer) : null;
        this.C = inflate != null ? (ConstraintLayout) inflate.findViewById(R.id.paymentDetailCL) : null;
        this.D = inflate != null ? (LinearLayout) inflate.findViewById(R.id.orderIdLl) : null;
        this.r = inflate != null ? (TextView) inflate.findViewById(R.id.tv_to_source) : null;
        this.s = inflate != null ? (TextView) inflate.findViewById(R.id.tv_declared_as_self) : null;
        this.t = inflate != null ? (TextView) inflate.findViewById(R.id.tv_amount_excluding_charge) : null;
        this.u = inflate != null ? (TextView) inflate.findViewById(R.id.paymentChargesTitleTv) : null;
        this.v = inflate != null ? (TextView) inflate.findViewById(R.id.tv_charge_payable) : null;
        this.w = inflate != null ? (TextView) inflate.findViewById(R.id.tv_total_paid) : null;
        this.x = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_info) : null;
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.y = inflate != null ? (TextView) inflate.findViewById(R.id.tv_wallet_txn_id) : null;
        this.z = inflate != null ? (TextView) inflate.findViewById(R.id.tv_bank_txn_id) : null;
        this.A = inflate != null ? (TextView) inflate.findViewById(R.id.tv_date_time) : null;
        this.F = inflate != null ? (ConstraintLayout) inflate.findViewById(R.id.SuccessBannerLargeCl) : null;
        this.G = inflate != null ? (TextView) inflate.findViewById(R.id.amountInWords2Tv) : null;
        this.H = inflate != null ? (TextView) inflate.findViewById(R.id.viewDetailTv) : null;
        TextView textView2 = this.H;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        this.E = inflate != null ? (LinearLayout) inflate.findViewById(R.id.ll_payment_details) : null;
        this.V = inflate != null ? (TextView) inflate.findViewById(R.id.amountTv1) : null;
        this.I = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_share) : null;
        ImageView imageView2 = this.I;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        this.J = inflate != null ? (TextView) inflate.findViewById(R.id.pendingTitleTv) : null;
        this.L = inflate != null ? (TextView) inflate.findViewById(R.id.failureSubTitleTv) : null;
        this.K = inflate != null ? (TextView) inflate.findViewById(R.id.failureTitleTv) : null;
        this.M = inflate != null ? (TextView) inflate.findViewById(R.id.tryAgainTv) : null;
        TextView textView3 = this.M;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        this.Y = inflate != null ? (LinearLayout) inflate.findViewById(R.id.ll_declared_as_self) : null;
        this.Z = inflate != null ? (P2bShimmerAnimationLayout) inflate.findViewById(R.id.status_shimmer_layout) : null;
        this.aa = inflate != null ? (Group) inflate.findViewById(R.id.gp_pending_progress) : null;
        this.ab = inflate != null ? (TextView) inflate.findViewById(R.id.textview1) : null;
        this.f13049d = inflate != null ? (TextView) inflate.findViewById(R.id.pollingTextMessage) : null;
        this.f13050e = inflate != null ? (ConstraintLayout) inflate.findViewById(R.id.polling_timer_container) : null;
        this.f13051f = inflate != null ? (ProgressBar) inflate.findViewById(R.id.timerProgressBar) : null;
        this.ac = inflate != null ? (TextView) inflate.findViewById(R.id.timerCountTextView) : null;
        this.ad = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_bank_icon) : null;
        this.ae = inflate != null ? (TextView) inflate.findViewById(R.id.pendingSubTitleTv) : null;
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(R.id.tv_amount_sent_to_bank);
        }
        this.af = textView;
        ImageView imageView3 = this.f13053h;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new b(this));
        }
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13056a;

        b(j jVar) {
            this.f13056a = jVar;
        }

        public final void onClick(View view) {
            j jVar = this.f13056a;
            jVar.startActivity(new Intent(jVar.getActivity(), SendMoneyToBankActivity.class));
            FragmentActivity activity = this.f13056a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        net.one97.paytm.p2b.e.c cVar;
        String str;
        Double d2;
        String str2;
        String str3;
        String str4;
        y<net.one97.paytm.p2b.data.a<CJRP2bCheckTxnStatus>> yVar;
        y<net.one97.paytm.p2b.data.a<CJRP2BStatus>> yVar2;
        y<IJRDataModel> yVar3;
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        String str5 = null;
        if (activity != null) {
            kotlin.g.b.k.a((Object) activity, "it");
            cVar = (net.one97.paytm.p2b.e.c) new al((ao) activity, (al.b) al.a.a(activity.getApplication())).a(net.one97.paytm.p2b.e.c.class);
        } else {
            cVar = null;
        }
        this.f13046a = cVar;
        net.one97.paytm.p2b.e.c cVar2 = this.f13046a;
        if (cVar2 != null) {
            str = cVar2.q;
        } else {
            str = null;
        }
        this.R = net.one97.paytm.p2b.d.k.a(str, getString(R.string.p2b_rupee_prefix));
        net.one97.paytm.p2b.e.c cVar3 = this.f13046a;
        if (cVar3 != null) {
            d2 = cVar3.o;
        } else {
            d2 = null;
        }
        this.S = net.one97.paytm.p2b.d.k.a(String.valueOf(d2), getString(R.string.p2b_rupee_prefix));
        net.one97.paytm.p2b.e.c cVar4 = this.f13046a;
        if (cVar4 != null) {
            str2 = cVar4.r;
        } else {
            str2 = null;
        }
        this.T = net.one97.paytm.p2b.d.k.a(str2, getString(R.string.p2b_rupee_prefix));
        int i2 = R.string.p2b_rupees_only;
        Object[] objArr = new Object[1];
        net.one97.paytm.p2b.e.c cVar5 = this.f13046a;
        if (cVar5 != null) {
            str3 = cVar5.q;
        } else {
            str3 = null;
        }
        objArr[0] = net.one97.paytm.p2b.d.k.c(str3);
        this.U = getString(i2, objArr);
        String string = getString(R.string.p2b_acc_number_initial, "");
        net.one97.paytm.p2b.e.c cVar6 = this.f13046a;
        if (cVar6 != null) {
            str4 = cVar6.n;
        } else {
            str4 = null;
        }
        net.one97.paytm.p2b.e.c cVar7 = this.f13046a;
        if (cVar7 != null) {
            str5 = cVar7.k;
        }
        this.X = net.one97.paytm.p2b.d.k.a(string, str4, str5);
        net.one97.paytm.p2b.e.c cVar8 = this.f13046a;
        if (!(cVar8 == null || (yVar3 = cVar8.f12792h) == null)) {
            yVar3.observe(getViewLifecycleOwner(), new c(this));
        }
        net.one97.paytm.p2b.e.c cVar9 = this.f13046a;
        if (!(cVar9 == null || (yVar2 = cVar9.f12789e) == null)) {
            yVar2.observe(getViewLifecycleOwner(), new d(this));
        }
        net.one97.paytm.p2b.e.c cVar10 = this.f13046a;
        if (cVar10 != null && (yVar = cVar10.f12790f) != null) {
            yVar.observe(getViewLifecycleOwner(), new e(this));
        }
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.p2b.d.j) {
            this.W = (net.one97.paytm.p2b.d.j) context;
        }
        net.one97.paytm.p2b.d.j jVar = this.W;
        if (jVar != null) {
            jVar.a((net.one97.paytm.p2b.b.f) this);
        }
    }

    static final class h implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13068a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f13069b;

        h(j jVar, BottomSheetBehavior bottomSheetBehavior) {
            this.f13068a = jVar;
            this.f13069b = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f13069b.setState(4);
            net.one97.paytm.p2b.d.k.a((Activity) this.f13068a.getActivity());
        }
    }

    public static final class i extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f13070a;

        public final void onStateChanged(View view, int i2) {
            kotlin.g.b.k.c(view, "bottomSheet");
        }

        i(com.google.android.material.bottomsheet.a aVar) {
            this.f13070a = aVar;
        }

        public final void onSlide(View view, float f2) {
            kotlin.g.b.k.c(view, "bottomSheet");
            com.google.android.material.bottomsheet.a aVar = this.f13070a;
            if (aVar != null) {
                aVar.cancel();
            }
        }
    }

    /* renamed from: net.one97.paytm.p2b.view.c.j$j  reason: collision with other inner class name */
    static final class C0175j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f13071a;

        C0175j(com.google.android.material.bottomsheet.a aVar) {
            this.f13071a = aVar;
        }

        public final void onClick(View view) {
            this.f13071a.cancel();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f13072a;

        k(com.google.android.material.bottomsheet.a aVar) {
            this.f13072a = aVar;
        }

        public final void onClick(View view) {
            this.f13072a.cancel();
        }
    }

    public static final class l extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13073a;

        l(j jVar) {
            this.f13073a = jVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "widget");
            j jVar = this.f13073a;
            h.a aVar = net.one97.paytm.p2b.d.h.f12718a;
            jVar.startActivity(net.one97.paytm.p2b.d.h.b(h.a.a()).b((Context) this.f13073a.getActivity()));
            FragmentActivity activity = this.f13073a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f13073a.getResources().getColor(R.color.p2b_blue));
            textPaint.setUnderlineText(false);
        }
    }

    public static final class e implements z<net.one97.paytm.p2b.data.a<CJRP2bCheckTxnStatus>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13059a;

        e(j jVar) {
            this.f13059a = jVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: net.one97.paytm.P2B.CJRP2bCheckTxnStatus} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.paytm.network.model.NetworkCustomError] */
        /* JADX WARNING: type inference failed for: r0v6 */
        /* JADX WARNING: type inference failed for: r0v7 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                net.one97.paytm.p2b.data.a r4 = (net.one97.paytm.p2b.data.a) r4
                r0 = 0
                if (r4 == 0) goto L_0x0008
                net.one97.paytm.p2b.data.b r1 = r4.f12729a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.p2b.view.c.k.f13078b
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 1
                if (r1 == r2) goto L_0x0025
                r2 = 2
                if (r1 == r2) goto L_0x001b
                goto L_0x0024
            L_0x001b:
                net.one97.paytm.p2b.view.c.j r1 = r3.f13059a
                if (r4 == 0) goto L_0x0021
                com.paytm.network.model.NetworkCustomError r0 = r4.f12731c
            L_0x0021:
                net.one97.paytm.p2b.view.c.j.b(r1, r0)
            L_0x0024:
                return
            L_0x0025:
                net.one97.paytm.p2b.view.c.j r1 = r3.f13059a
                if (r4 == 0) goto L_0x002e
                ResultType r4 = r4.f12730b
                r0 = r4
                net.one97.paytm.P2B.CJRP2bCheckTxnStatus r0 = (net.one97.paytm.P2B.CJRP2bCheckTxnStatus) r0
            L_0x002e:
                net.one97.paytm.p2b.view.c.j.a((net.one97.paytm.p2b.view.c.j) r1, (net.one97.paytm.P2B.CJRP2bCheckTxnStatus) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.j.e.onChanged(java.lang.Object):void");
        }
    }

    private final void a(String str) {
        String string = getString(R.string.p2b_error_title);
        kotlin.g.b.k.a((Object) string, "getString(R.string.p2b_error_title)");
        String string2 = getString(R.string.p2b_default_error);
        if (TextUtils.isEmpty(str)) {
            str = string2;
        }
        com.paytm.utility.h hVar = new com.paytm.utility.h(getContext());
        hVar.setTitle(string);
        hVar.a(str);
        hVar.a(-1, getString(R.string.p2b_ok), new g(hVar));
        hVar.show();
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f13067a;

        g(com.paytm.utility.h hVar) {
            this.f13067a = hVar;
        }

        public final void onClick(View view) {
            this.f13067a.dismiss();
        }
    }

    private final void b() {
        P2bShimmerAnimationLayout p2bShimmerAnimationLayout;
        net.one97.paytm.p2b.d.j jVar = this.W;
        if (jVar != null) {
            jVar.a(false, false);
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ConstraintLayout constraintLayout = this.F;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        Context context = getContext();
        if (!(context == null || (p2bShimmerAnimationLayout = this.Z) == null)) {
            p2bShimmerAnimationLayout.setBackgroundColor(androidx.core.content.b.c(context, R.color.p2b_status_green));
        }
        TextView textView = this.V;
        if (textView != null) {
            textView.setText(this.R);
        }
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setText(this.U);
        }
        net.one97.paytm.p2b.d.j jVar2 = this.W;
        if (jVar2 != null) {
            jVar2.a(Boolean.FALSE);
        }
        P2bShimmerAnimationLayout p2bShimmerAnimationLayout2 = this.Z;
        if (p2bShimmerAnimationLayout2 != null) {
            p2bShimmerAnimationLayout2.a();
        }
        Group group = this.aa;
        if (group != null) {
            group.setVisibility(0);
        }
        net.one97.paytm.p2b.d.j jVar3 = this.W;
        if (jVar3 != null) {
            jVar3.a(false);
        }
        TextView textView3 = this.ab;
        if (textView3 != null) {
            textView3.setText(getString(R.string.p2b_money_sen_sucessfully));
        }
    }

    public static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13074a;

        m(j jVar) {
            this.f13074a = jVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
            r1 = (r1 = (r1 = r1.f12790f).getValue()).f12729a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                net.one97.paytm.p2b.view.c.j r0 = r5.f13074a
                androidx.fragment.app.FragmentActivity r1 = r0.getActivity()
                if (r1 == 0) goto L_0x0067
                boolean r1 = r0.f13047b
                if (r1 != 0) goto L_0x0067
                net.one97.paytm.p2b.e.c r1 = r0.f13046a
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x0028
                androidx.lifecycle.y<net.one97.paytm.p2b.data.a<net.one97.paytm.P2B.CJRP2bCheckTxnStatus>> r1 = r1.f12790f
                if (r1 == 0) goto L_0x0028
                java.lang.Object r1 = r1.getValue()
                net.one97.paytm.p2b.data.a r1 = (net.one97.paytm.p2b.data.a) r1
                if (r1 == 0) goto L_0x0028
                net.one97.paytm.p2b.data.b r1 = r1.f12729a
                if (r1 == 0) goto L_0x0028
                net.one97.paytm.p2b.data.b r4 = net.one97.paytm.p2b.data.b.LOADING
                if (r1 != r4) goto L_0x0028
                r1 = 1
                goto L_0x0029
            L_0x0028:
                r1 = 0
            L_0x0029:
                if (r1 == 0) goto L_0x0067
                r0.f13047b = r2
                androidx.constraintlayout.widget.ConstraintLayout r1 = r0.f13050e
                if (r1 == 0) goto L_0x0034
                r1.setVisibility(r3)
            L_0x0034:
                int r1 = r0.f13048c
                androidx.fragment.app.FragmentActivity r2 = r0.getActivity()
                if (r2 == 0) goto L_0x0067
                android.widget.ProgressBar r2 = r0.f13051f
                if (r2 == 0) goto L_0x0043
                r2.setMax(r1)
            L_0x0043:
                androidx.fragment.app.FragmentActivity r2 = r0.getActivity()
                if (r2 == 0) goto L_0x0058
                android.widget.TextView r2 = r0.f13049d
                if (r2 == 0) goto L_0x0058
                int r3 = net.one97.paytm.p2b.R.string.p2b_polling_payment_request_text
                java.lang.String r3 = r0.getString(r3)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.setText(r3)
            L_0x0058:
                java.lang.Thread r2 = new java.lang.Thread
                net.one97.paytm.p2b.view.c.j$f r3 = new net.one97.paytm.p2b.view.c.j$f
                r3.<init>(r0, r1)
                java.lang.Runnable r3 = (java.lang.Runnable) r3
                r2.<init>(r3)
                r2.start()
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.j.m.run():void");
        }
    }

    public static final class a implements a.C0169a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13055a;

        a(j jVar) {
            this.f13055a = jVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            net.one97.paytm.p2b.e.c cVar;
            String str;
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                h.a aVar = net.one97.paytm.p2b.d.h.f12718a;
                String a2 = net.one97.paytm.p2b.d.h.b(h.a.a()).a((CJRPGTokenList) iJRPaytmDataModel);
                if (!TextUtils.isEmpty(a2) && (cVar = this.f13055a.f13046a) != null) {
                    net.one97.paytm.p2b.e.c cVar2 = this.f13055a.f13046a;
                    if (cVar2 != null) {
                        str = cVar2.t;
                    } else {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        y<net.one97.paytm.p2b.data.a<CJRP2bCheckTxnStatus>> yVar = cVar.f12790f;
                        a.C0168a aVar2 = net.one97.paytm.p2b.data.a.f12728d;
                        yVar.setValue(a.C0168a.a((NetworkCustomError) null));
                        return;
                    }
                    y<net.one97.paytm.p2b.data.a<CJRP2bCheckTxnStatus>> yVar2 = cVar.f12790f;
                    a.C0168a aVar3 = net.one97.paytm.p2b.data.a.f12728d;
                    yVar2.setValue(a.C0168a.a());
                    net.one97.paytm.p2b.data.a.b bVar = cVar.f12785a;
                    if (bVar != null) {
                        bVar.a();
                    }
                    net.one97.paytm.p2b.data.a.b bVar2 = cVar.f12785a;
                    if (bVar2 != null) {
                        bVar2.a(str, a2, cVar.w, (a.C0169a) new c.e(cVar));
                    }
                }
            }
        }

        public final void a(NetworkCustomError networkCustomError) {
            y<net.one97.paytm.p2b.data.a<CJRP2bCheckTxnStatus>> yVar;
            net.one97.paytm.p2b.e.c cVar = this.f13055a.f13046a;
            if (cVar != null && (yVar = cVar.f12790f) != null) {
                a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
                yVar.setValue(a.C0168a.a(networkCustomError));
            }
        }
    }

    private final void c() {
        String str;
        ConstraintLayout constraintLayout = this.j;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(Color.parseColor("#fd5c5c"));
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(getString(R.string.p2b_money_sent_failure));
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.C;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        ConstraintLayout constraintLayout3 = this.F;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(8);
        }
        ConstraintLayout constraintLayout4 = this.p;
        if (constraintLayout4 != null) {
            constraintLayout4.setVisibility(8);
        }
        ConstraintLayout constraintLayout5 = this.B;
        if (constraintLayout5 != null) {
            constraintLayout5.setVisibility(8);
        }
        ConstraintLayout constraintLayout6 = this.q;
        if (constraintLayout6 != null) {
            constraintLayout6.setVisibility(0);
        }
        net.one97.paytm.p2b.d.j jVar = this.W;
        if (jVar != null) {
            jVar.a(true, false);
        }
        e();
        net.one97.paytm.p2b.e.c cVar = this.f13046a;
        String str2 = null;
        if (cVar != null) {
            str = cVar.n;
        } else {
            str = null;
        }
        if (!net.one97.paytm.p2b.d.k.d(str)) {
            TextView textView2 = this.K;
            if (textView2 != null) {
                int i2 = R.string.p2b_request_declined_by_bank;
                Object[] objArr = new Object[1];
                net.one97.paytm.p2b.e.c cVar2 = this.f13046a;
                if (cVar2 != null) {
                    str2 = cVar2.n;
                }
                objArr[0] = str2;
                textView2.setText(getString(i2, objArr));
            }
        } else {
            TextView textView3 = this.K;
            if (textView3 != null) {
                textView3.setText(getString(R.string.p2b_request_declined));
            }
        }
        TextView textView4 = this.L;
        if (textView4 != null) {
            textView4.setText(this.P);
        }
        net.one97.paytm.p2b.d.j jVar2 = this.W;
        if (jVar2 != null) {
            jVar2.a(Boolean.FALSE);
        }
        net.one97.paytm.p2b.d.j jVar3 = this.W;
        if (jVar3 != null) {
            jVar3.a(false);
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        String str;
        String str2;
        ConstraintLayout constraintLayout = this.j;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(Color.parseColor("#ffa000"));
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(getString(R.string.p2b_money_sent_pending));
        }
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.C;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        ConstraintLayout constraintLayout3 = this.F;
        if (constraintLayout3 != null) {
            constraintLayout3.setVisibility(8);
        }
        ConstraintLayout constraintLayout4 = this.p;
        if (constraintLayout4 != null) {
            constraintLayout4.setVisibility(8);
        }
        ConstraintLayout constraintLayout5 = this.B;
        if (constraintLayout5 != null) {
            constraintLayout5.setVisibility(0);
        }
        ConstraintLayout constraintLayout6 = this.q;
        if (constraintLayout6 != null) {
            constraintLayout6.setVisibility(8);
        }
        net.one97.paytm.p2b.d.j jVar = this.W;
        if (jVar != null) {
            jVar.a(true, false);
        }
        e();
        net.one97.paytm.p2b.e.c cVar = this.f13046a;
        String str3 = null;
        if (cVar != null) {
            str = cVar.n;
        } else {
            str = null;
        }
        if (!net.one97.paytm.p2b.d.k.d(str)) {
            TextView textView2 = this.J;
            if (textView2 != null) {
                int i2 = R.string.p2b_confirmation_pending_from_bank;
                Object[] objArr = new Object[1];
                net.one97.paytm.p2b.e.c cVar2 = this.f13046a;
                if (cVar2 != null) {
                    str2 = cVar2.n;
                } else {
                    str2 = null;
                }
                objArr[0] = str2;
                textView2.setText(getString(i2, objArr));
            }
        } else {
            TextView textView3 = this.J;
            if (textView3 != null) {
                textView3.setText(getString(R.string.p2b_confirmation_pending_from_bank, getString(R.string.p2b_default_bank_txt)));
            }
        }
        net.one97.paytm.p2b.d.j jVar2 = this.W;
        if (jVar2 != null) {
            jVar2.a(Boolean.FALSE);
        }
        net.one97.paytm.p2b.d.j jVar3 = this.W;
        if (jVar3 != null) {
            jVar3.a(false);
        }
        net.one97.paytm.p2b.e.c cVar3 = this.f13046a;
        if (cVar3 != null) {
            str3 = cVar3.v;
        }
        net.one97.paytm.p2b.d.k.a(getContext(), this.ad, str3);
        TextView textView4 = this.ae;
        if (textView4 != null) {
            textView4.setText(getString(R.string.p2b_pending_message, this.T));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0111 A[LOOP:0: B:12:0x002d->B:48:0x0111, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0116 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.common.entity.wallet.P2BCommissionMetaObject r20) {
        /*
            r19 = this;
            r0 = r19
            java.util.List r1 = r20.getFeeDetailsBreakupList()
            android.view.View r2 = r19.getView()
            if (r2 == 0) goto L_0x0116
            android.view.View r2 = r19.getView()
            r3 = 0
            if (r2 == 0) goto L_0x001c
            int r4 = net.one97.paytm.p2b.R.id.slab_layout
            android.view.View r2 = r2.findViewById(r4)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            if (r2 == 0) goto L_0x0022
            r2.removeAllViews()
        L_0x0022:
            if (r1 == 0) goto L_0x0116
            int r4 = r1.size()
            int r5 = r4 + -1
            if (r5 < 0) goto L_0x0116
            r7 = 0
        L_0x002d:
            java.lang.Object r8 = r1.get(r7)
            net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList r8 = (net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList) r8
            if (r8 != 0) goto L_0x0036
            return
        L_0x0036:
            android.content.Context r9 = r19.getContext()
            int r10 = net.one97.paytm.p2b.R.layout.p2b_amount_row
            android.view.View r9 = android.widget.LinearLayout.inflate(r9, r10, r3)
            if (r9 == 0) goto L_0x004b
            int r10 = net.one97.paytm.p2b.R.id.tv_fee_item_label_item
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            goto L_0x004c
        L_0x004b:
            r10 = r3
        L_0x004c:
            if (r9 == 0) goto L_0x0057
            int r11 = net.one97.paytm.p2b.R.id.iv_info_icon_item
            android.view.View r11 = r9.findViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            goto L_0x0058
        L_0x0057:
            r11 = r3
        L_0x0058:
            if (r9 == 0) goto L_0x0063
            int r12 = net.one97.paytm.p2b.R.id.tv_fee_item
            android.view.View r12 = r9.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            goto L_0x0064
        L_0x0063:
            r12 = r3
        L_0x0064:
            if (r7 != 0) goto L_0x008b
            java.lang.Double r13 = r8.getSlabFeePercentage()
            double r13 = r13.doubleValue()
            r16 = r7
            r6 = 0
            int r6 = java.lang.Double.compare(r13, r6)
            if (r6 != 0) goto L_0x0079
            goto L_0x008d
        L_0x0079:
            if (r11 == 0) goto L_0x0088
            net.one97.paytm.p2b.view.c.j$n r6 = new net.one97.paytm.p2b.view.c.j$n
            r7 = r20
            r6.<init>(r0, r7)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r11.setOnClickListener(r6)
            goto L_0x0096
        L_0x0088:
            r7 = r20
            goto L_0x0096
        L_0x008b:
            r16 = r7
        L_0x008d:
            r7 = r20
            if (r11 == 0) goto L_0x0096
            r6 = 8
            r11.setVisibility(r6)
        L_0x0096:
            r6 = 1
            if (r4 <= r6) goto L_0x00c7
            if (r10 == 0) goto L_0x00e6
            int r11 = net.one97.paytm.p2b.R.string.p2b_fee_with_interest_slab
            r13 = 2
            java.lang.Object[] r13 = new java.lang.Object[r13]
            java.lang.Double r14 = r8.getSlabTxnAmount()
            double r17 = r14.doubleValue()
            java.lang.String r14 = java.lang.String.valueOf(r17)
            r15 = 0
            r13[r15] = r14
            java.lang.Double r14 = r8.getSlabFeePercentage()
            double r17 = r14.doubleValue()
            java.lang.String r14 = java.lang.String.valueOf(r17)
            r13[r6] = r14
            java.lang.String r6 = r0.getString(r11, r13)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r10.setText(r6)
            goto L_0x00e6
        L_0x00c7:
            if (r10 == 0) goto L_0x00e6
            int r11 = net.one97.paytm.p2b.R.string.p2b_fee_with_interest_new
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Double r13 = r8.getSlabFeePercentage()
            double r13 = r13.doubleValue()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r14 = 0
            r6[r14] = r13
            java.lang.String r6 = r0.getString(r11, r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r10.setText(r6)
            goto L_0x00e7
        L_0x00e6:
            r14 = 0
        L_0x00e7:
            if (r12 == 0) goto L_0x0108
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.Double r8 = r8.getSlabFeeAmount()
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            int r8 = net.one97.paytm.p2b.R.string.p2b_rupee_prefix
            java.lang.String r8 = r0.getString(r8)
            java.lang.String r6 = net.one97.paytm.p2b.d.k.a((java.lang.String) r6, (java.lang.String) r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
        L_0x0108:
            if (r2 == 0) goto L_0x010d
            r2.addView(r9)
        L_0x010d:
            r6 = r16
            if (r6 == r5) goto L_0x0116
            int r6 = r6 + 1
            r7 = r6
            goto L_0x002d
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.j.a(net.one97.paytm.common.entity.wallet.P2BCommissionMetaObject):void");
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13075a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ P2BCommissionMetaObject f13076b;

        n(j jVar, P2BCommissionMetaObject p2BCommissionMetaObject) {
            this.f13075a = jVar;
            this.f13076b = p2BCommissionMetaObject;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
            r1 = r1.m;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r12) {
            /*
                r11 = this;
                net.one97.paytm.p2b.view.c.j r12 = r11.f13075a
                net.one97.paytm.common.entity.wallet.P2BCommissionMetaObject r0 = r11.f13076b
                java.util.List r0 = r0.getFeeDetailsBreakupList()
                java.lang.String r1 = "p2BCommissionMetaObject.feeDetailsBreakupList"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.lang.String r1 = "feeDetailsBreakupLists"
                kotlin.g.b.k.c(r0, r1)
                net.one97.paytm.p2b.e.c r1 = r12.f13046a
                r2 = 0
                if (r1 == 0) goto L_0x0026
                java.lang.Double r1 = r1.m
                if (r1 == 0) goto L_0x0026
                java.lang.Number r1 = (java.lang.Number) r1
                double r3 = r1.doubleValue()
                java.lang.String r1 = net.one97.paytm.p2b.d.k.a((double) r3)
                goto L_0x0027
            L_0x0026:
                r1 = r2
            L_0x0027:
                androidx.fragment.app.FragmentActivity r3 = r12.getActivity()
                android.app.Activity r3 = (android.app.Activity) r3
                net.one97.paytm.p2b.d.k.a((android.app.Activity) r3)
                android.view.LayoutInflater r3 = r12.getLayoutInflater()
                int r4 = net.one97.paytm.p2b.R.layout.p2b_informatory_popup
                android.view.View r3 = r3.inflate(r4, r2)
                android.content.Context r4 = r12.getContext()
                if (r4 == 0) goto L_0x0048
                com.google.android.material.bottomsheet.a r5 = new com.google.android.material.bottomsheet.a
                int r6 = net.one97.paytm.p2b.R.style.p2bAppBottomSheetDialogTheme
                r5.<init>(r4, r6)
                goto L_0x0049
            L_0x0048:
                r5 = r2
            L_0x0049:
                if (r5 == 0) goto L_0x004e
                r5.setContentView((android.view.View) r3)
            L_0x004e:
                java.lang.String r4 = "bottomSheetView"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                android.view.ViewParent r4 = r3.getParent()
                if (r4 == 0) goto L_0x0194
                android.view.View r4 = (android.view.View) r4
                com.google.android.material.bottomsheet.BottomSheetBehavior r4 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r4)
                java.lang.String r6 = "BottomSheetBehavior.from…SheetView.parent as View)"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
                if (r5 == 0) goto L_0x0070
                net.one97.paytm.p2b.view.c.j$h r6 = new net.one97.paytm.p2b.view.c.j$h
                r6.<init>(r12, r4)
                android.content.DialogInterface$OnDismissListener r6 = (android.content.DialogInterface.OnDismissListener) r6
                r5.setOnDismissListener(r6)
            L_0x0070:
                net.one97.paytm.p2b.view.c.j$i r6 = new net.one97.paytm.p2b.view.c.j$i
                r6.<init>(r5)
                com.google.android.material.bottomsheet.BottomSheetBehavior$a r6 = (com.google.android.material.bottomsheet.BottomSheetBehavior.a) r6
                r4.setBottomSheetCallback(r6)
                r6 = 2
                r4.setState(r6)
                androidx.fragment.app.FragmentActivity r6 = r12.getActivity()
                android.app.Activity r6 = (android.app.Activity) r6
                int r6 = com.paytm.utility.b.b((android.app.Activity) r6)
                r4.setPeekHeight(r6)
                if (r5 == 0) goto L_0x0091
                android.view.Window r2 = r5.getWindow()
            L_0x0091:
                if (r2 != 0) goto L_0x0096
                kotlin.g.b.k.a()
            L_0x0096:
                r4 = 16
                r2.setSoftInputMode(r4)
                if (r5 == 0) goto L_0x00a0
                r5.show()
            L_0x00a0:
                int r2 = net.one97.paytm.p2b.R.id.iv_cross
                android.view.View r2 = r3.findViewById(r2)
                net.one97.paytm.p2b.view.c.j$j r4 = new net.one97.paytm.p2b.view.c.j$j
                r4.<init>(r5)
                android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
                r2.setOnClickListener(r4)
                int r2 = net.one97.paytm.p2b.R.id.tv_i_understand
                android.view.View r2 = r3.findViewById(r2)
                net.one97.paytm.p2b.view.c.j$k r4 = new net.one97.paytm.p2b.view.c.j$k
                r4.<init>(r5)
                android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
                r2.setOnClickListener(r4)
                int r2 = net.one97.paytm.p2b.R.id.tv_title
                android.view.View r2 = r3.findViewById(r2)
                android.widget.TextView r2 = (android.widget.TextView) r2
                int r4 = net.one97.paytm.p2b.R.id.tv_info_via_money_transfer
                android.view.View r4 = r3.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                int r5 = net.one97.paytm.p2b.R.id.tv_pop_up_text
                android.view.View r5 = r3.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                int r6 = net.one97.paytm.p2b.R.id.tv_rbi_guideline
                android.view.View r6 = r3.findViewById(r6)
                android.widget.TextView r6 = (android.widget.TextView) r6
                int r7 = net.one97.paytm.p2b.R.id.iv_transfer_flow
                android.view.View r3 = r3.findViewById(r7)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                int r7 = r0.size()
                java.lang.String r8 = "tvRbiGuideline"
                r9 = 1
                r10 = 0
                if (r7 <= r9) goto L_0x010e
                int r1 = net.one97.paytm.p2b.R.string.p2b_slab_heading
                java.lang.String r1 = r12.getString(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2.setText(r1)
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
                android.content.Context r1 = r12.getContext()
                java.lang.String r0 = net.one97.paytm.p2b.d.k.a((android.content.Context) r1, (java.util.List<net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList>) r0)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r6.setText(r0)
                goto L_0x012c
            L_0x010e:
                int r0 = net.one97.paytm.p2b.R.string.p2b_interest_charge
                java.lang.Object[] r7 = new java.lang.Object[r9]
                r7[r10] = r1
                java.lang.String r0 = r12.getString(r0, r7)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r2.setText(r0)
                int r0 = net.one97.paytm.p2b.R.string.p2b_rbi_guideline
                java.lang.Object[] r2 = new java.lang.Object[r9]
                r2[r10] = r1
                java.lang.String r0 = r12.getString(r0, r2)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r6.setText(r0)
            L_0x012c:
                java.lang.String r0 = "tvPopUpText"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
                r0 = 8
                r5.setVisibility(r0)
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
                r6.setVisibility(r10)
                java.lang.String r0 = "tvInformatortoryMoneyTransfer"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
                r4.setVisibility(r10)
                java.lang.String r0 = "ivHowItWork"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                r3.setVisibility(r10)
                int r0 = net.one97.paytm.p2b.R.string.p2b_recommend_via_money_transfer     // Catch:{ Exception -> 0x0193 }
                java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x0193 }
                java.lang.String r1 = "getString(R.string.p2b_r…mmend_via_money_transfer)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0193 }
                android.text.SpannableString r1 = new android.text.SpannableString     // Catch:{ Exception -> 0x0193 }
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0193 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0193 }
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0193 }
                int r2 = net.one97.paytm.p2b.R.string.p2b_money_transfer     // Catch:{ Exception -> 0x0193 }
                java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x0193 }
                java.lang.String r3 = "getString(R.string.p2b_money_transfer)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0193 }
                r3 = 6
                int r0 = kotlin.m.p.a((java.lang.CharSequence) r0, (java.lang.String) r2, (int) r10, (boolean) r10, (int) r3)     // Catch:{ Exception -> 0x0193 }
                if (r0 <= 0) goto L_0x018e
                net.one97.paytm.p2b.view.c.j$l r2 = new net.one97.paytm.p2b.view.c.j$l     // Catch:{ Exception -> 0x0193 }
                r2.<init>(r12)     // Catch:{ Exception -> 0x0193 }
                int r3 = net.one97.paytm.p2b.R.string.p2b_recommend_via_money_transfer     // Catch:{ Exception -> 0x0193 }
                java.lang.String r12 = r12.getString(r3)     // Catch:{ Exception -> 0x0193 }
                int r12 = r12.length()     // Catch:{ Exception -> 0x0193 }
                r3 = 33
                r1.setSpan(r2, r0, r12, r3)     // Catch:{ Exception -> 0x0193 }
                android.text.method.MovementMethod r12 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x0193 }
                r4.setMovementMethod(r12)     // Catch:{ Exception -> 0x0193 }
            L_0x018e:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0193 }
                r4.setText(r1)     // Catch:{ Exception -> 0x0193 }
            L_0x0193:
                return
            L_0x0194:
                kotlin.u r12 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.view.View"
                r12.<init>(r0)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.j.n.onClick(android.view.View):void");
        }
    }

    private final void e() {
        String str;
        String str2;
        Boolean bool;
        CJRP2BStatus cJRP2BStatus;
        CJRP2BStatusResponse response;
        P2BCommissionMetaObject p2BCommissionMetaObject;
        String str3;
        TextView textView = this.m;
        String str4 = null;
        if (textView != null) {
            int i2 = R.string.p2b_to_name;
            Object[] objArr = new Object[1];
            net.one97.paytm.p2b.e.c cVar = this.f13046a;
            if (cVar != null) {
                str3 = cVar.f12793i;
            } else {
                str3 = null;
            }
            objArr[0] = str3;
            textView.setText(getString(i2, objArr));
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(this.R);
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setText(this.X);
        }
        TextView textView4 = this.o;
        if (textView4 != null) {
            textView4.setText(this.U);
        }
        TextView textView5 = this.t;
        if (textView5 != null) {
            textView5.setText(this.R);
        }
        TextView textView6 = this.w;
        if (textView6 != null) {
            textView6.setText(this.T);
        }
        net.one97.paytm.p2b.e.c cVar2 = this.f13046a;
        if (!(cVar2 == null || (cJRP2BStatus = cVar2.p) == null || (response = cJRP2BStatus.getResponse()) == null || (p2BCommissionMetaObject = response.getP2BCommissionMetaObject()) == null)) {
            a(p2BCommissionMetaObject);
        }
        if (!TextUtils.isEmpty(this.N)) {
            TextView textView7 = this.y;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            TextView textView8 = this.y;
            if (textView8 != null) {
                textView8.setText(getString(R.string.p2b_wallet_tran_id, this.N));
            }
        } else {
            TextView textView9 = this.y;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(this.O)) {
            TextView textView10 = this.z;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            TextView textView11 = this.z;
            if (textView11 != null) {
                textView11.setText(getString(R.string.p2b_bank_txn_id, this.O));
            }
        } else {
            TextView textView12 = this.z;
            if (textView12 != null) {
                textView12.setVisibility(8);
            }
        }
        net.one97.paytm.p2b.e.c cVar3 = this.f13046a;
        if (!(cVar3 == null || (bool = cVar3.s) == null)) {
            if (bool.booleanValue()) {
                LinearLayout linearLayout = this.Y;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                LinearLayout linearLayout2 = this.Y;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
            }
        }
        net.one97.paytm.p2b.e.c cVar4 = this.f13046a;
        if (cVar4 != null) {
            str = cVar4.n;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            TextView textView13 = this.af;
            if (textView13 != null) {
                int i3 = R.string.p2b_amount_sent_to_bank;
                Object[] objArr2 = new Object[1];
                net.one97.paytm.p2b.e.c cVar5 = this.f13046a;
                if (cVar5 != null) {
                    str2 = cVar5.n;
                } else {
                    str2 = null;
                }
                objArr2[0] = str2;
                textView13.setText(getString(i3, objArr2));
            }
        } else {
            TextView textView14 = this.af;
            if (textView14 != null) {
                textView14.setText(getString(R.string.p2b_amount_sent_to_bank, getString(R.string.p2b_default_bank_txt)));
            }
        }
        TextView textView15 = this.A;
        net.one97.paytm.p2b.e.c cVar6 = this.f13046a;
        if (cVar6 != null) {
            str4 = cVar6.l;
        }
        a(textView15, str4);
    }

    private static void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (textView != null) {
                textView.setText(com.paytm.utility.b.g(str, "yyyy-MM-dd HH:mm:ss", "hh:mm a, dd MMM yyyy"));
            }
        } else if (textView != null) {
            textView.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
        }
    }

    private final void f() {
        Dialog dialog;
        if (getActivity() != null) {
            try {
                if (this.f13054i != null) {
                    Dialog dialog2 = this.f13054i;
                    Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (valueOf.booleanValue() && (dialog = this.f13054i) != null) {
                        dialog.dismiss();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13060a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f13061b;

        f(j jVar, int i2) {
            this.f13060a = jVar;
            this.f13061b = i2;
        }

        public final void run() {
            j jVar = this.f13060a;
            x.c cVar = new x.c();
            cVar.element = this.f13061b;
            while (cVar.element > 0 && jVar.f13047b) {
                jVar.f13052g.post(new a(jVar, cVar, this));
                cVar.element--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException unused) {
                }
            }
            if (jVar.f13047b) {
                jVar.f13052g.post(new b(jVar, this));
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j f13062a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.c f13063b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ f f13064c;

            a(j jVar, x.c cVar, f fVar) {
                this.f13062a = jVar;
                this.f13063b = cVar;
                this.f13064c = fVar;
            }

            public final void run() {
                j jVar = this.f13062a;
                FragmentActivity activity = jVar.getActivity();
                if (activity != null) {
                    kotlin.g.b.k.a((Object) activity, "it");
                    if (!activity.isFinishing() && !activity.isDestroyed() && this.f13064c.f13060a.isAdded()) {
                        ProgressBar c2 = jVar.f13051f;
                        if (c2 != null) {
                            c2.setProgress(this.f13064c.f13061b - this.f13063b.element);
                        }
                        TextView d2 = jVar.ac;
                        if (d2 != null) {
                            d2.setText(String.valueOf(this.f13063b.element));
                        }
                    }
                }
            }
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j f13065a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ f f13066b;

            b(j jVar, f fVar) {
                this.f13065a = jVar;
                this.f13066b = fVar;
            }

            public final void run() {
                j jVar = this.f13065a;
                FragmentActivity activity = jVar.getActivity();
                if (activity != null) {
                    kotlin.g.b.k.a((Object) activity, "it");
                    if (!activity.isFinishing() && !activity.isDestroyed() && this.f13066b.f13060a.isAdded()) {
                        jVar.d();
                        net.one97.paytm.p2b.e.c cVar = jVar.f13046a;
                        if (cVar != null) {
                            cVar.a();
                        }
                    }
                }
            }
        }
    }

    public static final /* synthetic */ void a(j jVar, IJRDataModel iJRDataModel) {
        String str;
        y<net.one97.paytm.p2b.data.a<CJRP2bCheckTxnStatus>> yVar;
        P2bShimmerAnimationLayout p2bShimmerAnimationLayout;
        if (iJRDataModel != null) {
            if (iJRDataModel instanceof CJRSendMoney) {
                CJRSendMoney cJRSendMoney = (CJRSendMoney) iJRDataModel;
                CJRSendMoneyResponse response = cJRSendMoney.getResponse();
                jVar.P = cJRSendMoney.getStatusMessage();
                jVar.Q = cJRSendMoney.getStatus();
                if (response != null) {
                    jVar.N = response.getwalletSysTransactionID();
                    jVar.O = response.getBankTransactionId();
                }
            } else if (iJRDataModel instanceof CJRValidateTransaction) {
                CJRValidateTransaction cJRValidateTransaction = (CJRValidateTransaction) iJRDataModel;
                CJRSendMoneyResponse response2 = cJRValidateTransaction.getResponse();
                jVar.P = cJRValidateTransaction.getStatusMessage();
                jVar.Q = cJRValidateTransaction.getStatus();
                if (response2 != null) {
                    jVar.N = response2.getwalletSysTransactionID();
                    jVar.O = response2.getBankTransactionId();
                }
            }
            net.one97.paytm.p2b.e.c cVar = jVar.f13046a;
            if (cVar != null) {
                cVar.t = jVar.N;
            }
            net.one97.paytm.p2b.e.c cVar2 = jVar.f13046a;
            if (cVar2 != null) {
                cVar2.u = jVar.O;
            }
            jVar.d();
            if (TextUtils.isEmpty(jVar.Q)) {
                return;
            }
            if (p.a(jVar.Q, "PENDING", false)) {
                if (!TextUtils.isEmpty(jVar.N)) {
                    net.one97.paytm.p2b.d.j jVar2 = jVar.W;
                    if (jVar2 != null) {
                        jVar2.a(false, false);
                    }
                    LinearLayout linearLayout = jVar.E;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    ConstraintLayout constraintLayout = jVar.F;
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                    }
                    Context context = jVar.getContext();
                    if (!(context == null || (p2bShimmerAnimationLayout = jVar.Z) == null)) {
                        p2bShimmerAnimationLayout.setBackgroundColor(androidx.core.content.b.c(context, R.color.p2b_color_ffa400));
                    }
                    P2bShimmerAnimationLayout p2bShimmerAnimationLayout2 = jVar.Z;
                    if (p2bShimmerAnimationLayout2 != null) {
                        View view = p2bShimmerAnimationLayout2.f12881a;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        View view2 = p2bShimmerAnimationLayout2.f12881a;
                        if (view2 != null) {
                            view2.startAnimation(p2bShimmerAnimationLayout2.f12882b);
                        }
                    }
                    TextView textView = jVar.V;
                    if (textView != null) {
                        textView.setText(jVar.R);
                    }
                    TextView textView2 = jVar.G;
                    if (textView2 != null) {
                        textView2.setText(jVar.U);
                    }
                    net.one97.paytm.p2b.d.j jVar3 = jVar.W;
                    if (jVar3 != null) {
                        jVar3.a(Boolean.FALSE);
                    }
                    Group group = jVar.aa;
                    if (group != null) {
                        group.setVisibility(8);
                    }
                    new Handler().post(new m(jVar));
                    net.one97.paytm.p2b.e.c cVar3 = jVar.f13046a;
                    if (!(cVar3 == null || (yVar = cVar3.f12790f) == null)) {
                        a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
                        yVar.setValue(a.C0168a.a());
                    }
                    net.one97.paytm.p2b.d.i.a(jVar.getActivity(), new a(jVar));
                    net.one97.paytm.p2b.d.j jVar4 = jVar.W;
                    if (jVar4 != null) {
                        jVar4.a(true);
                    }
                    TextView textView3 = jVar.ab;
                    if (textView3 != null) {
                        textView3.setText(jVar.getString(R.string.p2b_pending_processing));
                        return;
                    }
                    return;
                }
                jVar.d();
            } else if (p.a(jVar.Q, "FAILURE", false)) {
                jVar.c();
            } else {
                net.one97.paytm.p2b.e.c cVar4 = jVar.f13046a;
                if (cVar4 != null) {
                    if (cVar4 != null) {
                        str = cVar4.t;
                    } else {
                        str = null;
                    }
                    cVar4.a(str);
                }
                jVar.b();
            }
        }
    }

    public static final /* synthetic */ void a(j jVar) {
        Dialog dialog;
        if (jVar.getActivity() != null) {
            try {
                if (jVar.f13054i == null) {
                    jVar.f13054i = net.one97.paytm.p2b.d.d.a((Activity) jVar.getActivity());
                }
                if (jVar.f13054i != null) {
                    Dialog dialog2 = jVar.f13054i;
                    Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!valueOf.booleanValue() && (dialog = jVar.f13054i) != null) {
                        dialog.show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r4.getResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.p2b.view.c.j r3, net.one97.paytm.common.entity.wallet.CJRP2BStatus r4) {
        /*
            r3.f()
            if (r4 == 0) goto L_0x0010
            net.one97.paytm.common.entity.wallet.CJRP2BStatusResponse r0 = r4.getResponse()
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isValidForTxn()
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 == 0) goto L_0x003f
            android.content.Intent r0 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity> r2 = net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity.class
            r0.<init>(r1, r2)
            java.lang.String r1 = com.paytm.utility.e.aC
            java.io.Serializable r4 = (java.io.Serializable) r4
            r0.putExtra(r1, r4)
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            r0.setFlags(r4)
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L_0x0035
            r4.startActivity(r0)
        L_0x0035:
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
            if (r3 == 0) goto L_0x003e
            r3.finish()
        L_0x003e:
            return
        L_0x003f:
            r4 = 0
            r3.a((java.lang.String) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.j.a(net.one97.paytm.p2b.view.c.j, net.one97.paytm.common.entity.wallet.CJRP2BStatus):void");
    }

    public static final /* synthetic */ void a(j jVar, NetworkCustomError networkCustomError) {
        jVar.f();
        if (networkCustomError instanceof NetworkCustomError) {
            String valueOf = String.valueOf(networkCustomError.getStatusCode());
            if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, valueOf, true) || p.a("403", valueOf, true) || p.a("410", valueOf, true)) {
                h.a aVar = net.one97.paytm.p2b.d.h.f12718a;
                new NetworkCustomError();
                net.one97.paytm.p2b.d.h.b(h.a.a()).a((Activity) jVar.getActivity(), (String) null, true);
                return;
            }
            jVar.a(networkCustomError.getAlertMessage());
            return;
        }
        jVar.a((String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r5 = (r5 = r5.getResponse()).getTxnList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.p2b.view.c.j r4, net.one97.paytm.P2B.CJRP2bCheckTxnStatus r5) {
        /*
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            r4.f13047b = r1
            androidx.constraintlayout.widget.ConstraintLayout r0 = r4.f13050e
            if (r0 == 0) goto L_0x0012
            r2 = 8
            r0.setVisibility(r2)
        L_0x0012:
            r0 = 0
            if (r5 == 0) goto L_0x0028
            net.one97.paytm.P2B.CJRP2bCheckTxnResponse r5 = r5.getResponse()
            if (r5 == 0) goto L_0x0028
            java.util.ArrayList r5 = r5.getTxnList()
            if (r5 == 0) goto L_0x0028
            java.lang.Object r5 = r5.get(r1)
            net.one97.paytm.P2B.CJRP2bTransaction r5 = (net.one97.paytm.P2B.CJRP2bTransaction) r5
            goto L_0x0029
        L_0x0028:
            r5 = r0
        L_0x0029:
            if (r5 == 0) goto L_0x0073
            java.lang.String r1 = r5.getMessage()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 1
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = r5.getMessage()
            java.lang.String r3 = "SUCCESS"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r1 == 0) goto L_0x0053
            r4.b()
            net.one97.paytm.p2b.e.c r4 = r4.f13046a
            if (r4 == 0) goto L_0x0052
            if (r4 == 0) goto L_0x004f
            java.lang.String r0 = r4.t
        L_0x004f:
            r4.a((java.lang.String) r0)
        L_0x0052:
            return
        L_0x0053:
            java.lang.String r0 = r5.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x006f
            java.lang.String r5 = r5.getMessage()
            java.lang.String r0 = "FAILURE"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r0, (boolean) r2)
            if (r5 == 0) goto L_0x006f
            r4.c()
            return
        L_0x006f:
            r4.d()
            return
        L_0x0073:
            r4.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.j.a(net.one97.paytm.p2b.view.c.j, net.one97.paytm.P2B.CJRP2bCheckTxnStatus):void");
    }

    public static final /* synthetic */ void b(j jVar, NetworkCustomError networkCustomError) {
        jVar.d();
        String valueOf = networkCustomError != null ? String.valueOf(networkCustomError.getStatusCode()) : null;
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, valueOf, true) || p.a("403", valueOf, true) || p.a("410", valueOf, true)) {
            h.a aVar = net.one97.paytm.p2b.d.h.f12718a;
            new NetworkCustomError();
            net.one97.paytm.p2b.d.h.b(h.a.a()).a((Activity) jVar.getActivity(), (String) null, true);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.ah;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
