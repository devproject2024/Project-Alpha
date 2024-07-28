package net.one97.paytm.common.entity.insurance;

import com.google.gsonhtcfix.a.b;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRDataModelItem;

public final class InsuranceCategoryModel extends CJRDataModelItem {
    @b(a = "description")
    private final String description;
    @b(a = "insurance_type")
    private final String insurance_type;
    @b(a = "logo")
    private final String logo;
    @b(a = "status")
    private final String status;
    @b(a = "title")
    private final String title;
    @b(a = "url")
    private final String url;

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getInsurance_type() {
        return this.insurance_type;
    }

    public InsuranceCategoryModel(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "title");
        k.c(str2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str3, "logo");
        k.c(str4, "url");
        k.c(str6, "status");
        this.title = str;
        this.description = str2;
        this.logo = str3;
        this.url = str4;
        this.insurance_type = str5;
        this.status = str6;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getName() {
        String str = this.url;
        if (str != null) {
            return p.a(str, (CharSequence) "paytmmp://");
        }
        return null;
    }
}
