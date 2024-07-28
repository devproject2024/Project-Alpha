package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTRaiseIssueNode implements IJRDataModel {
    @a
    @b(a = "action")
    private String action;
    @a
    @b(a = "attributes")
    private ArrayList<CSTAttributes> attributes;
    @a
    @b(a = "display_text")
    private String display_text;
    @a
    @b(a = "icon")
    private String icon;
    @a
    @b(a = "id")
    private int id;
    @a
    @b(a = "name")
    private String name;
    @a
    @b(a = "tags")
    private List<Integer> tags = null;
    @a
    @b(a = "template")
    private String template;
    @a
    @b(a = "value")
    private String value;

    public String getDisplayText() {
        return this.display_text;
    }

    public void setDisplayText(String str) {
        this.display_text = str;
    }

    public ArrayList<CSTAttributes> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(ArrayList<CSTAttributes> arrayList) {
        this.attributes = arrayList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTemplate() {
        return this.template;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public List<Integer> getTags() {
        return this.tags;
    }

    public void setTags(List<Integer> list) {
        this.tags = list;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
