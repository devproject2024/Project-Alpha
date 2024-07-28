package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBBankStoreFrontModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "alt_image_url")
    private Object altImageUrl;
    @b(a = "api_version")
    private Integer apiVersion;
    @b(a = "canonical_url")
    private String canonicalUrl;
    @b(a = "context")
    private Context context;
    @b(a = "contextParams")
    private ContextParams contextParams;
    @b(a = "entity_associated_with")
    private Integer entityAssociatedWith;
    @b(a = "entity_type")
    private String entityType;
    @b(a = "footer_image_url")
    private String footerImageUrl;
    @b(a = "ga_key")
    private String gaKey;
    @b(a = "long_rich_desc")
    private String longRichDesc;
    @b(a = "meta_description")
    private String metaDescription;
    @b(a = "meta_keyword")
    private String metaKeyword;
    @b(a = "meta_title")
    private String metaTitle;
    @b(a = "no_follow")
    private Boolean noFollow;
    @b(a = "no_index")
    private Boolean noIndex;
    @b(a = "page")
    private List<Page> page = null;
    @b(a = "page_id")
    private Integer pageId;
    @b(a = "page_name")
    private String pageName;
    @b(a = "placeholder_image_url")
    private String placeholderImageUrl;
    @b(a = "redirect")
    private Boolean redirect;
    @b(a = "redirect_url")
    private String redirectUrl;
    @b(a = "sub_api")
    private List<SubApus> subApi = null;

    public static class Attributes {
    }

    public static class ContextParams extends IJRPaytmDataModel {
    }

    public static class Layout extends IJRPaytmDataModel {
    }

    public static class LayoutDetails extends IJRPaytmDataModel {
    }

    public static class User extends IJRPaytmDataModel {
    }

    public Integer getPageId() {
        return this.pageId;
    }

    public void setPageId(Integer num) {
        this.pageId = num;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String str) {
        this.pageName = str;
    }

    public Integer getApiVersion() {
        return this.apiVersion;
    }

    public void setApiVersion(Integer num) {
        this.apiVersion = num;
    }

    public List<SubApus> getSubApi() {
        return this.subApi;
    }

    public void setSubApi(List<SubApus> list) {
        this.subApi = list;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public String getMetaDescription() {
        return this.metaDescription;
    }

    public void setMetaDescription(String str) {
        this.metaDescription = str;
    }

    public String getMetaKeyword() {
        return this.metaKeyword;
    }

    public void setMetaKeyword(String str) {
        this.metaKeyword = str;
    }

    public String getMetaTitle() {
        return this.metaTitle;
    }

    public void setMetaTitle(String str) {
        this.metaTitle = str;
    }

    public List<Page> getPage() {
        return this.page;
    }

    public void setPage(List<Page> list) {
        this.page = list;
    }

    public String getFooterImageUrl() {
        return this.footerImageUrl;
    }

    public void setFooterImageUrl(String str) {
        this.footerImageUrl = str;
    }

    public String getPlaceholderImageUrl() {
        return this.placeholderImageUrl;
    }

    public void setPlaceholderImageUrl(String str) {
        this.placeholderImageUrl = str;
    }

    public String getGaKey() {
        return this.gaKey;
    }

    public void setGaKey(String str) {
        this.gaKey = str;
    }

    public Object getAltImageUrl() {
        return this.altImageUrl;
    }

    public void setAltImageUrl(Object obj) {
        this.altImageUrl = obj;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String str) {
        this.entityType = str;
    }

    public Integer getEntityAssociatedWith() {
        return this.entityAssociatedWith;
    }

    public void setEntityAssociatedWith(Integer num) {
        this.entityAssociatedWith = num;
    }

    public String getLongRichDesc() {
        return this.longRichDesc;
    }

    public void setLongRichDesc(String str) {
        this.longRichDesc = str;
    }

    public Boolean getNoFollow() {
        return this.noFollow;
    }

    public void setNoFollow(Boolean bool) {
        this.noFollow = bool;
    }

    public Boolean getNoIndex() {
        return this.noIndex;
    }

    public void setNoIndex(Boolean bool) {
        this.noIndex = bool;
    }

    public Boolean getRedirect() {
        return this.redirect;
    }

    public void setRedirect(Boolean bool) {
        this.redirect = bool;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public String getCanonicalUrl() {
        return this.canonicalUrl;
    }

    public void setCanonicalUrl(String str) {
        this.canonicalUrl = str;
    }

    public ContextParams getContextParams() {
        return this.contextParams;
    }

    public void setContextParams(ContextParams contextParams2) {
        this.contextParams = contextParams2;
    }

    public static class CategoryWeight {
        @b(a = "category_id")
        private String categoryId;
        @b(a = "weight")
        private Integer weight;

        public Integer getWeight() {
            return this.weight;
        }

        public void setWeight(Integer num) {
            this.weight = num;
        }

        public String getCategoryId() {
            return this.categoryId;
        }

        public void setCategoryId(String str) {
            this.categoryId = str;
        }
    }

    public static class Context {
        @b(a = "user")
        private User user;

        public User getUser() {
            return this.user;
        }

        public void setUser(User user2) {
            this.user = user2;
        }
    }

    public static class Metadata extends IJRPaytmDataModel {
        @b(a = "category_weights")
        private List<CategoryWeight> categoryWeights = null;
        @b(a = "group_tag")
        private String groupTag;
        @b(a = "offer")
        private String offer;
        @b(a = "region")
        private List<Object> region = null;

        public List<CategoryWeight> getCategoryWeights() {
            return this.categoryWeights;
        }

        public void setCategoryWeights(List<CategoryWeight> list) {
            this.categoryWeights = list;
        }

        public List<Object> getRegion() {
            return this.region;
        }

        public void setRegion(List<Object> list) {
            this.region = list;
        }

        public String getGroupTag() {
            return this.groupTag;
        }

        public void setGroupTag(String str) {
            this.groupTag = str;
        }

        public String getOffer() {
            return this.offer;
        }

        public void setOffer(String str) {
            this.offer = str;
        }
    }

    public static class Page extends IJRPaytmDataModel {
        @b(a = "attributes")
        private Attributes attributes;
        @b(a = "id")
        private Integer id;
        @b(a = "layout")
        private String layout;
        @b(a = "layout_details")
        private LayoutDetails layoutDetails;
        @b(a = "views")
        private List<View> views = null;

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer num) {
            this.id = num;
        }

        public String getLayout() {
            return this.layout;
        }

        public void setLayout(String str) {
            this.layout = str;
        }

        public LayoutDetails getLayoutDetails() {
            return this.layoutDetails;
        }

        public void setLayoutDetails(LayoutDetails layoutDetails2) {
            this.layoutDetails = layoutDetails2;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        public void setAttributes(Attributes attributes2) {
            this.attributes = attributes2;
        }

        public List<View> getViews() {
            return this.views;
        }

        public void setViews(List<View> list) {
            this.views = list;
        }
    }

    public static class SubApus extends IJRPaytmDataModel {
        @b(a = "name")
        private String name;
        @b(a = "version")
        private Integer version;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public Integer getVersion() {
            return this.version;
        }

        public void setVersion(Integer num) {
            this.version = num;
        }
    }

    public static class View extends IJRPaytmDataModel {
        @b(a = "id")
        private Integer id;
        @b(a = "items")
        private List<PBCJRHomePageItem> items = null;
        @b(a = "layout")
        private Layout layout;
        @b(a = "priority")
        private Integer priority;
        @b(a = "seourl")
        private Object seourl;
        @b(a = "subtitle")
        private Object subtitle;
        @b(a = "title")
        private String title;
        @b(a = "type")
        private String type;

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer num) {
            this.id = num;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public Layout getLayout() {
            return this.layout;
        }

        public void setLayout(Layout layout2) {
            this.layout = layout2;
        }

        public Object getSubtitle() {
            return this.subtitle;
        }

        public void setSubtitle(Object obj) {
            this.subtitle = obj;
        }

        public Integer getPriority() {
            return this.priority;
        }

        public void setPriority(Integer num) {
            this.priority = num;
        }

        public Object getSeourl() {
            return this.seourl;
        }

        public void setSeourl(Object obj) {
            this.seourl = obj;
        }

        public List<PBCJRHomePageItem> getItems() {
            return this.items;
        }

        public void setItems(List<PBCJRHomePageItem> list) {
            this.items = list;
        }
    }
}
