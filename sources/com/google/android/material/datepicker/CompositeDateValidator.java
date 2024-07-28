package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.g.f;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CompositeDateValidator[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CompositeDateValidator((List) f.a(parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader())), (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<CalendarConstraints.DateValidator> f36149a;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ CompositeDateValidator(List list, byte b2) {
        this(list);
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list) {
        this.f36149a = list;
    }

    public final boolean a(long j) {
        for (CalendarConstraints.DateValidator next : this.f36149a) {
            if (next != null && !next.a(j)) {
                return false;
            }
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f36149a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        return this.f36149a.equals(((CompositeDateValidator) obj).f36149a);
    }

    public final int hashCode() {
        return this.f36149a.hashCode();
    }
}
