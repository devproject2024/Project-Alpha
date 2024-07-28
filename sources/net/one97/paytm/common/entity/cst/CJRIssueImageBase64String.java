package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIssueImageBase64String extends IJRPaytmDataModel implements IJRDataModel {
    private String attachmentId;
    private String base64String;

    public String getBase64String() {
        return this.base64String;
    }

    public void setBase64String(String str) {
        this.base64String = str;
    }

    public String getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(String str) {
        this.attachmentId = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRIssueImageBase64String cJRIssueImageBase64String = new CJRIssueImageBase64String();
        cJRIssueImageBase64String.setAttachmentId(this.attachmentId);
        cJRIssueImageBase64String.setBase64String(str);
        return cJRIssueImageBase64String;
    }
}
