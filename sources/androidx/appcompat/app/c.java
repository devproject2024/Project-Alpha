package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.h.u;
import androidx.core.widget.NestedScrollView;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class c extends f implements DialogInterface {

    /* renamed from: a  reason: collision with root package name */
    public final AlertController f1094a = new AlertController(getContext(), this, getWindow());

    protected c(Context context, int i2) {
        super(context, a(context, i2));
    }

    static int a(Context context, int i2) {
        if (((i2 >>> 24) & PriceRangeSeekBar.INVALID_POINTER_ID) > 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1094a.a(charSequence);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        int i2;
        View view;
        boolean z;
        View findViewById;
        View view2;
        View findViewById2;
        super.onCreate(bundle);
        AlertController alertController = this.f1094a;
        if (alertController.K == 0 || alertController.Q != 1) {
            i2 = alertController.J;
        } else {
            i2 = alertController.K;
        }
        alertController.f993b.setContentView(i2);
        View findViewById3 = alertController.f994c.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        char c2 = 0;
        if (alertController.f999h != null) {
            view = alertController.f999h;
        } else {
            view = alertController.f1000i != 0 ? LayoutInflater.from(alertController.f992a).inflate(alertController.f1000i, viewGroup, false) : null;
        }
        boolean z2 = view != null;
        if (!z2 || !AlertController.a(view)) {
            alertController.f994c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.f994c.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.n) {
                frameLayout.setPadding(alertController.j, alertController.k, alertController.l, alertController.m);
            }
            if (alertController.f998g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f1551g = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup a2 = AlertController.a(findViewById7, findViewById4);
        ViewGroup a3 = AlertController.a(findViewById8, findViewById5);
        ViewGroup a4 = AlertController.a(findViewById9, findViewById6);
        alertController.A = (NestedScrollView) alertController.f994c.findViewById(R.id.scrollView);
        alertController.A.setFocusable(false);
        alertController.A.setNestedScrollingEnabled(false);
        alertController.F = (TextView) a3.findViewById(16908299);
        if (alertController.F != null) {
            if (alertController.f997f != null) {
                alertController.F.setText(alertController.f997f);
            } else {
                alertController.F.setVisibility(8);
                alertController.A.removeView(alertController.F);
                if (alertController.f998g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.A.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.A);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.f998g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    a3.setVisibility(8);
                }
            }
        }
        alertController.o = (Button) a4.findViewById(16908313);
        alertController.o.setOnClickListener(alertController.S);
        if (!TextUtils.isEmpty(alertController.p) || alertController.r != null) {
            alertController.o.setText(alertController.p);
            if (alertController.r != null) {
                alertController.r.setBounds(0, 0, alertController.f995d, alertController.f995d);
                alertController.o.setCompoundDrawables(alertController.r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            alertController.o.setVisibility(0);
            z = true;
        } else {
            alertController.o.setVisibility(8);
            z = false;
        }
        alertController.s = (Button) a4.findViewById(16908314);
        alertController.s.setOnClickListener(alertController.S);
        if (!TextUtils.isEmpty(alertController.t) || alertController.v != null) {
            alertController.s.setText(alertController.t);
            if (alertController.v != null) {
                alertController.v.setBounds(0, 0, alertController.f995d, alertController.f995d);
                alertController.s.setCompoundDrawables(alertController.v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            alertController.s.setVisibility(0);
            z |= true;
        } else {
            alertController.s.setVisibility(8);
        }
        alertController.w = (Button) a4.findViewById(16908315);
        alertController.w.setOnClickListener(alertController.S);
        if (!TextUtils.isEmpty(alertController.x) || alertController.z != null) {
            alertController.w.setText(alertController.x);
            if (alertController.z != null) {
                alertController.z.setBounds(0, 0, alertController.f995d, alertController.f995d);
                alertController.w.setCompoundDrawables(alertController.z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            alertController.w.setVisibility(0);
            z |= true;
        } else {
            alertController.w.setVisibility(8);
        }
        Context context = alertController.f992a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z) {
                AlertController.a(alertController.o);
            } else if (z) {
                AlertController.a(alertController.s);
            } else if (z) {
                AlertController.a(alertController.w);
            }
        }
        if (!(z)) {
            a4.setVisibility(8);
        }
        if (alertController.G != null) {
            a2.addView(alertController.G, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.f994c.findViewById(R.id.title_template).setVisibility(8);
        } else {
            alertController.D = (ImageView) alertController.f994c.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.f996e)) || !alertController.P) {
                alertController.f994c.findViewById(R.id.title_template).setVisibility(8);
                alertController.D.setVisibility(8);
                a2.setVisibility(8);
            } else {
                alertController.E = (TextView) alertController.f994c.findViewById(R.id.alertTitle);
                alertController.E.setText(alertController.f996e);
                if (alertController.B != 0) {
                    alertController.D.setImageResource(alertController.B);
                } else if (alertController.C != null) {
                    alertController.D.setImageDrawable(alertController.C);
                } else {
                    alertController.E.setPadding(alertController.D.getPaddingLeft(), alertController.D.getPaddingTop(), alertController.D.getPaddingRight(), alertController.D.getPaddingBottom());
                    alertController.D.setVisibility(8);
                }
            }
        }
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z4 = (a2 == null || a2.getVisibility() == 8) ? false : true;
        boolean z5 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!(z5 || a3 == null || (findViewById2 = a3.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z4) {
            if (alertController.A != null) {
                alertController.A.setClipToPadding(true);
            }
            if (alertController.f997f == null && alertController.f998g == null) {
                view2 = null;
            } else {
                view2 = a2.findViewById(R.id.titleDividerNoCustom);
            }
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else if (!(a3 == null || (findViewById = a3.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        if (alertController.f998g instanceof AlertController.RecycleListView) {
            ((AlertController.RecycleListView) alertController.f998g).setHasDecor(z4, z5);
        }
        if (!z3) {
            View view3 = alertController.f998g != null ? alertController.f998g : alertController.A;
            if (view3 != null) {
                if (z5) {
                    c2 = 2;
                }
                boolean z6 = z4 | c2;
                View findViewById10 = alertController.f994c.findViewById(R.id.scrollIndicatorUp);
                View findViewById11 = alertController.f994c.findViewById(R.id.scrollIndicatorDown);
                if (Build.VERSION.SDK_INT >= 23) {
                    u.h(view3, z6 ? 1 : 0);
                    if (findViewById10 != null) {
                        a3.removeView(findViewById10);
                    }
                    if (findViewById11 != null) {
                        a3.removeView(findViewById11);
                    }
                } else {
                    if (findViewById10 != null && (!z6 || !true)) {
                        a3.removeView(findViewById10);
                        findViewById10 = null;
                    }
                    if (findViewById11 != null && (!z6 || !true)) {
                        a3.removeView(findViewById11);
                        findViewById11 = null;
                    }
                    if (!(findViewById10 == null && findViewById11 == null)) {
                        if (alertController.f997f != null) {
                            alertController.A.setOnScrollChangeListener(new NestedScrollView.b(findViewById10, findViewById11) {

                                /* renamed from: a */
                                final /* synthetic */ View f1002a;

                                /* renamed from: b */
                                final /* synthetic */ View f1003b;

                                public final void onScrollChange(
/*
Method generation error in method: androidx.appcompat.app.AlertController.2.onScrollChange(androidx.core.widget.NestedScrollView, int, int, int, int):void, dex: classes.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: androidx.appcompat.app.AlertController.2.onScrollChange(androidx.core.widget.NestedScrollView, int, int, int, int):void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            });
                            alertController.A.post(new Runnable(findViewById10, findViewById11) {

                                /* renamed from: a */
                                final /* synthetic */ View f1005a;

                                /* renamed from: b */
                                final /* synthetic */ View f1006b;

                                public final void run(
/*
Method generation error in method: androidx.appcompat.app.AlertController.3.run():void, dex: classes.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: androidx.appcompat.app.AlertController.3.run():void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            });
                        } else if (alertController.f998g != null) {
                            alertController.f998g.setOnScrollListener(new AbsListView.OnScrollListener(findViewById10, findViewById11) {

                                /* renamed from: a */
                                final /* synthetic */ View f1008a;

                                /* renamed from: b */
                                final /* synthetic */ View f1009b;

                                public final void onScrollStateChanged(
/*
Method generation error in method: androidx.appcompat.app.AlertController.4.onScrollStateChanged(android.widget.AbsListView, int):void, dex: classes.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: androidx.appcompat.app.AlertController.4.onScrollStateChanged(android.widget.AbsListView, int):void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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

                                public final void onScroll(
/*
Method generation error in method: androidx.appcompat.app.AlertController.4.onScroll(android.widget.AbsListView, int, int, int):void, dex: classes.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: androidx.appcompat.app.AlertController.4.onScroll(android.widget.AbsListView, int, int, int):void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            });
                            alertController.f998g.post(new Runnable(findViewById10, findViewById11) {

                                /* renamed from: a */
                                final /* synthetic */ View f1011a;

                                /* renamed from: b */
                                final /* synthetic */ View f1012b;

                                public final void run(
/*
Method generation error in method: androidx.appcompat.app.AlertController.5.run():void, dex: classes.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: androidx.appcompat.app.AlertController.5.run():void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            });
                        } else {
                            if (findViewById10 != null) {
                                a3.removeView(findViewById10);
                            }
                            if (findViewById11 != null) {
                                a3.removeView(findViewById11);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = alertController.f998g;
        if (listView != null && alertController.H != null) {
            listView.setAdapter(alertController.H);
            int i3 = alertController.I;
            if (i3 >= 0) {
                listView.setItemChecked(i3, true);
                listView.setSelection(i3);
            }
        }
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AlertController alertController = this.f1094a;
        if (alertController.A != null && alertController.A.a(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AlertController alertController = this.f1094a;
        if (alertController.A != null && alertController.A.a(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final AlertController.a f1095a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1096b;

        public a(Context context) {
            this(context, c.a(context, 0));
        }

        public a(Context context, int i2) {
            this.f1095a = new AlertController.a(new ContextThemeWrapper(context, c.a(context, i2)));
            this.f1096b = i2;
        }

        public final a a(int i2) {
            AlertController.a aVar = this.f1095a;
            aVar.f1021f = aVar.f1016a.getText(i2);
            return this;
        }

        public final a a(CharSequence charSequence) {
            this.f1095a.f1021f = charSequence;
            return this;
        }

        public final a b(int i2) {
            AlertController.a aVar = this.f1095a;
            aVar.f1023h = aVar.f1016a.getText(i2);
            return this;
        }

        public final a b(CharSequence charSequence) {
            this.f1095a.f1023h = charSequence;
            return this;
        }

        public final a a(Drawable drawable) {
            this.f1095a.f1019d = drawable;
            return this;
        }

        public final a a(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f1095a;
            aVar.f1024i = aVar.f1016a.getText(i2);
            this.f1095a.k = onClickListener;
            return this;
        }

        public final a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f1095a;
            aVar.f1024i = charSequence;
            aVar.k = onClickListener;
            return this;
        }

        public final a b(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f1095a;
            aVar.l = aVar.f1016a.getText(i2);
            this.f1095a.n = onClickListener;
            return this;
        }

        public final a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f1095a;
            aVar.l = charSequence;
            aVar.n = onClickListener;
            return this;
        }

        public final a a(boolean z) {
            this.f1095a.r = z;
            return this;
        }

        public final a a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f1095a;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            return this;
        }

        public final a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f1095a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public final a a(View view) {
            AlertController.a aVar = this.f1095a;
            aVar.z = view;
            aVar.y = 0;
            aVar.E = false;
            return this;
        }

        /* JADX WARNING: type inference failed for: r14v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r14v4 */
        /* JADX WARNING: type inference failed for: r14v5 */
        /* JADX WARNING: type inference failed for: r14v6 */
        /* JADX WARNING: type inference failed for: r4v30, types: [androidx.appcompat.app.AlertController$a$2] */
        /* JADX WARNING: type inference failed for: r4v31, types: [androidx.appcompat.app.AlertController$a$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.appcompat.app.c a() {
            /*
                r20 = this;
                r0 = r20
                androidx.appcompat.app.c r1 = new androidx.appcompat.app.c
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                android.content.Context r2 = r2.f1016a
                int r3 = r0.f1096b
                r1.<init>(r2, r3)
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                androidx.appcompat.app.AlertController r10 = r1.f1094a
                android.view.View r3 = r2.f1022g
                r11 = 1
                r12 = 0
                if (r3 == 0) goto L_0x001c
                android.view.View r3 = r2.f1022g
                r10.G = r3
                goto L_0x0069
            L_0x001c:
                java.lang.CharSequence r3 = r2.f1021f
                if (r3 == 0) goto L_0x0025
                java.lang.CharSequence r3 = r2.f1021f
                r10.a((java.lang.CharSequence) r3)
            L_0x0025:
                android.graphics.drawable.Drawable r3 = r2.f1019d
                if (r3 == 0) goto L_0x0047
                android.graphics.drawable.Drawable r3 = r2.f1019d
                r10.C = r3
                r10.B = r12
                android.widget.ImageView r4 = r10.D
                if (r4 == 0) goto L_0x0047
                if (r3 == 0) goto L_0x0040
                android.widget.ImageView r4 = r10.D
                r4.setVisibility(r12)
                android.widget.ImageView r4 = r10.D
                r4.setImageDrawable(r3)
                goto L_0x0047
            L_0x0040:
                android.widget.ImageView r3 = r10.D
                r4 = 8
                r3.setVisibility(r4)
            L_0x0047:
                int r3 = r2.f1018c
                if (r3 == 0) goto L_0x0050
                int r3 = r2.f1018c
                r10.a((int) r3)
            L_0x0050:
                int r3 = r2.f1020e
                if (r3 == 0) goto L_0x0069
                int r3 = r2.f1020e
                android.util.TypedValue r4 = new android.util.TypedValue
                r4.<init>()
                android.content.Context r5 = r10.f992a
                android.content.res.Resources$Theme r5 = r5.getTheme()
                r5.resolveAttribute(r3, r4, r11)
                int r3 = r4.resourceId
                r10.a((int) r3)
            L_0x0069:
                java.lang.CharSequence r3 = r2.f1023h
                if (r3 == 0) goto L_0x007a
                java.lang.CharSequence r3 = r2.f1023h
                r10.f997f = r3
                android.widget.TextView r4 = r10.F
                if (r4 == 0) goto L_0x007a
                android.widget.TextView r4 = r10.F
                r4.setText(r3)
            L_0x007a:
                java.lang.CharSequence r3 = r2.f1024i
                if (r3 != 0) goto L_0x0082
                android.graphics.drawable.Drawable r3 = r2.j
                if (r3 == 0) goto L_0x008e
            L_0x0082:
                r4 = -1
                java.lang.CharSequence r5 = r2.f1024i
                android.content.DialogInterface$OnClickListener r6 = r2.k
                r7 = 0
                android.graphics.drawable.Drawable r8 = r2.j
                r3 = r10
                r3.a(r4, r5, r6, r7, r8)
            L_0x008e:
                java.lang.CharSequence r3 = r2.l
                if (r3 != 0) goto L_0x0096
                android.graphics.drawable.Drawable r3 = r2.m
                if (r3 == 0) goto L_0x00a2
            L_0x0096:
                r4 = -2
                java.lang.CharSequence r5 = r2.l
                android.content.DialogInterface$OnClickListener r6 = r2.n
                r7 = 0
                android.graphics.drawable.Drawable r8 = r2.m
                r3 = r10
                r3.a(r4, r5, r6, r7, r8)
            L_0x00a2:
                java.lang.CharSequence r3 = r2.o
                if (r3 != 0) goto L_0x00aa
                android.graphics.drawable.Drawable r3 = r2.p
                if (r3 == 0) goto L_0x00b6
            L_0x00aa:
                r4 = -3
                java.lang.CharSequence r5 = r2.o
                android.content.DialogInterface$OnClickListener r6 = r2.q
                r7 = 0
                android.graphics.drawable.Drawable r8 = r2.p
                r3 = r10
                r3.a(r4, r5, r6, r7, r8)
            L_0x00b6:
                java.lang.CharSequence[] r3 = r2.v
                r13 = 0
                if (r3 != 0) goto L_0x00c3
                android.database.Cursor r3 = r2.K
                if (r3 != 0) goto L_0x00c3
                android.widget.ListAdapter r3 = r2.w
                if (r3 == 0) goto L_0x0169
            L_0x00c3:
                android.view.LayoutInflater r3 = r2.f1017b
                int r4 = r10.L
                android.view.View r3 = r3.inflate(r4, r13)
                androidx.appcompat.app.AlertController$RecycleListView r3 = (androidx.appcompat.app.AlertController.RecycleListView) r3
                boolean r4 = r2.G
                if (r4 == 0) goto L_0x00f2
                android.database.Cursor r4 = r2.K
                if (r4 != 0) goto L_0x00e4
                androidx.appcompat.app.AlertController$a$1 r14 = new androidx.appcompat.app.AlertController$a$1
                android.content.Context r6 = r2.f1016a
                int r7 = r10.M
                java.lang.CharSequence[] r8 = r2.v
                r4 = r14
                r5 = r2
                r9 = r3
                r4.<init>(r6, r7, r8, r9)
                goto L_0x012f
            L_0x00e4:
                androidx.appcompat.app.AlertController$a$2 r14 = new androidx.appcompat.app.AlertController$a$2
                android.content.Context r6 = r2.f1016a
                android.database.Cursor r7 = r2.K
                r4 = r14
                r5 = r2
                r8 = r3
                r9 = r10
                r4.<init>(r6, r7, r8, r9)
                goto L_0x012f
            L_0x00f2:
                boolean r4 = r2.H
                if (r4 == 0) goto L_0x00f9
                int r4 = r10.N
                goto L_0x00fb
            L_0x00f9:
                int r4 = r10.O
            L_0x00fb:
                android.database.Cursor r5 = r2.K
                if (r5 == 0) goto L_0x011f
                android.widget.SimpleCursorAdapter r5 = new android.widget.SimpleCursorAdapter
                android.content.Context r15 = r2.f1016a
                android.database.Cursor r6 = r2.K
                java.lang.String[] r7 = new java.lang.String[r11]
                java.lang.String r8 = r2.L
                r7[r12] = r8
                int[] r8 = new int[r11]
                r9 = 16908308(0x1020014, float:2.3877285E-38)
                r8[r12] = r9
                r14 = r5
                r16 = r4
                r17 = r6
                r18 = r7
                r19 = r8
                r14.<init>(r15, r16, r17, r18, r19)
                goto L_0x012f
            L_0x011f:
                android.widget.ListAdapter r5 = r2.w
                if (r5 == 0) goto L_0x0126
                android.widget.ListAdapter r14 = r2.w
                goto L_0x012f
            L_0x0126:
                androidx.appcompat.app.AlertController$c r14 = new androidx.appcompat.app.AlertController$c
                android.content.Context r5 = r2.f1016a
                java.lang.CharSequence[] r6 = r2.v
                r14.<init>(r5, r4, r6)
            L_0x012f:
                r10.H = r14
                int r4 = r2.I
                r10.I = r4
                android.content.DialogInterface$OnClickListener r4 = r2.x
                if (r4 == 0) goto L_0x0142
                androidx.appcompat.app.AlertController$a$3 r4 = new androidx.appcompat.app.AlertController$a$3
                r4.<init>(r10)
                r3.setOnItemClickListener(r4)
                goto L_0x014e
            L_0x0142:
                android.content.DialogInterface$OnMultiChoiceClickListener r4 = r2.J
                if (r4 == 0) goto L_0x014e
                androidx.appcompat.app.AlertController$a$4 r4 = new androidx.appcompat.app.AlertController$a$4
                r4.<init>(r3, r10)
                r3.setOnItemClickListener(r4)
            L_0x014e:
                android.widget.AdapterView$OnItemSelectedListener r4 = r2.N
                if (r4 == 0) goto L_0x0157
                android.widget.AdapterView$OnItemSelectedListener r4 = r2.N
                r3.setOnItemSelectedListener(r4)
            L_0x0157:
                boolean r4 = r2.H
                if (r4 == 0) goto L_0x015f
                r3.setChoiceMode(r11)
                goto L_0x0167
            L_0x015f:
                boolean r4 = r2.G
                if (r4 == 0) goto L_0x0167
                r4 = 2
                r3.setChoiceMode(r4)
            L_0x0167:
                r10.f998g = r3
            L_0x0169:
                android.view.View r3 = r2.z
                if (r3 == 0) goto L_0x0193
                boolean r3 = r2.E
                if (r3 == 0) goto L_0x018a
                android.view.View r3 = r2.z
                int r4 = r2.A
                int r5 = r2.B
                int r6 = r2.C
                int r2 = r2.D
                r10.f999h = r3
                r10.f1000i = r12
                r10.n = r11
                r10.j = r4
                r10.k = r5
                r10.l = r6
                r10.m = r2
                goto L_0x019f
            L_0x018a:
                android.view.View r2 = r2.z
                r10.f999h = r2
                r10.f1000i = r12
                r10.n = r12
                goto L_0x019f
            L_0x0193:
                int r3 = r2.y
                if (r3 == 0) goto L_0x019f
                int r2 = r2.y
                r10.f999h = r13
                r10.f1000i = r2
                r10.n = r12
            L_0x019f:
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                boolean r2 = r2.r
                r1.setCancelable(r2)
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                boolean r2 = r2.r
                if (r2 == 0) goto L_0x01af
                r1.setCanceledOnTouchOutside(r11)
            L_0x01af:
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                android.content.DialogInterface$OnCancelListener r2 = r2.s
                r1.setOnCancelListener(r2)
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                android.content.DialogInterface$OnDismissListener r2 = r2.t
                r1.setOnDismissListener(r2)
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                android.content.DialogInterface$OnKeyListener r2 = r2.u
                if (r2 == 0) goto L_0x01ca
                androidx.appcompat.app.AlertController$a r2 = r0.f1095a
                android.content.DialogInterface$OnKeyListener r2 = r2.u
                r1.setOnKeyListener(r2)
            L_0x01ca:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.a.a():androidx.appcompat.app.c");
        }

        public final c b() {
            c a2 = a();
            a2.show();
            return a2;
        }
    }
}
