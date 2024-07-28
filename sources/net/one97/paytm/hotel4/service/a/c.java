package net.one97.paytm.hotel4.service.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.OrderSummary;
import net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public y<OrderSummary> f28598a;

    /* renamed from: b  reason: collision with root package name */
    public y<ErrorData> f28599b;

    /* renamed from: c  reason: collision with root package name */
    public y<CJRActionResponse> f28600c;

    /* renamed from: d  reason: collision with root package name */
    public y<CancelOrderModel> f28601d;

    /* renamed from: e  reason: collision with root package name */
    public y<ErrorData> f28602e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f28603f;

    public c(Context context) {
        k.c(context, "context");
        this.f28603f = context;
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f28605a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f28606b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f28607c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ y f28608d;

        public b(c cVar, String str, y yVar, y yVar2) {
            this.f28605a = cVar;
            this.f28606b = str;
            this.f28607c = yVar;
            this.f28608d = yVar2;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (networkCustomError == null) {
                this.f28607c.postValue(null);
            } else if (networkCustomError.getStatusCode() == 401) {
                this.f28607c.postValue(new ErrorData(Integer.valueOf(networkCustomError.getStatusCode()), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage()));
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y yVar = this.f28608d;
            if (iJRPaytmDataModel != null) {
                yVar.postValue((CancelOrderModel) iJRPaytmDataModel);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.ordersummary.CancelOrderModel");
        }
    }

    public final class a implements com.paytm.network.listener.b {
        public a() {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            y<CancelOrderModel> yVar;
            if (iJRPaytmDataModel instanceof OrderSummary) {
                y<OrderSummary> yVar2 = c.this.f28598a;
                if (yVar2 != null) {
                    yVar2.postValue(iJRPaytmDataModel);
                }
            } else if (iJRPaytmDataModel instanceof CJRActionResponse) {
                y<CJRActionResponse> yVar3 = c.this.f28600c;
                if (yVar3 != null) {
                    yVar3.postValue(iJRPaytmDataModel);
                }
            } else if ((iJRPaytmDataModel instanceof CancelOrderModel) && (yVar = c.this.f28601d) != null) {
                yVar.postValue(iJRPaytmDataModel);
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            String str = null;
            if (iJRPaytmDataModel instanceof OrderSummary) {
                if (networkCustomError == null) {
                    y<OrderSummary> yVar = c.this.f28598a;
                    if (yVar != null) {
                        yVar.postValue(null);
                    }
                } else if (networkCustomError.getStatusCode() == 401) {
                    ErrorData errorData = new ErrorData(Integer.valueOf(networkCustomError.getStatusCode()), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                    y<ErrorData> yVar2 = c.this.f28599b;
                    if (yVar2 != null) {
                        yVar2.postValue(errorData);
                    }
                } else {
                    y<OrderSummary> yVar3 = c.this.f28598a;
                    if (yVar3 != null) {
                        yVar3.postValue(null);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRActionResponse) {
                y<CJRActionResponse> yVar4 = c.this.f28600c;
                if (yVar4 != null) {
                    yVar4.postValue(null);
                }
            } else if (iJRPaytmDataModel instanceof CancelOrderModel) {
                ErrorData errorData2 = new ErrorData(networkCustomError != null ? Integer.valueOf(networkCustomError.getStatusCode()) : null, networkCustomError != null ? networkCustomError.getAlertTitle() : null, networkCustomError != null ? networkCustomError.getAlertMessage() : null);
                y<ErrorData> yVar5 = c.this.f28602e;
                if (yVar5 != null) {
                    yVar5.postValue(errorData2);
                }
                if (i2 == 401 || i2 == 410) {
                    ErrorData errorData3 = new ErrorData(401, "", "");
                    y<ErrorData> yVar6 = c.this.f28602e;
                    if (yVar6 != null) {
                        yVar6.postValue(errorData3);
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(networkCustomError != null ? networkCustomError.getAlertMessage() : null)) {
                    String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
                    if (networkCustomError != null) {
                        str = networkCustomError.getAlertMessage();
                    }
                    ErrorData errorData4 = new ErrorData(401, alertTitle, str);
                    y<ErrorData> yVar7 = c.this.f28602e;
                    if (yVar7 != null) {
                        yVar7.postValue(errorData4);
                        return;
                    }
                    return;
                }
                y<ErrorData> yVar8 = c.this.f28602e;
                if (yVar8 != null) {
                    yVar8.postValue(null);
                }
            }
        }
    }
}
