package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRNBBody extends CJRWalletDataModel implements IJRDataModel {
    private NbPayOption nbPayOption;
    private ResultInfo resultInfo;

    public NbPayOption getNbPayOption() {
        return this.nbPayOption;
    }

    public void setNbPayOption(NbPayOption nbPayOption2) {
        this.nbPayOption = nbPayOption2;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public String toString() {
        return "ClassPojo [nbPayOption = " + this.nbPayOption + ", resultInfo = " + this.resultInfo + "]";
    }
}
