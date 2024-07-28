package net.one97.paytm.transport.iocl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.CJRPGTokenListTransport;

public interface b {
    void addBottomBarTab(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener);

    Class getAJRAuthActivity();

    Class getAJRMainActivity();

    Class getCSTOrderIssuesActivity();

    Class getPaySendActivity();

    String getSSOToken(Context context);

    String getWalletSSOToken(Context context);

    String getWalletSSOToken(CJRPGTokenListTransport cJRPGTokenListTransport);

    void launchDeeplink(String str, Context context, String str2);

    void openH5CST(Activity activity, Bundle bundle);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, int i2);
}
