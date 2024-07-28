package net.one97.paytm.paymentsBank.cifCreation.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.h.u;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.n;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.cifCreation.CIFBaseActivity;
import net.one97.paytm.paymentsBank.cifCreation.a.a;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFCreationResponse;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFStatusResponse;
import net.one97.paytm.paymentsBank.cifCreation.view.a.b;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.si.c.f;
import net.one97.paytm.paymentsBank.slfd.c;

public final class CIFCreateActivity extends CIFBaseActivity implements View.OnClickListener, a.b, b.a, f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f18040c = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public a.C0295a f18041b;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f18042d;

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f18043e;

    /* renamed from: f  reason: collision with root package name */
    private View f18044f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f18045g;

    /* renamed from: h  reason: collision with root package name */
    private int f18046h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f18047i;

    public final View a(int i2) {
        if (this.f18047i == null) {
            this.f18047i = new HashMap();
        }
        View view = (View) this.f18047i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f18047i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void f() {
        i().b(true);
    }

    public final void g() {
        i().a(false);
    }

    public final void b(boolean z) {
        if (z) {
            i().c();
            return;
        }
        a(false);
        com.paytm.utility.b.a((Context) this, getString(R.string.pb_fd_tnc_saved));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private a.C0295a i() {
        a.C0295a aVar = this.f18041b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.activity_cif_create;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c cVar = c.f18958a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        a.C0295a aVar = new net.one97.paytm.paymentsBank.cifCreation.b.a(c.a(applicationContext), this);
        k.c(aVar, "<set-?>");
        this.f18041b = aVar;
        i().a();
        if (getIntent().getBooleanExtra("EXTRA_FLAG_CIF_CREATED", false)) {
            getSupportFragmentManager().a().b(R.id.fragment_container_benefits, b.a(false, false), b.class.getName()).c();
            a(new CIFCreationResponse((String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Boolean) null, 127, (g) null));
        } else {
            getSupportFragmentManager().a().b(R.id.fragment_container_benefits, b.a(true, false), b.class.getName()).c();
        }
        this.f18042d = (RelativeLayout) findViewById(R.id.fd_loader_lyt);
        this.f18043e = (LottieAnimationView) findViewById(R.id.fd_loader);
        ((ImageView) a(R.id.iv_back_arrow)).setOnClickListener(this);
        View findViewById = findViewById(R.id.pb_progress);
        k.a((Object) findViewById, "findViewById<ProgressBar>(R.id.pb_progress)");
        this.f18045g = (ProgressBar) findViewById;
        ProgressBar progressBar = this.f18045g;
        if (progressBar == null) {
            k.a("pbProgress");
        }
        u.g((View) progressBar, 10.0f);
        View findViewById2 = findViewById(R.id.parent);
        k.a((Object) findViewById2, "findViewById(R.id.parent)");
        this.f18044f = findViewById2;
        c(true);
    }

    public final void onClick(View view) {
        k.c(view, "view");
        if (view.getId() == R.id.iv_back_arrow) {
            finish();
        }
    }

    public final void h() {
        i().c();
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        View view = this.f18044f;
        if (view == null) {
            k.a("parentContainer");
        }
        Snackbar a2 = Snackbar.a(view, (CharSequence) str2, 0);
        k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public final void a(CIFCreationResponse cIFCreationResponse) {
        k.c(cIFCreationResponse, "cifCreationResponse");
        net.one97.paytm.paymentsBank.cifCreation.view.a.a aVar = new net.one97.paytm.paymentsBank.cifCreation.view.a.a();
        aVar.setCancelable(false);
        aVar.show(getSupportFragmentManager(), "CIFCreationResponseBottomSheet");
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        k.c(slfdMetaApiResponseModel, "slfdMetaApiResponse");
        if (slfdMetaApiResponseModel.getPeakInterestRatePerAnnum() != null && slfdMetaApiResponseModel.getFdCalculatorFunc() != null) {
            Bundle bundle = new Bundle();
            Double peakInterestRatePerAnnum = slfdMetaApiResponseModel.getPeakInterestRatePerAnnum();
            if (peakInterestRatePerAnnum == null) {
                k.a();
            }
            bundle.putDouble("EXTRA_FD_RATE", peakInterestRatePerAnnum.doubleValue());
            Integer peakTenureMonths = slfdMetaApiResponseModel.getPeakTenureMonths();
            if (peakTenureMonths == null) {
                k.a();
            }
            bundle.putInt("EXTRA_FD_TENURE_MONTHS", peakTenureMonths.intValue());
            Integer peakTenureDays = slfdMetaApiResponseModel.getPeakTenureDays();
            if (peakTenureDays == null) {
                k.a();
            }
            bundle.putInt("EXTRA_FD_TENURE_DAYS", peakTenureDays.intValue());
            String fdCalculatorFunc = slfdMetaApiResponseModel.getFdCalculatorFunc();
            if (fdCalculatorFunc == null) {
                k.a();
            }
            bundle.putString("EXTRA_INTEREST_CALCULATOR_JS", fdCalculatorFunc);
            Double fdCapAmount = slfdMetaApiResponseModel.getFdCapAmount();
            int length = String.valueOf(fdCapAmount != null ? Long.valueOf((long) fdCapAmount.doubleValue()) : null).length();
            if (length > 0) {
                bundle.putInt("MAX_DIGITS", length);
            } else {
                bundle.putInt("MAX_DIGITS", 7);
            }
            getSupportFragmentManager().a().b(R.id.fragment_container, net.one97.paytm.paymentsBank.cifCreation.view.a.c.a(bundle), net.one97.paytm.paymentsBank.cifCreation.view.a.c.class.getName()).c();
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.f18046h++;
            ProgressBar progressBar = this.f18045g;
            if (progressBar == null) {
                k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar);
            return;
        }
        this.f18046h--;
        if (this.f18046h <= 0) {
            ProgressBar progressBar2 = this.f18045g;
            if (progressBar2 == null) {
                k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar2);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        i().b();
    }

    public final void a(double d2) {
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(CIFStatusResponse cIFStatusResponse) {
        k.c(cIFStatusResponse, "cifBottomSheetResponse");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        k.c(arrayList, "mTncDataList");
        Context context = this;
        if (!net.one97.paytm.bankCommon.mapping.a.c(context)) {
            com.paytm.utility.b.b(context, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
        } else if (arrayList.size() > 0) {
            f a2 = f.a(arrayList);
            a2.a((f.a) this);
            a2.show(getSupportFragmentManager(), "tncFragment");
        }
    }

    public final void c(boolean z) {
        if (z) {
            RelativeLayout relativeLayout = this.f18042d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            net.one97.paytm.common.widgets.a.a(this.f18043e);
            return;
        }
        RelativeLayout relativeLayout2 = this.f18042d;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        net.one97.paytm.common.widgets.a.b(this.f18043e);
    }
}
