package net.one97.paytm.recharge.model.v4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJRCategoryDataHelper {
    private y<CJRCategoryData> categoryDataObservable = new y<>();
    private y<String> categoryIdObservable = new y<>();
    private Map<String, CJRCategoryData> rcCategoryDataList = new HashMap();

    public final String getCategoryId() {
        String value = this.categoryIdObservable.getValue();
        return value == null ? "" : value;
    }

    public final void setCategoryId(String str) {
        this.categoryIdObservable.setValue(str);
    }

    public final CJRCategoryData getCategoryData() {
        return this.categoryDataObservable.getValue();
    }

    public final void setCategoryData(CJRCategoryData cJRCategoryData) {
        this.categoryDataObservable.setValue(cJRCategoryData);
    }

    public final LiveData<CJRCategoryData> getCategoryLiveData() {
        return this.categoryDataObservable;
    }

    public final void setCategoryData(String str, CJRCategoryData cJRCategoryData) {
        k.c(str, "categoryId");
        k.c(cJRCategoryData, "categoryData");
        addRelatedCategoryData(str, cJRCategoryData);
        this.categoryIdObservable.setValue(str);
        this.categoryDataObservable.setValue(cJRCategoryData);
    }

    public final void addRelatedCategoryData(String str, CJRCategoryData cJRCategoryData) {
        k.c(str, "categoryId");
        k.c(cJRCategoryData, "data");
        this.rcCategoryDataList.put(str, cJRCategoryData);
    }

    public final CJRCategoryData getRelatedCategoryData(String str) {
        k.c(str, "categoryId");
        return this.rcCategoryDataList.get(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.util.List<net.one97.paytm.recharge.model.v4.CJRRelatedCategory>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> getRelatedCategories() {
        /*
            r5 = this;
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.getCategoryData()
            r1 = 0
            if (r0 == 0) goto L_0x0036
            java.util.List r0 = r0.getRelatedCategories()
            if (r0 == 0) goto L_0x0036
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0032
            java.lang.Object r3 = r0.next()
            r4 = r3
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r4 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r4
            if (r4 == 0) goto L_0x002b
            r4 = 1
            goto L_0x002c
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 == 0) goto L_0x001a
            r2.add(r3)
            goto L_0x001a
        L_0x0032:
            r0 = r2
            java.util.List r0 = (java.util.List) r0
            goto L_0x0037
        L_0x0036:
            r0 = r1
        L_0x0037:
            boolean r2 = r0 instanceof java.util.List
            if (r2 != 0) goto L_0x003c
            r0 = r1
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper.getRelatedCategories():java.util.List");
    }

    public final List<CJRInputFieldsItem> getCategoryInputFields() {
        CJRCategoryData categoryData = getCategoryData();
        if (categoryData != null) {
            return categoryData.getInputFields();
        }
        return null;
    }

    public final void clear() {
        setCategoryId((String) null);
        setCategoryData((CJRCategoryData) null);
        for (CJRCategoryData removeAllSelections : this.rcCategoryDataList.values()) {
            removeAllSelections.removeAllSelections();
        }
        this.rcCategoryDataList.clear();
    }

    public final String getGroupingTitle(int i2, String str) {
        String str2;
        k.c(str, "groupName");
        GroupAttributesItem groupAttributes = getGroupAttributes(i2, str);
        CJRAggsItem aggItem = getAggItem(i2, str);
        if (aggItem == null || (str2 = aggItem.getLabel()) == null) {
            str2 = groupAttributes != null ? groupAttributes.getDisplayName() : null;
        }
        return str2 == null ? "" : str2;
    }

    public final String getGroupingTitle(CJRAggsItem cJRAggsItem, GroupAttributesItem groupAttributesItem) {
        String str;
        if (cJRAggsItem == null || (str = cJRAggsItem.getLabel()) == null) {
            str = groupAttributesItem != null ? groupAttributesItem.getDisplayName() : null;
        }
        return str == null ? "" : str;
    }

    public final GroupAttributesItem getGroupAttributes(int i2, String str) {
        k.c(str, "groupName");
        for (CJRCategoryData categoryData = getCategoryData(); categoryData != null; categoryData = categoryData.getNextLevelGroupingData()) {
            if (categoryData.getGroupLevel() == i2) {
                return categoryData.getGroupFieldV2(str);
            }
        }
        return null;
    }

    public final CJRCategoryData getLastGroupingData() {
        CJRCategoryData categoryData = getCategoryData();
        if (categoryData != null) {
            return categoryData.getLastGroupingData();
        }
        return null;
    }

    public final List<CJRAggsItem> getGroupItemList(int i2, String str) {
        k.c(str, "groupName");
        CJRCategoryData groupingDataForGroupLevel = getGroupingDataForGroupLevel(i2);
        if (groupingDataForGroupLevel != null) {
            return groupingDataForGroupLevel.getGroupingItemList(str);
        }
        return null;
    }

    public final CJRAggsItem getGroupItem(int i2, String str, int i3) {
        k.c(str, "groupName");
        List<CJRAggsItem> groupItemList = getGroupItemList(i2, str);
        Integer valueOf = groupItemList != null ? Integer.valueOf(groupItemList.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.intValue() >= i3) {
            return groupItemList.get(i3);
        }
        return null;
    }

    public final CJRAggsItem getAggItem(int i2, String str) {
        k.c(str, "groupName");
        CJRCategoryData groupingDataForGroupLevel = getGroupingDataForGroupLevel(i2);
        if (groupingDataForGroupLevel != null) {
            return groupingDataForGroupLevel.getGroupingItem(str);
        }
        return null;
    }

    private final CJRCategoryData getGroupingDataForGroupLevel(int i2) {
        CJRCategoryData categoryData = getCategoryData();
        while (categoryData != null && categoryData.getGroupLevel() != i2) {
            categoryData = categoryData.getNextLevelGroupingData();
        }
        return categoryData;
    }

    public final void addSelectedGroupItem(int i2, CJRSelectedGroupItem cJRSelectedGroupItem) {
        k.c(cJRSelectedGroupItem, "selectedGroupItem");
        CJRCategoryData groupingDataForGroupLevel = getGroupingDataForGroupLevel(i2);
        if (groupingDataForGroupLevel != null) {
            groupingDataForGroupLevel.addItemToSelectedHashMap(cJRSelectedGroupItem);
        }
    }

    public final void removeSelectedGroupItem(int i2, String str) {
        k.c(str, "groupName");
        CJRCategoryData groupingDataForGroupLevel = getGroupingDataForGroupLevel(i2);
        if (groupingDataForGroupLevel != null) {
            groupingDataForGroupLevel.removeItemFromSelectedHashMap(str);
        }
        if (groupingDataForGroupLevel != null) {
            groupingDataForGroupLevel.setNextLevelGroupingData((CJRCategoryData) null);
        }
    }

    public final void removeAllSelections(int i2) {
        CJRCategoryData groupingDataForGroupLevel = getGroupingDataForGroupLevel(i2);
        if (groupingDataForGroupLevel != null) {
            groupingDataForGroupLevel.removeAllSelections();
        }
    }

    public final CJRNextGroupData getNextGroupItemData() {
        GroupAttributesItem groupAttributesItem;
        CJRDeviceType type;
        String androidType;
        CJRCategoryData lastGroupingData = getLastGroupingData();
        CJRNextGroupData nextGroupItemData = lastGroupingData != null ? lastGroupingData.getNextGroupItemData() : null;
        if (nextGroupItemData == null || (groupAttributesItem = nextGroupItemData.getGroupAttributesItem()) == null || (type = groupAttributesItem.getType()) == null || (androidType = type.getAndroidType()) == null || !p.a(androidType, "checkbox", true)) {
            return nextGroupItemData;
        }
        return null;
    }

    public final CJRCategoryData getCategoryDataForGroupLevel(int i2) {
        for (CJRCategoryData categoryData = getCategoryData(); categoryData != null; categoryData = categoryData.getNextLevelGroupingData()) {
            if (categoryData.getGroupLevel() == i2) {
                return categoryData;
            }
        }
        return null;
    }

    public final boolean isGroupAPICallRequired() {
        CJRCategoryData lastGroupingData = getLastGroupingData();
        return lastGroupingData != null && lastGroupingData.isGroupAPICallRequired();
    }

    public final JSONObject getFilterJSON() {
        JSONArray jSONArray = new JSONArray();
        for (CJRCategoryData categoryData = getCategoryData(); categoryData != null; categoryData = categoryData.getNextLevelGroupingData()) {
            JSONArray filterJSON = categoryData.getFilterJSON();
            int length = filterJSON.length();
            for (int i2 = 0; i2 < length; i2++) {
                jSONArray.put(filterJSON.get(i2));
            }
        }
        JSONObject put = new JSONObject().put("filters", jSONArray);
        k.a((Object) put, "JSONObject().put(\"filters\",filterJSONArray)");
        return put;
    }

    public final String getGroupFieldValuesForGA() {
        String str = "";
        for (CJRCategoryData categoryData = getCategoryData(); categoryData != null; categoryData = categoryData.getNextLevelGroupingData()) {
            if (k.a((Object) str, (Object) "")) {
                str = categoryData.getGroupInputFieldValuesForGA();
            } else {
                str = str + "/" + categoryData.getGroupInputFieldValuesForGA();
            }
        }
        return str;
    }

    public final JSONObject getSelectedGroupFieldMeta(JSONObject jSONObject) {
        k.c(jSONObject, "mMetaData");
        for (CJRCategoryData categoryData = getCategoryData(); categoryData != null; categoryData = categoryData.getNextLevelGroupingData()) {
            for (CJRSelectedGroupItem cJRSelectedGroupItem : categoryData.getSelectedGroupItemHashMap().values()) {
                String groupName = cJRSelectedGroupItem.getGroupName();
                if (groupName == null) {
                    k.a();
                }
                String value = cJRSelectedGroupItem.getValue();
                if (value == null) {
                    k.a();
                }
                jSONObject.put(groupName, value);
            }
        }
        return jSONObject;
    }

    public final String getProtectionURL() {
        CJRProtectionUrl protectionUrl;
        CJRCategoryData categoryData = getCategoryData();
        if (categoryData == null || (protectionUrl = categoryData.getProtectionUrl()) == null) {
            return null;
        }
        return protectionUrl.getAndroid();
    }

    public final Boolean getDealsFastForward() {
        CJRCategoryData categoryData = getCategoryData();
        if (categoryData != null) {
            return Boolean.valueOf(categoryData.getDealsFastForward());
        }
        return null;
    }

    public final JSONArray getNextGroupingJSONArray() {
        CJRCategoryData lastGroupingData = getLastGroupingData();
        if (lastGroupingData != null) {
            return lastGroupingData.getNextGroupingJSONArray();
        }
        return null;
    }

    public final String getURLQueryParams() {
        CJRCategoryData categoryData = getCategoryData();
        if (categoryData != null) {
            return categoryData.getURLQueryParams();
        }
        return null;
    }

    public final JSONObject getNextGroupingPostBody() {
        JSONObject filterJSON = getFilterJSON();
        JSONArray nextGroupingJSONArray = getNextGroupingJSONArray();
        if (nextGroupingJSONArray != null) {
            filterJSON.put("groups", nextGroupingJSONArray);
        }
        return filterJSON;
    }

    public final int getIndexFromList(List<CJRAggsItem> list, String str) {
        k.c(str, "key");
        if (list != null) {
            int i2 = 0;
            for (CJRAggsItem value : list) {
                if (p.a(value.getValue(), str, true)) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }
}
