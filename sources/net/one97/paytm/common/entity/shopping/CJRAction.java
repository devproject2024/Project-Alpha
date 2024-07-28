package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAction implements IJRDataModel {
    @b(a = "description")
    private String errorDescription;
    @b(a = "title")
    private String errorTitle;
    @b(a = "icon_url")
    private String genericActionImage;
    private boolean isError = false;
    @b(a = "label")
    private String label;
    @b(a = "error_text")
    private String mErrorText;
    @b(a = "error_title")
    private String mErrorTitle;
    @b(a = "name")
    private String name;
    @b(a = "type")
    private String type;
    @b(a = "ui_control")
    private String ui_control;
    @b(a = "urlParams")
    private CJRUrlParams urlParams;

    public String getLabel() {
        return this.label;
    }

    public String getName() {
        return this.name;
    }

    public String getUi_control() {
        return this.ui_control;
    }

    public CJRUrlParams getUrlParams() {
        return this.urlParams;
    }

    public String getType() {
        return this.type;
    }

    public String getGenericActionImage() {
        return this.genericActionImage;
    }

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public void setErrorTitle(String str) {
        this.errorTitle = str;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public void setErrorDescription(String str) {
        this.errorDescription = str;
    }

    public boolean isError() {
        return this.isError;
    }

    public void setError(boolean z) {
        this.isError = z;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getErrorTitleText() {
        return this.mErrorTitle;
    }

    public String getErrorText() {
        return this.mErrorText;
    }
}
