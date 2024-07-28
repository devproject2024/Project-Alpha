package net.one97.paytm.common.entity.shopping;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;

public class CJRCatalogItem extends CJRItem {
    private static final long serialVersionUID = 1;
    private boolean extra_view;
    @b(a = "brand")
    private String mBrand;
    @b(a = "category_id")
    private String mCategoryId;
    @b(a = "image_data")
    private String mImageData;
    @b(a = "image_url")
    private String mImageIconUrl;
    private boolean mIsSelected;
    @b(a = "label")
    private String mLabel;
    private String mListId = "";
    @b(a = "name")
    private String mName;
    transient ArrayList<String> mParentName;
    @b(a = "related_category")
    private ArrayList<CJRRelatedCategory> mRelatedCategories = new ArrayList<>();
    @b(a = "seourl")
    private String mSeoUrl;
    @b(a = "items")
    private ArrayList<CJRCatalogItem> mSubItems;
    @b(a = "tag_label_color")
    private String mTagColor;
    @b(a = "tag_label_name")
    private String mTagLabel;
    @b(a = "url")
    private String mUrl;
    @b(a = "url_type")
    private String mUrlType;
    public int position;

    public String getItemID() {
        return null;
    }

    public String getListName() {
        return null;
    }

    public String getParentID() {
        return "";
    }

    public String getSearchABValue() {
        return null;
    }

    public String getSearchCategory() {
        return null;
    }

    public String getSearchResultType() {
        return null;
    }

    public String getSearchTerm() {
        return null;
    }

    public String getSearchType() {
        return null;
    }

    public String getSource() {
        return null;
    }

    public String getmContainerInstanceID() {
        return "";
    }

    public boolean isExtra_view() {
        return this.extra_view;
    }

    public void setExtra_view(boolean z) {
        this.extra_view = z;
    }

    public String getTagLabel() {
        return this.mTagLabel;
    }

    public void setTagLabel(String str) {
        this.mTagLabel = str;
    }

    public String getTagColor() {
        return this.mTagColor;
    }

    public ArrayList<CJRCatalogItem> getSubItems() {
        return this.mSubItems;
    }

    public String getImageData() {
        return this.mImageData;
    }

    public void setImageData(String str) {
        this.mImageData = str;
    }

    public String getImageIconUrl() {
        return this.mImageIconUrl;
    }

    public void setImageIconUrl(String str) {
        this.mImageIconUrl = str;
    }

    public String getURLType() {
        return this.mUrlType;
    }

    public void setURLType(String str) {
        this.mUrlType = str;
    }

    public String getURL() {
        String str = this.mUrl;
        if (str == null || TextUtils.isEmpty(str)) {
            return this.mSeoUrl;
        }
        return this.mUrl;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public void setBrand(String str) {
        this.mBrand = str;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setSelected(boolean z) {
        this.mIsSelected = z;
    }

    public void setTagLabelColor(String str) {
        this.mTagColor = str;
    }

    public boolean equals(Object obj) {
        try {
            return this.mName.equalsIgnoreCase(((CJRCatalogItem) obj).getName());
        } catch (Exception unused) {
            return false;
        }
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setmRelatedCategories(ArrayList<CJRRelatedCategory> arrayList) {
        this.mRelatedCategories = arrayList;
    }

    public ArrayList<CJRRelatedCategory> getRelatedCategories() {
        return this.mRelatedCategories;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public int getListPosition() {
        return this.position;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public ArrayList<String> getParentName() {
        return this.mParentName;
    }

    public void setParentName(ArrayList<String> arrayList) {
        this.mParentName = arrayList;
    }

    public void setParentNameItems(ArrayList<String> arrayList) {
        this.mParentName = arrayList;
        ArrayList<CJRCatalogItem> arrayList2 = this.mSubItems;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = this.mSubItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.mParentName);
                arrayList3.add(this.mName);
                this.mSubItems.get(i2).setParentNameItems(arrayList3);
            }
        }
    }

    public String getListId() {
        return this.mListId;
    }

    public void setListId(String str) {
        this.mListId = str;
    }
}
