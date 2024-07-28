package net.one97.paytm.games.model.pfg;

import java.util.List;
import net.one97.paytm.games.model.GpCommonBaseResponse;

public class GamesInfo extends GpCommonBaseResponse {
    private List<Game> data;

    public List<Game> getData() {
        return this.data;
    }
}
