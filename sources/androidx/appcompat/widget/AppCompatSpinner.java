package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.c;
import androidx.core.h.t;
import androidx.core.h.u;

public class AppCompatSpinner extends Spinner implements t {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1489c = {16843505};

    /* renamed from: a  reason: collision with root package name */
    int f1490a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f1491b;

    /* renamed from: d  reason: collision with root package name */
    private final d f1492d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f1493e;

    /* renamed from: f  reason: collision with root package name */
    private r f1494f;

    /* renamed from: g  reason: collision with root package name */
    private SpinnerAdapter f1495g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f1496h;

    /* renamed from: i  reason: collision with root package name */
    private d f1497i;

    interface d {
        CharSequence a();

        void a(int i2);

        void a(int i2, int i3);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        Drawable b();

        void b(int i2);

        int c();

        void c(int i2);

        void d();

        boolean e();

        int f();
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, attributeSet, i2, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r3 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r3.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r3 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (r10 == 0) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        if (r10 == 1) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
        r10 = new androidx.appcompat.widget.AppCompatSpinner.c(r6, r6.f1493e, r8, r9);
        r1 = androidx.appcompat.widget.ac.a(r6.f1493e, r8, androidx.appcompat.R.styleable.Spinner, r9, 0);
        r6.f1490a = r1.f(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
        r10.a(r1.a(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
        r10.f1508a = r0.d(androidx.appcompat.R.styleable.Spinner_android_prompt);
        r1.f1669a.recycle();
        r6.f1497i = r10;
        r6.f1494f = new androidx.appcompat.widget.AppCompatSpinner.AnonymousClass1(r6, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        r6.f1497i = new androidx.appcompat.widget.AppCompatSpinner.a(r6);
        r6.f1497i.a((java.lang.CharSequence) r0.d(androidx.appcompat.R.styleable.Spinner_android_prompt));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a8, code lost:
        r10 = r0.f1669a.getTextArray(androidx.appcompat.R.styleable.Spinner_android_entries);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b0, code lost:
        if (r10 == null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b2, code lost:
        r1 = new android.widget.ArrayAdapter(r7, 17367048, r10);
        r1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        setAdapter((android.widget.SpinnerAdapter) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c2, code lost:
        r0.f1669a.recycle();
        r6.f1496h = true;
        r7 = r6.f1495g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cb, code lost:
        if (r7 == null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cd, code lost:
        setAdapter(r7);
        r6.f1495g = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d2, code lost:
        r6.f1492d.a(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d7, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f1491b = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.y.a((android.view.View) r6, (android.content.Context) r0)
            int[] r0 = androidx.appcompat.R.styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.ac r0 = androidx.appcompat.widget.ac.a(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.d r2 = new androidx.appcompat.widget.d
            r2.<init>(r6)
            r6.f1492d = r2
            int r2 = androidx.appcompat.R.styleable.Spinner_popupTheme
            int r2 = r0.g(r2, r1)
            if (r2 == 0) goto L_0x002f
            androidx.appcompat.view.d r3 = new androidx.appcompat.view.d
            r3.<init>((android.content.Context) r7, (int) r2)
            r6.f1493e = r3
            goto L_0x0031
        L_0x002f:
            r6.f1493e = r7
        L_0x0031:
            r2 = 0
            int[] r3 = f1489c     // Catch:{ Exception -> 0x0054, all -> 0x004d }
            android.content.res.TypedArray r3 = r7.obtainStyledAttributes(r8, r3, r9, r1)     // Catch:{ Exception -> 0x0054, all -> 0x004d }
            boolean r4 = r3.hasValue(r1)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            if (r4 == 0) goto L_0x0042
            int r10 = r3.getInt(r1, r1)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
        L_0x0042:
            if (r3 == 0) goto L_0x0058
        L_0x0044:
            r3.recycle()
            goto L_0x0058
        L_0x0048:
            r7 = move-exception
            r2 = r3
            goto L_0x004e
        L_0x004b:
            goto L_0x0055
        L_0x004d:
            r7 = move-exception
        L_0x004e:
            if (r2 == 0) goto L_0x0053
            r2.recycle()
        L_0x0053:
            throw r7
        L_0x0054:
            r3 = r2
        L_0x0055:
            if (r3 == 0) goto L_0x0058
            goto L_0x0044
        L_0x0058:
            r3 = 1
            if (r10 == 0) goto L_0x0096
            if (r10 == r3) goto L_0x005e
            goto L_0x00a8
        L_0x005e:
            androidx.appcompat.widget.AppCompatSpinner$c r10 = new androidx.appcompat.widget.AppCompatSpinner$c
            android.content.Context r4 = r6.f1493e
            r10.<init>(r4, r8, r9)
            android.content.Context r4 = r6.f1493e
            int[] r5 = androidx.appcompat.R.styleable.Spinner
            androidx.appcompat.widget.ac r1 = androidx.appcompat.widget.ac.a(r4, r8, r5, r9, r1)
            int r4 = androidx.appcompat.R.styleable.Spinner_android_dropDownWidth
            r5 = -2
            int r4 = r1.f(r4, r5)
            r6.f1490a = r4
            int r4 = androidx.appcompat.R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r4 = r1.a(r4)
            r10.a((android.graphics.drawable.Drawable) r4)
            int r4 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r4 = r0.d(r4)
            r10.f1508a = r4
            android.content.res.TypedArray r1 = r1.f1669a
            r1.recycle()
            r6.f1497i = r10
            androidx.appcompat.widget.AppCompatSpinner$1 r1 = new androidx.appcompat.widget.AppCompatSpinner$1
            r1.<init>(r6, r10)
            r6.f1494f = r1
            goto L_0x00a8
        L_0x0096:
            androidx.appcompat.widget.AppCompatSpinner$a r10 = new androidx.appcompat.widget.AppCompatSpinner$a
            r10.<init>()
            r6.f1497i = r10
            androidx.appcompat.widget.AppCompatSpinner$d r10 = r6.f1497i
            int r1 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r10.a((java.lang.CharSequence) r1)
        L_0x00a8:
            int r10 = androidx.appcompat.R.styleable.Spinner_android_entries
            android.content.res.TypedArray r1 = r0.f1669a
            java.lang.CharSequence[] r10 = r1.getTextArray(r10)
            if (r10 == 0) goto L_0x00c2
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r4, r10)
            int r7 = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00c2:
            android.content.res.TypedArray r7 = r0.f1669a
            r7.recycle()
            r6.f1496h = r3
            android.widget.SpinnerAdapter r7 = r6.f1495g
            if (r7 == 0) goto L_0x00d2
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f1495g = r2
        L_0x00d2:
            androidx.appcompat.widget.d r7 = r6.f1492d
            r7.a(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    public Context getPopupContext() {
        return this.f1493e;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        d dVar = this.f1497i;
        if (dVar != null) {
            dVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i2));
    }

    public Drawable getPopupBackground() {
        d dVar = this.f1497i;
        if (dVar != null) {
            return dVar.b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i2) {
        d dVar = this.f1497i;
        if (dVar != null) {
            dVar.a(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public int getDropDownVerticalOffset() {
        d dVar = this.f1497i;
        if (dVar != null) {
            return dVar.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i2) {
        d dVar = this.f1497i;
        if (dVar != null) {
            dVar.c(i2);
            this.f1497i.b(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public int getDropDownHorizontalOffset() {
        d dVar = this.f1497i;
        if (dVar != null) {
            return dVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i2) {
        if (this.f1497i != null) {
            this.f1490a = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public int getDropDownWidth() {
        if (this.f1497i != null) {
            return this.f1490a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1496h) {
            this.f1495g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1497i != null) {
            Context context = this.f1493e;
            if (context == null) {
                context = getContext();
            }
            this.f1497i.a((ListAdapter) new b(spinnerAdapter, context.getTheme()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f1497i;
        if (dVar != null && dVar.e()) {
            this.f1497i.d();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        r rVar = this.f1494f;
        if (rVar == null || !rVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1497i != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        d dVar = this.f1497i;
        if (dVar == null) {
            return super.performClick();
        }
        if (dVar.e()) {
            return true;
        }
        a();
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        d dVar = this.f1497i;
        if (dVar != null) {
            dVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        d dVar = this.f1497i;
        return dVar != null ? dVar.a() : super.getPrompt();
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1492d;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1492d;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1492d;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1492d;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1492d;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1492d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1492d;
        if (dVar != null) {
            dVar.d();
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.f1491b);
        return i3 + this.f1491b.left + this.f1491b.right;
    }

    /* access modifiers changed from: package-private */
    public final d getInternalPopup() {
        return this.f1497i;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1497i.a(getTextDirection(), getTextAlignment());
        } else {
            this.f1497i.a(-1, -1);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.f1497i;
        savedState.f1501a = dVar != null && dVar.e();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1501a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    if (!AppCompatSpinner.this.getInternalPopup().e()) {
                        AppCompatSpinner.this.a();
                    }
                    ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f1501a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1501a = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f1501a ? (byte) 1 : 0);
        }
    }

    static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f1506a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f1507b;

        public final int getItemViewType(int i2) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1506a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1507b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1506a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public final Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1506a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public final long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1506a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1506a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1506a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1506a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1506a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1507b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f1507b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    class a implements DialogInterface.OnClickListener, d {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.app.c f1502a;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1504c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f1505d;

        public final void a(int i2) {
        }

        public final void a(Drawable drawable) {
        }

        public final Drawable b() {
            return null;
        }

        public final void b(int i2) {
        }

        public final int c() {
            return 0;
        }

        public final void c(int i2) {
        }

        public final int f() {
            return 0;
        }

        a() {
        }

        public final void d() {
            androidx.appcompat.app.c cVar = this.f1502a;
            if (cVar != null) {
                cVar.dismiss();
                this.f1502a = null;
            }
        }

        public final boolean e() {
            androidx.appcompat.app.c cVar = this.f1502a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        public final void a(ListAdapter listAdapter) {
            this.f1504c = listAdapter;
        }

        public final void a(CharSequence charSequence) {
            this.f1505d = charSequence;
        }

        public final CharSequence a() {
            return this.f1505d;
        }

        public final void a(int i2, int i3) {
            if (this.f1504c != null) {
                c.a aVar = new c.a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f1505d;
                if (charSequence != null) {
                    aVar.a(charSequence);
                }
                ListAdapter listAdapter = this.f1504c;
                int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
                aVar.f1095a.w = listAdapter;
                aVar.f1095a.x = this;
                aVar.f1095a.I = selectedItemPosition;
                aVar.f1095a.H = true;
                this.f1502a = aVar.a();
                ListView listView = this.f1502a.f1094a.f998g;
                if (Build.VERSION.SDK_INT >= 17) {
                    listView.setTextDirection(i2);
                    listView.setTextAlignment(i3);
                }
                this.f1502a.show();
            }
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner.this.setSelection(i2);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i2, this.f1504c.getItemId(i2));
            }
            d();
        }
    }

    class c extends ListPopupWindow implements d {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f1508a;

        /* renamed from: b  reason: collision with root package name */
        ListAdapter f1509b;

        /* renamed from: c  reason: collision with root package name */
        final Rect f1510c = new Rect();
        private int q;

        public c(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.k = AppCompatSpinner.this;
            i();
            this.j = 0;
            this.l = new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, c.this.f1509b.getItemId(i2));
                    }
                    c.this.d();
                }
            };
        }

        public final void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f1509b = listAdapter;
        }

        public final CharSequence a() {
            return this.f1508a;
        }

        public final void a(CharSequence charSequence) {
            this.f1508a = charSequence;
        }

        public final void c(int i2) {
            this.q = i2;
        }

        /* access modifiers changed from: package-private */
        public final void h() {
            int i2;
            int i3;
            Drawable background = this.p.getBackground();
            int i4 = 0;
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.f1491b);
                if (ai.a(AppCompatSpinner.this)) {
                    i3 = AppCompatSpinner.this.f1491b.right;
                } else {
                    i3 = -AppCompatSpinner.this.f1491b.left;
                }
                i4 = i3;
            } else {
                Rect rect = AppCompatSpinner.this.f1491b;
                AppCompatSpinner.this.f1491b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f1490a == -2) {
                int a2 = AppCompatSpinner.this.a((SpinnerAdapter) this.f1509b, this.p.getBackground());
                int i5 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.f1491b.left) - AppCompatSpinner.this.f1491b.right;
                if (a2 > i5) {
                    a2 = i5;
                }
                d(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.f1490a == -1) {
                d((width - paddingLeft) - paddingRight);
            } else {
                d(AppCompatSpinner.this.f1490a);
            }
            if (ai.a(AppCompatSpinner.this)) {
                i2 = i4 + (((width - paddingRight) - this.f1558f) - this.q);
            } else {
                i2 = i4 + paddingLeft + this.q;
            }
            this.f1559g = i2;
        }

        public final void a(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = this.p.isShowing();
            h();
            j();
            super.a_();
            DropDownListView dropDownListView = this.f1557e;
            dropDownListView.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                dropDownListView.setTextDirection(i2);
                dropDownListView.setTextAlignment(i3);
            }
            int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
            DropDownListView dropDownListView2 = this.f1557e;
            if (this.p.isShowing() && dropDownListView2 != null) {
                dropDownListView2.setListSelectionHidden(false);
                dropDownListView2.setSelection(selectedItemPosition);
                if (dropDownListView2.getChoiceMode() != 0) {
                    dropDownListView2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r7 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        c cVar = c.this;
                        AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                        if (!(u.M(appCompatSpinner) && appCompatSpinner.getGlobalVisibleRect(cVar.f1510c))) {
                            c.this.d();
                            return;
                        }
                        c.this.h();
                        c.super.a_();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r7);
                a((PopupWindow.OnDismissListener) new PopupWindow.OnDismissListener() {
                    public final void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r7);
                        }
                    }
                });
            }
        }
    }
}
