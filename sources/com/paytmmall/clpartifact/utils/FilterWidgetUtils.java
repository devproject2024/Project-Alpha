package com.paytmmall.clpartifact.utils;

import android.content.Context;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilter;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import java.util.ArrayList;
import java.util.List;

public class FilterWidgetUtils {
    public static final ArrayList<CJRFilterItem> VALID_FILTER_ITEMS = new ArrayList<CJRFilterItem>() {
        {
            add(new CJRFilterItem(CLPConstants.FILTER_LINEAR_RECT));
            add(new CJRFilterItem(CLPConstants.FILTER_RANGE_SLIDER));
            add(new CJRFilterItem(CLPConstants.FILTER_TREE));
        }
    };
    private static final String categoryFilterTitle = "Category";
    private static final String sortFilterTitle = "Sort";

    public static void appendCategory(ArrayList<CJRFrontEndFilter> arrayList, ArrayList<CJRFilterItem> arrayList2, String str) {
        if (isCategoryAppendRequired(arrayList, arrayList2)) {
            CJRFilterItem cJRFilterItem = new CJRFilterItem();
            cJRFilterItem.setTitle(categoryFilterTitle);
            cJRFilterItem.setType(CLPConstants.FILTER_TREE);
            cJRFilterItem.setDisplayValue(str);
            ArrayList arrayList3 = new ArrayList();
            if (arrayList2 == null || arrayList2.isEmpty() || !arrayList2.get(0).getTitle().equals(sortFilterTitle)) {
                arrayList3.add(0, cJRFilterItem);
            } else {
                arrayList3.add(arrayList2.get(0));
                arrayList2.remove(0);
                arrayList3.add(1, cJRFilterItem);
            }
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
            }
            arrayList3.addAll(arrayList2);
            arrayList2.clear();
            arrayList2.addAll(arrayList3);
        }
    }

    private static boolean isCategoryAppendRequired(ArrayList<CJRFrontEndFilter> arrayList, ArrayList<CJRFilterItem> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int min = Math.min(1, arrayList2.size() - 1);
            for (int i2 = 0; i2 <= min; i2++) {
                if (categoryFilterTitle.equalsIgnoreCase(arrayList2.get(i2).getTitle())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void appendSortFilter(ArrayList<CJRFilterItem> arrayList, ArrayList<CJRSortingKeys> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0 && arrayList != null && !arrayList.isEmpty() && !arrayList.get(0).getTitle().equals(sortFilterTitle)) {
            CJRFilterItem cJRFilterItem = new CJRFilterItem();
            cJRFilterItem.setTitle(sortFilterTitle);
            arrayList.add(0, cJRFilterItem);
        }
    }

    public static List<CJRFilterItem> filterToggle(int i2, List<CJRFilterItem> list) {
        int i3 = 0;
        while (i3 < list.size()) {
            list.get(i3).setToggleChecked(i3 == i2);
            i3++;
        }
        return list;
    }

    public static String getCategoryDisplayName(Context context, List<CJRFrontEndFilter> list) {
        String string = context.getResources().getString(R.string.filter_fixed_value);
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ArrayList<CJRFilterValue> appliedFrontEndFiltersList = list.get(i2).getAppliedFrontEndFiltersList();
                if (appliedFrontEndFiltersList != null && appliedFrontEndFiltersList.size() > 0) {
                    int size = appliedFrontEndFiltersList.size();
                    if (size <= 2) {
                        int i3 = size - 1;
                        if (appliedFrontEndFiltersList.get(i3) != null) {
                            string = appliedFrontEndFiltersList.get(i3).getName();
                        }
                    }
                    StringBuilder sb = new StringBuilder("(");
                    sb.append(size - 1);
                    sb.append(")");
                    string = sb.toString();
                }
            }
        }
        return string;
    }

    public static void sanitizeFilterUtils(ArrayList<CJRFilterItem> arrayList) {
        for (int size = (arrayList != null ? arrayList.size() : 0) - 1; size >= 0; size--) {
            if (isFaultyFilter(arrayList.get(size))) {
                arrayList.remove(size);
            }
        }
    }

    private static boolean isFaultyFilter(CJRFilterItem cJRFilterItem) {
        return cJRFilterItem == null || cJRFilterItem.getFilterValues() == null || cJRFilterItem.getFilterValues().size() == 0;
    }
}
