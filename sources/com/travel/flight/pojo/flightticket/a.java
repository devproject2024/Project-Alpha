package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.g;

public final class a implements Serializable {
    private String heading;
    @b(a = "table_headers")
    private String[] tableHeader;
    @b(a = "table_rows")
    private h[] tableRows;

    public a() {
        this((String) null, (String[]) null, (h[]) null, 7, (g) null);
    }

    public a(String str, String[] strArr, h[] hVarArr) {
        this.heading = str;
        this.tableHeader = strArr;
        this.tableRows = hVarArr;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        this.heading = str;
    }

    public final String[] getTableHeader() {
        return this.tableHeader;
    }

    public final void setTableHeader(String[] strArr) {
        this.tableHeader = strArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, String[] strArr, h[] hVarArr, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : strArr, (i2 & 4) != 0 ? null : hVarArr);
    }

    public final h[] getTableRows() {
        return this.tableRows;
    }

    public final void setTableRows(h[] hVarArr) {
        this.tableRows = hVarArr;
    }
}
