package com.paytmmall.clpartifact.utils;

import com.google.gson.a.c;
import com.google.gson.f;

public class GAImpression {
    @c(a = "category")
    private String category;
    @c(a = "dimension52")
    private String dimension52;
    @c(a = "dimension80")
    private boolean dimension80;
    @c(a = "dimension25")
    private String mDimension25;
    @c(a = "dimension40")
    private String mDimension40;
    @c(a = "dimension43")
    private String mDimension43;
    @c(a = "dimension67")
    private String mDimension67;
    @c(a = "dimension79")
    private Dimension79 mDimension79;
    @c(a = "dimension24")
    private String mDimesion24;
    @c(a = "dimension38")
    private String mDimesion38;
    @c(a = "dimension39")
    private String mDimesion39;
    @c(a = "dimension41")
    private String mDimesion41;
    @c(a = "dimension70")
    private String mDimesion70;
    @c(a = "id")
    private String mId;
    @c(a = "list")
    private String mList;
    @c(a = "name")
    private String mName;
    @c(a = "position")
    private String mPosition;
    @c(a = "price")
    private String mPrice;
    @c(a = "brand")
    private String mbrand;

    public String getDimension52() {
        return this.dimension52;
    }

    public void setDimension52(String str) {
        this.dimension52 = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public boolean isDimension80() {
        return this.dimension80;
    }

    public void setDimension80(boolean z) {
        this.dimension80 = z;
    }

    public String getmDimension40() {
        return this.mDimension40;
    }

    public void setmDimension40(String str) {
        this.mDimension40 = str;
    }

    public String getmId() {
        return this.mId;
    }

    public void setmId(String str) {
        this.mId = str;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getmList() {
        return this.mList;
    }

    public void setmList(String str) {
        this.mList = str;
    }

    public String getMbrand() {
        return this.mbrand;
    }

    public void setMbrand(String str) {
        this.mbrand = str;
    }

    public String getmPrice() {
        return this.mPrice;
    }

    public void setmPrice(String str) {
        this.mPrice = str;
    }

    public String getmPosition() {
        return this.mPosition;
    }

    public void setmPosition(String str) {
        this.mPosition = str;
    }

    public String getmDimesion24() {
        return this.mDimesion24;
    }

    public void setmDimesion24(String str) {
        this.mDimesion24 = str;
    }

    public String getmDimension25() {
        return this.mDimension25;
    }

    public void setmDimension25(String str) {
        this.mDimension25 = str;
    }

    public String getmDimesion38() {
        return this.mDimesion38;
    }

    public void setmDimesion38(String str) {
        this.mDimesion38 = str;
    }

    public String getmDimension67() {
        return this.mDimension67;
    }

    public void setmDimension67(String str) {
        this.mDimension67 = str;
    }

    public String getmDimesion39() {
        return this.mDimesion39;
    }

    public void setmDimesion39(String str) {
        this.mDimesion39 = str;
    }

    public String getmDimesion70() {
        return this.mDimesion70;
    }

    public void setmDimesion70(String str) {
        this.mDimesion70 = str;
    }

    public String getmDimesion41() {
        return this.mDimesion41;
    }

    public void setmDimesion41(String str) {
        this.mDimesion41 = str;
    }

    public Dimension79 getmDimension79() {
        return this.mDimension79;
    }

    public void setmDimension79(Dimension79 dimension79) {
        this.mDimension79 = dimension79;
    }

    public String getmDimension43() {
        return this.mDimension43;
    }

    public void setDimension43(String str) {
        this.mDimension43 = str;
    }

    public static class Dimension79 {
        @c(a = "flash_sale")
        private Boolean mFlashSale;
        @c(a = "timeslot")
        private String mTimeslot;

        public Boolean getmFlashSale() {
            return this.mFlashSale;
        }

        public void setmFlashSale(Boolean bool) {
            this.mFlashSale = bool;
        }

        public String getTimeslot() {
            return this.mTimeslot;
        }

        public void setTimeslot(String str) {
            this.mTimeslot = str;
        }

        public String toString() {
            if (!this.mFlashSale.booleanValue()) {
                this.mTimeslot = null;
            }
            return new f().b(this);
        }
    }
}
