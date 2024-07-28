package com.google.android.gms.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.drawable.a;
import com.google.android.gms.b.f;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.i;

public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f8341a;

    /* renamed from: b  reason: collision with root package name */
    private int f8342b;

    /* renamed from: c  reason: collision with root package name */
    private View f8343c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f8344d;

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8344d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignInButton, 0, 0);
        try {
            this.f8341a = obtainStyledAttributes.getInt(R.styleable.SignInButton_buttonSize, 0);
            this.f8342b = obtainStyledAttributes.getInt(R.styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.f8341a, this.f8342b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setSize(int i2) {
        setStyle(i2, this.f8342b);
    }

    public final void setColorScheme(int i2) {
        setStyle(this.f8341a, i2);
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        setStyle(this.f8341a, this.f8342b);
    }

    public final void setStyle(int i2, int i3) {
        this.f8341a = i2;
        this.f8342b = i3;
        Context context = getContext();
        View view = this.f8343c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f8343c = t.a(context, this.f8341a, this.f8342b);
        } catch (f.a unused) {
            int i4 = this.f8341a;
            int i5 = this.f8342b;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            Resources resources = context.getResources();
            signInButtonImpl.setTypeface(Typeface.DEFAULT_BOLD);
            signInButtonImpl.setTextSize(14.0f);
            int i6 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
            signInButtonImpl.setMinHeight(i6);
            signInButtonImpl.setMinWidth(i6);
            int i7 = R.drawable.common_google_signin_btn_icon_dark;
            int i8 = R.drawable.common_google_signin_btn_icon_light;
            int a2 = SignInButtonImpl.a(i5, i7, i8, i8);
            int i9 = R.drawable.common_google_signin_btn_text_dark;
            int i10 = R.drawable.common_google_signin_btn_text_light;
            int a3 = SignInButtonImpl.a(i5, i9, i10, i10);
            if (i4 == 0 || i4 == 1) {
                a2 = a3;
            } else if (i4 != 2) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Unknown button size: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
            Drawable f2 = a.f(resources.getDrawable(a2));
            a.a(f2, resources.getColorStateList(R.color.common_google_signin_btn_tint));
            a.a(f2, PorterDuff.Mode.SRC_ATOP);
            signInButtonImpl.setBackgroundDrawable(f2);
            int i11 = R.color.common_google_signin_btn_text_dark;
            int i12 = R.color.common_google_signin_btn_text_light;
            signInButtonImpl.setTextColor((ColorStateList) s.a(resources.getColorStateList(SignInButtonImpl.a(i5, i11, i12, i12))));
            if (i4 == 0) {
                signInButtonImpl.setText(resources.getString(R.string.common_signin_button_text));
            } else if (i4 == 1) {
                signInButtonImpl.setText(resources.getString(R.string.common_signin_button_text_long));
            } else if (i4 == 2) {
                signInButtonImpl.setText((CharSequence) null);
            } else {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown button size: ");
                sb2.append(i4);
                throw new IllegalStateException(sb2.toString());
            }
            signInButtonImpl.setTransformationMethod((TransformationMethod) null);
            if (i.a(signInButtonImpl.getContext().getPackageManager())) {
                signInButtonImpl.setGravity(19);
            }
            this.f8343c = signInButtonImpl;
        }
        addView(this.f8343c);
        this.f8343c.setEnabled(isEnabled());
        this.f8343c.setOnClickListener(this);
    }

    @Deprecated
    public final void setStyle(int i2, int i3, Scope[] scopeArr) {
        setStyle(i2, i3);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8344d = onClickListener;
        View view = this.f8343c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f8343c.setEnabled(z);
    }

    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f8344d;
        if (onClickListener != null && view == this.f8343c) {
            onClickListener.onClick(this);
        }
    }
}
