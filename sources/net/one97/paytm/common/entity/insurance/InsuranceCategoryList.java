package net.one97.paytm.common.entity.insurance;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class InsuranceCategoryList extends IJRPaytmDataModel implements IJRDataModel {
    private final List<InsuranceCategoryModel> products;
    private final String title;

    public InsuranceCategoryList(List<InsuranceCategoryModel> list, String str) {
        this.products = list;
        this.title = str;
    }

    public final List<InsuranceCategoryModel> getProducts() {
        return this.products;
    }

    public final String getTitle() {
        return this.title;
    }
}
