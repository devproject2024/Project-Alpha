package net.one97.paytm.vipcashback;

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
        static final HashMap<String, Integer> f20534a = new HashMap<>(0);
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
        if (str == null || (num = b.f20534a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f20533a.get(i2);
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
        static final SparseArray<String> f20533a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(63);
            f20533a = sparseArray;
            sparseArray.put(0, "_all");
            f20533a.put(1, "handler");
            f20533a.put(2, "slider");
            f20533a.put(3, "isCollapsed");
            f20533a.put(4, "rating");
            f20533a.put(5, "type");
            f20533a.put(6, "view");
            f20533a.put(7, "showRating");
            f20533a.put(8, "levelToRateCount");
            f20533a.put(9, "model");
            f20533a.put(10, "id");
            f20533a.put(11, "badgeText");
            f20533a.put(12, "totalReview");
            f20533a.put(13, "item");
            f20533a.put(14, "adapter");
            f20533a.put(15, "reviewDetail");
            f20533a.put(16, "showWishListIcon");
            f20533a.put(17, "ratingModel");
            f20533a.put(18, "entityType");
            f20533a.put(19, "totalRatings");
            f20533a.put(20, "ratingTotal");
            f20533a.put(21, "iSCOLLAPSED");
            f20533a.put(22, "starNumber");
            f20533a.put(23, "offerTag");
            f20533a.put(24, "badgeImageUrl");
            f20533a.put(25, "notificationActive");
            f20533a.put(26, "subCashback");
            f20533a.put(27, "following");
            f20533a.put(28, "name");
            f20533a.put(29, "tickerText");
            f20533a.put(30, "viewModel");
            f20533a.put(31, CLPConstants.ARGUMENT_KEY_POSITION);
            f20533a.put(32, "clickHandler");
            f20533a.put(33, "groupAdapter");
            f20533a.put(34, "dataModel");
            f20533a.put(35, "title");
            f20533a.put(36, "reviewDate");
            f20533a.put(37, "imageUrl");
            f20533a.put(38, "isSelected");
            f20533a.put(39, "isApplied");
            f20533a.put(40, "avgRating");
            f20533a.put(41, "IS_COLLAPSED");
            f20533a.put(42, "redirect");
            f20533a.put(43, "product");
            f20533a.put(44, "holder");
            f20533a.put(45, "label");
            f20533a.put(46, "clickhandler");
            f20533a.put(47, "cashback");
            f20533a.put(48, "entityIdentifier");
            f20533a.put(49, "pagerIndicatorVisibility");
            f20533a.put(50, "fragment");
            f20533a.put(51, "seourl");
            f20533a.put(52, "isWishListed");
            f20533a.put(53, "initialFrom");
            f20533a.put(54, "layoutManager");
            f20533a.put(55, "dialogDataModel");
            f20533a.put(56, "showSeparation");
            f20533a.put(57, "showPrice");
            f20533a.put(58, "showRatingBar");
            f20533a.put(59, "initialTo");
            f20533a.put(60, "defaultItemData");
            f20533a.put(61, "ratingData");
        }
    }
}
