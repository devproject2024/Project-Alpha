package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.a.g;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.core.h.u;
import androidx.core.widget.l;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.k;
import com.google.android.material.internal.q;
import com.google.android.material.k.i;
import com.google.android.material.k.m;
import com.google.android.material.k.p;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

public class FloatingActionButton extends VisibilityAwareImageButton implements CoordinatorLayout.a, t, l, com.google.android.material.f.a, p {

    /* renamed from: c  reason: collision with root package name */
    private static final int f36297c = R.style.Widget_Design_FloatingActionButton;

    /* renamed from: a  reason: collision with root package name */
    boolean f36298a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f36299b;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f36300d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f36301e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f36302f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f36303g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f36304h;

    /* renamed from: i  reason: collision with root package name */
    private int f36305i;
    private int j;
    private int k;
    /* access modifiers changed from: private */
    public int l;
    private int m;
    private final Rect n;
    private final h o;
    private final com.google.android.material.f.c p;
    private d q;

    public static abstract class a {
        public void a() {
        }

        public void a(FloatingActionButton floatingActionButton) {
        }
    }

    public void setBackgroundColor(int i2) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i2) {
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36297c), attributeSet, i2);
        this.f36299b = new Rect();
        this.n = new Rect();
        Context context2 = getContext();
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.FloatingActionButton, i2, f36297c, new int[0]);
        this.f36300d = com.google.android.material.h.c.a(context2, a2, R.styleable.FloatingActionButton_backgroundTint);
        this.f36301e = q.a(a2.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.f36304h = com.google.android.material.h.c.a(context2, a2, R.styleable.FloatingActionButton_rippleColor);
        this.j = a2.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.k = a2.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.f36305i = a2.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = a2.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = a2.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = a2.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f36298a = a2.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        this.m = a2.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
        com.google.android.material.a.h a3 = com.google.android.material.a.h.a(context2, a2, R.styleable.FloatingActionButton_showMotionSpec);
        com.google.android.material.a.h a4 = com.google.android.material.a.h.a(context2, a2, R.styleable.FloatingActionButton_hideMotionSpec);
        m a5 = m.a(context2, attributeSet, i2, f36297c, m.f36549a).a();
        boolean z = a2.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(a2.getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
        a2.recycle();
        this.o = new h(this);
        this.o.a(attributeSet, i2);
        this.p = new com.google.android.material.f.c(this);
        getImpl().a(a5);
        getImpl().a(this.f36300d, this.f36301e, this.f36304h, this.f36305i);
        getImpl().l = dimensionPixelSize;
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().c(dimension3);
        d impl = getImpl();
        int i3 = this.m;
        if (impl.p != i3) {
            impl.p = i3;
            impl.b();
        }
        getImpl().m = a3;
        getImpl().n = a4;
        getImpl().f36337g = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.l = (sizeDimension - this.m) / 2;
        getImpl().h();
        int min = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        setMeasuredDimension(this.f36299b.left + min + this.f36299b.right, min + this.f36299b.top + this.f36299b.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f36304h;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f36304h;
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f36304h != colorStateList) {
            this.f36304h = colorStateList;
            getImpl().a(this.f36304h);
        }
    }

    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public ColorStateList getBackgroundTintList() {
        return this.f36300d;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f36300d != colorStateList) {
            this.f36300d = colorStateList;
            d impl = getImpl();
            if (impl.f36333c != null) {
                impl.f36333c.setTintList(colorStateList);
            }
            if (impl.f36335e != null) {
                impl.f36335e.a(colorStateList);
            }
        }
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f36301e;
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f36301e != mode) {
            this.f36301e = mode;
            d impl = getImpl();
            if (impl.f36333c != null) {
                impl.f36333c.setTintMode(mode);
            }
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f36302f != colorStateList) {
            this.f36302f = colorStateList;
            d();
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.f36302f;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f36303g != mode) {
            this.f36303g = mode;
            d();
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f36303g;
    }

    private void d() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f36302f;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.e(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f36303g;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(f.a(colorForState, mode));
        }
    }

    public void setImageResource(int i2) {
        this.o.a(i2);
        d();
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().b();
            if (this.f36302f != null) {
                d();
            }
        }
    }

    public void setShapeAppearanceModel(m mVar) {
        getImpl().a(mVar);
    }

    public m getShapeAppearanceModel() {
        return (m) androidx.core.g.f.a(getImpl().f36332b);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f36337g) {
            getImpl().f36337g = z;
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public final void a(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public final void b(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    public final boolean a() {
        return this.p.f36271b;
    }

    public void setExpandedComponentIdHint(int i2) {
        this.p.f36272c = i2;
    }

    public int getExpandedComponentIdHint() {
        return this.p.f36272c;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f36298a != z) {
            this.f36298a = z;
            getImpl().g();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f36298a;
    }

    public void setSize(int i2) {
        this.k = 0;
        if (i2 != this.j) {
            this.j = i2;
            requestLayout();
        }
    }

    public int getSize() {
        return this.j;
    }

    private d.e a(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new d.e() {
            public final void a() {
                aVar.a();
            }

            public final void b() {
                aVar.a(FloatingActionButton.this);
            }
        };
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.k) {
            this.k = i2;
            requestLayout();
        }
    }

    public int getCustomSize() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        int i2 = this.j;
        while (true) {
            int i3 = this.k;
            if (i3 != 0) {
                return i3;
            }
            Resources resources = getResources();
            if (i2 == -1) {
                i2 = Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? 1 : 0;
            } else if (i2 != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            } else {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d impl = getImpl();
        if (impl.f36333c != null) {
            i.a((View) impl.z, impl.f36333c);
        }
        if (impl.j()) {
            ViewTreeObserver viewTreeObserver = impl.z.getViewTreeObserver();
            if (impl.B == null) {
                impl.B = new ViewTreeObserver.OnPreDrawListener() {
                    public final boolean onPreDraw(
/*
Method generation error in method: com.google.android.material.floatingactionbutton.d.5.onPreDraw():boolean, dex: classes2.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.google.android.material.floatingactionbutton.d.5.onPreDraw():boolean, class status: UNLOADED
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
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
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
            }
            viewTreeObserver.addOnPreDrawListener(impl.B);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.z.getViewTreeObserver();
        if (impl.B != null) {
            viewTreeObserver.removeOnPreDrawListener(impl.B);
            impl.B = null;
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().d();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        g<String, Bundle> gVar = extendableSavedState.f36713a;
        com.google.android.material.f.c cVar = this.p;
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", cVar.f36271b);
        bundle.putInt("expandedComponentIdHint", cVar.f36272c);
        gVar.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.f3245d);
        com.google.android.material.f.c cVar = this.p;
        Bundle bundle = (Bundle) androidx.core.g.f.a(extendableSavedState.f36713a.get("expandableWidgetHelper"));
        cVar.f36271b = bundle.getBoolean("expanded", false);
        cVar.f36272c = bundle.getInt("expandedComponentIdHint", 0);
        if (cVar.f36271b) {
            ViewParent parent = cVar.f36270a.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).a(cVar.f36270a);
            }
        }
    }

    @Deprecated
    public final boolean a(Rect rect) {
        if (!u.J(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        b(rect);
        return true;
    }

    public final void b(Rect rect) {
        rect.left += this.f36299b.left;
        rect.top += this.f36299b.top;
        rect.right -= this.f36299b.right;
        rect.bottom -= this.f36299b.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().f36336f;
    }

    private static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a(this.n) || this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i2);
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.d dVar) {
            super.onAttachedToLayoutParams(dVar);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f36308a;

        /* renamed from: b  reason: collision with root package name */
        private a f36309b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f36310c;

        public BaseBehavior() {
            this.f36310c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f36310c = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.d dVar) {
            if (dVar.f2610h == 0) {
                dVar.f2610h = 80;
            }
        }

        /* renamed from: a */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!a(view)) {
                return false;
            } else {
                b(view, floatingActionButton);
                return false;
            }
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).f2603a instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            if (this.f36310c && dVar.f2608f == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f36308a == null) {
                this.f36308a = new Rect();
            }
            Rect rect = this.f36308a;
            com.google.android.material.internal.b.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.f36309b, false);
                return true;
            }
            floatingActionButton.a(this.f36309b, false);
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.b(this.f36309b, false);
                return true;
            }
            floatingActionButton.a(this.f36309b, false);
            return true;
        }

        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            int i3;
            List<View> b2 = coordinatorLayout.b((View) floatingActionButton);
            int size = b2.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                View view = b2.get(i5);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.b(floatingActionButton, i2);
            Rect rect = floatingActionButton.f36299b;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin) {
                i3 = rect.right;
            } else {
                i3 = floatingActionButton.getLeft() <= dVar.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                i4 = rect.bottom;
            } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                i4 = -rect.top;
            }
            if (i4 != 0) {
                u.f((View) floatingActionButton, i4);
            }
            if (i3 == 0) {
                return true;
            }
            u.g((View) floatingActionButton, i3);
            return true;
        }

        /* renamed from: a */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f36299b;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().d(f2);
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().j;
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().k;
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().c(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        return getImpl().m;
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().m = hVar;
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(com.google.android.material.a.h.a(getContext(), i2));
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        return getImpl().n;
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        getImpl().n = hVar;
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(com.google.android.material.a.h.a(getContext(), i2));
    }

    public class c<T extends FloatingActionButton> implements d.C0605d {

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.material.a.k<T> f36313b;

        public c(com.google.android.material.a.k<T> kVar) {
            this.f36313b = kVar;
        }

        public final void a() {
            this.f36313b.a(FloatingActionButton.this);
        }

        public final void b() {
            this.f36313b.b(FloatingActionButton.this);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).f36313b.equals(this.f36313b);
        }

        public final int hashCode() {
            return this.f36313b.hashCode();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().e();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().e();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().e();
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().f();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().f();
    }

    public void setShadowPaddingEnabled(boolean z) {
        d impl = getImpl();
        impl.f36338h = z;
        impl.h();
    }

    public d getImpl() {
        d dVar;
        if (this.q == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                dVar = new e(this, new b());
            } else {
                dVar = new d(this, new b());
            }
            this.q = dVar;
        }
        return this.q;
    }

    class b implements com.google.android.material.j.b {
        b() {
        }

        public final void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.f36299b.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.l, i3 + FloatingActionButton.this.l, i4 + FloatingActionButton.this.l, i5 + FloatingActionButton.this.l);
        }

        public final void a(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        public final boolean a() {
            return FloatingActionButton.this.f36298a;
        }
    }

    public final void b() {
        a((a) null, true);
    }

    public final void c() {
        b((a) null, true);
    }
}
