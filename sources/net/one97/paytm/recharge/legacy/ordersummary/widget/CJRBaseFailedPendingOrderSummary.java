package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.p;
import androidx.transition.v;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.f.r;

public abstract class CJRBaseFailedPendingOrderSummary extends ConstraintLayout implements View.OnClickListener, ai {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f63066a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressDialog f63067b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final r f63068c;

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f63069d;

    /* renamed from: e  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f63070e;

    public final View.OnClickListener getClickListener() {
        return this.f63069d;
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f63070e;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRBaseFailedPendingOrderSummary(Context context, ViewGroup viewGroup, int i2, int i3, r rVar, View.OnClickListener onClickListener, net.one97.paytm.recharge.ordersummary.b.a aVar) {
        super(context);
        k.c(context, "context");
        k.c(viewGroup, "rootLayout");
        k.c(aVar, "viewModel");
        this.f63068c = rVar;
        this.f63069d = onClickListener;
        this.f63070e = aVar;
        boolean z = true;
        LayoutInflater.from(context).inflate(i2, this, true);
        setBackgroundColor(androidx.core.content.b.c(context, 17170443));
        ((ImageView) findViewById(R.id.icon)).setImageResource(i3);
        View findViewById = findViewById(R.id.title);
        k.a((Object) findViewById, "findViewById<TextView>(R.id.title)");
        this.f63066a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.operator_number);
        k.a((Object) findViewById2, "(findViewById<TextView>(R.id.operator_number))");
        ((TextView) findViewById2).setText(this.f63070e.a(context));
        TextView textView = (TextView) findViewById(R.id.amount);
        CharSequence b2 = this.f63070e.b(context);
        int i4 = 0;
        if (!(b2 == null || b2.length() == 0)) {
            textView.setText(b2);
        }
        if (!(b2 == null || b2.length() == 0)) {
            z = false;
        }
        textView.setVisibility(z ? 8 : i4);
        View findViewById3 = findViewById(R.id.order_id);
        k.a((Object) findViewById3, "(findViewById<TextView>(R.id.order_id))");
        ((TextView) findViewById3).setText(this.f63070e.o(context));
        View findViewById4 = findViewById(R.id.date_time);
        k.a((Object) findViewById4, "(findViewById<TextView>(R.id.date_time))");
        ((TextView) findViewById4).setText(this.f63070e.n(context));
        ((TextView) findViewById(R.id.need_help)).setOnClickListener(this);
        v.a(new p(viewGroup, this), (Transition) new Fade());
        postDelayed(new b(this), 200);
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = (AJRechargeOrderSummaryActivity) (!(context instanceof AJRechargeOrderSummaryActivity) ? null : context);
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.b();
        }
    }

    /* access modifiers changed from: protected */
    public final TextView getTitle() {
        return this.f63066a;
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseFailedPendingOrderSummary f63073a;

        b(CJRBaseFailedPendingOrderSummary cJRBaseFailedPendingOrderSummary) {
            this.f63073a = cJRBaseFailedPendingOrderSummary;
        }

        public final void run() {
            CJRBaseFailedPendingOrderSummary.a(this.f63073a);
            r b2 = this.f63073a.f63068c;
            if (b2 != null) {
                b2.u();
            }
        }
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f63069d;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static final class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseFailedPendingOrderSummary f63071a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f63072b;

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
            jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 3, insn: 0x0000: IPUT  
              (r3 I:net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseFailedPendingOrderSummary)
              (r2 I:net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseFailedPendingOrderSummary$a)
             net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseFailedPendingOrderSummary.a.a net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseFailedPendingOrderSummary, block:B:0:0x0000
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:165)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:137)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        a(
/*
Method generation error in method: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseFailedPendingOrderSummary.a.<init>(net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseFailedPendingOrderSummary):void, dex: classes7.dex
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v0 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
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
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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

        public final void onAnimationEnd(Animation animation) {
            for (Integer intValue : this.f63071a.getLateInflatingViewIds()) {
                int intValue2 = intValue.intValue();
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f63071a.getContext(), 17432576);
                k.a((Object) loadAnimation, "fadeIn");
                loadAnimation.setFillAfter(true);
                loadAnimation.setDuration(this.f63072b / 2);
                View findViewById = this.f63071a.findViewById(intValue2);
                k.a((Object) findViewById, "findViewById<View>(it)");
                findViewById.setVisibility(0);
                this.f63071a.findViewById(intValue2).startAnimation(loadAnimation);
            }
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(this.f63072b / 2);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setAnimationListener(new C1219a());
            ((ImageView) this.f63071a.findViewById(R.id.icon)).startAnimation(scaleAnimation);
        }

        /* renamed from: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseFailedPendingOrderSummary$a$a  reason: collision with other inner class name */
        public static final class C1219a implements Animation.AnimationListener {
            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            C1219a() {
            }
        }
    }

    /* access modifiers changed from: protected */
    public Integer[] getLateInflatingViewIds() {
        return new Integer[]{Integer.valueOf(R.id.order_id), Integer.valueOf(R.id.need_help)};
    }

    /* access modifiers changed from: protected */
    public final void a() {
        if (this.f63067b == null) {
            this.f63067b = ProgressDialog.show(getContext(), "", getContext().getString(R.string.please_wait));
        }
        ProgressDialog progressDialog = this.f63067b;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        try {
            ProgressDialog progressDialog = this.f63067b;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (IllegalStateException e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        b();
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        k.c(networkCustomError, "error");
        b();
    }

    public static final /* synthetic */ void a(CJRBaseFailedPendingOrderSummary cJRBaseFailedPendingOrderSummary) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new a(cJRBaseFailedPendingOrderSummary));
        View findViewById = cJRBaseFailedPendingOrderSummary.findViewById(R.id.icon);
        k.a((Object) findViewById, "findViewById<ImageView>(R.id.icon)");
        ((ImageView) findViewById).setVisibility(0);
        ((ImageView) cJRBaseFailedPendingOrderSummary.findViewById(R.id.icon)).startAnimation(scaleAnimation);
    }
}
