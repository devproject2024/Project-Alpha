package com.squareup.timessquare.v2;

import java.util.Date;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final Date f45586a;

    /* renamed from: b  reason: collision with root package name */
    final int f45587b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f45588c;

    /* renamed from: d  reason: collision with root package name */
    boolean f45589d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f45590e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f45591f;

    /* renamed from: g  reason: collision with root package name */
    boolean f45592g;

    /* renamed from: h  reason: collision with root package name */
    boolean f45593h;

    /* renamed from: i  reason: collision with root package name */
    f f45594i;
    private boolean j;

    d(Date date, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, f fVar) {
        this.f45586a = date;
        this.f45588c = z;
        this.f45591f = z2;
        this.f45592g = z5;
        this.f45589d = z3;
        this.f45590e = z4;
        this.f45587b = i2;
        this.f45594i = fVar;
    }

    public final String toString() {
        return "MonthCellDescriptor{date=" + this.f45586a + ", value=" + this.f45587b + ", isCurrentMonth=" + this.f45588c + ", isSelected=" + this.f45589d + ", isToday=" + this.f45590e + ", isSelectable=" + this.f45591f + ", isHighlighted=" + this.f45592g + ", rangeState=" + this.f45594i + "isDeactivated=" + this.j + '}';
    }
}
