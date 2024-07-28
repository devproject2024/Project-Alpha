package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (byte) 0);
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final Month f36137a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final Month f36138b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final Month f36139c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public final DateValidator f36140d;

    /* renamed from: e  reason: collision with root package name */
    final int f36141e;

    /* renamed from: f  reason: collision with root package name */
    final int f36142f;

    public interface DateValidator extends Parcelable {
        boolean a(long j);
    }

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator, byte b2) {
        this(month, month2, month3, dateValidator);
    }

    private CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator) {
        this.f36137a = month;
        this.f36138b = month2;
        this.f36139c = month3;
        this.f36140d = dateValidator;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3.compareTo(month2) <= 0) {
            this.f36142f = month.b(month2) + 1;
            this.f36141e = (month2.f36157d - month.f36157d) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f36137a.equals(calendarConstraints.f36137a) && this.f36138b.equals(calendarConstraints.f36138b) && this.f36139c.equals(calendarConstraints.f36139c) && this.f36140d.equals(calendarConstraints.f36140d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f36137a, this.f36138b, this.f36139c, this.f36140d});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f36137a, 0);
        parcel.writeParcelable(this.f36138b, 0);
        parcel.writeParcelable(this.f36139c, 0);
        parcel.writeParcelable(this.f36140d, 0);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final long f36143a = o.a(Month.a(1900, 0).f36160g);

        /* renamed from: b  reason: collision with root package name */
        static final long f36144b = o.a(Month.a(2100, 11).f36160g);

        /* renamed from: c  reason: collision with root package name */
        long f36145c = f36143a;

        /* renamed from: d  reason: collision with root package name */
        long f36146d = f36144b;

        /* renamed from: e  reason: collision with root package name */
        Long f36147e;

        /* renamed from: f  reason: collision with root package name */
        DateValidator f36148f = DateValidatorPointForward.a();

        public a() {
        }

        a(CalendarConstraints calendarConstraints) {
            this.f36145c = calendarConstraints.f36137a.f36160g;
            this.f36146d = calendarConstraints.f36138b.f36160g;
            this.f36147e = Long.valueOf(calendarConstraints.f36139c.f36160g);
            this.f36148f = calendarConstraints.f36140d;
        }
    }
}
