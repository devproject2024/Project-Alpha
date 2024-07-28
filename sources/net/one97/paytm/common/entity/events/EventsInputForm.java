package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class EventsInputForm implements IJRDataModel {
    public static final String FIELD_TYPE_CALENDAR = "calendar";
    public static final String FIELD_TYPE_CHECKBOX = "checkbox";
    public static final String FIELD_TYPE_DROPDOWN = "dropdown";
    public static final String FIELD_TYPE_RADIO = "radio";
    public static final String FIELD_TYPE_TEXTBOX = "textbox";
    public static final String FIELD_TYPE_TEXT_AREA = "textarea";
    private static final long serialVersionUID = 1;
    @b(a = "applied")
    private String applied;
    private List<FormValuesData> checkBoxListValues;
    private List<String> dropDownListValues;
    @b(a = "hint")
    private String hint;
    @b(a = "id")
    private String id;
    @b(a = "info_type")
    private String info_type;
    @b(a = "provider_seat_id")
    private String provider_seat_id;
    private List<String> radioListValues;
    @b(a = "regex")
    private String regex;
    @b(a = "seat_id")
    private String seat_id;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;
    @b(a = "values")
    private Object values;

    public List<String> getDropDownListValues() {
        return this.dropDownListValues;
    }

    public void setDropDownListValues(List<String> list) {
        this.dropDownListValues = list;
    }

    public List<FormValuesData> getCheckBoxListValues() {
        return this.checkBoxListValues;
    }

    public void setCheckBoxListValues(List<FormValuesData> list) {
        this.checkBoxListValues = list;
    }

    public List<String> getRadioListValues() {
        return this.radioListValues;
    }

    public void setRadioListValues(List<String> list) {
        this.radioListValues = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getAppliedData() {
        return this.applied;
    }

    public void setApplied(String str) {
        this.applied = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public Object getValues() {
        return this.values;
    }

    public void setValues(Object obj) {
        this.values = obj;
    }

    public String getHint() {
        return this.hint;
    }

    public void setHint(String str) {
        this.hint = str;
    }

    public String getSeatId() {
        return this.seat_id;
    }

    public void setSeatId(String str) {
        this.seat_id = str;
    }

    public String getProviderSeatId() {
        return this.provider_seat_id;
    }

    public void setProviderSeatId(String str) {
        this.provider_seat_id = str;
    }

    public String getInfoType() {
        return this.info_type;
    }

    public void setInfoType(String str) {
        this.info_type = str;
    }
}
