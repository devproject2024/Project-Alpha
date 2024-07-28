package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class AutocompleteFilter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AutocompleteFilter> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final int f11384a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11385b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f11386c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11387d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11388e;

    AutocompleteFilter(int i2, boolean z, List<Integer> list, String str) {
        this.f11384a = i2;
        this.f11386c = list;
        this.f11388e = (list == null || list.isEmpty()) ? 0 : list.iterator().next().intValue();
        this.f11387d = str;
        if (this.f11384a <= 0) {
            this.f11385b = !z;
        } else {
            this.f11385b = z;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f11385b), Integer.valueOf(this.f11388e), this.f11387d});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.f11388e == autocompleteFilter.f11388e && this.f11385b == autocompleteFilter.f11385b && this.f11387d == autocompleteFilter.f11387d;
    }

    public String toString() {
        return q.a((Object) this).a("includeQueryPredictions", Boolean.valueOf(this.f11385b)).a("typeFilter", Integer.valueOf(this.f11388e)).a(AddEditGstinViewModelKt.BODY_PARAM_COUNTRY, this.f11387d).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11385b);
        b.a(parcel, 2, this.f11386c);
        b.a(parcel, 3, this.f11387d, false);
        b.b(parcel, 1000, this.f11384a);
        b.b(parcel, a2);
    }
}
