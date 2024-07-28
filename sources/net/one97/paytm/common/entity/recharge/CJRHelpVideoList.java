package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHelpVideoList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "service")
    private String service;
    @b(a = "videos")
    private List<CJRVideo> videos = new ArrayList();

    public String getService() {
        return this.service;
    }

    public void setService(String str) {
        this.service = str;
    }

    public List<CJRVideo> getVideos() {
        return this.videos;
    }

    public void setVideos(ArrayList<CJRVideo> arrayList) {
        this.videos = arrayList;
    }
}
