package net.one97.paytm.upgradeKyc.videokyc.a;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;

public final class g extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final a f66391b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public b f66392a;

    /* renamed from: c  reason: collision with root package name */
    private int f66393c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f66394d;

    public interface b {
        void h();
    }

    public final View a(int i2) {
        if (this.f66394d == null) {
            this.f66394d = new HashMap();
        }
        View view = (View) this.f66394d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f66394d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f66392a = (b) context;
            return;
        }
        throw new IllegalStateException(context + " must implement TimerVideoKycFragment.InteractionListener");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_timer_video_kyc, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("waitTimeInSec", 0)) : null;
        if (valueOf == null) {
            k.a();
        }
        this.f66393c = valueOf.intValue();
        ProgressBar progressBar = (ProgressBar) a(R.id.progressBar);
        k.a((Object) progressBar, "progressBar");
        progressBar.setMax(this.f66393c * 1000);
        ProgressBar progressBar2 = (ProgressBar) a(R.id.progressBar);
        k.a((Object) progressBar2, "progressBar");
        ProgressBar progressBar3 = (ProgressBar) a(R.id.progressBar);
        k.a((Object) progressBar3, "progressBar");
        progressBar2.setProgress(progressBar3.getMax());
        new c(this, (long) (this.f66393c * 1000)).start();
        x.a aVar = new x.a();
        aVar.element = false;
        x.a aVar2 = new x.a();
        aVar2.element = false;
        ProgressBar progressBar4 = (ProgressBar) a(R.id.progressBar);
        k.a((Object) progressBar4, "progressBar");
        ObjectAnimator ofInt = ObjectAnimator.ofInt((ProgressBar) a(R.id.progressBar), H5Param.PROGRESS, new int[]{progressBar4.getProgress(), 0});
        k.a((Object) ofInt, "ObjectAnimator.ofInt(pro…essBar.progress, 0 * 100)");
        ofInt.setDuration((long) (this.f66393c * 1000));
        ofInt.addUpdateListener(new d(this, aVar, ofInt, aVar2));
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    public static final class c extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f66395a;

        /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
            jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 3, insn: 0x0000: IPUT  
              (r3 I:net.one97.paytm.upgradeKyc.videokyc.a.g)
              (r2 I:net.one97.paytm.upgradeKyc.videokyc.a.g$c)
             net.one97.paytm.upgradeKyc.videokyc.a.g.c.a net.one97.paytm.upgradeKyc.videokyc.a.g, block:B:0:0x0000
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:165)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:137)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        c(
/*
Method generation error in method: net.one97.paytm.upgradeKyc.videokyc.a.g.c.<init>(net.one97.paytm.upgradeKyc.videokyc.a.g, long):void, dex: classes7.dex
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

        public final void onTick(long j) {
            if (this.f66395a.getActivity() != null) {
                FragmentActivity activity = this.f66395a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                if (!activity.isFinishing()) {
                    FragmentActivity activity2 = this.f66395a.getActivity();
                    if (activity2 == null) {
                        k.a();
                    }
                    k.a((Object) activity2, "activity!!");
                    if (!activity2.isDestroyed()) {
                        TextView textView = (TextView) this.f66395a.a(R.id.tv_time_progress);
                        k.a((Object) textView, "tv_time_progress");
                        textView.setText((j / 1000) + 10 + this.f66395a.getString(R.string.kyc_seconds));
                    }
                }
            }
        }

        public final void onFinish() {
            if (this.f66395a.getActivity() != null) {
                FragmentActivity activity = this.f66395a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                if (!activity.isFinishing()) {
                    FragmentActivity activity2 = this.f66395a.getActivity();
                    if (activity2 == null) {
                        k.a();
                    }
                    k.a((Object) activity2, "activity!!");
                    if (!activity2.isDestroyed()) {
                        b bVar = this.f66395a.f66392a;
                        if (bVar == null) {
                            k.a("mHost");
                        }
                        bVar.h();
                    }
                }
            }
        }
    }

    static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f66396a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f66397b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f66398c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.a f66399d;

        d(g gVar, x.a aVar, ObjectAnimator objectAnimator, x.a aVar2) {
            this.f66396a = gVar;
            this.f66397b = aVar;
            this.f66398c = objectAnimator;
            this.f66399d = aVar2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f66396a.getActivity() != null) {
                FragmentActivity activity = this.f66396a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                if (!activity.isFinishing()) {
                    FragmentActivity activity2 = this.f66396a.getActivity();
                    if (activity2 == null) {
                        k.a();
                    }
                    k.a((Object) activity2, "activity!!");
                    if (!activity2.isDestroyed()) {
                        if (!this.f66397b.element) {
                            k.a((Object) valueAnimator, "it");
                            if (this.f66398c.getDuration() / 2 > ((long) Integer.parseInt(valueAnimator.getAnimatedValue().toString()))) {
                                this.f66397b.element = true;
                                ProgressBar progressBar = (ProgressBar) this.f66396a.a(R.id.progressBar);
                                k.a((Object) progressBar, "progressBar");
                                FragmentActivity activity3 = this.f66396a.getActivity();
                                if (activity3 == null) {
                                    k.a();
                                }
                                k.a((Object) activity3, "activity!!");
                                progressBar.setProgressDrawable(activity3.getResources().getDrawable(R.drawable.circular_progress_intermidate));
                            }
                        }
                        if (!this.f66399d.element) {
                            k.a((Object) valueAnimator, "it");
                            if (this.f66398c.getDuration() / 4 > ((long) Integer.parseInt(valueAnimator.getAnimatedValue().toString()))) {
                                this.f66399d.element = true;
                                ProgressBar progressBar2 = (ProgressBar) this.f66396a.a(R.id.progressBar);
                                k.a((Object) progressBar2, "progressBar");
                                FragmentActivity activity4 = this.f66396a.getActivity();
                                if (activity4 == null) {
                                    k.a();
                                }
                                k.a((Object) activity4, "activity!!");
                                progressBar2.setProgressDrawable(activity4.getResources().getDrawable(R.drawable.circular_progress_bar_finishing));
                            }
                        }
                    }
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66394d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
