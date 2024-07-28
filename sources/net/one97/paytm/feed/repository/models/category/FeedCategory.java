package net.one97.paytm.feed.repository.models.category;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.Category;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedCategory extends FeedItem {
    private final List<Category> categories;

    public static /* synthetic */ FeedCategory copy$default(FeedCategory feedCategory, List<Category> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = feedCategory.categories;
        }
        return feedCategory.copy(list);
    }

    public final List<Category> component1() {
        return this.categories;
    }

    public final FeedCategory copy(List<Category> list) {
        k.c(list, "categories");
        return new FeedCategory(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FeedCategory) && k.a((Object) this.categories, (Object) ((FeedCategory) obj).categories);
        }
        return true;
    }

    public final int hashCode() {
        List<Category> list = this.categories;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "FeedCategory(categories=" + this.categories + ")";
    }

    public FeedCategory(List<Category> list) {
        k.c(list, "categories");
        this.categories = list;
        setFeedItemType("CATEGORY");
    }

    public final List<Category> getCategories() {
        return this.categories;
    }
}
