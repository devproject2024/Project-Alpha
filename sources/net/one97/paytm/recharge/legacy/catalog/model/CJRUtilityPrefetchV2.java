package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityPrefetchV2 implements IJRDataModel {
    @b(a = "post")
    private String post;
    @b(a = "pre")
    private String pre;
    @b(a = "processing")
    private String processing;

    public String getPre() {
        return this.pre;
    }

    public void setPre(String str) {
        this.pre = str;
    }

    public String getProcessing() {
        return this.processing;
    }

    public void setProcessing(String str) {
        this.processing = str;
    }

    public String getPost() {
        return this.post;
    }

    public void setPost(String str) {
        this.post = str;
    }
}
