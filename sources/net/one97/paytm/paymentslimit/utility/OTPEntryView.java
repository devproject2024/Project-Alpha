package net.one97.paytm.paymentslimit.utility;

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
import net.one97.paytm.wallet.R;

public class OTPEntryView extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f59316a;

    /* renamed from: b  reason: collision with root package name */
    private int f59317b;

    /* renamed from: c  reason: collision with root package name */
    private int f59318c;

    /* renamed from: d  reason: collision with root package name */
    private int f59319d;

    /* renamed from: e  reason: collision with root package name */
    private int f59320e;

    /* renamed from: f  reason: collision with root package name */
    private int f59321f;

    /* renamed from: g  reason: collision with root package name */
    private int f59322g;

    /* renamed from: h  reason: collision with root package name */
    private int f59323h;

    /* renamed from: i  reason: collision with root package name */
    private int f59324i;
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
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public OTPEntryView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OTPEntryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OTPEntryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = "*";
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.OTPEntryView);
        this.f59316a = obtainStyledAttributes.getInt(R.styleable.OTPEntryView_numDigitsWallet, 6);
        this.f59317b = obtainStyledAttributes.getInt(R.styleable.OTPEntryView_pinInputTypeWallet, 2);
        this.j = obtainStyledAttributes.getInt(R.styleable.OTPEntryView_accentTypeWallet, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f59318c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OTPEntryView_digitWidthWallet, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f59319d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OTPEntryView_digitHeightWallet, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
        this.f59321f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OTPEntryView_digitSpacingWallet, (int) TypedValue.applyDimension(1, 20.0f, displayMetrics));
        this.f59322g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OTPEntryView_digitTextSizeWallet, (int) TypedValue.applyDimension(2, 15.0f, displayMetrics));
        this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OTPEntryView_accentWidthWallet, (int) TypedValue.applyDimension(1, 3.0f, displayMetrics));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f59324i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OTPEntryView_digitElevationWallet, 0);
        }
        Resources.Theme theme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(16842836, typedValue, true);
        this.f59320e = obtainStyledAttributes.getResourceId(R.styleable.OTPEntryView_digitBackgroundWallet, typedValue.resourceId);
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(16842806, typedValue2, true);
        this.f59323h = obtainStyledAttributes.getColor(R.styleable.OTPEntryView_digitTextColorWallet, typedValue2.resourceId > 0 ? getResources().getColor(typedValue2.resourceId) : typedValue2.data);
        TypedValue typedValue3 = new TypedValue();
        theme.resolveAttribute(R.attr.colorAccent, typedValue3, true);
        this.l = obtainStyledAttributes.getColor(R.styleable.OTPEntryView_pinAccentColorWallet, typedValue3.resourceId > 0 ? getResources().getColor(typedValue3.resourceId) : typedValue3.data);
        String string = obtainStyledAttributes.getString(R.styleable.OTPEntryView_maskWallet);
        if (string != null) {
            this.m = string;
        }
        this.q = obtainStyledAttributes.getBoolean(R.styleable.OTPEntryView_accentRequiresFocusWallet, true);
        obtainStyledAttributes.recycle();
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = this.f59318c;
        int i5 = this.f59316a;
        int i6 = (i4 * i5) + (this.f59321f * (i5 - 1));
        setMeasuredDimension(getPaddingLeft() + i6 + getPaddingRight() + (this.f59324i * 2), this.f59319d + getPaddingTop() + getPaddingBottom() + (this.f59324i * 2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).measure(i6, makeMeasureSpec);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (true) {
            int i7 = this.f59316a;
            if (i6 < i7) {
                View childAt = getChildAt(i6);
                int i8 = (this.f59318c * i6) + (i6 > 0 ? this.f59321f * i6 : 0);
                childAt.layout(getPaddingLeft() + i8 + this.f59324i, getPaddingTop() + (this.f59324i / 2), i8 + getPaddingLeft() + this.f59324i + this.f59318c, getPaddingTop() + (this.f59324i / 2) + this.f59319d);
                i6++;
            } else {
                getChildAt(i7).layout(0, 0, 1, getMeasuredHeight());
                return;
            }
        }
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
        savedState.f59327a = this.n.getText().toString();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.n.setText(savedState.f59327a);
        this.n.setSelection(savedState.f59327a.length());
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
        int length = charSequence.length();
        int i2 = this.f59316a;
        if (length > i2) {
            charSequence = charSequence.subSequence(0, i2);
        }
        this.n.setText(charSequence);
    }

    public int getDigits() {
        return this.f59316a;
    }

    public int getInputType() {
        return this.f59317b;
    }

    public int getAccentType() {
        return this.j;
    }

    public int getDigitWidth() {
        return this.f59318c;
    }

    public int getDigitHeight() {
        return this.f59319d;
    }

    public int getDigitSpacing() {
        return this.f59321f;
    }

    public int getDigitTextSize() {
        return this.f59322g;
    }

    public int getAccentWidth() {
        return this.k;
    }

    public int getDigitElevation() {
        return this.f59324i;
    }

    public int getDigitBackground() {
        return this.f59320e;
    }

    public void setDigitBackground(int i2) {
        this.f59320e = i2;
        for (int i3 = 0; i3 < this.f59316a; i3++) {
            ((a) getChildAt(i3)).setBackgroundResource(i2);
        }
    }

    public int getDigitTextColor() {
        return this.f59323h;
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

    private void a() {
        for (int i2 = 0; i2 < this.f59316a; i2++) {
            a aVar = new a(this, getContext());
            aVar.setWidth(this.f59318c);
            aVar.setHeight(this.f59319d);
            aVar.setBackgroundResource(this.f59320e);
            aVar.setTextColor(this.f59323h);
            aVar.setTextSize(0, (float) this.f59322g);
            aVar.setGravity(17);
            if (Build.VERSION.SDK_INT >= 21) {
                aVar.setElevation((float) this.f59324i);
            }
            if (i2 == 0) {
                aVar.setBackgroundResource(R.drawable.payment_limit_blue_et_bg);
            } else {
                aVar.setBackgroundResource(R.drawable.payment_limit_grey_et_bg);
            }
            addView(aVar);
        }
        this.n = new EditText(getContext());
        this.n.setBackgroundColor(getResources().getColor(17170445));
        this.n.setTextColor(getResources().getColor(17170445));
        this.n.setCursorVisible(false);
        this.n.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f59316a)});
        this.n.setInputType(this.f59317b);
        this.n.setImeOptions(268435456);
        this.n.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                int length = OTPEntryView.this.n.getText().length();
                for (int i2 = 0; i2 < OTPEntryView.this.f59316a; i2++) {
                    View childAt = OTPEntryView.this.getChildAt(i2);
                    boolean z2 = true;
                    if (!z || !(OTPEntryView.this.j == 1 || (OTPEntryView.this.j == 2 && (i2 == length || (i2 == OTPEntryView.this.f59316a - 1 && length == OTPEntryView.this.f59316a))))) {
                        z2 = false;
                    }
                    childAt.setSelected(z2);
                }
                OTPEntryView.this.n.setSelection(length);
                if (OTPEntryView.this.o != null) {
                    OTPEntryView.this.o.onFocusChange(OTPEntryView.this, z);
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
                for (int i2 = 0; i2 < OTPEntryView.this.f59316a; i2++) {
                    if (editable.length() > i2) {
                        ((TextView) OTPEntryView.this.getChildAt(i2)).setText((OTPEntryView.this.m == null || OTPEntryView.this.m.length() == 0) ? String.valueOf(editable.charAt(i2)) : OTPEntryView.this.m);
                        ((a) OTPEntryView.this.getChildAt(i2)).setBackgroundResource(R.drawable.payment_limit_grey_et_bg);
                        if (OTPEntryView.this.p != null) {
                            b unused = OTPEntryView.this.p;
                        }
                    } else {
                        ((TextView) OTPEntryView.this.getChildAt(i2)).setText("");
                        a aVar = (a) OTPEntryView.this.getChildAt(i2);
                        if (i2 == editable.length()) {
                            aVar.setBackgroundResource(R.drawable.payment_limit_blue_et_bg);
                        } else {
                            aVar.setBackgroundResource(R.drawable.payment_limit_grey_et_bg);
                        }
                    }
                    if (OTPEntryView.this.n.hasFocus()) {
                        View childAt = OTPEntryView.this.getChildAt(i2);
                        boolean z = true;
                        if (!(OTPEntryView.this.j == 1 || (OTPEntryView.this.j == 2 && (i2 == length || (i2 == OTPEntryView.this.f59316a - 1 && length == OTPEntryView.this.f59316a))))) {
                            z = false;
                        }
                        childAt.setSelected(z);
                    }
                }
                if (length == OTPEntryView.this.f59316a && OTPEntryView.this.p != null) {
                    b unused2 = OTPEntryView.this.p;
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
        String f59327a;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f59327a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f59327a);
        }
    }

    class a extends AppCompatTextView {

        /* renamed from: b  reason: collision with root package name */
        private Paint f59329b;

        public a(OTPEntryView oTPEntryView, Context context) {
            this(oTPEntryView, context, (byte) 0);
        }

        private a(OTPEntryView oTPEntryView, Context context, byte b2) {
            this(context, 0);
        }

        private a(Context context, char c2) {
            super(context, (AttributeSet) null, 0);
            this.f59329b = new Paint();
            this.f59329b.setStyle(Paint.Style.FILL);
            this.f59329b.setColor(OTPEntryView.this.l);
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (isSelected() || !OTPEntryView.this.q) {
                canvas.drawRect(0.0f, (float) (getHeight() - OTPEntryView.this.k), (float) getWidth(), (float) getHeight(), this.f59329b);
            }
        }
    }

    public void setMask(String str) {
        this.m = str;
    }
}
