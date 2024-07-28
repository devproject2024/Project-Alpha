package net.one97.paytm.passbook.genericPassbook.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.passbook.R;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f57334a;

    /* renamed from: b  reason: collision with root package name */
    private int f57335b;

    /* renamed from: c  reason: collision with root package name */
    private int f57336c;

    /* renamed from: i  reason: collision with root package name */
    public int f57337i;
    public Context j;

    public abstract LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> a(int i2);

    public abstract RecyclerView.a<RecyclerView.v> a(c cVar, RecyclerView recyclerView);

    public abstract void a();

    public void a(int i2, int i3, Intent intent) {
    }

    public abstract void a(int i2, Runnable runnable);

    public abstract void a(Context context, View view);

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(MenuItem menuItem) {
    }

    public void a(View view) {
        k.c(view, "view");
    }

    public void a(FrameLayout frameLayout) {
        k.c(frameLayout, "pbBannerContainer");
    }

    public abstract void a(TextView textView);

    public abstract void a(Throwable th);

    public abstract String[] b();

    public abstract Fragment c();

    public abstract LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> d();

    public abstract boolean e();

    public abstract o<String, ArrayList<String>> f();

    public abstract void g();

    public abstract String h();

    public abstract Drawable i();

    public abstract int j();

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    private b(Context context) {
        this.j = context;
        a();
        this.f57334a = true;
        this.f57335b = R.string.wallet;
        this.f57337i = R.string.pass_available_balance;
        this.f57336c = R.drawable.pass_ic_payment_bank;
    }

    public /* synthetic */ b(Context context, byte b2) {
        this(context);
    }
}
