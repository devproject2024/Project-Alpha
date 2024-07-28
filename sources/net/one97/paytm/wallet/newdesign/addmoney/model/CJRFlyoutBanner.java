package net.one97.paytm.wallet.newdesign.addmoney.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;

public class CJRFlyoutBanner extends IJRPaytmDataModel {
    public ArrayList<Page> page;
    public String page_id;

    public static class Items {
        public String id;
        public String image_url;
        public String name;
        public String priority;
        public String seourl;
        public String url;
        public String url_info;
        public String url_type;
    }

    public static class Page {
        public String id;
        public ArrayList<Views> views;

        public Page(String str) {
            this.id = str;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof Page) && this.id.equals(((Page) obj).id);
        }
    }

    public static class Views {
        public String id;
        public ArrayList<CJRHomePageItem> items;

        public Views(String str) {
            this.id = str;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof Views) && this.id.equals(((Views) obj).id);
        }
    }
}
