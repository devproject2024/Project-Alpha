package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.events.CJRInputMetaDataModel;

public class CJRInputMetaDataModelV2 extends CJRInputMetaDataModel {
    @b(a = "dateString")
    private String eventDateString;

    public String getEventDateString() {
        return this.eventDateString;
    }
}
