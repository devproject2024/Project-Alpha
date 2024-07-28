package com.google.android.exoplayer2.e;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.g.ae;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f31388a = new a(-1, -16777216, 0, 0, -1, (Typeface) null);

    /* renamed from: b  reason: collision with root package name */
    public final int f31389b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31390c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31391d;

    /* renamed from: e  reason: collision with root package name */
    public final int f31392e;

    /* renamed from: f  reason: collision with root package name */
    public final int f31393f;

    /* renamed from: g  reason: collision with root package name */
    public final Typeface f31394g;

    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        CaptioningManager.CaptionStyle captionStyle2 = captionStyle;
        if (ae.f32499a < 21) {
            return new a(captionStyle2.foregroundColor, captionStyle2.backgroundColor, 0, captionStyle2.edgeType, captionStyle2.edgeColor, captionStyle.getTypeface());
        }
        return new a(captionStyle.hasForegroundColor() ? captionStyle2.foregroundColor : f31388a.f31389b, captionStyle.hasBackgroundColor() ? captionStyle2.backgroundColor : f31388a.f31390c, captionStyle.hasWindowColor() ? captionStyle2.windowColor : f31388a.f31391d, captionStyle.hasEdgeType() ? captionStyle2.edgeType : f31388a.f31392e, captionStyle.hasEdgeColor() ? captionStyle2.edgeColor : f31388a.f31393f, captionStyle.getTypeface());
    }

    private a(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        this.f31389b = i2;
        this.f31390c = i3;
        this.f31391d = i4;
        this.f31392e = i5;
        this.f31393f = i6;
        this.f31394g = typeface;
    }
}
