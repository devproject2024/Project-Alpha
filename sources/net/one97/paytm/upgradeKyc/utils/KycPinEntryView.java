package net.one97.paytm.upgradeKyc.utils;

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
import net.one97.paytm.upgradeKyc.R;

public class KycPinEntryView extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f66297a;

    /* renamed from: b  reason: collision with root package name */
    private int f66298b;

    /* renamed from: c  reason: collision with root package name */
    private int f66299c;

    /* renamed from: d  reason: collision with root package name */
    private int f66300d;

    /* renamed from: e  reason: collision with root package name */
    private int f66301e;

    /* renamed from: f  reason: collision with root package name */
    private int f66302f;

    /* renamed from: g  reason: collision with root package name */
    private int f66303g;

    /* renamed from: h  reason: collision with root package name */
    private int f66304h;

    /* renamed from: i  reason: collision with root package name */
    private int f66305i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public EditText n;
    /* access modifiers changed from: private */
    public View.OnFocusChangeListener o;
    /* access modifiers changed from: private */
    public b p;
    /* access modifiers changed from: private */
    public boolean q;

    public interface b {
        void a(String str);

        void b(String str);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public KycPinEntryView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KycPinEntryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KycPinEntryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = null;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.KycOTPEntryView);
        this.f66297a = obtainStyledAttributes.getInt(R.styleable.KycOTPEntryView_otpNumDigits, 4);
        this.f66298b = obtainStyledAttributes.getInt(R.styleable.KycOTPEntryView_otpInputType, 2);
        this.j = obtainStyledAttributes.getInt(R.styleable.KycOTPEntryView_otpAccentType, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f66299c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KycOTPEntryView_otpDigitWidth, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f66300d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KycOTPEntryView_otpDigitHeight, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f66302f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KycOTPEntryView_otpDigitSpacing, (int) TypedValue.applyDimension(1, 20.0f, displayMetrics));
        this.f66303g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KycOTPEntryView_otpDigitTextSize, (int) TypedValue.applyDimension(2, 15.0f, displayMetrics));
        this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KycOTPEntryView_otpAccentWidth, (int) TypedValue.applyDimension(1, 3.0f, displayMetrics));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f66305i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.KycOTPEntryView_otpDigitElevation, 0);
        }
        Resources.Theme theme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(16842836, typedValue, true);
        this.f66301e = obtainStyledAttributes.getResourceId(R.styleable.KycOTPEntryView_otpDigitBackground, typedValue.resourceId);
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(16842806, typedValue2, true);
        this.f66304h = obtainStyledAttributes.getColor(R.styleable.KycOTPEntryView_otpDigitTextColor, typedValue2.resourceId > 0 ? getResources().getColor(typedValue2.resourceId) : typedValue2.data);
        TypedValue typedValue3 = new TypedValue();
        if (Build.VERSION.SDK_INT >= 21) {
            theme.resolveAttribute(16843829, typedValue3, true);
        }
        this.l = obtainStyledAttributes.getColor(R.styleable.KycOTPEntryView_otpAccentColor, typedValue3.resourceId > 0 ? getResources().getColor(typedValue3.resourceId) : typedValue3.data);
        String string = obtainStyledAttributes.getString(R.styleable.KycOTPEntryView_otpMask);
        if (string != null) {
            this.m = string;
        }
        this.q = obtainStyledAttributes.getBoolean(R.styleable.KycOTPEntryView_otpAccentRequiresFocus, true);
        obtainStyledAttributes.recycle();
        b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = this.f66299c;
        int i5 = this.f66297a;
        int i6 = (i4 * i5) + (this.f66302f * (i5 - 1));
        setMeasuredDimension(getPaddingLeft() + i6 + getPaddingRight() + (this.f66305i * 2), this.f66300d + getPaddingTop() + getPaddingBottom() + (this.f66305i * 2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).measure(i6, makeMeasureSpec);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (true) {
            int i7 = this.f66297a;
            if (i6 < i7) {
                View childAt = getChildAt(i6);
                int i8 = (this.f66299c * i6) + (i6 > 0 ? this.f66302f * i6 : 0);
                childAt.layout(getPaddingLeft() + i8 + this.f66305i, getPaddingTop() + (this.f66305i / 2), i8 + getPaddingLeft() + this.f66305i + this.f66299c, getPaddingTop() + (this.f66305i / 2) + this.f66300d);
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
        savedState.f66308a = this.n.getText().toString();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        try {
            this.n.setText(savedState.f66308a);
            this.n.setSelection(savedState.f66308a.length());
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
            if (charSequence.length() > this.f66297a) {
                charSequence = charSequence.subSequence(0, this.f66297a);
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
        return this.f66297a;
    }

    public int getInputType() {
        return this.f66298b;
    }

    public int getAccentType() {
        return this.j;
    }

    public int getDigitWidth() {
        return this.f66299c;
    }

    public int getDigitHeight() {
        return this.f66300d;
    }

    public int getDigitSpacing() {
        return this.f66302f;
    }

    public int getDigitTextSize() {
        return this.f66303g;
    }

    public int getAccentWidth() {
        return this.k;
    }

    public int getDigitElevation() {
        return this.f66305i;
    }

    public int getDigitBackground() {
        return this.f66301e;
    }

    public void setDigitBackground(int i2) {
        this.f66301e = i2;
        for (int i3 = 0; i3 < this.f66297a; i3++) {
            ((a) getChildAt(i3)).setBackgroundResource(i2);
        }
    }

    public int getDigitTextColor() {
        return this.f66304h;
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
        this.f66297a = i2;
        removeAllViews();
        if (i2 > 6) {
            int a2 = com.paytm.utility.b.a((Activity) getContext());
            int dimension = (int) getContext().getResources().getDimension(R.dimen.dimen_20dp);
            int c2 = com.paytm.utility.b.c((int) getContext().getResources().getDimension(R.dimen.kyc_pin_view_text_width));
            int i3 = (((a2 - dimension) - dimension) - ((i2 - 1) * this.f66302f)) / i2;
            if (c2 <= i3) {
                i3 = c2;
            }
            this.f66299c = i3;
            this.f66303g = com.paytm.utility.b.c((int) getContext().getResources().getDimension(R.dimen.kyc_pin_view_text_size));
        }
        b();
    }

    private void b() {
        for (int i2 = 0; i2 < this.f66297a; i2++) {
            a aVar = new a(this, getContext());
            aVar.setWidth(this.f66299c);
            aVar.setHeight(this.f66300d);
            aVar.setBackgroundResource(this.f66301e);
            aVar.setTextColor(this.f66304h);
            aVar.setTextSize(0, (float) this.f66303g);
            aVar.setGravity(17);
            if (Build.VERSION.SDK_INT >= 21) {
                aVar.setElevation((float) this.f66305i);
            }
            if (i2 == 0) {
                aVar.setBackgroundResource(R.drawable.kyc_pin_view_blue_bg);
            } else {
                aVar.setBackgroundResource(R.drawable.kyc_pin_view_gray_bg);
            }
            addView(aVar);
        }
        this.n = new EditText(getContext());
        this.n.setBackgroundColor(getResources().getColor(17170445));
        this.n.setTextColor(getResources().getColor(17170445));
        this.n.setCursorVisible(false);
        this.n.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f66297a)});
        this.n.setInputType(this.f66298b);
        this.n.setImeOptions(268435456);
        this.n.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                int length = KycPinEntryView.this.n.getText().length();
                for (int i2 = 0; i2 < KycPinEntryView.this.f66297a; i2++) {
                    View childAt = KycPinEntryView.this.getChildAt(i2);
                    boolean z2 = true;
                    if (!z || !(KycPinEntryView.this.j == 1 || (KycPinEntryView.this.j == 2 && (i2 == length || (i2 == KycPinEntryView.this.f66297a - 1 && length == KycPinEntryView.this.f66297a))))) {
                        z2 = false;
                    }
                    childAt.setSelected(z2);
                }
                KycPinEntryView.this.n.setSelection(length);
                if (KycPinEntryView.this.o != null) {
                    KycPinEntryView.this.o.onFocusChange(KycPinEntryView.this, z);
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
                for (int i2 = 0; i2 < KycPinEntryView.this.f66297a; i2++) {
                    if (editable.length() > i2) {
                        String valueOf = (KycPinEntryView.this.m == null || KycPinEntryView.this.m.length() == 0) ? String.valueOf(editable.charAt(i2)) : KycPinEntryView.this.m;
                        ((TextView) KycPinEntryView.this.getChildAt(i2)).setText(valueOf);
                        ((a) KycPinEntryView.this.getChildAt(i2)).setBackgroundResource(R.drawable.kyc_pin_view_gray_bg);
                        if (KycPinEntryView.this.p != null) {
                            KycPinEntryView.this.p.b(valueOf);
                        }
                    } else {
                        ((TextView) KycPinEntryView.this.getChildAt(i2)).setText("");
                        a aVar = (a) KycPinEntryView.this.getChildAt(i2);
                        if (i2 == editable.length()) {
                            aVar.setBackgroundResource(R.drawable.kyc_pin_view_blue_bg);
                        } else {
                            aVar.setBackgroundResource(R.drawable.kyc_pin_view_gray_bg);
                        }
                    }
                    if (KycPinEntryView.this.n.hasFocus()) {
                        View childAt = KycPinEntryView.this.getChildAt(i2);
                        boolean z = true;
                        if (!(KycPinEntryView.this.j == 1 || (KycPinEntryView.this.j == 2 && (i2 == length || (i2 == KycPinEntryView.this.f66297a - 1 && length == KycPinEntryView.this.f66297a))))) {
                            z = false;
                        }
                        childAt.setSelected(z);
                    }
                }
                if (length == KycPinEntryView.this.f66297a && KycPinEntryView.this.p != null) {
                    KycPinEntryView.this.p.a(editable.toString());
                }
            }
        });
        addView(this.n);
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
        String f66308a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f66308a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f66308a);
        }
    }

    class a extends AppCompatTextView {

        /* renamed from: b  reason: collision with root package name */
        private Paint f66310b;

        public a(KycPinEntryView kycPinEntryView, Context context) {
            this(kycPinEntryView, context, (byte) 0);
        }

        private a(KycPinEntryView kycPinEntryView, Context context, byte b2) {
            this(context, 0);
        }

        private a(Context context, char c2) {
            super(context, (AttributeSet) null, 0);
            this.f66310b = new Paint();
            this.f66310b.setStyle(Paint.Style.FILL);
            this.f66310b.setColor(KycPinEntryView.this.l);
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (isSelected() || !KycPinEntryView.this.q) {
                canvas.drawRect(0.0f, (float) (getHeight() - KycPinEntryView.this.k), (float) getWidth(), (float) getHeight(), this.f66310b);
            }
        }
    }

    public void setMask(String str) {
        this.m = str;
    }
}
