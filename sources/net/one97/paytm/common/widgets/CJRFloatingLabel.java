package net.one97.paytm.common.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;

public class CJRFloatingLabel extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public c f49690a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f49691b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RoboTextView f49692c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b f49693d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f49694e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f49695f;

    /* renamed from: g  reason: collision with root package name */
    private String f49696g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f49697h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f49698i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;

    public interface b {
        void a(View view);

        void b(View view);
    }

    public interface c {
        void a(CharSequence charSequence);
    }

    public void setClickable(boolean z) {
    }

    public CJRFloatingLabel(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public CJRFloatingLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CJRFloatingLabel(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        int i4;
        int i5;
        int i6;
        CharSequence charSequence;
        this.f49693d = new a((byte) 0);
        CharSequence charSequence2 = null;
        this.f49696g = null;
        this.f49697h = false;
        this.f49698i = false;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = true;
        int i7 = R.id.fl_edit_text;
        int i8 = R.id.fl_label_view;
        if (attributeSet == null) {
            i4 = R.layout.lyt_floating_label;
            i3 = androidx.core.content.b.c(context, R.color.color_909090);
            charSequence = null;
            i6 = 0;
            i5 = 0;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CJRFloatingLabel, i2, 0);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CJRFloatingLabel_android_layout, R.layout.lyt_floating_label);
            i7 = obtainStyledAttributes.getResourceId(R.styleable.CJRFloatingLabel_editTextId, R.id.fl_edit_text);
            i8 = obtainStyledAttributes.getResourceId(R.styleable.CJRFloatingLabel_labelId, R.id.fl_label_view);
            charSequence2 = obtainStyledAttributes.getText(R.styleable.CJRFloatingLabel_android_text);
            charSequence = obtainStyledAttributes.getText(R.styleable.CJRFloatingLabel_android_hint);
            int color = obtainStyledAttributes.getColor(R.styleable.CJRFloatingLabel_textHintColor, androidx.core.content.b.c(context, R.color.color_909090));
            obtainStyledAttributes.getColor(R.styleable.CJRFloatingLabel_floatLabelColor, 0);
            i6 = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_imeOptions, 0);
            i5 = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_inputType, 1);
            this.f49697h = obtainStyledAttributes.getBoolean(R.styleable.CJRFloatingLabel_isHintPrefixRequired, false);
            this.j = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_maxLength, -1);
            this.k = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_maxEms, -1);
            this.l = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_minWidth, -1);
            this.m = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_minHeight, -1);
            this.n = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_maxWidth, -1);
            this.o = obtainStyledAttributes.getInt(R.styleable.CJRFloatingLabel_android_maxHeight, -1);
            this.p = obtainStyledAttributes.getColor(R.styleable.CJRFloatingLabel_android_background, androidx.core.content.b.c(context, 17170445));
            this.q = obtainStyledAttributes.getBoolean(R.styleable.CJRFloatingLabel_android_enabled, true);
            obtainStyledAttributes.recycle();
            i4 = resourceId;
            i3 = color;
        }
        inflate(context, i4, this);
        this.f49691b = (EditText) findViewById(i7);
        if (this.f49691b == null) {
            this.f49691b = (EditText) findViewById(R.id.fl_edit_text);
        }
        if (this.f49691b != null) {
            if (i7 != R.id.fl_edit_text) {
                this.f49691b.setId(i7);
            }
            this.f49691b.setHint(charSequence);
            this.f49691b.setText(charSequence2);
            this.f49691b.setEnabled(this.q);
            int i9 = this.p;
            if (i9 != -1) {
                this.f49691b.setBackgroundColor(i9);
            }
            this.f49691b.setHintTextColor(i3);
            if (i6 != 0) {
                this.f49691b.setImeOptions(i6);
            }
            if (i5 != 0) {
                this.f49691b.setInputType(i5);
            }
            int i10 = this.j;
            if (i10 != -1) {
                setMaxLength(i10);
            }
            int i11 = this.k;
            if (i11 != -1) {
                setMaxEms(i11);
            }
            int i12 = this.l;
            if (i12 != -1) {
                this.f49691b.setMinWidth(i12);
            }
            int i13 = this.m;
            if (i13 != -1) {
                this.f49691b.setMinHeight(i13);
            }
            int i14 = this.n;
            if (i14 != -1) {
                this.f49691b.setMaxWidth(i14);
            }
            int i15 = this.o;
            if (i15 != -1) {
                this.f49691b.setMaxHeight(i15);
            }
            this.f49692c = (RoboTextView) findViewById(i8);
            if (this.f49692c == null) {
                this.f49692c = (RoboTextView) findViewById(R.id.fl_label_view);
            }
            if (this.f49692c != null) {
                if (i8 != R.id.fl_label_view) {
                    this.f49692c.setId(i8);
                }
                this.f49692c.setText(this.f49691b.getHint());
                this.f49692c.setTextColor(androidx.core.content.b.c(context, R.color.color_adadad));
                this.f49691b.addTextChangedListener(new d());
                if (this.f49691b.getText().length() == 0) {
                    this.f49692c.setAlpha(0.0f);
                    this.f49694e = false;
                } else {
                    this.f49692c.setVisibility(0);
                    this.f49694e = true;
                }
                this.f49698i = true;
                this.f49691b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public final void onFocusChange(View view, boolean z) {
                        if (view.getId() == R.id.fl_edit_text && !z) {
                            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }
                });
                return;
            }
            throw new RuntimeException("Your layout must have a TextView whose ID is @id/float_label");
        }
        throw new RuntimeException("Your layout must have an EditText whose ID is @id/edit_text");
    }

    public void addView(View view) {
        if (!this.f49698i) {
            super.addView(view);
            return;
        }
        throw new UnsupportedOperationException("ChildViews not Supported");
    }

    public void addView(View view, int i2) {
        if (!this.f49698i) {
            super.addView(view, i2);
            return;
        }
        throw new UnsupportedOperationException("ChildViews not Supported");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!this.f49698i) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("ChildViews not Supported");
    }

    public void addView(View view, int i2, int i3) {
        if (!this.f49698i) {
            super.addView(view, i2, i3);
            return;
        }
        throw new UnsupportedOperationException("ChildViews not Supported");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f49698i) {
            super.addView(view, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("ChildViews not Supported");
    }

    public EditText getEditText() {
        return this.f49691b;
    }

    public TextView getFloatingLabel() {
        return this.f49692c;
    }

    public void setHintText(int i2) {
        this.f49696g = getContext().getString(i2);
        setHintText(this.f49696g);
    }

    public void setHintPrefix(boolean z) {
        this.f49697h = z;
    }

    public void setHintText(String str) {
        this.f49696g = str;
        setHintTextWithPrefix("");
    }

    public void setEdittextEditable(boolean z) {
        this.f49691b.setFocusable(z);
        this.f49691b.setClickable(z);
    }

    public CharSequence getText() {
        EditText editText = this.f49691b;
        return (editText == null || TextUtils.isEmpty(editText.getText())) ? "" : this.f49691b.getText();
    }

    public void setText(int i2) {
        this.f49691b.setText(i2);
    }

    public void setText(char[] cArr, int i2, int i3) {
        this.f49691b.setText(cArr, i2, i3);
    }

    public void setText(int i2, TextView.BufferType bufferType) {
        this.f49691b.setText(i2, bufferType);
    }

    public void setText(CharSequence charSequence) {
        this.f49691b.setText(charSequence);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f49691b.setText(charSequence, bufferType);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i4 - i2) - getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        a(this.f49692c, paddingLeft, paddingTop, paddingRight);
        a(this.f49691b, paddingLeft, paddingTop + this.f49692c.getMeasuredHeight(), paddingRight);
    }

    private void a(View view, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (view.getVisibility() != 8) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i7 = i3 + layoutParams.topMargin;
            int i8 = layoutParams.gravity;
            if (i8 == -1) {
                i8 = 8388659;
            }
            if (Build.VERSION.SDK_INT < 17) {
                i5 = 0;
            } else {
                i5 = getLayoutDirection();
            }
            int absoluteGravity = Gravity.getAbsoluteGravity(i8, i5) & 7;
            if (absoluteGravity == 1) {
                i6 = ((i2 + (((i4 - i2) - measuredWidth) / 2)) + layoutParams.leftMargin) - layoutParams.rightMargin;
            } else if (absoluteGravity != 8388613) {
                i6 = i2 + layoutParams.leftMargin;
            } else {
                i6 = (i4 - measuredWidth) - layoutParams.rightMargin;
            }
            view.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        Bundle bundle = this.f49695f;
        if (bundle != null) {
            this.f49691b.onRestoreInstanceState(bundle.getParcelable("saveStateEditText"));
            this.f49692c.onRestoreInstanceState(this.f49695f.getParcelable("saveStateLabel"));
            if (this.f49695f.getBoolean("saveStateFocus", false)) {
                this.f49691b.requestFocus();
            }
            this.f49695f = null;
        }
        measureChild(this.f49691b, i2, i3);
        measureChild(this.f49692c, i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            int max = Math.max(Math.max(this.f49691b.getMeasuredWidth(), this.f49692c.getMeasuredWidth()), getSuggestedMinimumWidth()) + getPaddingLeft() + getPaddingRight();
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(max, size);
            } else {
                size = max;
            }
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 != 1073741824) {
            int max2 = Math.max(this.f49691b.getMeasuredHeight() + this.f49692c.getMeasuredHeight() + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight());
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(max2, size2);
            } else {
                size2 = max2;
            }
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getBoolean("saveStateTag", false)) {
                this.f49695f = bundle;
                super.onRestoreInstanceState(bundle.getParcelable("saveStateParent"));
                return;
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("saveStateEditText", this.f49691b.onSaveInstanceState());
        bundle.putParcelable("saveStateLabel", this.f49692c.onSaveInstanceState());
        bundle.putBoolean("saveStateFocus", this.f49691b.isFocused());
        bundle.putBoolean("saveStateTag", true);
        bundle.putParcelable("saveStateParent", onSaveInstanceState);
        return bundle;
    }

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private static void a(View view, boolean z) {
            float height = (float) (view.getHeight() / 2);
            float f2 = z ? height : 0.0f;
            if (z) {
                height = 0.0f;
            }
            view.setY(f2);
            view.animate().alpha(z ? 1.0f : 0.0f).y(height);
        }

        public final void a(View view) {
            a(view, true);
        }

        public final void b(View view) {
            a(view, false);
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        public final void afterTextChanged(Editable editable) {
            if (CJRFloatingLabel.this.f49690a != null) {
                c unused = CJRFloatingLabel.this.f49690a;
            }
            String obj = (editable == null || TextUtils.isEmpty(editable.toString().trim())) ? null : editable.toString();
            if (obj == null) {
                if (CJRFloatingLabel.this.f49694e) {
                    CJRFloatingLabel.this.f49693d.b(CJRFloatingLabel.this.f49692c);
                    boolean unused2 = CJRFloatingLabel.this.f49694e = false;
                }
            } else if (!CJRFloatingLabel.this.f49694e) {
                boolean unused3 = CJRFloatingLabel.this.f49694e = true;
                CJRFloatingLabel.this.f49693d.a(CJRFloatingLabel.this.f49692c);
            }
            CJRFloatingLabel.this.setHintTextWithPrefix(obj);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (CJRFloatingLabel.this.f49690a != null) {
                c unused = CJRFloatingLabel.this.f49690a;
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (CJRFloatingLabel.this.f49690a != null) {
                CJRFloatingLabel.this.f49690a.a(charSequence);
            }
        }
    }

    public void setMaxLength(int i2) {
        this.f49691b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public void setMaxEms(int i2) {
        this.f49691b.setMaxEms(i2);
    }

    public final void a(c cVar) {
        this.f49690a = cVar;
    }

    /* access modifiers changed from: private */
    public void setHintTextWithPrefix(String str) {
        String str2 = this.f49696g;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            if (str == null || TextUtils.isEmpty(str.trim())) {
                this.f49691b.setHint(this.f49696g);
            } else {
                this.f49692c.setText(this.f49696g);
            }
        }
    }

    public void setEnabled(boolean z) {
        this.f49691b.setEnabled(z);
    }

    public void setEdiTextFocusable(boolean z) {
        this.f49691b.setFocusable(z);
    }
}
