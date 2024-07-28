package net.one97.paytm.games.e;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35608a = g.a().c().isStag();

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<String> f35609b;

    public static String a(int i2) {
        switch (i2) {
            case -2:
                return Payload.RESPONSE_FEATURE_NOT_SUPPORTED;
            case -1:
                return Payload.RESPONSE_SERVICE_DISCONNECTED;
            case 0:
                return Payload.RESPONSE_OK;
            case 1:
                return "USER_CANCELED";
            case 2:
                return Payload.RESPONSE_SERVICE_UNAVAILABLE;
            case 3:
                return "BILLING_UNAVAILABLE";
            case 4:
                return "ITEM_UNAVAILABLE";
            case 5:
                return Payload.RESPONSE_DEVELOPER_ERROR;
            case 6:
                return AppConstants.TRANSACTION_STATUS_ERROR;
            case 7:
                return "ITEM_ALREADY_OWNED";
            case 8:
                return "ITEM_NOT_OWNED";
            default:
                return "Unknown Code";
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f35609b = arrayList;
        arrayList.add("list_h");
        f35609b.add(CLPConstants.DEFAULT_GRID_VIEW_TYPE);
        f35609b.add("bannerstatic");
    }
}
