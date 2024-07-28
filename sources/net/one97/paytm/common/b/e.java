package net.one97.paytm.common.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.y;
import com.google.firebase.messaging.RemoteMessage;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.x;
import net.one97.paytm.common.entity.CJRCatalogSavedState;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.offline.OfflineLeadOTPModel;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.recharge.CJRBillDetails;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRSearchLayout;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.c.c;
import net.one97.paytm.landingpage.c.d;
import net.one97.paytm.landingpage.c.g;

public interface e {
    void A(Context context);

    boolean A();

    String B();

    void B(Context context);

    String C();

    void C(Context context);

    Context D();

    void D(Context context);

    String E();

    void E(Context context);

    IJRPaytmDataModel F();

    void F(Context context);

    void G();

    boolean G(Context context);

    void H();

    boolean H(Context context);

    String I();

    void I(Context context);

    boolean J();

    void K();

    void L();

    void M();

    Class<?> N();

    Class<?> O();

    Class<?> P();

    Class<?> Q();

    Class<?> R();

    Class<?> S();

    Class<?> T();

    Class<?> U();

    void V();

    void W();

    void X();

    int a(int i2);

    long a();

    Intent a(Context context);

    Intent a(FragmentActivity fragmentActivity);

    Fragment a(Bundle bundle);

    String a(Activity activity, String str);

    String a(Context context, String str, CJRBillDetails cJRBillDetails);

    String a(Context context, CJRFrequentOrder cJRFrequentOrder);

    String a(Double d2);

    String a(String str);

    String a(String str, String str2);

    String a(String str, String str2, boolean z);

    String a(CJRFrequentOrder cJRFrequentOrder, String str);

    ArrayList<String> a(IJRPaytmDataModel iJRPaytmDataModel);

    CJRUserInfoV2 a(CJRUserInfo cJRUserInfo);

    CJRBillDetails a(CJRBillDetails cJRBillDetails);

    void a(Activity activity);

    void a(Activity activity, String str, d dVar);

    void a(Activity activity, CJRSearchLayout cJRSearchLayout);

    void a(Activity activity, d dVar);

    void a(Application application);

    void a(Context context, Intent intent);

    void a(Context context, Bundle bundle);

    void a(Context context, j jVar);

    void a(Context context, j jVar, KYCStatusV2 kYCStatusV2);

    void a(Context context, RemoteMessage remoteMessage);

    void a(Context context, String str);

    void a(Context context, String str, String str2);

    void a(Context context, String str, String str2, String str3);

    void a(Context context, String str, String str2, String str3, String str4, String str5);

    void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void a(Context context, String str, ArrayList<String> arrayList);

    void a(Context context, String str, HashMap hashMap, m<String, Integer, Object> mVar);

    void a(Context context, String str, Map<String, String> map);

    void a(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, String str4);

    void a(Context context, List<Map<String, String>> list);

    void a(Context context, b<y<Integer>, x> bVar);

    void a(Context context, c cVar);

    void a(Context context, OfflineLeadOTPModel offlineLeadOTPModel);

    void a(Context context, StandingInstructionList standingInstructionList);

    void a(Context context, CJRFrequentOrder cJRFrequentOrder, IJRPaytmDataModel iJRPaytmDataModel);

    void a(Context context, CJRQRScanResultModel cJRQRScanResultModel);

    void a(Context context, net.one97.paytm.landingpage.c.b bVar);

    void a(Intent intent, Activity activity);

    void a(Intent intent, Context context, String str);

    void a(AppCompatActivity appCompatActivity);

    void a(Fragment fragment, int i2, Intent intent);

    void a(j jVar);

    void a(j jVar, Activity activity);

    void a(j jVar, c cVar);

    void a(Item item, int i2, String str, String str2, Context context);

    void a(String str, String str2, Activity activity);

    void a(String str, String str2, Context context);

    void a(String str, String str2, String str3);

    void a(String str, String str2, String str3, String str4, net.one97.paytm.landingpage.c.e eVar);

    void a(HashMap<String, Object> hashMap, Activity activity);

    void a(CJRCatalogSavedState cJRCatalogSavedState);

    void a(CJRUserInfoV2 cJRUserInfoV2, Context context);

    void a(KYCStatusV2 kYCStatusV2, Context context);

    void a(CustProductList custProductList, Context context, g gVar);

    void a(CJRFrequentOrder cJRFrequentOrder, Activity activity, int i2);

    void a(CJRFrequentOrder cJRFrequentOrder, Context context);

    void a(CJRFrequentOrderList cJRFrequentOrderList);

    void a(CJRCatalog cJRCatalog);

    void a(CJRShoppingCart cJRShoppingCart);

    void a(CJRShoppingCart cJRShoppingCart, Context context);

    void a(AJRMainActivity aJRMainActivity);

    void a(boolean z);

    boolean a(Activity activity, Intent intent);

    boolean a(Activity activity, NetworkCustomError networkCustomError);

    boolean a(Context context, int i2);

    boolean a(Fragment fragment);

    boolean a(IJRDataModel iJRDataModel, Context context);

    int b(String str);

    Intent b(Activity activity);

    Intent b(FragmentActivity fragmentActivity);

    String b(Context context);

    void b();

    void b(int i2);

    void b(Activity activity, String str);

    void b(Context context, Intent intent);

    void b(Context context, j jVar, KYCStatusV2 kYCStatusV2);

    void b(Context context, String str);

    void b(Context context, String str, String str2, String str3);

    void b(Context context, CJRFrequentOrder cJRFrequentOrder);

    void b(AppCompatActivity appCompatActivity);

    void b(j jVar);

    void b(j jVar, c cVar);

    void b(String str, String str2, Activity activity);

    void b(CJRUserInfoV2 cJRUserInfoV2, Context context);

    boolean b(Context context, int i2);

    boolean b(String str, String str2);

    Intent c(Context context);

    String c(String str);

    StandingInstructionList c(Context context, String str);

    void c();

    void c(Activity activity);

    void c(Activity activity, String str);

    void c(j jVar);

    boolean c(int i2);

    Intent d(Activity activity);

    ArrayList<CJRSearchLayout> d();

    void d(Context context, String str);

    void d(j jVar);

    boolean d(int i2);

    boolean d(Context context);

    boolean d(String str);

    Intent e(Context context);

    String e(String str);

    void e();

    void e(Activity activity);

    void e(Context context, String str);

    void e(j jVar);

    boolean e(int i2);

    int f(String str);

    Intent f(Activity activity);

    Intent f(Context context);

    Fragment f();

    boolean f(int i2);

    String g();

    void g(Activity activity);

    boolean g(Context context);

    ArrayList<IJRDataModel> h(Activity activity);

    boolean h();

    boolean h(Context context);

    Intent i(Activity activity);

    Fragment i();

    void i(Context context);

    Fragment j();

    void j(Activity activity);

    void j(Context context);

    CJRFrequentOrderList k();

    void k(Activity activity);

    boolean k(Context context);

    Intent l(Context context);

    String l();

    String m();

    boolean m(Context context);

    Intent n(Context context);

    String n();

    int o(Context context);

    String o();

    int p(Context context);

    Class<?> p();

    Map<String, String> q(Context context);

    CJRCatalog q();

    Intent r(Context context);

    void r();

    ArrayList<StandingInstructionList> s(Context context);

    void s();

    Context t(Context context);

    void t();

    Map<String, String> u(Context context);

    void u();

    void v();

    boolean v(Context context);

    void w();

    boolean w(Context context);

    @Deprecated
    int x();

    boolean x(Context context);

    boolean y();

    boolean y(Context context);

    boolean z();

    boolean z(Context context);
}
