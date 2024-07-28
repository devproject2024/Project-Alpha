package net.one97.paytm.passbook.main.entity;

import android.text.TextUtils;
import com.paytm.utility.v;
import java.util.ArrayList;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.d;

public class MultiSubWallet extends CJRSubWallet {
    private final boolean mEnableActionButton;
    private ArrayList<CJRSubWallet> subWalletList;

    public MultiSubWallet(int i2) {
        this(i2, false);
    }

    public MultiSubWallet(int i2, boolean z) {
        this.subWalletList = new ArrayList<>();
        setSubWalletType(i2);
        this.mEnableActionButton = z;
    }

    public void addSubWallet(CJRSubWallet cJRSubWallet) {
        this.subWalletList.add(cJRSubWallet);
    }

    public ArrayList<CJRSubWallet> getSubWalletList() {
        return this.subWalletList;
    }

    public boolean isActionButtonEnabled() {
        return this.mEnableActionButton;
    }

    public String getSubWalletName() {
        if (this.subWalletList.isEmpty()) {
            return "";
        }
        return this.subWalletList.get(0).getSubWalletName();
    }

    public String getDisplayName() {
        if (!v.a(super.getDisplayName())) {
            return super.getDisplayName();
        }
        for (int i2 = 0; i2 < this.subWalletList.size(); i2++) {
            if (!this.subWalletList.get(i2).isExpired()) {
                return this.subWalletList.get(i2).getDisplayName();
            }
        }
        return this.subWalletList.get(0).getDisplayName();
    }

    public String getMetaData() {
        if (!v.a(super.getMetaData())) {
            return super.getMetaData();
        }
        if (this.subWalletList.size() > 0) {
            return this.subWalletList.get(0).getDisplayName();
        }
        return null;
    }

    public double getBalance() {
        double d2 = 0.0d;
        for (int i2 = 0; i2 < this.subWalletList.size(); i2++) {
            if (!this.subWalletList.get(i2).isExpired()) {
                d2 += this.subWalletList.get(i2).getBalance();
            }
        }
        return d2;
    }

    public String getIssuerMetadata() {
        if (!v.a(super.getIssuerMetadata())) {
            return super.getIssuerMetadata();
        }
        String issuerMetadata = this.subWalletList.get(0).getIssuerMetadata();
        for (int i2 = 0; i2 < this.subWalletList.size(); i2++) {
            if (!this.subWalletList.get(i2).isExpired() && this.subWalletList.get(i2).getIssuedOnTime() > 0) {
                issuerMetadata = this.subWalletList.get(i2).getIssuerMetadata();
            }
        }
        if (TextUtils.isEmpty(issuerMetadata)) {
            return issuerMetadata;
        }
        return String.format(d.b().b().getString(R.string.wallet_issuedby), new Object[]{issuerMetadata});
    }
}
