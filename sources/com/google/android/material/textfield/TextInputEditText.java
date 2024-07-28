package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import com.google.android.material.internal.c;
import com.google.android.material.internal.k;
import com.google.android.material.theme.a.a;

public class TextInputEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f36778a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f36779b;

    public TextInputEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i2) {
        super(a.a(context, attributeSet, i2, 0), attributeSet, i2);
        this.f36778a = new Rect();
        TypedArray a2 = k.a(context, attributeSet, R.styleable.TextInputEditText, i2, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(a2.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        a2.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.f36783c && super.getHint() == null && c.a()) {
            setHint("");
        }
    }

    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.f36783c) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.f36779b = z;
    }

    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f36779b && rect != null) {
            textInputLayout.getFocusedRect(this.f36778a);
            rect.bottom = this.f36778a.bottom;
        }
    }

    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout == null || !this.f36779b || rect == null)) {
            textInputLayout.getGlobalVisibleRect(this.f36778a, point);
            rect.bottom = this.f36778a.bottom;
        }
        return globalVisibleRect;
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f36779b) {
            this.f36778a.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f36778a, true);
        }
        return requestRectangleOnScreen;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            Editable text = getText();
            CharSequence hint = textInputLayout.getHint();
            CharSequence helperText = textInputLayout.getHelperText();
            CharSequence error = textInputLayout.getError();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(helperText);
            boolean z4 = !TextUtils.isEmpty(error);
            String str = "";
            String charSequence = z2 ? hint.toString() : str;
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(((z4 || z3) && !TextUtils.isEmpty(charSequence)) ? ", " : str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (!z4) {
                error = z3 ? helperText : str;
            }
            sb3.append(error);
            String sb4 = sb3.toString();
            if (z) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(text);
                if (!TextUtils.isEmpty(sb4)) {
                    str = ", ".concat(String.valueOf(sb4));
                }
                sb5.append(str);
                str = sb5.toString();
            } else if (!TextUtils.isEmpty(sb4)) {
                str = sb4;
            }
            accessibilityNodeInfo.setText(str);
        }
    }
}
