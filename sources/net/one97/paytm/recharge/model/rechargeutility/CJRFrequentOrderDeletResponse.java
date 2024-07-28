package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFrequentOrderDeletResponse extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "code")
    @a
    private Integer code;
    @c(a = "message")
    @a
    private String message;
    @c(a = "title")
    @a
    private String title;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
