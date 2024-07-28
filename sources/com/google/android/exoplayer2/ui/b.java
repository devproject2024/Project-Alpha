package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;

final class b {
    float A;
    int B;
    int C;
    int D;
    int E;
    StaticLayout F;
    int G;
    int H;
    int I;
    Rect J;

    /* renamed from: a  reason: collision with root package name */
    final float f33580a;

    /* renamed from: b  reason: collision with root package name */
    final float f33581b;

    /* renamed from: c  reason: collision with root package name */
    final float f33582c;

    /* renamed from: d  reason: collision with root package name */
    final float f33583d;

    /* renamed from: e  reason: collision with root package name */
    final float f33584e;

    /* renamed from: f  reason: collision with root package name */
    final TextPaint f33585f = new TextPaint();

    /* renamed from: g  reason: collision with root package name */
    final Paint f33586g;

    /* renamed from: h  reason: collision with root package name */
    CharSequence f33587h;

    /* renamed from: i  reason: collision with root package name */
    Layout.Alignment f33588i;
    Bitmap j;
    float k;
    int l;
    int m;
    float n;
    int o;
    float p;
    float q;
    boolean r;
    boolean s;
    int t;
    int u;
    int v;
    int w;
    int x;
    float y;
    float z;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.f33584e = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f33583d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f33580a = round;
        this.f33581b = round;
        this.f33582c = round;
        this.f33585f.setAntiAlias(true);
        this.f33585f.setSubpixelText(true);
        this.f33586g = new Paint();
        this.f33586g.setAntiAlias(true);
        this.f33586g.setStyle(Paint.Style.FILL);
    }
}
