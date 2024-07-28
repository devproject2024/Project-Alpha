package com.paytmmall.artifact.common.b;

import com.paytmmall.artifact.common.entity.CJRHomePageItem;
import java.util.HashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Object> f15656a;

    public static HashMap<String, Object> a(CJRHomePageItem cJRHomePageItem) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("search_input_type", cJRHomePageItem.getSearchType());
        hashMap.put("search_output_type", cJRHomePageItem.getSearchResultType());
        hashMap.put("search_category", cJRHomePageItem.getSearchCategory());
        hashMap.put("search_autosuggest_data", cJRHomePageItem.getAutoSuggestMetaData());
        return hashMap;
    }
}
