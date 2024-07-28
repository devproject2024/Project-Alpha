package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class FilterValuesItem {
    private boolean applied;
    private String id;
    private String name;

    public FilterValuesItem() {
        this(false, (String) null, (String) null, 7, (g) null);
    }

    public FilterValuesItem(boolean z, String str, String str2) {
        k.c(str, "name");
        k.c(str2, "id");
        this.applied = z;
        this.name = str;
        this.id = str2;
    }

    public final boolean getApplied() {
        return this.applied;
    }

    public final void setApplied(boolean z) {
        this.applied = z;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterValuesItem(boolean z, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }
}
