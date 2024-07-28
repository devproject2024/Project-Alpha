package net.one97.paytm.passbook.mapping;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.ResultReceiver;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.passbook.beans.BankAccStatusListener;
import net.one97.paytm.passbook.beans.CJRP2BStatus;
import net.one97.paytm.passbook.beans.CJRReplacementReason;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.beans.mlv.MerchantItem;
import net.one97.paytm.passbook.beans.upi.AccountProviderBody;
import net.one97.paytm.passbook.beans.upi.BankAccountDetails;
import net.one97.paytm.passbook.beans.upi.DeviceRegistrationFailure;
import net.one97.paytm.passbook.beans.upi.GetCredentialsResponse;
import net.one97.paytm.passbook.beans.upi.UPICheckBalanceListenerCallback;
import net.one97.paytm.passbook.beans.upi.UpiCallback;
import net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank;
import net.one97.paytm.passbook.beans.upi.UserUpiDetails;

public interface f {
    Class<?> A();

    String B();

    ContextWrapper a(Context context);

    Intent a(Activity activity, CJRP2BStatus cJRP2BStatus);

    Intent a(Context context, AccountProviderBody.AccountProvider accountProvider);

    Intent a(Context context, UserUpiDetails userUpiDetails);

    Intent a(IJRDataModel iJRDataModel);

    Fragment a(Activity activity, String str, a.c cVar, View view, String str2);

    String a(String str);

    String a(CJRPGTokenList cJRPGTokenList);

    ThemeData a(Context context, String str);

    void a(Activity activity);

    void a(Activity activity, Intent intent);

    void a(Activity activity, b bVar, a.c cVar);

    void a(Activity activity, String str, double d2, double d3);

    void a(Activity activity, String str, double d2, double d3, String str2);

    void a(Activity activity, String str, boolean z, boolean z2);

    void a(Activity activity, CJRP2BStatus cJRP2BStatus, Intent intent);

    void a(Activity activity, net.one97.paytm.passbook.c.a aVar, String str);

    void a(Context context, String str, String str2);

    void a(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4);

    void a(Context context, BankAccStatusListener bankAccStatusListener);

    void a(ContextThemeWrapper contextThemeWrapper);

    void a(AppCompatActivity appCompatActivity, String str);

    void a(AppCompatActivity appCompatActivity, CJRTransaction cJRTransaction);

    void a(Fragment fragment, AccountProviderBody.AccountProvider accountProvider, String str);

    void a(String str, Activity activity);

    void a(String str, TextView textView);

    void a(String str, String str2, Context context);

    void a(String str, String str2, BankAccountDetails.BankAccount bankAccount, ResultReceiver resultReceiver);

    void a(String str, MerchantItem merchantItem);

    void a(List<GetCredentialsResponse> list, String str, UpiProfileDefaultBank upiProfileDefaultBank, UpiCallback upiCallback);

    void a(Map<String, Object> map);

    void a(UpiCallback upiCallback);

    void a(UpiCallback upiCallback, DeviceRegistrationFailure deviceRegistrationFailure);

    void a(UpiProfileDefaultBank upiProfileDefaultBank, Activity activity, Fragment fragment, UPICheckBalanceListenerCallback uPICheckBalanceListenerCallback);

    void a(IJRDataModel iJRDataModel, Context context);

    void a(IJRDataModel iJRDataModel, CJRReplacementReason cJRReplacementReason, String str);

    boolean a(Activity activity, Exception exc);

    boolean a(String str, boolean z);

    int b(Context context);

    Context b();

    void b(Activity activity);

    void b(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void b(String str);

    void b(String str, String str2, Context context);

    void b(UpiCallback upiCallback);

    Class<?> c();

    String c(String str);

    void c(Activity activity);

    void c(UpiCallback upiCallback);

    boolean c(Context context);

    int d(Context context);

    Class<?> d();

    void d(String str);

    Intent e(Context context);

    Class<?> e();

    Intent f(Context context);

    Class<?> f();

    String g();

    void g(Context context);

    Class<?> h();

    boolean h(Context context);

    Class<?> i();

    void i(Context context);

    boolean j();

    boolean j(Context context);

    String k();

    String l();

    boolean m();

    Class<?> n();

    Class<?> o();

    String p();

    String q();

    void r();

    void s();

    Class<?> t();

    Class<?> u();

    Class<?> v();

    Class<?> w();

    String x();

    Class<?> y();

    String z();
}
