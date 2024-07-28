package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Freebie implements Parcelable {
    public static final Parcelable.Creator<Freebie> CREATOR = new Parcelable.Creator<Freebie>() {
        public final Freebie createFromParcel(Parcel parcel) {
            return new Freebie(parcel);
        }

        public final Freebie[] newArray(int i2) {
            return new Freebie[i2];
        }
    };
    private String brand;
    private String imageUrl;
    private String name;
    private String offerPrice;
    private int pid;
    private boolean stock;

    public int describeContents() {
        return 0;
    }

    protected Freebie(Parcel parcel) {
        this.name = parcel.readString();
        this.offerPrice = parcel.readString();
        this.imageUrl = parcel.readString();
        this.stock = parcel.readInt() != 1 ? false : true;
        this.pid = parcel.readInt();
        this.brand = parcel.readString();
    }

    public Freebie(JSONObject jSONObject) {
        this.name = jSONObject.optString("name");
        this.offerPrice = jSONObject.optString(Item.KEY_OFFER_PRICE);
        this.imageUrl = jSONObject.optString("image_url");
        this.stock = jSONObject.optBoolean("stock");
        this.pid = jSONObject.optInt(CLPConstants.PRODUCT_ID);
        this.brand = jSONObject.optString(CLPConstants.BRAND_PARAMS);
    }

    public boolean isStock() {
        return this.stock;
    }

    public void setStock(boolean z) {
        this.stock = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getOfferPrice() {
        return this.offerPrice;
    }

    public void setOfferPrice(String str) {
        this.offerPrice = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.offerPrice);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.stock ? 1 : 0);
        parcel.writeInt(this.pid);
        parcel.writeString(this.brand);
    }

    public static List<Freebie> createFreebieArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(createInstance(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    LogUtility.printStackTrace(e2);
                }
            }
        }
        return arrayList;
    }

    private static Freebie createInstance(JSONObject jSONObject) {
        return new Freebie(jSONObject);
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int i2) {
        this.pid = i2;
    }

    public String getBrand() {
        return this.brand;
    }
}
