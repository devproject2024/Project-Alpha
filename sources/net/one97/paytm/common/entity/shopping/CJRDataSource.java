package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDataSource implements IJRDataModel {
    @b(a = "container_id")
    private String mContainerID;
    @b(a = "container_instance_id")
    private String mContainerInstanceID;
    @b(a = "list_id")
    private String mListId;
    @b(a = "type")
    private String mType;

    public String getmType() {
        return this.mType;
    }

    public void setmType(String str) {
        this.mType = str;
    }

    public String getmListId() {
        return this.mListId;
    }

    public void setmListId(String str) {
        this.mListId = str;
    }

    public String getmContainerID() {
        return this.mContainerID;
    }

    public void setmContainerID(String str) {
        this.mContainerID = str;
    }

    public String getmContainerInstanceID() {
        return this.mContainerInstanceID;
    }

    public void setmContainerInstanceID(String str) {
        this.mContainerInstanceID = str;
    }
}
