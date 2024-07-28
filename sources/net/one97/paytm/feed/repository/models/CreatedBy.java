package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CreatedBy implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private boolean canFollow;
    private Integer id;
    private String imageUrl;
    private String name;

    public static /* synthetic */ CreatedBy copy$default(CreatedBy createdBy, Integer num, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = createdBy.id;
        }
        if ((i2 & 2) != 0) {
            str = createdBy.name;
        }
        if ((i2 & 4) != 0) {
            str2 = createdBy.imageUrl;
        }
        if ((i2 & 8) != 0) {
            z = createdBy.canFollow;
        }
        return createdBy.copy(num, str, str2, z);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final boolean component4() {
        return this.canFollow;
    }

    public final CreatedBy copy(Integer num, String str, String str2, boolean z) {
        k.c(str, "name");
        k.c(str2, "imageUrl");
        return new CreatedBy(num, str, str2, z);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CreatedBy) {
                CreatedBy createdBy = (CreatedBy) obj;
                if (k.a((Object) this.id, (Object) createdBy.id) && k.a((Object) this.name, (Object) createdBy.name) && k.a((Object) this.imageUrl, (Object) createdBy.imageUrl)) {
                    if (this.canFollow == createdBy.canFollow) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imageUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.canFollow;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "CreatedBy(id=" + this.id + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ", canFollow=" + this.canFollow + ")";
    }

    public CreatedBy(Integer num, String str, String str2, boolean z) {
        k.c(str, "name");
        k.c(str2, "imageUrl");
        this.id = num;
        this.name = str;
        this.imageUrl = str2;
        this.canFollow = z;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        k.c(str, "<set-?>");
        this.imageUrl = str;
    }

    public final boolean getCanFollow() {
        return this.canFollow;
    }

    public final void setCanFollow(boolean z) {
        this.canFollow = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CreatedBy(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.k.c(r5, r0)
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r5.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 != 0) goto L_0x0014
            r0 = 0
        L_0x0014:
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.String r1 = r5.readString()
            if (r1 != 0) goto L_0x001f
            kotlin.g.b.k.a()
        L_0x001f:
            java.lang.String r2 = "parcel.readString()!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r3 = r5.readString()
            if (r3 != 0) goto L_0x002d
            kotlin.g.b.k.a()
        L_0x002d:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            java.lang.Class r2 = java.lang.Boolean.TYPE
            java.lang.ClassLoader r2 = r2.getClassLoader()
            java.lang.Object r5 = r5.readValue(r2)
            if (r5 == 0) goto L_0x0046
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r4.<init>(r0, r1, r3, r5)
            return
        L_0x0046:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Boolean"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.models.CreatedBy.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeValue(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.imageUrl);
        parcel.writeValue(Boolean.valueOf(this.canFollow));
    }

    public static final class CREATOR implements Parcelable.Creator<CreatedBy> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final CreatedBy createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new CreatedBy(parcel);
        }

        public final CreatedBy[] newArray(int i2) {
            return new CreatedBy[i2];
        }
    }
}
