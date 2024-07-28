package com.business.common_module.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.business.common_module.R;
import com.business.common_module.view.widget.a.a;
import com.business.common_module.view.widget.a.b;
import java.util.HashMap;
import kotlin.g.b.k;

public class CustomTextView extends AppCompatTextView {
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context) {
        super(context);
        k.d(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.d(context, "context");
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.d(context, "context");
        if (!isInEditMode()) {
            setAttribute(context, attributeSet);
        }
    }

    /* JADX INFO: finally extract failed */
    private final void setAttribute(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTextView);
        k.b(obtainStyledAttributes, "context.obtainStyledAttr…styleable.CustomTextView)");
        try {
            int integer = obtainStyledAttributes.getInteger(R.styleable.CustomTextView_custom_tv_font_name, 4);
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

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setHorizontalFadingEdgeEnabled(false);
    }
}
