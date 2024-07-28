package net.one97.paytm.phoenix.data;

import java.io.Serializable;
import kotlin.g.b.k;

public final class PhoenixMiniAppDialogItems implements Serializable {
    private final String appName;
    private final String deeplink;
    private final String icon;
    private final String longLable;
    private final String path;
    private final String qParam;
    private final String shortlable;

    public static /* synthetic */ PhoenixMiniAppDialogItems copy$default(PhoenixMiniAppDialogItems phoenixMiniAppDialogItems, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = phoenixMiniAppDialogItems.shortlable;
        }
        if ((i2 & 2) != 0) {
            str2 = phoenixMiniAppDialogItems.longLable;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = phoenixMiniAppDialogItems.deeplink;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = phoenixMiniAppDialogItems.icon;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = phoenixMiniAppDialogItems.appName;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = phoenixMiniAppDialogItems.path;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = phoenixMiniAppDialogItems.qParam;
        }
        return phoenixMiniAppDialogItems.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.shortlable;
    }

    public final String component2() {
        return this.longLable;
    }

    public final String component3() {
        return this.deeplink;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.appName;
    }

    public final String component6() {
        return this.path;
    }

    public final String component7() {
        return this.qParam;
    }

    public final PhoenixMiniAppDialogItems copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str5, "appName");
        return new PhoenixMiniAppDialogItems(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoenixMiniAppDialogItems)) {
            return false;
        }
        PhoenixMiniAppDialogItems phoenixMiniAppDialogItems = (PhoenixMiniAppDialogItems) obj;
        return k.a((Object) this.shortlable, (Object) phoenixMiniAppDialogItems.shortlable) && k.a((Object) this.longLable, (Object) phoenixMiniAppDialogItems.longLable) && k.a((Object) this.deeplink, (Object) phoenixMiniAppDialogItems.deeplink) && k.a((Object) this.icon, (Object) phoenixMiniAppDialogItems.icon) && k.a((Object) this.appName, (Object) phoenixMiniAppDialogItems.appName) && k.a((Object) this.path, (Object) phoenixMiniAppDialogItems.path) && k.a((Object) this.qParam, (Object) phoenixMiniAppDialogItems.qParam);
    }

    public final int hashCode() {
        String str = this.shortlable;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.longLable;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deeplink;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.icon;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.appName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.path;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.qParam;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "PhoenixMiniAppDialogItems(shortlable=" + this.shortlable + ", longLable=" + this.longLable + ", deeplink=" + this.deeplink + ", icon=" + this.icon + ", appName=" + this.appName + ", path=" + this.path + ", qParam=" + this.qParam + ")";
    }

    public PhoenixMiniAppDialogItems(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        k.c(str5, "appName");
        this.shortlable = str;
        this.longLable = str2;
        this.deeplink = str3;
        this.icon = str4;
        this.appName = str5;
        this.path = str6;
        this.qParam = str7;
    }

    public final String getShortlable() {
        return this.shortlable;
    }

    public final String getLongLable() {
        return this.longLable;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getQParam() {
        return this.qParam;
    }
}
