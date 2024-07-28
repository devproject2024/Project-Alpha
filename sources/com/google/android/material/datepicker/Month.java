package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Parcelable, Comparable<Month> {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new Month[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return Month.a(parcel.readInt(), parcel.readInt());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Calendar f36154a;

    /* renamed from: b  reason: collision with root package name */
    final String f36155b = o.d().format(this.f36154a.getTime());

    /* renamed from: c  reason: collision with root package name */
    final int f36156c = this.f36154a.get(2);

    /* renamed from: d  reason: collision with root package name */
    final int f36157d = this.f36154a.get(1);

    /* renamed from: e  reason: collision with root package name */
    final int f36158e = this.f36154a.getMaximum(7);

    /* renamed from: f  reason: collision with root package name */
    final int f36159f = this.f36154a.getActualMaximum(5);

    /* renamed from: g  reason: collision with root package name */
    final long f36160g = this.f36154a.getTimeInMillis();

    public final int describeContents() {
        return 0;
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        this.f36154a = o.a(calendar);
    }

    static Month a(long j) {
        Calendar b2 = o.b();
        b2.setTimeInMillis(j);
        return new Month(b2);
    }

    static Month a(int i2, int i3) {
        Calendar b2 = o.b();
        b2.set(1, i2);
        b2.set(2, i3);
        return new Month(b2);
    }

    static Month a() {
        return new Month(o.a());
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        int firstDayOfWeek = this.f36154a.get(7) - this.f36154a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f36158e : firstDayOfWeek;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f36156c == month.f36156c && this.f36157d == month.f36157d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f36156c), Integer.valueOf(this.f36157d)});
    }

    /* renamed from: a */
    public final int compareTo(Month month) {
        return this.f36154a.compareTo(month.f36154a);
    }

    /* access modifiers changed from: package-private */
    public final int b(Month month) {
        if (this.f36154a instanceof GregorianCalendar) {
            return ((month.f36157d - this.f36157d) * 12) + (month.f36156c - this.f36156c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* access modifiers changed from: package-private */
    public final long a(int i2) {
        Calendar a2 = o.a(this.f36154a);
        a2.set(5, i2);
        return a2.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public final Month b(int i2) {
        Calendar a2 = o.a(this.f36154a);
        a2.add(2, i2);
        return new Month(a2);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f36157d);
        parcel.writeInt(this.f36156c);
    }
}
