package net.one97.paytm.recharge.legacy.catalog.model.v2;

import android.widget.CheckBox;
import android.widget.EditText;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;

public class CJRUtilityCheckboxItem {
    private CheckBox checkBox;
    private List<CJRDisplayValues> displayValues;
    private long id;
    private String inputMode;
    private boolean isChecked;
    private boolean isDisplayValuesExpanded;
    private boolean isPriceEditable;
    private Map<String, String> metaData;
    private String name;
    private String price;
    private EditText priceEditTextView;
    private boolean showDisplayValues;

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getInputMode() {
        return this.inputMode;
    }

    public void setInputMode(String str) {
        this.inputMode = str;
    }

    public boolean isPriceEditable() {
        return this.isPriceEditable;
    }

    public void setPriceEditable(boolean z) {
        this.isPriceEditable = z;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public List<CJRDisplayValues> getDisplayValues() {
        return this.displayValues;
    }

    public void setDisplayValues(List<CJRDisplayValues> list) {
        this.displayValues = list;
    }

    public boolean isShowDisplayValues() {
        return this.showDisplayValues;
    }

    public void setShowDisplayValues(boolean z) {
        this.showDisplayValues = z;
    }

    public boolean isDisplayValuesExpanded() {
        return this.isDisplayValuesExpanded;
    }

    public void setDisplayValuesExpanded(boolean z) {
        this.isDisplayValuesExpanded = z;
    }

    public Map<String, String> getMetaData() {
        return this.metaData;
    }

    public void setMetaData(Map<String, String> map) {
        this.metaData = map;
    }

    public CheckBox getCheckBox() {
        return this.checkBox;
    }

    public void setCheckBox(CheckBox checkBox2) {
        this.checkBox = checkBox2;
    }

    public EditText getPriceEditTextView() {
        return this.priceEditTextView;
    }

    public void setPriceEditTextView(EditText editText) {
        this.priceEditTextView = editText;
    }
}
