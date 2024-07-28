package com.paytm.notification.b;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<c> f43008a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b) && k.a((Object) this.f43008a, (Object) ((b) obj).f43008a);
        }
        return true;
    }

    public final int hashCode() {
        ArrayList<c> arrayList = this.f43008a;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "ActivityLogData(list=" + this.f43008a + ")";
    }

    public b(ArrayList<c> arrayList) {
        k.c(arrayList, "list");
        this.f43008a = arrayList;
    }

    public final void a(ArrayList<c> arrayList) {
        k.c(arrayList, "<set-?>");
        this.f43008a = arrayList;
    }
}
