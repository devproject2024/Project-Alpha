package net.one97.paytm.paymentsBank.slfd.nominee.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.h.u;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.c;
import net.one97.paytm.paymentsBank.slfd.nominee.a.a;
import net.one97.paytm.paymentsBank.utils.o;

public final class SlfdNomineeListActivity extends SlfdBaseActivity implements a.b {

    /* renamed from: b  reason: collision with root package name */
    public a.C0337a f19233b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f19234c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f19235d;

    /* renamed from: e  reason: collision with root package name */
    private Button f19236e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f19237f;

    /* renamed from: g  reason: collision with root package name */
    private a f19238g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f19239h;

    public final View a(int i2) {
        if (this.f19239h == null) {
            this.f19239h = new HashMap();
        }
        View view = (View) this.f19239h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f19239h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    private a.C0337a f() {
        a.C0337a aVar = this.f19233b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.activity_fd_select_nominee;
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("slfd_selected_nominee_position", 0);
        c cVar = c.f18958a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        a.C0337a aVar = new net.one97.paytm.paymentsBank.slfd.nominee.b.a(this, intExtra, c.a(applicationContext));
        k.c(aVar, "<set-?>");
        this.f19233b = aVar;
        this.f19238g = new a(f());
        View findViewById = findViewById(R.id.pb_progress);
        k.a((Object) findViewById, "findViewById<ProgressBar>(R.id.pb_progress)");
        this.f19237f = (ProgressBar) findViewById;
        ProgressBar progressBar = this.f19237f;
        if (progressBar == null) {
            k.a("pbProgress");
        }
        u.g((View) progressBar, 10.0f);
        View findViewById2 = findViewById(R.id.iv_back);
        ImageView imageView = (ImageView) findViewById2;
        imageView.setOnClickListener(new a(this));
        k.a((Object) findViewById2, "(findViewById<ImageView>…)\n            }\n        }");
        this.f19234c = imageView;
        View findViewById3 = findViewById(R.id.rv_nominee_list);
        k.a((Object) findViewById3, "findViewById<RecyclerView>(R.id.rv_nominee_list)");
        this.f19235d = (RecyclerView) findViewById3;
        RecyclerView recyclerView = this.f19235d;
        if (recyclerView == null) {
            k.a("rvNomineeList");
        }
        Context context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = this.f19235d;
        if (recyclerView2 == null) {
            k.a("rvNomineeList");
        }
        a aVar2 = this.f19238g;
        if (aVar2 == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(aVar2);
        RecyclerView recyclerView3 = this.f19235d;
        if (recyclerView3 == null) {
            k.a("rvNomineeList");
        }
        recyclerView3.addItemDecoration(new net.one97.paytm.paymentsBank.widget.a(context, androidx.core.content.b.a(context, R.drawable.pb_upi_passbook_item_divider_decoration), net.one97.paytm.bankCommon.mapping.a.a(60.0f, context)));
        View findViewById4 = findViewById(R.id.btn_add_nominee);
        Button button = (Button) findViewById4;
        button.setOnClickListener(new b(this));
        k.a((Object) findViewById4, "(findViewById<Button>(R.…)\n            }\n        }");
        this.f19236e = button;
        net.one97.paytm.bankCommon.mapping.c.a("/fixed-deposit/select-pb_nominee", "fixed-deposit", context);
        f().a();
    }

    public final void onDestroy() {
        super.onDestroy();
        f().b();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdNomineeListActivity f19240a;

        a(SlfdNomineeListActivity slfdNomineeListActivity) {
            this.f19240a = slfdNomineeListActivity;
        }

        public final void onClick(View view) {
            this.f19240a.finish();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdNomineeListActivity f19241a;

        b(SlfdNomineeListActivity slfdNomineeListActivity) {
            this.f19241a = slfdNomineeListActivity;
        }

        public final void onClick(View view) {
            Intent intent = this.f19241a.getIntent();
            intent.setClass(this.f19241a, PaymentsBankBaseActivity.class);
            intent.putExtra("extraDefaultFrame", 2);
            intent.putExtra("DO_CREATE_ACCOUNT", false);
            intent.putExtra("add_nominee_for_slfd", true);
            this.f19241a.startActivityForResult(intent, 2);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2 && i3 == -1) {
            f().a();
        }
    }

    public final void a() {
        a aVar = this.f19238g;
        if (aVar == null) {
            k.a("adapter");
        }
        aVar.notifyDataSetChanged();
    }

    public final void a(SlfdNomineeModel slfdNomineeModel, int i2) {
        k.c(slfdNomineeModel, "nominee");
        net.one97.paytm.bankCommon.mapping.c.a(this, "fixed_deposit", "select_nominee_radio_button_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/select-pb_nominee", "fixed_deposit");
        Intent intent = getIntent();
        intent.putExtra("slfd_nominee", slfdNomineeModel);
        intent.putExtra("slfd_selected_nominee_position", i2);
        setResult(-1, intent);
        finish();
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, str, str2);
    }

    public final void a(boolean z) {
        if (z) {
            ProgressBar progressBar = this.f19237f;
            if (progressBar == null) {
                k.a("pbProgress");
            }
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = this.f19237f;
        if (progressBar2 == null) {
            k.a("pbProgress");
        }
        progressBar2.setVisibility(8);
    }
}
