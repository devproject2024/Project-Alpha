package net.one97.paytm.o2o.amusementpark.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.LinkedList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.a;

public final class k {
    private static String a(Context context, String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            linkedList.add(str);
        }
        String applicationVersion = a.a().getApplicationVersion(context);
        if (!TextUtils.isEmpty(applicationVersion)) {
            linkedList.add(applicationVersion);
        }
        String n = b.n(context);
        if (!TextUtils.isEmpty(n)) {
            linkedList.add(n);
        }
        return TextUtils.join("/", linkedList);
    }

    public static void a(Context context, int i2, String str) {
        try {
            HashMap hashMap = new HashMap();
            switch (i2) {
                case 1:
                    hashMap.put("event_category", "parks_home_page");
                    hashMap.put("event_action", "home_page_screen_loaded");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Home Page");
                    break;
                case 2:
                    hashMap.put("event_category", "parks_pdp");
                    hashMap.put("event_action", "pdp_screen_loaded");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "PDP");
                    break;
                case 3:
                    hashMap.put("event_category", "parks_date_page");
                    hashMap.put("event_action", "date_page_loaded");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Date page");
                    break;
                case 4:
                    hashMap.put("event_category", "parks_book_tickets_page");
                    hashMap.put("event_action", "book_tickets_page_loaded");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Book tickets page");
                    break;
                case 5:
                    hashMap.put("event_category", "parks_visitor_details_page_loaded");
                    hashMap.put("event_action", "visitor_details_page_loaded");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Visitor details page");
                    break;
                case 6:
                    hashMap.put("event_category", "parks_order_review_page_loaded");
                    hashMap.put("event_action", "order_review_page_loaded");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Order review page");
                    break;
            }
            hashMap.put("event_label", a(context, str));
            hashMap.put("user_id", b.n(context));
            hashMap.put("vertical_name", "amusement_park");
            a.b().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, int i2, String str) {
        try {
            HashMap hashMap = new HashMap();
            if (i2 == 2) {
                hashMap.put("event_category", "parks_pdp");
                hashMap.put("event_action", "pdp_continue_booking_clicked");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "PDP");
            } else if (i2 == 4) {
                hashMap.put("event_category", "parks_book_tickets_page_continue_clicked");
                hashMap.put("event_action", "book_tickets_page_continue_clicked");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Book tickets page");
            } else if (i2 == 5) {
                hashMap.put("event_category", "parks_visitor_details_page_continue_clicked");
                hashMap.put("event_action", "visitor_details_page_continue_clicked");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Visitor details page");
            } else if (i2 == 6) {
                hashMap.put("event_category", "parks_order_review_page_proceed_to_pay_clicked");
                hashMap.put("event_action", "order_review_p age_proceed_to_pay_clicked");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Order review page");
            }
            hashMap.put("event_label", a(context, str));
            hashMap.put("user_id", b.n(context));
            hashMap.put("vertical_name", "amusement_park");
            a.b().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, context);
        } catch (Exception e2) {
            if (a.a().isDebugType()) {
                e2.getMessage();
            }
        }
    }
}
