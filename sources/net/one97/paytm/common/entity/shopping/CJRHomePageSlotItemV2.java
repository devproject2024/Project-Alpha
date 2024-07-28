package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;

public class CJRHomePageSlotItemV2 {
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
    @b(a = "link")
    private String mLink;
    @b(a = "mobile_layout")
    public ArrayList<CJRHomePageLayoutV2> mMobileLayout = new ArrayList<>();
    @b(a = "name")
    private String mName;
    @b(a = "attributes")
    private CJRLayoutDetailV2 mattribute;

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getmLink() {
        return this.mLink;
    }

    public void setmLink(String str) {
        this.mLink = str;
    }

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

    public CJRLayoutDetailV2 getmLayoutDetails() {
        return this.mLayoutDetails;
    }

    public void setmLayoutDetails(CJRLayoutDetailV2 cJRLayoutDetailV2) {
        this.mLayoutDetails = cJRLayoutDetailV2;
    }

    public CJRLayoutDetailV2 getMattribute() {
        return this.mattribute;
    }

    public void setMattribute(CJRLayoutDetailV2 cJRLayoutDetailV2) {
        this.mattribute = cJRLayoutDetailV2;
    }

    public ArrayList<CJRHomePageLayoutV2> getmMobileLayout() {
        return this.mMobileLayout;
    }

    public void setmMobileLayout(ArrayList<CJRHomePageLayoutV2> arrayList) {
        this.mMobileLayout = arrayList;
    }

    public void setmHomePageLayoutList(ArrayList<CJRHomePageLayoutV2> arrayList) {
        this.mHomePageLayoutList = arrayList;
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

    public ArrayList<CJRHomePageLayoutV2> pageRowItems(boolean z) {
        CJRHomePageItem cJRHomePageItem;
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
                switch (LayoutType.fromName(next2.getLayout())) {
                    case LAYOUT_PRODUCT_GRID:
                    case LAYOUT_BRAND_PRODUCT_ROW:
                        if (next2.getHomePageItemList().size() > 0 && (cJRHomePageItem = next2.getHomePageItemList().get(0)) != null && cJRHomePageItem.getMproducts() != null && cJRHomePageItem.getMproducts().size() > 0) {
                            arrayList.add(next2);
                            break;
                        }
                    case LAYOUT_PRODUCT_ROW:
                    case LAYOUT_CAROUSEL_1:
                    case LAYOUT_CAROUSEL1:
                    case LAYOUT_CAROUSEL_FULL_WIDTH:
                    case LAYOUT_CAROUSEL_ROW:
                    case LAYOUT_CAROUSEL_2:
                    case LAYOUT_VIDEO_COROUSEL:
                    case LAYOUT_PHOTO_COROUSEL:
                    case LAYOUT_SNIPPET_1:
                    case LAYOUT_SNIPPET_2:
                    case LAYOUT_CAROUSEL2:
                    case LAYOUT_SMART_LIST:
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

    public ArrayList<CJRHomePageLayoutV2> getPromotionImpression() {
        ArrayList<CJRHomePageLayoutV2> arrayList = new ArrayList<>();
        Iterator<CJRHomePageLayoutV2> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayoutV2 next = it2.next();
            int i2 = AnonymousClass1.$SwitchMap$net$one97$paytm$common$entity$shopping$LayoutType[LayoutType.fromName(next.getLayout()).ordinal()];
            if (!(i2 == 13 || i2 == 15)) {
                switch (i2) {
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        break;
                }
            }
            if (next.getHomePageItemList().size() > 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public ArrayList<CJRHomePageItem> getParentListForItem(String str, CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem cJRHomePageItem2;
        Iterator<CJRHomePageLayoutV2> it2 = this.mHomePageLayoutList.iterator();
        while (it2.hasNext()) {
            CJRHomePageLayoutV2 next = it2.next();
            ArrayList<CJRHomePageItem> homePageItemList = next.getHomePageItemList();
            if (homePageItemList.contains(cJRHomePageItem) && (cJRHomePageItem2 = homePageItemList.get(homePageItemList.indexOf(cJRHomePageItem))) != null && cJRHomePageItem2.getParentItem() != null && cJRHomePageItem.getParentItem() != null && cJRHomePageItem2.getParentItem().equalsIgnoreCase(cJRHomePageItem.getParentItem())) {
                return next.getHomePageItemList();
            }
        }
        return null;
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
}
