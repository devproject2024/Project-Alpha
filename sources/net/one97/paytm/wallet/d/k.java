package net.one97.paytm.wallet.d;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.p2p.theme.e;
import net.one97.paytm.wallet.newdesign.utils.DelegateUtil;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static k f70262a;

    public enum a {
        SCANNER,
        NATIVE_CONTACT,
        ENTERED,
        CONTACT_LIST,
        RECENT,
        NONE
    }

    private static double a(double d2, double d3, int i2) {
        return ((((double) i2) * d2) + d3) / ((double) (i2 + 1));
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (f70262a == null) {
                f70262a = new k();
            }
            kVar = f70262a;
        }
        return kVar;
    }

    private k() {
    }

    public static void a(Context context, String str, String str2, String str3, long j, String str4, String str5, a aVar) {
        RecentSendMoney recentSendMoney = new RecentSendMoney();
        recentSendMoney.setPhoneNumber(str2);
        recentSendMoney.setName(str);
        recentSendMoney.setImageurl(str3);
        recentSendMoney.setTimestamp(j);
        recentSendMoney.setAmount(str4);
        recentSendMoney.setModeOfPayment(str5);
        recentSendMoney.setRoute(aVar.name());
        b(recentSendMoney, context);
    }

    private static void b(IJRDataModel iJRDataModel, Context context) {
        ArrayList<IJRDataModel> arrayList;
        try {
            ArrayList<IJRDataModel> a2 = a(context);
            if (a2 == null) {
                arrayList = new ArrayList<>(10);
                c(iJRDataModel, context);
            } else {
                arrayList = a(iJRDataModel, a2, context);
                if (arrayList.size() == 10) {
                    arrayList.remove(9);
                }
            }
            arrayList.add(0, iJRDataModel);
            DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList, "recents_sendmoney_data");
        } catch (NumberFormatException unused) {
        }
    }

    private static ArrayList<IJRDataModel> a(IJRDataModel iJRDataModel, ArrayList<IJRDataModel> arrayList, Context context) {
        Iterator<IJRDataModel> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            IJRDataModel next = it2.next();
            if ((next instanceof RecentSendMoney) && (iJRDataModel instanceof RecentSendMoney)) {
                RecentSendMoney recentSendMoney = (RecentSendMoney) next;
                RecentSendMoney recentSendMoney2 = (RecentSendMoney) iJRDataModel;
                if (recentSendMoney.getPhoneNumber().equalsIgnoreCase(recentSendMoney2.getPhoneNumber())) {
                    String s = b.s(context);
                    String t = b.t(context);
                    int i2 = Calendar.getInstance().get(7);
                    double currentTimeMillis = (double) System.currentTimeMillis();
                    if (!TextUtils.isEmpty(s)) {
                        recentSendMoney.getMachineIntelligent().getLocation().setLatitudeweight(a(recentSendMoney.getMachineIntelligent().getLocation().getLatitudeweight(), Double.parseDouble(s), recentSendMoney.getMachineIntelligent().getLocation().getLatitudeCount()));
                        recentSendMoney.getMachineIntelligent().getLocation().setLatitudeCount(recentSendMoney.getMachineIntelligent().getLocation().getLatitudeCount() + 1);
                    }
                    if (!TextUtils.isEmpty(t)) {
                        recentSendMoney.getMachineIntelligent().getLocation().setLongitudeweight(a(recentSendMoney.getMachineIntelligent().getLocation().getLongitudeweight(), Double.parseDouble(t), recentSendMoney.getMachineIntelligent().getLocation().getLongitudeCount()));
                        recentSendMoney.getMachineIntelligent().getLocation().setLongitudeCount(recentSendMoney.getMachineIntelligent().getLocation().getLongitudeCount() + 1);
                    }
                    recentSendMoney.getMachineIntelligent().getTimeOfDay().setTimeOfDayweight(a(recentSendMoney.getMachineIntelligent().getTimeOfDay().getTimeOfDayweight(), currentTimeMillis, recentSendMoney.getMachineIntelligent().getTimeOfDay().getTimeOfDayCount()));
                    recentSendMoney.getMachineIntelligent().getTimeOfDay().setTimeOfDayCount(recentSendMoney.getMachineIntelligent().getTimeOfDay().getTimeOfDayCount() + 1);
                    recentSendMoney.getMachineIntelligent().getWeekday().updateweekdaycount(recentSendMoney.getMachineIntelligent().getWeekday(), i2);
                    recentSendMoney2.setMachineIntelligent(recentSendMoney.getMachineIntelligent());
                    arrayList.remove(next);
                    return arrayList;
                }
            }
        }
        c(iJRDataModel, context);
        return arrayList;
    }

    private static void c(IJRDataModel iJRDataModel, Context context) {
        if (iJRDataModel instanceof RecentSendMoney) {
            String s = b.s(context);
            String t = b.t(context);
            double currentTimeMillis = (double) System.currentTimeMillis();
            int i2 = Calendar.getInstance().get(7);
            if (!TextUtils.isEmpty(s)) {
                RecentSendMoney recentSendMoney = (RecentSendMoney) iJRDataModel;
                recentSendMoney.getMachineIntelligent().getLocation().setLatitudeweight(Double.parseDouble(s));
                recentSendMoney.getMachineIntelligent().getLocation().setLatitudeCount(1);
            }
            if (!TextUtils.isEmpty(t)) {
                RecentSendMoney recentSendMoney2 = (RecentSendMoney) iJRDataModel;
                recentSendMoney2.getMachineIntelligent().getLocation().setLongitudeweight(Double.parseDouble(t));
                recentSendMoney2.getMachineIntelligent().getLocation().setLongitudeCount(1);
            }
            RecentSendMoney recentSendMoney3 = (RecentSendMoney) iJRDataModel;
            recentSendMoney3.getMachineIntelligent().getTimeOfDay().setTimeOfDayweight(currentTimeMillis);
            recentSendMoney3.getMachineIntelligent().getTimeOfDay().setTimeOfDayCount(1);
            recentSendMoney3.getMachineIntelligent().getWeekday().updateweekdaycount(recentSendMoney3.getMachineIntelligent().getWeekday(), i2);
        }
    }

    public static void a(IJRDataModel iJRDataModel, Context context) {
        ArrayList<IJRDataModel> a2 = a(context);
        if (a2 == null) {
            a2 = new ArrayList<>(10);
            c(iJRDataModel, context);
            a2.add(0, iJRDataModel);
        } else {
            Iterator<IJRDataModel> it2 = a2.iterator();
            while (it2.hasNext()) {
                IJRDataModel next = it2.next();
                if ((next instanceof RecentSendMoney) && (iJRDataModel instanceof RecentSendMoney) && ((RecentSendMoney) next).getPhoneNumber().equalsIgnoreCase(((RecentSendMoney) iJRDataModel).getPhoneNumber())) {
                    it2.remove();
                }
            }
        }
        DelegateUtil.INSTANCE.writeObjectToFile(context, a2, "recents_sendmoney_data");
    }

    public static ArrayList<IJRDataModel> a(Context context) {
        Object a2 = e.a(context, "recents_sendmoney_data");
        if (a2 instanceof ArrayList) {
            return (ArrayList) a2;
        }
        return null;
    }
}
