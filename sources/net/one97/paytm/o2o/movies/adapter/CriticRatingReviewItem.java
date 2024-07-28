package net.one97.paytm.o2o.movies.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import kotlin.u;

public final class CriticRatingReviewItem implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    @b(a = "source_id")

    /* renamed from: a  reason: collision with root package name */
    public final int f74227a;
    @b(a = "dwh_source")

    /* renamed from: b  reason: collision with root package name */
    public final DwhSource f74228b;
    @b(a = "reviewer")

    /* renamed from: c  reason: collision with root package name */
    public final String f74229c;
    @b(a = "value")

    /* renamed from: d  reason: collision with root package name */
    public String f74230d;
    @b(a = "text")

    /* renamed from: e  reason: collision with root package name */
    public final String f74231e;
    @b(a = "date")

    /* renamed from: f  reason: collision with root package name */
    public final String f74232f;
    @b(a = "rated_by")

    /* renamed from: g  reason: collision with root package name */
    public String f74233g;

    /* renamed from: h  reason: collision with root package name */
    private final Integer f74234h;
    @b(a = "content_id")

    /* renamed from: i  reason: collision with root package name */
    private final Integer f74235i;

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "CriticRatingReviewItem(id=" + this.f74234h + ", contentId=" + this.f74235i + ", sourceId=" + this.f74227a + ", source=" + this.f74228b + ", reviewer=" + this.f74229c + ", value=" + this.f74230d + ", text=" + this.f74231e + ", date=" + this.f74232f + ", ratedBy=" + this.f74233g + ")";
    }

    public CriticRatingReviewItem(Integer num, Integer num2, int i2, DwhSource dwhSource, String str, String str2, String str3, String str4, String str5) {
        this.f74234h = num;
        this.f74235i = num2;
        this.f74227a = i2;
        this.f74228b = dwhSource;
        this.f74229c = str;
        this.f74230d = str2;
        this.f74231e = str3;
        this.f74232f = str4;
        this.f74233g = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CriticRatingReviewItem(android.os.Parcel r14) {
        /*
            r13 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.k.c(r14, r0)
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r14.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            r2 = 0
            if (r1 != 0) goto L_0x0015
            r0 = r2
        L_0x0015:
            r4 = r0
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r14.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 != 0) goto L_0x0027
            r0 = r2
        L_0x0027:
            r5 = r0
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r6 = r14.readInt()
            java.lang.Class<net.one97.paytm.o2o.movies.adapter.DwhSource> r0 = net.one97.paytm.o2o.movies.adapter.DwhSource.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r14.readParcelable(r0)
            r7 = r0
            net.one97.paytm.o2o.movies.adapter.DwhSource r7 = (net.one97.paytm.o2o.movies.adapter.DwhSource) r7
            java.lang.String r8 = r14.readString()
            java.lang.String r9 = r14.readString()
            java.lang.String r10 = r14.readString()
            java.lang.String r11 = r14.readString()
            java.lang.String r12 = r14.readString()
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (!k.a((Object) obj != null ? obj.getClass() : null, (Object) getClass())) {
            return false;
        }
        if (obj != null) {
            return Integer.valueOf(this.f74227a).equals(Integer.valueOf(((CriticRatingReviewItem) obj).f74227a));
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem");
    }

    public final int hashCode() {
        return Integer.valueOf(this.f74227a).hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeValue(this.f74234h);
        parcel.writeValue(this.f74235i);
        parcel.writeInt(this.f74227a);
        parcel.writeParcelable(this.f74228b, i2);
        parcel.writeString(this.f74229c);
        parcel.writeString(this.f74230d);
        parcel.writeString(this.f74231e);
        parcel.writeString(this.f74232f);
        parcel.writeString(this.f74233g);
    }

    public static final class a implements Parcelable.Creator<CriticRatingReviewItem> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new CriticRatingReviewItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CriticRatingReviewItem[i2];
        }
    }
}
