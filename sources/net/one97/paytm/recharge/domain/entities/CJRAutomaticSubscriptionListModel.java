package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRAutomaticSubscriptionListModel extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<CJRAutomaticSubscriptionItemModel> subscriptionModelArrayList = new ArrayList<>();

    public final ArrayList<CJRAutomaticSubscriptionItemModel> getSubscriptionModelArrayList() {
        return this.subscriptionModelArrayList;
    }

    public final void setSubscriptionModelArrayList(ArrayList<CJRAutomaticSubscriptionItemModel> arrayList) {
        k.c(arrayList, "<set-?>");
        this.subscriptionModelArrayList = arrayList;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        k.c(str, "jsonString");
        k.c(fVar, "gson");
        Object a2 = fVar.a(str, new CJRAutomaticSubscriptionListModel$parseResponse$modelList$1().getType());
        k.a(a2, "gson.fromJson(jsonString…tionItemModel>>(){}.type)");
        CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = new CJRAutomaticSubscriptionListModel();
        cJRAutomaticSubscriptionListModel.subscriptionModelArrayList = (ArrayList) a2;
        return cJRAutomaticSubscriptionListModel;
    }
}
