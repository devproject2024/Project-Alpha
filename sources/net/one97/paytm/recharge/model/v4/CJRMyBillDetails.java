package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRMyBillDetails extends IJRPaytmDataModel {
    @b(a = "imageUrl")
    private final ArrayList<String> imageUrls;
    @b(a = "isWebView")
    private final boolean isWebView;
    @b(a = "pdfUrl")
    private final String pdfUrl;

    public CJRMyBillDetails() {
        this((String) null, false, (ArrayList) null, 7, (g) null);
    }

    public static /* synthetic */ CJRMyBillDetails copy$default(CJRMyBillDetails cJRMyBillDetails, String str, boolean z, ArrayList<String> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRMyBillDetails.pdfUrl;
        }
        if ((i2 & 2) != 0) {
            z = cJRMyBillDetails.isWebView;
        }
        if ((i2 & 4) != 0) {
            arrayList = cJRMyBillDetails.imageUrls;
        }
        return cJRMyBillDetails.copy(str, z, arrayList);
    }

    public final String component1() {
        return this.pdfUrl;
    }

    public final boolean component2() {
        return this.isWebView;
    }

    public final ArrayList<String> component3() {
        return this.imageUrls;
    }

    public final CJRMyBillDetails copy(String str, boolean z, ArrayList<String> arrayList) {
        return new CJRMyBillDetails(str, z, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRMyBillDetails) {
                CJRMyBillDetails cJRMyBillDetails = (CJRMyBillDetails) obj;
                if (k.a((Object) this.pdfUrl, (Object) cJRMyBillDetails.pdfUrl)) {
                    if (!(this.isWebView == cJRMyBillDetails.isWebView) || !k.a((Object) this.imageUrls, (Object) cJRMyBillDetails.imageUrls)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.pdfUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.isWebView;
        if (z) {
            z = true;
        }
        int i3 = (hashCode + (z ? 1 : 0)) * 31;
        ArrayList<String> arrayList = this.imageUrls;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "CJRMyBillDetails(pdfUrl=" + this.pdfUrl + ", isWebView=" + this.isWebView + ", imageUrls=" + this.imageUrls + ")";
    }

    public final String getPdfUrl() {
        return this.pdfUrl;
    }

    public final boolean isWebView() {
        return this.isWebView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMyBillDetails(String str, boolean z, ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : arrayList);
    }

    public final ArrayList<String> getImageUrls() {
        return this.imageUrls;
    }

    public CJRMyBillDetails(String str, boolean z, ArrayList<String> arrayList) {
        this.pdfUrl = str;
        this.isWebView = z;
        this.imageUrls = arrayList;
    }
}
