package com.travel.train.c;

import com.travel.train.model.metro.CJRParcelableMetroStationModel;
import com.travel.train.model.metro.CJRStationAutoSuggestModel;
import java.util.List;

public interface c {

    public interface a {
        void a();

        void a(String str, String str2);

        void a(List<? extends CJRParcelableMetroStationModel> list);

        void a(boolean z);

        void b(List<? extends CJRStationAutoSuggestModel> list);

        void c(List<? extends CJRStationAutoSuggestModel> list);
    }
}
