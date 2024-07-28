package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class AdspotDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "adProvider")
    AdProvider adProvider;
    @b(a = "visiblity")
    boolean isVisible;

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setVisible(boolean z) {
        this.isVisible = z;
    }

    public AdProvider getAdProvider() {
        return this.adProvider;
    }

    public void setAdProvider(AdProvider adProvider2) {
        this.adProvider = adProvider2;
    }

    public static class AdProvider extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "adSpotID")
        private String adSpotId;
        @b(a = "adSpotViewType")
        private String adSpotViewType;
        @b(a = "name")
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getAdSpotId() {
            return this.adSpotId;
        }

        public void setAdSpotId(String str) {
            this.adSpotId = str;
        }

        public String getAdSpotViewType() {
            return this.adSpotViewType;
        }

        public void setAdSpotViewType(String str) {
            this.adSpotViewType = str;
        }
    }
}
