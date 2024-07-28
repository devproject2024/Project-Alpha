package net.one97.paytm.o2o.movies.common.movies.seats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRObjSeat implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRObjSeat> CREATOR = new Parcelable.Creator<CJRObjSeat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRObjSeat[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRObjSeat(parcel);
        }
    };
    @b(a = "GridSeatNum")
    private int GridSeatNum;
    @b(a = "SeatStatus")
    private String SeatStatus;
    private String areaCircleName;
    private String areaCode;
    private String areaDesc;
    private String gridSeatAreaNum;
    private int gridSeatRowId;
    private int mAreaAvailableCount;
    private String phyRowId;
    private double price;
    @b(a = "seatNumber")
    private int seatNumber;
    private boolean selected;
    private String typeCode;
    private double voucherPrice;

    public int describeContents() {
        return 0;
    }

    public int getGridSeatNum() {
        return this.GridSeatNum;
    }

    public String getSeatStatus() {
        return this.SeatStatus;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double d2) {
        this.price = d2;
    }

    public int getGridSeatRowId() {
        return this.gridSeatRowId;
    }

    public void setGridSeatRowId(int i2) {
        this.gridSeatRowId = i2;
    }

    public String getGridSeatAreaNum() {
        return !TextUtils.isEmpty(this.gridSeatAreaNum) ? this.gridSeatAreaNum : "";
    }

    public void setGridSeatAreaNum(String str) {
        this.gridSeatAreaNum = str;
    }

    public String getAreaCode() {
        return !TextUtils.isEmpty(this.areaCode) ? this.areaCode : "";
    }

    public void setAreaCode(String str) {
        this.areaCode = str;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public String getUniqueId() {
        return getAreaCode() + getGridSeatAreaNum() + getGridSeatRowId() + getGridSeatNum();
    }

    public String getAreaDesc() {
        return this.areaDesc;
    }

    public void setAreaDesc(String str) {
        this.areaDesc = str;
    }

    public String getPhyRowId() {
        return this.phyRowId;
    }

    public void setPhyRowId(String str) {
        this.phyRowId = str;
    }

    public void setAreaCirclename(String str) {
        this.areaCircleName = str;
    }

    public String getAreaCircleName() {
        return this.areaCircleName;
    }

    public void setAreaAvailableCount(int i2) {
        this.mAreaAvailableCount = i2;
    }

    public int getAreaAvailableCount() {
        return this.mAreaAvailableCount;
    }

    public double getVoucherPrice() {
        return this.voucherPrice;
    }

    public void setVoucherPrice(double d2) {
        this.voucherPrice = d2;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSeatStatus(String str) {
        this.SeatStatus = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.GridSeatNum);
        parcel.writeString(this.SeatStatus);
        parcel.writeInt(this.seatNumber);
        parcel.writeDouble(this.price);
        parcel.writeDouble(this.voucherPrice);
        parcel.writeInt(this.gridSeatRowId);
        parcel.writeString(this.phyRowId);
        parcel.writeString(this.gridSeatAreaNum);
        parcel.writeString(this.areaCode);
        parcel.writeString(this.typeCode);
        parcel.writeString(this.areaDesc);
        parcel.writeString(this.areaCircleName);
        parcel.writeInt(this.mAreaAvailableCount);
        parcel.writeByte(this.selected ? (byte) 1 : 0);
    }

    public CJRObjSeat() {
    }

    protected CJRObjSeat(Parcel parcel) {
        this.GridSeatNum = parcel.readInt();
        this.SeatStatus = parcel.readString();
        this.seatNumber = parcel.readInt();
        this.price = parcel.readDouble();
        this.voucherPrice = parcel.readDouble();
        this.gridSeatRowId = parcel.readInt();
        this.phyRowId = parcel.readString();
        this.gridSeatAreaNum = parcel.readString();
        this.areaCode = parcel.readString();
        this.typeCode = parcel.readString();
        this.areaDesc = parcel.readString();
        this.areaCircleName = parcel.readString();
        this.mAreaAvailableCount = parcel.readInt();
        this.selected = parcel.readByte() != 0;
    }
}
