package net.one97.paytm.common.entity.wallet.postcard.data;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class PostcardThemesResponseDataModel extends IJRPaytmDataModel implements IJRDataModel {
    private List<ThemesMetaDataModel> response;
    private String statusCode;
    private String statusMessage;

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public List<ThemesMetaDataModel> getResponse() {
        return this.response;
    }

    public void setResponse(List<ThemesMetaDataModel> list) {
        this.response = list;
    }
}
