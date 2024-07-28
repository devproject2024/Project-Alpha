package com.paytm.contactsSdk.models;

import java.util.List;
import kotlin.g.b.k;

public final class Schema {
    private final List<String> columns;
    private final String contentUri;

    public Schema(String str, List<String> list) {
        k.c(str, "contentUri");
        k.c(list, "columns");
        this.contentUri = str;
        this.columns = list;
    }

    public final List<String> getColumns() {
        return this.columns;
    }

    public final String getContentUri() {
        return this.contentUri;
    }
}
