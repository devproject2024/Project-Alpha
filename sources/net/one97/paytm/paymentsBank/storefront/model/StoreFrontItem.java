package net.one97.paytm.paymentsBank.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class StoreFrontItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "id")
    private final Integer id;
    @b(a = "image_url")
    private final String imageUrl;
    @b(a = "url")
    private final String url;

    public StoreFrontItem() {
        this((String) null, (String) null, (Integer) null, 7, (g) null);
    }

    public static /* synthetic */ StoreFrontItem copy$default(StoreFrontItem storeFrontItem, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = storeFrontItem.imageUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = storeFrontItem.url;
        }
        if ((i2 & 4) != 0) {
            num = storeFrontItem.id;
        }
        return storeFrontItem.copy(str, str2, num);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.url;
    }

    public final Integer component3() {
        return this.id;
    }

    public final StoreFrontItem copy(String str, String str2, Integer num) {
        return new StoreFrontItem(str, str2, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoreFrontItem)) {
            return false;
        }
        StoreFrontItem storeFrontItem = (StoreFrontItem) obj;
        return k.a((Object) this.imageUrl, (Object) storeFrontItem.imageUrl) && k.a((Object) this.url, (Object) storeFrontItem.url) && k.a((Object) this.id, (Object) storeFrontItem.id);
    }

    public final int hashCode() {
        String str = this.imageUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.id;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "StoreFrontItem(imageUrl=" + this.imageUrl + ", url=" + this.url + ", id=" + this.id + ")";
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoreFrontItem(String str, String str2, Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : num);
    }

    public final Integer getId() {
        return this.id;
    }

    public StoreFrontItem(String str, String str2, Integer num) {
        this.imageUrl = str;
        this.url = str2;
        this.id = num;
    }
}
