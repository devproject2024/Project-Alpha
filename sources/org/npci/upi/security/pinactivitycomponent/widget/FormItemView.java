package org.npci.upi.security.pinactivitycomponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.h.u;
import androidx.core.h.x;
import androidx.core.h.y;
import com.business.merchant_payments.common.utility.AppUtility;
import org.npci.upi.security.pinactivitycomponent.R;

public class FormItemView extends LinearLayout implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f73027a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f73028b;

    /* renamed from: c  reason: collision with root package name */
    private String f73029c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f73030d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f73031e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public FormItemEditText f73032f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public m f73033g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f73034h;

    /* renamed from: i  reason: collision with root package name */
    private Object f73035i;
    private LinearLayout j;
    private Button k;
    private ProgressBar l;
    private ImageView m;
    /* access modifiers changed from: private */
    public String n = "";
    /* access modifiers changed from: private */
    public boolean o = false;
    private boolean p;
    private boolean q;
    private RelativeLayout r;

    public FormItemView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public FormItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FormItemView);
        if (obtainStyledAttributes != null) {
            this.f73028b = obtainStyledAttributes.getString(R.styleable.FormItemView_formTitle);
            this.f73029c = obtainStyledAttributes.getString(R.styleable.FormItemView_formValidationError);
            this.f73030d = obtainStyledAttributes.getInteger(R.styleable.FormItemView_formInputLength, 6);
            this.p = obtainStyledAttributes.getBoolean(R.styleable.FormItemView_formActionOnTop, false);
            obtainStyledAttributes.recycle();
        }
        inflate(context, R.layout.layout_form_item, this);
        this.r = (RelativeLayout) findViewById(R.id.form_item_root);
        this.j = (LinearLayout) findViewById(R.id.form_item_action_bar);
        this.f73031e = (TextView) findViewById(R.id.form_item_title);
        this.f73032f = (FormItemEditText) findViewById(R.id.form_item_input);
        this.k = (Button) findViewById(R.id.form_item_button);
        this.l = (ProgressBar) findViewById(R.id.form_item_progress);
        this.m = (ImageView) findViewById(R.id.form_item_image);
        this.f73032f.setInputType(0);
        setTitle(this.f73028b);
        setInputLength(this.f73030d);
        this.f73032f.addTextChangedListener(new j(this));
        this.f73032f.setOnTouchListener(new k(this));
        setActionBarPositionTop(this.p);
    }

    public void a(Drawable drawable, boolean z) {
        if (drawable != null) {
            this.m.setImageDrawable(drawable);
        }
        a((View) this.m, z);
    }

    public void a(String str, Drawable drawable, View.OnClickListener onClickListener, int i2, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            this.k.setText(str);
        }
        Button button = this.k;
        Drawable drawable2 = i2 == 0 ? drawable : null;
        Drawable drawable3 = i2 == 1 ? drawable : null;
        Drawable drawable4 = i2 == 2 ? drawable : null;
        if (i2 != 3) {
            drawable = null;
        }
        button.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable);
        this.k.setOnClickListener(onClickListener);
        this.k.setEnabled(z2);
        a((View) this.k, z);
    }

    public void a(String str, View.OnClickListener onClickListener, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            this.k.setText(str);
        }
        a((View) this.k, z);
        this.k.setEnabled(z2);
        this.k.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        x a2 = a((View) this.l, z);
        a2.a((Interpolator) new AccelerateDecelerateInterpolator());
        a2.c();
    }

    public boolean a() {
        this.f73032f.requestFocus();
        return true;
    }

    public boolean b() {
        if (!this.o) {
            this.o = true;
            setText(this.n);
        } else {
            this.o = false;
            this.f73032f.setText(this.n.replaceAll(AppUtility.CENTER_DOT, "●"));
        }
        return this.o;
    }

    public Object getFormDataTag() {
        return this.f73035i;
    }

    public FormItemEditText getFormInputView() {
        return this.f73032f;
    }

    public m getFormItemListener() {
        return this.f73033g;
    }

    public int getInputLength() {
        return this.f73030d;
    }

    public String getInputValue() {
        return (this.f73027a || this.o) ? this.f73032f.getText().toString() : this.n;
    }

    public void setActionBarPositionTop(boolean z) {
        this.q = z;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        if (this.q) {
            layoutParams.addRule(10);
            layoutParams.addRule(8, 0);
        } else {
            layoutParams.addRule(10, 0);
            layoutParams.addRule(8, R.id.form_item_input);
        }
        this.j.setLayoutParams(layoutParams);
    }

    public void setFormDataTag(Object obj) {
        this.f73035i = obj;
    }

    public void setFormItemListener(m mVar) {
        this.f73033g = mVar;
    }

    public void setFormItemTag(int i2) {
        this.f73034h = i2;
    }

    public void setInputLength(int i2) {
        this.f73032f.setMaxLength(i2);
        this.f73030d = i2;
    }

    public void setNonMaskedField() {
        this.f73027a = true;
    }

    public void setText(String str) {
        this.f73032f.setText(str);
        this.f73032f.setSelection(str.length());
    }

    public void setTitle(String str) {
        this.f73031e.setText(str);
        this.f73028b = str;
    }

    public x a(View view, boolean z) {
        x s = u.s(view);
        float f2 = 0.0f;
        float f3 = 1.0f;
        float f4 = z ? 1.0f : 0.0f;
        View view2 = (View) s.f3139a.get();
        if (view2 != null) {
            view2.animate().scaleY(f4);
        }
        if (z) {
            f2 = 1.0f;
        }
        View view3 = (View) s.f3139a.get();
        if (view3 != null) {
            view3.animate().scaleX(f2);
        }
        x a2 = s.a((Interpolator) new AccelerateInterpolator()).a((y) new l(this, z));
        if (!z) {
            f3 = 0.5f;
        }
        return a2.a(f3);
    }
}
