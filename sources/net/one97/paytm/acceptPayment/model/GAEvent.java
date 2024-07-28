package net.one97.paytm.acceptPayment.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class GAEvent {
    public final String eventAction;
    public final String eventCategory;
    public String eventLabel;
    public String eventLabel2;
    public String eventLabel3;
    public String eventLabel4;
    public String screenName;

    public GAEvent(String str, String str2) {
        this(str, str2, (String) null, (String) null, (String) null, (String) null, (String) null, 124, (g) null);
    }

    public GAEvent(String str, String str2, String str3) {
        this(str, str2, str3, (String) null, (String) null, (String) null, (String) null, 120, (g) null);
    }

    public GAEvent(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, (String) null, (String) null, (String) null, 112, (g) null);
    }

    public GAEvent(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, (String) null, (String) null, 96, (g) null);
    }

    public GAEvent(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, (String) null, 64, (g) null);
    }

    public static /* synthetic */ GAEvent copy$default(GAEvent gAEvent, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gAEvent.eventCategory;
        }
        if ((i2 & 2) != 0) {
            str2 = gAEvent.eventAction;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = gAEvent.eventLabel;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = gAEvent.eventLabel2;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = gAEvent.eventLabel3;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = gAEvent.eventLabel4;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = gAEvent.screenName;
        }
        return gAEvent.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.eventCategory;
    }

    public final String component2() {
        return this.eventAction;
    }

    public final String component3() {
        return this.eventLabel;
    }

    public final String component4() {
        return this.eventLabel2;
    }

    public final String component5() {
        return this.eventLabel3;
    }

    public final String component6() {
        return this.eventLabel4;
    }

    public final String component7() {
        return this.screenName;
    }

    public final GAEvent copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.d(str, "eventCategory");
        k.d(str2, "eventAction");
        k.d(str3, "eventLabel");
        k.d(str4, "eventLabel2");
        k.d(str5, "eventLabel3");
        k.d(str6, "eventLabel4");
        String str8 = str7;
        k.d(str8, SDKConstants.EVENT_KEY_SCREEN_NAME);
        return new GAEvent(str, str2, str3, str4, str5, str6, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GAEvent)) {
            return false;
        }
        GAEvent gAEvent = (GAEvent) obj;
        return k.a((Object) this.eventCategory, (Object) gAEvent.eventCategory) && k.a((Object) this.eventAction, (Object) gAEvent.eventAction) && k.a((Object) this.eventLabel, (Object) gAEvent.eventLabel) && k.a((Object) this.eventLabel2, (Object) gAEvent.eventLabel2) && k.a((Object) this.eventLabel3, (Object) gAEvent.eventLabel3) && k.a((Object) this.eventLabel4, (Object) gAEvent.eventLabel4) && k.a((Object) this.screenName, (Object) gAEvent.screenName);
    }

    public final int hashCode() {
        String str = this.eventCategory;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.eventAction;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.eventLabel;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.eventLabel2;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.eventLabel3;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.eventLabel4;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.screenName;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "GAEvent(eventCategory=" + this.eventCategory + ", eventAction=" + this.eventAction + ", eventLabel=" + this.eventLabel + ", eventLabel2=" + this.eventLabel2 + ", eventLabel3=" + this.eventLabel3 + ", eventLabel4=" + this.eventLabel4 + ", screenName=" + this.screenName + ")";
    }

    public GAEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.d(str, "eventCategory");
        k.d(str2, "eventAction");
        k.d(str3, "eventLabel");
        k.d(str4, "eventLabel2");
        k.d(str5, "eventLabel3");
        k.d(str6, "eventLabel4");
        k.d(str7, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.eventCategory = str;
        this.eventAction = str2;
        this.eventLabel = str3;
        this.eventLabel2 = str4;
        this.eventLabel3 = str5;
        this.eventLabel4 = str6;
        this.screenName = str7;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GAEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, g gVar) {
        this(str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7);
    }
}
