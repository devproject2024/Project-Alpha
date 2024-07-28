package net.one97.paytm.common.entity.replacement;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCustomTextModel implements IJRDataModel {
    @b(a = "estimated_refund_time")
    private String estimated_refund_time;
    @b(a = "reason_selection_question")
    private String reason_selection_question;
    @b(a = "reason_selection_text")
    private String reason_selection_text;
    @b(a = "replacement_confirmation_title")
    private String replacement_Title;
    @b(a = "return_address_error")
    private String return_address_error;
    @b(a = "return_address_info")
    private String return_address_info;
    @b(a = "return_confirmation_title")
    private String return_confirmation_title;
    @b(a = "return_process")
    private String return_process;
    @b(a = "user_product_confirmation")
    private String user_product_confirmation;

    public String getReturn_pickup_text() {
        return this.return_address_info;
    }

    public String getReturn_confirmation_title() {
        return this.return_confirmation_title;
    }

    public void setReturn_confirmation_title(String str) {
        this.return_confirmation_title = str;
    }

    public String getReturn_address_error() {
        return this.return_address_error;
    }

    public void setReturn_address_error(String str) {
        this.return_address_error = str;
    }

    public String getEstimated_refund_time() {
        return this.estimated_refund_time;
    }

    public void setEstimated_refund_time(String str) {
        this.estimated_refund_time = str;
    }

    public String getReturn_process() {
        return this.return_process;
    }

    public void setReturn_process(String str) {
        this.return_process = str;
    }

    public String getUser_product_confirmation() {
        return this.user_product_confirmation;
    }

    public void setUser_product_confirmation(String str) {
        this.user_product_confirmation = str;
    }

    public String getReason_selection_question() {
        return this.reason_selection_question;
    }

    public void setReason_selection_question(String str) {
        this.reason_selection_question = str;
    }

    public String getReason_selection_text() {
        return this.reason_selection_text;
    }

    public void setReason_selection_text(String str) {
        this.reason_selection_text = str;
    }

    public String getReplacement_Title() {
        return this.replacement_Title;
    }
}
