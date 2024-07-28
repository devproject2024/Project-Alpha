package com.business.common_module.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.business.common_module.R;
import com.business.common_module.view.widget.a.a;
import com.business.common_module.view.widget.a.b;
import kotlin.g.b.k;

public final class CustomCheckBox extends AppCompatCheckBox {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomCheckBox(Context context) {
        super(context);
        k.d(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.d(context, "context");
        if (!isInEditMode()) {
            a(context, attributeSet);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.d(context, "context");
        if (!isInEditMode()) {
            a(context, attributeSet);
        }
    }

    /* JADX INFO: finally extract failed */
    private final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomCheckbox);
        k.b(obtainStyledAttributes, "context.obtainStyledAttr…styleable.CustomCheckbox)");
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.CustomCheckbox_custom_cb_font_name, 4);
            obtainStyledAttributes.recycle();
            if (isInEditMode()) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                a aVar = a.f7381a;
                setTypeface(a.a(Integer.valueOf(integer)));
                return;
            }
            b bVar = b.f7383a;
            setTypeface(b.a(Integer.valueOf(integer)));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
