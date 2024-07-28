package net.one97.paytm.bankCommon.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import net.one97.paytm.bankOpen.R;

public class PinEntryView extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f16298a;

    /* renamed from: b  reason: collision with root package name */
    private int f16299b;

    /* renamed from: c  reason: collision with root package name */
    private int f16300c;

    /* renamed from: d  reason: collision with root package name */
    private int f16301d;

    /* renamed from: e  reason: collision with root package name */
    private int f16302e;

    /* renamed from: f  reason: collision with root package name */
    private int f16303f;

    /* renamed from: g  reason: collision with root package name */
    private int f16304g;

    /* renamed from: h  reason: collision with root package name */
    private int f16305h;

    /* renamed from: i  reason: collision with root package name */
    private int f16306i;
    /* access modifiers changed from: private */
    public int j;
    private int k;
    private int l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public EditText n;
    /* access modifiers changed from: private */
    public View.OnFocusChangeListener o;
    /* access modifiers changed from: private */
    public b p;
    private boolean q;

    public interface b {
        void a(String str);

        void af_();
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public PinEntryView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PinEntryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinEntryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = "*";
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PinEntryView);
        this.f16298a = obtainStyledAttributes.getInt(R.styleable.PinEntryView_numDigits, 4);
        this.f16299b = obtainStyledAttributes.getInt(R.styleable.PinEntryView_pinInputType, 2);
        this.j = obtainStyledAttributes.getInt(R.styleable.PinEntryView_accentType, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f16300c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitWidth, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f16301d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitHeight, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f16303f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitSpacing, (int) TypedValue.applyDimension(1, 20.0f, displayMetrics));
        this.f16304g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitTextSize, (int) TypedValue.applyDimension(2, 15.0f, displayMetrics));
        this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_accentWidth, (int) TypedValue.applyDimension(1, 3.0f, displayMetrics));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f16306i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitElevation, 0);
        }
        Resources.Theme theme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(16842836, typedValue, true);
        this.f16302e = obtainStyledAttributes.getResourceId(R.styleable.PinEntryView_digitBackground, typedValue.resourceId);
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(16842806, typedValue2, true);
        this.f16305h = obtainStyledAttributes.getColor(R.styleable.PinEntryView_digitTextColor, typedValue2.resourceId > 0 ? getResources().getColor(typedValue2.resourceId) : typedValue2.data);
        TypedValue typedValue3 = new TypedValue();
        if (Build.VERSION.SDK_INT >= 21) {
            theme.resolveAttribute(16843829, typedValue3, true);
        }
        this.l = obtainStyledAttributes.getColor(R.styleable.PinEntryView_pinAccentColor, typedValue3.resourceId > 0 ? getResources().getColor(typedValue3.resourceId) : typedValue3.data);
        String string = obtainStyledAttributes.getString(R.styleable.PinEntryView_mask);
        if (string != null) {
            this.m = string;
        }
        this.q = obtainStyledAttributes.getBoolean(R.styleable.PinEntryView_accentRequiresFocus, true);
        obtainStyledAttributes.recycle();
        b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = this.f16300c;
        int i5 = this.f16298a;
        int i6 = (i4 * i5) + (this.f16303f * (i5 - 1));
        setMeasuredDimension(getPaddingLeft() + i6 + getPaddingRight() + (this.f16306i * 2), this.f16301d + getPaddingTop() + getPaddingBottom() + (this.f16306i * 2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).measure(i6, makeMeasureSpec);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (true) {
            int i7 = this.f16298a;
            if (i6 < i7) {
                View childAt = getChildAt(i6);
                int i8 = (this.f16300c * i6) + (i6 > 0 ? this.f16303f * i6 : 0);
                childAt.layout(getPaddingLeft() + i8 + this.f16306i, getPaddingTop() + (this.f16306i / 2), i8 + getPaddingLeft() + this.f16306i + this.f16300c, getPaddingTop() + (this.f16306i / 2) + this.f16301d);
                i6++;
            } else {
                getChildAt(i7).layout(0, 0, 1, getMeasuredHeight());
                return;
            }
        }
    }

    public EditText getEditText() {
        return this.n;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        this.n.requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.n, 0);
        return true;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f16309a = this.n.getText().toString();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        try {
            this.n.setText(savedState.f16309a);
            this.n.setSelection(savedState.f16309a.length());
        } catch (Exception unused) {
        }
    }

    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.o;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.o = onFocusChangeListener;
    }

    public b getOnPinEnteredListener() {
        return this.p;
    }

    public void setOnPinEnteredListener(b bVar) {
        this.p = bVar;
    }

    public Editable getText() {
        return this.n.getText();
    }

    public void setText(CharSequence charSequence) {
        try {
            if (charSequence.length() > this.f16298a) {
                charSequence = charSequence.subSequence(0, this.f16298a);
            }
            this.n.setText(charSequence);
            if (charSequence.length() > 0) {
                this.n.setSelection(charSequence.length());
            }
        } catch (Exception unused) {
        }
    }

    public final void a() {
        this.n.setText("");
    }

    public int getDigits() {
        return this.f16298a;
    }

    public int getInputType() {
        return this.f16299b;
    }

    public int getAccentType() {
        return this.j;
    }

    public int getDigitWidth() {
        return this.f16300c;
    }

    public int getDigitHeight() {
        return this.f16301d;
    }

    public int getDigitSpacing() {
        return this.f16303f;
    }

    public int getDigitTextSize() {
        return this.f16304g;
    }

    public int getAccentWidth() {
        return this.k;
    }

    public int getDigitElevation() {
        return this.f16306i;
    }

    public int getDigitBackground() {
        return this.f16302e;
    }

    public void setDigitBackground(int i2) {
        this.f16302e = i2;
        for (int i3 = 0; i3 < this.f16298a; i3++) {
            ((a) getChildAt(i3)).setBackgroundResource(i2);
        }
    }

    public void setDigitCurserInitialState(String str) {
        a aVar;
        int i2 = 0;
        while (i2 < this.f16298a && (aVar = (a) getChildAt(i2)) != null) {
            aVar.setText(str);
            if (i2 == 0) {
                aVar.f16310a = true;
            } else {
                aVar.f16310a = false;
            }
            aVar.invalidate();
            i2++;
        }
    }

    public int getDigitTextColor() {
        return this.f16305h;
    }

    public int getAccentColor() {
        return this.l;
    }

    public String getMask() {
        return this.m;
    }

    public boolean getAccentRequiresFocus() {
        return this.q;
    }

    public void setDigits(int i2) {
        this.f16298a = i2;
        removeAllViews();
        if (i2 > 6) {
            int a2 = net.one97.paytm.bankCommon.mapping.a.a((Activity) getContext());
            int dimension = (int) getContext().getResources().getDimension(R.dimen.dimen_20dp);
            int c2 = net.one97.paytm.bankCommon.mapping.a.c((int) getContext().getResources().getDimension(R.dimen.pin_view_text_width));
            int i3 = (((a2 - dimension) - dimension) - ((i2 - 1) * this.f16303f)) / i2;
            if (c2 <= i3) {
                i3 = c2;
            }
            this.f16300c = i3;
            this.f16304g = net.one97.paytm.bankCommon.mapping.a.c((int) getContext().getResources().getDimension(R.dimen.pin_view_text_size));
        }
        b();
    }

    private void b() {
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < this.f16298a) {
                Context context = getContext();
                if (i2 != 0) {
                    z = false;
                }
                a aVar = new a(this, context, z);
                aVar.setWidth(this.f16300c);
                aVar.setHeight(this.f16301d);
                aVar.setBackgroundResource(this.f16302e);
                aVar.setTextColor(this.f16305h);
                aVar.setTextSize(0, (float) this.f16304g);
                aVar.setGravity(17);
                if (Build.VERSION.SDK_INT >= 21) {
                    aVar.setElevation((float) this.f16306i);
                }
                addView(aVar);
                i2++;
            } else {
                this.n = new EditText(getContext());
                this.n.setBackgroundColor(getResources().getColor(17170445));
                this.n.setTextColor(getResources().getColor(17170445));
                this.n.setCursorVisible(false);
                this.n.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f16298a)});
                this.n.setInputType(this.f16299b);
                this.n.setImeOptions(268435456);
                this.n.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public final void onFocusChange(View view, boolean z) {
                        int length = PinEntryView.this.n.getText().length();
                        for (int i2 = 0; i2 < PinEntryView.this.f16298a; i2++) {
                            View childAt = PinEntryView.this.getChildAt(i2);
                            boolean z2 = true;
                            if (!z || !(PinEntryView.this.j == 1 || (PinEntryView.this.j == 2 && (i2 == length || (i2 == PinEntryView.this.f16298a - 1 && length == PinEntryView.this.f16298a))))) {
                                z2 = false;
                            }
                            childAt.setSelected(z2);
                        }
                        PinEntryView.this.n.setSelection(length);
                        if (PinEntryView.this.o != null) {
                            PinEntryView.this.o.onFocusChange(PinEntryView.this, z);
                        }
                    }
                });
                this.n.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        int length = editable.length();
                        for (int i2 = 0; i2 < PinEntryView.this.f16298a; i2++) {
                            boolean z = true;
                            if (editable.length() > i2) {
                                ((TextView) PinEntryView.this.getChildAt(i2)).setText((PinEntryView.this.m == null || PinEntryView.this.m.length() == 0) ? String.valueOf(editable.charAt(i2)) : PinEntryView.this.m);
                                a aVar = (a) PinEntryView.this.getChildAt(i2);
                                aVar.f16310a = false;
                                aVar.invalidate();
                                if (PinEntryView.this.p != null) {
                                    PinEntryView.this.p.af_();
                                }
                            } else {
                                ((TextView) PinEntryView.this.getChildAt(i2)).setText("");
                                a aVar2 = (a) PinEntryView.this.getChildAt(i2);
                                if (i2 == editable.length()) {
                                    aVar2.f16310a = true;
                                    aVar2.invalidate();
                                } else {
                                    aVar2.f16310a = false;
                                    aVar2.invalidate();
                                }
                            }
                            if (PinEntryView.this.n.hasFocus()) {
                                View childAt = PinEntryView.this.getChildAt(i2);
                                if (!(PinEntryView.this.j == 1 || (PinEntryView.this.j == 2 && (i2 == length || (i2 == PinEntryView.this.f16298a - 1 && length == PinEntryView.this.f16298a))))) {
                                    z = false;
                                }
                                childAt.setSelected(z);
                            }
                        }
                        if (length == PinEntryView.this.f16298a && PinEntryView.this.p != null) {
                            PinEntryView.this.p.a(editable.toString());
                        }
                    }
                });
                addView(this.n);
                return;
            }
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f16309a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f16309a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f16309a);
        }
    }

    class a extends AppCompatTextView {

        /* renamed from: a  reason: collision with root package name */
        boolean f16310a;

        /* renamed from: c  reason: collision with root package name */
        private Paint f16312c;

        public a(PinEntryView pinEntryView, Context context, boolean z) {
            this(pinEntryView, context, z, (byte) 0);
        }

        private a(PinEntryView pinEntryView, Context context, boolean z, byte b2) {
            this(context, z, 0);
        }

        private a(Context context, boolean z, char c2) {
            super(context, (AttributeSet) null, 0);
            this.f16310a = z;
            this.f16312c = new Paint();
            this.f16312c.setStyle(Paint.Style.FILL);
            this.f16312c.setStrokeWidth(5.0f);
            this.f16312c.setColor(getResources().getColor(R.color.paytm_blue));
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f16310a) {
                float width = (float) (getWidth() / 2);
                canvas.drawLine(width, 50.0f, width, (float) (getHeight() - 50), this.f16312c);
            }
        }
    }

    public void setMask(String str) {
        this.m = str;
    }
}
