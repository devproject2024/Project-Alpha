package net.one97.paytm.common.entity.wallet.postcard.data;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class ThemesIconsDataModel implements IJRDataModel {
    private ArrayList<IconMetaDataModel> applicationView = new ArrayList<>();
    private ArrayList<IconMetaDataModel> passbookView = new ArrayList<>();
    private ArrayList<IconMetaDataModel> pushView = new ArrayList<>();
    private ArrayList<IconMetaDataModel> summaryView = new ArrayList<>();
    private ArrayList<IconMetaDataModel> thumbnailView = new ArrayList<>();

    public ArrayList<IconMetaDataModel> getThumbnailView() {
        return this.thumbnailView;
    }

    public void setThumbnailView(ArrayList<IconMetaDataModel> arrayList) {
        this.thumbnailView = arrayList;
    }

    public ArrayList<IconMetaDataModel> getPassbookView() {
        return this.passbookView;
    }

    public void setPassbookView(ArrayList<IconMetaDataModel> arrayList) {
        this.passbookView = arrayList;
    }

    public ArrayList<IconMetaDataModel> getPushView() {
        return this.pushView;
    }

    public void setPushView(ArrayList<IconMetaDataModel> arrayList) {
        this.pushView = arrayList;
    }

    public ArrayList<IconMetaDataModel> getSummaryView() {
        return this.summaryView;
    }

    public void setSummaryView(ArrayList<IconMetaDataModel> arrayList) {
        this.summaryView = arrayList;
    }

    public ArrayList<IconMetaDataModel> getApplicationView() {
        return this.applicationView;
    }

    public void setApplicationView(ArrayList<IconMetaDataModel> arrayList) {
        this.applicationView = arrayList;
    }
}
