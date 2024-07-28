package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsQuota extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "CK")
    private String cK;
    @a
    @b(a = "GN")
    private String gN;
    @a
    @b(a = "LD")
    private String lD;
    @a
    @b(a = "PT")
    private String pT;

    public CJRTrainSearchResultsQuota() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public final String getGN() {
        return this.gN;
    }

    public final void setGN(String str) {
        this.gN = str;
    }

    public final String getPT() {
        return this.pT;
    }

    public final void setPT(String str) {
        this.pT = str;
    }

    public final String getLD() {
        return this.lD;
    }

    public final void setLD(String str) {
        this.lD = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRTrainSearchResultsQuota(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getCK() {
        return this.cK;
    }

    public final void setCK(String str) {
        this.cK = str;
    }

    public CJRTrainSearchResultsQuota(String str, String str2, String str3, String str4) {
        this.gN = str;
        this.pT = str2;
        this.lD = str3;
        this.cK = str4;
    }
}
