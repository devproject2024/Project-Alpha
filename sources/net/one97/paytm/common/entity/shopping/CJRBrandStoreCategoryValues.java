package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrandStoreCategoryValues implements IJRDataModel {
    @b(a = "count")
    private String mCategoryCount;
    @b(a = "id")
    private String mCategoryId;
    @b(a = "name")
    private String mCategoryName;
    private boolean mIsCategoryAndIsLeaf;
    private boolean mIsClicked;
    private boolean mIsDeleted;
    private boolean mIsExpanded;
    private boolean mIsLastLeafNode;
    private boolean mIsLastSelected;
    private boolean mIsLeafNode;
    private boolean mIsMainCategory;
    private boolean mIsSubCategory;
    private int mLevel;
    private CJRBrandStoreCategoryValues mParent;
    @b(a = "cats")
    private ArrayList<CJRBrandStoreCategoryValues> mValues;

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    public ArrayList<CJRBrandStoreCategoryValues> getValues() {
        return this.mValues;
    }

    public void setValues(ArrayList<CJRBrandStoreCategoryValues> arrayList) {
        this.mValues = arrayList;
    }

    public String getCategoryCount() {
        return this.mCategoryCount;
    }

    public void setCategoryCount(String str) {
        this.mCategoryCount = str;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public boolean isCategoryAndIsLeaf() {
        return this.mIsCategoryAndIsLeaf;
    }

    public void setIsCategoryAndIsLeaf(boolean z) {
        this.mIsCategoryAndIsLeaf = z;
    }

    public boolean isLeafNode() {
        return this.mIsLeafNode;
    }

    public void setIsLeafNode(boolean z) {
        this.mIsLeafNode = z;
    }

    public boolean isSubCategory() {
        return this.mIsSubCategory;
    }

    public void setIsSubCategory(boolean z) {
        this.mIsSubCategory = z;
    }

    public boolean isMainCategory() {
        return this.mIsMainCategory;
    }

    public void setIsMainCategory(boolean z) {
        this.mIsMainCategory = z;
    }

    public boolean isClicked() {
        return this.mIsClicked;
    }

    public void setIsClicked(boolean z) {
        this.mIsClicked = z;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public void setLevel(int i2) {
        this.mLevel = i2;
    }

    public CJRBrandStoreCategoryValues getParent() {
        return this.mParent;
    }

    public void setParent(CJRBrandStoreCategoryValues cJRBrandStoreCategoryValues) {
        this.mParent = cJRBrandStoreCategoryValues;
    }

    public boolean isExpanded() {
        return this.mIsExpanded;
    }

    public void setIsExpanded(boolean z) {
        this.mIsExpanded = z;
    }

    public boolean isDeleted() {
        return this.mIsDeleted;
    }

    public void setIsDeleted(boolean z) {
        this.mIsDeleted = z;
    }

    public boolean isLastSelected() {
        return this.mIsLastSelected;
    }

    public void setIsLastSelected(boolean z) {
        this.mIsLastSelected = z;
    }

    public boolean isLastLeafNode() {
        return this.mIsLastLeafNode;
    }

    public void setIsLastLeafNode(boolean z) {
        this.mIsLastLeafNode = z;
    }
}
