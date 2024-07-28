package net.one97.paytm.moneytransfer.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.moneytransfer.contacts.b.a;
import net.one97.paytm.p2mNewDesign.models.QrData;
import net.one97.paytm.splitbill.SBMarkAsPaid;

public interface a {
    Context a();

    ContextWrapper a(Context context);

    Intent a(Activity activity);

    String a(String str);

    String a(String str, String str2);

    void a(Activity activity, int i2);

    void a(Activity activity, Exception exc, String str);

    void a(Activity activity, String str);

    void a(Activity activity, String str, boolean z);

    void a(Activity activity, CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel);

    void a(Activity activity, SBMarkAsPaid sBMarkAsPaid);

    void a(Context context, int i2);

    void a(Context context, Bundle bundle);

    void a(Context context, j jVar);

    void a(Context context, String str);

    void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void a(Context context, String str, String str2, String str3, boolean z);

    void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5);

    void a(Context context, a.c cVar);

    void a(Context context, QrData qrData);

    void a(View view, String str, FragmentActivity fragmentActivity, RecyclerView recyclerView);

    void a(Fragment fragment, CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel);

    void a(String str, View view);

    void a(String str, String str2, Context context);

    boolean a(Context context, Exception exc);

    boolean a(String str, boolean z);

    int b(String str);

    Intent b(Activity activity);

    String b();

    void b(String str, String str2);

    boolean b(Context context);

    String c();

    boolean c(Context context);

    String d();

    void d(Context context);

    String e();

    void e(Context context);

    String f();

    String g();

    void h();

    String i();

    String j();
}
