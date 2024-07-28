package com.squareup.timessquare.v4;

import java.util.Date;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final Date f45695a;

    /* renamed from: b  reason: collision with root package name */
    final int f45696b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f45697c;

    /* renamed from: d  reason: collision with root package name */
    boolean f45698d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f45699e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f45700f;

    /* renamed from: g  reason: collision with root package name */
    boolean f45701g;

    /* renamed from: h  reason: collision with root package name */
    f f45702h;

    public d(Date date, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2, f fVar) {
        this.f45695a = date;
        this.f45697c = z;
        this.f45700f = z2;
        this.f45701g = z5;
        this.f45698d = z3;
        this.f45699e = z4;
        this.f45696b = i2;
        this.f45702h = fVar;
    }

    public final String toString() {
        return "MonthCellDescriptor{date=" + this.f45695a + ", value=" + this.f45696b + ", isCurrentMonth=" + this.f45697c + ", isSelected=" + this.f45698d + ", isToday=" + this.f45699e + ", isSelectable=" + this.f45700f + ", isHighlighted=" + this.f45701g + ", rangeState=" + this.f45702h + '}';
    }
}
