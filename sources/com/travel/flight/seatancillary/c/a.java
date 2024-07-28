package com.travel.flight.seatancillary.c;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.travel.flight.pojo.model.CJRSeatSelectedItem;
import com.travel.flight.pojo.model.CJRSeatSelection;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatTax;
import com.travel.flight.pojo.seatancillaryentity.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class a implements Serializable {
    private static final String EXTRA_LEGROOM = "EXTRA LEGROOM";
    private static final String LOWER = "lower";
    private static final String UPPER = "upper";

    private a() {
    }

    public static boolean updateTravellerSeatTransitionList(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < cJRTravellerSeatTransition.getOnwardSeatSelections().size(); i2++) {
            if (cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2).getmSelectedSeatsCount() > 0) {
                z = true;
            }
            cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2).setmSelectedSeatsCount(0);
            cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2).setmTotalSeatPrice(0.0d);
        }
        return z;
    }

    public static CJRSeatSelectedItem getSelectedItem(ArrayList<CJRSeatSelectedItem> arrayList, String str) {
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).isSeatSelected() && !isEmpty(str) && str.equalsIgnoreCase(arrayList.get(i2).getmSeatNumber())) {
                    return arrayList.get(i2);
                }
            }
        }
        return null;
    }

    public static CJRSeatSelectedItem getUnselectedItem(ArrayList<CJRSeatSelectedItem> arrayList) {
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!arrayList.get(i2).isSeatSelected()) {
                    return arrayList.get(i2);
                }
            }
        }
        return null;
    }

    public static boolean isHopMatched(String str, String str2, String str3, CJRSeatSelection cJRSeatSelection) {
        return cJRSeatSelection != null && !isEmpty(str) && !isEmpty(str2) && !isEmpty(str3) && str.equalsIgnoreCase(cJRSeatSelection.getmFlightNumber()) && str2.equalsIgnoreCase(cJRSeatSelection.getmOrigin()) && str3.equalsIgnoreCase(cJRSeatSelection.getmDestination());
    }

    public static boolean isSeatLimitReached(b bVar, CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (!(cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null || bVar == null)) {
            int i2 = 0;
            while (i2 < cJRTravellerSeatTransition.getOnwardSeatSelections().size()) {
                CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
                if (cJRSeatSelection == null || !isHopMatched(bVar.getFlightNumber(), bVar.getOrigin(), bVar.getDestination(), cJRSeatSelection)) {
                    i2++;
                } else if (cJRSeatSelection.getmSelectedSeatsCount() == cJRSeatSelection.getmSeatSelectedItems().size()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static int getTotalSelectedSeatsCount(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < cJRTravellerSeatTransition.getOnwardSeatSelections().size(); i3++) {
            CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i3);
            if (cJRSeatSelection != null) {
                i2 += cJRSeatSelection.getmSelectedSeatsCount();
            }
        }
        return i2;
    }

    public static boolean isSelectionCountCriteriaPassed(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (cJRTravellerSeatTransition == null) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= cJRTravellerSeatTransition.getOnwardSeatSelections().size()) {
                break;
            }
            CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
            if (cJRSeatSelection != null) {
                i3 += cJRSeatSelection.getmSelectedSeatsCount();
                if (cJRSeatSelection.getmSelectedSeatsCount() % cJRSeatSelection.getmSeatSelectedItems().size() != 0) {
                    z = false;
                    break;
                }
                z = true;
            }
            i2++;
        }
        if (i3 == 0) {
            return false;
        }
        return z;
    }

    public static String getPassengerName(String str, CJRTravellerSeatTransition cJRTravellerSeatTransition, String str2, String str3, String str4) {
        if (cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null || isEmpty(str) || isEmpty(str2) || isEmpty(str3) || isEmpty(str4)) {
            return "";
        }
        String str5 = "";
        for (int i2 = 0; i2 < cJRTravellerSeatTransition.getOnwardSeatSelections().size(); i2++) {
            CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
            if (cJRSeatSelection != null && isHopMatched(str2, str3, str4, cJRSeatSelection)) {
                int i3 = 0;
                while (true) {
                    if (i3 >= cJRSeatSelection.getmSeatSelectedItems().size()) {
                        break;
                    }
                    CJRSeatSelectedItem cJRSeatSelectedItem = cJRSeatSelection.getmSeatSelectedItems().get(i3);
                    if (!str.equalsIgnoreCase(cJRSeatSelectedItem.getmSeatNumber())) {
                        i3++;
                    } else if (!isEmpty(cJRSeatSelectedItem.getmTravellerFirstName())) {
                        str5 = cJRSeatSelectedItem.getmTravellerFirstName();
                    } else {
                        str5 = cJRSeatSelectedItem.getmTravellerLastName();
                    }
                }
            }
        }
        return str5;
    }

    public static boolean isSeatTobeSelected(String str, String str2, String str3, String str4, CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null || isEmpty(str4) || isEmpty(str) || isEmpty(str2) || isEmpty(str3)) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < cJRTravellerSeatTransition.getOnwardSeatSelections().size(); i2++) {
            CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
            if (cJRSeatSelection != null && isHopMatched(str, str2, str3, cJRSeatSelection)) {
                boolean z2 = z;
                int i3 = 0;
                while (true) {
                    if (i3 >= cJRSeatSelection.getmSeatSelectedItems().size()) {
                        z = z2;
                        break;
                    }
                    CJRSeatSelectedItem cJRSeatSelectedItem = cJRSeatSelection.getmSeatSelectedItems().get(i3);
                    if (cJRSeatSelectedItem != null) {
                        if (str4.equalsIgnoreCase(cJRSeatSelectedItem.getmSeatNumber())) {
                            z = true;
                            break;
                        }
                        z2 = false;
                    }
                    i3++;
                }
            }
        }
        return z;
    }

    public static void setPreselectSeatsToTravelerList(ArrayList<com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.a> arrayList, String str, String str2, String str3, CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (cJRTravellerSeatTransition != null && cJRTravellerSeatTransition.getOnwardSeatSelections() != null && arrayList != null && arrayList.size() > 0 && !isEmpty(str) && !isEmpty(str2) && !isEmpty(str3)) {
            for (int i2 = 0; i2 < cJRTravellerSeatTransition.getOnwardSeatSelections().size(); i2++) {
                CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
                if (cJRSeatSelection != null && isHopMatched(str, str2, str3, cJRSeatSelection)) {
                    for (int i3 = 0; i3 < cJRSeatSelection.getmSeatSelectedItems().size(); i3++) {
                        CJRSeatSelectedItem cJRSeatSelectedItem = cJRSeatSelection.getmSeatSelectedItems().get(i3);
                        com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.a aVar = arrayList.get(i3);
                        if (!(cJRSeatSelectedItem == null || aVar == null)) {
                            cJRSeatSelectedItem.setmSeatNumber(aVar.f25424a);
                        }
                    }
                }
            }
        }
    }

    public static boolean isSeatsAlreadySelected(String str, String str2, String str3, CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        if (cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null || isEmpty(str) || isEmpty(str2) || isEmpty(str3)) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < cJRTravellerSeatTransition.getOnwardSeatSelections().size(); i2++) {
            CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
            if (cJRSeatSelection != null && isHopMatched(str, str2, str3, cJRSeatSelection)) {
                boolean z2 = z;
                for (int i3 = 0; i3 < cJRSeatSelection.getmSeatSelectedItems().size(); i3++) {
                    CJRSeatSelectedItem cJRSeatSelectedItem = cJRSeatSelection.getmSeatSelectedItems().get(i3);
                    if (cJRSeatSelectedItem != null && !isEmpty(cJRSeatSelectedItem.getmSeatNumber())) {
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    public static int[] getDisplayHeightWidth(Activity activity) {
        int[] iArr = new int[2];
        if (activity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.heightPixels;
            iArr[1] = displayMetrics.widthPixels - ((int) convertDpToPixel(70.0f, activity));
        }
        return iArr;
    }

    public static float convertDpToPixel(float f2, Context context) {
        if (context != null) {
            return f2 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
        }
        return 0.0f;
    }

    public static float convertPixelsToDp(float f2, Context context) {
        if (context != null) {
            return f2 / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
        }
        return 0.0f;
    }

    public static void updateSeatValues(CJRSeatSelection cJRSeatSelection, b bVar, boolean z) {
        if (cJRSeatSelection != null && bVar != null) {
            if (z) {
                cJRSeatSelection.setmTotalSeatPrice(cJRSeatSelection.getmTotalSeatPrice() + bVar.getSeatPrice());
                cJRSeatSelection.setmSelectedSeatsCount(cJRSeatSelection.getmSelectedSeatsCount() + 1);
                updateTravelerInfoBasedOnCount(bVar, cJRSeatSelection, z);
                return;
            }
            cJRSeatSelection.setmTotalSeatPrice(cJRSeatSelection.getmTotalSeatPrice() - bVar.getSeatPrice());
            cJRSeatSelection.setmSelectedSeatsCount(cJRSeatSelection.getmSelectedSeatsCount() - 1);
            updateTravelerInfoBasedOnCount(bVar, cJRSeatSelection, z);
        }
    }

    public static void updateTravelerInfoBasedOnCount(b bVar, CJRSeatSelection cJRSeatSelection, boolean z) {
        if (z) {
            CJRSeatSelectedItem unselectedItem = getUnselectedItem(cJRSeatSelection.getmSeatSelectedItems());
            if (unselectedItem != null) {
                unselectedItem.setmDeck(bVar.getDeck());
                unselectedItem.setmSeatCode(bVar.getSeatCode());
                unselectedItem.setmSeatNumber(bVar.getSeatNumber());
                unselectedItem.setmSeatPrice(bVar.getSeatPrice());
                unselectedItem.setmTax(bVar.getCJRSeatTaxes());
                unselectedItem.setSeatSelected(true);
                return;
            }
            return;
        }
        CJRSeatSelectedItem selectedItem = getSelectedItem(cJRSeatSelection.getmSeatSelectedItems(), bVar.getSeatNumber());
        if (selectedItem != null) {
            selectedItem.setmDeck((String) null);
            selectedItem.setmSeatCode((String) null);
            selectedItem.setmSeatNumber((String) null);
            selectedItem.setmSeatPrice(0.0d);
            selectedItem.setmTax((List<CJRSeatTax>) null);
            selectedItem.setSeatSelected(false);
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
