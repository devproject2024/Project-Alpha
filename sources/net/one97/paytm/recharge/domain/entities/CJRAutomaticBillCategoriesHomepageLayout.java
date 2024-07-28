package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRAutomaticBillCategoriesHomepageLayout implements IJRDataModel {
    @b(a = "items")
    private List<CJRABCHLItems> items;
    @b(a = "layout")
    private String layout;
    @b(a = "name")
    private String name;

    public static /* synthetic */ CJRAutomaticBillCategoriesHomepageLayout copy$default(CJRAutomaticBillCategoriesHomepageLayout cJRAutomaticBillCategoriesHomepageLayout, String str, String str2, List<CJRABCHLItems> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRAutomaticBillCategoriesHomepageLayout.layout;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRAutomaticBillCategoriesHomepageLayout.name;
        }
        if ((i2 & 4) != 0) {
            list = cJRAutomaticBillCategoriesHomepageLayout.items;
        }
        return cJRAutomaticBillCategoriesHomepageLayout.copy(str, str2, list);
    }

    public final String component1() {
        return this.layout;
    }

    public final String component2() {
        return this.name;
    }

    public final List<CJRABCHLItems> component3() {
        return this.items;
    }

    public final CJRAutomaticBillCategoriesHomepageLayout copy(String str, String str2, List<CJRABCHLItems> list) {
        k.c(list, "items");
        return new CJRAutomaticBillCategoriesHomepageLayout(str, str2, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRAutomaticBillCategoriesHomepageLayout)) {
            return false;
        }
        CJRAutomaticBillCategoriesHomepageLayout cJRAutomaticBillCategoriesHomepageLayout = (CJRAutomaticBillCategoriesHomepageLayout) obj;
        return k.a((Object) this.layout, (Object) cJRAutomaticBillCategoriesHomepageLayout.layout) && k.a((Object) this.name, (Object) cJRAutomaticBillCategoriesHomepageLayout.name) && k.a((Object) this.items, (Object) cJRAutomaticBillCategoriesHomepageLayout.items);
    }

    public final int hashCode() {
        String str = this.layout;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<CJRABCHLItems> list = this.items;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRAutomaticBillCategoriesHomepageLayout(layout=" + this.layout + ", name=" + this.name + ", items=" + this.items + ")";
    }

    public CJRAutomaticBillCategoriesHomepageLayout(String str, String str2, List<CJRABCHLItems> list) {
        k.c(list, "items");
        this.layout = str;
        this.name = str2;
        this.items = list;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final void setLayout(String str) {
        this.layout = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAutomaticBillCategoriesHomepageLayout(String str, String str2, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, list);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final List<CJRABCHLItems> getItems() {
        return this.items;
    }

    public final void setItems(List<CJRABCHLItems> list) {
        k.c(list, "<set-?>");
        this.items = list;
    }
}
