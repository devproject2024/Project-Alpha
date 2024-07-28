package net.one97.paytm.fastag.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class CJRActiveMetroTicketModel extends IJRPaytmDataModel implements Cloneable {
    private String balanceAmount;
    private int balanceTrips;
    private String destination;
    private String expiryDate;
    private String expiryTime;
    private boolean isOfflineData;
    private boolean isPass;
    private String logoUrl;
    @b(a = "order_id")
    private String orderId;
    private String passId;
    private long productId;
    private String productType;
    private List<CJRActiveMetroTicketQRItemModel> qrCodes;
    private String source;
    private String totalAmount;
    private int totalTrips;
    private String type;
    private String valid;
    private String validity;

    public String getValid() {
        String str = this.valid;
        return str == null ? "" : str;
    }

    public String getValidity() {
        return this.validity;
    }

    public String getDestination() {
        return this.destination;
    }

    public List<CJRActiveMetroTicketQRItemModel> getQrCodes() {
        return this.qrCodes;
    }

    public String getSource() {
        return this.source;
    }

    public String getType() {
        return this.type;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public long getProductId() {
        List<CJRActiveMetroTicketQRItemModel> list;
        if (this.productId == 0 && (list = this.qrCodes) != null && list.size() > 0) {
            this.productId = this.qrCodes.get(0).getProductId();
        }
        return this.productId;
    }

    public String getPassId() {
        return this.passId;
    }

    public String getOrderId() {
        List<CJRActiveMetroTicketQRItemModel> list;
        if (TextUtils.isEmpty(this.orderId) && (list = this.qrCodes) != null && list.size() > 0) {
            this.orderId = this.qrCodes.get(0).getOrderId();
        }
        return this.orderId;
    }

    public int getTotalTrips() {
        return this.totalTrips;
    }

    public int getBalanceTrips() {
        return this.balanceTrips;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getBalanceAmount() {
        return this.balanceAmount;
    }

    public String getExpiryTime() {
        String str = this.expiryTime;
        return str == null ? "" : str;
    }

    public String getProductType() {
        return TextUtils.isEmpty(this.productType) ? this.type : this.productType;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public void setBalanceAmount(String str) {
        this.balanceAmount = str;
    }

    public void setBalanceTrips(int i2) {
        this.balanceTrips = i2;
    }

    public boolean isPass() {
        return this.isPass;
    }

    public void setPass(boolean z) {
        this.isPass = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRActiveMetroTicketModel)) {
            return false;
        }
        CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) obj;
        return getOrderId().equalsIgnoreCase(cJRActiveMetroTicketModel.getOrderId()) && getProductType().equalsIgnoreCase(cJRActiveMetroTicketModel.getProductType()) && (TextUtils.isEmpty(this.source) || (!TextUtils.isEmpty(this.source) && !TextUtils.isEmpty(cJRActiveMetroTicketModel.source) && this.source.equalsIgnoreCase(cJRActiveMetroTicketModel.source) && !TextUtils.isEmpty(this.destination) && !TextUtils.isEmpty(cJRActiveMetroTicketModel.destination) && this.destination.equalsIgnoreCase(cJRActiveMetroTicketModel.destination)));
    }

    public CJRActiveMetroTicketModel clone() throws CloneNotSupportedException {
        CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) super.clone();
        List<CJRActiveMetroTicketQRItemModel> list = cJRActiveMetroTicketModel.qrCodes;
        if (list != null) {
            cJRActiveMetroTicketModel.qrCodes = new ArrayList(list);
        }
        return cJRActiveMetroTicketModel;
    }

    public boolean isOfflineData() {
        return this.isOfflineData;
    }

    public void setOfflineData(boolean z) {
        this.isOfflineData = z;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }
}
