package net.one97.paytm.recharge.legacy.catalog.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityGroupFieldV2 implements IJRDataModel {
    @b(a = "brandImage")
    private Boolean brandImage;
    @b(a = "cart_verify_type")
    private String cartVerifyType;
    @b(a = "child")
    private String child;
    @b(a = "Error")
    private String error;
    @b(a = "key")
    private String key;
    @b(a = "label")
    private String label;
    @b(a = "multiple_selection")
    private Boolean multipleSelection;
    @b(a = "skip_click_to_view")
    private boolean performViewClick;
    @b(a = "placeholder")
    private String placeHolder;
    @b(a = "showfield")
    private Boolean showfield = Boolean.TRUE;
    @b(a = "type")
    private String type;

    public boolean isPerformViewClick() {
        return this.performViewClick;
    }

    public String getLabel() {
        return this.label;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Boolean getMultipleSelection() {
        return this.multipleSelection;
    }

    public void setMultipleSelection(Boolean bool) {
        this.multipleSelection = bool;
    }

    public Boolean getShowfield() {
        return this.showfield;
    }

    public void setShowfield(Boolean bool) {
        this.showfield = bool;
    }

    public Boolean getBrandImage() {
        return this.showfield;
    }

    public void setBrandImage(Boolean bool) {
        this.brandImage = bool;
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public void setPlaceHolder(String str) {
        this.placeHolder = str;
    }

    public String getChild() {
        return this.child;
    }

    public void setChild(String str) {
        this.child = str;
    }

    public String getCartVerifyType() {
        return this.cartVerifyType;
    }

    public void setCartVerifyType(String str) {
        this.cartVerifyType = str;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }
}
