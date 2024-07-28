package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;

public class CJRNotificationItem implements IJRDataModel {
    @b(a = "category")
    private String mCategory;
    @b(a = "description1")
    private String mDescription1;
    @b(a = "displayName")
    private String mDisplayName;
    @b(a = "settings")
    private HashMap<String, String> mSettings;

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getDescription1() {
        return this.mDescription1;
    }

    public HashMap<String, String> getSettings() {
        return this.mSettings;
    }
}
