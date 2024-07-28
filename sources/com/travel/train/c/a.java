package com.travel.train.c;

import com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel;
import java.util.ArrayList;

public interface a {

    /* renamed from: com.travel.train.c.a$a  reason: collision with other inner class name */
    public interface C0486a {
        void getModeIdDetails(ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList);

        void launchMetroRouteActivity(String str, String str2, String str3, String str4);

        void showBothMetroMissingAlert();

        void showBothMetroSameAlert();

        void showBottomSheet(ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList);

        void showDestinationMetroMissingAlert();

        void showSourceMetroMissingAlert();

        void updateUiIfNoDataPassed(ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList);
    }
}
