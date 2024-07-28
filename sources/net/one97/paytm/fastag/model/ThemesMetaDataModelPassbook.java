package net.one97.paytm.fastag.model;

import com.paytm.network.model.IJRPaytmDataModel;

public class ThemesMetaDataModelPassbook extends IJRPaytmDataModel {
    private String additionalCharges;
    private String amount;
    private String category;
    private String description;
    private String hasMoreThemes;
    private String id = "";
    private boolean isSelected = false;
    private ThemesIconsDataModel metadata = new ThemesIconsDataModel();
    private String paid;
    private String subCategory;
    private String themeName;

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public ThemesIconsDataModel getThemes() {
        return this.metadata;
    }

    public void setThemes(ThemesIconsDataModel themesIconsDataModel) {
        this.metadata = themesIconsDataModel;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getThemeName() {
        return this.themeName;
    }

    public void setThemeName(String str) {
        this.themeName = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getAdditionalCharges() {
        return this.additionalCharges;
    }

    public void setAdditionalCharges(String str) {
        this.additionalCharges = str;
    }

    public String getHasMoreThemes() {
        return this.hasMoreThemes;
    }

    public void setHasMoreThemes(String str) {
        this.hasMoreThemes = str;
    }

    public String getPaid() {
        return this.paid;
    }

    public void setPaid(String str) {
        this.paid = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public void setSubCategory(String str) {
        this.subCategory = str;
    }
}
