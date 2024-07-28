package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Gratification implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private ArrayList<Freebie> freebieList;
    private String icon;
    private String listId;
    private String listUrl;
    private String saving;
    private String text;
    private String title;

    public Gratification() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 127, (g) null);
    }

    public static /* synthetic */ Gratification copy$default(Gratification gratification, String str, String str2, String str3, String str4, String str5, String str6, ArrayList<Freebie> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gratification.icon;
        }
        if ((i2 & 2) != 0) {
            str2 = gratification.title;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = gratification.text;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = gratification.saving;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = gratification.listId;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = gratification.listUrl;
        }
        String str11 = str6;
        if ((i2 & 64) != 0) {
            arrayList = gratification.freebieList;
        }
        return gratification.copy(str, str7, str8, str9, str10, str11, arrayList);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.saving;
    }

    public final String component5() {
        return this.listId;
    }

    public final String component6() {
        return this.listUrl;
    }

    public final ArrayList<Freebie> component7() {
        return this.freebieList;
    }

    public final Gratification copy(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<Freebie> arrayList) {
        return new Gratification(str, str2, str3, str4, str5, str6, arrayList);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Gratification)) {
            return false;
        }
        Gratification gratification = (Gratification) obj;
        return k.a((Object) this.icon, (Object) gratification.icon) && k.a((Object) this.title, (Object) gratification.title) && k.a((Object) this.text, (Object) gratification.text) && k.a((Object) this.saving, (Object) gratification.saving) && k.a((Object) this.listId, (Object) gratification.listId) && k.a((Object) this.listUrl, (Object) gratification.listUrl) && k.a((Object) this.freebieList, (Object) gratification.freebieList);
    }

    public final int hashCode() {
        String str = this.icon;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.saving;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.listId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.listUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ArrayList<Freebie> arrayList = this.freebieList;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "Gratification(icon=" + this.icon + ", title=" + this.title + ", text=" + this.text + ", saving=" + this.saving + ", listId=" + this.listId + ", listUrl=" + this.listUrl + ", freebieList=" + this.freebieList + ")";
    }

    public Gratification(String str, String str2, String str3, String str4, String str5, String str6, ArrayList<Freebie> arrayList) {
        this.icon = str;
        this.title = str2;
        this.text = str3;
        this.saving = str4;
        this.listId = str5;
        this.listUrl = str6;
        this.freebieList = arrayList;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getSaving() {
        return this.saving;
    }

    public final void setSaving(String str) {
        this.saving = str;
    }

    public final String getListId() {
        return this.listId;
    }

    public final void setListId(String str) {
        this.listId = str;
    }

    public final String getListUrl() {
        return this.listUrl;
    }

    public final void setListUrl(String str) {
        this.listUrl = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Gratification(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.ArrayList r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.model.Gratification.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, int, kotlin.g.b.g):void");
    }

    public final ArrayList<Freebie> getFreebieList() {
        return this.freebieList;
    }

    public final void setFreebieList(ArrayList<Freebie> arrayList) {
        this.freebieList = arrayList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Gratification(android.os.Parcel r10) {
        /*
            r9 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            java.lang.String r4 = r10.readString()
            java.lang.String r5 = r10.readString()
            java.lang.String r6 = r10.readString()
            java.lang.String r7 = r10.readString()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r0 = r8
            java.util.List r0 = (java.util.List) r0
            java.lang.Class<net.one97.paytm.nativesdk.orflow.promo.model.Freebie> r1 = net.one97.paytm.nativesdk.orflow.promo.model.Freebie.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r10.readList(r0, r1)
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.model.Gratification.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.icon);
        parcel.writeString(this.title);
        parcel.writeString(this.text);
        parcel.writeString(this.saving);
        parcel.writeString(this.listId);
        parcel.writeString(this.listUrl);
        ArrayList<Freebie> arrayList = this.freebieList;
        if (arrayList != null) {
            parcel.writeList(arrayList);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.nativesdk.orflow.promo.model.Freebie>");
    }

    public static final class CREATOR implements Parcelable.Creator<Gratification> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final Gratification create(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            Gratification gratification = new Gratification((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 127, (g) null);
            gratification.setIcon(jSONObject.optString(H5Param.MENU_ICON));
            gratification.setTitle(jSONObject.optString("title"));
            gratification.setText(jSONObject.optString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
            gratification.setSaving(jSONObject.optString("saving"));
            gratification.setListId(jSONObject.optString("listId"));
            gratification.setListUrl(jSONObject.optString("listUrl"));
            return gratification;
        }

        public final ArrayList<Gratification> createGratificationArray(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList<Gratification> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(create(jSONArray.getJSONObject(i2)));
            }
            return arrayList;
        }

        public final Gratification createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new Gratification(parcel);
        }

        public final Gratification[] newArray(int i2) {
            return new Gratification[i2];
        }
    }
}
