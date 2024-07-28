package com.paytm.business.merchantprofile.profileotp;

import android.widget.Toast;
import androidx.lifecycle.z;
import com.business.common_module.events.ErrorDisplayEvent;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import kotlin.g.b.k;
import kotlin.m.p;
import org.greenrobot.eventbus.c;

public final class AddMobileOTPActivity$setUpData$1<T> implements z<b<GenerateOtpResponseModel>> {
    public final /* synthetic */ AddMobileOTPActivity this$0;

    public AddMobileOTPActivity$setUpData$1(AddMobileOTPActivity addMobileOTPActivity) {
        this.this$0 = addMobileOTPActivity;
    }

    public final void onChanged(b<GenerateOtpResponseModel> bVar) {
        T t;
        String str;
        String str2;
        e eVar = bVar.f7357b;
        if (eVar == e.OFFLINE) {
            c.a().c(new ErrorDisplayEvent(AddMobileOTPActivity.Companion.getTAG()));
        } else if (eVar != e.LOADING) {
            this.this$0.removeProgressDialog();
            if (bVar.f7357b == e.SUCCESS && (t = bVar.f7358c) != null) {
                GenerateOtpResponseModel generateOtpResponseModel = (GenerateOtpResponseModel) t;
                String str3 = null;
                if (generateOtpResponseModel != null) {
                    str = generateOtpResponseModel.getStatus();
                } else {
                    str = null;
                }
                if (p.a(str, "FAILURE", false)) {
                    String string = this.this$0.getResources().getString(R.string.pr_error_msg_default);
                    k.b(string, "resources.getString(R.string.pr_error_msg_default)");
                    if (generateOtpResponseModel != null) {
                        str3 = generateOtpResponseModel.getMessage();
                    }
                    if (str3 != null) {
                        string = generateOtpResponseModel.getMessage();
                        k.b(string, "model.message");
                    }
                    ProfileConfig instance = ProfileConfig.getInstance();
                    k.b(instance, "ProfileConfig.getInstance()");
                    Toast.makeText(instance.getAppContext(), string, 1).show();
                    this.this$0.finish();
                    return;
                }
                if (generateOtpResponseModel != null) {
                    str2 = generateOtpResponseModel.getStatus();
                } else {
                    str2 = null;
                }
                if (p.a(str2, "SUCCESS", false)) {
                    AddMobileOTPActivity addMobileOTPActivity = this.this$0;
                    if (generateOtpResponseModel != null) {
                        str3 = generateOtpResponseModel.getState();
                    }
                    addMobileOTPActivity.setOtpState(str3);
                }
            }
        }
    }
}
