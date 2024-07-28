package net.one97.paytm.recharge.common.f;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.network.b.g;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.CJRIllegalCodeError;
import com.paytm.network.model.ErrorAdditionalInfo;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.b;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilteredProductListV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductListV2;
import net.one97.paytm.recharge.legacy.catalog.model.CalendarResponseModel;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private final String f61103a;

    /* renamed from: b  reason: collision with root package name */
    private final ai f61104b;

    /* renamed from: c  reason: collision with root package name */
    private final String f61105c;

    /* renamed from: d  reason: collision with root package name */
    private final String f61106d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f61107e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, ai aiVar, String str2, String str3, Object obj) {
        super(aiVar, str, obj);
        k.c(str, "tag");
        k.c(aiVar, "listener");
        k.c(str3, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.f61103a = str;
        this.f61104b = aiVar;
        this.f61105c = str2;
        this.f61106d = str3;
        this.f61107e = obj;
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        NetworkResponse networkResponse;
        k.c(str, "tag");
        Integer num = null;
        if (networkCustomError != null) {
            try {
                networkResponse = networkCustomError.networkResponse;
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        } else {
            networkResponse = null;
        }
        String str2 = "";
        if (networkResponse != null) {
            if (networkCustomError.networkResponse.data != null) {
                byte[] bArr = networkCustomError.networkResponse.data;
                if (k.a((Object) str2, (Object) "gzip")) {
                    Reader a2 = g.a(bArr);
                    if (a2 != null) {
                        str2 = g.a(a2);
                    }
                } else {
                    k.a((Object) bArr, "networkData");
                    str2 = new String(bArr, d.f47971a);
                }
            }
        }
        if (i2 == 401 || i2 == 410 || i2 == 412 || i2 == 499 || i2 == 502 || i2 == 503 || i2 == 504) {
            throw new net.one97.paytm.recharge.legacy.catalog.b.b(str2);
        }
        try {
            CJRIllegalCodeError cJRIllegalCodeError = (CJRIllegalCodeError) new f().a(str2, new CJRIllegalCodeError().getClass());
            NetworkCustomError networkCustomError2 = new NetworkCustomError(networkCustomError != null ? networkCustomError.networkResponse : null, "failure_error");
            if (networkCustomError != null) {
                z.a(networkCustomError2, networkCustomError);
            }
            if ((cJRIllegalCodeError != null ? cJRIllegalCodeError.getAdditionalInfo() : null) != null) {
                ErrorAdditionalInfo additionalInfo = cJRIllegalCodeError.getAdditionalInfo();
                k.a((Object) additionalInfo, "errorStatus.additionalInfo");
                networkCustomError2.setUniqueReference(additionalInfo.getConfirmationFlag());
                if (!(cJRIllegalCodeError.getStatusError() == null || cJRIllegalCodeError.getStatusError().getmMessage() == null)) {
                    CJRError cJRError = cJRIllegalCodeError.getStatusError().getmMessage();
                    k.a((Object) cJRError, "errorStatus.statusError.getmMessage()");
                    networkCustomError2.setAlertMessage(cJRError.getMessage());
                    CJRError cJRError2 = cJRIllegalCodeError.getStatusError().getmMessage();
                    k.a((Object) cJRError2, "errorStatus.statusError.getmMessage()");
                    networkCustomError2.setmAlertTitle(cJRError2.getTitle());
                }
                b(str, i2, iJRPaytmDataModel, networkCustomError2, this.f61107e);
                return;
            }
            CJRIllegalCodeError cJRIllegalCodeError2 = (CJRIllegalCodeError) new f().a(str2, new CJRIllegalCodeError().getClass());
            if (cJRIllegalCodeError2 == null || cJRIllegalCodeError2.getStatusError() == null || cJRIllegalCodeError2.getStatusError().getmResult() == null || !p.a(cJRIllegalCodeError2.getStatusError().getmResult(), ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true)) {
                throw new net.one97.paytm.recharge.legacy.catalog.b.b(str2);
            }
            if (!(cJRIllegalCodeError2.getStatusError() == null || cJRIllegalCodeError2.getStatusError().getmMessage() == null)) {
                CJRError cJRError3 = cJRIllegalCodeError2.getStatusError().getmMessage();
                k.a((Object) cJRError3, "errorStatus.statusError.getmMessage()");
                networkCustomError2.setAlertMessage(cJRError3.getMessage());
                CJRError cJRError4 = cJRIllegalCodeError2.getStatusError().getmMessage();
                k.a((Object) cJRError4, "errorStatus.statusError.getmMessage()");
                networkCustomError2.setmAlertTitle(cJRError4.getTitle());
            }
            b(str, i2, iJRPaytmDataModel, networkCustomError2, this.f61107e);
        } catch (net.one97.paytm.recharge.legacy.catalog.b.b unused) {
            CJRIllegalCodeError cJRIllegalCodeError3 = (CJRIllegalCodeError) new f().a(str2, new CJRIllegalCodeError().getClass());
            NetworkResponse networkResponse2 = networkCustomError != null ? networkCustomError.networkResponse : null;
            if (networkCustomError != null) {
                num = Integer.valueOf(networkCustomError.getStatusCode());
            }
            NetworkCustomError networkCustomError3 = new NetworkCustomError(networkResponse2, String.valueOf(num));
            if (networkCustomError != null) {
                z.a(networkCustomError3, networkCustomError);
            }
            if (cJRIllegalCodeError3 != null && cJRIllegalCodeError3.getStatusError() != null && cJRIllegalCodeError3.getStatusError().getmMessage() != null) {
                CJRError cJRError5 = cJRIllegalCodeError3.getStatusError().getmMessage();
                k.a((Object) cJRError5, "errorStatus.statusError.getmMessage()");
                networkCustomError3.setAlertMessage(cJRError5.getMessage());
                CJRError cJRError6 = cJRIllegalCodeError3.getStatusError().getmMessage();
                k.a((Object) cJRError6, "errorStatus.statusError.getmMessage()");
                networkCustomError3.setmAlertTitle(cJRError6.getTitle());
            } else if (cJRIllegalCodeError3 != null && !TextUtils.isEmpty(cJRIllegalCodeError3.getError()) && p.a(cJRIllegalCodeError3.getError(), "true", true) && !TextUtils.isEmpty(cJRIllegalCodeError3.getError_message())) {
                networkCustomError3.setAlertMessage(cJRIllegalCodeError3.getError_message());
            } else if (cJRIllegalCodeError3 != null && !TextUtils.isEmpty(cJRIllegalCodeError3.getError())) {
                networkCustomError3.setAlertMessage(cJRIllegalCodeError3.getError());
            }
            b(str, i2, iJRPaytmDataModel, networkCustomError3, this.f61107e);
        } catch (Exception e3) {
            q.d(e3.getMessage());
            b(str, i2, iJRPaytmDataModel, networkCustomError, this.f61107e);
        }
    }

    private final void b(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        NetworkCustomError.ErrorType errorType;
        String str2 = null;
        if (obj instanceof CJRRechargeErrorModel) {
            cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
        } else {
            if (obj instanceof HashMap) {
                Object obj2 = ((Map) obj).get("hawkEyeModel");
                if (obj2 instanceof CJRRechargeErrorModel) {
                    cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                }
            }
            cJRRechargeErrorModel = null;
        }
        if (cJRRechargeErrorModel != null) {
            if (networkCustomError != null) {
                errorType = networkCustomError.getErrorType();
            } else {
                errorType = null;
            }
            if (errorType != null) {
                int i3 = f.f61108a[errorType.ordinal()];
                if (i3 == 1) {
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.TIMEOUT);
                    CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.TIMEOUT.name());
                    }
                } else if (i3 == 2) {
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.AUTH);
                    ay.a(true);
                    CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setErrorType(ERROR_TYPE.AUTH.name());
                    }
                } else if (i3 == 3) {
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.NO_CONNECTION);
                    CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
                    if (flowName3 != null) {
                        flowName3.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                    }
                } else if (i3 == 4) {
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.PARSING);
                    CRUFlowModel flowName4 = cJRRechargeErrorModel.getFlowName();
                    if (flowName4 != null) {
                        flowName4.setErrorType(ERROR_TYPE.PARSING.name());
                    }
                } else if (i3 == 5) {
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.INVALID_ARG);
                    CRUFlowModel flowName5 = cJRRechargeErrorModel.getFlowName();
                    if (flowName5 != null) {
                        flowName5.setErrorType(ERROR_TYPE.INVALID_ARG.name());
                    }
                }
            }
            CRUFlowModel flowName6 = cJRRechargeErrorModel.getFlowName();
            if (flowName6 != null) {
                flowName6.setTag(str);
            }
            cJRRechargeErrorModel.setErrorCode(String.valueOf(i2));
            if (!TextUtils.isEmpty(networkCustomError != null ? networkCustomError.getAlertMessage() : null)) {
                if (networkCustomError != null) {
                    str2 = networkCustomError.getAlertMessage();
                }
                cJRRechargeErrorModel.setErrorMsg(str2);
            }
        }
        this.f61104b.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        int a2;
        CRUFlowModel flowName;
        k.c(str, "tag");
        if (obj instanceof CJRRechargeErrorModel) {
            cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
        } else {
            if (obj instanceof HashMap) {
                Object obj2 = ((Map) obj).get("hawkEyeModel");
                if (obj2 instanceof CJRRechargeErrorModel) {
                    cJRRechargeErrorModel = (CJRRechargeErrorModel) obj2;
                }
            }
            cJRRechargeErrorModel = null;
        }
        if (!(cJRRechargeErrorModel == null || (flowName = cJRRechargeErrorModel.getFlowName()) == null)) {
            flowName.setTag(str);
        }
        if ((iJRPaytmDataModel instanceof CJRUtilityFilteredProductListV2) || (iJRPaytmDataModel instanceof CJRUtilityProductListV2)) {
            String str2 = this.f61105c;
            if (!(str2 == null || (a2 = p.a((CharSequence) str2, "?", 0, false, 6)) == -1)) {
                CJRUtilityProductListV2 cJRUtilityProductListV2 = (CJRUtilityProductListV2) iJRPaytmDataModel;
                String str3 = this.f61105c;
                if (str3 != null) {
                    String substring = str3.substring(0, a2);
                    k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    cJRUtilityProductListV2.setUrl(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            this.f61104b.a_(str, (IJRPaytmDataModel) null, obj);
        } else if ((iJRPaytmDataModel instanceof CalendarResponseModel) && iJRPaytmDataModel.getNetworkResponse() != null && iJRPaytmDataModel.getNetworkResponse().statusCode == 406) {
            this.f61104b.a(str, iJRPaytmDataModel.getNetworkResponse().statusCode, iJRPaytmDataModel, new NetworkCustomError(((CalendarResponseModel) iJRPaytmDataModel).getNetworkResponse()), this.f61107e);
        } else if (iJRPaytmDataModel instanceof CJRRechargeCart) {
            CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
            CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
            if (p.a("SUCCESS", cartStatus != null ? cartStatus.getResult() : null, true)) {
                az azVar = az.f61525a;
                Bundle a3 = az.a((Context) null, cJRRechargeCart, true, 5);
                boolean z = a3.getBoolean("extra.has.error");
                String string = a3.getString("extra.error.msg");
                String string2 = a3.getString("extra.error.code");
                if (z && cJRRechargeErrorModel != null) {
                    cJRRechargeErrorModel.setErrorMsg(string);
                    cJRRechargeErrorModel.setErrorType(ERROR_TYPE.VERIFY_200);
                    CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setErrorType(ERROR_TYPE.VERIFY_200.name());
                    }
                    CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
                    if (flowName3 != null) {
                        flowName3.setVerifyErrorCode(string2);
                    }
                }
            }
        }
        this.f61104b.a_(str, iJRPaytmDataModel, obj);
    }
}
