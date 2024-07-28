package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.brandStoreModels.CJRCategoryTree;

public class CJRHomePageDetailV2 {
    @b(a = "badge_image_url")
    private String mBadgeImageUrl;
    private String mFooterImageURL;
    @b(a = "views")
    public ArrayList<CJRHomePageLayoutV2> mHomePageLayoutList = new ArrayList<>();
    @b(a = "slots")
    private ArrayList<CJRHomePageSlotItemV2> mHomePageSlotItemList = new ArrayList<>();
    @b(a = "id")
    private String mId;
    @b(a = "layout")
    private String mLayout;
    @b(a = "layout_details")
    private CJRLayoutDetailV2 mLayoutDetails;
    @b(a = "mobile_layout")
    public ArrayList<CJRHomePageLayoutV2> mMobileLayout = new ArrayList<>();
    @b(a = "attributes")
    private CJRLayoutDetailV2 mattribute;
    @b(a = "category_tree")
    private CJRCategoryTree mcategorytree;

    public String getmId() {
        return this.mId;
    }

    public void setmId(String str) {
        this.mId = str;
    }

    public String getmLayout() {
        return this.mLayout;
    }

    public void setmLayout(String str) {
        this.mLayout = str;
    }

    public ArrayList<CJRHomePageSlotItemV2> getmHomePageSlotItemList() {
        return this.mHomePageSlotItemList;
    }

    public void setmHomePageSlotItemList(ArrayList<CJRHomePageSlotItemV2> arrayList) {
        this.mHomePageSlotItemList = arrayList;
    }

    public void setmHomePageLayoutList(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        this.mHomePageLayoutList.add(cJRHomePageLayoutV2);
    }

    public ArrayList<CJRHomePageLayoutV2> getHomePageLayoutList() {
        return this.mHomePageLayoutList;
    }

    public void setHomePageLayoutList(ArrayList<CJRHomePageLayoutV2> arrayList) {
        this.mHomePageLayoutList = arrayList;
    }

    public ArrayList<CJRHomePageItem> getItemsForLayout(String str) {
        Iterator<CJRHomePageLayoutV2> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayoutV2 next = it2.next();
            if (next.getLayout().equalsIgnoreCase(str)) {
                return next.getHomePageItemList();
            }
        }
        return null;
    }

    public ArrayList<CJRHomePageItem> getItemsForProduct(String str) {
        Iterator<CJRHomePageLayoutV2> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayoutV2 next = it2.next();
            if (next.getName().equalsIgnoreCase(str)) {
                return next.getHomePageItemList();
            }
        }
        return null;
    }

    public ArrayList<CJRHomePageLayoutV2> pageRowItems(boolean z, boolean z2) {
        ArrayList<CJRHomePageLayoutV2> arrayList = new ArrayList<>();
        if (z) {
            Iterator<CJRHomePageLayoutV2> it2 = this.mMobileLayout.iterator();
            while (it2.hasNext()) {
                CJRHomePageLayoutV2 next = it2.next();
                if (next.getLayout().equalsIgnoreCase(CJRHomePage.LAYOUT_HOME_PAGE_TABS) && next.getHomePageItemList().size() > 0) {
                    arrayList.add(next);
                }
            }
        }
        Iterator<CJRHomePageLayoutV2> it3 = this.mHomePageLayoutList.iterator();
        while (it3.hasNext()) {
            CJRHomePageLayoutV2 next2 = it3.next();
            if (next2.getLayout() != null) {
                LayoutType fromName = LayoutType.fromName(next2.getLayout());
                switch (fromName) {
                    case LAYOUT_PRODUCT_ROW:
                    case LAYOUT_BRAND_PRODUCT_ROW:
                    case LAYOUT_PRODUCT_GRID:
                    case LAYOUT_CAROUSEL_1:
                    case LAYOUT_CAROUSEL1:
                    case LAYOUT_CAROUSEL_FULL_WIDTH:
                    case LAYOUT_CAROUSEL_ROW:
                    case LAYOUT_CAROUSEL_2:
                    case LAYOUT_CAROUSEL2:
                    case LAYOUT_VIDEO_COROUSEL:
                    case LAYOUT_PHOTO_COROUSEL:
                    case LAYOUT_SNIPPET_1:
                    case LAYOUT_SNIPPET_2:
                    case LAYOUT_SMART_LIST:
                    case LAYOUT_SMART_ICON_HEADER:
                    case LAYOUT_TICKER:
                    case LAYOUT_C4_LARGE:
                    case LAYOUT_SMART_ICON_CAROUSEL:
                    case LAYOUT_SMART_ICON_VIDEO:
                    case LAYOUT_SMART_ICON_GROUP_GRID:
                    case LAYOUT_SMART_ICON_BUTTON:
                        if (next2.getHomePageItemList().size() > 0) {
                            arrayList.add(next2);
                            break;
                        }
                        break;
                    case LAYOUT_TEXT_LINKS:
                    case LAYOUT_HORIZONTAL_TEXT_LIST:
                    case LAYOUT_VIEW_PAGER:
                    case LAYOUT_WALLET_OPTIONS:
                    case LAYOUT_FOOTER_SOCIAL_ICONS:
                    case LAYOUT_CATEGORY_COROUSEL:
                    case LAYOUT_FOOTER_SELL_PARTNER_CONTACT_ICONS:
                    case LAYOUT_SUCCESS_CARD:
                    case LAYOUT_PENDING_CARD:
                    case LAYOUT_AUTO_CARD:
                    case LAYOUT_FAILURE_CARD:
                    case LAYOUT_FOOTER_CARD:
                    case LAYOUT_PAYMENT_CARD:
                        arrayList.add(next2);
                        break;
                }
                if (z2) {
                    switch (fromName) {
                        case LAYOUT_PRODUCT_ROW_3XN:
                        case LAYOUT_PRODUCT_ROW_2XN:
                        case LAYOUT_PRODUCT_ROW_1XN:
                        case LAYOUT_BANNER_2XN:
                        case LAYOUT_BANNER_3XN:
                        case LAYOUT_SQUARE_BANNER:
                        case LAYOUT_THIN_BANNER:
                        case LAYOUT_COLLAGE_3X:
                        case LAYOUT_COLLAGE_5X:
                        case LAYOUT_H1_BANNER:
                        case LAYOUT_SMART_ICON_GRID:
                        case LAYOUT_BANNER_WITH_ROW:
                        case LAYOUT_STORE_BANNER_ROW:
                        case LAYOUT_STORE_PRODUCT_ROW:
                        case LAYOUT_CAROUSEL4:
                        case LAYOUT_STORE_BANNER_WITH_BANNER_ROW:
                        case LAYOUT_INFINITE_GRID:
                        case LAYOUT_CIRCULAR_PROGRESS_BAR:
                            if (next2.getHomePageItemList().size() <= 0) {
                                break;
                            } else {
                                arrayList.add(next2);
                                break;
                            }
                        case LAYOUT_ACCORDION_VIEW:
                            arrayList.add(next2);
                            break;
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<CJRHomePageLayoutV2> getPromotionImpression() {
        ArrayList<CJRHomePageLayoutV2> arrayList = new ArrayList<>();
        Iterator<CJRHomePageLayoutV2> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayoutV2 next = it2.next();
            int i2 = AnonymousClass1.$SwitchMap$net$one97$paytm$common$entity$shopping$LayoutType[LayoutType.fromName(next.getLayout()).ordinal()];
            if (i2 != 22) {
                switch (i2) {
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        break;
                }
            }
            if (next.getHomePageItemList().size() > 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public CJRHomePageLayoutV2 getLayoutFromItem(CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem cJRHomePageItem2;
        try {
            Iterator<CJRHomePageLayoutV2> it2 = this.mHomePageLayoutList.iterator();
            while (it2.hasNext()) {
                CJRHomePageLayoutV2 next = it2.next();
                ArrayList<CJRHomePageItem> homePageItemList = next.getHomePageItemList();
                if (homePageItemList != null && cJRHomePageItem != null && homePageItemList.contains(cJRHomePageItem) && (cJRHomePageItem2 = homePageItemList.get(homePageItemList.indexOf(cJRHomePageItem))) != null && cJRHomePageItem2.getURLType() != null && cJRHomePageItem.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase(cJRHomePageItem.getURLType())) {
                    return next;
                }
            }
            return null;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public void setLayout(String str) {
        this.mLayout = str;
    }

    public String getFooterImageURL() {
        return this.mFooterImageURL;
    }

    public void setFooterImageURL(String str) {
        this.mFooterImageURL = str;
    }

    public CJRCategoryTree getMcategorytree() {
        return this.mcategorytree;
    }

    public void setMcategorytree(CJRCategoryTree cJRCategoryTree) {
        this.mcategorytree = cJRCategoryTree;
    }

    public String getmBadgeImageUrl() {
        return this.mBadgeImageUrl;
    }

    public void setmBadgeImageUrl(String str) {
        this.mBadgeImageUrl = str;
    }
}
