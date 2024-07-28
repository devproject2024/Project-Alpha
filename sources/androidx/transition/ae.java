package androidx.transition;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.os.Build;
import android.view.ViewGroup;
import androidx.transition.af;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;

final class ae {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4738a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Method f4739b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4740c;

    static ad a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new ac(viewGroup) : (ab) ag.c(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
            return;
        }
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 18) {
            if (af.f4741a == null) {
                af.AnonymousClass1 r0 = new LayoutTransition() {
                    public final boolean isChangingLayout(
/*
Method generation error in method: androidx.transition.af.1.isChangingLayout():boolean, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: androidx.transition.af.1.isChangingLayout():boolean, class status: UNLOADED
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
                };
                af.f4741a = r0;
                r0.setAnimator(2, (Animator) null);
                af.f4741a.setAnimator(0, (Animator) null);
                af.f4741a.setAnimator(1, (Animator) null);
                af.f4741a.setAnimator(3, (Animator) null);
                af.f4741a.setAnimator(4, (Animator) null);
            }
            if (z) {
                LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
                if (layoutTransition != null) {
                    if (layoutTransition.isRunning()) {
                        if (!af.f4745e) {
                            try {
                                Method declaredMethod = LayoutTransition.class.getDeclaredMethod(DirectFormItemType.CANCEL, new Class[0]);
                                af.f4744d = declaredMethod;
                                declaredMethod.setAccessible(true);
                            } catch (NoSuchMethodException unused) {
                            }
                            af.f4745e = true;
                        }
                        if (af.f4744d != null) {
                            try {
                                af.f4744d.invoke(layoutTransition, new Object[0]);
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                    }
                    if (layoutTransition != af.f4741a) {
                        viewGroup.setTag(R.id.transition_layout_save, layoutTransition);
                    }
                }
                viewGroup.setLayoutTransition(af.f4741a);
                return;
            }
            viewGroup.setLayoutTransition((LayoutTransition) null);
            if (!af.f4743c) {
                try {
                    Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                    af.f4742b = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused3) {
                }
                af.f4743c = true;
            }
            if (af.f4742b != null) {
                try {
                    boolean z3 = af.f4742b.getBoolean(viewGroup);
                    if (z3) {
                        try {
                            af.f4742b.setBoolean(viewGroup, false);
                        } catch (IllegalAccessException unused4) {
                        }
                    }
                    z2 = z3;
                } catch (IllegalAccessException unused5) {
                }
            }
            if (z2) {
                viewGroup.requestLayout();
            }
            LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
            if (layoutTransition2 != null) {
                viewGroup.setTag(R.id.transition_layout_save, (Object) null);
                viewGroup.setLayoutTransition(layoutTransition2);
            }
        } else if (f4738a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused6) {
                f4738a = false;
            }
        }
    }

    static int a(ViewGroup viewGroup, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i2);
        }
        if (!f4740c) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{Integer.TYPE, Integer.TYPE});
                f4739b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f4740c = true;
        }
        Method method = f4739b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i2)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i2;
    }
}
