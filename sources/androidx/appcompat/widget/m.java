package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.h.u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

final class m {

    /* renamed from: f  reason: collision with root package name */
    private static final RectF f1772f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f1773g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f1774h = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    int f1775a = 0;

    /* renamed from: b  reason: collision with root package name */
    float f1776b = -1.0f;

    /* renamed from: c  reason: collision with root package name */
    float f1777c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    float f1778d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    int[] f1779e = new int[0];

    /* renamed from: i  reason: collision with root package name */
    private boolean f1780i = false;
    private boolean j = false;
    private TextPaint k;
    private final TextView l;
    private final Context m;
    private final a n;

    static class a {
        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        a() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(TextView textView) {
            return ((Boolean) m.a((Object) textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    static class b extends a {
        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) m.a((Object) textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    static class c extends b {
        c() {
        }

        /* access modifiers changed from: package-private */
        public final boolean a(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        /* access modifiers changed from: package-private */
        public final void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    m(TextView textView) {
        this.l = textView;
        this.m = this.l.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.n = new c();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.n = new b();
        } else {
            this.n = new a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.m.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i2, 0);
        TextView textView = this.l;
        u.a(textView, textView.getContext(), R.styleable.AppCompatTextView, attributeSet, obtainStyledAttributes, i2);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1775a = obtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!f()) {
            this.f1775a = 0;
        } else if (this.f1775a == 1) {
            if (!this.j) {
                DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a(dimension2, dimension3, dimension);
            }
            d();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (!f()) {
            return;
        }
        if (i2 == 0) {
            e();
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (d()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(i2)));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (f()) {
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (d()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int[] iArr, int i2) throws IllegalArgumentException {
        if (f()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                this.f1779e = a(iArr2);
                if (!c()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.j = false;
            }
            if (d()) {
                a();
            }
        }
    }

    private void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f1779e = a(iArr);
            c();
        }
    }

    private boolean c() {
        int length = this.f1779e.length;
        this.j = length > 0;
        if (this.j) {
            this.f1775a = 1;
            int[] iArr = this.f1779e;
            this.f1777c = (float) iArr[0];
            this.f1778d = (float) iArr[length - 1];
            this.f1776b = -1.0f;
        }
        return this.j;
    }

    private static int[] a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void a(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.f1775a = 1;
            this.f1777c = f2;
            this.f1778d = f3;
            this.f1776b = f4;
            this.j = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }

    private boolean d() {
        if (!f() || this.f1775a != 1) {
            this.f1780i = false;
        } else {
            if (!this.j || this.f1779e.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1778d - this.f1777c) / this.f1776b))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.f1777c + (((float) i2) * this.f1776b));
                }
                this.f1779e = a(iArr);
            }
            this.f1780i = true;
        }
        return this.f1780i;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        int i2;
        if (b()) {
            if (this.f1780i) {
                if (this.l.getMeasuredHeight() > 0 && this.l.getMeasuredWidth() > 0) {
                    if (this.n.a(this.l)) {
                        i2 = 1048576;
                    } else {
                        i2 = (this.l.getMeasuredWidth() - this.l.getTotalPaddingLeft()) - this.l.getTotalPaddingRight();
                    }
                    int height = (this.l.getHeight() - this.l.getCompoundPaddingBottom()) - this.l.getCompoundPaddingTop();
                    if (i2 > 0 && height > 0) {
                        synchronized (f1772f) {
                            f1772f.setEmpty();
                            f1772f.right = (float) i2;
                            f1772f.bottom = (float) height;
                            float a2 = (float) a(f1772f);
                            if (a2 != this.l.getTextSize()) {
                                a(0, a2);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1780i = true;
        }
    }

    private void e() {
        this.f1775a = 0;
        this.f1777c = -1.0f;
        this.f1778d = -1.0f;
        this.f1776b = -1.0f;
        this.f1779e = new int[0];
        this.f1780i = false;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, float f2) {
        Resources resources;
        Context context = this.m;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        a(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }

    private void a(float f2) {
        if (f2 != this.l.getPaint().getTextSize()) {
            this.l.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.l.isInLayout() : false;
            if (this.l.getLayout() != null) {
                this.f1780i = false;
                try {
                    Method a2 = a("nullLayouts");
                    if (a2 != null) {
                        a2.invoke(this.l, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (!isInLayout) {
                    this.l.requestLayout();
                } else {
                    this.l.forceLayout();
                }
                this.l.invalidate();
            }
        }
    }

    private int a(RectF rectF) {
        int length = this.f1779e.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                if (a(this.f1779e[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i3;
                    i3 = i6;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f1779e[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private void b(int i2) {
        TextPaint textPaint = this.k;
        if (textPaint == null) {
            this.k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.k.set(this.l.getPaint());
        this.k.setTextSize((float) i2);
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b(charSequence, alignment, i2, i3);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return new StaticLayout(charSequence, this.k, i2, alignment, this.l.getLineSpacingMultiplier(), this.l.getLineSpacingExtra(), this.l.getIncludeFontPadding());
        }
        return new StaticLayout(charSequence, this.k, i2, alignment, ((Float) b(this.l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) b(this.l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) b(this.l, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private boolean a(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.l.getText();
        TransformationMethod transformationMethod = this.l.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.l)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.l.getMaxLines() : -1;
        b(i2);
        StaticLayout a2 = a(text, (Layout.Alignment) a((Object) this.l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (a2.getLineCount() <= maxLines && a2.getLineEnd(a2.getLineCount() - 1) == text.length())) && ((float) a2.getHeight()) <= rectF.bottom;
    }

    private StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.k, i2);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.l.getLineSpacingExtra(), this.l.getLineSpacingMultiplier()).setIncludePad(this.l.getIncludeFontPadding()).setBreakStrategy(this.l.getBreakStrategy()).setHyphenationFrequency(this.l.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            this.n.a(obtain, this.l);
        } catch (ClassCastException unused) {
        }
        return obtain.build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r2 = new java.lang.StringBuilder("Failed to invoke TextView#");
        r2.append(r3);
        r2.append("() method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T a(java.lang.Object r2, java.lang.String r3, T r4) {
        /*
            java.lang.reflect.Method r0 = a((java.lang.String) r3)     // Catch:{ Exception -> 0x000e }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000e }
            java.lang.Object r4 = r0.invoke(r2, r1)     // Catch:{ Exception -> 0x000e }
            goto L_0x001d
        L_0x000c:
            r2 = move-exception
            goto L_0x001e
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x000c }
            java.lang.String r0 = "Failed to invoke TextView#"
            r2.<init>(r0)     // Catch:{ all -> 0x000c }
            r2.append(r3)     // Catch:{ all -> 0x000c }
            java.lang.String r3 = "() method"
            r2.append(r3)     // Catch:{ all -> 0x000c }
        L_0x001d:
            return r4
        L_0x001e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m.a(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    private static <T> T b(Object obj, String str, T t) {
        try {
            Field b2 = b(str);
            if (b2 == null) {
                return t;
            }
            return b2.get(obj);
        } catch (IllegalAccessException unused) {
            StringBuilder sb = new StringBuilder("Failed to access TextView#");
            sb.append(str);
            sb.append(" member");
            return t;
        }
    }

    private static Method a(String str) {
        try {
            Method method = f1773g.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1773g.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            return null;
        }
    }

    private static Field b(String str) {
        try {
            Field field = f1774h.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f1774h.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException unused) {
            StringBuilder sb = new StringBuilder("Failed to access TextView#");
            sb.append(str);
            sb.append(" member");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return f() && this.f1775a != 0;
    }

    private boolean f() {
        return !(this.l instanceof AppCompatEditText);
    }
}
