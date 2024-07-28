package com.business.merchant_payments.deeplinkUtil;

import android.app.Activity;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.paytm.android.chat.utils.KeyList;
import easypay.manager.Constants;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.m.p;

public final class DeepLinkHelper {
    public static final DeepLinkHelper INSTANCE = new DeepLinkHelper();
    public static final String PAYTM_BASE_URL = "paytmmp://accept_money?featuretype=";

    public final String getPAYTM_BASE_URL() {
        return PAYTM_BASE_URL;
    }

    public final int parseAndGetTargetScreen(String str) {
        k.d(str, "url");
        return parseAndGetTargetScreen(str, (Activity) null);
    }

    public final int parseAndGetTargetScreen(String str, Activity activity) {
        k.d(str, "url");
        if (TextUtils.isEmpty(str)) {
            return 116;
        }
        if (p.a((CharSequence) str, (CharSequence) DeepLinkConstant.PAYMENTS_YESTERDAY, false) || p.a((CharSequence) str, (CharSequence) DeepLinkConstant.PAYMENTS_CUSTOM_RANGE, false)) {
            return 100;
        }
        if (!p.a((CharSequence) str, (CharSequence) DeepLinkConstant.PAYMENTS_TODAY, false)) {
            if (isPatternFound(DeepLinkConstant.PAYMENTS, str)) {
                GAGTMTagAnalytics.getSingleInstance().pushScreenEvent(AppUtility.buildScreenName("Payments", "Date Filter", "Today"));
            } else if (isPatternFound(DeepLinkConstant.BUSINESS_WALLET_PASSBOOK, str)) {
                return 103;
            } else {
                if (isPatternFound(DeepLinkConstant.MANAGE_QR, str)) {
                    return 888;
                }
                if (isPatternFound(DeepLinkConstant.TRAINING_VIDEO, str)) {
                    return 800;
                }
                if (isPatternFound(DeepLinkConstant.GENERATE_REPORTS, str)) {
                    return 808;
                }
                if (isPatternFound(DeepLinkConstant.PAYMENTS_TWO_WEEKS, str)) {
                    return 880;
                }
                if (isPatternFound(DeepLinkConstant.BANK_TRANSFERS, str)) {
                    return 101;
                }
                if (isPatternFound(DeepLinkConstant.SHOW_MERCHANT_QR, str)) {
                    return 105;
                }
                if (isPatternFound(DeepLinkConstant.DOWNLOAD_MERCHANT_QR, str)) {
                    return 132;
                }
                if (isPatternFound(DeepLinkConstant.REQUEST_MONEY, str)) {
                    return 106;
                }
                if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENTS_NOTIFICATION, str)) {
                    return 407;
                }
                if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENTS, str)) {
                    return 104;
                }
                if (isPatternFound(DeepLinkConstant.EDIT_BANK_DETAILS, str)) {
                    return 117;
                }
                if (isPatternFound(DeepLinkConstant.EDIT_NOTIFICATION_DETAILS, str)) {
                    return 118;
                }
                if (isPatternFound(DeepLinkConstant.MONTHLY_LIMIT, str)) {
                    return 123;
                }
                if (isPatternFound(DeepLinkConstant.TRANSACTION_CHARGES, str)) {
                    return 124;
                }
                if (isPatternFound(DeepLinkConstant.UPGRADE_LIMITS, str)) {
                    return 125;
                }
                if (isPatternFound(DeepLinkConstant.CHANGE_BANK, str)) {
                    return 126;
                }
                if (isPatternFound(DeepLinkConstant.PAYMENT_SETTLEMENT_SETTING, str)) {
                    return H5ErrorCode.HTTP_CONFLICT;
                }
                if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENT_SETTINGS_NOTIFICATION, str)) {
                    return 408;
                }
                if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENT_SETTINGS, str)) {
                    return 114;
                }
                if (isPatternFound(DeepLinkConstant.RESELLER, str)) {
                    return 133;
                }
                if (isPatternFound(DeepLinkConstant.OPEN_REPORTS_SCREEN, str)) {
                    return 128;
                }
                if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE_EDIT_NAME, str)) {
                    return 129;
                }
                if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE_EDIT_GSTIN, str)) {
                    return 130;
                }
                if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE_EDIT_ADDRESS, str)) {
                    return 131;
                }
                if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE, str)) {
                    return 108;
                }
                if (isPatternFound(DeepLinkConstant.HELP, str)) {
                    return 115;
                }
                if (isPatternFound(DeepLinkConstant.LANGUAGE, str)) {
                    return 122;
                }
                if (isPatternFound(DeepLinkConstant.GST_INVOICES, str)) {
                    return 112;
                }
                if (isPatternFound(DeepLinkConstant.STATEMENTS, str)) {
                    return 111;
                }
                if (isPatternFound(DeepLinkConstant.ORDER_QR, str)) {
                    return 119;
                }
                if (isPatternFound(DeepLinkConstant.LINK_NEW_QR, str)) {
                    return 120;
                }
                if (isPatternFound(DeepLinkConstant.CREATE_NEW_QR, str)) {
                    return 127;
                }
                if (isPatternFound(DeepLinkConstant.ACCOUNT, str)) {
                    return 107;
                }
                if (isPatternFound(DeepLinkConstant.WHOLESALE, str)) {
                    return 109;
                }
                if (isPatternFound(DeepLinkConstant.WS_ORDERS, str)) {
                    return 110;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_LOAN, str)) {
                    return 200;
                }
                if (isPatternFound(DeepLinkConstant.WEB_VIEW, str)) {
                    return 113;
                }
                if (isPatternFound(DeepLinkConstant.MY_STORE, str)) {
                    return 121;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_COMMISSION_LIST, str)) {
                    return 401;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_COMMISSION_DETAIL, str)) {
                    return KeyList.IntentRequestKey.INTENT_USER_CENTER_RESULT_ACTION_CLEAR;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LEAD_CREATE_FIRST, str)) {
                    return 403;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LEAD_CREATE_SECOND, str)) {
                    return H5ErrorCode.HTTP_NOT_FOUND;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LEAD_DETAIL, str)) {
                    return 405;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_PITCH, str)) {
                    return 406;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LANDING, str)) {
                    return 400;
                }
                if (isPatternFound(DeepLinkConstant.MERCHANT_GV, str)) {
                    return H5ErrorCode.HTTP_BAD_GATEWAY;
                }
                if (isPatternFound(DeepLinkConstant.KHATA_BOOK, str)) {
                    return H5ErrorCode.HTTP_SERVICE_UNAVAILABLE;
                }
                if (isPatternFound(DeepLinkConstant.INSURANCE_POS, str)) {
                    return H5PullContainer.DEFALUT_DURATION;
                }
                if (isPatternFound(DeepLinkConstant.DEEPLINK_EDC_LEAD, str)) {
                    return 601;
                }
                if (isPatternFound(DeepLinkConstant.PATTERN_PAYTM_MONEY, str)) {
                    return 134;
                }
                if (isPatternFound(DeepLinkConstant.BUY_INSURANCE, str)) {
                    return 135;
                }
                if (isPatternFound(DeepLinkConstant.UMP_PAGES_EXT, str)) {
                    return 1000;
                }
                if (isPatternFound(DeepLinkConstant.VERIFY_QR, str)) {
                    return 136;
                }
                if (isPatternFound(DeepLinkConstant.P4B_REACT, str)) {
                    return 1001;
                }
                if (isPatternFound(DeepLinkConstant.LOAN_DOCUMENT_SCREEN, str)) {
                    return 1002;
                }
                if (isPatternFound(DeepLinkConstant.ATTENDANCE, str)) {
                    return 137;
                }
                if (!isPatternFound(DeepLinkConstant.CREDIT_SCORE, str)) {
                    if (!isPatternFound(DeepLinkConstant.CIR_CONTACT_US, str)) {
                        if (isPatternFound(DeepLinkConstant.REDEEM_LOYALTY_POINTS, str)) {
                            return 139;
                        }
                        if (p.a((CharSequence) str, (CharSequence) DeepLinkConstant.CHANNELS_DEEPLINK, false)) {
                            return KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE;
                        }
                        if (!isPatternFound(DeepLinkConstant.CREDIT_SCORE, str)) {
                            if (!isPatternFound(DeepLinkConstant.CIR_CONTACT_US, str)) {
                                if (isPatternFound(DeepLinkConstant.BILL_PAYMENTS, str)) {
                                    return 305;
                                }
                                if (isPatternFound(DeepLinkConstant.ALL_ORDERS, str)) {
                                    return 310;
                                }
                                if (isPatternFound(DeepLinkConstant.PPBL, str)) {
                                    return 141;
                                }
                                if (isPatternFound(DeepLinkConstant.UPI, str)) {
                                    return 142;
                                }
                                if (isPatternFound(DeepLinkConstant.SELLER_IN_STORE_ORDERS, str)) {
                                    return 148;
                                }
                                if (isPatternFound(DeepLinkConstant.COACHMARKS_JOURNEY, str)) {
                                    return H5Param.WEBVIEW_FONT_SIZE_LARGER;
                                }
                                if (isPatternFound(DeepLinkConstant.COACHMARKS_MENU, str)) {
                                    return Constants.ACTION_PASSWORD_VIEWER;
                                }
                                return 116;
                            }
                        }
                    }
                    return 140;
                }
                return 138;
            }
        }
        return 144;
    }

    private final boolean isPatternFound(String str, String str2) {
        return Pattern.compile(str, 2).matcher(str2).find();
    }

    public final String getCADeepkink(String str, String str2) {
        k.d(str, "feature");
        k.d(str2, "deeplink");
        switch (str.hashCode()) {
            case -2059574344:
                if (!str.equals(DeepLinkConstant.SHARE_QR)) {
                    return null;
                }
                return PAYTM_BASE_URL + "download_qr&share=true";
            case -2052902916:
                if (!str.equals(DeepLinkConstant.ACCEPT_PAYMENT_SETTINGS)) {
                    return null;
                }
                return PAYTM_BASE_URL + DeepLinkConstant.FEATURES.MERCHANT_SETTING;
            case -1493345099:
                if (str.equals(DeepLinkConstant.DOWNLOAD_MERCHANT_QR)) {
                    return PAYTM_BASE_URL + DeepLinkConstant.FEATURES.DOWNLOAD_QR;
                } else if (!str.equals(DeepLinkConstant.DOWNLOAD_MERCHANT_QR)) {
                    return null;
                } else {
                    return PAYTM_BASE_URL + DeepLinkConstant.FEATURES.DOWNLOAD_QR;
                }
            case -1374434588:
                if (!str.equals(DeepLinkConstant.VERIFY_QR)) {
                    return null;
                }
                return PAYTM_BASE_URL + "verify_qr";
            case -1321646824:
                if (!str.equals(DeepLinkConstant.LINK_NEW_QR)) {
                    return null;
                }
                return PAYTM_BASE_URL + DeepLinkConstant.FEATURES.LINK_QR;
            case -783216206:
                if (!str.equals(DeepLinkConstant.WEB_VIEW)) {
                    return null;
                }
                return "paytmmp://embed?url=" + geURLFronP4bDeeplink(str2);
            case -262190223:
                if (!str.equals(DeepLinkConstant.REQUEST_MONEY)) {
                    return null;
                }
                return PAYTM_BASE_URL + DeepLinkConstant.FEATURES.PAYMENT_LINK;
            case -81509911:
                if (!str.equals(DeepLinkConstant.ORDER_QR)) {
                    return null;
                }
                return PAYTM_BASE_URL + DeepLinkConstant.FEATURES.ORDER_QR;
            case 36647329:
                if (str.equals(DeepLinkConstant.HELP)) {
                    return "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=25";
                }
                return null;
            case 393152834:
                if (str.equals(DeepLinkConstant.HOME)) {
                    return "paytmmp://accept_money";
                }
                return null;
            case 512351928:
                if (!str.equals(DeepLinkConstant.PAYMENT_SETTLEMENT_SETTING)) {
                    return null;
                }
                return PAYTM_BASE_URL + DeepLinkConstant.FEATURES.SETTLEMENT;
            case 894146353:
                if (str.equals(DeepLinkConstant.FEATURES.MERCHANT_CASHBACK)) {
                    return "paytmmp://cash_wallet?featuretype=vip&screen=homescreenMerchant";
                }
                return null;
            case 1385255448:
                if (!str.equals(DeepLinkConstant.UMP_PAGES_EXT)) {
                    return null;
                }
                return PAYTM_BASE_URL + "ump-web&url=" + geURLFronP4bDeeplink(str2);
            default:
                return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r4 = kotlin.m.p.a(r4, "channel=p4b", "channel=consumer_app", false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String geURLFronP4bDeeplink(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "?url="
            java.lang.String[] r0 = new java.lang.String[]{r0}
            java.util.List r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.String[]) r0)
            r0 = 1
            java.lang.Object r4 = kotlin.a.k.a(r4, (int) r0)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x001e
            r0 = 0
            java.lang.String r1 = "channel=p4b"
            java.lang.String r2 = "channel=consumer_app"
            java.lang.String r4 = kotlin.m.p.a(r4, r1, r2, r0)
            if (r4 != 0) goto L_0x0020
        L_0x001e:
            java.lang.String r4 = ""
        L_0x0020:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.deeplinkUtil.DeepLinkHelper.geURLFronP4bDeeplink(java.lang.String):java.lang.String");
    }

    public final String getFeatureFromDeeplink(String str) {
        String str2 = str;
        k.d(str2, "url");
        boolean a2 = p.a((CharSequence) str2, (CharSequence) DeepLinkConstant.HOME, false);
        String str3 = DeepLinkConstant.HOME;
        String str4 = DeepLinkConstant.GENERATE_REPORTS;
        if (!a2) {
            if (p.a((CharSequence) str2, (CharSequence) DeepLinkConstant.PAYMENTS_YESTERDAY, false)) {
                return DeepLinkConstant.PAYMENTS_YESTERDAY;
            }
            if (p.a((CharSequence) str2, (CharSequence) DeepLinkConstant.PAYMENTS_CUSTOM_RANGE, false)) {
                return DeepLinkConstant.PAYMENTS_CUSTOM_RANGE;
            }
            if (p.a((CharSequence) str2, (CharSequence) DeepLinkConstant.PAYMENTS_TODAY, false)) {
                return DeepLinkConstant.PAYMENTS_TODAY;
            }
            if (isPatternFound(DeepLinkConstant.PAYMENTS, str2)) {
                return DeepLinkConstant.PAYMENTS;
            }
            if (isPatternFound(DeepLinkConstant.BUSINESS_WALLET_PASSBOOK, str2)) {
                return DeepLinkConstant.BUSINESS_WALLET_PASSBOOK;
            }
            if (p.a((CharSequence) str2, (CharSequence) "view_qr", false)) {
                return "view_qr";
            }
            if (isPatternFound(DeepLinkConstant.MANAGE_QR, str2)) {
                return DeepLinkConstant.MANAGE_QR;
            }
            if (isPatternFound(DeepLinkConstant.TRAINING_VIDEO, str2)) {
                return DeepLinkConstant.TRAINING_VIDEO;
            }
            if (!isPatternFound(str4, str2) && !isPatternFound(str4, str2)) {
                if (isPatternFound(DeepLinkConstant.BANK_TRANSFERS, str2)) {
                    return DeepLinkConstant.BANK_TRANSFERS;
                }
                if (isPatternFound(DeepLinkConstant.SHOW_MERCHANT_QR, str2)) {
                    return DeepLinkConstant.SHOW_MERCHANT_QR;
                }
                if (isPatternFound(DeepLinkConstant.DOWNLOAD_MERCHANT_QR, str2)) {
                    str4 = DeepLinkConstant.DOWNLOAD_MERCHANT_QR;
                } else if (isPatternFound(DeepLinkConstant.REQUEST_MONEY, str2)) {
                    str4 = DeepLinkConstant.REQUEST_MONEY;
                } else if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENTS_NOTIFICATION, str2)) {
                    str4 = DeepLinkConstant.ACCEPT_PAYMENTS_NOTIFICATION;
                } else if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENTS, str2)) {
                    str4 = DeepLinkConstant.ACCEPT_PAYMENTS;
                } else if (isPatternFound(DeepLinkConstant.EDIT_BANK_DETAILS, str2)) {
                    str4 = DeepLinkConstant.EDIT_BANK_DETAILS;
                } else if (isPatternFound(DeepLinkConstant.EDIT_NOTIFICATION_DETAILS, str2)) {
                    str4 = DeepLinkConstant.EDIT_NOTIFICATION_DETAILS;
                } else if (isPatternFound(DeepLinkConstant.MONTHLY_LIMIT, str2)) {
                    str4 = DeepLinkConstant.MONTHLY_LIMIT;
                } else if (isPatternFound(DeepLinkConstant.TRANSACTION_CHARGES, str2)) {
                    str4 = DeepLinkConstant.TRANSACTION_CHARGES;
                } else if (isPatternFound(DeepLinkConstant.UPGRADE_LIMITS, str2)) {
                    str4 = DeepLinkConstant.UPGRADE_LIMITS;
                } else if (isPatternFound(DeepLinkConstant.CHANGE_BANK, str2)) {
                    str4 = DeepLinkConstant.CHANGE_BANK;
                } else if (isPatternFound(DeepLinkConstant.PAYMENT_SETTLEMENT_SETTING, str2)) {
                    str4 = DeepLinkConstant.PAYMENT_SETTLEMENT_SETTING;
                } else if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENT_SETTINGS_NOTIFICATION, str2)) {
                    str4 = DeepLinkConstant.ACCEPT_PAYMENT_SETTINGS_NOTIFICATION;
                } else if (isPatternFound(DeepLinkConstant.ACCEPT_PAYMENT_SETTINGS, str2)) {
                    str4 = DeepLinkConstant.ACCEPT_PAYMENT_SETTINGS;
                } else if (isPatternFound(DeepLinkConstant.RESELLER, str2)) {
                    str4 = DeepLinkConstant.RESELLER;
                } else if (isPatternFound(DeepLinkConstant.OPEN_REPORTS_SCREEN, str2)) {
                    str4 = DeepLinkConstant.OPEN_REPORTS_SCREEN;
                } else if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE_EDIT_NAME, str2)) {
                    str4 = DeepLinkConstant.BUSINESS_PROFILE_EDIT_NAME;
                } else if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE_EDIT_GSTIN, str2)) {
                    str4 = DeepLinkConstant.BUSINESS_PROFILE_EDIT_GSTIN;
                } else if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE_EDIT_ADDRESS, str2)) {
                    str4 = DeepLinkConstant.BUSINESS_PROFILE_EDIT_ADDRESS;
                } else if (isPatternFound(DeepLinkConstant.BUSINESS_PROFILE, str2)) {
                    str4 = DeepLinkConstant.BUSINESS_PROFILE;
                } else if (isPatternFound(DeepLinkConstant.HELP, str2)) {
                    str4 = DeepLinkConstant.HELP;
                } else if (isPatternFound(DeepLinkConstant.LANGUAGE, str2)) {
                    str4 = DeepLinkConstant.LANGUAGE;
                } else if (isPatternFound(DeepLinkConstant.GST_INVOICES, str2)) {
                    str4 = DeepLinkConstant.GST_INVOICES;
                } else if (isPatternFound(DeepLinkConstant.STATEMENTS, str2)) {
                    str4 = DeepLinkConstant.STATEMENTS;
                } else if (isPatternFound(DeepLinkConstant.ORDER_QR, str2)) {
                    str4 = DeepLinkConstant.ORDER_QR;
                } else if (isPatternFound(DeepLinkConstant.LINK_NEW_QR, str2)) {
                    str4 = DeepLinkConstant.LINK_NEW_QR;
                } else if (isPatternFound(DeepLinkConstant.CREATE_NEW_QR, str2)) {
                    str4 = DeepLinkConstant.CREATE_NEW_QR;
                } else if (isPatternFound(DeepLinkConstant.SHARE_QR, str2)) {
                    str4 = DeepLinkConstant.SHARE_QR;
                } else if (isPatternFound(DeepLinkConstant.ACCOUNT, str2)) {
                    str4 = DeepLinkConstant.ACCOUNT;
                } else if (isPatternFound(DeepLinkConstant.WHOLESALE, str2)) {
                    str4 = DeepLinkConstant.WHOLESALE;
                } else if (isPatternFound(DeepLinkConstant.WS_ORDERS, str2)) {
                    str4 = DeepLinkConstant.WS_ORDERS;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_LOAN, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_LOAN;
                } else if (isPatternFound(DeepLinkConstant.WEB_VIEW, str2)) {
                    str4 = DeepLinkConstant.WEB_VIEW;
                } else if (isPatternFound(DeepLinkConstant.MY_STORE, str2)) {
                    str4 = DeepLinkConstant.MY_STORE;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_COMMISSION_LIST, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_INSURANCE_COMMISSION_LIST;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_COMMISSION_DETAIL, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_INSURANCE_COMMISSION_DETAIL;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LEAD_CREATE_FIRST, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_INSURANCE_LEAD_CREATE_FIRST;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LEAD_CREATE_SECOND, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_INSURANCE_LEAD_CREATE_SECOND;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LEAD_DETAIL, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_INSURANCE_LEAD_DETAIL;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_PITCH, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_INSURANCE_PITCH;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_INSURANCE_LANDING, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_INSURANCE_LANDING;
                } else if (isPatternFound(DeepLinkConstant.MERCHANT_GV, str2)) {
                    str4 = DeepLinkConstant.MERCHANT_GV;
                } else if (isPatternFound(DeepLinkConstant.KHATA_BOOK, str2)) {
                    str4 = DeepLinkConstant.KHATA_BOOK;
                } else if (isPatternFound(DeepLinkConstant.INSURANCE_POS, str2)) {
                    str4 = DeepLinkConstant.INSURANCE_POS;
                } else if (isPatternFound(DeepLinkConstant.DEEPLINK_EDC_LEAD, str2)) {
                    str4 = DeepLinkConstant.DEEPLINK_EDC_LEAD;
                } else if (isPatternFound(DeepLinkConstant.PATTERN_PAYTM_MONEY, str2)) {
                    str4 = DeepLinkConstant.PATTERN_PAYTM_MONEY;
                } else if (isPatternFound(DeepLinkConstant.BUY_INSURANCE, str2)) {
                    str4 = DeepLinkConstant.BUY_INSURANCE;
                } else if (isPatternFound(DeepLinkConstant.UMP_PAGES_EXT, str2)) {
                    str4 = DeepLinkConstant.UMP_PAGES_EXT;
                } else if (isPatternFound(DeepLinkConstant.VERIFY_QR, str2)) {
                    str4 = DeepLinkConstant.VERIFY_QR;
                } else if (isPatternFound(DeepLinkConstant.P4B_REACT, str2)) {
                    str4 = DeepLinkConstant.P4B_REACT;
                } else if (isPatternFound(DeepLinkConstant.LOAN_DOCUMENT_SCREEN, str2)) {
                    str4 = DeepLinkConstant.LOAN_DOCUMENT_SCREEN;
                } else if (isPatternFound(DeepLinkConstant.ATTENDANCE, str2)) {
                    str4 = DeepLinkConstant.ATTENDANCE;
                } else {
                    if (!isPatternFound(DeepLinkConstant.CREDIT_SCORE, str2)) {
                        if (!isPatternFound(DeepLinkConstant.CIR_CONTACT_US, str2)) {
                            if (isPatternFound(DeepLinkConstant.REDEEM_LOYALTY_POINTS, str2)) {
                                str4 = DeepLinkConstant.REDEEM_LOYALTY_POINTS;
                            } else if (p.a((CharSequence) str2, (CharSequence) DeepLinkConstant.CHANNELS_DEEPLINK, false)) {
                                str4 = DeepLinkConstant.CHANNELS_DEEPLINK;
                            } else if (!isPatternFound(DeepLinkConstant.CREDIT_SCORE, str2)) {
                                if (!isPatternFound(DeepLinkConstant.CIR_CONTACT_US, str2)) {
                                    if (isPatternFound(DeepLinkConstant.BILL_PAYMENTS, str2)) {
                                        str4 = DeepLinkConstant.BILL_PAYMENTS;
                                    } else if (isPatternFound(DeepLinkConstant.ALL_ORDERS, str2)) {
                                        str4 = DeepLinkConstant.ALL_ORDERS;
                                    } else if (isPatternFound(DeepLinkConstant.PPBL, str2)) {
                                        str4 = DeepLinkConstant.PPBL;
                                    } else if (isPatternFound(DeepLinkConstant.UPI, str2)) {
                                        str4 = DeepLinkConstant.UPI;
                                    } else if (isPatternFound(DeepLinkConstant.SELLER_IN_STORE_ORDERS, str2)) {
                                        str4 = DeepLinkConstant.SELLER_IN_STORE_ORDERS;
                                    } else if (isPatternFound(DeepLinkConstant.COACHMARKS_JOURNEY, str2)) {
                                        str4 = DeepLinkConstant.COACHMARKS_JOURNEY;
                                    } else if (isPatternFound(DeepLinkConstant.COACHMARKS_MENU, str2)) {
                                        str4 = DeepLinkConstant.COACHMARKS_MENU;
                                    } else if (!str2.equals("paytmba://business-app")) {
                                        if (!str2.equals("paytmba://cash_wallet?featuretype=vip&screen=homescreenMerchant")) {
                                            return null;
                                        }
                                        str4 = DeepLinkConstant.FEATURES.MERCHANT_CASHBACK;
                                    }
                                }
                            }
                        }
                        return DeepLinkConstant.CIR_CONTACT_US;
                    }
                    return DeepLinkConstant.CREDIT_SCORE;
                }
            }
            return str4;
        }
        return str3;
    }
}
