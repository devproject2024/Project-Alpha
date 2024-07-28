package net.one97.paytm.p2b;

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

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f56867a = new HashMap<>(0);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f56867a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f56866a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f56866a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(63);
            f56866a = sparseArray;
            sparseArray.put(0, "_all");
            f56866a.put(1, "handler");
            f56866a.put(2, "slider");
            f56866a.put(3, "isCollapsed");
            f56866a.put(4, "rating");
            f56866a.put(5, "type");
            f56866a.put(6, "view");
            f56866a.put(7, "showRating");
            f56866a.put(8, "levelToRateCount");
            f56866a.put(9, "model");
            f56866a.put(10, "id");
            f56866a.put(11, "badgeText");
            f56866a.put(12, "totalReview");
            f56866a.put(13, "item");
            f56866a.put(14, "adapter");
            f56866a.put(15, "reviewDetail");
            f56866a.put(16, "showWishListIcon");
            f56866a.put(17, "ratingModel");
            f56866a.put(18, "entityType");
            f56866a.put(19, "totalRatings");
            f56866a.put(20, "ratingTotal");
            f56866a.put(21, "iSCOLLAPSED");
            f56866a.put(22, "starNumber");
            f56866a.put(23, "offerTag");
            f56866a.put(24, "badgeImageUrl");
            f56866a.put(25, "notificationActive");
            f56866a.put(26, "subCashback");
            f56866a.put(27, "following");
            f56866a.put(28, "name");
            f56866a.put(29, "tickerText");
            f56866a.put(30, "viewModel");
            f56866a.put(31, CLPConstants.ARGUMENT_KEY_POSITION);
            f56866a.put(32, "clickHandler");
            f56866a.put(33, "groupAdapter");
            f56866a.put(34, "dataModel");
            f56866a.put(35, "title");
            f56866a.put(36, "reviewDate");
            f56866a.put(37, "imageUrl");
            f56866a.put(38, "isSelected");
            f56866a.put(39, "isApplied");
            f56866a.put(40, "avgRating");
            f56866a.put(41, "IS_COLLAPSED");
            f56866a.put(42, "redirect");
            f56866a.put(43, "product");
            f56866a.put(44, "holder");
            f56866a.put(45, "label");
            f56866a.put(46, "clickhandler");
            f56866a.put(47, "cashback");
            f56866a.put(48, "entityIdentifier");
            f56866a.put(49, "pagerIndicatorVisibility");
            f56866a.put(50, "fragment");
            f56866a.put(51, "seourl");
            f56866a.put(52, "isWishListed");
            f56866a.put(53, "initialFrom");
            f56866a.put(54, "layoutManager");
            f56866a.put(55, "dialogDataModel");
            f56866a.put(56, "showSeparation");
            f56866a.put(57, "showPrice");
            f56866a.put(58, "showRatingBar");
            f56866a.put(59, "initialTo");
            f56866a.put(60, "defaultItemData");
            f56866a.put(61, "ratingData");
        }
    }
}
