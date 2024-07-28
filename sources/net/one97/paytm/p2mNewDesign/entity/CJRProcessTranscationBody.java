package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRProcessTranscationBody extends CJRWalletDataModel implements IJRDataModel {
    private BankForm bankForm;
    private OneClickInfo oneClickInfo;
    private CJRProcessTranscationResultInfo resultInfo;
    private RetryInfo retryInfo;
    private TxnInfo txnInfo;

    public TxnInfo getTxnInfo() {
        return this.txnInfo;
    }

    public void setTxnInfo(TxnInfo txnInfo2) {
        this.txnInfo = txnInfo2;
    }

    public CJRProcessTranscationResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(CJRProcessTranscationResultInfo cJRProcessTranscationResultInfo) {
        this.resultInfo = cJRProcessTranscationResultInfo;
    }

    public String toString() {
        return "ClassPojo [txnInfo = " + this.txnInfo + ", resultInfo = " + this.resultInfo + "]";
    }

    public BankForm getBankForm() {
        return this.bankForm;
    }

    public RetryInfo getRetryInfo() {
        return this.retryInfo;
    }

    public OneClickInfo getOneClickInfo() {
        return this.oneClickInfo;
    }
}
