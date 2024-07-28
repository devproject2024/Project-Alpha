package net.one97.paytm.recharge.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;

public class BannerData extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "page")
    public ArrayList<BannerPage> bannerPage;

    public String getSource() {
        return null;
    }

    public class BannerPage implements IJRDataModel {
        @b(a = "views")
        public ArrayList<PaytmBannerView> bannerViews;
        public long id;

        public BannerPage() {
        }
    }

    public class PaytmBannerView implements IJRDataModel {
        @b(a = "items")
        public ArrayList<PaytmBannerItems> items;

        public PaytmBannerView() {
        }
    }

    public class PaytmBannerItems extends CJRItem {
        @b(a = "id")
        public Integer id;
        @b(a = "image_url")
        public String imageUrl;
        @b(a = "name")
        public String name;
        @b(a = "url_info")
        public String urlInfo;
        @b(a = "url_type")
        public String urlType;
        @b(a = "url")
        public String videoUrl;

        public String getBrand() {
            return "";
        }

        public String getCategoryId() {
            return "";
        }

        public String getLabel() {
            return "";
        }

        public String getListId() {
            return "";
        }

        public String getListName() {
            return "";
        }

        public int getListPosition() {
            return 0;
        }

        public String getParentID() {
            return "";
        }

        public ArrayList<CJRRelatedCategory> getRelatedCategories() {
            return null;
        }

        public String getSearchABValue() {
            return null;
        }

        public String getSearchCategory() {
            return "";
        }

        public String getSearchResultType() {
            return "";
        }

        public String getSearchTerm() {
            return "";
        }

        public String getSearchType() {
            return "";
        }

        public String getSource() {
            return null;
        }

        public String getmContainerInstanceID() {
            return "";
        }

        public PaytmBannerItems() {
        }

        public String getURLType() {
            return this.urlType;
        }

        public String getURL() {
            return this.videoUrl;
        }

        public String getName() {
            return this.name;
        }

        public String getItemID() {
            try {
                String num = Integer.toString(getId().intValue());
                if (!TextUtils.isEmpty(num)) {
                    return num;
                }
                return "";
            } catch (Exception e2) {
                q.d(e2.getMessage());
                return "";
            }
        }

        public Integer getId() {
            return this.id;
        }
    }
}
