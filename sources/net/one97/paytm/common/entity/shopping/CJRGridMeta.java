package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGridMeta implements IJRDataModel {
    @b(a = "brand")
    private ArrayList<String> brand = new ArrayList<>();
    @b(a = "category")
    private ArrayList<String> categories = new ArrayList<>();
    @b(a = "classifier")
    private String classifier;
    @b(a = "experimentName")
    private String experimentName;
    @b(a = "filterCategory")
    private ArrayList<String> filterCategory = new ArrayList<>();
    @b(a = "query")
    private String query;
    @b(a = "queryRepairType")
    private String queryRepairType;
    @b(a = "spe")
    private SpellingMeta spe;
    @b(a = "version")
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

    public String getQueryRepairType() {
        return this.queryRepairType;
    }

    public void setQueryRepairType(String str) {
        this.queryRepairType = str;
    }

    class SpellingMeta {
        @b(a = "origQuery")
        private String origQuery;
        @b(a = "suggQuery")
        private String suggQuery;

        SpellingMeta() {
        }

        public String getSuggQuery() {
            return this.suggQuery;
        }

        public void setSuggQuery(String str) {
            this.suggQuery = str;
        }

        public String getOrigQuery() {
            return this.origQuery;
        }

        public void setOrigQuery(String str) {
            this.origQuery = str;
        }
    }
}
