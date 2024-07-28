package com.squareup.timessquare;

import java.util.Date;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final Date f45535a;

    /* renamed from: b  reason: collision with root package name */
    final int f45536b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f45537c;

    /* renamed from: d  reason: collision with root package name */
    boolean f45538d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f45539e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f45540f;

    /* renamed from: g  reason: collision with root package name */
    boolean f45541g;

    /* renamed from: h  reason: collision with root package name */
    a f45542h;

    public enum a {
        NONE,
        FIRST,
        MIDDLE,
        LAST
    }

    public d(Date date, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, a aVar) {
        this.f45535a = date;
        this.f45537c = z;
        this.f45540f = z2;
        this.f45541g = z5;
        this.f45538d = z3;
        this.f45539e = z4;
        this.f45536b = i2;
        this.f45542h = aVar;
    }

    public final String toString() {
        return "MonthCellDescriptor{date=" + this.f45535a + ", value=" + this.f45536b + ", isCurrentMonth=" + this.f45537c + ", isSelected=" + this.f45538d + ", isToday=" + this.f45539e + ", isSelectable=" + this.f45540f + ", isHighlighted=" + this.f45541g + ", rangeState=" + this.f45542h + '}';
    }
}
