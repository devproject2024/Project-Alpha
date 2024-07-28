package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.a.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class CancellationData extends IJRPaytmDataModel {
    @a
    private String cancellationPolicy;
    @a
    private List<String> cancellationPolicyList;

    public final List<String> getCancellationPolicyList() {
        return this.cancellationPolicyList;
    }

    public final void setCancellationPolicyList(List<String> list) {
        this.cancellationPolicyList = list;
    }

    public final String getCancellationPolicy() {
        return this.cancellationPolicy;
    }

    public final void setCancellationPolicy(String str) {
        this.cancellationPolicy = str;
    }
}
