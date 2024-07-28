package net.one97.paytm.common.entity.giftcards;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGiftCardFilterValue implements IJRDataModel {
    @b(a = "applied")
    private boolean applied;
    @b(a = "attributes")
    private String attributes;
    @b(a = "exist")
    private boolean exist;
    @b(a = "id")
    private String id;
    @b(a = "name")
    private String name;
    @b(a = "product_id")
    private int productId;
    @b(a = "seourl")
    private String seourl;
    @b(a = "totalScore")
    private int totalScore;
    @b(a = "url")
    private String url;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getSeourl() {
        return this.seourl;
    }

    public void setSeourl(String str) {
        this.seourl = str;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i2) {
        this.productId = i2;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(int i2) {
        this.totalScore = i2;
    }

    public boolean isExist() {
        return this.exist;
    }

    public void setExist(boolean z) {
        this.exist = z;
    }

    public boolean isApplied() {
        return this.applied;
    }

    public void setApplied(boolean z) {
        this.applied = z;
    }

    public String getAttributes() {
        return this.attributes;
    }

    public void setAttributes(String str) {
        this.attributes = str;
    }
}
