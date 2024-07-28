package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class GroupBean extends IJRPaytmDataModel implements IJRDataModel {
    private int groupId;
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(int i2) {
        this.groupId = i2;
    }
}
