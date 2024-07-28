package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.p;
import androidx.core.h.u;
import androidx.core.widget.i;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.k.h;
import com.google.android.material.k.m;
import java.util.Iterator;
import java.util.LinkedHashSet;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public class TextInputLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final int f36780e = R.style.Widget_Design_TextInputLayout;
    private final TextView A;
    private boolean B;
    private CharSequence C;
    private h D;
    private h E;
    private m F;
    private final int G;
    private int H;
    private final int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private final Rect O;
    private final Rect P;
    private final RectF Q;
    private Typeface R;
    private final CheckableImageButton S;
    private ColorStateList T;
    private boolean U;
    private PorterDuff.Mode V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    EditText f36781a;
    private int aA;
    private int aB;
    private int aC;
    private int aD;
    private boolean aE;
    private boolean aF;
    private ValueAnimator aG;
    private boolean aH;
    /* access modifiers changed from: private */
    public boolean aI;
    private Drawable aa;
    private int ab;
    private View.OnLongClickListener ac;
    private final LinkedHashSet<b> ad;
    private int ae;
    private final SparseArray<e> af;
    /* access modifiers changed from: private */
    public final CheckableImageButton ag;
    private final LinkedHashSet<c> ah;
    private ColorStateList ai;
    private boolean aj;
    private PorterDuff.Mode ak;
    private boolean al;
    private Drawable am;
    private int an;
    private Drawable ao;
    private View.OnLongClickListener ap;
    private View.OnLongClickListener aq;
    private final CheckableImageButton ar;
    private ColorStateList as;
    private ColorStateList at;
    private ColorStateList au;
    private int av;
    private int aw;
    private int ax;
    private ColorStateList ay;
    private int az;

    /* renamed from: b  reason: collision with root package name */
    boolean f36782b;

    /* renamed from: c  reason: collision with root package name */
    boolean f36783c;

    /* renamed from: d  reason: collision with root package name */
    final com.google.android.material.internal.a f36784d;

    /* renamed from: f  reason: collision with root package name */
    private final FrameLayout f36785f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f36786g;

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f36787h;

    /* renamed from: i  reason: collision with root package name */
    private final FrameLayout f36788i;
    private CharSequence j;
    private final f k;
    private int l;
    private boolean m;
    private TextView n;
    private int o;
    private int p;
    private CharSequence q;
    /* access modifiers changed from: private */
    public boolean r;
    private TextView s;
    private ColorStateList t;
    private int u;
    private ColorStateList v;
    private ColorStateList w;
    private CharSequence x;
    private final TextView y;
    private CharSequence z;

    public interface b {
        void a(TextInputLayout textInputLayout);
    }

    public interface c {
        void a(TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r21, android.util.AttributeSet r22, int r23) {
        /*
            r20 = this;
            r0 = r20
            r7 = r22
            r8 = r23
            int r1 = f36780e
            r2 = r21
            android.content.Context r1 = com.google.android.material.theme.a.a.a(r2, r7, r8, r1)
            r0.<init>(r1, r7, r8)
            com.google.android.material.textfield.f r1 = new com.google.android.material.textfield.f
            r1.<init>(r0)
            r0.k = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.O = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.P = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.Q = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.ad = r1
            r9 = 0
            r0.ae = r9
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r0.af = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.ah = r1
            com.google.android.material.internal.a r1 = new com.google.android.material.internal.a
            r1.<init>(r0)
            r0.f36784d = r1
            android.content.Context r10 = r20.getContext()
            r11 = 1
            r0.setOrientation(r11)
            r0.setWillNotDraw(r9)
            r0.setAddStatesFromChildren(r11)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r10)
            r0.f36785f = r1
            android.widget.FrameLayout r1 = r0.f36785f
            r1.setAddStatesFromChildren(r11)
            android.widget.FrameLayout r1 = r0.f36785f
            r0.addView(r1)
            android.widget.LinearLayout r1 = new android.widget.LinearLayout
            r1.<init>(r10)
            r0.f36786g = r1
            android.widget.LinearLayout r1 = r0.f36786g
            r1.setOrientation(r9)
            android.widget.LinearLayout r1 = r0.f36786g
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r12 = -2
            r13 = -1
            r3 = 8388611(0x800003, float:1.1754948E-38)
            r2.<init>(r12, r13, r3)
            r1.setLayoutParams(r2)
            android.widget.FrameLayout r1 = r0.f36785f
            android.widget.LinearLayout r2 = r0.f36786g
            r1.addView(r2)
            android.widget.LinearLayout r1 = new android.widget.LinearLayout
            r1.<init>(r10)
            r0.f36787h = r1
            android.widget.LinearLayout r1 = r0.f36787h
            r1.setOrientation(r9)
            android.widget.LinearLayout r1 = r0.f36787h
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 8388613(0x800005, float:1.175495E-38)
            r2.<init>(r12, r13, r3)
            r1.setLayoutParams(r2)
            android.widget.FrameLayout r1 = r0.f36785f
            android.widget.LinearLayout r2 = r0.f36787h
            r1.addView(r2)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r10)
            r0.f36788i = r1
            android.widget.FrameLayout r1 = r0.f36788i
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r12, r13)
            r1.setLayoutParams(r2)
            com.google.android.material.internal.a r1 = r0.f36784d
            android.animation.TimeInterpolator r2 = com.google.android.material.a.a.f35800a
            r1.a((android.animation.TimeInterpolator) r2)
            com.google.android.material.internal.a r1 = r0.f36784d
            android.animation.TimeInterpolator r2 = com.google.android.material.a.a.f35800a
            r1.j = r2
            r1.c()
            com.google.android.material.internal.a r1 = r0.f36784d
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.b((int) r2)
            int[] r3 = com.google.android.material.R.styleable.TextInputLayout
            int r5 = f36780e
            r1 = 5
            int[] r6 = new int[r1]
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            r6[r9] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            r6[r11] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            r14 = 2
            r6[r14] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            r15 = 3
            r6[r15] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            r2 = 4
            r6[r2] = r1
            r1 = r10
            r2 = r22
            r4 = r23
            androidx.appcompat.widget.ac r1 = com.google.android.material.internal.k.b(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintEnabled
            boolean r2 = r1.a((int) r2, (boolean) r11)
            r0.B = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_hint
            java.lang.CharSequence r2 = r1.c(r2)
            r0.setHint(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintAnimationEnabled
            boolean r2 = r1.a((int) r2, (boolean) r11)
            r0.aF = r2
            int r2 = f36780e
            com.google.android.material.k.m$a r2 = com.google.android.material.k.m.a((android.content.Context) r10, (android.util.AttributeSet) r7, (int) r8, (int) r2)
            com.google.android.material.k.m r2 = r2.a()
            r0.F = r2
            android.content.res.Resources r2 = r10.getResources()
            int r3 = com.google.android.material.R.dimen.mtrl_textinput_box_label_cutout_padding
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.G = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCollapsedPaddingTop
            int r2 = r1.d(r2, r9)
            r0.I = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r3 = r10.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_default
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.e(r2, r3)
            r0.K = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r3 = r10.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_focused
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.e(r2, r3)
            r0.L = r2
            int r2 = r0.K
            r0.J = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopStart
            float r2 = r1.f(r2)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopEnd
            float r3 = r1.f(r3)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomEnd
            float r4 = r1.f(r4)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomStart
            float r5 = r1.f(r5)
            com.google.android.material.k.m r6 = r0.F
            com.google.android.material.k.m$a r6 = r6.b()
            r7 = 0
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x0184
            r6.b((float) r2)
        L_0x0184:
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x018b
            r6.c((float) r3)
        L_0x018b:
            int r2 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0192
            r6.d((float) r4)
        L_0x0192:
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0199
            r6.e((float) r5)
        L_0x0199:
            com.google.android.material.k.m r2 = r6.a()
            r0.F = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r2 = com.google.android.material.h.c.a((android.content.Context) r10, (androidx.appcompat.widget.ac) r1, (int) r2)
            if (r2 == 0) goto L_0x01fd
            int r3 = r2.getDefaultColor()
            r0.az = r3
            int r3 = r0.az
            r0.N = r3
            boolean r3 = r2.isStateful()
            r4 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r3 == 0) goto L_0x01db
            int[] r3 = new int[r11]
            r3[r9] = r4
            int r3 = r2.getColorForState(r3, r13)
            r0.aA = r3
            int[] r3 = new int[r14]
            r3 = {16842908, 16842910} // fill-array
            int r3 = r2.getColorForState(r3, r13)
            r0.aB = r3
            int[] r3 = new int[r14]
            r3 = {16843623, 16842910} // fill-array
            int r2 = r2.getColorForState(r3, r13)
            r0.aC = r2
            goto L_0x0207
        L_0x01db:
            int r2 = r0.az
            r0.aB = r2
            int r2 = com.google.android.material.R.color.mtrl_filled_background_color
            android.content.res.ColorStateList r2 = androidx.appcompat.a.a.a.a(r10, r2)
            int[] r3 = new int[r11]
            r3[r9] = r4
            int r3 = r2.getColorForState(r3, r13)
            r0.aA = r3
            int[] r3 = new int[r11]
            r4 = 16843623(0x1010367, float:2.3696E-38)
            r3[r9] = r4
            int r2 = r2.getColorForState(r3, r13)
            r0.aC = r2
            goto L_0x0207
        L_0x01fd:
            r0.N = r9
            r0.az = r9
            r0.aA = r9
            r0.aB = r9
            r0.aC = r9
        L_0x0207:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0219
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.au = r2
            r0.at = r2
        L_0x0219:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r2 = com.google.android.material.h.c.a((android.content.Context) r10, (androidx.appcompat.widget.ac) r1, (int) r2)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            int r3 = r1.b(r3, r9)
            r0.ax = r3
            int r3 = com.google.android.material.R.color.mtrl_textinput_default_box_stroke_color
            int r3 = androidx.core.content.b.c(r10, r3)
            r0.av = r3
            int r3 = com.google.android.material.R.color.mtrl_textinput_disabled_color
            int r3 = androidx.core.content.b.c(r10, r3)
            r0.aD = r3
            int r3 = com.google.android.material.R.color.mtrl_textinput_hovered_box_stroke_color
            int r3 = androidx.core.content.b.c(r10, r3)
            r0.aw = r3
            if (r2 == 0) goto L_0x0244
            r0.setBoxStrokeColorStateList(r2)
        L_0x0244:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0255
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            android.content.res.ColorStateList r2 = com.google.android.material.h.c.a((android.content.Context) r10, (androidx.appcompat.widget.ac) r1, (int) r2)
            r0.setBoxStrokeErrorColor(r2)
        L_0x0255:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            int r2 = r1.g(r2, r13)
            if (r2 == r13) goto L_0x0266
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            int r2 = r1.g(r2, r9)
            r0.setHintTextAppearance(r2)
        L_0x0266:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            int r2 = r1.g(r2, r9)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorContentDescription
            java.lang.CharSequence r3 = r1.c(r3)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorEnabled
            boolean r4 = r1.a((int) r4, (boolean) r9)
            android.content.Context r5 = r20.getContext()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            int r6 = com.google.android.material.R.layout.design_text_input_end_icon
            android.widget.LinearLayout r7 = r0.f36787h
            android.view.View r5 = r5.inflate(r6, r7, r9)
            com.google.android.material.internal.CheckableImageButton r5 = (com.google.android.material.internal.CheckableImageButton) r5
            r0.ar = r5
            com.google.android.material.internal.CheckableImageButton r5 = r0.ar
            r6 = 8
            r5.setVisibility(r6)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable
            boolean r5 = r1.g(r5)
            if (r5 == 0) goto L_0x02a4
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable
            android.graphics.drawable.Drawable r5 = r1.a(r5)
            r0.setErrorIconDrawable((android.graphics.drawable.Drawable) r5)
        L_0x02a4:
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint
            boolean r5 = r1.g(r5)
            if (r5 == 0) goto L_0x02b5
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint
            android.content.res.ColorStateList r5 = com.google.android.material.h.c.a((android.content.Context) r10, (androidx.appcompat.widget.ac) r1, (int) r5)
            r0.setErrorIconTintList(r5)
        L_0x02b5:
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode
            boolean r5 = r1.g(r5)
            r7 = 0
            if (r5 == 0) goto L_0x02cb
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode
            int r5 = r1.a((int) r5, (int) r13)
            android.graphics.PorterDuff$Mode r5 = com.google.android.material.internal.q.a((int) r5, (android.graphics.PorterDuff.Mode) r7)
            r0.setErrorIconTintMode(r5)
        L_0x02cb:
            com.google.android.material.internal.CheckableImageButton r5 = r0.ar
            android.content.res.Resources r8 = r20.getResources()
            int r12 = com.google.android.material.R.string.error_icon_content_description
            java.lang.CharSequence r8 = r8.getText(r12)
            r5.setContentDescription(r8)
            com.google.android.material.internal.CheckableImageButton r5 = r0.ar
            androidx.core.h.u.c((android.view.View) r5, (int) r14)
            com.google.android.material.internal.CheckableImageButton r5 = r0.ar
            r5.setClickable(r9)
            com.google.android.material.internal.CheckableImageButton r5 = r0.ar
            r5.setPressable(r9)
            com.google.android.material.internal.CheckableImageButton r5 = r0.ar
            r5.setFocusable(r9)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            int r5 = r1.g(r5, r9)
            int r8 = com.google.android.material.R.styleable.TextInputLayout_helperTextEnabled
            boolean r8 = r1.a((int) r8, (boolean) r9)
            int r12 = com.google.android.material.R.styleable.TextInputLayout_helperText
            java.lang.CharSequence r12 = r1.c(r12)
            int r15 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextAppearance
            int r15 = r1.g(r15, r9)
            int r14 = com.google.android.material.R.styleable.TextInputLayout_placeholderText
            java.lang.CharSequence r14 = r1.c(r14)
            int r11 = com.google.android.material.R.styleable.TextInputLayout_prefixTextAppearance
            int r11 = r1.g(r11, r9)
            int r7 = com.google.android.material.R.styleable.TextInputLayout_prefixText
            java.lang.CharSequence r7 = r1.c(r7)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_suffixTextAppearance
            int r6 = r1.g(r6, r9)
            int r13 = com.google.android.material.R.styleable.TextInputLayout_suffixText
            java.lang.CharSequence r13 = r1.c(r13)
            r16 = r6
            int r6 = com.google.android.material.R.styleable.TextInputLayout_counterEnabled
            boolean r6 = r1.a((int) r6, (boolean) r9)
            int r9 = com.google.android.material.R.styleable.TextInputLayout_counterMaxLength
            r17 = r6
            r6 = -1
            int r9 = r1.a((int) r9, (int) r6)
            r0.setCounterMaxLength(r9)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            r9 = 0
            int r6 = r1.g(r6, r9)
            r0.p = r6
            int r6 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            int r6 = r1.g(r6, r9)
            r0.o = r6
            android.content.Context r6 = r20.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            r18 = r13
            int r13 = com.google.android.material.R.layout.design_text_input_start_icon
            r19 = r11
            android.widget.LinearLayout r11 = r0.f36786g
            android.view.View r6 = r6.inflate(r13, r11, r9)
            com.google.android.material.internal.CheckableImageButton r6 = (com.google.android.material.internal.CheckableImageButton) r6
            r0.S = r6
            com.google.android.material.internal.CheckableImageButton r6 = r0.S
            r9 = 8
            r6.setVisibility(r9)
            r6 = 0
            r0.setStartIconOnClickListener(r6)
            r0.setStartIconOnLongClickListener(r6)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconDrawable
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x039b
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconDrawable
            android.graphics.drawable.Drawable r6 = r1.a(r6)
            r0.setStartIconDrawable((android.graphics.drawable.Drawable) r6)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconContentDescription
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x0391
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconContentDescription
            java.lang.CharSequence r6 = r1.c(r6)
            r0.setStartIconContentDescription((java.lang.CharSequence) r6)
        L_0x0391:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconCheckable
            r9 = 1
            boolean r6 = r1.a((int) r6, (boolean) r9)
            r0.setStartIconCheckable(r6)
        L_0x039b:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconTint
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x03ac
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconTint
            android.content.res.ColorStateList r6 = com.google.android.material.h.c.a((android.content.Context) r10, (androidx.appcompat.widget.ac) r1, (int) r6)
            r0.setStartIconTintList(r6)
        L_0x03ac:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconTintMode
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x03c3
            int r6 = com.google.android.material.R.styleable.TextInputLayout_startIconTintMode
            r9 = -1
            int r6 = r1.a((int) r6, (int) r9)
            r9 = 0
            android.graphics.PorterDuff$Mode r6 = com.google.android.material.internal.q.a((int) r6, (android.graphics.PorterDuff.Mode) r9)
            r0.setStartIconTintMode(r6)
        L_0x03c3:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundMode
            r9 = 0
            int r6 = r1.a((int) r6, (int) r9)
            r0.setBoxBackgroundMode(r6)
            android.content.Context r6 = r20.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r11 = com.google.android.material.R.layout.design_text_input_end_icon
            android.widget.FrameLayout r13 = r0.f36788i
            android.view.View r6 = r6.inflate(r11, r13, r9)
            com.google.android.material.internal.CheckableImageButton r6 = (com.google.android.material.internal.CheckableImageButton) r6
            r0.ag = r6
            android.widget.FrameLayout r6 = r0.f36788i
            com.google.android.material.internal.CheckableImageButton r9 = r0.ag
            r6.addView(r9)
            com.google.android.material.internal.CheckableImageButton r6 = r0.ag
            r9 = 8
            r6.setVisibility(r9)
            android.util.SparseArray<com.google.android.material.textfield.e> r6 = r0.af
            com.google.android.material.textfield.b r9 = new com.google.android.material.textfield.b
            r9.<init>(r0)
            r11 = -1
            r6.append(r11, r9)
            android.util.SparseArray<com.google.android.material.textfield.e> r6 = r0.af
            com.google.android.material.textfield.g r9 = new com.google.android.material.textfield.g
            r9.<init>(r0)
            r11 = 0
            r6.append(r11, r9)
            android.util.SparseArray<com.google.android.material.textfield.e> r6 = r0.af
            com.google.android.material.textfield.h r9 = new com.google.android.material.textfield.h
            r9.<init>(r0)
            r11 = 1
            r6.append(r11, r9)
            android.util.SparseArray<com.google.android.material.textfield.e> r6 = r0.af
            com.google.android.material.textfield.a r9 = new com.google.android.material.textfield.a
            r9.<init>(r0)
            r11 = 2
            r6.append(r11, r9)
            android.util.SparseArray<com.google.android.material.textfield.e> r6 = r0.af
            com.google.android.material.textfield.d r9 = new com.google.android.material.textfield.d
            r9.<init>(r0)
            r11 = 3
            r6.append(r11, r9)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconMode
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x0465
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconMode
            r9 = 0
            int r6 = r1.a((int) r6, (int) r9)
            r0.setEndIconMode(r6)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconDrawable
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x0449
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconDrawable
            android.graphics.drawable.Drawable r6 = r1.a(r6)
            r0.setEndIconDrawable((android.graphics.drawable.Drawable) r6)
        L_0x0449:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x045a
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription
            java.lang.CharSequence r6 = r1.c(r6)
            r0.setEndIconContentDescription((java.lang.CharSequence) r6)
        L_0x045a:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconCheckable
            r9 = 1
            boolean r6 = r1.a((int) r6, (boolean) r9)
            r0.setEndIconCheckable(r6)
            goto L_0x04b1
        L_0x0465:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x04b1
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            r9 = 0
            boolean r6 = r1.a((int) r6, (boolean) r9)
            r0.setEndIconMode(r6)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleDrawable
            android.graphics.drawable.Drawable r6 = r1.a(r6)
            r0.setEndIconDrawable((android.graphics.drawable.Drawable) r6)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleContentDescription
            java.lang.CharSequence r6 = r1.c(r6)
            r0.setEndIconContentDescription((java.lang.CharSequence) r6)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x049a
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint
            android.content.res.ColorStateList r6 = com.google.android.material.h.c.a((android.content.Context) r10, (androidx.appcompat.widget.ac) r1, (int) r6)
            r0.setEndIconTintList(r6)
        L_0x049a:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x04b1
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode
            r9 = -1
            int r6 = r1.a((int) r6, (int) r9)
            r9 = 0
            android.graphics.PorterDuff$Mode r6 = com.google.android.material.internal.q.a((int) r6, (android.graphics.PorterDuff.Mode) r9)
            r0.setEndIconTintMode(r6)
        L_0x04b1:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r6 = r1.g(r6)
            if (r6 != 0) goto L_0x04e1
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconTint
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x04ca
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconTint
            android.content.res.ColorStateList r6 = com.google.android.material.h.c.a((android.content.Context) r10, (androidx.appcompat.widget.ac) r1, (int) r6)
            r0.setEndIconTintList(r6)
        L_0x04ca:
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode
            boolean r6 = r1.g(r6)
            if (r6 == 0) goto L_0x04e1
            int r6 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode
            r9 = -1
            int r6 = r1.a((int) r6, (int) r9)
            r9 = 0
            android.graphics.PorterDuff$Mode r6 = com.google.android.material.internal.q.a((int) r6, (android.graphics.PorterDuff.Mode) r9)
            r0.setEndIconTintMode(r6)
        L_0x04e1:
            androidx.appcompat.widget.AppCompatTextView r6 = new androidx.appcompat.widget.AppCompatTextView
            r6.<init>(r10)
            r0.y = r6
            android.widget.TextView r6 = r0.y
            int r9 = com.google.android.material.R.id.textinput_prefix_text
            r6.setId(r9)
            android.widget.TextView r6 = r0.y
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r11 = -2
            r9.<init>(r11, r11)
            r6.setLayoutParams(r9)
            android.widget.TextView r6 = r0.y
            androidx.core.h.u.l(r6)
            android.widget.LinearLayout r6 = r0.f36786g
            com.google.android.material.internal.CheckableImageButton r9 = r0.S
            r6.addView(r9)
            android.widget.LinearLayout r6 = r0.f36786g
            android.widget.TextView r9 = r0.y
            r6.addView(r9)
            androidx.appcompat.widget.AppCompatTextView r6 = new androidx.appcompat.widget.AppCompatTextView
            r6.<init>(r10)
            r0.A = r6
            android.widget.TextView r6 = r0.A
            int r9 = com.google.android.material.R.id.textinput_suffix_text
            r6.setId(r9)
            android.widget.TextView r6 = r0.A
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r10 = 80
            r11 = -2
            r9.<init>(r11, r11, r10)
            r6.setLayoutParams(r9)
            android.widget.TextView r6 = r0.A
            androidx.core.h.u.l(r6)
            android.widget.LinearLayout r6 = r0.f36787h
            android.widget.TextView r9 = r0.A
            r6.addView(r9)
            android.widget.LinearLayout r6 = r0.f36787h
            com.google.android.material.internal.CheckableImageButton r9 = r0.ar
            r6.addView(r9)
            android.widget.LinearLayout r6 = r0.f36787h
            android.widget.FrameLayout r9 = r0.f36788i
            r6.addView(r9)
            r0.setHelperTextEnabled(r8)
            r0.setHelperText(r12)
            r0.setHelperTextTextAppearance(r5)
            r0.setErrorEnabled(r4)
            r0.setErrorTextAppearance(r2)
            r0.setErrorContentDescription(r3)
            int r2 = r0.p
            r0.setCounterTextAppearance(r2)
            int r2 = r0.o
            r0.setCounterOverflowTextAppearance(r2)
            r0.setPlaceholderText(r14)
            r0.setPlaceholderTextAppearance(r15)
            r0.setPrefixText(r7)
            r2 = r19
            r0.setPrefixTextAppearance(r2)
            r2 = r18
            r0.setSuffixText(r2)
            r2 = r16
            r0.setSuffixTextAppearance(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0587
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setErrorTextColor(r2)
        L_0x0587:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0598
            int r2 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setHelperTextColor(r2)
        L_0x0598:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05a9
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setHintTextColor(r2)
        L_0x05a9:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05ba
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setCounterTextColor(r2)
        L_0x05ba:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05cb
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setCounterOverflowTextColor(r2)
        L_0x05cb:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05dc
            int r2 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setPlaceholderTextColor(r2)
        L_0x05dc:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_prefixTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05ed
            int r2 = com.google.android.material.R.styleable.TextInputLayout_prefixTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setPrefixTextColor(r2)
        L_0x05ed:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05fe
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setSuffixTextColor(r2)
        L_0x05fe:
            r2 = r17
            r0.setCounterEnabled(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_enabled
            r3 = 1
            boolean r2 = r1.a((int) r2, (boolean) r3)
            r0.setEnabled(r2)
            android.content.res.TypedArray r1 = r1.f1669a
            r1.recycle()
            r1 = 2
            androidx.core.h.u.c((android.view.View) r0, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f36785f.addView(view, layoutParams2);
            this.f36785f.setLayoutParams(layoutParams);
            h();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public h getBoxBackground() {
        int i2 = this.H;
        if (i2 == 1 || i2 == 2) {
            return this.D;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.H) {
            this.H = i2;
            if (this.f36781a != null) {
                d();
            }
        }
    }

    public int getBoxBackgroundMode() {
        return this.H;
    }

    private void d() {
        e();
        f();
        c();
        if (this.H != 0) {
            h();
        }
    }

    private void e() {
        int i2 = this.H;
        if (i2 == 0) {
            this.D = null;
            this.E = null;
        } else if (i2 == 1) {
            this.D = new h(this.F);
            this.E = new h();
        } else if (i2 == 2) {
            if (!this.B || (this.D instanceof c)) {
                this.D = new h(this.F);
            } else {
                this.D = new c(this.F);
            }
            this.E = null;
        } else {
            throw new IllegalArgumentException(this.H + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private void f() {
        if (g()) {
            u.a((View) this.f36781a, (Drawable) this.D);
        }
    }

    private boolean g() {
        EditText editText = this.f36781a;
        return (editText == null || this.D == null || editText.getBackground() != null || this.H == 0) ? false : true;
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidth(int i2) {
        this.K = i2;
        c();
    }

    public int getBoxStrokeWidth() {
        return this.K;
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.L = i2;
        c();
    }

    public int getBoxStrokeWidthFocused() {
        return this.L;
    }

    public void setBoxStrokeColor(int i2) {
        if (this.ax != i2) {
            this.ax = i2;
            c();
        }
    }

    public int getBoxStrokeColor() {
        return this.ax;
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.av = colorStateList.getDefaultColor();
            this.aD = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.aw = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.ax = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.ax != colorStateList.getDefaultColor()) {
            this.ax = colorStateList.getDefaultColor();
        }
        c();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.ay != colorStateList) {
            this.ay = colorStateList;
            c();
        }
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.ay;
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(androidx.core.content.b.c(getContext(), i2));
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.N != i2) {
            this.N = i2;
            this.az = i2;
            this.aB = i2;
            this.aC = i2;
            u();
        }
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        this.az = colorStateList.getDefaultColor();
        this.N = this.az;
        this.aA = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.aB = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.aC = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        u();
    }

    public int getBoxBackgroundColor() {
        return this.N;
    }

    public void setBoxCornerRadiiResources(int i2, int i3, int i4, int i5) {
        setBoxCornerRadii(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i4));
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        h hVar = this.D;
        if (hVar == null || hVar.m() != f2 || this.D.n() != f3 || this.D.p() != f5 || this.D.o() != f4) {
            this.F = this.F.b().b(f2).c(f3).d(f5).e(f4).a();
            u();
        }
    }

    public float getBoxCornerRadiusTopStart() {
        return this.D.m();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.D.n();
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.D.o();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.D.p();
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.R) {
            this.R = typeface;
            this.f36784d.c(typeface);
            f fVar = this.k;
            if (typeface != fVar.q) {
                fVar.q = typeface;
                f.a(fVar.f36843h, typeface);
                f.a(fVar.n, typeface);
            }
            TextView textView = this.n;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.R;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.j == null || (editText = this.f36781a) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z2 = this.f36783c;
        this.f36783c = false;
        CharSequence hint = editText.getHint();
        this.f36781a.setHint(this.j);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.f36781a.setHint(hint);
            this.f36783c = z2;
        }
    }

    private void setEditText(EditText editText) {
        if (this.f36781a == null) {
            this.f36781a = editText;
            d();
            setTextInputAccessibilityDelegate(new a(this));
            this.f36784d.c(this.f36781a.getTypeface());
            this.f36784d.a(this.f36781a.getTextSize());
            int gravity = this.f36781a.getGravity();
            this.f36784d.b((gravity & -113) | 48);
            this.f36784d.a(gravity);
            this.f36781a.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.a(!textInputLayout.aI, false);
                    if (TextInputLayout.this.f36782b) {
                        TextInputLayout.this.a(editable.length());
                    }
                    if (TextInputLayout.this.r) {
                        TextInputLayout.this.b(editable.length());
                    }
                }
            });
            if (this.at == null) {
                this.at = this.f36781a.getHintTextColors();
            }
            if (this.B) {
                if (TextUtils.isEmpty(this.C)) {
                    this.j = this.f36781a.getHint();
                    setHint(this.j);
                    this.f36781a.setHint((CharSequence) null);
                }
                this.f36783c = true;
            }
            if (this.n != null) {
                a(this.f36781a.getText().length());
            }
            a();
            this.k.c();
            this.f36786g.bringToFront();
            this.f36787h.bringToFront();
            this.f36788i.bringToFront();
            this.ar.bringToFront();
            z();
            n();
            p();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void h() {
        if (this.H != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f36785f.getLayoutParams();
            int r2 = r();
            if (r2 != layoutParams.topMargin) {
                layoutParams.topMargin = r2;
                this.f36785f.requestLayout();
            }
        }
    }

    public int getBaseline() {
        EditText editText = this.f36781a;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + r();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f36781a;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f36781a;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean d2 = this.k.d();
        ColorStateList colorStateList2 = this.at;
        if (colorStateList2 != null) {
            this.f36784d.a(colorStateList2);
            this.f36784d.b(this.at);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.at;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.aD) : this.aD;
            this.f36784d.a(ColorStateList.valueOf(colorForState));
            this.f36784d.b(ColorStateList.valueOf(colorForState));
        } else if (d2) {
            this.f36784d.a(this.k.f());
        } else if (this.m && (textView = this.n) != null) {
            this.f36784d.a(textView.getTextColors());
        } else if (z5 && (colorStateList = this.au) != null) {
            this.f36784d.a(colorStateList);
        }
        if (z4 || (isEnabled() && (z5 || d2))) {
            if (z3 || this.aE) {
                b(z2);
            }
        } else if (z3 || !this.aE) {
            c(z2);
        }
    }

    public EditText getEditText() {
        return this.f36781a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.B) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(EmiUtil.EMI_PLAN_REQUEST_CODE);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.C)) {
            this.C = charSequence;
            this.f36784d.a(charSequence);
            if (!this.aE) {
                H();
            }
        }
    }

    public CharSequence getHint() {
        if (this.B) {
            return this.C;
        }
        return null;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.B) {
            this.B = z2;
            if (!this.B) {
                this.f36783c = false;
                if (!TextUtils.isEmpty(this.C) && TextUtils.isEmpty(this.f36781a.getHint())) {
                    this.f36781a.setHint(this.C);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.f36781a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.C)) {
                        setHint(hint);
                    }
                    this.f36781a.setHint((CharSequence) null);
                }
                this.f36783c = true;
            }
            if (this.f36781a != null) {
                h();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.f36784d.c(i2);
        this.au = this.f36784d.f36436e;
        if (this.f36781a != null) {
            a(false, false);
            h();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.au != colorStateList) {
            if (this.at == null) {
                this.f36784d.a(colorStateList);
            }
            this.au = colorStateList;
            if (this.f36781a != null) {
                a(false, false);
            }
        }
    }

    public ColorStateList getHintTextColor() {
        return this.au;
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.at = colorStateList;
        this.au = colorStateList;
        if (this.f36781a != null) {
            a(false, false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.at;
    }

    public void setErrorEnabled(boolean z2) {
        f fVar = this.k;
        if (fVar.f36842g != z2) {
            fVar.b();
            if (z2) {
                fVar.f36843h = new AppCompatTextView(fVar.f36836a);
                fVar.f36843h.setId(R.id.textinput_error);
                if (Build.VERSION.SDK_INT >= 17) {
                    fVar.f36843h.setTextAlignment(5);
                }
                if (fVar.q != null) {
                    fVar.f36843h.setTypeface(fVar.q);
                }
                fVar.a(fVar.j);
                fVar.a(fVar.k);
                fVar.a(fVar.f36844i);
                fVar.f36843h.setVisibility(4);
                u.l(fVar.f36843h);
                fVar.a(fVar.f36843h, 0);
            } else {
                fVar.a();
                fVar.b(fVar.f36843h, 0);
                fVar.f36843h = null;
                fVar.f36837b.a();
                fVar.f36837b.c();
            }
            fVar.f36842g = z2;
        }
    }

    public void setErrorTextAppearance(int i2) {
        this.k.a(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.k.a(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.k.e();
    }

    public void setHelperTextTextAppearance(int i2) {
        this.k.b(i2);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.k.b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        f fVar = this.k;
        if (fVar.m != z2) {
            fVar.b();
            if (z2) {
                fVar.n = new AppCompatTextView(fVar.f36836a);
                fVar.n.setId(R.id.textinput_helper_text);
                if (Build.VERSION.SDK_INT >= 17) {
                    fVar.n.setTextAlignment(5);
                }
                if (fVar.q != null) {
                    fVar.n.setTypeface(fVar.q);
                }
                fVar.n.setVisibility(4);
                u.l(fVar.n);
                fVar.b(fVar.o);
                fVar.b(fVar.p);
                fVar.a(fVar.n, 1);
            } else {
                fVar.b();
                if (fVar.f36839d == 2) {
                    fVar.f36840e = 0;
                }
                fVar.a(fVar.f36839d, fVar.f36840e, fVar.a(fVar.n, (CharSequence) null));
                fVar.b(fVar.n, 1);
                fVar.n = null;
                fVar.f36837b.a();
                fVar.f36837b.c();
            }
            fVar.m = z2;
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.k.m) {
                setHelperTextEnabled(true);
            }
            f fVar = this.k;
            fVar.b();
            fVar.l = charSequence;
            fVar.n.setText(charSequence);
            if (fVar.f36839d != 2) {
                fVar.f36840e = 2;
            }
            fVar.a(fVar.f36839d, fVar.f36840e, fVar.a(fVar.n, charSequence));
        } else if (this.k.m) {
            setHelperTextEnabled(false);
        }
    }

    public int getHelperTextCurrentTextColor() {
        f fVar = this.k;
        if (fVar.n != null) {
            return fVar.n.getCurrentTextColor();
        }
        return -1;
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.k.a(charSequence);
    }

    public CharSequence getErrorContentDescription() {
        return this.k.f36844i;
    }

    public void setError(CharSequence charSequence) {
        if (!this.k.f36842g) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            f fVar = this.k;
            fVar.b();
            fVar.f36841f = charSequence;
            fVar.f36843h.setText(charSequence);
            if (fVar.f36839d != 1) {
                fVar.f36840e = 1;
            }
            fVar.a(fVar.f36839d, fVar.f36840e, fVar.a(fVar.f36843h, charSequence));
            return;
        }
        this.k.a();
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.ar.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.k.f36842g);
    }

    public Drawable getErrorIconDrawable() {
        return this.ar.getDrawable();
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.as = colorStateList;
        Drawable drawable = this.ar.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.f(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        if (this.ar.getDrawable() != drawable) {
            this.ar.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.ar.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.f(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
        if (this.ar.getDrawable() != drawable) {
            this.ar.setImageDrawable(drawable);
        }
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f36782b != z2) {
            if (z2) {
                this.n = new AppCompatTextView(getContext());
                this.n.setId(R.id.textinput_counter);
                Typeface typeface = this.R;
                if (typeface != null) {
                    this.n.setTypeface(typeface);
                }
                this.n.setMaxLines(1);
                this.k.a(this.n, 2);
                androidx.core.h.h.a((ViewGroup.MarginLayoutParams) this.n.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                q();
                i();
            } else {
                this.k.b(this.n, 2);
                this.n = null;
            }
            this.f36782b = z2;
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.p != i2) {
            this.p = i2;
            q();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            q();
        }
    }

    public ColorStateList getCounterTextColor() {
        return this.v;
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.o != i2) {
            this.o = i2;
            q();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.w != colorStateList) {
            this.w = colorStateList;
            q();
        }
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.v;
    }

    public void setCounterMaxLength(int i2) {
        if (this.l != i2) {
            if (i2 > 0) {
                this.l = i2;
            } else {
                this.l = -1;
            }
            if (this.f36782b) {
                i();
            }
        }
    }

    private void i() {
        if (this.n != null) {
            EditText editText = this.f36781a;
            a(editText == null ? 0 : editText.getText().length());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        boolean z2 = this.m;
        int i3 = this.l;
        if (i3 == -1) {
            this.n.setText(String.valueOf(i2));
            this.n.setContentDescription((CharSequence) null);
            this.m = false;
        } else {
            this.m = i2 > i3;
            a(getContext(), this.n, i2, this.l, this.m);
            if (z2 != this.m) {
                q();
            }
            this.n.setText(androidx.core.f.a.a().a(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.l)})));
        }
        if (this.f36781a != null && z2 != this.m) {
            a(false, false);
            c();
            a();
        }
    }

    private static void a(Context context, TextView textView, int i2, int i3, boolean z2) {
        textView.setContentDescription(context.getString(z2 ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (!this.r || !TextUtils.isEmpty(charSequence)) {
            if (!this.r) {
                setPlaceholderTextEnabled(true);
            }
            this.q = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        j();
    }

    public CharSequence getPlaceholderText() {
        if (this.r) {
            return this.q;
        }
        return null;
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.r != z2) {
            if (z2) {
                this.s = new AppCompatTextView(getContext());
                this.s.setId(R.id.textinput_placeholder);
                u.l(this.s);
                setPlaceholderTextAppearance(this.u);
                setPlaceholderTextColor(this.t);
                TextView textView = this.s;
                if (textView != null) {
                    this.f36785f.addView(textView);
                    this.s.setVisibility(0);
                }
            } else {
                TextView textView2 = this.s;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                this.s = null;
            }
            this.r = z2;
        }
    }

    private void j() {
        EditText editText = this.f36781a;
        b(editText == null ? 0 : editText.getText().length());
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 != 0 || this.aE) {
            l();
        } else {
            k();
        }
    }

    private void k() {
        TextView textView = this.s;
        if (textView != null && this.r) {
            textView.setText(this.q);
            this.s.setVisibility(0);
            this.s.bringToFront();
        }
    }

    private void l() {
        TextView textView = this.s;
        if (textView != null && this.r) {
            textView.setText((CharSequence) null);
            this.s.setVisibility(4);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            TextView textView = this.s;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.t;
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.u = i2;
        TextView textView = this.s;
        if (textView != null) {
            i.a(textView, i2);
        }
    }

    public int getPlaceholderTextAppearance() {
        return this.u;
    }

    public void setPrefixText(CharSequence charSequence) {
        this.x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.y.setText(charSequence);
        m();
    }

    public CharSequence getPrefixText() {
        return this.x;
    }

    public TextView getPrefixTextView() {
        return this.y;
    }

    private void m() {
        this.y.setVisibility((this.x == null || this.aE) ? 8 : 0);
        D();
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public ColorStateList getPrefixTextColor() {
        return this.y.getTextColors();
    }

    public void setPrefixTextAppearance(int i2) {
        i.a(this.y, i2);
    }

    private void n() {
        if (this.f36781a != null) {
            u.b(this.y, y() ? 0 : u.m(this.f36781a), this.f36781a.getCompoundPaddingTop(), 0, this.f36781a.getCompoundPaddingBottom());
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.z = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.A.setText(charSequence);
        o();
    }

    public CharSequence getSuffixText() {
        return this.z;
    }

    public TextView getSuffixTextView() {
        return this.A;
    }

    private void o() {
        int visibility = this.A.getVisibility();
        int i2 = 0;
        boolean z2 = this.z != null && !this.aE;
        TextView textView = this.A;
        if (!z2) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.A.getVisibility()) {
            getEndIconDelegate().a(z2);
        }
        D();
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public ColorStateList getSuffixTextColor() {
        return this.A.getTextColors();
    }

    public void setSuffixTextAppearance(int i2) {
        i.a(this.A, i2);
    }

    private void p() {
        if (this.f36781a != null) {
            u.b(this.A, 0, this.f36781a.getPaddingTop(), (b() || J()) ? 0 : u.n(this.f36781a), this.f36781a.getPaddingBottom());
        }
    }

    public void setEnabled(boolean z2) {
        a((ViewGroup) this, z2);
        super.setEnabled(z2);
    }

    private static void a(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z2);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f36782b || !this.m || (textView = this.n) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    private void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.n;
        if (textView != null) {
            a(textView, this.m ? this.o : this.p);
            if (!this.m && (colorStateList2 = this.v) != null) {
                this.n.setTextColor(colorStateList2);
            }
            if (this.m && (colorStateList = this.w) != null) {
                this.n.setTextColor(colorStateList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(TextView textView, int i2) {
        boolean z2 = true;
        try {
            i.a(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            i.a(textView, R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(androidx.core.content.b.c(getContext(), R.color.design_error));
        }
    }

    private int r() {
        float a2;
        if (!this.B) {
            return 0;
        }
        int i2 = this.H;
        if (i2 == 0 || i2 == 1) {
            a2 = this.f36784d.a();
        } else if (i2 != 2) {
            return 0;
        } else {
            a2 = this.f36784d.a() / 2.0f;
        }
        return (int) a2;
    }

    private int a(int i2, boolean z2) {
        int compoundPaddingLeft = i2 + this.f36781a.getCompoundPaddingLeft();
        return (this.x == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.y.getMeasuredWidth()) + this.y.getPaddingLeft();
    }

    private int b(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f36781a.getCompoundPaddingRight();
        return (this.x == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.y.getMeasuredWidth() - this.y.getPaddingRight());
    }

    private boolean s() {
        if (this.H != 1) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 16 || this.f36781a.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    private int t() {
        int i2 = this.N;
        if (this.H != 1) {
            return i2;
        }
        return androidx.core.graphics.a.a(this.N, com.google.android.material.b.a.a(getContext(), R.attr.colorSurface));
    }

    private void u() {
        h hVar = this.D;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(this.F);
            if (w()) {
                this.D.a((float) this.J, this.M);
            }
            this.N = t();
            this.D.g(ColorStateList.valueOf(this.N));
            if (this.ae == 3) {
                this.f36781a.getBackground().invalidateSelf();
            }
            v();
            invalidate();
        }
    }

    private void v() {
        if (this.E != null) {
            if (x()) {
                this.E.g(ColorStateList.valueOf(this.M));
            }
            invalidate();
        }
    }

    private boolean w() {
        return this.H == 2 && x();
    }

    private boolean x() {
        return this.J >= 0 && this.M != 0;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Drawable background;
        TextView textView;
        EditText editText = this.f36781a;
        if (editText != null && this.H == 0 && (background = editText.getBackground()) != null) {
            if (p.c(background)) {
                background = background.mutate();
            }
            if (this.k.d()) {
                background.setColorFilter(f.a(this.k.e(), PorterDuff.Mode.SRC_IN));
            } else if (!this.m || (textView = this.n) == null) {
                androidx.core.graphics.drawable.a.e(background);
                this.f36781a.refreshDrawableState();
            } else {
                background.setColorFilter(f.a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        CharSequence f36793a;

        /* renamed from: b  reason: collision with root package name */
        boolean f36794b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f36793a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f36794b = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f36793a, parcel, i2);
            parcel.writeInt(this.f36794b ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f36793a + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.k.d()) {
            savedState.f36793a = getError();
        }
        savedState.f36794b = B() && this.ag.isChecked();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        setError(savedState.f36793a);
        if (savedState.f36794b) {
            this.ag.post(new Runnable() {
                public final void run() {
                    TextInputLayout.this.ag.performClick();
                    TextInputLayout.this.ag.jumpDrawablesToCurrentState();
                }
            });
        }
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.aI = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.aI = false;
    }

    public CharSequence getError() {
        if (this.k.f36842g) {
            return this.k.f36841f;
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.k.m) {
            return this.k.l;
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.aF = z2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z2;
        EditText editText;
        int max;
        super.onMeasure(i2, i3);
        if (this.f36781a == null || this.f36781a.getMeasuredHeight() >= (max = Math.max(this.f36787h.getMeasuredHeight(), this.f36786g.getMeasuredHeight()))) {
            z2 = false;
        } else {
            this.f36781a.setMinimumHeight(max);
            z2 = true;
        }
        boolean D2 = D();
        if (z2 || D2) {
            this.f36781a.post(new Runnable() {
                public final void run() {
                    TextInputLayout.this.f36781a.requestLayout();
                }
            });
        }
        if (!(this.s == null || (editText = this.f36781a) == null)) {
            this.s.setGravity(editText.getGravity());
            this.s.setPadding(this.f36781a.getCompoundPaddingLeft(), this.f36781a.getCompoundPaddingTop(), this.f36781a.getCompoundPaddingRight(), this.f36781a.getCompoundPaddingBottom());
        }
        n();
        p();
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.S.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            A();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener((View.OnClickListener) null);
        setStartIconOnLongClickListener((View.OnLongClickListener) null);
        setStartIconContentDescription((CharSequence) null);
    }

    public Drawable getStartIconDrawable() {
        return this.S.getDrawable();
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.S, onClickListener, this.ac);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ac = onLongClickListener;
        a(this.S, onLongClickListener);
    }

    public void setStartIconVisible(boolean z2) {
        if (y() != z2) {
            this.S.setVisibility(z2 ? 0 : 8);
            n();
            D();
        }
    }

    private boolean y() {
        return this.S.getVisibility() == 0;
    }

    public void setStartIconCheckable(boolean z2) {
        this.S.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.S.setContentDescription(charSequence);
        }
    }

    public CharSequence getStartIconContentDescription() {
        return this.S.getContentDescription();
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.T != colorStateList) {
            this.T = colorStateList;
            this.U = true;
            A();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.V != mode) {
            this.V = mode;
            this.W = true;
            A();
        }
    }

    public void setEndIconMode(int i2) {
        int i3 = this.ae;
        this.ae = i2;
        Iterator it2 = this.ah.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).a(this, i3);
        }
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().a(this.H)) {
            getEndIconDelegate().a();
            C();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.H + " is not supported by the end icon mode " + i2);
    }

    public int getEndIconMode() {
        return this.ae;
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.ag, onClickListener, this.ap);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.ar, onClickListener, this.aq);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ap = onLongClickListener;
        a(this.ag, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aq = onLongClickListener;
        a(this.ar, onLongClickListener);
    }

    public void setEndIconVisible(boolean z2) {
        if (b() != z2) {
            this.ag.setVisibility(z2 ? 0 : 8);
            p();
            D();
        }
    }

    public final boolean b() {
        return this.f36788i.getVisibility() == 0 && this.ag.getVisibility() == 0;
    }

    public void setEndIconActivated(boolean z2) {
        this.ag.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.ag.setCheckable(z2);
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.ag.setImageDrawable(drawable);
    }

    public Drawable getEndIconDrawable() {
        return this.ag.getDrawable();
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.ag.setContentDescription(charSequence);
        }
    }

    public CharSequence getEndIconContentDescription() {
        return this.ag.getContentDescription();
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.ai != colorStateList) {
            this.ai = colorStateList;
            this.aj = true;
            C();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.ak != mode) {
            this.ak = mode;
            this.al = true;
            C();
        }
    }

    public final void a(c cVar) {
        this.ah.add(cVar);
    }

    public final void a(b bVar) {
        this.ad.add(bVar);
        if (this.f36781a != null) {
            bVar.a(this);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.ag.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.ag.setContentDescription(charSequence);
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.ag.getDrawable();
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.ag.getContentDescription();
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.ae != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.ai = colorStateList;
        this.aj = true;
        C();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.ak = mode;
        this.al = true;
        C();
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        EditText editText = this.f36781a;
        if (editText != null) {
            u.a((View) editText, (androidx.core.h.a) aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.ag;
    }

    private e getEndIconDelegate() {
        e eVar = this.af.get(this.ae);
        if (eVar != null) {
            return eVar;
        }
        return this.af.get(0);
    }

    private void z() {
        Iterator it2 = this.ad.iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).a(this);
        }
    }

    private void A() {
        a(this.S, this.U, this.T, this.W, this.V);
    }

    private boolean B() {
        return this.ae != 0;
    }

    private void a(boolean z2) {
        if (!z2 || getEndIconDrawable() == null) {
            C();
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.f(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.a(mutate, this.k.e());
        this.ag.setImageDrawable(mutate);
    }

    private void C() {
        a(this.ag, this.aj, this.ai, this.al, this.ak);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean D() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.f36781a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.E()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x004d
            android.widget.LinearLayout r0 = r10.f36786g
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.f36781a
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.aa
            if (r6 == 0) goto L_0x0025
            int r6 = r10.ab
            if (r6 == r0) goto L_0x0035
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.aa = r6
            r10.ab = r0
            android.graphics.drawable.Drawable r0 = r10.aa
            int r6 = r10.ab
            r0.setBounds(r1, r1, r6, r5)
        L_0x0035:
            android.widget.EditText r0 = r10.f36781a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.i.b(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.aa
            if (r6 == r7) goto L_0x0066
            android.widget.EditText r6 = r10.f36781a
            r8 = r0[r5]
            r9 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.i.a(r6, r7, r8, r9, r0)
            goto L_0x0064
        L_0x004d:
            android.graphics.drawable.Drawable r0 = r10.aa
            if (r0 == 0) goto L_0x0066
            android.widget.EditText r0 = r10.f36781a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.i.b(r0)
            android.widget.EditText r6 = r10.f36781a
            r7 = r0[r5]
            r8 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.i.a(r6, r2, r7, r8, r0)
            r10.aa = r2
        L_0x0064:
            r0 = 1
            goto L_0x0067
        L_0x0066:
            r0 = 0
        L_0x0067:
            boolean r6 = r10.F()
            if (r6 == 0) goto L_0x00dd
            android.widget.TextView r2 = r10.A
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.f36781a
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            com.google.android.material.internal.CheckableImageButton r6 = r10.getEndIconToUpdateDummyDrawable()
            if (r6 == 0) goto L_0x0090
            int r7 = r6.getMeasuredWidth()
            int r2 = r2 + r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = androidx.core.h.h.a(r6)
            int r2 = r2 + r6
        L_0x0090:
            android.widget.EditText r6 = r10.f36781a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.i.b(r6)
            android.graphics.drawable.Drawable r7 = r10.am
            if (r7 == 0) goto L_0x00b3
            int r8 = r10.an
            if (r8 == r2) goto L_0x00b3
            r10.an = r2
            int r0 = r10.an
            r7.setBounds(r1, r1, r0, r5)
            android.widget.EditText r0 = r10.f36781a
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r4 = r10.am
            r3 = r6[r3]
            androidx.core.widget.i.a(r0, r1, r2, r4, r3)
            goto L_0x0100
        L_0x00b3:
            android.graphics.drawable.Drawable r7 = r10.am
            if (r7 != 0) goto L_0x00c7
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.am = r7
            r10.an = r2
            android.graphics.drawable.Drawable r2 = r10.am
            int r7 = r10.an
            r2.setBounds(r1, r1, r7, r5)
        L_0x00c7:
            r2 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.am
            if (r2 == r7) goto L_0x00ff
            r0 = r6[r4]
            r10.ao = r0
            android.widget.EditText r0 = r10.f36781a
            r1 = r6[r1]
            r2 = r6[r5]
            r3 = r6[r3]
            androidx.core.widget.i.a(r0, r1, r2, r7, r3)
            goto L_0x0100
        L_0x00dd:
            android.graphics.drawable.Drawable r6 = r10.am
            if (r6 == 0) goto L_0x00ff
            android.widget.EditText r6 = r10.f36781a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.i.b(r6)
            r4 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.am
            if (r4 != r7) goto L_0x00fb
            android.widget.EditText r0 = r10.f36781a
            r1 = r6[r1]
            r4 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.ao
            r3 = r6[r3]
            androidx.core.widget.i.a(r0, r1, r4, r7, r3)
            goto L_0x00fc
        L_0x00fb:
            r5 = r0
        L_0x00fc:
            r10.am = r2
            goto L_0x0100
        L_0x00ff:
            r5 = r0
        L_0x0100:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.D():boolean");
    }

    private boolean E() {
        return !(getStartIconDrawable() == null && this.x == null) && this.f36786g.getMeasuredWidth() > 0;
    }

    private boolean F() {
        return (this.ar.getVisibility() == 0 || ((B() && b()) || this.z != null)) && this.f36787h.getMeasuredWidth() > 0;
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.ar.getVisibility() == 0) {
            return this.ar;
        }
        if (!B() || !b()) {
            return null;
        }
        return this.ag;
    }

    private static void a(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = androidx.core.graphics.drawable.a.f(drawable).mutate();
            if (z2) {
                androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            }
            if (z3) {
                androidx.core.graphics.drawable.a.a(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private static void a(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        b(checkableImageButton, onLongClickListener);
    }

    private static void a(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        b(checkableImageButton, onLongClickListener);
    }

    private static void b(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean N2 = u.N(checkableImageButton);
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (N2 || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(N2);
        checkableImageButton.setPressable(N2);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        u.c((View) checkableImageButton, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.f36781a;
        if (editText != null) {
            Rect rect = this.O;
            com.google.android.material.internal.b.b(this, editText, rect);
            if (this.E != null) {
                this.E.setBounds(rect.left, rect.bottom - this.L, rect.right, rect.bottom);
            }
            if (this.B) {
                this.f36784d.a(this.f36781a.getTextSize());
                int gravity = this.f36781a.getGravity();
                this.f36784d.b((gravity & -113) | 48);
                this.f36784d.a(gravity);
                com.google.android.material.internal.a aVar = this.f36784d;
                if (this.f36781a != null) {
                    Rect rect2 = this.P;
                    boolean z3 = u.j(this) == 1;
                    rect2.bottom = rect.bottom;
                    int i8 = this.H;
                    if (i8 == 1) {
                        rect2.left = a(rect.left, z3);
                        rect2.top = rect.top + this.I;
                        rect2.right = b(rect.right, z3);
                    } else if (i8 != 2) {
                        rect2.left = a(rect.left, z3);
                        rect2.top = getPaddingTop();
                        rect2.right = b(rect.right, z3);
                    } else {
                        rect2.left = rect.left + this.f36781a.getPaddingLeft();
                        rect2.top = rect.top - r();
                        rect2.right = rect.right - this.f36781a.getPaddingRight();
                    }
                    aVar.b(rect2.left, rect2.top, rect2.right, rect2.bottom);
                    com.google.android.material.internal.a aVar2 = this.f36784d;
                    if (this.f36781a != null) {
                        Rect rect3 = this.P;
                        TextPaint textPaint = aVar2.f36440i;
                        textPaint.setTextSize(aVar2.f36435d);
                        textPaint.setTypeface(aVar2.f36438g);
                        float f2 = -aVar2.f36440i.ascent();
                        rect3.left = rect.left + this.f36781a.getCompoundPaddingLeft();
                        if (s()) {
                            i6 = (int) (((float) rect.centerY()) - (f2 / 2.0f));
                        } else {
                            i6 = rect.top + this.f36781a.getCompoundPaddingTop();
                        }
                        rect3.top = i6;
                        rect3.right = rect.right - this.f36781a.getCompoundPaddingRight();
                        if (s()) {
                            i7 = (int) (((float) rect3.top) + f2);
                        } else {
                            i7 = rect.bottom - this.f36781a.getCompoundPaddingBottom();
                        }
                        rect3.bottom = i7;
                        aVar2.a(rect3.left, rect3.top, rect3.right, rect3.bottom);
                        this.f36784d.c();
                        if (G() && !this.aE) {
                            H();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.B) {
            this.f36784d.a(canvas);
        }
        h hVar = this.E;
        if (hVar != null) {
            Rect bounds = hVar.getBounds();
            bounds.top = bounds.bottom - this.J;
            this.E.draw(canvas);
        }
    }

    private void b(boolean z2) {
        ValueAnimator valueAnimator = this.aG;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.aG.cancel();
        }
        if (!z2 || !this.aF) {
            this.f36784d.b(1.0f);
        } else {
            a(1.0f);
        }
        this.aE = false;
        if (G()) {
            H();
        }
        j();
        m();
        o();
    }

    private boolean G() {
        return this.B && !TextUtils.isEmpty(this.C) && (this.D instanceof c);
    }

    private void H() {
        if (G()) {
            RectF rectF = this.Q;
            this.f36784d.a(rectF, this.f36781a.getWidth(), this.f36781a.getGravity());
            a(rectF);
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            ((c) this.D).a(rectF);
        }
    }

    private void I() {
        if (G()) {
            ((c) this.D).a(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void a(RectF rectF) {
        rectF.left -= (float) this.G;
        rectF.top -= (float) this.G;
        rectF.right += (float) this.G;
        rectF.bottom += (float) this.G;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.aH) {
            boolean z2 = true;
            this.aH = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            com.google.android.material.internal.a aVar = this.f36784d;
            boolean a2 = aVar != null ? aVar.a(drawableState) | false : false;
            if (this.f36781a != null) {
                if (!u.J(this) || !isEnabled()) {
                    z2 = false;
                }
                a(z2, false);
            }
            a();
            c();
            if (a2) {
                invalidate();
            }
            this.aH = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r6.f36781a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r6 = this;
            com.google.android.material.k.h r0 = r6.D
            if (r0 == 0) goto L_0x00f8
            int r0 = r6.H
            if (r0 != 0) goto L_0x000a
            goto L_0x00f8
        L_0x000a:
            boolean r0 = r6.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            android.widget.EditText r0 = r6.f36781a
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            boolean r3 = r6.isHovered()
            if (r3 != 0) goto L_0x0033
            android.widget.EditText r3 = r6.f36781a
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            boolean r4 = r6.isEnabled()
            if (r4 != 0) goto L_0x003f
            int r4 = r6.aD
            r6.M = r4
            goto L_0x0081
        L_0x003f:
            com.google.android.material.textfield.f r4 = r6.k
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x0058
            android.content.res.ColorStateList r4 = r6.ay
            if (r4 == 0) goto L_0x004f
            r6.b((boolean) r0, (boolean) r3)
            goto L_0x0081
        L_0x004f:
            com.google.android.material.textfield.f r4 = r6.k
            int r4 = r4.e()
            r6.M = r4
            goto L_0x0081
        L_0x0058:
            boolean r4 = r6.m
            if (r4 == 0) goto L_0x006f
            android.widget.TextView r4 = r6.n
            if (r4 == 0) goto L_0x006f
            android.content.res.ColorStateList r5 = r6.ay
            if (r5 == 0) goto L_0x0068
            r6.b((boolean) r0, (boolean) r3)
            goto L_0x0081
        L_0x0068:
            int r4 = r4.getCurrentTextColor()
            r6.M = r4
            goto L_0x0081
        L_0x006f:
            if (r0 == 0) goto L_0x0076
            int r4 = r6.ax
            r6.M = r4
            goto L_0x0081
        L_0x0076:
            if (r3 == 0) goto L_0x007d
            int r4 = r6.aw
            r6.M = r4
            goto L_0x0081
        L_0x007d:
            int r4 = r6.av
            r6.M = r4
        L_0x0081:
            android.graphics.drawable.Drawable r4 = r6.getErrorIconDrawable()
            if (r4 == 0) goto L_0x0096
            com.google.android.material.textfield.f r4 = r6.k
            boolean r4 = r4.f36842g
            if (r4 == 0) goto L_0x0096
            com.google.android.material.textfield.f r4 = r6.k
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x0096
            r1 = 1
        L_0x0096:
            r6.setErrorIconVisible(r1)
            com.google.android.material.internal.CheckableImageButton r1 = r6.ar
            android.content.res.ColorStateList r4 = r6.as
            r6.a((com.google.android.material.internal.CheckableImageButton) r1, (android.content.res.ColorStateList) r4)
            com.google.android.material.internal.CheckableImageButton r1 = r6.S
            android.content.res.ColorStateList r4 = r6.T
            r6.a((com.google.android.material.internal.CheckableImageButton) r1, (android.content.res.ColorStateList) r4)
            com.google.android.material.internal.CheckableImageButton r1 = r6.ag
            android.content.res.ColorStateList r4 = r6.ai
            r6.a((com.google.android.material.internal.CheckableImageButton) r1, (android.content.res.ColorStateList) r4)
            com.google.android.material.textfield.e r1 = r6.getEndIconDelegate()
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x00c1
            com.google.android.material.textfield.f r1 = r6.k
            boolean r1 = r1.d()
            r6.a((boolean) r1)
        L_0x00c1:
            if (r0 == 0) goto L_0x00ce
            boolean r1 = r6.isEnabled()
            if (r1 == 0) goto L_0x00ce
            int r1 = r6.L
            r6.J = r1
            goto L_0x00d2
        L_0x00ce:
            int r1 = r6.K
            r6.J = r1
        L_0x00d2:
            int r1 = r6.H
            if (r1 != r2) goto L_0x00f5
            boolean r1 = r6.isEnabled()
            if (r1 != 0) goto L_0x00e1
            int r0 = r6.aA
            r6.N = r0
            goto L_0x00f5
        L_0x00e1:
            if (r3 == 0) goto L_0x00ea
            if (r0 != 0) goto L_0x00ea
            int r0 = r6.aC
            r6.N = r0
            goto L_0x00f5
        L_0x00ea:
            if (r0 == 0) goto L_0x00f1
            int r0 = r6.aB
            r6.N = r0
            goto L_0x00f5
        L_0x00f1:
            int r0 = r6.az
            r6.N = r0
        L_0x00f5:
            r6.u()
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.c():void");
    }

    private void b(boolean z2, boolean z3) {
        int defaultColor = this.ay.getDefaultColor();
        int colorForState = this.ay.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.ay.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.M = colorForState2;
        } else if (z3) {
            this.M = colorForState;
        } else {
            this.M = defaultColor;
        }
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.ar.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.f36788i;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        p();
        if (!B()) {
            D();
        }
    }

    private boolean J() {
        return this.ar.getVisibility() == 0;
    }

    private void a(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
            Drawable mutate = androidx.core.graphics.drawable.a.f(drawable).mutate();
            androidx.core.graphics.drawable.a.a(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private void c(boolean z2) {
        ValueAnimator valueAnimator = this.aG;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.aG.cancel();
        }
        if (!z2 || !this.aF) {
            this.f36784d.b(0.0f);
        } else {
            a(0.0f);
        }
        if (G() && ((c) this.D).a()) {
            I();
        }
        this.aE = true;
        l();
        m();
        o();
    }

    private void a(float f2) {
        if (this.f36784d.f36432a != f2) {
            if (this.aG == null) {
                this.aG = new ValueAnimator();
                this.aG.setInterpolator(com.google.android.material.a.a.f35801b);
                this.aG.setDuration(167);
                this.aG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.f36784d.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.aG.setFloatValues(new float[]{this.f36784d.f36432a, f2});
            this.aG.start();
        }
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.f36784d.b();
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.f36784d.a();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.k.e();
    }

    public static class a extends androidx.core.h.a {

        /* renamed from: a  reason: collision with root package name */
        private final TextInputLayout f36795a;

        public a(TextInputLayout textInputLayout) {
            this.f36795a = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.c cVar) {
            String str;
            String str2;
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            EditText editText = this.f36795a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f36795a.getHint();
            CharSequence helperText = this.f36795a.getHelperText();
            CharSequence error = this.f36795a.getError();
            int counterMaxLength = this.f36795a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f36795a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z2) {
                str = hint.toString();
            } else {
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if ((z4 || z3) && !TextUtils.isEmpty(str)) {
                str2 = ", ";
            } else {
                str2 = "";
            }
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (z4) {
                helperText = error;
            } else if (!z3) {
                helperText = "";
            }
            sb3.append(helperText);
            String sb4 = sb3.toString();
            if (z) {
                cVar.c((CharSequence) text);
            } else if (!TextUtils.isEmpty(sb4)) {
                cVar.c((CharSequence) sb4);
            }
            if (!TextUtils.isEmpty(sb4)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.f((CharSequence) sb4);
                } else {
                    if (z) {
                        sb4 = text + ", " + sb4;
                    }
                    cVar.c((CharSequence) sb4);
                }
                boolean z6 = !z;
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.f3041a.setShowingHintText(z6);
                } else {
                    cVar.a(4, z6);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                cVar.f3041a.setMaxTextLength(counterMaxLength);
            }
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    cVar.f3041a.setError(error);
                }
            }
        }
    }
}
