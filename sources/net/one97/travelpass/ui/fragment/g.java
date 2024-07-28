package net.one97.travelpass.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.b;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.o;
import net.one97.paytm.i.h;
import net.one97.travelpass.R;
import net.one97.travelpass.model.BookingDetailsResponse;
import net.one97.travelpass.model.CJRErrorStatus;
import net.one97.travelpass.model.CJRMessageFormat;
import net.one97.travelpass.model.MyPasses;
import net.one97.travelpass.model.MyPassesResponse;
import net.one97.travelpass.model.TPAboutResponse;
import net.one97.travelpass.model.TravelPass;
import net.one97.travelpass.model.TravelPassData;
import net.one97.travelpass.ordersummary.model.OrderSummary;
import net.one97.travelpass.ordersummary.model.OrderSummaryBody;

public class g extends h {
    public static final a Companion = new a((byte) 0);
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public static /* synthetic */ void handleErrorCode$default(g gVar, Integer num, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                num = -1;
            }
            if ((i2 & 2) != 0) {
                iJRPaytmDataModel = null;
            }
            if ((i2 & 4) != 0) {
                networkCustomError = null;
            }
            gVar.handleErrorCode(num, iJRPaytmDataModel, networkCustomError);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleErrorCode");
    }

    public final void handleErrorCode(Integer num, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        net.one97.travelpass.model.a aVar = new net.one97.travelpass.model.a();
        String str = null;
        if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    byte[] bArr = networkResponse.data;
                    k.a((Object) bArr, "response.data");
                    Object a2 = new f().a(new String(bArr, d.f47971a), aVar.getClass());
                    k.a((Object) a2, "Gson().fromJson(jsonStri…cjrErrorFormat.javaClass)");
                    aVar = (net.one97.travelpass.model.a) a2;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        if ((num != null && num.intValue() == 401) || ((num != null && num.intValue() == 410) || (num != null && num.intValue() == 403))) {
            showSessionTimeoutAlert(networkCustomError);
        } else if ((num != null && num.intValue() == 449) || ((num != null && num.intValue() == 499) || ((num != null && num.intValue() == 502) || ((num != null && num.intValue() == 503) || (num != null && num.intValue() == 504))))) {
            Context context = getContext();
            String alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
            if (networkCustomError != null) {
                str = networkCustomError.getAlertMessage();
            }
            b.b(context, alertTitle, str);
        } else {
            if (aVar.getStatus() != null) {
                CJRErrorStatus status = aVar.getStatus();
                k.a((Object) status, "cjrErrorFormat.status");
                if (status.getMessage() != null) {
                    CJRErrorStatus status2 = aVar.getStatus();
                    k.a((Object) status2, "cjrErrorFormat.status");
                    CJRMessageFormat message = status2.getMessage();
                    k.a((Object) message, "cjrErrorFormat.status.message");
                    if (!TextUtils.isEmpty(message.getTitle())) {
                        CJRErrorStatus status3 = aVar.getStatus();
                        k.a((Object) status3, "cjrErrorFormat.status");
                        CJRMessageFormat message2 = status3.getMessage();
                        k.a((Object) message2, "cjrErrorFormat.status.message");
                        if (!TextUtils.isEmpty(message2.getMessage())) {
                            Context context2 = getContext();
                            CJRErrorStatus status4 = aVar.getStatus();
                            k.a((Object) status4, "cjrErrorFormat.status");
                            CJRMessageFormat message3 = status4.getMessage();
                            k.a((Object) message3, "cjrErrorFormat.status.message");
                            String title = message3.getTitle();
                            CJRErrorStatus status5 = aVar.getStatus();
                            k.a((Object) status5, "cjrErrorFormat.status");
                            CJRMessageFormat message4 = status5.getMessage();
                            k.a((Object) message4, "cjrErrorFormat.status.message");
                            b.b(context2, title, message4.getMessage());
                            return;
                        }
                    }
                }
            }
            if ((networkCustomError != null ? networkCustomError.getAlertTitle() : null) == null || networkCustomError.getAlertMessage() == null) {
                if (!TextUtils.isEmpty(networkCustomError != null ? networkCustomError.getMessage() : null)) {
                    if ((networkCustomError != null ? networkCustomError.getErrorType() : null) == NetworkCustomError.ErrorType.ParsingError) {
                        String string = getResources().getString(R.string.tp_message_error_data_display);
                        k.a((Object) string, "resources.getString(\n   …ssage_error_data_display)");
                        String string2 = getResources().getString(R.string.tp_error_data_display);
                        k.a((Object) string2, "resources.getString(\n   …ng.tp_error_data_display)");
                        b.b(getContext(), string2, string);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(getResources().getString(R.string.tp_network_error_message));
                    sb.append(" ");
                    if (networkCustomError != null) {
                        str = networkCustomError.getUrl();
                    }
                    sb.append(str);
                    b.b(getContext(), getResources().getString(R.string.tp_network_error_heading), sb.toString());
                } else if (iJRPaytmDataModel != null) {
                    handleSuccessErrorState(iJRPaytmDataModel);
                } else {
                    String string3 = getResources().getString(R.string.tp_network_error_message);
                    k.a((Object) string3, "resources.getString(R.st…tp_network_error_message)");
                    b.b(getContext(), getResources().getString(R.string.tp_network_error_heading), string3);
                }
            } else {
                b.b(getContext(), networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
            }
        }
    }

    public static /* synthetic */ o processErrorState$default(g gVar, Integer num, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                num = -1;
            }
            if ((i2 & 2) != 0) {
                iJRPaytmDataModel = null;
            }
            if ((i2 & 4) != 0) {
                networkCustomError = null;
            }
            return gVar.processErrorState(num, iJRPaytmDataModel, networkCustomError);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processErrorState");
    }

    public final o<String, String> processErrorState(Integer num, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        String str2;
        String str3;
        String str4;
        String alertMessage;
        String str5;
        net.one97.travelpass.model.a aVar = new net.one97.travelpass.model.a();
        String str6 = null;
        if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    byte[] bArr = networkResponse.data;
                    k.a((Object) bArr, "response.data");
                    Object a2 = new f().a(new String(bArr, d.f47971a), aVar.getClass());
                    k.a((Object) a2, "Gson().fromJson(jsonStri…cjrErrorFormat.javaClass)");
                    aVar = (net.one97.travelpass.model.a) a2;
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        String str7 = "";
        if ((num != null && num.intValue() == 401) || ((num != null && num.intValue() == 410) || (num != null && num.intValue() == 403))) {
            showSessionTimeoutAlert(networkCustomError);
            str = str7;
        } else {
            boolean z = false;
            if ((num != null && num.intValue() == 449) || ((num != null && num.intValue() == 499) || ((num != null && num.intValue() == 502) || ((num != null && num.intValue() == 503) || (num != null && num.intValue() == 504))))) {
                CharSequence alertTitle = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
                if (!(alertTitle == null || alertTitle.length() == 0)) {
                    str4 = networkCustomError != null ? networkCustomError.getAlertTitle() : null;
                    if (str4 == null) {
                        k.a();
                    }
                } else {
                    str4 = str7;
                }
                if (networkCustomError != null) {
                    str3 = networkCustomError.getAlertMessage();
                } else {
                    str3 = null;
                }
                CharSequence charSequence = str3;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (!z) {
                    if (networkCustomError != null) {
                        str6 = networkCustomError.getAlertMessage();
                    }
                    if (str6 == null) {
                        k.a();
                    }
                    str7 = str6;
                }
            } else {
                if (aVar.getStatus() != null) {
                    CJRErrorStatus status = aVar.getStatus();
                    k.a((Object) status, "cjrErrorFormat.status");
                    if (status.getMessage() != null) {
                        CJRErrorStatus status2 = aVar.getStatus();
                        k.a((Object) status2, "cjrErrorFormat.status");
                        CJRMessageFormat message = status2.getMessage();
                        k.a((Object) message, "cjrErrorFormat.status.message");
                        if (!TextUtils.isEmpty(message.getTitle())) {
                            CJRErrorStatus status3 = aVar.getStatus();
                            k.a((Object) status3, "cjrErrorFormat.status");
                            CJRMessageFormat message2 = status3.getMessage();
                            k.a((Object) message2, "cjrErrorFormat.status.message");
                            if (!TextUtils.isEmpty(message2.getMessage())) {
                                CJRErrorStatus status4 = aVar.getStatus();
                                k.a((Object) status4, "cjrErrorFormat.status");
                                CJRMessageFormat message3 = status4.getMessage();
                                k.a((Object) message3, "cjrErrorFormat.status.message");
                                CharSequence title = message3.getTitle();
                                if (!(title == null || title.length() == 0)) {
                                    CJRErrorStatus status5 = aVar.getStatus();
                                    k.a((Object) status5, "cjrErrorFormat.status");
                                    CJRMessageFormat message4 = status5.getMessage();
                                    k.a((Object) message4, "cjrErrorFormat.status.message");
                                    str2 = message4.getTitle();
                                    k.a((Object) str2, "cjrErrorFormat.status.message.title");
                                } else {
                                    str2 = str7;
                                }
                                CJRErrorStatus status6 = aVar.getStatus();
                                k.a((Object) status6, "cjrErrorFormat.status");
                                CJRMessageFormat message5 = status6.getMessage();
                                k.a((Object) message5, "cjrErrorFormat.status.message");
                                CharSequence message6 = message5.getMessage();
                                if (message6 == null || message6.length() == 0) {
                                    z = true;
                                }
                                if (!z) {
                                    CJRErrorStatus status7 = aVar.getStatus();
                                    k.a((Object) status7, "cjrErrorFormat.status");
                                    CJRMessageFormat message7 = status7.getMessage();
                                    k.a((Object) message7, "cjrErrorFormat.status.message");
                                    alertMessage = message7.getMessage();
                                    k.a((Object) alertMessage, "cjrErrorFormat.status.message.message");
                                    str7 = alertMessage;
                                }
                            }
                        }
                    }
                }
                if ((networkCustomError != null ? networkCustomError.getAlertTitle() : null) == null || networkCustomError.getAlertMessage() == null) {
                    if (!TextUtils.isEmpty(networkCustomError != null ? networkCustomError.getMessage() : null)) {
                        if ((networkCustomError != null ? networkCustomError.getErrorType() : null) == NetworkCustomError.ErrorType.ParsingError) {
                            str7 = getResources().getString(R.string.tp_error);
                            k.a((Object) str7, "resources.getString(R.string.tp_error)");
                            str = getResources().getString(R.string.msg_invalid_url_train);
                            k.a((Object) str, "resources.getString(R.st…ng.msg_invalid_url_train)");
                        } else {
                            str7 = getResources().getString(R.string.tp_network_error_heading);
                            k.a((Object) str7, "resources.getString(R.st…tp_network_error_heading)");
                            StringBuilder sb = new StringBuilder();
                            sb.append(getResources().getString(R.string.tp_network_error_message));
                            sb.append(" ");
                            if (networkCustomError != null) {
                                str6 = networkCustomError.getUrl();
                            }
                            sb.append(str6);
                            str = sb.toString();
                        }
                    } else if (iJRPaytmDataModel != null) {
                        o<String, String> processSuccessErrorState = processSuccessErrorState(iJRPaytmDataModel);
                        str7 = processSuccessErrorState.getFirst();
                        str = processSuccessErrorState.getSecond();
                    } else {
                        str7 = getResources().getString(R.string.tp_network_error_heading);
                        k.a((Object) str7, "resources.getString(R.st…tp_network_error_heading)");
                        str = getResources().getString(R.string.tp_network_error_message);
                        k.a((Object) str, "resources.getString(R.st…tp_network_error_message)");
                    }
                } else {
                    CharSequence alertTitle2 = networkCustomError.getAlertTitle();
                    if (!(alertTitle2 == null || alertTitle2.length() == 0)) {
                        str5 = networkCustomError.getAlertTitle();
                        k.a((Object) str5, "networkCustomError.alertTitle");
                    } else {
                        str5 = str7;
                    }
                    CharSequence alertMessage2 = networkCustomError.getAlertMessage();
                    if (alertMessage2 == null || alertMessage2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        alertMessage = networkCustomError.getAlertMessage();
                        k.a((Object) alertMessage, "networkCustomError.alertMessage");
                        str7 = alertMessage;
                    }
                }
            }
            String str8 = str7;
            str7 = str2;
            str = str8;
        }
        return new o<>(str7, str);
    }

    private final o<String, String> processSuccessErrorState(IJRPaytmDataModel iJRPaytmDataModel) {
        String message;
        boolean z = false;
        String str = "";
        if (iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof TravelPass) {
                TravelPass travelPass = (TravelPass) iJRPaytmDataModel;
                TravelPassData body = travelPass.getBody();
                CharSequence error = body != null ? body.getError() : null;
                if (!(error == null || error.length() == 0)) {
                    TravelPassData body2 = travelPass.getBody();
                    if (body2 != null) {
                        message = body2.getError();
                    }
                    str = null;
                } else {
                    TravelPassData body3 = travelPass.getBody();
                    CharSequence message2 = body3 != null ? body3.getMessage() : null;
                    if (!(message2 == null || message2.length() == 0)) {
                        TravelPassData body4 = travelPass.getBody();
                        if (body4 != null) {
                            message = body4.getMessage();
                        }
                        str = null;
                    } else {
                        CharSequence message3 = travelPass.getMessage();
                        if (!(message3 == null || message3.length() == 0)) {
                            str = travelPass.getMessage();
                        }
                    }
                }
            } else if (iJRPaytmDataModel instanceof MyPassesResponse) {
                MyPassesResponse myPassesResponse = (MyPassesResponse) iJRPaytmDataModel;
                MyPasses body5 = myPassesResponse.getBody();
                CharSequence error2 = body5 != null ? body5.getError() : null;
                if (!(error2 == null || error2.length() == 0)) {
                    MyPasses body6 = myPassesResponse.getBody();
                    if (body6 != null) {
                        message = body6.getError();
                    }
                    str = null;
                } else {
                    MyPasses body7 = myPassesResponse.getBody();
                    CharSequence message4 = body7 != null ? body7.getMessage() : null;
                    if (!(message4 == null || message4.length() == 0)) {
                        MyPasses body8 = myPassesResponse.getBody();
                        if (body8 != null) {
                            message = body8.getMessage();
                        }
                        str = null;
                    } else {
                        CharSequence message5 = myPassesResponse.getMessage();
                        if (!(message5 == null || message5.length() == 0)) {
                            str = myPassesResponse.getMessage();
                        }
                    }
                }
            } else if (iJRPaytmDataModel instanceof OrderSummary) {
                OrderSummary orderSummary = (OrderSummary) iJRPaytmDataModel;
                OrderSummaryBody body9 = orderSummary.getBody();
                CharSequence error3 = body9 != null ? body9.getError() : null;
                if (!(error3 == null || error3.length() == 0)) {
                    OrderSummaryBody body10 = orderSummary.getBody();
                    if (body10 != null) {
                        message = body10.getError();
                    }
                    str = null;
                } else {
                    OrderSummaryBody body11 = orderSummary.getBody();
                    CharSequence message6 = body11 != null ? body11.getMessage() : null;
                    if (!(message6 == null || message6.length() == 0)) {
                        OrderSummaryBody body12 = orderSummary.getBody();
                        if (body12 != null) {
                            message = body12.getMessage();
                        }
                        str = null;
                    } else {
                        CharSequence message7 = orderSummary.getMessage();
                        if (!(message7 == null || message7.length() == 0)) {
                            str = orderSummary.getMessage();
                        }
                    }
                }
            } else if (iJRPaytmDataModel instanceof BookingDetailsResponse) {
                BookingDetailsResponse bookingDetailsResponse = (BookingDetailsResponse) iJRPaytmDataModel;
                BookingDetailsResponse.BookingDetails body13 = bookingDetailsResponse.getBody();
                CharSequence error4 = body13 != null ? body13.getError() : null;
                if (!(error4 == null || error4.length() == 0)) {
                    BookingDetailsResponse.BookingDetails body14 = bookingDetailsResponse.getBody();
                    if (body14 != null) {
                        message = body14.getError();
                    }
                    str = null;
                } else {
                    BookingDetailsResponse.BookingDetails body15 = bookingDetailsResponse.getBody();
                    CharSequence message8 = body15 != null ? body15.getMessage() : null;
                    if (!(message8 == null || message8.length() == 0)) {
                        BookingDetailsResponse.BookingDetails body16 = bookingDetailsResponse.getBody();
                        if (body16 != null) {
                            message = body16.getMessage();
                        }
                        str = null;
                    } else {
                        CharSequence message9 = bookingDetailsResponse.getMessage();
                        if (!(message9 == null || message9.length() == 0)) {
                            str = bookingDetailsResponse.getMessage();
                        }
                    }
                }
            } else if (iJRPaytmDataModel instanceof TPAboutResponse) {
                TPAboutResponse tPAboutResponse = (TPAboutResponse) iJRPaytmDataModel;
                TPAboutResponse.TPResponseBody tpAboutData = tPAboutResponse.getTpAboutData();
                CharSequence error5 = tpAboutData != null ? tpAboutData.getError() : null;
                if (!(error5 == null || error5.length() == 0)) {
                    TPAboutResponse.TPResponseBody tpAboutData2 = tPAboutResponse.getTpAboutData();
                    if (tpAboutData2 != null) {
                        message = tpAboutData2.getError();
                    }
                    str = null;
                } else {
                    TPAboutResponse.TPResponseBody tpAboutData3 = tPAboutResponse.getTpAboutData();
                    CharSequence message10 = tpAboutData3 != null ? tpAboutData3.getMessage() : null;
                    if (!(message10 == null || message10.length() == 0)) {
                        TPAboutResponse.TPResponseBody tpAboutData4 = tPAboutResponse.getTpAboutData();
                        if (tpAboutData4 != null) {
                            message = tpAboutData4.getMessage();
                        }
                        str = null;
                    } else {
                        CharSequence message11 = tPAboutResponse.getMessage();
                        if (!(message11 == null || message11.length() == 0)) {
                            str = tPAboutResponse.getMessage();
                        }
                    }
                }
            }
            str = message;
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            str = getResources().getString(R.string.msg_invalid_url_train);
        }
        String string = getResources().getString(R.string.travel_pass_error);
        if (str == null) {
            k.a();
        }
        return new o<>(string, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:160:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleSuccessErrorState(com.paytm.network.model.IJRPaytmDataModel r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x01e3
            boolean r0 = r6 instanceof net.one97.travelpass.model.TravelPass
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0077
            net.one97.travelpass.model.TravelPass r6 = (net.one97.travelpass.model.TravelPass) r6
            net.one97.travelpass.model.TravelPassData r0 = r6.getBody()
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getError()
            goto L_0x0019
        L_0x0018:
            r0 = r3
        L_0x0019:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0026
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r0 = 0
            goto L_0x0027
        L_0x0026:
            r0 = 1
        L_0x0027:
            if (r0 != 0) goto L_0x0036
            net.one97.travelpass.model.TravelPassData r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getError()
        L_0x0033:
            r4 = r3
            goto L_0x01c4
        L_0x0036:
            net.one97.travelpass.model.TravelPassData r0 = r6.getBody()
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r0.getMessage()
            goto L_0x0042
        L_0x0041:
            r0 = r3
        L_0x0042:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x004f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r0 = 0
            goto L_0x0050
        L_0x004f:
            r0 = 1
        L_0x0050:
            if (r0 != 0) goto L_0x005d
            net.one97.travelpass.model.TravelPassData r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getMessage()
            goto L_0x0033
        L_0x005d:
            java.lang.String r0 = r6.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x006e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r0 = 0
            goto L_0x006f
        L_0x006e:
            r0 = 1
        L_0x006f:
            if (r0 != 0) goto L_0x01c4
            java.lang.String r4 = r6.getMessage()
            goto L_0x01c4
        L_0x0077:
            boolean r0 = r6 instanceof net.one97.travelpass.model.MyPassesResponse
            if (r0 == 0) goto L_0x00e6
            net.one97.travelpass.model.MyPassesResponse r6 = (net.one97.travelpass.model.MyPassesResponse) r6
            net.one97.travelpass.model.MyPasses r0 = r6.getBody()
            if (r0 == 0) goto L_0x0088
            java.lang.String r0 = r0.getError()
            goto L_0x0089
        L_0x0088:
            r0 = r3
        L_0x0089:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0096
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0094
            goto L_0x0096
        L_0x0094:
            r0 = 0
            goto L_0x0097
        L_0x0096:
            r0 = 1
        L_0x0097:
            if (r0 != 0) goto L_0x00a4
            net.one97.travelpass.model.MyPasses r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getError()
            goto L_0x0033
        L_0x00a4:
            net.one97.travelpass.model.MyPasses r0 = r6.getBody()
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = r0.getMessage()
            goto L_0x00b0
        L_0x00af:
            r0 = r3
        L_0x00b0:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00bd
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00bb
            goto L_0x00bd
        L_0x00bb:
            r0 = 0
            goto L_0x00be
        L_0x00bd:
            r0 = 1
        L_0x00be:
            if (r0 != 0) goto L_0x00cc
            net.one97.travelpass.model.MyPasses r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getMessage()
            goto L_0x0033
        L_0x00cc:
            java.lang.String r0 = r6.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00dd
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00db
            goto L_0x00dd
        L_0x00db:
            r0 = 0
            goto L_0x00de
        L_0x00dd:
            r0 = 1
        L_0x00de:
            if (r0 != 0) goto L_0x01c4
            java.lang.String r4 = r6.getMessage()
            goto L_0x01c4
        L_0x00e6:
            boolean r0 = r6 instanceof net.one97.travelpass.ordersummary.model.OrderSummary
            if (r0 == 0) goto L_0x0156
            net.one97.travelpass.ordersummary.model.OrderSummary r6 = (net.one97.travelpass.ordersummary.model.OrderSummary) r6
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r0 = r6.getBody()
            if (r0 == 0) goto L_0x00f7
            java.lang.String r0 = r0.getError()
            goto L_0x00f8
        L_0x00f7:
            r0 = r3
        L_0x00f8:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0105
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0103
            goto L_0x0105
        L_0x0103:
            r0 = 0
            goto L_0x0106
        L_0x0105:
            r0 = 1
        L_0x0106:
            if (r0 != 0) goto L_0x0114
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getError()
            goto L_0x0033
        L_0x0114:
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r0 = r6.getBody()
            if (r0 == 0) goto L_0x011f
            java.lang.String r0 = r0.getMessage()
            goto L_0x0120
        L_0x011f:
            r0 = r3
        L_0x0120:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x012d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x012b
            goto L_0x012d
        L_0x012b:
            r0 = 0
            goto L_0x012e
        L_0x012d:
            r0 = 1
        L_0x012e:
            if (r0 != 0) goto L_0x013c
            net.one97.travelpass.ordersummary.model.OrderSummaryBody r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getMessage()
            goto L_0x0033
        L_0x013c:
            java.lang.String r0 = r6.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x014d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r0 = 0
            goto L_0x014e
        L_0x014d:
            r0 = 1
        L_0x014e:
            if (r0 != 0) goto L_0x01c4
            java.lang.String r4 = r6.getMessage()
            goto L_0x01c4
        L_0x0156:
            boolean r0 = r6 instanceof net.one97.travelpass.model.BookingDetailsResponse
            if (r0 == 0) goto L_0x01c4
            net.one97.travelpass.model.BookingDetailsResponse r6 = (net.one97.travelpass.model.BookingDetailsResponse) r6
            net.one97.travelpass.model.BookingDetailsResponse$BookingDetails r0 = r6.getBody()
            if (r0 == 0) goto L_0x0167
            java.lang.String r0 = r0.getError()
            goto L_0x0168
        L_0x0167:
            r0 = r3
        L_0x0168:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0175
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0173
            goto L_0x0175
        L_0x0173:
            r0 = 0
            goto L_0x0176
        L_0x0175:
            r0 = 1
        L_0x0176:
            if (r0 != 0) goto L_0x0184
            net.one97.travelpass.model.BookingDetailsResponse$BookingDetails r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getError()
            goto L_0x0033
        L_0x0184:
            net.one97.travelpass.model.BookingDetailsResponse$BookingDetails r0 = r6.getBody()
            if (r0 == 0) goto L_0x018f
            java.lang.String r0 = r0.getMessage()
            goto L_0x0190
        L_0x018f:
            r0 = r3
        L_0x0190:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x019d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x019b
            goto L_0x019d
        L_0x019b:
            r0 = 0
            goto L_0x019e
        L_0x019d:
            r0 = 1
        L_0x019e:
            if (r0 != 0) goto L_0x01ac
            net.one97.travelpass.model.BookingDetailsResponse$BookingDetails r6 = r6.getBody()
            if (r6 == 0) goto L_0x0033
            java.lang.String r3 = r6.getMessage()
            goto L_0x0033
        L_0x01ac:
            java.lang.String r0 = r6.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x01bd
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r0 = 0
            goto L_0x01be
        L_0x01bd:
            r0 = 1
        L_0x01be:
            if (r0 != 0) goto L_0x01c4
            java.lang.String r4 = r6.getMessage()
        L_0x01c4:
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x01cf
            int r6 = r6.length()
            if (r6 != 0) goto L_0x01d0
        L_0x01cf:
            r1 = 1
        L_0x01d0:
            if (r1 != 0) goto L_0x01e3
            android.content.Context r6 = r5.getContext()
            android.content.res.Resources r0 = r5.getResources()
            int r1 = net.one97.travelpass.R.string.travel_pass_error
            java.lang.String r0 = r0.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r6, (java.lang.String) r0, (java.lang.String) r4)
        L_0x01e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.g.handleSuccessErrorState(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    private final void showSessionTimeoutAlert(NetworkCustomError networkCustomError) {
        if (getActivity() != null && !isDetached()) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "this.activity!!");
            if (!activity.isFinishing()) {
                k.a((Object) net.one97.travelpass.d.a(), "TravelPassController.getInstance()");
                net.one97.travelpass.d.b().a((Activity) getActivity(), (Exception) networkCustomError);
            }
        }
    }
}
