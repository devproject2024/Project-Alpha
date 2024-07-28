package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRUserMoviePassWrapperModel extends IJRPaytmDataModel {
    private ArrayList<CJRUserMoviePassModel> activePass;
    private String currentDate;
    private List<CJRUserMoviePassModel> expiredPass;

    public static /* synthetic */ CJRUserMoviePassWrapperModel copy$default(CJRUserMoviePassWrapperModel cJRUserMoviePassWrapperModel, String str, ArrayList<CJRUserMoviePassModel> arrayList, List<CJRUserMoviePassModel> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRUserMoviePassWrapperModel.currentDate;
        }
        if ((i2 & 2) != 0) {
            arrayList = cJRUserMoviePassWrapperModel.activePass;
        }
        if ((i2 & 4) != 0) {
            list = cJRUserMoviePassWrapperModel.expiredPass;
        }
        return cJRUserMoviePassWrapperModel.copy(str, arrayList, list);
    }

    public final String component1() {
        return this.currentDate;
    }

    public final ArrayList<CJRUserMoviePassModel> component2() {
        return this.activePass;
    }

    public final List<CJRUserMoviePassModel> component3() {
        return this.expiredPass;
    }

    public final CJRUserMoviePassWrapperModel copy(String str, ArrayList<CJRUserMoviePassModel> arrayList, List<CJRUserMoviePassModel> list) {
        return new CJRUserMoviePassWrapperModel(str, arrayList, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRUserMoviePassWrapperModel)) {
            return false;
        }
        CJRUserMoviePassWrapperModel cJRUserMoviePassWrapperModel = (CJRUserMoviePassWrapperModel) obj;
        return k.a((Object) this.currentDate, (Object) cJRUserMoviePassWrapperModel.currentDate) && k.a((Object) this.activePass, (Object) cJRUserMoviePassWrapperModel.activePass) && k.a((Object) this.expiredPass, (Object) cJRUserMoviePassWrapperModel.expiredPass);
    }

    public final int hashCode() {
        String str = this.currentDate;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<CJRUserMoviePassModel> arrayList = this.activePass;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        List<CJRUserMoviePassModel> list = this.expiredPass;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRUserMoviePassWrapperModel(currentDate=" + this.currentDate + ", activePass=" + this.activePass + ", expiredPass=" + this.expiredPass + ")";
    }

    public final String getCurrentDate() {
        return this.currentDate;
    }

    public final void setCurrentDate(String str) {
        this.currentDate = str;
    }

    public final ArrayList<CJRUserMoviePassModel> getActivePass() {
        return this.activePass;
    }

    public final void setActivePass(ArrayList<CJRUserMoviePassModel> arrayList) {
        this.activePass = arrayList;
    }

    public CJRUserMoviePassWrapperModel(String str, ArrayList<CJRUserMoviePassModel> arrayList, List<CJRUserMoviePassModel> list) {
        this.currentDate = str;
        this.activePass = arrayList;
        this.expiredPass = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRUserMoviePassWrapperModel(String str, ArrayList arrayList, List list, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? null : arrayList, (i2 & 4) != 0 ? null : list);
    }

    public final List<CJRUserMoviePassModel> getExpiredPass() {
        return this.expiredPass;
    }

    public final void setExpiredPass(List<CJRUserMoviePassModel> list) {
        this.expiredPass = list;
    }
}
