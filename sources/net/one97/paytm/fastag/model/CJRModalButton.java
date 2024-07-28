package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRModalButton extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "modalactionPage")
    private String mModalActionPage;
    @b(a = "modalactionUrl")
    private String mModalActionUrl;
    @b(a = "modalactionUrlRequest")
    private CJRModalActionUrlRequest mModalActionUrlRequest;
    @b(a = "modalbuttonAlignment")
    private String mModalButtonAlignment;
    @b(a = "modalbuttonName")
    private String mModalButtonName;
    @b(a = "modalrespAction")
    private String modalRespAction;

    public String getmModalButtonName() {
        return this.mModalButtonName;
    }

    public String getModalActionUrl() {
        return this.mModalActionUrl;
    }

    public String getModalActionPage() {
        return this.mModalActionPage;
    }

    public CJRModalActionUrlRequest getModalActionUrlRequest() {
        return this.mModalActionUrlRequest;
    }

    public String getModalButtonAlignment() {
        return this.mModalButtonAlignment;
    }

    public String getModalRespAction() {
        return this.modalRespAction;
    }
}
