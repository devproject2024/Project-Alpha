package net.one97.paytm.o2o.movies.common.customui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import net.one97.paytm.o2o.movies.R;

public class CustomTabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    final CharSequence f75034a;

    /* renamed from: b  reason: collision with root package name */
    final Drawable f75035b;

    /* renamed from: c  reason: collision with root package name */
    final int f75036c;

    public CustomTabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomTabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTabItem, 0, 0);
        this.f75034a = obtainStyledAttributes.getText(R.styleable.CustomTabItem_android_text);
        this.f75035b = obtainStyledAttributes.getDrawable(R.styleable.CustomTabItem_android_icon);
        this.f75036c = obtainStyledAttributes.getResourceId(R.styleable.CustomTabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
