package net.one97.paytm.nativesdk.orflow.promo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.view.FreebieSelectionActivity;
import net.one97.paytm.nativesdk.orflow.promo.view.MallPromoSearchActivity;

public class PromoUtils {
    public static final String BULK_ADD_DATA = "BULK_ADD_DATA";
    public static final String FREEBIE_LIST = "FREEBIE_LIST";
    private static final int GRATIFICATION_MIN_LENGTH = 2;
    public static final int IS_ADD = 102;
    public static final int ITEM = 101;
    public static final String PROMO_DATA = "PROMO_DATA";
    public static final String PROMO_FREEBIE_INDEX = "PROMO_FREEBIE_INDEX";
    public static final String VIEW_MODE = "VIEW_MODE";

    public static String getCustomerId() {
        return "";
    }

    public static boolean isFlashSale(PromoListItem promoListItem) {
        return promoListItem != null && promoListItem.isFlashSale() && !TextUtils.isEmpty(promoListItem.getValidUpto());
    }

    public static boolean isFreebie(PromoListItem promoListItem) {
        return promoListItem.getFreebieListId() > 0 && !TextUtils.isEmpty(promoListItem.getFreebieListUrl());
    }

    public static boolean isGratification(List<Gratification> list) {
        return list != null && list.size() >= 2;
    }

    public static void startFreebieListActivity(Context context, List<Freebie> list, boolean z) {
        Intent intent = new Intent(context, FreebieSelectionActivity.class);
        if (context instanceof MallPromoSearchActivity) {
            MallPromoSearchActivity mallPromoSearchActivity = (MallPromoSearchActivity) context;
            if (mallPromoSearchActivity.getIntent() != null) {
                intent.putExtra(Constants.DATA_MAP, mallPromoSearchActivity.getIntent().getSerializableExtra(Constants.DATA_MAP));
            }
        }
        intent.putParcelableArrayListExtra(FREEBIE_LIST, (ArrayList) list);
        intent.putExtra(VIEW_MODE, z);
        context.startActivity(intent);
    }

    public static void startFreebieListActivity(Activity activity, List<CJRPromoData> list, HashMap<String, Object> hashMap) {
        Intent intent = new Intent(activity, FreebieSelectionActivity.class);
        intent.putExtra(Constants.DATA_MAP, hashMap);
        intent.putExtra("PROMO_DATA", (ArrayList) list);
        intent.putExtra(VIEW_MODE, false);
        activity.startActivityForResult(intent, 1001);
    }

    public static int convertDpToPixel(int i2, Context context) {
        return i2 * (context.getResources().getDisplayMetrics().densityDpi / 160);
    }

    public static void log(String str) {
        LogUtility.d("Taaha", str);
    }
}
