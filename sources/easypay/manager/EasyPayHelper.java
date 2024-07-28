package easypay.manager;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.gson.f;
import easypay.entity.AssistRequest;
import easypay.listeners.a;
import easypay.utils.AssistLogs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class EasyPayHelper {
    private ArrayList<a> mJsCallListListener = new ArrayList<>();

    EasyPayHelper() {
        if (AssistMerchantDetails.getInstance().getWebView() != null) {
            AssistMerchantDetails.getInstance().getWebView().addJavascriptInterface(this, Constants.TAG);
        }
    }

    public void addJsCallListener(a aVar) {
        ArrayList<a> arrayList = this.mJsCallListListener;
        if (arrayList != null) {
            arrayList.add(aVar);
        }
    }

    @JavascriptInterface
    public void successEvent(int i2, String str) {
        if (!(i2 == 100 || i2 == 101)) {
            if (i2 == 107 || i2 == 112) {
                AssistLogs.printLog("Event received :" + i2 + ". Calling for each subscriber", this);
                Iterator<a> it2 = this.mJsCallListListener.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    AssistLogs.printLog("EasyPayHelper :Web success Ui callback" + next.toString(), this);
                    next.a("", str, i2);
                }
                return;
            } else if (i2 != 225) {
                switch (i2) {
                    case Constants.ACTION_PASSWORD_FOUND:
                    case 155:
                    case Constants.ACTION_DELAY_PASSWORD_FOUND:
                        break;
                    default:
                        return;
                }
            } else {
                AssistLogs.printLog("Event received :".concat(String.valueOf(i2)), this);
                Iterator<a> it3 = this.mJsCallListListener.iterator();
                while (it3.hasNext()) {
                    a next2 = it3.next();
                    AssistLogs.printLog("EasyPayHelper : Generic Callback" + next2.toString(), this);
                    next2.a("", str, i2);
                }
                return;
            }
        }
        Iterator<a> it4 = this.mJsCallListListener.iterator();
        while (it4.hasNext()) {
            it4.next().a(i2);
        }
    }

    @JavascriptInterface
    public void NBWatcher(String str, String str2, int i2) {
        if (str != null && str2 != null) {
            if (i2 == 106) {
                Iterator<a> it2 = this.mJsCallListListener.iterator();
                while (it2.hasNext()) {
                    it2.next().a(i2);
                }
            } else if (i2 != 156) {
                if (i2 != 157) {
                    if (i2 == 223) {
                        AssistLogs.printLog("Assist made visible", this);
                        Iterator<a> it3 = this.mJsCallListListener.iterator();
                        while (it3.hasNext()) {
                            it3.next().a(str2, str, i2);
                        }
                        return;
                    } else if (i2 != 224) {
                        switch (i2) {
                            case Constants.ACTION_PASSWORD_VIEWER:
                            case Constants.ACTION_UID_VIEWER:
                            case Constants.ACTION_REMOVE_NB_LAYOUT:
                                break;
                            default:
                                switch (i2) {
                                    case Constants.ACTION_NB_NEXT_BTN_CLICKED:
                                    case 160:
                                    case Constants.ACTION_NB_WV_LOGIN_CLICKED:
                                        break;
                                    default:
                                        switch (i2) {
                                            case 163:
                                            case 164:
                                                break;
                                            case 165:
                                                AssistLogs.printLog("Bank Bage optimized called", this);
                                                if (AssistMerchantDetails.getInstance().getEventMap() != null) {
                                                    AssistMerchantDetails.getInstance().getEventMap().put("isWebPageOptimized", Boolean.TRUE);
                                                    AssistLogs.printLog("Bank Bage optimized called" + AssistMerchantDetails.getInstance().getEventMap(), this);
                                                    return;
                                                }
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                    } else {
                        AssistLogs.printLog("Assist made invisible", this);
                        Iterator<a> it4 = this.mJsCallListListener.iterator();
                        while (it4.hasNext()) {
                            it4.next().a(str2, str, i2);
                        }
                        return;
                    }
                }
                Iterator<a> it5 = this.mJsCallListListener.iterator();
                while (it5.hasNext()) {
                    it5.next().a(str2, str, i2);
                }
            } else {
                Iterator<a> it6 = this.mJsCallListListener.iterator();
                while (it6.hasNext()) {
                    it6.next().a(i2);
                }
            }
        }
    }

    @JavascriptInterface
    public void OTPWatcher(String str, String str2, int i2) {
        if (i2 != 108) {
            if (i2 == 158) {
                AssistLogs.printLog("Incorrect OTP", this);
                Iterator<a> it2 = this.mJsCallListListener.iterator();
                while (it2.hasNext()) {
                    it2.next().a(str2, str, i2);
                }
                return;
            } else if (i2 != 201) {
                if (i2 != 300) {
                    switch (i2) {
                        case Constants.EASY_PAY_MINIMIZE_ASSIST:
                            AssistLogs.printLog("Assist minimized programmatically", this);
                            Iterator<a> it3 = this.mJsCallListListener.iterator();
                            while (it3.hasNext()) {
                                it3.next().a(str2, str, i2);
                            }
                            return;
                        case Constants.EASY_PAY_MAXIMIZE_ASSIST:
                            AssistLogs.printLog("Assist maximized programmatically", this);
                            Iterator<a> it4 = this.mJsCallListListener.iterator();
                            while (it4.hasNext()) {
                                it4.next().a(str2, str, i2);
                            }
                            return;
                        case Constants.EASY_PAY_VISIBLE_ASSIST:
                            AssistLogs.printLog("Assist made visible", this);
                            Iterator<a> it5 = this.mJsCallListListener.iterator();
                            while (it5.hasNext()) {
                                it5.next().a(str2, str, i2);
                            }
                            return;
                        case Constants.EASY_PAY_INVISIBLE_ASSIST:
                            AssistLogs.printLog("Assist made invisible", this);
                            Iterator<a> it6 = this.mJsCallListListener.iterator();
                            while (it6.hasNext()) {
                                it6.next().a(str2, str, i2);
                            }
                            return;
                        default:
                            return;
                    }
                } else {
                    Iterator<a> it7 = this.mJsCallListListener.iterator();
                    while (it7.hasNext()) {
                        it7.next().a(i2);
                    }
                    return;
                }
            }
        }
        Iterator<a> it8 = this.mJsCallListListener.iterator();
        while (it8.hasNext()) {
            it8.next().a(str2, str, i2);
        }
    }

    @JavascriptInterface
    public void logError(String str) {
        Iterator<a> it2 = this.mJsCallListListener.iterator();
        while (it2.hasNext()) {
            it2.next().a("", str, 110);
        }
        AssistLogs.printLog("Log error from JS: ".concat(String.valueOf(str)), this);
        AssistMerchantDetails.getInstance().getEventMap().put("JSError", str);
        if (!TextUtils.isEmpty(AssistMerchantDetails.getInstance().getCardDetails())) {
            Map<String, Object> eventMap = AssistMerchantDetails.getInstance().getEventMap();
            eventMap.put("JSError", str + "bank Details" + AssistMerchantDetails.getInstance().getCardDetails());
        }
    }

    @JavascriptInterface
    public void sendBnkDtlToApp(String str) {
        AssistLogs.printLog("Json From UI:".concat(String.valueOf(str)), this);
        AssistRequest assistRequest = (AssistRequest) new f().a(str, AssistRequest.class);
        AssistMerchantDetails.getInstance().setBankInfo(assistRequest.getBank(), assistRequest.getPayType(), assistRequest.getCardScheme());
    }
}
