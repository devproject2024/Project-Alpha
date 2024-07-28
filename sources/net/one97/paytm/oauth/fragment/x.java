package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.OtpSmsRetrieveBroadcastReceiver;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class x extends v implements OtpSmsRetrieveBroadcastReceiver.a {

    /* renamed from: a  reason: collision with root package name */
    private OtpSmsRetrieveBroadcastReceiver f56655a;

    /* renamed from: b  reason: collision with root package name */
    long f56656b;

    /* renamed from: c  reason: collision with root package name */
    private CountDownTimer f56657c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f56658d;

    /* renamed from: e  reason: collision with root package name */
    private Animation f56659e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Animation f56660f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f56661g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f56662h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f56663i;

    public enum a {
        STARTED,
        UPDATED,
        FINISHED
    }

    public View a(int i2) {
        if (this.f56663i == null) {
            this.f56663i = new HashMap();
        }
        View view = (View) this.f56663i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56663i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.f56663i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    /* access modifiers changed from: protected */
    public abstract void a(a aVar, long j);

    /* access modifiers changed from: protected */
    public abstract void b(String str);

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public x() {
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
        this.f56662h = new d(this);
    }

    public static final /* synthetic */ View a(x xVar) {
        View view = xVar.f56658d;
        if (view == null) {
            k.a("snackBarView");
        }
        return view;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        this.f56659e = AnimationUtils.loadAnimation(b2.getApplicationContext(), R.anim.slide_in_top);
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        this.f56660f = AnimationUtils.loadAnimation(b3.getApplicationContext(), R.anim.slide_out_top);
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
    }

    public void onStart() {
        super.onStart();
        q.d("Inside onStart()");
        if (this.f56655a == null) {
            q.d("SMS receiver null");
            net.one97.paytm.oauth.utils.x xVar = net.one97.paytm.oauth.utils.x.f56805a;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.f56655a = net.one97.paytm.oauth.utils.x.a((Activity) activity, (OtpSmsRetrieveBroadcastReceiver.a) this);
            } else {
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }
        Task<Void> a2 = com.google.android.gms.auth.api.phone.a.a(requireActivity()).a();
        a2.a((OnSuccessListener<? super Void>) f.f56670a);
        a2.a((OnFailureListener) g.f56671a);
    }

    static final class g implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public static final g f56671a = new g();

        g() {
        }

        public final void onFailure(Exception exc) {
            k.c(exc, "e");
            q.b("Failed to start sms retriever: " + exc.getMessage());
        }
    }

    public void onStop() {
        d();
        if (this.f56657c != null) {
            try {
                CountDownTimer countDownTimer = this.f56657c;
                if (countDownTimer == null) {
                    k.a("timer");
                }
                countDownTimer.cancel();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        net.one97.paytm.oauth.utils.x xVar = net.one97.paytm.oauth.utils.x.f56805a;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            net.one97.paytm.oauth.utils.x.a((Activity) activity, this.f56655a);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }

    public static final class e extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f56669a;

        /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
            jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 3, insn: 0x0000: IPUT  
              (r3 I:net.one97.paytm.oauth.fragment.x)
              (r2 I:net.one97.paytm.oauth.fragment.x$e)
             net.one97.paytm.oauth.fragment.x.e.a net.one97.paytm.oauth.fragment.x, block:B:0:0x0000
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:165)
            	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:137)
            	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
            	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
            */
        e(
/*
Method generation error in method: net.one97.paytm.oauth.fragment.x.e.<init>(net.one97.paytm.oauth.fragment.x, long):void, dex: classes5.dex
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
            x xVar = this.f56669a;
            xVar.f56656b = j;
            if (xVar.isAdded()) {
                this.f56669a.a(a.UPDATED, j);
            }
        }

        public final void onFinish() {
            this.f56669a.a(a.FINISHED, 0);
            this.f56669a.f56656b = 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        CountDownTimer start = new e(this, this.f56656b).start();
        k.a((Object) start, "object : CountDownTimer(…      }\n        }.start()");
        this.f56657c = start;
        a(a.STARTED, 0);
    }

    public final void c(String str) {
        k.c(str, "otp");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new c(this, str));
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f56666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56667b;

        c(x xVar, String str) {
            this.f56666a = xVar;
            this.f56667b = str;
        }

        public final void run() {
            OAuthUtils.a((Activity) this.f56666a.getActivity());
            this.f56666a.a(this.f56667b);
        }
    }

    /* access modifiers changed from: protected */
    public final String a(ErrorModel errorModel, String str) {
        k.c(errorModel, "model");
        if (OAuthUtils.a((Activity) getActivity(), (Fragment) this, errorModel.getCustomError())) {
            return "";
        }
        if (errorModel.getStatus() == -1) {
            String string = getString(R.string.no_connection);
            k.a((Object) string, "getString(R.string.no_connection)");
            String string2 = getString(R.string.no_internet);
            k.a((Object) string2, "getString(R.string.no_internet)");
            OAuthUtils.a(requireContext(), string, string2, new b(this, str));
        } else {
            if (errorModel.getCustomError() instanceof NetworkCustomError) {
                byte[] bArr = errorModel.getCustomError().networkResponse.data;
                if (bArr != null) {
                    try {
                        String string3 = new JSONObject(new String(bArr, kotlin.m.d.f47971a)).getString("message");
                        com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), string3);
                        k.a((Object) string3, "message");
                        return string3;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), getString(R.string.some_went_wrong));
        }
        return "";
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f56664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56665b;

        b(x xVar, String str) {
            this.f56664a = xVar;
            this.f56665b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56664a.b(this.f56665b);
        }
    }

    /* access modifiers changed from: protected */
    public final String d(String str) {
        k.c(str, "otp");
        if (TextUtils.isEmpty(str)) {
            String string = getString(R.string.empty_otp);
            k.a((Object) string, "getString(R.string.empty_otp)");
            return string;
        } else if (str.length() == 6) {
            return "";
        } else {
            String string2 = getString(R.string.invalid_otp);
            k.a((Object) string2, "getString(R.string.invalid_otp)");
            return string2;
        }
    }

    public static /* synthetic */ void a(x xVar, boolean z, int i2) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        xVar.a(z, false, (String) null);
    }

    /* JADX WARNING: type inference failed for: r9v23, types: [android.view.View] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r9, boolean r10, java.lang.String r11) {
        /*
            r8 = this;
            r0 = r8
            net.one97.paytm.oauth.fragment.x r0 = (net.one97.paytm.oauth.fragment.x) r0
            android.view.View r0 = r0.f56658d
            r1 = 0
            java.lang.String r2 = "snackBarView"
            if (r0 != 0) goto L_0x00cd
            android.view.LayoutInflater r0 = r8.getLayoutInflater()
            int r3 = net.one97.paytm.oauth.R.layout.layout_top_snack_bar
            r4 = 0
            android.view.View r0 = r0.inflate(r3, r4, r1)
            java.lang.String r3 = "layoutInflater.inflate(R…p_snack_bar, null, false)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r8.f56658d = r0
            r0 = -1
            java.lang.String r3 = "requireContext()"
            if (r9 == 0) goto L_0x0094
            android.graphics.drawable.GradientDrawable r9 = new android.graphics.drawable.GradientDrawable
            r9.<init>()
            android.content.Context r5 = r8.requireContext()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            android.content.res.Resources r5 = r5.getResources()
            int r6 = net.one97.paytm.common.assets.R.dimen.dimen_8dp
            int r5 = r5.getDimensionPixelSize(r6)
            float r5 = (float) r5
            r6 = 8
            float[] r6 = new float[r6]
            r6[r1] = r5
            r7 = 1
            r6[r7] = r5
            r7 = 2
            r6[r7] = r5
            r7 = 3
            r6[r7] = r5
            r5 = 4
            r7 = 0
            r6[r5] = r7
            r5 = 5
            r6[r5] = r7
            r5 = 6
            r6[r5] = r7
            r5 = 7
            r6[r5] = r7
            r9.setCornerRadii(r6)
            android.view.View r5 = r8.f56658d
            if (r5 != 0) goto L_0x005e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x005e:
            android.graphics.drawable.Drawable r9 = (android.graphics.drawable.Drawable) r9
            r5.setBackground(r9)
            android.view.View r9 = r8.getView()
            if (r9 == 0) goto L_0x006e
            android.view.ViewParent r9 = r9.getParent()
            goto L_0x006f
        L_0x006e:
            r9 = r4
        L_0x006f:
            boolean r5 = r9 instanceof android.view.ViewGroup
            if (r5 != 0) goto L_0x0074
            r9 = r4
        L_0x0074:
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            if (r9 == 0) goto L_0x00cd
            android.view.View r4 = r8.f56658d
            if (r4 != 0) goto L_0x007f
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x007f:
            android.content.Context r5 = r8.requireContext()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            android.content.res.Resources r3 = r5.getResources()
            int r5 = net.one97.paytm.oauth.R.dimen.dimen_45dp
            int r3 = r3.getDimensionPixelSize(r5)
            r9.addView(r4, r0, r3)
            goto L_0x00cd
        L_0x0094:
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            if (r9 == 0) goto L_0x00b0
            android.view.Window r9 = r9.getWindow()
            if (r9 == 0) goto L_0x00b0
            android.view.View r9 = r9.getDecorView()
            if (r9 == 0) goto L_0x00b0
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r9 = r9.findViewById(r4)
            r4 = r9
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
        L_0x00b0:
            if (r4 == 0) goto L_0x00cd
            android.view.View r9 = r8.f56658d
            if (r9 != 0) goto L_0x00b9
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00b9:
            android.content.Context r5 = r8.requireContext()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            android.content.res.Resources r3 = r5.getResources()
            int r5 = net.one97.paytm.oauth.R.dimen.dimen_45dp
            int r3 = r3.getDimensionPixelSize(r5)
            r4.addView(r9, r0, r3)
        L_0x00cd:
            android.view.View r9 = r8.f56658d
            if (r9 != 0) goto L_0x00d4
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00d4:
            boolean r9 = r9.isShown()
            if (r9 == 0) goto L_0x00dd
            r8.d()
        L_0x00dd:
            if (r10 == 0) goto L_0x00e2
            int r9 = net.one97.paytm.oauth.R.color.color_fd5154
            goto L_0x00e4
        L_0x00e2:
            int r9 = net.one97.paytm.oauth.R.color.color_21c17a
        L_0x00e4:
            android.view.View r10 = r8.f56658d
            if (r10 != 0) goto L_0x00eb
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00eb:
            android.graphics.drawable.Drawable r10 = r10.getBackground()
            boolean r0 = r10 instanceof android.graphics.drawable.GradientDrawable
            if (r0 == 0) goto L_0x0101
            android.graphics.drawable.GradientDrawable r10 = (android.graphics.drawable.GradientDrawable) r10
            android.content.Context r0 = r8.requireContext()
            int r9 = androidx.core.content.b.c(r0, r9)
            r10.setColor(r9)
            goto L_0x012d
        L_0x0101:
            boolean r0 = r10 instanceof android.graphics.drawable.ShapeDrawable
            if (r0 == 0) goto L_0x011c
            android.graphics.drawable.ShapeDrawable r10 = (android.graphics.drawable.ShapeDrawable) r10
            android.graphics.Paint r10 = r10.getPaint()
            java.lang.String r0 = "shapeDrawable.paint"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            android.content.Context r0 = r8.requireContext()
            int r9 = androidx.core.content.b.c(r0, r9)
            r10.setColor(r9)
            goto L_0x012d
        L_0x011c:
            boolean r0 = r10 instanceof android.graphics.drawable.ColorDrawable
            if (r0 == 0) goto L_0x012d
            android.graphics.drawable.ColorDrawable r10 = (android.graphics.drawable.ColorDrawable) r10
            android.content.Context r0 = r8.requireContext()
            int r9 = androidx.core.content.b.c(r0, r9)
            r10.setColor(r9)
        L_0x012d:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r9 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r10 = "null cannot be cast to non-null type android.widget.TextView"
            if (r9 != 0) goto L_0x014c
            android.view.View r9 = r8.f56658d
            if (r9 != 0) goto L_0x013e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x013e:
            if (r9 == 0) goto L_0x0146
            android.widget.TextView r9 = (android.widget.TextView) r9
            r9.setText(r11)
            goto L_0x0162
        L_0x0146:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r10)
            throw r9
        L_0x014c:
            android.view.View r9 = r8.f56658d
            if (r9 != 0) goto L_0x0153
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0153:
            if (r9 == 0) goto L_0x0184
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r10 = net.one97.paytm.oauth.R.string.lbl_otp_sent
            java.lang.String r10 = r8.getString(r10)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
        L_0x0162:
            android.view.View r9 = r8.f56658d
            if (r9 != 0) goto L_0x0169
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0169:
            r9.setVisibility(r1)
            android.view.animation.Animation r9 = r8.f56659e
            if (r9 == 0) goto L_0x017a
            android.view.View r10 = r8.f56658d
            if (r10 != 0) goto L_0x0177
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0177:
            r10.startAnimation(r9)
        L_0x017a:
            android.os.Handler r9 = r8.f56661g
            java.lang.Runnable r10 = r8.f56662h
            r0 = 4000(0xfa0, double:1.9763E-320)
            r9.postDelayed(r10, r0)
            return
        L_0x0184:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.x.a(boolean, boolean, java.lang.String):void");
    }

    private final void d() {
        this.f56661g.removeCallbacksAndMessages((Object) null);
        if (this.f56658d != null) {
            View view = this.f56658d;
            if (view == null) {
                k.a("snackBarView");
            }
            view.setVisibility(8);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f56668a;

        d(x xVar) {
            this.f56668a = xVar;
        }

        public final void run() {
            if (this.f56668a.f56658d != null && x.a(this.f56668a).isShown()) {
                x.a(this.f56668a).startAnimation(this.f56668a.f56660f);
                x.a(this.f56668a).setVisibility(8);
            }
        }
    }

    static final class f<TResult> implements OnSuccessListener<Void> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f56670a = new f();

        f() {
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            q.d("Sms retriever started!");
        }
    }
}
