package net.one97.paytm.iocl;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.iocl.a.f;
import net.one97.paytm.iocl.a.h;
import net.one97.paytm.iocl.a.j;
import net.one97.paytm.iocl.a.l;
import net.one97.paytm.iocl.a.n;
import net.one97.paytm.iocl.a.p;
import net.one97.paytm.iocl.a.r;
import net.one97.paytm.iocl.a.t;
import net.one97.paytm.iocl.a.v;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_FRAGMENTIOCLLANDINGPAGE = 1;
    private static final int LAYOUT_FRAGMENTIOCLLANDINGPAGEV1 = 2;
    private static final int LAYOUT_IOCLBASEACTIVITY = 3;
    private static final int LAYOUT_IOCLBASEACTIVITYV1 = 4;
    private static final int LAYOUT_IOCLBOTTOMSHEETCONFIRMATION = 5;
    private static final int LAYOUT_IOCLBOTTOMSHEETFILTER = 6;
    private static final int LAYOUT_IOCLBOTTOMSHEETGENDERV1 = 7;
    private static final int LAYOUT_IOCLUSERDETAILFRAGMENT = 8;
    private static final int LAYOUT_IOCLUSERDETAILFRAGMENTV1 = 9;
    private static final int LAYOUT_IOCLVIEWBALANCE = 10;
    private static final int LAYOUT_IOCLVIEWBALANCEV1 = 11;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(11);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_iocl_landing_page, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_iocl_landing_page_v1, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_base_activity, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_base_activity_v1, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_bottom_sheet_confirmation, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_bottom_sheet_filter, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_bottom_sheet_gender_v1, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_user_detail_fragment, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_user_detail_fragment_v1, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_view_balance, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.iocl_view_balance_v1, 11);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i3) {
                case 1:
                    if ("layout/fragment_iocl_landing_page_0".equals(tag)) {
                        return new net.one97.paytm.iocl.a.b(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_iocl_landing_page is invalid. Received: ".concat(String.valueOf(tag)));
                case 2:
                    if ("layout/fragment_iocl_landing_page_v1_0".equals(tag)) {
                        return new net.one97.paytm.iocl.a.d(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_iocl_landing_page_v1 is invalid. Received: ".concat(String.valueOf(tag)));
                case 3:
                    if ("layout/iocl_base_activity_0".equals(tag)) {
                        return new f(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_base_activity is invalid. Received: ".concat(String.valueOf(tag)));
                case 4:
                    if ("layout/iocl_base_activity_v1_0".equals(tag)) {
                        return new h(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_base_activity_v1 is invalid. Received: ".concat(String.valueOf(tag)));
                case 5:
                    if ("layout/iocl_bottom_sheet_confirmation_0".equals(tag)) {
                        return new j(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_bottom_sheet_confirmation is invalid. Received: ".concat(String.valueOf(tag)));
                case 6:
                    if ("layout/iocl_bottom_sheet_filter_0".equals(tag)) {
                        return new l(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_bottom_sheet_filter is invalid. Received: ".concat(String.valueOf(tag)));
                case 7:
                    if ("layout/iocl_bottom_sheet_gender_v1_0".equals(tag)) {
                        return new n(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_bottom_sheet_gender_v1 is invalid. Received: ".concat(String.valueOf(tag)));
                case 8:
                    if ("layout/iocl_user_detail_fragment_0".equals(tag)) {
                        return new p(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_user_detail_fragment is invalid. Received: ".concat(String.valueOf(tag)));
                case 9:
                    if ("layout/iocl_user_detail_fragment_v1_0".equals(tag)) {
                        return new r(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_user_detail_fragment_v1 is invalid. Received: ".concat(String.valueOf(tag)));
                case 10:
                    if ("layout/iocl_view_balance_0".equals(tag)) {
                        return new t(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_view_balance is invalid. Received: ".concat(String.valueOf(tag)));
                case 11:
                    if ("layout/iocl_view_balance_v1_0".equals(tag)) {
                        return new v(eVar, view);
                    }
                    throw new IllegalArgumentException("The tag for iocl_view_balance_v1 is invalid. Received: ".concat(String.valueOf(tag)));
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
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
        if (str == null || (num = b.f14076a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f14075a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f14075a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            f14075a = sparseArray;
            sparseArray.put(0, "_all");
            f14075a.put(1, "userModel");
            f14075a.put(2, "landingPageModel");
            f14075a.put(3, "redeemModel");
            f14075a.put(4, "baseData");
            f14075a.put(5, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
            f14075a.put(6, "loaderVisible");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f14076a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(11);
            f14076a = hashMap;
            hashMap.put("layout/fragment_iocl_landing_page_0", Integer.valueOf(R.layout.fragment_iocl_landing_page));
            f14076a.put("layout/fragment_iocl_landing_page_v1_0", Integer.valueOf(R.layout.fragment_iocl_landing_page_v1));
            f14076a.put("layout/iocl_base_activity_0", Integer.valueOf(R.layout.iocl_base_activity));
            f14076a.put("layout/iocl_base_activity_v1_0", Integer.valueOf(R.layout.iocl_base_activity_v1));
            f14076a.put("layout/iocl_bottom_sheet_confirmation_0", Integer.valueOf(R.layout.iocl_bottom_sheet_confirmation));
            f14076a.put("layout/iocl_bottom_sheet_filter_0", Integer.valueOf(R.layout.iocl_bottom_sheet_filter));
            f14076a.put("layout/iocl_bottom_sheet_gender_v1_0", Integer.valueOf(R.layout.iocl_bottom_sheet_gender_v1));
            f14076a.put("layout/iocl_user_detail_fragment_0", Integer.valueOf(R.layout.iocl_user_detail_fragment));
            f14076a.put("layout/iocl_user_detail_fragment_v1_0", Integer.valueOf(R.layout.iocl_user_detail_fragment_v1));
            f14076a.put("layout/iocl_view_balance_0", Integer.valueOf(R.layout.iocl_view_balance));
            f14076a.put("layout/iocl_view_balance_v1_0", Integer.valueOf(R.layout.iocl_view_balance_v1));
        }
    }
}
