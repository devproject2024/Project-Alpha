package com.travel.train.i;

import android.app.Activity;
import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface g {
    void a();

    void a(int i2);

    void a(IJRPaytmDataModel iJRPaytmDataModel);

    void a(aj ajVar);

    void a(String str);

    void a(String str, String str2);

    String d();

    Activity e();

    void removeProgressDialog();

    void showProgressDialog(Context context, String str);

    void showSessionTimeoutAlert(NetworkCustomError networkCustomError);
}
