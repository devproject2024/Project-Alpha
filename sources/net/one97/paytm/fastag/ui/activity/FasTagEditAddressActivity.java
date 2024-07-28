package net.one97.paytm.fastag.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.q;
import java.util.ArrayList;
import java.util.Collections;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.dependencies.j;
import net.one97.paytm.fastag.model.CJRAddress;
import net.one97.paytm.fastag.ui.c.a;

public class FasTagEditAddressActivity extends AppCompatActivity implements j {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRAddress> f13803a = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fastag_edit_address);
        boolean booleanExtra = getIntent().getBooleanExtra("edit address", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("no address", false);
        CJRAddress cJRAddress = (CJRAddress) getIntent().getSerializableExtra("address to update");
        this.f13803a = (ArrayList) getIntent().getSerializableExtra("address list to update");
        try {
            q a2 = getSupportFragmentManager().a();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("edit address", booleanExtra);
            bundle2.putSerializable("address to update", cJRAddress);
            bundle2.putBoolean("no address", booleanExtra2);
            a aVar = new a();
            aVar.setArguments(bundle2);
            a2.a(R.id.edit_address_layout_container, aVar, "new_address_fragment").b();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(CJRAddress cJRAddress) {
        int indexOf;
        if (cJRAddress.getPriority() == 1) {
            b();
            ArrayList<CJRAddress> arrayList = this.f13803a;
            if (arrayList != null && arrayList.size() > 0 && (indexOf = this.f13803a.indexOf(cJRAddress)) >= 0 && indexOf < this.f13803a.size()) {
                this.f13803a.get(indexOf).setPriority(1);
                Collections.swap(this.f13803a, 0, indexOf);
            }
        }
        ArrayList<CJRAddress> arrayList2 = this.f13803a;
        if (arrayList2 != null && arrayList2.size() == 0) {
            this.f13803a.add(cJRAddress);
        }
        a(this.f13803a);
    }

    public final void b(CJRAddress cJRAddress) {
        ArrayList<CJRAddress> arrayList = this.f13803a;
        if (arrayList != null && arrayList.size() > 0) {
            if (cJRAddress != null) {
                this.f13803a.remove(cJRAddress);
            }
            ArrayList<CJRAddress> arrayList2 = this.f13803a;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i2 = 0; i2 < this.f13803a.size(); i2++) {
                    this.f13803a.get(i2).setChecked(false);
                }
            }
        }
        a(this.f13803a);
    }

    public final void a() {
        finish();
    }

    public final void c(CJRAddress cJRAddress) {
        if (cJRAddress.getPriority() == 1) {
            b();
        }
        ArrayList<CJRAddress> arrayList = this.f13803a;
        if (arrayList != null && arrayList.size() > 0) {
            if (this.f13803a.contains(cJRAddress)) {
                this.f13803a.remove(cJRAddress);
            }
            if (cJRAddress.getPriority() == 1) {
                this.f13803a.add(0, cJRAddress);
            } else {
                this.f13803a.add(cJRAddress);
            }
        }
        ArrayList<CJRAddress> arrayList2 = this.f13803a;
        if (arrayList2 != null && arrayList2.size() == 0) {
            this.f13803a.add(cJRAddress);
        }
        a(this.f13803a);
    }

    private void b() {
        ArrayList<CJRAddress> arrayList = this.f13803a;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.f13803a.size(); i2++) {
                if (this.f13803a.get(i2).getPriority() == 1) {
                    this.f13803a.get(i2).setPriority(0);
                }
            }
        }
    }

    private void a(ArrayList<CJRAddress> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("address list to update", arrayList);
        setResult(-1, intent);
        finish();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
