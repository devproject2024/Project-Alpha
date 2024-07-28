package net.one97.paytm.wallet.d;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.p2p.theme.e;
import net.one97.paytm.wallet.newdesign.utils.DelegateUtil;
import org.json.JSONObject;

public final class j {

    /* renamed from: b  reason: collision with root package name */
    private static j f70260b;

    /* renamed from: a  reason: collision with root package name */
    RecentScan f70261a = null;

    private static double a(double d2, double d3, int i2) {
        return ((((double) i2) * d2) + d3) / ((double) (i2 + 1));
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f70260b == null) {
                f70260b = new j();
            }
            jVar = f70260b;
        }
        return jVar;
    }

    private j() {
    }

    public final void b() {
        this.f70261a = null;
    }

    public final void a(Context context) {
        try {
            if (this.f70261a != null) {
                b(this.f70261a, context);
                this.f70261a = null;
            }
        } catch (NumberFormatException unused) {
        }
    }

    public final void a(Context context, String str, String str2, int i2, int i3) {
        if (!TextUtils.isEmpty(str2) && a(i3, str, context, str2)) {
            this.f70261a = new RecentScan();
            this.f70261a.setScanResult(a(str));
            this.f70261a.setType(i2);
            this.f70261a.setUniqKey(str2);
            this.f70261a.setTimestamp(System.currentTimeMillis());
        }
    }

    private static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("mode", "RECENT_SCAN");
            return jSONObject.toString();
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return str;
        }
    }

    private static boolean a(int i2, String str, Context context, String str2) {
        if (i2 == 2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                cJRQRScanResultModel.parseData(jSONObject, context);
                if (!TextUtils.isEmpty(cJRQRScanResultModel.getTxnAmount())) {
                    return false;
                }
                if (!TextUtils.isEmpty(cJRQRScanResultModel.getMerchantTransId())) {
                    return false;
                }
                if (TextUtils.isEmpty(cJRQRScanResultModel.getPosId()) || str2.equalsIgnoreCase(cJRQRScanResultModel.getPosId()) || cJRQRScanResultModel.getPosId().equalsIgnoreCase("null")) {
                    return true;
                }
                return false;
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
        return true;
    }

    private static void b(IJRDataModel iJRDataModel, Context context) {
        ArrayList<IJRDataModel> arrayList;
        ArrayList<IJRDataModel> b2 = b(context);
        if (b2 == null) {
            arrayList = new ArrayList<>(10);
            a(iJRDataModel, context);
        } else {
            arrayList = a(iJRDataModel, b2, context);
            if (arrayList.size() == 10) {
                arrayList.remove(9);
            }
        }
        arrayList.add(0, iJRDataModel);
        DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList, "recents_data");
    }

    private static ArrayList<IJRDataModel> a(IJRDataModel iJRDataModel, ArrayList<IJRDataModel> arrayList, Context context) {
        Iterator<IJRDataModel> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            IJRDataModel next = it2.next();
            if ((next instanceof RecentScan) && (iJRDataModel instanceof RecentScan)) {
                RecentScan recentScan = (RecentScan) next;
                if (recentScan.getUniqKey() != null) {
                    RecentScan recentScan2 = (RecentScan) iJRDataModel;
                    if (recentScan2.getUniqKey() != null && recentScan.getUniqKey().equalsIgnoreCase(recentScan2.getUniqKey())) {
                        String s = b.s(context);
                        String t = b.t(context);
                        int i2 = Calendar.getInstance().get(7);
                        double currentTimeMillis = (double) System.currentTimeMillis();
                        if (!TextUtils.isEmpty(s)) {
                            recentScan.getMachineIntelligent().getLocation().setLatitudeweight(a(recentScan.getMachineIntelligent().getLocation().getLatitudeweight(), Double.parseDouble(s), recentScan.getMachineIntelligent().getLocation().getLatitudeCount()));
                            recentScan.getMachineIntelligent().getLocation().setLatitudeCount(recentScan.getMachineIntelligent().getLocation().getLatitudeCount() + 1);
                        }
                        if (!TextUtils.isEmpty(t)) {
                            recentScan.getMachineIntelligent().getLocation().setLongitudeweight(a(recentScan.getMachineIntelligent().getLocation().getLongitudeweight(), Double.parseDouble(t), recentScan.getMachineIntelligent().getLocation().getLongitudeCount()));
                            recentScan.getMachineIntelligent().getLocation().setLongitudeCount(recentScan.getMachineIntelligent().getLocation().getLongitudeCount() + 1);
                        }
                        recentScan.getMachineIntelligent().getTimeOfDay().setTimeOfDayweight(a(recentScan.getMachineIntelligent().getTimeOfDay().getTimeOfDayweight(), currentTimeMillis, recentScan.getMachineIntelligent().getTimeOfDay().getTimeOfDayCount()));
                        recentScan.getMachineIntelligent().getTimeOfDay().setTimeOfDayCount(recentScan.getMachineIntelligent().getTimeOfDay().getTimeOfDayCount() + 1);
                        recentScan.getMachineIntelligent().getWeekday().updateweekdaycount(recentScan.getMachineIntelligent().getWeekday(), i2);
                        recentScan2.setMachineIntelligent(recentScan.getMachineIntelligent());
                        arrayList.remove(next);
                        return arrayList;
                    }
                } else {
                    continue;
                }
            }
        }
        a(iJRDataModel, context);
        return arrayList;
    }

    public static void a(IJRDataModel iJRDataModel, Context context) {
        if (iJRDataModel instanceof RecentScan) {
            String s = b.s(context);
            String t = b.t(context);
            double currentTimeMillis = (double) System.currentTimeMillis();
            int i2 = Calendar.getInstance().get(7);
            if (!TextUtils.isEmpty(s)) {
                RecentScan recentScan = (RecentScan) iJRDataModel;
                recentScan.getMachineIntelligent().getLocation().setLatitudeweight(Double.parseDouble(s));
                recentScan.getMachineIntelligent().getLocation().setLatitudeCount(1);
            }
            if (!TextUtils.isEmpty(t)) {
                RecentScan recentScan2 = (RecentScan) iJRDataModel;
                recentScan2.getMachineIntelligent().getLocation().setLongitudeweight(Double.parseDouble(t));
                recentScan2.getMachineIntelligent().getLocation().setLongitudeCount(1);
            }
            RecentScan recentScan3 = (RecentScan) iJRDataModel;
            recentScan3.getMachineIntelligent().getTimeOfDay().setTimeOfDayweight(currentTimeMillis);
            recentScan3.getMachineIntelligent().getTimeOfDay().setTimeOfDayCount(1);
            recentScan3.getMachineIntelligent().getWeekday().updateweekdaycount(recentScan3.getMachineIntelligent().getWeekday(), i2);
        }
    }

    public static ArrayList<IJRDataModel> b(Context context) {
        Object a2 = e.a(context, "recents_data");
        if (a2 instanceof ArrayList) {
            return (ArrayList) a2;
        }
        return null;
    }

    public static IJRDataModel a(Context context, String str) {
        ArrayList<IJRDataModel> b2 = b(context);
        if (b2 != null) {
            Iterator<IJRDataModel> it2 = b2.iterator();
            while (it2.hasNext()) {
                IJRDataModel next = it2.next();
                if ((next instanceof RecentScan) && str.equalsIgnoreCase(((RecentScan) next).getUniqKey())) {
                    return next;
                }
            }
        }
        return null;
    }
}
