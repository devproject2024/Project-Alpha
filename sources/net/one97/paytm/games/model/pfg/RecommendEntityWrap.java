package net.one97.paytm.games.model.pfg;

import java.util.List;
import net.one97.paytm.games.model.GpCommonBaseResponse;

public class RecommendEntityWrap extends GpCommonBaseResponse {
    private List<RecommendEntity> data;

    public List<RecommendEntity> getData() {
        return this.data;
    }
}
