package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import java.util.Comparator;
import kotlin.g.b.k;

public abstract class ae {

    /* renamed from: a  reason: collision with root package name */
    final boolean f24082a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f24083b;

    public ae() {
        this(false, false, 3);
    }

    public abstract int a();

    public abstract String b();

    static final class a<T> implements Comparator<CJRFlightDetailsItem> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f24084a;

        a(ae aeVar) {
            this.f24084a = aeVar;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            CJRFlightDetailsItem cJRFlightDetailsItem = (CJRFlightDetailsItem) obj;
            CJRFlightDetailsItem cJRFlightDetailsItem2 = (CJRFlightDetailsItem) obj2;
            ae aeVar = this.f24084a;
            k.a((Object) cJRFlightDetailsItem, "lhs");
            Comparable<Object> a2 = aeVar.a(cJRFlightDetailsItem);
            ae aeVar2 = this.f24084a;
            k.a((Object) cJRFlightDetailsItem2, "rhs");
            int compareTo = a2.compareTo(aeVar2.a(cJRFlightDetailsItem2));
            return !this.f24084a.f24082a ? -compareTo : compareTo;
        }
    }

    static final class b<T> implements Comparator<CJRIntlFlightMapping> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ae f24085a;

        b(ae aeVar) {
            this.f24085a = aeVar;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            CJRIntlFlightMapping cJRIntlFlightMapping = (CJRIntlFlightMapping) obj;
            CJRIntlFlightMapping cJRIntlFlightMapping2 = (CJRIntlFlightMapping) obj2;
            ae aeVar = this.f24085a;
            k.a((Object) cJRIntlFlightMapping, "lhs");
            Comparable<Object> a2 = aeVar.a(cJRIntlFlightMapping);
            ae aeVar2 = this.f24085a;
            k.a((Object) cJRIntlFlightMapping2, "rhs");
            int compareTo = a2.compareTo(aeVar2.a(cJRIntlFlightMapping2));
            return !this.f24085a.f24082a ? -compareTo : compareTo;
        }
    }

    public ae(boolean z, boolean z2) {
        this.f24082a = z;
        this.f24083b = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ae(boolean z, boolean z2, int i2) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? true : z2);
    }

    public final Comparator<CJRFlightDetailsItem> c() {
        return new a<>(this);
    }

    public final Comparator<CJRIntlFlightMapping> d() {
        return new b<>(this);
    }

    public Comparable<Object> a(CJRFlightDetailsItem cJRFlightDetailsItem) {
        k.c(cJRFlightDetailsItem, "flight");
        throw new UnsupportedOperationException("This sort type does not support domestic flights");
    }

    public Comparable<Object> a(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        throw new UnsupportedOperationException("This sort type does not support international flights");
    }

    public String b(CJRIntlFlightMapping cJRIntlFlightMapping) {
        k.c(cJRIntlFlightMapping, "flightMapping");
        throw new UnsupportedOperationException("This sort type does not support international flights");
    }
}
