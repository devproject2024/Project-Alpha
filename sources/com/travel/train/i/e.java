package com.travel.train.i;

import android.app.Activity;
import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainConfirmation;
import com.travel.train.model.trainticket.CJRTrainOffers;
import com.travel.train.model.trainticket.CJRTrainPromoVerify;
import com.travel.train.model.travellerProfile.model.CJRTpUserProfile;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRPGTokenList;

public interface e {
    double a(double d2, double d3);

    void a();

    void a(int i2);

    void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

    void a(CJRTrainBooking cJRTrainBooking);

    void a(CJRTrainConfirmation cJRTrainConfirmation);

    void a(CJRTrainOffers cJRTrainOffers);

    void a(CJRTrainPromoVerify cJRTrainPromoVerify);

    void a(CJRTpUserProfile cJRTpUserProfile);

    void a(CJRTpUserProfileContact cJRTpUserProfileContact);

    void a(Double d2);

    void a(String str);

    void a(String str, String str2);

    void a(CJRPGTokenList cJRPGTokenList);

    void b(int i2);

    void b(Double d2);

    void b(String str);

    void c(Double d2);

    void c(String str);

    CJRTrainBooking d();

    HashMap<Integer, String> e();

    boolean f();

    void g();

    void h();

    void i();

    void j();

    Double k();

    Double l();

    void m();

    void n();

    void o();

    void p();

    void q();

    void r();

    void removeProgressDialog();

    void showErrorDialog(String str, String str2);

    void showProgressDialog(Context context, String str);

    void showSessionTimeoutAlert(NetworkCustomError networkCustomError);

    void t();

    Activity u();
}
