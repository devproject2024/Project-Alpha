package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityAlertV2 implements IJRDataModel {
    @b(a = "checkbox_text")
    private String check_box_text;
    @b(a = "heading")
    private String heading;
    @b(a = "message")
    private String message;
    @b(a = "cancelButton")
    private String negative_btn_txt;
    @b(a = "okbutton")
    private String positive_btn_txt;
    @b(a = "rich_message")
    private List<CJRRichMessage> rich_message;
    @b(a = "title")
    private String title;

    public CJRUtilityAlertV2() {
    }

    public CJRUtilityAlertV2(String str, String str2, String str3, String str4, String str5, String str6, List<CJRRichMessage> list) {
        this.title = str;
        this.heading = str2;
        this.message = str3;
        this.positive_btn_txt = str4;
        this.negative_btn_txt = str5;
        this.check_box_text = str6;
        this.rich_message = list;
    }

    public String getTitle() {
        return this.title;
    }

    public String getHeading() {
        return this.heading;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPositive_btn_txt() {
        return this.positive_btn_txt;
    }

    public String getNegative_btn_txt() {
        return this.negative_btn_txt;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPositive_btn_txt(String str) {
        this.positive_btn_txt = str;
    }

    public void setNegative_btn_txt(String str) {
        this.negative_btn_txt = str;
    }

    public String getCheck_box_text() {
        return this.check_box_text;
    }

    public List<CJRRichMessage> getRich_message() {
        return this.rich_message;
    }

    public void setCheck_box_text(String str) {
        this.check_box_text = str;
    }
}
