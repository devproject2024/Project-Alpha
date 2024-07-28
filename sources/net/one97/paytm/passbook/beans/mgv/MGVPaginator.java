package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MGVPaginator extends IJRDataModel {
    @b(a = "pageNum")
    private int pageNum;
    @b(a = "pageSize")
    private int pageSize;
    @b(a = "totalCount")
    private int totalCount;
    @b(a = "totalPage")
    private int totalPage;

    public static /* synthetic */ MGVPaginator copy$default(MGVPaginator mGVPaginator, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = mGVPaginator.pageNum;
        }
        if ((i6 & 2) != 0) {
            i3 = mGVPaginator.pageSize;
        }
        if ((i6 & 4) != 0) {
            i4 = mGVPaginator.totalPage;
        }
        if ((i6 & 8) != 0) {
            i5 = mGVPaginator.totalCount;
        }
        return mGVPaginator.copy(i2, i3, i4, i5);
    }

    public final int component1() {
        return this.pageNum;
    }

    public final int component2() {
        return this.pageSize;
    }

    public final int component3() {
        return this.totalPage;
    }

    public final int component4() {
        return this.totalCount;
    }

    public final MGVPaginator copy(int i2, int i3, int i4, int i5) {
        return new MGVPaginator(i2, i3, i4, i5);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MGVPaginator) {
                MGVPaginator mGVPaginator = (MGVPaginator) obj;
                if (this.pageNum == mGVPaginator.pageNum) {
                    if (this.pageSize == mGVPaginator.pageSize) {
                        if (this.totalPage == mGVPaginator.totalPage) {
                            if (this.totalCount == mGVPaginator.totalCount) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.pageNum * 31) + this.pageSize) * 31) + this.totalPage) * 31) + this.totalCount;
    }

    public final String toString() {
        return "MGVPaginator(pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", totalPage=" + this.totalPage + ", totalCount=" + this.totalCount + ")";
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final void setPageNum(int i2) {
        this.pageNum = i2;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    public final void setTotalPage(int i2) {
        this.totalPage = i2;
    }

    public MGVPaginator(int i2, int i3, int i4, int i5) {
        this.pageNum = i2;
        this.pageSize = i3;
        this.totalPage = i4;
        this.totalCount = i5;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(int i2) {
        this.totalCount = i2;
    }
}
