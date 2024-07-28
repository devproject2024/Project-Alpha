package net.one97.paytm.wallet.newdesign.universalp2p.c;

import android.content.Context;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class a {
    private static a n;

    /* renamed from: a  reason: collision with root package name */
    public e f71389a = e.WALLET_PAY;

    /* renamed from: b  reason: collision with root package name */
    public b f71390b = b.WAlLET_SEND_MONEY;

    /* renamed from: c  reason: collision with root package name */
    public C1450a f71391c = C1450a.PROCEED_TO_PAY;

    /* renamed from: d  reason: collision with root package name */
    public c f71392d = c.CONTACT_SELECTED;

    /* renamed from: e  reason: collision with root package name */
    public d f71393e = d.P2P;

    /* renamed from: f  reason: collision with root package name */
    public String f71394f = "no";

    /* renamed from: g  reason: collision with root package name */
    public String f71395g;

    /* renamed from: h  reason: collision with root package name */
    public String f71396h;

    /* renamed from: i  reason: collision with root package name */
    public String f71397i;
    public e j;
    public b k;
    public C1450a l;
    public String m;

    private a() {
    }

    public static a a() {
        if (n == null) {
            synchronized (a.class) {
                n = new a();
            }
        }
        return n;
    }

    private static void b() {
        if (n != null) {
            synchronized (a.class) {
                n = null;
            }
        }
    }

    public final void a(c cVar) {
        this.f71392d = cVar;
    }

    public final void a(String str) {
        this.f71394f = str;
    }

    public enum e {
        WALLET_PAY_SUMMARY("wallet pay summary screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        SEND_MONEY_SUMMARY("send money summary screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        CONATCT_SCREEN("contact screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        WALLET_PAY("wallet pay screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        PAYMENT_SCREEN("payment screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        PAYMENT_SUCCESS_SCREEN("payment success screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        PASSBOOK_SCREEN("passbook screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        UPI_LEAD("upi lead", SDKConstants.EVENT_KEY_SCREEN_NAME),
        SEND_MONEY("send money screen", SDKConstants.EVENT_KEY_SCREEN_NAME),
        NEW_WALLET_PAY_SUMMARY("/wallet-summary", SDKConstants.EVENT_KEY_SCREEN_NAME),
        NEW_WALLET_PAY_CLICK("home/pay-send", SDKConstants.EVENT_KEY_SCREEN_NAME),
        RECENTS("home/pay-send/post-scan", SDKConstants.EVENT_KEY_SCREEN_NAME);
        
        private String key;
        private String screenName;

        private e(String str, String str2) {
            this.screenName = str;
            this.key = str2;
        }

        public final String getScreenName() {
            return this.screenName;
        }

        public final void setScreenName(String str) {
            this.screenName = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.universalp2p.c.a$a  reason: collision with other inner class name */
    public enum C1450a {
        SUCCESSFUL_TRANS("success_screen_loaded", "event_action"),
        SCAN_QR_TO_PAY_CLICKED("scan_qr_to_pay_clicked", "event_action"),
        CONTACT_ICON_CLICKED("contact_icon_clicked", "event_action"),
        CONTACT_SORTED("contact_sorted", "event_action"),
        CONTACT_PROCEED_CLICKED("contact_proceed_clicked", "event_action"),
        CONTACT_SELECT_ALL_CLICKED("contact_select_all_clicked", "event_action"),
        YES_DELETE_RECENT_CLICKED("yes_delete_recent_contact_clicked", "event_action"),
        PAYMENT_OPTION_CHANGED(SDKConstants.NATIVESDK_USER_CHANGES, "event_action"),
        SHARE_ICON_CLICKED("share_icon_clicked", "event_action"),
        CHAT_WITH_TAB_CLICKED("chat_with_tab_clicked", "event_action"),
        REFER_SHOPKEEPER_CLICKED("refer_shopekeeper_clicked", "event_action"),
        MAKE_ANOTHER_PAYMENT_CLICKED("make_another_payment", "event_action"),
        BUY_GIFT_VOUCHER_TAB_CLICKED("buy_gift_voucher_tab_clicked", "event_action"),
        LINK_YOUR_BANK_ACCOUNT_CLICKED("link_your_bank_account_clicked", "event_action"),
        KYC_PROCEED_CLICKED("kyc_proceed_clicked", "event_action"),
        PROCEED_TO_PAY("proceed_to_pay_clicked", "event_action"),
        PAY_CLICKED_NEW("pay_icon_clicked", "event_action"),
        SCAN_RECENT_CLICKED("scan_screen_recents_clicked", "event_action"),
        PHONE_BOOK_CONTACT_PICKED("phonebook_contact_selected", "event_action"),
        PAY_TYPE_P2P("pay_type_p2p", "event_action"),
        PAY_TYPE_P2M("pay_type_p2m", "event_action"),
        ADD_MESSAGE_CLICKED("add_message_clicked", "event_action"),
        PAY_USING_DROP_DOWN("pay_using_dropdown_clicked", "event_action"),
        PAY_USING_OPTION_SELECTED("pay_using_option_selected", "event_action"),
        CHECK_BALANCE_CLICKED("check_balance_clicked", "event_action"),
        INSUFFICICENT_POPUP_LOADED("insufficient_popup_loaded", "event_action"),
        ADD_PAY_CLICKED("add_and_pay_clicked", "event_action"),
        SET_REMINDER_CLICKED("set_as_payment_reminder_clicked", "event_action");
        
        private String eventAction;
        private String key;

        private C1450a(String str, String str2) {
            this.eventAction = str;
            this.key = str2;
        }

        public final String getEventAction() {
            return this.eventAction;
        }

        public final void setEventAction(String str) {
            this.eventAction = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }
    }

    public enum b {
        WAlLET_SEND_MONEY("wallet_send_money", "event_category"),
        KYC_UPGRADE_WALLET("kyc_upgrade_wallet", "event_category"),
        PAY_CLICKED_NEW("offline_payments", "event_category");
        
        private String eventCategory;
        private String key;

        private b(String str, String str2) {
            this.eventCategory = str;
            this.key = str2;
        }

        public final String getEventCategory() {
            return this.eventCategory;
        }

        public final void setEventCategory(String str) {
            this.eventCategory = str;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }
    }

    public enum c {
        QR_SCAN_UPI("qr_scan_upi"),
        QR_SCAN_MERCHANT_QR("qr_scan_merchant_qr"),
        QR_SCAN_PAYTM_P2P("qr_scan_paytm_p2p"),
        QR_SCAN_PAYTM_PROFILE("qr_scan_paytm_profile"),
        MOBILE_NUMBER_ENTERED("mobile_number_entered"),
        CONTACT_SELECTED("contact_selected"),
        UPI_ENTERED("upi_entered"),
        MONEY_TRANSFER(UpiConstants.WALLET_TYPE_MONEY_TRANSFER),
        EXTERNAL("external");
        
        private String eventLabelFlow;

        private c(String str) {
            this.eventLabelFlow = str;
        }

        public final String getEventLabelFlow() {
            return this.eventLabelFlow;
        }

        public final void setEventLabelFlow(String str) {
            this.eventLabelFlow = str;
        }
    }

    public enum d {
        P2P("p2p"),
        UPI_TO_PAYTM_UPI("upi_to_paytm_upi"),
        UPI_TO_NON_PAYTM_UPI("upi_to_non_paytm_upi"),
        UPI_TO_PPB("upi_to_ppb"),
        UPI_TO_OBA("upi_to_oba"),
        UPI_TO_AADHAAR("upi_to_aadhaar"),
        PPB_TO_PPB("ppb_to_ppb"),
        PPB_TO_OBA("ppb_to_oba");
        
        private String eventLabelType;

        private d(String str) {
            this.eventLabelType = str;
        }

        public final String getEventLabelType() {
            return this.eventLabelType;
        }

        public final void setEventLabelType(String str) {
            this.eventLabelType = str;
        }
    }

    private String c() {
        try {
            return "flow_" + this.f71392d.getEventLabelFlow() + ";type_" + this.f71393e.getEventLabelType() + ";recent_scan_" + this.f71394f + ";pay_instrument_" + this.m;
        } catch (Exception unused) {
            return "";
        }
    }

    public final void a(Context context) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(this.f71389a.getKey(), this.f71389a.getScreenName());
            hashMap.put(this.f71390b.getKey(), this.f71390b.getEventCategory());
            hashMap.put(this.f71391c.getKey(), this.f71391c.getEventAction());
            hashMap.put("event_label", c());
            hashMap.put("event_label2", this.f71395g);
            hashMap.put("event_value", this.f71396h);
            hashMap.put("vertical_name", "wallet");
            hashMap.put("user_id", com.paytm.utility.b.n(context));
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(context, GAUtil.CUSTOM_EVENT, hashMap);
            if (this.f71391c.equals(C1450a.SUCCESSFUL_TRANS)) {
                b();
            }
        } catch (Exception unused) {
        }
    }

    public final void b(String str) {
        this.f71397i = str;
    }

    public final void b(Context context) {
        try {
            HashMap hashMap = new HashMap();
            if (this.j == null) {
                this.j = e.PAYMENT_SUCCESS_SCREEN;
            }
            hashMap.put(this.j.getKey(), this.j.getScreenName());
            hashMap.put(this.k.getKey(), this.k.getEventCategory());
            if (this.l != null) {
                hashMap.put(this.l.getKey(), this.l.getEventAction());
            }
            hashMap.put("event_label", this.f71397i);
            hashMap.put("vertical_name", "wallet");
            hashMap.put("user_id", com.paytm.utility.b.n(context));
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(context, GAUtil.CUSTOM_EVENT, hashMap);
            if (this.f71391c.equals(C1450a.SUCCESSFUL_TRANS)) {
                b();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(e eVar) {
        this.j = eVar;
    }

    public final void a(b bVar) {
        this.k = bVar;
    }

    public final void a(C1450a aVar) {
        this.l = aVar;
    }
}
