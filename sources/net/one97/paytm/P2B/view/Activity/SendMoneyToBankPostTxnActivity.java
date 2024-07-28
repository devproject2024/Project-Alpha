package net.one97.paytm.p2b.view.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.network.a;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRTransaction;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.m;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.b.f;
import net.one97.paytm.p2b.d.d;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.p2b.d.j;
import net.one97.paytm.p2b.data.a;
import net.one97.paytm.p2b.e.c;
import net.one97.paytm.p2b.view.CustomView.P2BShimmerFrameLayout;
import net.one97.paytm.upi.util.UpiConstants;

public final class SendMoneyToBankPostTxnActivity extends PaytmActivity implements View.OnClickListener, j {

    /* renamed from: a  reason: collision with root package name */
    public c f12820a;

    /* renamed from: b  reason: collision with root package name */
    private SFWidget f12821b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f12822c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f12823d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f12824e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f12825f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f12826g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    private f f12827h;

    /* renamed from: i  reason: collision with root package name */
    private ConstraintLayout f12828i;
    private P2BShimmerFrameLayout j;
    private FrameLayout k;
    private FrameLayout l;
    private String m;

    static final class b<T> implements z<SanitizedResponseModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SendMoneyToBankPostTxnActivity f12831a;

        b(SendMoneyToBankPostTxnActivity sendMoneyToBankPostTxnActivity) {
            this.f12831a = sendMoneyToBankPostTxnActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SanitizedResponseModel sanitizedResponseModel = (SanitizedResponseModel) obj;
            SendMoneyToBankPostTxnActivity.a(this.f12831a, sanitizedResponseModel.getSfWidgets(), sanitizedResponseModel.getGaListener());
        }
    }

    public final void onCreate(Bundle bundle) {
        y<IJRDataModel> yVar;
        super.onCreate(bundle);
        setContentView(R.layout.p2b_activity_post_transaction);
        this.f12823d = (RelativeLayout) findViewById(R.id.toolbar);
        this.f12824e = (ImageView) findViewById(R.id.backArrowImv);
        ImageView imageView = this.f12824e;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.f12825f = (ImageView) findViewById(R.id.shareImv);
        ImageView imageView2 = this.f12825f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        this.f12828i = (ConstraintLayout) findViewById(R.id.dummyviewparent);
        this.l = (FrameLayout) findViewById(R.id.fl_passbook_navigation_controller);
        this.k = (FrameLayout) findViewById(R.id.fl_deals_container);
        this.j = (P2BShimmerFrameLayout) findViewById(R.id.dummyview);
        ai a2 = new al((ao) this, (al.b) al.a.a(getApplication())).a(c.class);
        k.a((Object) a2, "ViewModelProvider(\n     …TxnViewModel::class.java)");
        this.f12820a = (c) a2;
        c cVar = this.f12820a;
        if (cVar == null) {
            k.a("viewModel");
        }
        y<net.one97.paytm.p2b.data.a<Double>> yVar2 = cVar.f12788d;
        a.C0168a aVar = net.one97.paytm.p2b.data.a.f12728d;
        yVar2.setValue(a.C0168a.a());
        net.one97.paytm.p2b.data.a.b bVar = cVar.f12785a;
        if (bVar != null) {
            bVar.b(new c.C0171c(cVar), cVar.w);
        }
        getSupportFragmentManager().a().a(R.id.fl_transaction_details, (Fragment) new net.one97.paytm.p2b.view.c.j()).c();
        getSupportFragmentManager().a().a(R.id.fl_passbook_navigation_controller, (Fragment) new net.one97.paytm.p2b.view.c.a()).c();
        h.a aVar2 = h.f12718a;
        String a3 = h.b(h.a.a()).a("p2b_home_url", "https://storefront.paytm.com/v2/h/p2b-post-transaction");
        if (a3 != null) {
            c cVar2 = this.f12820a;
            if (cVar2 == null) {
                k.a("viewModel");
            }
            cVar2.f12786b.observe(this, new b(this));
            c cVar3 = this.f12820a;
            if (cVar3 == null) {
                k.a("viewModel");
            }
            k.c(a3, "url");
            String e2 = com.paytm.utility.b.e((Context) cVar3.getApplication(), a3);
            SFInterface sFInterface = SFInterface.INSTANCE;
            k.a((Object) e2, "newUrl");
            sFInterface.getStoreFrontReponse(e2, new HashMap(), a.c.ADDMONEY, new c.d(cVar3), "P2B_post_txn", 1004, (IGAEnableListener) null);
        }
        Intent intent = getIntent();
        if (intent != null) {
            c cVar4 = this.f12820a;
            if (cVar4 == null) {
                k.a("viewModel");
            }
            if (cVar4 != null) {
                cVar4.o = Double.valueOf(intent.getDoubleExtra(net.one97.paytm.p2b.d.c.S, 0.0d));
            }
            Serializable serializableExtra = intent.getSerializableExtra(net.one97.paytm.p2b.d.c.U);
            if (serializableExtra != null) {
                c cVar5 = this.f12820a;
                if (cVar5 == null) {
                    k.a("viewModel");
                }
                if (serializableExtra != null) {
                    cVar5.p = (CJRP2BStatus) serializableExtra;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.wallet.CJRP2BStatus");
                }
            }
            c cVar6 = this.f12820a;
            if (cVar6 == null) {
                k.a("viewModel");
            }
            if (cVar6 != null) {
                yVar = cVar6.f12792h;
            } else {
                yVar = null;
            }
            yVar.setValue((IJRDataModel) intent.getSerializableExtra(net.one97.paytm.p2b.d.c.N));
            c cVar7 = this.f12820a;
            if (cVar7 == null) {
                k.a("viewModel");
            }
            if (cVar7 != null) {
                cVar7.f12793i = intent.getStringExtra(net.one97.paytm.p2b.d.c.O);
            }
            c cVar8 = this.f12820a;
            if (cVar8 == null) {
                k.a("viewModel");
            }
            if (cVar8 != null) {
                cVar8.q = intent.getStringExtra(net.one97.paytm.p2b.d.c.Q);
            }
            c cVar9 = this.f12820a;
            if (cVar9 == null) {
                k.a("viewModel");
            }
            if (cVar9 != null) {
                cVar9.j = intent.getStringExtra(net.one97.paytm.p2b.d.c.P);
            }
            c cVar10 = this.f12820a;
            if (cVar10 == null) {
                k.a("viewModel");
            }
            if (cVar10 != null) {
                cVar10.k = intent.getStringExtra(net.one97.paytm.p2b.d.c.R);
            }
            c cVar11 = this.f12820a;
            if (cVar11 == null) {
                k.a("viewModel");
            }
            if (cVar11 != null) {
                cVar11.n = intent.getStringExtra(net.one97.paytm.p2b.d.c.T);
            }
            c cVar12 = this.f12820a;
            if (cVar12 == null) {
                k.a("viewModel");
            }
            if (cVar12 != null) {
                cVar12.m = Double.valueOf(intent.getDoubleExtra(net.one97.paytm.p2b.d.c.f12674d, 0.0d));
            }
            c cVar13 = this.f12820a;
            if (cVar13 == null) {
                k.a("viewModel");
            }
            if (cVar13 != null) {
                cVar13.r = intent.getStringExtra(net.one97.paytm.p2b.d.c.f12673c);
            }
            c cVar14 = this.f12820a;
            if (cVar14 == null) {
                k.a("viewModel");
            }
            if (cVar14 != null) {
                cVar14.s = Boolean.valueOf(intent.getBooleanExtra("is_self", false));
            }
            c cVar15 = this.f12820a;
            if (cVar15 == null) {
                k.a("viewModel");
            }
            if (cVar15 != null) {
                cVar15.v = intent.getStringExtra(net.one97.paytm.p2b.d.c.f12677g);
            }
            this.m = intent.getStringExtra("key_source");
        }
        h.a aVar3 = h.f12718a;
        h.b(h.a.a()).a(this, "P2B", "Confirmation_screen_loaded", (String) null, this.m, (String) null, "p2b", "P2B");
    }

    public final void a(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "mTransaction");
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJRTransaction);
        bundle.putLong("intent_flag", 67108864);
        Activity activity = this;
        k.c(activity, "activity");
        a(activity);
        h.a aVar = h.f12718a;
        h.b(h.a.a()).a(activity, bundle, (m) new a(this, activity));
    }

    public final void a() {
        h.a aVar = h.f12718a;
        h.b(h.a.a()).b((Activity) this);
    }

    public final void b() {
        h.a aVar = h.f12718a;
        h.b(h.a.a()).c((Activity) this);
    }

    public final void c() {
        String str;
        if (!s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                a((Activity) this);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.p2b_share_subject));
                int i2 = R.string.p2b_share_message;
                Object[] objArr = new Object[2];
                c cVar = this.f12820a;
                if (cVar == null) {
                    k.a("viewModel");
                }
                String str2 = null;
                if (cVar != null) {
                    str = cVar.q;
                } else {
                    str = null;
                }
                objArr[0] = str;
                c cVar2 = this.f12820a;
                if (cVar2 == null) {
                    k.a("viewModel");
                }
                if (cVar2 != null) {
                    str2 = cVar2.k;
                }
                objArr[1] = net.one97.paytm.p2b.d.k.a(str2, 4);
                intent.putExtra("android.intent.extra.TEXT", getString(i2, objArr));
                View findViewById = findViewById(R.id.scrollViewContainer);
                k.a((Object) findViewById, "findViewById(R.id.scrollViewContainer)");
                k.c(findViewById, "view");
                Bitmap createBitmap = Bitmap.createBitmap(findViewById.getWidth(), findViewById.getHeight(), Bitmap.Config.ARGB_8888);
                findViewById.draw(new Canvas(createBitmap));
                k.a((Object) createBitmap, "bitmap");
                intent.putExtra("android.intent.extra.STREAM", net.one97.paytm.p2b.d.k.a((Context) this, createBitmap));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.p2b_share_title));
                e();
                if (createChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(this, getString(R.string.p2b_no_app_found), 1).show();
                }
            } catch (Exception unused) {
                e();
            }
        } else {
            s.b((Activity) this);
        }
    }

    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SendMoneyToBankPostTxnActivity f12829a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f12830b;

        a(SendMoneyToBankPostTxnActivity sendMoneyToBankPostTxnActivity, Activity activity) {
            this.f12829a = sendMoneyToBankPostTxnActivity;
            this.f12830b = activity;
        }

        public final void dismiss() {
            this.f12829a.e();
        }

        public final void show() {
            this.f12829a.a(this.f12830b);
        }
    }

    /* access modifiers changed from: private */
    public final void a(Activity activity) {
        Dialog dialog;
        try {
            if (this.f12822c == null) {
                this.f12822c = d.a(activity);
            }
            if (this.f12822c != null) {
                Dialog dialog2 = this.f12822c;
                Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (!valueOf.booleanValue() && (dialog = this.f12822c) != null) {
                    dialog.show();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        Dialog dialog;
        try {
            if (this.f12822c != null) {
                Dialog dialog2 = this.f12822c;
                Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.booleanValue() && (dialog = this.f12822c) != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(boolean z, boolean z2) {
        if (z) {
            RelativeLayout relativeLayout = this.f12823d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            if (z2) {
                ImageView imageView = this.f12825f;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.f12825f;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.f12823d;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.shareImv;
        if (valueOf != null && valueOf.intValue() == i2) {
            c();
            return;
        }
        int i3 = R.id.backArrowImv;
        if (valueOf != null && valueOf.intValue() == i3) {
            onBackPressed();
        }
    }

    public final void d() {
        e();
    }

    public final void onDestroy() {
        super.onDestroy();
        c cVar = this.f12820a;
        if (cVar == null) {
            k.a("viewModel");
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void a(Boolean bool) {
        this.f12826g = bool;
    }

    public final void onBackPressed() {
        Boolean bool = this.f12826g;
        if (bool != null) {
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue()) {
                f fVar = this.f12827h;
                if (fVar == null) {
                    super.onBackPressed();
                    return;
                } else if (fVar != null) {
                    fVar.a();
                    return;
                } else {
                    return;
                }
            }
        }
        super.onBackPressed();
    }

    public final void a(f fVar) {
        this.f12827h = fVar;
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        h.a aVar = h.f12718a;
        if (h.b(h.a.a()).e(context) != null) {
            h.a aVar2 = h.f12718a;
            super.attachBaseContext(h.b(h.a.a()).e(context));
            return;
        }
        super.attachBaseContext(context);
    }

    public final void a(boolean z) {
        if (z) {
            ConstraintLayout constraintLayout = this.f12828i;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            P2BShimmerFrameLayout p2BShimmerFrameLayout = this.j;
            if (p2BShimmerFrameLayout != null) {
                p2BShimmerFrameLayout.a();
            }
            FrameLayout frameLayout = this.k;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            FrameLayout frameLayout2 = this.l;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout2 = this.f12828i;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        P2BShimmerFrameLayout p2BShimmerFrameLayout2 = this.j;
        if (p2BShimmerFrameLayout2 != null) {
            p2BShimmerFrameLayout2.b();
        }
        FrameLayout frameLayout3 = this.k;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        FrameLayout frameLayout4 = this.l;
        if (frameLayout4 != null) {
            frameLayout4.setVisibility(0);
        }
    }

    public static final /* synthetic */ void a(SendMoneyToBankPostTxnActivity sendMoneyToBankPostTxnActivity, LinkedHashMap linkedHashMap, StoreFrontGAHandler storeFrontGAHandler) {
        IWidgetProvider iWidgetProvider = (IWidgetProvider) linkedHashMap.get(104);
        sendMoneyToBankPostTxnActivity.f12821b = iWidgetProvider != null ? iWidgetProvider.getWidget(sendMoneyToBankPostTxnActivity, storeFrontGAHandler) : null;
        if (sendMoneyToBankPostTxnActivity.f12821b instanceof IStaticWidget) {
            c cVar = sendMoneyToBankPostTxnActivity.f12820a;
            if (cVar == null) {
                k.a("viewModel");
            }
            y<IStaticWidget> yVar = cVar.f12787c;
            SFWidget sFWidget = sendMoneyToBankPostTxnActivity.f12821b;
            if (sFWidget != null) {
                yVar.setValue((IStaticWidget) sFWidget);
                FrameLayout frameLayout = (FrameLayout) sendMoneyToBankPostTxnActivity.findViewById(R.id.lyt_bottom_tab_bar);
                SFWidget sFWidget2 = sendMoneyToBankPostTxnActivity.f12821b;
                if (sFWidget2 != null) {
                    frameLayout.addView(((IStaticWidget) sFWidget2).getView());
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
            }
            throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget");
        }
    }
}
