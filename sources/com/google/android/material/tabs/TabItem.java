package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ac;
import com.google.android.material.R;

public class TabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f36720a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f36721b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36722c;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ac a2 = ac.a(context, attributeSet, R.styleable.TabItem);
        this.f36720a = a2.c(R.styleable.TabItem_android_text);
        this.f36721b = a2.a(R.styleable.TabItem_android_icon);
        this.f36722c = a2.g(R.styleable.TabItem_android_layout, 0);
        a2.f1669a.recycle();
    }
}
