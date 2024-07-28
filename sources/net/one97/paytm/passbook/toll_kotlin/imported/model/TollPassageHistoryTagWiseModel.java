package net.one97.paytm.passbook.toll_kotlin.imported.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.toll_kotlin.imported.b;
import net.one97.paytm.passbook.toll_kotlin.model.TollTagListModel;
import net.one97.paytm.upi.util.UpiConstants;

public class TollPassageHistoryTagWiseModel {
    private Context context;
    private Context mApplicatinContext;

    public TollPassageHistoryTagWiseModel(Context context2) {
        this.context = context2;
        this.mApplicatinContext = context2.getApplicationContext();
    }

    public Context getContext() {
        return this.context;
    }

    public String getamountFormattedString(String str, String str2) {
        String string = this.context.getResources().getString(R.string.recharge_rs);
        if (str2.equalsIgnoreCase(b.f58949a)) {
            return " + " + String.format(string, new Object[]{str});
        } else if (str2.equalsIgnoreCase(b.f58950b)) {
            return " - " + String.format(string, new Object[]{str});
        } else {
            return String.format(string, new Object[]{str});
        }
    }

    public String getDateFormattedString(String str) {
        return com.paytm.utility.b.h(str, "yyyy-MM-dd'T'HH:mm:ss", "MMMM dd , hh:mm a");
    }

    public String getFormattedPlazaName(String str) {
        return String.format(this.context.getResources().getString(R.string.paid_at), new Object[]{str});
    }

    public String getTollString() {
        return this.context.getResources().getString(R.string.toll);
    }

    public String getplazaIdFormattedString(String str) {
        return String.format(this.context.getResources().getString(R.string.paid_at_plaza_id), new Object[]{str});
    }

    public String getformattedRegNum(String str) {
        return String.format(this.context.getResources().getString(R.string.toll_txn_id), new Object[]{str});
    }

    public String getformattedlaneName(String str) {
        return String.format(this.context.getResources().getString(R.string.lane_name), new Object[]{str});
    }

    public Bitmap getCircularImageBitMap() {
        return TollTagListModel.Companion.getCircularBitmapWithWhiteBorder(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.pass_car), 5);
    }

    public Context getmApplicatinContext() {
        return this.mApplicatinContext;
    }

    public int getSendReceiveDrawable(String str) {
        if (str.equalsIgnoreCase(AppConstants.FEED_COMMUNITY)) {
            return R.drawable.pass_money_received;
        }
        if (str.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
            return R.drawable.pass_money_sent;
        }
        return 0;
    }
}
