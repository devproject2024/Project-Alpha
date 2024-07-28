package net.one97.paytm.passbook.toll_kotlin.imported.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.paytm.network.a;
import com.paytm.utility.a;
import java.util.HashMap;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.mapping.a.b;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.subWallet.b.f;
import net.one97.paytm.passbook.toll_kotlin.model.TollTagListModel;
import org.json.JSONObject;

public class TollTxnPsgHstryModel {
    private Context context;
    private Context mApplicationContext;

    public TollTxnPsgHstryModel(Context context2) {
        this.mApplicationContext = context2.getApplicationContext();
        this.context = context2;
    }

    public b getTollEntriesRequest(int i2, int i3, i.a aVar, g gVar) {
        e.a();
        String r = e.r();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("ssotoken", a.q(this.context));
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", i2);
            jSONObject2.put("startIndex", i3);
            jSONObject.put("request", jSONObject2);
            return new b(r, aVar, gVar, new TollWalletpsgHstryResponseModel(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, f.class.getName());
        } catch (Exception unused) {
            return null;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public String getErrorHeading() {
        return this.context.getResources().getString(R.string.error);
    }

    public String getamountFormattedString(String str, String str2) {
        String string = this.context.getResources().getString(R.string.recharge_rs);
        if (str2 == null) {
            return string;
        }
        if (str2.equalsIgnoreCase(net.one97.paytm.passbook.toll_kotlin.imported.b.f58949a)) {
            return " + " + String.format(string, new Object[]{str});
        } else if (str2.equalsIgnoreCase(net.one97.paytm.passbook.toll_kotlin.imported.b.f58950b)) {
            return " - " + String.format(string, new Object[]{str});
        } else {
            return String.format(string, new Object[]{str});
        }
    }

    public String getDateFormattedString(String str) {
        return com.paytm.utility.b.h(str, "yyyy-MM-dd'T'HH:mm:ss", "MMMM dd , hh:mm a");
    }

    public Bitmap getVehicleType(String str) {
        return BitmapFactory.decodeResource(this.context.getResources(), R.drawable.pass_car);
    }

    public String getTollString() {
        return this.context.getResources().getString(R.string.toll);
    }

    public String getFormattedPlazaName(String str) {
        return String.format(this.context.getResources().getString(R.string.paid_at), new Object[]{str});
    }

    public String getplazaIdFormattedString(String str) {
        return String.format(this.context.getResources().getString(R.string.paid_at_plaza_id), new Object[]{str});
    }

    public String getformattedRegNum(String str) {
        return String.format(this.context.getResources().getString(R.string.veh_reg_no), new Object[]{str});
    }

    public String getformattedlaneName(String str) {
        return String.format(this.context.getResources().getString(R.string.lane_name), new Object[]{str});
    }

    public Bitmap getCircularImageBmp() {
        return TollTagListModel.Companion.getCircularBitmapWithWhiteBorder(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.pass_car), 5);
    }

    public int getSendReceiveDrawable(String str) {
        if (str != null) {
            if (str.equalsIgnoreCase(net.one97.paytm.passbook.toll_kotlin.imported.b.f58949a)) {
                return R.drawable.pass_money_received;
            }
            if (str.equalsIgnoreCase(net.one97.paytm.passbook.toll_kotlin.imported.b.f58950b)) {
                return R.drawable.pass_money_sent;
            }
        }
        return 0;
    }
}
