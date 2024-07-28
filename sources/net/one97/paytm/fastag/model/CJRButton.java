package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRButton extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "isModalBtnEnabled")
    private boolean isModalBtnEnabled;
    @b(a = "action")
    private String mAction;
    @b(a = "actionPage")
    private String mActionPage;
    @b(a = "actionUrl")
    private String mActionUrl;
    @b(a = "actionUrlRequest")
    private CJRActionUrlRequest mActionUrlRequest;
    @b(a = "buttonAlignment")
    private String mButtonAlignment;
    @b(a = "buttonName")
    private String mButtonName;
    private int mButtonTag;
    @b(a = "modalbuttonHeader")
    private String mModalButtonHeader;
    @b(a = "checkUserTxnHistoryWrapperButtonsModals")
    private ArrayList<CJRModalButton> mModalButtonList;
    @b(a = "modalbuttonText")
    private String mModalButtonText;
    @b(a = "respAction")
    private String mRespAction;

    public void setButtonName(String str) {
        this.mButtonName = str;
    }

    public ArrayList<CJRModalButton> getModalButtonList() {
        return this.mModalButtonList;
    }

    public boolean isModalBtnEnabled() {
        return this.isModalBtnEnabled;
    }

    public String getAction() {
        return this.mAction;
    }

    public String getRespAction() {
        return this.mRespAction;
    }

    public String getButtonName() {
        return this.mButtonName;
    }

    public String getActionUrl() {
        return this.mActionUrl;
    }

    public String getActionPage() {
        return this.mActionPage;
    }

    public String getModalButtonHeader() {
        return this.mModalButtonHeader;
    }

    public String getModalButtonText() {
        return this.mModalButtonText;
    }

    public CJRActionUrlRequest getActionUrlRequest() {
        return this.mActionUrlRequest;
    }

    public String getButtonAlignment() {
        return this.mButtonAlignment;
    }

    public int getButtonTag() {
        return this.mButtonTag;
    }

    public void setButtonTag(int i2) {
        this.mButtonTag = i2;
    }
}
