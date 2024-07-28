package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator<DateValidatorPointBackward>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new DateValidatorPointBackward[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong(), (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final long f36150a;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ DateValidatorPointBackward(long j, byte b2) {
        this(j);
    }

    private DateValidatorPointBackward(long j) {
        this.f36150a = j;
    }

    public final boolean a(long j) {
        return j <= this.f36150a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f36150a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.f36150a == ((DateValidatorPointBackward) obj).f36150a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f36150a)});
    }
}
