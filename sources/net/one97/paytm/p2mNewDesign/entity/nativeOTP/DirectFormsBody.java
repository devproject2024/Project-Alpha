package net.one97.paytm.p2mNewDesign.entity.nativeOTP;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.p2mNewDesign.entity.TxnInfo;

public class DirectFormsBody extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    private boolean bankRetry;
    private String callBackUrl;
    private boolean resendRetry;
    private DirectFormsResultInfo resultInfo;
    private TxnInfo txnInfo;

    public TxnInfo getTxnInfo() {
        return this.txnInfo;
    }

    public void setTxnInfo(TxnInfo txnInfo2) {
        this.txnInfo = txnInfo2;
    }

    public boolean isResendRetry() {
        return this.resendRetry;
    }

    public void setResendRetry(boolean z) {
        this.resendRetry = z;
    }

    public boolean isBankRetry() {
        return this.bankRetry;
    }

    public void setBankRetry(boolean z) {
        this.bankRetry = z;
    }

    public String getCallBackUrl() {
        return this.callBackUrl;
    }

    public DirectFormsResultInfo getResultInfo() {
        return this.resultInfo;
    }
}
