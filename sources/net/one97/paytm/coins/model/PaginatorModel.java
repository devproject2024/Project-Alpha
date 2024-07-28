package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class PaginatorModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "pageNum")
    private Integer pageNum;
    @b(a = "pageSize")
    private Integer pageSize;
    @b(a = "totalCount")
    private Integer totalCount;
    @b(a = "totalPage")
    private Integer totalPage;

    public PaginatorModel() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, 15, (g) null);
    }

    public static /* synthetic */ PaginatorModel copy$default(PaginatorModel paginatorModel, Integer num, Integer num2, Integer num3, Integer num4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = paginatorModel.pageNum;
        }
        if ((i2 & 2) != 0) {
            num2 = paginatorModel.pageSize;
        }
        if ((i2 & 4) != 0) {
            num3 = paginatorModel.totalPage;
        }
        if ((i2 & 8) != 0) {
            num4 = paginatorModel.totalCount;
        }
        return paginatorModel.copy(num, num2, num3, num4);
    }

    public final Integer component1() {
        return this.pageNum;
    }

    public final Integer component2() {
        return this.pageSize;
    }

    public final Integer component3() {
        return this.totalPage;
    }

    public final Integer component4() {
        return this.totalCount;
    }

    public final PaginatorModel copy(Integer num, Integer num2, Integer num3, Integer num4) {
        return new PaginatorModel(num, num2, num3, num4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaginatorModel)) {
            return false;
        }
        PaginatorModel paginatorModel = (PaginatorModel) obj;
        return k.a((Object) this.pageNum, (Object) paginatorModel.pageNum) && k.a((Object) this.pageSize, (Object) paginatorModel.pageSize) && k.a((Object) this.totalPage, (Object) paginatorModel.totalPage) && k.a((Object) this.totalCount, (Object) paginatorModel.totalCount);
    }

    public final int hashCode() {
        Integer num = this.pageNum;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.pageSize;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.totalPage;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.totalCount;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "PaginatorModel(pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", totalPage=" + this.totalPage + ", totalCount=" + this.totalCount + ")";
    }

    public final Integer getPageNum() {
        return this.pageNum;
    }

    public final void setPageNum(Integer num) {
        this.pageNum = num;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public final Integer getTotalPage() {
        return this.totalPage;
    }

    public final void setTotalPage(Integer num) {
        this.totalPage = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaginatorModel(Integer num, Integer num2, Integer num3, Integer num4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4);
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(Integer num) {
        this.totalCount = num;
    }

    public PaginatorModel(Integer num, Integer num2, Integer num3, Integer num4) {
        this.pageNum = num;
        this.pageSize = num2;
        this.totalPage = num3;
        this.totalCount = num4;
    }
}
