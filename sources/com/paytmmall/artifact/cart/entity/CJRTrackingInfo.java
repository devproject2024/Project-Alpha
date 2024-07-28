package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrackingInfo extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "container_id")
    private String mContainerID;
    @b(a = "experimentName")
    private String mExperimentName;
    @b(a = "list_id_type")
    private String mListId;
    @b(a = "list_name")
    private String mListName;
    @b(a = "list_position")
    private int mListPosition;
    @b(a = "originGAData")
    private CJROriginGAData mOriginGaData;
    @b(a = "parent_id")
    private String mParentId;
    @b(a = "search_ab_value")
    private String mSearchABValue;
    @b(a = "search_category")
    private String mSearchCategory;
    @b(a = "search_result_type")
    private String mSearchResultType;
    @b(a = "search_term")
    private String mSearchTerm;
    @b(a = "search_type")
    private String mSearchType;
    @b(a = "source_container_id")
    private String mSourceContainerId;
    @b(a = "source_container_instance_id")
    private String mSourceContainerInstanceId;
    @b(a = "source_id")
    private String mSourceId;
    @b(a = "source_position")
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
