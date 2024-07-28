package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

public class Request implements Parcelable {
    public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() {
        public final Request createFromParcel(Parcel parcel) {
            return new Request(parcel);
        }

        public final Request[] newArray(int i2) {
            return new Request[i2];
        }
    };
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String requestBody;
    private int requestType;
    private String url;

    public int describeContents() {
        return 0;
    }

    public Request(String str, Map<String, String> map) {
        this.url = str;
        this.queryParams = map;
        this.requestType = 0;
        this.requestBody = null;
        this.headers = null;
    }

    public Request(int i2, String str, Map<String, String> map, Map<String, String> map2, String str2) {
        this.headers = map;
        this.queryParams = map2;
        this.requestBody = str2;
        this.requestType = i2;
        this.url = str;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public void setRequestType(int i2) {
        this.requestType = i2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public Map<String, String> getParams() {
        return this.queryParams;
    }

    public void setParams(Map<String, String> map) {
        this.queryParams = map;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

    public void setRequestBody(String str) {
        this.requestBody = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.url);
        parcel.writeInt(this.headers.size());
        for (Map.Entry next : this.headers.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        parcel.writeInt(this.queryParams.size());
        for (Map.Entry next2 : this.queryParams.entrySet()) {
            parcel.writeString((String) next2.getKey());
            parcel.writeString((String) next2.getValue());
        }
        parcel.writeString(this.requestBody);
        parcel.writeInt(this.requestType);
    }

    protected Request(Parcel parcel) {
        this.url = parcel.readString();
        int readInt = parcel.readInt();
        this.headers = new HashMap(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.headers.put(parcel.readString(), parcel.readString());
        }
        int readInt2 = parcel.readInt();
        this.queryParams = new HashMap(readInt2);
        for (int i3 = 0; i3 < readInt2; i3++) {
            this.queryParams.put(parcel.readString(), parcel.readString());
        }
        this.requestBody = parcel.readString();
        this.requestType = parcel.readInt();
    }
}
