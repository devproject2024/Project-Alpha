package com.paytmmall.clpartifact.modal.grid;

import android.text.TextUtils;
import com.google.gson.a.c;
import com.paytmmall.clpartifact.R;
import java.util.ArrayList;

public class CJRFrontEndFilterItem extends CJRFilterValue {
    private static final long serialVersionUID = 1;
    private int fontColor = R.color.clp_color_2222222;
    private int imageSrc = -1;
    private boolean isSelected;
    @c(a = "cats")
    private ArrayList<CJRFrontEndFilterItem> mFrontEndFilterItemList = new ArrayList<>();
    @c(a = "parent_id")
    private String mParentId;

    public ArrayList<CJRFrontEndFilterItem> getFrontEndFilterItemList() {
        return this.mFrontEndFilterItemList;
    }

    public String getParentId() {
        return this.mParentId;
    }

    public void setParentId(String str) {
        if (TextUtils.isEmpty(this.mParentId)) {
            this.mParentId = str;
        }
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public void setFontColor(int i2) {
        this.fontColor = i2;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getImageSrc() {
        int i2 = this.imageSrc;
        if (i2 != -1) {
            return i2;
        }
        if (!this.isSelected) {
            return R.drawable.clp_ic_done;
        }
        if (this.mFrontEndFilterItemList.size() > 0) {
            return R.drawable.clp_ic_cancel;
        }
        return R.drawable.clp_ic_selcted;
    }

    public void setImageSrc(int i2) {
        this.imageSrc = i2;
    }
}
