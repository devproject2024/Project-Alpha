package com.paytmmall.clpartifact.utils;

import java.util.HashSet;
import kotlin.g.b.k;

public final class CategoryImpressionAndApiHandler {
    public static final CategoryImpressionAndApiHandler INSTANCE = new CategoryImpressionAndApiHandler();
    private static HashSet<String> categoryPopupImpressionsData = new HashSet<>();
    private static boolean isFirstApiCallFromCategoryPopup = true;
    private static boolean isFirstApiCallFromShowMore = true;
    private static HashSet<String> showMoreImpressionsData = new HashSet<>();

    private CategoryImpressionAndApiHandler() {
    }

    public final boolean isFirstApiCallFromShowMore() {
        return isFirstApiCallFromShowMore;
    }

    public final void setFirstApiCallFromShowMore(boolean z) {
        isFirstApiCallFromShowMore = z;
    }

    public final boolean isFirstApiCallFromCategoryPopup() {
        return isFirstApiCallFromCategoryPopup;
    }

    public final void setFirstApiCallFromCategoryPopup(boolean z) {
        isFirstApiCallFromCategoryPopup = z;
    }

    public final HashSet<String> getShowMoreImpressionsData() {
        return showMoreImpressionsData;
    }

    public final void setShowMoreImpressionsData(HashSet<String> hashSet) {
        k.c(hashSet, "<set-?>");
        showMoreImpressionsData = hashSet;
    }

    public final HashSet<String> getCategoryPopupImpressionsData() {
        return categoryPopupImpressionsData;
    }

    public final void setCategoryPopupImpressionsData(HashSet<String> hashSet) {
        k.c(hashSet, "<set-?>");
        categoryPopupImpressionsData = hashSet;
    }

    public final void resetAll() {
        isFirstApiCallFromShowMore = true;
        isFirstApiCallFromCategoryPopup = true;
        showMoreImpressionsData.clear();
        categoryPopupImpressionsData.clear();
    }
}
