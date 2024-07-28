package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRResourceDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "image")
    private String image;
    @b(a = "type")
    private String mType;
    @b(a = "value1")
    private String mValue1;
    @b(a = "value2")
    private String mValue2;

    public String getType() {
        return this.mType;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getValue1() {
        return this.mValue1;
    }

    public void setValue1(String str) {
        this.mValue2 = str;
    }

    public String getValue2() {
        return this.mValue2;
    }

    public void setValue2(String str) {
        this.mValue2 = str;
    }
}
