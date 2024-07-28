package net.one97.paytm.wifi.models;

import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class WifiStatus {
    private final int oldStatus;
    private final int status;
    private final String statusText;

    public static /* synthetic */ WifiStatus copy$default(WifiStatus wifiStatus, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = wifiStatus.status;
        }
        if ((i4 & 2) != 0) {
            i3 = wifiStatus.oldStatus;
        }
        if ((i4 & 4) != 0) {
            str = wifiStatus.statusText;
        }
        return wifiStatus.copy(i2, i3, str);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.oldStatus;
    }

    public final String component3() {
        return this.statusText;
    }

    public final WifiStatus copy(int i2, int i3, String str) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT);
        return new WifiStatus(i2, i3, str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof WifiStatus) {
                WifiStatus wifiStatus = (WifiStatus) obj;
                if (this.status == wifiStatus.status) {
                    if (!(this.oldStatus == wifiStatus.oldStatus) || !k.a((Object) this.statusText, (Object) wifiStatus.statusText)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = ((this.status * 31) + this.oldStatus) * 31;
        String str = this.statusText;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "WifiStatus(status=" + this.status + ", oldStatus=" + this.oldStatus + ", statusText=" + this.statusText + ")";
    }

    public WifiStatus(int i2, int i3, String str) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT);
        this.status = i2;
        this.oldStatus = i3;
        this.statusText = str;
    }

    public final int getOldStatus() {
        return this.oldStatus;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusText() {
        return this.statusText;
    }
}
