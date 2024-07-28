package net.one97.paytm.common.entity.offline_pg;

public class UpiHelpModel {
    private String description;
    private int imageViewId;

    public UpiHelpModel(String str, int i2) {
        this.description = str;
        this.imageViewId = i2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public int getImageViewId() {
        return this.imageViewId;
    }

    public void setImageViewId(int i2) {
        this.imageViewId = i2;
    }
}
