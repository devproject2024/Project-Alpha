package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroStationListResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "to")
    private CJRMetroStationDataModel destination;
    @b(a = "passengers")
    private CJRMetroPassengerDataModel passengers;
    @b(a = "from")
    private CJRMetroStationDataModel source;
    @b(a = "stations")
    private List<CJRMetroStationModel> stations;

    public CJRMetroStationDataModel getSource() {
        return this.source;
    }

    public CJRMetroStationDataModel getDestination() {
        return this.destination;
    }

    public CJRMetroPassengerDataModel getPassengers() {
        return this.passengers;
    }

    public List<CJRMetroStationModel> getStations() {
        return this.stations;
    }
}
