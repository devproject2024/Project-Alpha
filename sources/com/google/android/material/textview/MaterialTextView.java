package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.h.c;
import com.google.android.material.theme.a.a;

public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a.a(context, attributeSet, i2, i3), attributeSet, i2);
        Context context2 = getContext();
        if (a(context2)) {
            Resources.Theme theme = context2.getTheme();
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i2, i3);
            boolean z = false;
            int a2 = a(context2, obtainStyledAttributes, R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight);
            obtainStyledAttributes.recycle();
            if (!(a2 != -1 ? true : z)) {
                TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i2, i3);
                int resourceId = obtainStyledAttributes2.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
                obtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    a(theme, resourceId);
                }
            }
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (a(context)) {
            a(context.getTheme(), i2);
        }
    }

    private void a(Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
        int a2 = a(getContext(), obtainStyledAttributes, R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (a2 >= 0) {
            setLineHeight(a2);
        }
    }

    private static boolean a(Context context) {
        return b.a(context, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int a(Context context, TypedArray typedArray, int... iArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < 2 && i2 < 0; i3++) {
            i2 = c.d(context, typedArray, iArr[i3]);
        }
        return i2;
    }
}
