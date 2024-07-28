package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRHomePage extends CJRDataModelItem {
    public static final String LAYOUT_HOME_PAGE_TABS = "tabs";
    private static final long serialVersionUID = 1;
    @b(a = "alt_image_url")
    private String alt_image_url;
    @b(a = "name")
    private String banner_name;
    @b(a = "description")
    private String description;
    @b(a = "entity_associated_with")
    private String entityAssociatedWith;
    @b(a = "image_url")
    private String image_url;
    public boolean isOrderDetailsExpanded;
    @b(a = "error")
    private String mErrorMsg;
    @b(a = "footer_image_url")
    private String mFooterImage;
    @b(a = "ga_key")
    public String mGAKey;
    private String mGATitle;
    @b(a = "homepage_layout")
    public ArrayList<CJRHomePageLayout> mHomePageLayoutList = new ArrayList<>();
    @b(a = "id")
    private String mID = "";
    @b(a = "mobile_layout")
    public ArrayList<CJRHomePageLayout> mMobileLayout = new ArrayList<>();
    @b(a = "old_category_id")
    private String mOldCategoryId;
    @b(a = "placeholder_image_url")
    public String mPlaceHolderImageUrl;
    @b(a = "url_key")
    private String urlKey;

    public String getName() {
        return null;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public void setmHomePageLayoutList(CJRHomePageLayout cJRHomePageLayout) {
        this.mHomePageLayoutList.add(cJRHomePageLayout);
    }

    public void setmHomePageLayoutList(ArrayList<CJRHomePageLayout> arrayList) {
        this.mHomePageLayoutList = arrayList;
    }

    public String getOldCategoryId() {
        return this.mOldCategoryId;
    }

    public String getID() {
        return this.mID;
    }

    public String getGAKey() {
        return this.mGAKey;
    }

    public ArrayList<CJRHomePageLayout> getMobileLayoutList() {
        return this.mMobileLayout;
    }

    public ArrayList<CJRHomePageLayout> getHomePageLayoutList() {
        return this.mHomePageLayoutList;
    }

    public void setHomePageLayoutList(ArrayList<CJRHomePageLayout> arrayList) {
        this.mHomePageLayoutList = arrayList;
    }

    public ArrayList<CJRHomePageItem> getItemsForLayout(String str) {
        Iterator<CJRHomePageLayout> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayout next = it2.next();
            if (next.getLayout().equalsIgnoreCase(str)) {
                return next.getHomePageItemList();
            }
        }
        return null;
    }

    public ArrayList<CJRHomePageItem> getItemsForProduct(String str) {
        Iterator<CJRHomePageLayout> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayout next = it2.next();
            if (next.getName().equalsIgnoreCase(str)) {
                return next.getHomePageItemList();
            }
        }
        return null;
    }

    public ArrayList<CJRHomePageLayout> pageRowItems(boolean z) {
        ArrayList<CJRHomePageLayout> arrayList = new ArrayList<>();
        if (z) {
            Iterator<CJRHomePageLayout> it2 = this.mMobileLayout.iterator();
            while (it2.hasNext()) {
                CJRHomePageLayout next = it2.next();
                if (next.getLayout().equalsIgnoreCase(LAYOUT_HOME_PAGE_TABS) && next.getHomePageItemList().size() > 0) {
                    arrayList.add(next);
                }
            }
        }
        Iterator<CJRHomePageLayout> it3 = this.mHomePageLayoutList.iterator();
        while (it3.hasNext()) {
            CJRHomePageLayout next2 = it3.next();
            if (next2.getLayout() != null) {
                switch (LayoutType.fromName(next2.getLayout())) {
                    case LAYOUT_PRODUCT_ROW:
                    case LAYOUT_PRODUCT_GRID:
                    case LAYOUT_CAROUSEL_1:
                    case LAYOUT_CAROUSEL1:
                    case LAYOUT_CAROUSEL_2:
                    case LAYOUT_CAROUSEL2:
                    case LAYOUT_SMART_LIST:
                    case LAYOUT_VIDEO_COROUSEL:
                    case LAYOUT_PHOTO_COROUSEL:
                    case LAYOUT_SNIPPET_2:
                    case LAYOUT_SNIPPET_1:
                        if (next2.getHomePageItemList().size() <= 0) {
                            break;
                        } else {
                            arrayList.add(next2);
                            break;
                        }
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
            }
        }
        return arrayList;
    }

    public ArrayList<CJRHomePageLayout> getPromotionImpression() {
        ArrayList<CJRHomePageLayout> arrayList = new ArrayList<>();
        Iterator<CJRHomePageLayout> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayout next = it2.next();
            int i2 = AnonymousClass1.$SwitchMap$net$one97$paytm$common$entity$shopping$LayoutType[LayoutType.fromName(next.getLayout()).ordinal()];
            if ((i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 12) && next.getHomePageItemList().size() > 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String getFooterImage() {
        return this.mFooterImage;
    }

    public void setFooterImageUrl(String str) {
        this.mFooterImage = str;
    }

    public ArrayList<CJRHomePageItem> getParentListForItem(String str, CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem cJRHomePageItem2;
        Iterator<CJRHomePageLayout> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayout next = it2.next();
            ArrayList<CJRHomePageItem> homePageItemList = next.getHomePageItemList();
            if (homePageItemList.contains(cJRHomePageItem) && (cJRHomePageItem2 = homePageItemList.get(homePageItemList.indexOf(cJRHomePageItem))) != null && cJRHomePageItem2.getParentItem() != null && cJRHomePageItem.getParentItem() != null && cJRHomePageItem2.getParentItem().equalsIgnoreCase(cJRHomePageItem.getParentItem())) {
                return next.getHomePageItemList();
            }
        }
        return null;
    }

    public CJRHomePageLayout getLayoutFromItem(CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem cJRHomePageItem2;
        try {
            Iterator<CJRHomePageLayout> it2 = this.mHomePageLayoutList.iterator();
            while (it2.hasNext()) {
                CJRHomePageLayout next = it2.next();
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

    public String getPlaceHolderImageUrl() {
        return this.mPlaceHolderImageUrl;
    }

    public String getGATitle() {
        return this.mGATitle;
    }

    public void setGATitle(String str) {
        this.mGATitle = str;
    }

    public String getEntityAssociatedWith() {
        return this.entityAssociatedWith;
    }

    public void setEntityAssociatedWith(String str) {
        this.entityAssociatedWith = str;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getUrlKey() {
        return this.urlKey;
    }

    public String getAlt_image_url() {
        return this.alt_image_url;
    }

    public String getDescription() {
        return this.description;
    }

    public String getBannerName() {
        return this.banner_name;
    }

    public boolean isOrderDetailsExpanded() {
        return this.isOrderDetailsExpanded;
    }

    public void setIsOrderDetailsExpanded(boolean z) {
        this.isOrderDetailsExpanded = z;
    }
}
