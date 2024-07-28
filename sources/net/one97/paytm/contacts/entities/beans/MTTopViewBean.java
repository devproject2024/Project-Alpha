package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class MTTopViewBean extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isAdded;
    private boolean showSettingOption;

    public static /* synthetic */ MTTopViewBean copy$default(MTTopViewBean mTTopViewBean, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = mTTopViewBean.isAdded;
        }
        if ((i2 & 2) != 0) {
            z2 = mTTopViewBean.showSettingOption;
        }
        return mTTopViewBean.copy(z, z2);
    }

    public final boolean component1() {
        return this.isAdded;
    }

    public final boolean component2() {
        return this.showSettingOption;
    }

    public final MTTopViewBean copy(boolean z, boolean z2) {
        return new MTTopViewBean(z, z2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MTTopViewBean) {
                MTTopViewBean mTTopViewBean = (MTTopViewBean) obj;
                if (this.isAdded == mTTopViewBean.isAdded) {
                    if (this.showSettingOption == mTTopViewBean.showSettingOption) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.isAdded;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.showSettingOption;
        if (!z3) {
            z2 = z3;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "MTTopViewBean(isAdded=" + this.isAdded + ", showSettingOption=" + this.showSettingOption + ")";
    }

    public MTTopViewBean(boolean z, boolean z2) {
        this.isAdded = z;
        this.showSettingOption = z2;
    }

    public final boolean getShowSettingOption() {
        return this.showSettingOption;
    }

    public final boolean isAdded() {
        return this.isAdded;
    }

    public final void setAdded(boolean z) {
        this.isAdded = z;
    }

    public final void setShowSettingOption(boolean z) {
        this.showSettingOption = z;
    }
}
