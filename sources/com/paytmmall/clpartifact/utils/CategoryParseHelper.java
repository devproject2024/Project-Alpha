package com.paytmmall.clpartifact.utils;

import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.grid.CJRFilterValue;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilter;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilterItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryParseHelper {
    public static List<CJRFrontEndFilterItem> getParsedFilterItem(CJRFrontEndFilter cJRFrontEndFilter) {
        ArrayList<CJRFilterValue> appliedFrontEndFiltersList = cJRFrontEndFilter.getAppliedFrontEndFiltersList();
        if (appliedFrontEndFiltersList == null || appliedFrontEndFiltersList.size() == 0) {
            return cJRFrontEndFilter.getFrontEndRootFilterItem().getFrontEndFilterItemList();
        }
        Iterator<CJRFilterValue> it2 = appliedFrontEndFiltersList.iterator();
        while (it2.hasNext()) {
            CJRFrontEndFilterItem searchFrontEndFilterItemById = searchFrontEndFilterItemById(cJRFrontEndFilter.getFrontEndRootFilterItem(), it2.next().getID());
            searchFrontEndFilterItemById.setFontColor(R.color.primaryBlue);
            searchFrontEndFilterItemById.setSelected(true);
        }
        CJRFrontEndFilterItem frontEndRootFilterItem = cJRFrontEndFilter.getFrontEndRootFilterItem();
        String id = appliedFrontEndFiltersList.get(0).getID();
        List<CJRFrontEndFilterItem> reverseList = reverseList(getPath(frontEndRootFilterItem, id));
        addAllChildren(reverseList, findSelectedPosition(reverseList, id));
        if (id != null) {
            setSelectedColor(reverseList, id);
        }
        return reverseList;
    }

    private static void setSelectedColor(List<CJRFrontEndFilterItem> list, String str) {
        CJRFrontEndFilterItem cJRFrontEndFilterItem = list.get(0);
        int i2 = 1;
        while (cJRFrontEndFilterItem != null && !str.equals(cJRFrontEndFilterItem.getID()) && cJRFrontEndFilterItem.getFrontEndFilterItemList() != null && cJRFrontEndFilterItem.getFrontEndFilterItemList().size() != 0 && list.size() > i2) {
            cJRFrontEndFilterItem.setFontColor(R.color.primaryBlue);
            cJRFrontEndFilterItem.setSelected(true);
            CJRFrontEndFilterItem cJRFrontEndFilterItem2 = list.get(i2);
            i2++;
            cJRFrontEndFilterItem = cJRFrontEndFilterItem2;
        }
    }

    private static List<CJRFrontEndFilterItem> reverseList(List<CJRFrontEndFilterItem> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size <= 0) {
            return list;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            arrayList.add(list.get(i2));
        }
        return arrayList;
    }

    private static int findSelectedPosition(List<CJRFrontEndFilterItem> list, String str) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(list.get(i2).getID())) {
                return i2;
            }
        }
        return 0;
    }

    private static void addAllChildren(List<CJRFrontEndFilterItem> list, int i2) {
        int i3;
        int size = list.size();
        if (size > i2) {
            boolean z = false;
            CJRFrontEndFilterItem cJRFrontEndFilterItem = list.get(i2);
            ArrayList<CJRFrontEndFilterItem> frontEndFilterItemList = cJRFrontEndFilterItem.getFrontEndFilterItemList();
            if ((frontEndFilterItemList == null || frontEndFilterItemList.size() <= 0) && (i3 = i2 - 1) >= 0) {
                frontEndFilterItemList = list.get(i3).getFrontEndFilterItemList();
                z = true;
            }
            if (frontEndFilterItemList != null) {
                addChildren(list, size, frontEndFilterItemList, cJRFrontEndFilterItem.getID(), z);
            }
        }
    }

    private static void addChildren(List<CJRFrontEndFilterItem> list, int i2, ArrayList<CJRFrontEndFilterItem> arrayList, String str, boolean z) {
        Iterator<CJRFrontEndFilterItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRFrontEndFilterItem next = it2.next();
            if (!z || !next.getID().equals(str)) {
                list.add(i2, next);
                i2++;
            }
        }
    }

    private static List<CJRFrontEndFilterItem> getPath(CJRFrontEndFilterItem cJRFrontEndFilterItem, String str) {
        ArrayList arrayList = new ArrayList();
        CJRFrontEndFilterItem searchFrontEndFilterItemById = searchFrontEndFilterItemById(cJRFrontEndFilterItem, str);
        if (searchFrontEndFilterItemById != null) {
            arrayList.add(searchFrontEndFilterItemById);
            String parentId = searchFrontEndFilterItemById.getParentId();
            while (parentId != null) {
                CJRFrontEndFilterItem searchFrontEndFilterItemById2 = searchFrontEndFilterItemById(cJRFrontEndFilterItem, parentId);
                if (searchFrontEndFilterItemById2 == null) {
                    break;
                }
                String parentId2 = searchFrontEndFilterItemById2.getParentId();
                arrayList.add(searchFrontEndFilterItemById2);
                parentId = parentId2;
            }
        }
        return arrayList;
    }

    public static CJRFrontEndFilterItem searchFrontEndFilterItemById(CJRFrontEndFilterItem cJRFrontEndFilterItem, String str) {
        if (cJRFrontEndFilterItem == null) {
            return null;
        }
        if (str.equals(cJRFrontEndFilterItem.getID())) {
            return cJRFrontEndFilterItem;
        }
        if (cJRFrontEndFilterItem.getFrontEndFilterItemList() == null || cJRFrontEndFilterItem.getFrontEndFilterItemList().size() <= 0) {
            return null;
        }
        Iterator<CJRFrontEndFilterItem> it2 = cJRFrontEndFilterItem.getFrontEndFilterItemList().iterator();
        while (it2.hasNext()) {
            CJRFrontEndFilterItem searchFrontEndFilterItemById = searchFrontEndFilterItemById(it2.next(), str);
            if (searchFrontEndFilterItemById != null) {
                return searchFrontEndFilterItemById;
            }
        }
        return null;
    }
}
