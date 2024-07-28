package net.one97.paytm.common.entity.upgradeKyc;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class DocData {
    private String docCode;
    private String docName;
    private String docValue;

    public DocData(String str, String str2, String str3) {
        k.c(str, "docCode");
        k.c(str2, "docValue");
        k.c(str3, "docName");
        this.docCode = str;
        this.docValue = str2;
        this.docName = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DocData(String str, String str2, String str3, int i2, g gVar) {
        this(str, str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getDocCode() {
        return this.docCode;
    }

    public final String getDocName() {
        return this.docName;
    }

    public final String getDocValue() {
        return this.docValue;
    }

    public final void setDocCode(String str) {
        k.c(str, "<set-?>");
        this.docCode = str;
    }

    public final void setDocName(String str) {
        k.c(str, "<set-?>");
        this.docName = str;
    }

    public final void setDocValue(String str) {
        k.c(str, "<set-?>");
        this.docValue = str;
    }
}
