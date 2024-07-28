package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SortKeysItem implements Serializable {

    /* renamed from: default  reason: not valid java name */
    private String f378default;
    private boolean isSelected;
    private String name;
    private String urlParams;

    public SortKeysItem() {
        this((String) null, (String) null, (String) null, false, 15, (g) null);
    }

    public SortKeysItem(String str, String str2, String str3, boolean z) {
        k.c(str, "default");
        k.c(str2, "name");
        k.c(str3, "urlParams");
        this.f378default = str;
        this.name = str2;
        this.urlParams = str3;
        this.isSelected = z;
    }

    public final String getDefault() {
        return this.f378default;
    }

    public final void setDefault(String str) {
        k.c(str, "<set-?>");
        this.f378default = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getUrlParams() {
        return this.urlParams;
    }

    public final void setUrlParams(String str) {
        k.c(str, "<set-?>");
        this.urlParams = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SortKeysItem(String str, String str2, String str3, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? false : z);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
