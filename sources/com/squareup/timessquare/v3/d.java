package com.squareup.timessquare.v3;

import java.util.Date;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final Date f45641a;

    /* renamed from: b  reason: collision with root package name */
    final int f45642b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f45643c;

    /* renamed from: d  reason: collision with root package name */
    boolean f45644d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f45645e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f45646f;

    /* renamed from: g  reason: collision with root package name */
    boolean f45647g;

    /* renamed from: h  reason: collision with root package name */
    f f45648h;

    public d(Date date, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, f fVar) {
        this.f45641a = date;
        this.f45643c = z;
        this.f45646f = z2;
        this.f45647g = z5;
        this.f45644d = z3;
        this.f45645e = z4;
        this.f45642b = i2;
        this.f45648h = fVar;
    }

    public final String toString() {
        return "MonthCellDescriptor{date=" + this.f45641a + ", value=" + this.f45642b + ", isCurrentMonth=" + this.f45643c + ", isSelected=" + this.f45644d + ", isToday=" + this.f45645e + ", isSelectable=" + this.f45646f + ", isHighlighted=" + this.f45647g + ", rangeState=" + this.f45648h + '}';
    }
}
