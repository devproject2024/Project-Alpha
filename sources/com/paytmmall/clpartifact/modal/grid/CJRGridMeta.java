package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;

public class CJRGridMeta implements Serializable {
    @c(a = "brand")
    private ArrayList<String> brand = new ArrayList<>();
    @c(a = "category")
    private ArrayList<String> categories = new ArrayList<>();
    @c(a = "classifier")
    private String classifier;
    @c(a = "experimentName")
    private String experimentName;
    @c(a = "filterCategory")
    private ArrayList<String> filterCategory = new ArrayList<>();
    @c(a = "query")
    private String query;
    @c(a = "version")
    private String version;

    public String getExperimentName() {
        return this.experimentName;
    }

    public ArrayList<String> getFilterCategory() {
        return this.filterCategory;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getClassifier() {
        return this.classifier;
    }

    public void setClassifier(String str) {
        this.classifier = str;
    }

    public void setExperimentName(String str) {
        this.experimentName = str;
    }

    public void setFilterCategory(ArrayList<String> arrayList) {
        this.filterCategory = arrayList;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public ArrayList<String> getBrand() {
        return this.brand;
    }

    public void setBrand(ArrayList<String> arrayList) {
        this.brand = arrayList;
    }

    public ArrayList<String> getCategories() {
        return this.categories;
    }

    public void setCategories(ArrayList<String> arrayList) {
        this.categories = arrayList;
    }
}
