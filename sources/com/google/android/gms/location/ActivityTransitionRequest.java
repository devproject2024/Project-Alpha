package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<ActivityTransition> f11322a = new x();

    /* renamed from: b  reason: collision with root package name */
    private final List<ActivityTransition> f11323b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11324c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ClientIdentity> f11325d;

    public ActivityTransitionRequest(List<ActivityTransition> list, String str, List<ClientIdentity> list2) {
        s.a(list, (Object) "transitions can't be null");
        s.b(list.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(f11322a);
        for (ActivityTransition next : list) {
            s.b(treeSet.add(next), String.format("Found duplicated transition: %s.", new Object[]{next}));
        }
        this.f11323b = Collections.unmodifiableList(list);
        this.f11324c = str;
        this.f11325d = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            return q.a(this.f11323b, activityTransitionRequest.f11323b) && q.a(this.f11324c, activityTransitionRequest.f11324c) && q.a(this.f11325d, activityTransitionRequest.f11325d);
        }
    }

    public int hashCode() {
        int hashCode = this.f11323b.hashCode() * 31;
        String str = this.f11324c;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.f11325d;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f11323b);
        String str = this.f11324c;
        String valueOf2 = String.valueOf(this.f11325d);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61 + String.valueOf(str).length() + String.valueOf(valueOf2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append('\'');
        sb.append(", mClients=");
        sb.append(valueOf2);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11323b, false);
        b.a(parcel, 2, this.f11324c, false);
        b.a(parcel, 3, this.f11325d, false);
        b.b(parcel, a2);
    }
}
