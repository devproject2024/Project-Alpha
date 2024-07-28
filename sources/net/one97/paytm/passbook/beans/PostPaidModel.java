package net.one97.paytm.passbook.beans;

import android.content.Context;
import com.paytm.utility.b;
import net.one97.paytm.passbook.R;

public class PostPaidModel {
    private String errorHeading;
    private Context mApplicationContext;

    public PostPaidModel(Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public String getNodataText() {
        return this.mApplicationContext.getResources().getString(R.string.no_dat_load);
    }

    public boolean isInternetAvailable() {
        return b.c(this.mApplicationContext);
    }

    public String geterrorHeading() {
        return this.mApplicationContext.getResources().getString(R.string.network_error_heading);
    }
}
