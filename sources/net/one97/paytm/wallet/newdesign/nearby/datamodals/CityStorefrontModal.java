package net.one97.paytm.wallet.newdesign.nearby.datamodals;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CityStorefrontModal extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "default")
    private String defaultUrl;
    @b(a = "response")
    private ArrayList<Response> response;

    public ArrayList<Response> getResponse() {
        return this.response;
    }

    public void setResponse(ArrayList<Response> arrayList) {
        this.response = arrayList;
    }

    public String getDefaultUrl() {
        return this.defaultUrl;
    }

    public void setDefaultUrl(String str) {
        this.defaultUrl = str;
    }

    public class Response {
        @b(a = "city")
        private String city;
        @b(a = "url")
        private String url;

        public Response() {
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }
}
