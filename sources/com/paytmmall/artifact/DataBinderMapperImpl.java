package com.paytmmall.artifact;

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
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_FRAGMENTCLP = 1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_clp, 1);
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
            if ("layout/fragment_clp_0".equals(tag)) {
                return new com.paytmmall.artifact.b.b(eVar, view);
            }
            throw new IllegalArgumentException("The tag for fragment_clp is invalid. Received: ".concat(String.valueOf(tag)));
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
        if (str == null || (num = b.f15390a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f15389a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.paytmmall.clpartifact.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f15389a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(65);
            f15389a = sparseArray;
            sparseArray.put(0, "_all");
            f15389a.put(1, "handler");
            f15389a.put(2, "slider");
            f15389a.put(3, "isCollapsed");
            f15389a.put(4, "rating");
            f15389a.put(5, "showMoreVisibility");
            f15389a.put(6, "type");
            f15389a.put(7, "view");
            f15389a.put(8, "showRating");
            f15389a.put(9, "levelToRateCount");
            f15389a.put(10, "model");
            f15389a.put(11, "id");
            f15389a.put(12, "badgeText");
            f15389a.put(13, "totalReview");
            f15389a.put(14, "item");
            f15389a.put(15, "adapter");
            f15389a.put(16, "reviewDetail");
            f15389a.put(17, "showWishListIcon");
            f15389a.put(18, "ratingModel");
            f15389a.put(19, "entityType");
            f15389a.put(20, "totalRatings");
            f15389a.put(21, "ratingTotal");
            f15389a.put(22, "iSCOLLAPSED");
            f15389a.put(23, "starNumber");
            f15389a.put(24, "offerTag");
            f15389a.put(25, "badgeImageUrl");
            f15389a.put(26, "notificationActive");
            f15389a.put(27, "subCashback");
            f15389a.put(28, "following");
            f15389a.put(29, "name");
            f15389a.put(30, "tickerText");
            f15389a.put(31, "viewModel");
            f15389a.put(32, CLPConstants.ARGUMENT_KEY_POSITION);
            f15389a.put(33, "clickHandler");
            f15389a.put(34, "groupAdapter");
            f15389a.put(35, "dataModel");
            f15389a.put(36, "title");
            f15389a.put(37, "reviewDate");
            f15389a.put(38, "imageUrl");
            f15389a.put(39, "isSelected");
            f15389a.put(40, "isApplied");
            f15389a.put(41, "avgRating");
            f15389a.put(42, "IS_COLLAPSED");
            f15389a.put(43, "redirect");
            f15389a.put(44, "product");
            f15389a.put(45, "holder");
            f15389a.put(46, "label");
            f15389a.put(47, "clickhandler");
            f15389a.put(48, "cashback");
            f15389a.put(49, "entityIdentifier");
            f15389a.put(50, "pagerIndicatorVisibility");
            f15389a.put(51, "fragment");
            f15389a.put(52, "seourl");
            f15389a.put(53, "isWishListed");
            f15389a.put(54, "initialFrom");
            f15389a.put(55, "layoutManager");
            f15389a.put(56, "dialogDataModel");
            f15389a.put(57, "showSeparation");
            f15389a.put(58, "showPrice");
            f15389a.put(59, "showRatingBar");
            f15389a.put(60, "initialTo");
            f15389a.put(61, "category");
            f15389a.put(62, "defaultItemData");
            f15389a.put(63, "ratingData");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f15390a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(1);
            f15390a = hashMap;
            hashMap.put("layout/fragment_clp_0", Integer.valueOf(R.layout.fragment_clp));
        }
    }
}
