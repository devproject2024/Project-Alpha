package net.one97.paytm.recharge.legacy.catalog.model;

import java.util.List;

public class CJRUtilitySelectedGroupItemV2 {
    private CJRUtilityFilterAttributesV2 attributes;
    private int groupIndex;
    private String groupKey;
    private String groupName;
    private String groupType;
    private String itemDisplayName;
    private String itemFilterName;
    private int itemIndex;
    private List<CJRUtilityVariantV2> itemVarientList;

    public CJRUtilitySelectedGroupItemV2() {
    }

    public CJRUtilitySelectedGroupItemV2(String str, String str2, String str3, String str4, int i2) {
        this.groupName = str;
        this.groupKey = str2;
        this.itemFilterName = str3;
        this.itemDisplayName = str4;
        this.itemIndex = i2;
    }

    public void setItemVarientList(List<CJRUtilityVariantV2> list) {
        this.itemVarientList = list;
    }

    public List<CJRUtilityVariantV2> getItemVarientList() {
        return this.itemVarientList;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public void setItemDisplayName(String str) {
        this.itemDisplayName = str;
    }

    public void setItemFilterName(String str) {
        this.itemFilterName = str;
    }

    public void setItemIndex(int i2) {
        this.itemIndex = i2;
    }

    public int getItemIndex() {
        return this.itemIndex;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public String getItemDisplayName() {
        return this.itemDisplayName;
    }

    public String getItemFilterName() {
        return this.itemFilterName;
    }

    public int getGroupIndex() {
        return this.groupIndex;
    }

    public void setGroupIndex(int i2) {
        this.groupIndex = i2;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public CJRUtilityFilterAttributesV2 getAttributes() {
        return this.attributes;
    }

    public void setAttributes(CJRUtilityFilterAttributesV2 cJRUtilityFilterAttributesV2) {
        this.attributes = cJRUtilityFilterAttributesV2;
    }
}
