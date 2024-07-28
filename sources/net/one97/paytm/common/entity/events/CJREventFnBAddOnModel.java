package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventFnBAddOnModel implements IJRDataModel {
    @b(a = "conv_fee")
    private double convFees;
    @b(a = "id")
    private String id;
    @b(a = "image")
    private String image;
    @b(a = "inventory")
    private int inventory;
    @b(a = "item_description")
    private String itemDescription;
    @b(a = "item_min")
    private int itemMin;
    @b(a = "item_name")
    private String itemName;
    @b(a = "item_params")
    private ArrayList<CJREventAddOnItemParamsModel> itemParams;
    @b(a = "items_available")
    private int itemsAvailable;
    @b(a = "price")
    private int price;
    @b(a = "provider_item_id")
    private String providerItemId;
    private int selectedQty = 0;
    private String selectedSize = null;

    public double getConvFees() {
        return 0.0d;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getInventory() {
        return this.inventory;
    }

    public void setInventory(int i2) {
        this.inventory = i2;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int i2) {
        this.price = i2;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(String str) {
        this.itemDescription = str;
    }

    public int getItemsAvailable() {
        return this.itemsAvailable;
    }

    public void setItemsAvailable(int i2) {
        this.itemsAvailable = i2;
    }

    public String getProviderItemId() {
        return this.providerItemId;
    }

    public void setProviderItemId(String str) {
        this.providerItemId = str;
    }

    public int getItemMin() {
        return this.itemMin;
    }

    public void setItemMin(int i2) {
        this.itemMin = i2;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public ArrayList<CJREventAddOnItemParamsModel> getItemParams() {
        return this.itemParams;
    }

    public void setItemParams(ArrayList<CJREventAddOnItemParamsModel> arrayList) {
        this.itemParams = arrayList;
    }

    public int getSelectedQty() {
        return this.selectedQty;
    }

    public void setSelectedQty(int i2) {
        this.selectedQty = i2;
        updateSelectedParamsToZero();
    }

    public void setConvFees(double d2) {
        this.convFees = d2;
    }

    public void increaseSelectedQtyByOne() {
        this.selectedQty++;
        int i2 = this.selectedQty;
        int i3 = this.itemsAvailable;
        if (i2 > i3) {
            i2 = i3;
        }
        this.selectedQty = i2;
    }

    public void decreaseSelectedQtyByOne() {
        this.selectedQty--;
        int i2 = this.selectedQty;
        if (i2 < 0) {
            i2 = 0;
        }
        this.selectedQty = i2;
        updateSelectedParamsToZero();
    }

    private void updateSelectedParamsToZero() {
        if (this.selectedQty <= 0) {
            ArrayList<CJREventAddOnItemParamsModel> arrayList = this.itemParams;
            if (arrayList != null && arrayList.size() > 0) {
                this.itemParams.get(0).setSelectedValue((String) null);
            }
            this.selectedSize = null;
        }
    }

    public String getSelectedSize() {
        return this.selectedSize;
    }

    public void setSelectedSize(String str) {
        this.selectedSize = str;
    }
}
