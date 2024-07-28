package net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBUserSettlementResponse extends CJRWalletDataModel {
    @c(a = "nextPage")
    @a
    private Boolean nextPage;
    @c(a = "toPay")
    @a
    private String toPay;
    @c(a = "toReceive")
    @a
    private String toReceive;
    @c(a = "userSnapShotList")
    @a
    private List<SBUserSnapShotPojo> userSnapShotList = null;

    public String getToPay() {
        return this.toPay;
    }

    public void setToPay(String str) {
        this.toPay = str;
    }

    public String getToReceive() {
        return this.toReceive;
    }

    public void setToReceive(String str) {
        this.toReceive = str;
    }

    public Boolean getNextPage() {
        return this.nextPage;
    }

    public void setNextPage(Boolean bool) {
        this.nextPage = bool;
    }

    public List<SBUserSnapShotPojo> getUserSnapShotPojos() {
        return this.userSnapShotList;
    }

    public void setUserSnapShotPojos(List<SBUserSnapShotPojo> list) {
        this.userSnapShotList = list;
    }
}
