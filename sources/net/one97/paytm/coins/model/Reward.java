package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Reward extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "attributes")
    private Attributes attributes;
    @b(a = "image_url")
    private String image_url;
    @b(a = "product_id")
    private String product_id;

    public Reward() {
        this((String) null, (String) null, (Attributes) null, 7, (g) null);
    }

    public static /* synthetic */ Reward copy$default(Reward reward, String str, String str2, Attributes attributes2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reward.product_id;
        }
        if ((i2 & 2) != 0) {
            str2 = reward.image_url;
        }
        if ((i2 & 4) != 0) {
            attributes2 = reward.attributes;
        }
        return reward.copy(str, str2, attributes2);
    }

    public final String component1() {
        return this.product_id;
    }

    public final String component2() {
        return this.image_url;
    }

    public final Attributes component3() {
        return this.attributes;
    }

    public final Reward copy(String str, String str2, Attributes attributes2) {
        return new Reward(str, str2, attributes2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reward)) {
            return false;
        }
        Reward reward = (Reward) obj;
        return k.a((Object) this.product_id, (Object) reward.product_id) && k.a((Object) this.image_url, (Object) reward.image_url) && k.a((Object) this.attributes, (Object) reward.attributes);
    }

    public final int hashCode() {
        String str = this.product_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.image_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Attributes attributes2 = this.attributes;
        if (attributes2 != null) {
            i2 = attributes2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Reward(product_id=" + this.product_id + ", image_url=" + this.image_url + ", attributes=" + this.attributes + ")";
    }

    public Reward(String str, String str2, Attributes attributes2) {
        this.product_id = str;
        this.image_url = str2;
        this.attributes = attributes2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Reward(String str, String str2, Attributes attributes2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : attributes2);
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getProduct_id() {
        return this.product_id;
    }

    public final void setAttributes(Attributes attributes2) {
        this.attributes = attributes2;
    }

    public final void setImage_url(String str) {
        this.image_url = str;
    }

    public final void setProduct_id(String str) {
        this.product_id = str;
    }
}
