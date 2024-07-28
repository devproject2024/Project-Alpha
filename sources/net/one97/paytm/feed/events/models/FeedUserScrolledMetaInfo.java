package net.one97.paytm.feed.events.models;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class FeedUserScrolledMetaInfo extends MetaInfo {
    private ArrayList<FeedScrolledItem> scrolledItems;

    public final ArrayList<FeedScrolledItem> getScrolledItems() {
        return this.scrolledItems;
    }

    public final void setScrolledItems(ArrayList<FeedScrolledItem> arrayList) {
        k.c(arrayList, "<set-?>");
        this.scrolledItems = arrayList;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedUserScrolledMetaInfo(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, boolean z, ArrayList<FeedScrolledItem> arrayList) {
        super(str, str2, str3, str4, str5, str6, num, str7, str8, str9, z);
        k.c(arrayList, "scrolledItems");
        this.scrolledItems = arrayList;
    }
}
