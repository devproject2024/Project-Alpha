package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Payload extends IJRPaytmDataModel {
    @c(a = "description")
    @a
    private String description;
    @c(a = "maximumPage")
    @a
    private Integer maximumPage;
    @c(a = "minimumPage")
    @a
    private Integer minimumPage;
    @c(a = "name")
    @a
    private String name;

    public Payload() {
        this((String) null, (String) null, (Integer) null, (Integer) null, 15, (g) null);
    }

    public static /* synthetic */ Payload copy$default(Payload payload, String str, String str2, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = payload.name;
        }
        if ((i2 & 2) != 0) {
            str2 = payload.description;
        }
        if ((i2 & 4) != 0) {
            num = payload.minimumPage;
        }
        if ((i2 & 8) != 0) {
            num2 = payload.maximumPage;
        }
        return payload.copy(str, str2, num, num2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.description;
    }

    public final Integer component3() {
        return this.minimumPage;
    }

    public final Integer component4() {
        return this.maximumPage;
    }

    public final Payload copy(String str, String str2, Integer num, Integer num2) {
        return new Payload(str, str2, num, num2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Payload)) {
            return false;
        }
        Payload payload = (Payload) obj;
        return k.a((Object) this.name, (Object) payload.name) && k.a((Object) this.description, (Object) payload.description) && k.a((Object) this.minimumPage, (Object) payload.minimumPage) && k.a((Object) this.maximumPage, (Object) payload.maximumPage);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.minimumPage;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.maximumPage;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Payload(name=" + this.name + ", description=" + this.description + ", minimumPage=" + this.minimumPage + ", maximumPage=" + this.maximumPage + ")";
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final Integer getMinimumPage() {
        return this.minimumPage;
    }

    public final void setMinimumPage(Integer num) {
        this.minimumPage = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Payload(String str, String str2, Integer num, Integer num2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2);
    }

    public final Integer getMaximumPage() {
        return this.maximumPage;
    }

    public final void setMaximumPage(Integer num) {
        this.maximumPage = num;
    }

    public Payload(String str, String str2, Integer num, Integer num2) {
        this.name = str;
        this.description = str2;
        this.minimumPage = num;
        this.maximumPage = num2;
    }
}
