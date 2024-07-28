package net.one97.paytm.dynamic.module.feed;

import com.paytm.network.model.IJRPaytmDataModel;

public final class SheroesAuthModel extends IJRPaytmDataModel {
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    public final class Data {
        private String access_token;
        private String resourceOwnerId;

        public Data() {
        }

        public final String getResourceOwnerId() {
            return this.resourceOwnerId;
        }

        public final void setResourceOwnerId(String str) {
            this.resourceOwnerId = str;
        }

        public final String getAccess_token() {
            return this.access_token;
        }

        public final void setAccess_token(String str) {
            this.access_token = str;
        }
    }
}
