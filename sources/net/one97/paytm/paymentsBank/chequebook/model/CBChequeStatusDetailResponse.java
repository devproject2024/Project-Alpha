package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CBChequeStatusDetailResponse extends IJRPaytmDataModel {
    @b(a = "chequeDetailCountPresent")
    private int chqDetailCount;
    @b(a = "chequeDetails")
    private List<ChequeDetailsForInwardOutward> chqListForInwrdOutwrd;
    @b(a = "currentPage")
    private int crntPage;
    @b(a = "totalPages")
    private int totalPages;

    public CBChequeStatusDetailResponse() {
        this(0, 0, 0, (List) null, 15, (g) null);
    }

    public static /* synthetic */ CBChequeStatusDetailResponse copy$default(CBChequeStatusDetailResponse cBChequeStatusDetailResponse, int i2, int i3, int i4, List<ChequeDetailsForInwardOutward> list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = cBChequeStatusDetailResponse.chqDetailCount;
        }
        if ((i5 & 2) != 0) {
            i3 = cBChequeStatusDetailResponse.totalPages;
        }
        if ((i5 & 4) != 0) {
            i4 = cBChequeStatusDetailResponse.crntPage;
        }
        if ((i5 & 8) != 0) {
            list = cBChequeStatusDetailResponse.chqListForInwrdOutwrd;
        }
        return cBChequeStatusDetailResponse.copy(i2, i3, i4, list);
    }

    public final int component1() {
        return this.chqDetailCount;
    }

    public final int component2() {
        return this.totalPages;
    }

    public final int component3() {
        return this.crntPage;
    }

    public final List<ChequeDetailsForInwardOutward> component4() {
        return this.chqListForInwrdOutwrd;
    }

    public final CBChequeStatusDetailResponse copy(int i2, int i3, int i4, List<ChequeDetailsForInwardOutward> list) {
        return new CBChequeStatusDetailResponse(i2, i3, i4, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CBChequeStatusDetailResponse) {
                CBChequeStatusDetailResponse cBChequeStatusDetailResponse = (CBChequeStatusDetailResponse) obj;
                if (this.chqDetailCount == cBChequeStatusDetailResponse.chqDetailCount) {
                    if (this.totalPages == cBChequeStatusDetailResponse.totalPages) {
                        if (!(this.crntPage == cBChequeStatusDetailResponse.crntPage) || !k.a((Object) this.chqListForInwrdOutwrd, (Object) cBChequeStatusDetailResponse.chqListForInwrdOutwrd)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = ((((this.chqDetailCount * 31) + this.totalPages) * 31) + this.crntPage) * 31;
        List<ChequeDetailsForInwardOutward> list = this.chqListForInwrdOutwrd;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "CBChequeStatusDetailResponse(chqDetailCount=" + this.chqDetailCount + ", totalPages=" + this.totalPages + ", crntPage=" + this.crntPage + ", chqListForInwrdOutwrd=" + this.chqListForInwrdOutwrd + ")";
    }

    public final int getChqDetailCount() {
        return this.chqDetailCount;
    }

    public final void setChqDetailCount(int i2) {
        this.chqDetailCount = i2;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public final void setTotalPages(int i2) {
        this.totalPages = i2;
    }

    public final int getCrntPage() {
        return this.crntPage;
    }

    public final void setCrntPage(int i2) {
        this.crntPage = i2;
    }

    public CBChequeStatusDetailResponse(int i2, int i3, int i4, List<ChequeDetailsForInwardOutward> list) {
        this.chqDetailCount = i2;
        this.totalPages = i3;
        this.crntPage = i4;
        this.chqListForInwrdOutwrd = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CBChequeStatusDetailResponse(int i2, int i3, int i4, List list, int i5, g gVar) {
        this((i5 & 1) != 0 ? 0 : i2, (i5 & 2) != 0 ? 0 : i3, (i5 & 4) != 0 ? 0 : i4, (i5 & 8) != 0 ? null : list);
    }

    public final List<ChequeDetailsForInwardOutward> getChqListForInwrdOutwrd() {
        return this.chqListForInwrdOutwrd;
    }

    public final void setChqListForInwrdOutwrd(List<ChequeDetailsForInwardOutward> list) {
        this.chqListForInwrdOutwrd = list;
    }
}
