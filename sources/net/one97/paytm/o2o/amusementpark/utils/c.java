package net.one97.paytm.o2o.amusementpark.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static Comparator<CJRSeatDetailsModel> f73649a = new Comparator<CJRSeatDetailsModel>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            CJRSeatDetailsModel cJRSeatDetailsModel = (CJRSeatDetailsModel) obj;
            CJRSeatDetailsModel cJRSeatDetailsModel2 = (CJRSeatDetailsModel) obj2;
            if (!(cJRSeatDetailsModel == null || cJRSeatDetailsModel2 == null)) {
                if (cJRSeatDetailsModel.getmIndex() > cJRSeatDetailsModel2.getmIndex()) {
                    return 1;
                }
                if (cJRSeatDetailsModel.getmIndex() < cJRSeatDetailsModel2.getmIndex()) {
                    return -1;
                }
            }
            return 0;
        }
    };

    public static void a(List<CJRSeatDetailsModel> list) {
        if (list != null) {
            Collections.sort(list, f73649a);
        }
    }

    public static String b(List<CJRSeatDetailsModel> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            CJRSeatDetailsModel cJRSeatDetailsModel = list.get(i2);
            sb.append(cJRSeatDetailsModel.getSelectedQuantity());
            sb.append(" ");
            sb.append(cJRSeatDetailsModel.getSeatType());
            sb.append(", ");
        }
        int lastIndexOf = sb.lastIndexOf(", ");
        sb.delete(lastIndexOf, lastIndexOf + 2);
        return sb.toString();
    }
}
