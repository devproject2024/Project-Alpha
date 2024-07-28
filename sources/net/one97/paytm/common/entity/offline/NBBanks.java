package net.one97.paytm.common.entity.offline;

public class NBBanks {
    private String bankName;
    private boolean hasLowSuccess;
    private boolean isSelected;
    private boolean isValid;

    public NBBanks(String str, boolean z, boolean z2) {
        this.bankName = str;
        this.hasLowSuccess = z;
        this.isValid = z2;
    }

    public String getBankName() {
        return this.bankName;
    }

    public boolean isHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isValid() {
        return this.isValid;
    }
}
