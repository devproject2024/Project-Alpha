package net.one97.paytm.moneytransfer;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.moneytransfer.c.ae;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_MTV4COLLECTREQUESTWIDGET = 1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.mt_v4_collect_request_widget, 1);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i3 != 1) {
            return null;
        } else {
            if ("layout/mt_v4_collect_request_widget_0".equals(tag)) {
                return new ae(eVar, view);
            }
            throw new IllegalArgumentException("The tag for mt_v4_collect_request_widget is invalid. Received: ".concat(String.valueOf(tag)));
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f53517a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f53516a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.wallet.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f53516a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(61);
            f53516a = sparseArray;
            sparseArray.put(1, "IS_COLLAPSED");
            f53516a.put(0, "_all");
            f53516a.put(2, "adapter");
            f53516a.put(3, "avgRating");
            f53516a.put(4, "badgeImageUrl");
            f53516a.put(5, "badgeText");
            f53516a.put(6, "cashback");
            f53516a.put(7, "clickHandler");
            f53516a.put(8, "clickhandler");
            f53516a.put(9, "data");
            f53516a.put(10, "dataModel");
            f53516a.put(11, "defaultItemData");
            f53516a.put(12, "dialogDataModel");
            f53516a.put(13, "entityIdentifier");
            f53516a.put(14, "entityType");
            f53516a.put(15, "following");
            f53516a.put(16, "fragment");
            f53516a.put(17, "groupAdapter");
            f53516a.put(18, "handler");
            f53516a.put(19, "holder");
            f53516a.put(20, "iSCOLLAPSED");
            f53516a.put(21, "id");
            f53516a.put(22, "imageUrl");
            f53516a.put(23, "initialFrom");
            f53516a.put(24, "initialTo");
            f53516a.put(25, "isApplied");
            f53516a.put(26, "isCollapsed");
            f53516a.put(27, "isViewAll");
            f53516a.put(28, "isWishListed");
            f53516a.put(29, "item");
            f53516a.put(30, "label");
            f53516a.put(31, "layoutManager");
            f53516a.put(32, "levelToRateCount");
            f53516a.put(33, "model");
            f53516a.put(34, "name");
            f53516a.put(35, "offerTag");
            f53516a.put(36, "pagerIndicatorVisibility");
            f53516a.put(37, CLPConstants.ARGUMENT_KEY_POSITION);
            f53516a.put(38, "product");
            f53516a.put(39, "rating");
            f53516a.put(40, "ratingData");
            f53516a.put(41, "ratingModel");
            f53516a.put(42, "ratingTotal");
            f53516a.put(43, "redirect");
            f53516a.put(44, "reviewDate");
            f53516a.put(45, "reviewDetail");
            f53516a.put(46, "seourl");
            f53516a.put(47, "showPrice");
            f53516a.put(48, "showRating");
            f53516a.put(49, "showRatingBar");
            f53516a.put(50, "showSeparation");
            f53516a.put(51, "slider");
            f53516a.put(52, "starNumber");
            f53516a.put(53, "subCashback");
            f53516a.put(54, "tickerText");
            f53516a.put(55, "title");
            f53516a.put(56, "totalRatings");
            f53516a.put(57, "totalReview");
            f53516a.put(58, "type");
            f53516a.put(59, "view");
            f53516a.put(60, "viewModel");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f53517a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(1);
            f53517a = hashMap;
            hashMap.put("layout/mt_v4_collect_request_widget_0", Integer.valueOf(R.layout.mt_v4_collect_request_widget));
        }
    }
}
