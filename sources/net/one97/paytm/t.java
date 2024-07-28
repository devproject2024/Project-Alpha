package net.one97.paytm;

import com.paytm.network.model.IJRPaytmDataModel;

public interface t {
    void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str);

    void onFileWriteComplete(String str);
}
