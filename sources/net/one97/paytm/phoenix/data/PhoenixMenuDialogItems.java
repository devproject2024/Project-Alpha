package net.one97.paytm.phoenix.data;

import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;

public final class PhoenixMenuDialogItems {
    private String description;
    private String image;
    private int uniqueID;

    public static /* synthetic */ PhoenixMenuDialogItems copy$default(PhoenixMenuDialogItems phoenixMenuDialogItems, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = phoenixMenuDialogItems.uniqueID;
        }
        if ((i3 & 2) != 0) {
            str = phoenixMenuDialogItems.image;
        }
        if ((i3 & 4) != 0) {
            str2 = phoenixMenuDialogItems.description;
        }
        return phoenixMenuDialogItems.copy(i2, str, str2);
    }

    public final int component1() {
        return this.uniqueID;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.description;
    }

    public final PhoenixMenuDialogItems copy(int i2, String str, String str2) {
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        return new PhoenixMenuDialogItems(i2, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PhoenixMenuDialogItems) {
                PhoenixMenuDialogItems phoenixMenuDialogItems = (PhoenixMenuDialogItems) obj;
                if (!(this.uniqueID == phoenixMenuDialogItems.uniqueID) || !k.a((Object) this.image, (Object) phoenixMenuDialogItems.image) || !k.a((Object) this.description, (Object) phoenixMenuDialogItems.description)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.uniqueID).hashCode() * 31;
        String str = this.image;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "PhoenixMenuDialogItems(uniqueID=" + this.uniqueID + ", image=" + this.image + ", description=" + this.description + ")";
    }

    public PhoenixMenuDialogItems(int i2, String str, String str2) {
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        this.uniqueID = i2;
        this.image = str;
        this.description = str2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImage() {
        return this.image;
    }

    public final int getUniqueID() {
        return this.uniqueID;
    }

    public final void setDescription(String str) {
        k.c(str, "<set-?>");
        this.description = str;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setUniqueID(int i2) {
        this.uniqueID = i2;
    }
}
