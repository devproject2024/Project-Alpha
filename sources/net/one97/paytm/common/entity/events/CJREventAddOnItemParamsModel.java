package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventAddOnItemParamsModel implements IJRDataModel {
    @b(a = "display_text")
    private String displayText;
    @b(a = "input_type")
    private String inputType;
    @b(a = "is_required")
    private String isRequired;
    @b(a = "name")
    private String name;
    private String selectedValue;
    @b(a = "values")
    private ArrayList<String> values;

    public String getDisplayText() {
        return this.displayText;
    }

    public void setDisplayText(String str) {
        this.displayText = str;
    }

    public String getInputType() {
        return this.inputType;
    }

    public void setInputType(String str) {
        this.inputType = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIsRequired() {
        return this.isRequired;
    }

    public void setIsRequired(String str) {
        this.isRequired = str;
    }

    public ArrayList<String> getValues() {
        return this.values;
    }

    public void setValues(ArrayList<String> arrayList) {
        this.values = arrayList;
    }

    public String getSelectedValue() {
        return this.selectedValue;
    }

    public void setSelectedValue(String str) {
        this.selectedValue = str;
    }
}
