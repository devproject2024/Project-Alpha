package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRTrackingInfo implements Serializable {
    private static final long serialVersionUID = 1;
    @c(a = "container_id")
    private String mContainerID;
    @c(a = "experimentName")
    private String mExperimentName;
    @c(a = "list_id_type")
    private String mListId;
    @c(a = "list_name")
    private String mListName;
    @c(a = "list_position")
    private int mListPosition;
    @c(a = "originGAData")
    private CJROriginGAData mOriginGaData;
    @c(a = "parent_id")
    private String mParentId;
    @c(a = "search_ab_value")
    private String mSearchABValue;
    @c(a = "search_category")
    private String mSearchCategory;
    @c(a = "search_result_type")
    private String mSearchResultType;
    @c(a = "search_term")
    private String mSearchTerm;
    @c(a = "search_type")
    private String mSearchType;
    @c(a = "source_container_id")
    private String mSourceContainerId;
    @c(a = "source_container_instance_id")
    private String mSourceContainerInstanceId;
    @c(a = "source_id")
    private String mSourceId;
    @c(a = "source_position")
    private String mSourcePosition;

    public String getContainerID() {
        return this.mContainerID;
    }

    public String getParentId() {
        return this.mParentId;
    }

    public String getListId() {
        return this.mListId;
    }

    public CJROriginGAData getOriginGaData() {
        return this.mOriginGaData;
    }

    public void setOriginGaData(CJROriginGAData cJROriginGAData) {
        this.mOriginGaData = cJROriginGAData;
    }

    public String getSearchType() {
        return this.mSearchType;
    }

    public void setSearchType(String str) {
        this.mSearchType = str;
    }

    public String getSearchCategory() {
        return this.mSearchCategory;
    }

    public void setSearchCategory(String str) {
        this.mSearchCategory = str;
    }

    public String getSearchTerm() {
        return this.mSearchTerm;
    }

    public void setSearchTerm(String str) {
        this.mSearchTerm = str;
    }

    public String getSearchResultType() {
        return this.mSearchResultType;
    }

    public String getmSourcePosition() {
        return this.mSourcePosition;
    }

    public String getmSourceId() {
        return this.mSourceId;
    }

    public String getmSourceContainerInstanceId() {
        return this.mSourceContainerInstanceId;
    }

    public String getmSourceContainerId() {
        return this.mSourceContainerId;
    }

    public void setSearchResultType(String str) {
        this.mSearchResultType = str;
    }

    public String getListName() {
        return this.mListName;
    }

    public void setListName(String str) {
        this.mListName = str;
    }

    public int getListPosition() {
        return this.mListPosition;
    }

    public void setListPosition(int i2) {
        this.mListPosition = i2;
    }

    public String getSearchABValue() {
        return this.mSearchABValue;
    }

    public void setSearchABValue(String str) {
        this.mSearchABValue = str;
    }

    public String getmExperimentName() {
        return this.mExperimentName;
    }

    public void setmExperimentName(String str) {
        this.mExperimentName = str;
    }
}
