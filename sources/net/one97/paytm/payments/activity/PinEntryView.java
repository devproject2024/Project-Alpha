package net.one97.paytm.payments.activity;

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
    public int f17192a;

    /* renamed from: b  reason: collision with root package name */
    private int f17193b;

    /* renamed from: c  reason: collision with root package name */
    private int f17194c;

    /* renamed from: d  reason: collision with root package name */
    private int f17195d;

    /* renamed from: e  reason: collision with root package name */
    private int f17196e;

    /* renamed from: f  reason: collision with root package name */
    private int f17197f;

    /* renamed from: g  reason: collision with root package name */
    private int f17198g;

    /* renamed from: h  reason: collision with root package name */
    private int f17199h;

    /* renamed from: i  reason: collision with root package name */
    private int f17200i;
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
        this.f17192a = obtainStyledAttributes.getInt(R.styleable.PinEntryView_numDigits, 4);
        this.f17193b = obtainStyledAttributes.getInt(R.styleable.PinEntryView_pinInputType, 2);
        this.j = obtainStyledAttributes.getInt(R.styleable.PinEntryView_accentType, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f17194c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitWidth, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f17195d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitHeight, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f17197f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitSpacing, (int) TypedValue.applyDimension(1, 20.0f, displayMetrics));
        this.f17198g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitTextSize, (int) TypedValue.applyDimension(2, 15.0f, displayMetrics));
        this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_accentWidth, (int) TypedValue.applyDimension(1, 3.0f, displayMetrics));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f17200i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinEntryView_digitElevation, 0);
        }
        Resources.Theme theme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(16842836, typedValue, true);
        this.f17196e = obtainStyledAttributes.getResourceId(R.styleable.PinEntryView_digitBackground, typedValue.resourceId);
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(16842806, typedValue2, true);
        this.f17199h = obtainStyledAttributes.getColor(R.styleable.PinEntryView_digitTextColor, typedValue2.resourceId > 0 ? getResources().getColor(typedValue2.resourceId) : typedValue2.data);
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
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = this.f17194c;
        int i5 = this.f17192a;
        int i6 = (i4 * i5) + (this.f17197f * (i5 - 1));
        setMeasuredDimension(getPaddingLeft() + i6 + getPaddingRight() + (this.f17200i * 2), this.f17195d + getPaddingTop() + getPaddingBottom() + (this.f17200i * 2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).measure(i6, makeMeasureSpec);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (true) {
            int i7 = this.f17192a;
            if (i6 < i7) {
                View childAt = getChildAt(i6);
                int i8 = (this.f17194c * i6) + (i6 > 0 ? this.f17197f * i6 : 0);
                childAt.layout(getPaddingLeft() + i8 + this.f17200i, getPaddingTop() + (this.f17200i / 2), i8 + getPaddingLeft() + this.f17200i + this.f17194c, getPaddingTop() + (this.f17200i / 2) + this.f17195d);
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
        savedState.f17203a = this.n.getText().toString();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        try {
            this.n.setText(savedState.f17203a);
            this.n.setSelection(savedState.f17203a.length());
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
            if (charSequence.length() > this.f17192a) {
                charSequence = charSequence.subSequence(0, this.f17192a);
            }
            this.n.setText(charSequence);
            if (charSequence.length() > 0) {
                this.n.setSelection(charSequence.length());
            }
        } catch (Exception unused) {
        }
    }

    public int getDigits() {
        return this.f17192a;
    }

    public int getInputType() {
        return this.f17193b;
    }

    public int getAccentType() {
        return this.j;
    }

    public int getDigitWidth() {
        return this.f17194c;
    }

    public int getDigitHeight() {
        return this.f17195d;
    }

    public int getDigitSpacing() {
        return this.f17197f;
    }

    public int getDigitTextSize() {
        return this.f17198g;
    }

    public int getAccentWidth() {
        return this.k;
    }

    public int getDigitElevation() {
        return this.f17200i;
    }

    public int getDigitBackground() {
        return this.f17196e;
    }

    public void setDigitBackground(int i2) {
        this.f17196e = i2;
        for (int i3 = 0; i3 < this.f17192a; i3++) {
            ((a) getChildAt(i3)).setBackgroundResource(i2);
        }
    }

    public int getDigitTextColor() {
        return this.f17199h;
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
        this.f17192a = i2;
        removeAllViews();
        if (i2 > 6) {
            int a2 = net.one97.paytm.bankCommon.mapping.a.a((Activity) getContext());
            int dimension = (int) getContext().getResources().getDimension(R.dimen.dimen_20dp);
            int c2 = net.one97.paytm.bankCommon.mapping.a.c((int) getContext().getResources().getDimension(R.dimen.pin_view_text_width));
            int i3 = (((a2 - dimension) - dimension) - ((i2 - 1) * this.f17197f)) / i2;
            if (c2 <= i3) {
                i3 = c2;
            }
            this.f17194c = i3;
            this.f17198g = net.one97.paytm.bankCommon.mapping.a.c((int) getContext().getResources().getDimension(R.dimen.pin_view_text_size));
        }
        a();
    }

    private void a() {
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < this.f17192a) {
                Context context = getContext();
                if (i2 != 0) {
                    z = false;
                }
                a aVar = new a(this, context, z);
                aVar.setWidth(this.f17194c);
                aVar.setHeight(this.f17195d);
                aVar.setBackgroundResource(this.f17196e);
                aVar.setTextColor(this.f17199h);
                aVar.setTextSize(0, (float) this.f17198g);
                aVar.setGravity(17);
                if (Build.VERSION.SDK_INT >= 21) {
                    aVar.setElevation((float) this.f17200i);
                }
                addView(aVar);
                i2++;
            } else {
                this.n = new EditText(getContext());
                this.n.setBackgroundColor(getResources().getColor(17170445));
                this.n.setTextColor(getResources().getColor(17170445));
                this.n.setCursorVisible(false);
                this.n.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f17192a)});
                this.n.setInputType(this.f17193b);
                this.n.setImeOptions(268435456);
                this.n.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public final void onFocusChange(View view, boolean z) {
                        int length = PinEntryView.this.n.getText().length();
                        for (int i2 = 0; i2 < PinEntryView.this.f17192a; i2++) {
                            View childAt = PinEntryView.this.getChildAt(i2);
                            boolean z2 = true;
                            if (!z || !(PinEntryView.this.j == 1 || (PinEntryView.this.j == 2 && (i2 == length || (i2 == PinEntryView.this.f17192a - 1 && length == PinEntryView.this.f17192a))))) {
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
                        for (int i2 = 0; i2 < PinEntryView.this.f17192a; i2++) {
                            boolean z = true;
                            if (editable.length() > i2) {
                                ((TextView) PinEntryView.this.getChildAt(i2)).setText((PinEntryView.this.m == null || PinEntryView.this.m.length() == 0) ? String.valueOf(editable.charAt(i2)) : PinEntryView.this.m);
                                a aVar = (a) PinEntryView.this.getChildAt(i2);
                                aVar.f17204a = false;
                                aVar.invalidate();
                                if (PinEntryView.this.p != null) {
                                    b unused = PinEntryView.this.p;
                                }
                            } else {
                                ((TextView) PinEntryView.this.getChildAt(i2)).setText("");
                                a aVar2 = (a) PinEntryView.this.getChildAt(i2);
                                if (i2 == editable.length()) {
                                    aVar2.f17204a = true;
                                    aVar2.invalidate();
                                } else {
                                    aVar2.f17204a = false;
                                    aVar2.invalidate();
                                }
                            }
                            if (PinEntryView.this.n.hasFocus()) {
                                View childAt = PinEntryView.this.getChildAt(i2);
                                if (!(PinEntryView.this.j == 1 || (PinEntryView.this.j == 2 && (i2 == length || (i2 == PinEntryView.this.f17192a - 1 && length == PinEntryView.this.f17192a))))) {
                                    z = false;
                                }
                                childAt.setSelected(z);
                            }
                        }
                        if (length == PinEntryView.this.f17192a && PinEntryView.this.p != null) {
                            b unused2 = PinEntryView.this.p;
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
        String f17203a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f17203a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f17203a);
        }
    }

    class a extends AppCompatTextView {

        /* renamed from: a  reason: collision with root package name */
        boolean f17204a;

        /* renamed from: c  reason: collision with root package name */
        private Paint f17206c;

        public a(PinEntryView pinEntryView, Context context, boolean z) {
            this(pinEntryView, context, z, (byte) 0);
        }

        private a(PinEntryView pinEntryView, Context context, boolean z, byte b2) {
            this(context, z, 0);
        }

        private a(Context context, boolean z, char c2) {
            super(context, (AttributeSet) null, 0);
            this.f17204a = z;
            this.f17206c = new Paint();
            this.f17206c.setStyle(Paint.Style.FILL);
            this.f17206c.setStrokeWidth(5.0f);
            this.f17206c.setColor(getResources().getColor(net.one97.paytm.paymentsBank.R.color.paytm_blue));
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f17204a) {
                float width = (float) (getWidth() / 2);
                canvas.drawLine(width, 50.0f, width, (float) (getHeight() - 50), this.f17206c);
            }
        }
    }

    public void setMask(String str) {
        this.m = str;
    }
}
