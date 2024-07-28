package com.paytm.android.chat.network.response;

import com.alipay.mobile.h5container.api.H5Param;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class ResponseSF {
    private ArrayList<Page> page;

    public ResponseSF(ArrayList<Page> arrayList) {
        k.c(arrayList, H5Param.PAGE);
        this.page = arrayList;
    }

    public final ArrayList<Page> getPage() {
        return this.page;
    }

    public final void setPage(ArrayList<Page> arrayList) {
        k.c(arrayList, "<set-?>");
        this.page = arrayList;
    }
}
