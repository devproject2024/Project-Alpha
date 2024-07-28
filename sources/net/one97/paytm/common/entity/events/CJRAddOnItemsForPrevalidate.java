package net.one97.paytm.common.entity.events;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAddOnItemsForPrevalidate implements IJRDataModel {
    private String count;
    private String imageUrl;
    private String itemId;
    private String itemName;
    private String pricePerItem;
    private String providerItemId;
    private ArrayList<SelectedAddonProductDetailForPrevalidate> selection;

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getPricePerItem() {
        return this.pricePerItem;
    }

    public void setPricePerItem(String str) {
        this.pricePerItem = str;
    }

    public String getProviderItemId() {
        return this.providerItemId;
    }

    public void setProviderItemId(String str) {
        this.providerItemId = str;
    }

    public ArrayList<SelectedAddonProductDetailForPrevalidate> getSelection() {
        return this.selection;
    }

    public void setSelection(ArrayList<SelectedAddonProductDetailForPrevalidate> arrayList) {
        this.selection = arrayList;
    }
}
