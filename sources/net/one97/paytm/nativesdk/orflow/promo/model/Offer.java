package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import org.json.JSONObject;

public final class Offer implements Parcelable {
    public static final Parcelable.Creator<Offer> CREATOR = new Offer$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((g) null);
    private String icon;
    private String pdpIcon;
    private String selectedText;
    private String text;
    private String title;

    public Offer() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ Offer copy$default(Offer offer, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = offer.title;
        }
        if ((i2 & 2) != 0) {
            str2 = offer.text;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = offer.selectedText;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = offer.icon;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = offer.pdpIcon;
        }
        return offer.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.selectedText;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.pdpIcon;
    }

    public final Offer copy(String str, String str2, String str3, String str4, String str5) {
        return new Offer(str, str2, str3, str4, str5);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offer)) {
            return false;
        }
        Offer offer = (Offer) obj;
        return k.a((Object) this.title, (Object) offer.title) && k.a((Object) this.text, (Object) offer.text) && k.a((Object) this.selectedText, (Object) offer.selectedText) && k.a((Object) this.icon, (Object) offer.icon) && k.a((Object) this.pdpIcon, (Object) offer.pdpIcon);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.selectedText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.icon;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.pdpIcon;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "Offer(title=" + this.title + ", text=" + this.text + ", selectedText=" + this.selectedText + ", icon=" + this.icon + ", pdpIcon=" + this.pdpIcon + ")";
    }

    public Offer(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.text = str2;
        this.selectedText = str3;
        this.icon = str4;
        this.pdpIcon = str5;
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

    public final String getSelectedText() {
        return this.selectedText;
    }

    public final void setSelectedText(String str) {
        this.selectedText = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Offer(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.model.Offer.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getPdpIcon() {
        return this.pdpIcon;
    }

    public final void setPdpIcon(String str) {
        this.pdpIcon = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Offer(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        k.c(parcel, "source");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "dest");
        parcel.writeString(this.title);
        parcel.writeString(this.text);
        parcel.writeString(this.selectedText);
        parcel.writeString(this.icon);
        parcel.writeString(this.pdpIcon);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Offer create(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            Offer offer = new Offer((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
            offer.setTitle(jSONObject.optString("title"));
            offer.setText(jSONObject.optString(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
            offer.setSelectedText(jSONObject.optString("selectedText"));
            offer.setIcon(jSONObject.optString(H5Param.MENU_ICON));
            offer.setPdpIcon(jSONObject.optString("pdpIcon"));
            return offer;
        }
    }
}
