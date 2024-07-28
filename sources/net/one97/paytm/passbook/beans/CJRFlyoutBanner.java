package net.one97.paytm.passbook.beans;

import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRFlyoutBanner extends IJRDataModel {
    public ArrayList<Page> page;

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
        public ArrayList<Views> views;
    }

    public static class Views {
        public ArrayList<CJRHomePageItem> items;
    }
}
