package net.one97.paytm.common.entity.amPark;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRValidatePackage extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "allowFurther")
    @a
    private Boolean allowFurther;
    @c(a = "message")
    @a
    private String message;
    @c(a = "showMessage")
    @a
    private Boolean showMessage;
    @c(a = "type")
    @a
    private String type;

    public Boolean getAllowFurther() {
        return this.allowFurther;
    }

    public void setAllowFurther(Boolean bool) {
        this.allowFurther = bool;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Boolean getShowMessage() {
        return this.showMessage;
    }

    public void setShowMessage(Boolean bool) {
        this.showMessage = bool;
    }
}
