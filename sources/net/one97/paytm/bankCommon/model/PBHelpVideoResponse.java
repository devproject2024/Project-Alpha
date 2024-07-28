package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBHelpVideoResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "video")
    private List<PBHelpVideoModel> video = null;

    public List<PBHelpVideoModel> getVideo() {
        return this.video;
    }

    public void setVideo(List<PBHelpVideoModel> list) {
        this.video = list;
    }
}
