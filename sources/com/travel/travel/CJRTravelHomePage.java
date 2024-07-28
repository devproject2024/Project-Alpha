package com.travel.travel;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRTravelHomePage extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "alt_image_url")
    private String alt_image_url;
    @b(a = "api_version")
    private String api_version;
    @b(a = "canonical_url")
    private String canonical_url;
    @b(a = "entity_associated_with")
    private String entity_associated_with;
    @b(a = "entity_type")
    private String entity_type;
    @b(a = "footer_image_url")
    private String footer_image_url;
    @b(a = "ga_key")
    private String ga_key;
    @b(a = "image_url")
    private String image_url;
    @b(a = "long_rich_desc")
    private String long_rich_desc;
    @b(a = "page")
    public ArrayList<CJRTravelSubPage> mCjrTravelSubPages = new ArrayList<>();
    @b(a = "error")
    private String mErrorMsg;
    @b(a = "meta_description")
    private String meta_description;
    @b(a = "meta_keyword")
    private String meta_keyword;
    @b(a = "meta_title")
    private String meta_title;
    @b(a = "no_follow")
    private String no_follow;
    @b(a = "no_index")
    private String no_index;
    @b(a = "page_id")
    private String page_id;
    @b(a = "page_name")
    private String page_name;
    @b(a = "placeholder_image_url")
    private String placeholder_image_url;
    @b(a = "redirect")
    private String redirect;
    @b(a = "redirect_url")
    private String redirect_url;
    @b(a = "layout")
    private a rootLayout;

    public class a {
        @b(a = "bg_image_url")

        /* renamed from: a  reason: collision with root package name */
        public String f28406a;
    }

    public String getName() {
        return null;
    }

    public a getRootLayout() {
        return this.rootLayout;
    }

    public void setRootLayout(a aVar) {
        this.rootLayout = aVar;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getPage_id() {
        return this.page_id;
    }

    public void setPage_id(String str) {
        this.page_id = str;
    }

    public String getPage_name() {
        return this.page_name;
    }

    public void setPage_name(String str) {
        this.page_name = str;
    }

    public String getApi_version() {
        return this.api_version;
    }

    public void setApi_version(String str) {
        this.api_version = str;
    }

    public String getMeta_description() {
        return this.meta_description;
    }

    public void setMeta_description(String str) {
        this.meta_description = str;
    }

    public String getMeta_keyword() {
        return this.meta_keyword;
    }

    public void setMeta_keyword(String str) {
        this.meta_keyword = str;
    }

    public String getMeta_title() {
        return this.meta_title;
    }

    public void setMeta_title(String str) {
        this.meta_title = str;
    }

    public String getFooter_image_url() {
        return this.footer_image_url;
    }

    public void setFooter_image_url(String str) {
        this.footer_image_url = str;
    }

    public String getPlaceholder_image_url() {
        return this.placeholder_image_url;
    }

    public void setPlaceholder_image_url(String str) {
        this.placeholder_image_url = str;
    }

    public String getGa_key() {
        return this.ga_key;
    }

    public void setGa_key(String str) {
        this.ga_key = str;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public String getAlt_image_url() {
        return this.alt_image_url;
    }

    public void setAlt_image_url(String str) {
        this.alt_image_url = str;
    }

    public String getEntity_type() {
        return this.entity_type;
    }

    public void setEntity_type(String str) {
        this.entity_type = str;
    }

    public String getEntity_associated_with() {
        return this.entity_associated_with;
    }

    public void setEntity_associated_with(String str) {
        this.entity_associated_with = str;
    }

    public String getLong_rich_desc() {
        return this.long_rich_desc;
    }

    public void setLong_rich_desc(String str) {
        this.long_rich_desc = str;
    }

    public String getNo_follow() {
        return this.no_follow;
    }

    public void setNo_follow(String str) {
        this.no_follow = str;
    }

    public String getNo_index() {
        return this.no_index;
    }

    public void setNo_index(String str) {
        this.no_index = str;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public void setRedirect(String str) {
        this.redirect = str;
    }

    public String getRedirect_url() {
        return this.redirect_url;
    }

    public void setRedirect_url(String str) {
        this.redirect_url = str;
    }

    public String getCanonical_url() {
        return this.canonical_url;
    }

    public void setCanonical_url(String str) {
        this.canonical_url = str;
    }

    public String getmErrorMsg() {
        return this.mErrorMsg;
    }

    public void setmErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public ArrayList<CJRTravelSubPage> getmCjrTravelSubPages() {
        return this.mCjrTravelSubPages;
    }

    public void setmCjrTravelSubPages(ArrayList<CJRTravelSubPage> arrayList) {
        this.mCjrTravelSubPages = arrayList;
    }
}
