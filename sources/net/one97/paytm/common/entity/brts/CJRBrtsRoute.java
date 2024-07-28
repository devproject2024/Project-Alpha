package net.one97.paytm.common.entity.brts;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrtsRoute extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "destinationInfoList")
    private ArrayList<CJRBrtsDestination> mDestinationList;
    @b(a = "destinations")
    private ArrayList<CJRBrtsDestination> mDestinations;
    @b(a = "routeId")
    private String mRouteId;
    @b(a = "routeName")
    private String mRouteName;
    @b(a = "sourceId")
    private String sourceId;
    @b(a = "sourceName")
    private String sourceName;

    public String getRouteName() {
        return this.mRouteName;
    }

    public String getRouteId() {
        return this.mRouteId;
    }

    public ArrayList<CJRBrtsDestination> getDestinations() {
        ArrayList<CJRBrtsDestination> arrayList = this.mDestinationList;
        if (arrayList != null) {
            return arrayList;
        }
        return this.mDestinations;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String str) {
        this.sourceId = str;
    }

    public void setmRouteId(String str) {
        this.mRouteId = str;
    }
}
