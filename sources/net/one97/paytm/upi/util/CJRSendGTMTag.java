package net.one97.paytm.upi.util;

import android.content.Context;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiGTMLoader;

public class CJRSendGTMTag {

    public interface OnCustomNewGTMEvent {
        void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6);

        void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

        void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5);

        void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);
    }

    public static void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendNewCustomGTMEvents(context, str, str2, str3, str4, str5, str6, str7);
    }

    public static void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendOpenScreenWithDeviceInfo(str, str2, context);
    }

    public static void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendCustomGTMEvents(context, str, str2, str3, str4, str5, str6);
    }

    public static void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendNewCustomGTMEventsWithMultipleLabel(context, str, str2, arrayList, str3, str4, str5);
    }

    public static void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        ArrayList arrayList = new ArrayList();
        String str10 = str3;
        arrayList.add(str3);
        String str11 = str4;
        arrayList.add(str4);
        String str12 = str5;
        arrayList.add(str5);
        String str13 = str6;
        arrayList.add(str6);
        UpiGTMLoader.getInstance().getOnCustomNewGTMEvent().sendNewCustomGTMEventsWithMultipleLabel(context, str, str2, arrayList, str7, str8, str9);
    }
}
