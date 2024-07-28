package net.one97.paytm.dynamic.module.eduforms.plugins;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJREduFeeConfigModel extends IJRPaytmDataModel {
    @b(a = "android")
    private CJREduFeeAndroid cjrEduFeeAndroid;

    public CJREduFeeAndroid getCjrEduFeeAndroid() {
        return this.cjrEduFeeAndroid;
    }
}
