package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.BranchData;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.i.a;

public class BranchModel {
    f gson;
    private final SheroesAppServiceApi sheroesAppServiceApi;

    public BranchModel(SheroesAppServiceApi sheroesAppServiceApi2, f fVar) {
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
        this.gson = fVar;
    }

    public p<BranchData> fetchBranchData(String str, String str2) {
        return this.sheroesAppServiceApi.fetchBranchData(str, str2).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }
}
