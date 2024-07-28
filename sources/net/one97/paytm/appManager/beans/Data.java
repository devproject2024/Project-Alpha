package net.one97.paytm.appManager.beans;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Arrays;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.appManager.storage.db.c;

public final class Data extends IJRPaytmDataModel {
    @b(a = "deleted_list")
    private c[] deletedList;
    @b(a = "list")
    private c[] list;
    @b(a = "meta_data")
    private MetaInfo metaData;

    public Data() {
        this((MetaInfo) null, (c[]) null, (c[]) null, 7, (g) null);
    }

    public static /* synthetic */ Data copy$default(Data data, MetaInfo metaInfo, c[] cVarArr, c[] cVarArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            metaInfo = data.metaData;
        }
        if ((i2 & 2) != 0) {
            cVarArr = data.list;
        }
        if ((i2 & 4) != 0) {
            cVarArr2 = data.deletedList;
        }
        return data.copy(metaInfo, cVarArr, cVarArr2);
    }

    public final MetaInfo component1() {
        return this.metaData;
    }

    public final c[] component2() {
        return this.list;
    }

    public final c[] component3() {
        return this.deletedList;
    }

    public final Data copy(MetaInfo metaInfo, c[] cVarArr, c[] cVarArr2) {
        return new Data(metaInfo, cVarArr, cVarArr2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data = (Data) obj;
        return k.a((Object) this.metaData, (Object) data.metaData) && k.a((Object) this.list, (Object) data.list) && k.a((Object) this.deletedList, (Object) data.deletedList);
    }

    public final int hashCode() {
        MetaInfo metaInfo = this.metaData;
        int i2 = 0;
        int hashCode = (metaInfo != null ? metaInfo.hashCode() : 0) * 31;
        c[] cVarArr = this.list;
        int hashCode2 = (hashCode + (cVarArr != null ? Arrays.hashCode(cVarArr) : 0)) * 31;
        c[] cVarArr2 = this.deletedList;
        if (cVarArr2 != null) {
            i2 = Arrays.hashCode(cVarArr2);
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Data(metaData=" + this.metaData + ", list=" + Arrays.toString(this.list) + ", deletedList=" + Arrays.toString(this.deletedList) + ")";
    }

    public final MetaInfo getMetaData() {
        return this.metaData;
    }

    public final void setMetaData(MetaInfo metaInfo) {
        this.metaData = metaInfo;
    }

    public final c[] getList() {
        return this.list;
    }

    public final void setList(c[] cVarArr) {
        this.list = cVarArr;
    }

    public Data(MetaInfo metaInfo, c[] cVarArr, c[] cVarArr2) {
        this.metaData = metaInfo;
        this.list = cVarArr;
        this.deletedList = cVarArr2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Data(MetaInfo metaInfo, c[] cVarArr, c[] cVarArr2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : metaInfo, (i2 & 2) != 0 ? null : cVarArr, (i2 & 4) != 0 ? null : cVarArr2);
    }

    public final c[] getDeletedList() {
        return this.deletedList;
    }

    public final void setDeletedList(c[] cVarArr) {
        this.deletedList = cVarArr;
    }
}
