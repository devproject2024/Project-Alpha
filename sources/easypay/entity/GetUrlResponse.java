package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;

public class GetUrlResponse implements Serializable {
    @c(a = "responseCode")
    private int responseCode;
    @c(a = "responseMessage")
    private String responseMessage;
    @c(a = "url")
    private String responseUrl;

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public String getResponseUrl() {
        return this.responseUrl;
    }

    public void setResponseUrl(String str) {
        this.responseUrl = str;
    }
}
