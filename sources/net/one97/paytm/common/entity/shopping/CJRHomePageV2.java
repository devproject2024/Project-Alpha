package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRHomePageV2 extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "alt_image_url")
    private String alt_image_url;
    @b(a = "api_version")
    private String apiVersion;
    @b(a = "name")
    private String banner_name;
    @b(a = "context")
    public CJRContext cjrContext;
    @b(a = "contextParams")
    private HashMap<String, String> contextParam;
    private boolean dataFromCache;
    @b(a = "description")
    private String description;
    private String entityAssociatedWith;
    @b(a = "has_more")
    private boolean hasMore;
    @b(a = "image_url")
    private String image_url;
    public boolean isOrderDetailsExpanded;
    @b(a = "entity_type")
    private String mEntity;
    @b(a = "entity_associated_with")
    private long mEntityAssociatedWith;
    @b(a = "error")
    private String mErrorMsg;
    @b(a = "footer_image_url")
    private String mFooterImage;
    @b(a = "ga_key")
    public String mGAKey;
    private String mGATitle;
    @b(a = "page_id")
    private String mID = "";
    @b(a = "mobile_layout")
    public ArrayList<CJRHomePageLayoutV2> mMobileLayout = new ArrayList<>();
    @b(a = "old_category_id")
    private String mOldCategoryId;
    @b(a = "page")
    public ArrayList<CJRHomePageDetailV2> mPage = new ArrayList<>();
    @b(a = "pages")
    public ArrayList<CJRHomePageDetailV2> mPages = new ArrayList<>();
    @b(a = "placeholder_image_url")
    public String mPlaceHolderImageUrl;
    @b(a = "page_name")
    private String pageName;
    @b(a = "totalViewCount")
    private String totalViewCount;
    @b(a = "url_key")
    private String urlKey;

    public String getName() {
        return null;
    }

    public ArrayList<CJRHomePageDetailV2> getmPages() {
        return this.mPages;
    }

    public void setmPages(ArrayList<CJRHomePageDetailV2> arrayList) {
        this.mPages = arrayList;
    }

    public ArrayList<CJRHomePageDetailV2> getmPage() {
        return this.mPage;
    }

    public void setmPage(ArrayList<CJRHomePageDetailV2> arrayList) {
        this.mPage = arrayList;
    }

    public boolean getDataFromCache() {
        return this.dataFromCache;
    }

    public void setDataFromCache(boolean z) {
        this.dataFromCache = z;
    }

    public HashMap<String, String> getContextParam() {
        return this.contextParam;
    }

    public long getEntityId() {
        return this.mEntityAssociatedWith;
    }

    public String getEntity() {
        return this.mEntity;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
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

    public ArrayList<CJRHomePageLayoutV2> getMobileLayoutList() {
        return this.mMobileLayout;
    }

    public String getFooterImage() {
        return this.mFooterImage;
    }

    public void setFooterImageUrl(String str) {
        this.mFooterImage = str;
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
        return this.mID;
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

    public boolean hasMore() {
        return this.hasMore;
    }

    public String getTotalViewCount() {
        return this.totalViewCount;
    }

    public ArrayList<CJRHomePageItem> getParentListForItem(String str, CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem cJRHomePageItem2;
        new ArrayList();
        Iterator<CJRHomePageDetailV2> it2 = this.mPage.iterator();
        while (it2.hasNext()) {
            Iterator<CJRHomePageLayoutV2> it3 = it2.next().getHomePageLayoutList().iterator();
            while (true) {
                if (it3.hasNext()) {
                    CJRHomePageLayoutV2 next = it3.next();
                    ArrayList<CJRHomePageItem> homePageItemList = next.getHomePageItemList();
                    if (homePageItemList.contains(cJRHomePageItem) && (cJRHomePageItem2 = homePageItemList.get(homePageItemList.indexOf(cJRHomePageItem))) != null && cJRHomePageItem2.getParentItem() != null && cJRHomePageItem.getParentItem() != null && cJRHomePageItem2.getParentItem().equalsIgnoreCase(cJRHomePageItem.getParentItem())) {
                        return next.getHomePageItemList();
                    }
                }
            }
        }
        return null;
    }

    public CJRHomePageLayoutV2 getLayoutFromItem(CJRHomePageItem cJRHomePageItem) {
        CJRHomePageItem cJRHomePageItem2;
        try {
            Iterator<CJRHomePageDetailV2> it2 = this.mPage.iterator();
            while (it2.hasNext()) {
                Iterator<CJRHomePageLayoutV2> it3 = it2.next().getHomePageLayoutList().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        CJRHomePageLayoutV2 next = it3.next();
                        ArrayList<CJRHomePageItem> homePageItemList = next.getHomePageItemList();
                        if (homePageItemList != null && cJRHomePageItem != null && homePageItemList.contains(cJRHomePageItem) && (cJRHomePageItem2 = homePageItemList.get(homePageItemList.indexOf(cJRHomePageItem))) != null && cJRHomePageItem2.getURLType() != null && cJRHomePageItem.getURLType() != null && cJRHomePageItem2.getURLType().equalsIgnoreCase(cJRHomePageItem.getURLType())) {
                            return next;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public String getPageName() {
        return this.pageName;
    }
}
