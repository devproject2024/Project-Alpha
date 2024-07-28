package net.one97.paytm.recharge.common.g;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.al;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJRSendOTP;
import net.one97.paytm.recharge.model.CJRValidateOTP;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class a implements ai {

    /* renamed from: a  reason: collision with root package name */
    public Activity f61403a;

    /* renamed from: b  reason: collision with root package name */
    private al f61404b;

    /* renamed from: c  reason: collision with root package name */
    private String f61405c = a.class.getSimpleName();

    public a(Activity activity, al alVar) {
        this.f61403a = activity;
        this.f61404b = alVar;
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        Activity activity = this.f61403a;
        if (activity != null && !activity.isFinishing() && iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof CJRSendOTP) {
                CJRSendOTP cJRSendOTP = (CJRSendOTP) iJRPaytmDataModel;
                al alVar = this.f61404b;
                if (!(alVar == null || cJRSendOTP == null)) {
                    alVar.a(cJRSendOTP);
                }
            }
            if (iJRPaytmDataModel instanceof CJRValidateOTP) {
                CJRValidateOTP cJRValidateOTP = (CJRValidateOTP) iJRPaytmDataModel;
                al alVar2 = this.f61404b;
                if (alVar2 != null && cJRValidateOTP != null) {
                    alVar2.a(cJRValidateOTP);
                }
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        NetworkCustomError networkCustomError2 = networkCustomError;
        Object obj2 = obj;
        Activity activity = this.f61403a;
        if (activity != null && !activity.isFinishing()) {
            try {
                if (this.f61404b != null) {
                    this.f61404b.a(false);
                }
                if (networkCustomError2 != null && !TextUtils.isEmpty(networkCustomError.getMessage())) {
                    if (CJRRechargeUtilities.INSTANCE.checkErrorCode(str, this.f61403a, networkCustomError2, obj2)) {
                        return;
                    }
                    if (networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                        ACTION_TYPE action_type2 = null;
                        if (obj2 instanceof CJRRechargeErrorModel) {
                            CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj2;
                            cJRRechargeErrorModel2.setErrorType(ERROR_TYPE.PARSING);
                            CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                            if (flowName != null) {
                                flowName.setErrorType(ERROR_TYPE.PARSING.name());
                                action_type2 = ACTION_TYPE.Companion.getActionType(flowName.getActionType(), ACTION_TYPE.OTP);
                            }
                            cJRRechargeErrorModel = cJRRechargeErrorModel2;
                            action_type = action_type2;
                        } else {
                            action_type = null;
                            cJRRechargeErrorModel = null;
                        }
                        az azVar = az.f61525a;
                        Activity activity2 = this.f61403a;
                        ERROR_TYPE error_type = ERROR_TYPE.PARSING;
                        String url = networkCustomError.getUrl();
                        StringBuilder sb = new StringBuilder();
                        sb.append(networkCustomError.getStatusCode());
                        az.a(activity2, error_type, action_type, url, sb.toString(), false, cJRRechargeErrorModel.getCategoryId(), cJRRechargeErrorModel.getScreenName(), cJRRechargeErrorModel.getProductId(), cJRRechargeErrorModel, false);
                        return;
                    }
                    String string = this.f61403a.getResources().getString(R.string.network_error_message_re);
                    az azVar2 = az.f61525a;
                    az.a(this.f61403a, ERROR_TYPE.NO_CONNECTION, ACTION_TYPE.OTP, this.f61403a.getResources().getString(R.string.network_error_heading_re), string);
                }
            } catch (Resources.NotFoundException | Exception unused) {
            }
        }
    }
}
