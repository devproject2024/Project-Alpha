package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new Parcelable.Creator<DateValidatorPointForward>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new DateValidatorPointForward[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final long f36151a;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ DateValidatorPointForward(long j, byte b2) {
        this(j);
    }

    private DateValidatorPointForward(long j) {
        this.f36151a = j;
    }

    public static DateValidatorPointForward a() {
        return new DateValidatorPointForward(Long.MIN_VALUE);
    }

    public final boolean a(long j) {
        return j >= this.f36151a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f36151a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f36151a == ((DateValidatorPointForward) obj).f36151a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f36151a)});
    }
}
