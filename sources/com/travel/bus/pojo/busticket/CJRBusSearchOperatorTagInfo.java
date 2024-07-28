package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchOperatorTagInfo implements IJRDataModel {
    private int count = 0;
    @b(a = "description")
    private String description;
    @b(a = "dest_id")
    private String destId;
    @b(a = "icon")
    private String icon;
    private boolean isSelected;
    @b(a = "label")
    private String label;
    @b(a = "priority")
    private Integer priority;
    @b(a = "rule_priority")
    private Integer rulePriority;
    @b(a = "rule_type")
    private String ruleType;
    @b(a = "src_id")
    private String srcId;
    @b(a = "tag_id")
    private String tagId;
    @b(a = "tag_type")
    private String tagType;

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public String getTagId() {
        return this.tagId;
    }

    public void setTagId(String str) {
        this.tagId = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getTagType() {
        return this.tagType;
    }

    public void setTagType(String str) {
        this.tagType = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public void setSrcId(String str) {
        this.srcId = str;
    }

    public void setDestId(String str) {
        this.destId = str;
    }

    public void setRuleType(String str) {
        this.ruleType = str;
    }

    public void setRulePriority(Integer num) {
        this.rulePriority = num;
    }
}
