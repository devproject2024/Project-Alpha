package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import java.util.Map;

public interface EventInterface {
    Event getEventScreenName();

    String getScreenName();

    void trackEvent(Event event, Map<String, Object> map);
}
