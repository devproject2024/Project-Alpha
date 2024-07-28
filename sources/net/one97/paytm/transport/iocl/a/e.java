package net.one97.paytm.transport.iocl.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.databinding.f;
import androidx.lifecycle.z;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.google.android.material.snackbar.Snackbar;
import java.util.Calendar;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.widgets.a.d;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.a.i;
import net.one97.paytm.iocl.a.o;
import net.one97.paytm.transport.iocl.b.b;
import net.one97.paytm.transport.iocl.data.IOCLCommonResponse;

public class e extends a implements View.OnClickListener, d {

    /* renamed from: a  reason: collision with root package name */
    o f14238a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.transport.iocl.c.d f14239b;

    /* renamed from: c  reason: collision with root package name */
    a f14240c;

    /* renamed from: d  reason: collision with root package name */
    net.one97.paytm.common.widgets.e f14241d;

    /* renamed from: e  reason: collision with root package name */
    RelativeLayout f14242e;

    /* renamed from: f  reason: collision with root package name */
    ProgressBar f14243f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public z<IOCLCommonResponse> f14244g = new z<IOCLCommonResponse>() {
        public final /* synthetic */ void onChanged(Object obj) {
            e.this.f14243f.setVisibility(8);
            e.this.f14242e.setVisibility(0);
            net.one97.paytm.transport.iocl.c.d dVar = e.this.f14239b;
            if (!(dVar.a() == null || dVar.a().getUser() == null)) {
                dVar.q.set(dVar.a().getUser().getDob());
                dVar.o.set(dVar.a().getUser().getPincode());
                dVar.f14308g.set(Boolean.TRUE);
                dVar.f14309h.set(Boolean.FALSE);
                if (dVar.a().getUserEnrollmentMeta() != null) {
                    dVar.f14308g.set(Boolean.FALSE);
                    dVar.f14310i.set("You are already registered with IndianOil");
                    if (dVar.a().getUserEnrollmentMeta().getDupUCMId() != null) {
                        dVar.j.set(dVar.a().getUserEnrollmentMeta().getDupUCMId());
                    }
                    if (dVar.a().getUserEnrollmentMeta().getMemberNumber() != null) {
                        dVar.k.set(dVar.a().getUserEnrollmentMeta().getMemberNumber());
                    }
                }
                if (!dVar.s || dVar.b() != null) {
                    dVar.e();
                }
            }
            e.this.f14239b.f14296b.removeObserver(e.this.f14244g);
            e.this.b();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public z<CJRAadharPanGet> f14245h = new z<CJRAadharPanGet>() {
        public final /* synthetic */ void onChanged(Object obj) {
            e.this.f14239b.e();
            e.this.f14239b.f14297c.removeObserver(e.this.f14245h);
        }
    };

    public interface a {
        void onClickOnDatePicker();
    }

    public void onClick(View view) {
    }

    public static e a(Bundle bundle) {
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.transport.iocl.c.d dVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == b.f14274f && i3 == -1) {
            net.one97.paytm.transport.iocl.c.d dVar2 = this.f14239b;
            if (dVar2 != null) {
                dVar2.c();
            }
        } else if (i2 == b.f14273e && i3 == -1 && (dVar = this.f14239b) != null) {
            dVar.d();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14238a = (o) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.iocl_user_detail_fragment, viewGroup, false);
        this.f14242e = this.f14238a.f14153i;
        this.f14243f = this.f14238a.f14152h;
        this.f14240c = new a() {
            public final void onClickOnDatePicker() {
                e.this.c();
            }
        };
        if (getActivity() != null) {
            if (com.paytm.utility.b.c((Context) getActivity()) && com.paytm.utility.b.r((Context) getActivity())) {
                this.f14242e.setVisibility(8);
                this.f14243f.setVisibility(0);
            }
            this.f14239b = new net.one97.paytm.transport.iocl.c.d(this.f14240c, getActivity().getApplication(), getActivity());
            this.f14239b.f14296b.observe(this, this.f14244g);
            this.f14239b.f14297c.observe(this, this.f14245h);
            this.f14238a.a(this.f14239b);
            this.f14239b.u.observe(this, new z<String>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        e.this.f14238a.f14146b.setText(str);
                    }
                }
            });
            this.f14238a.j.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    e.this.a(view);
                }
            });
        }
        return this.f14238a.getRoot();
    }

    public void setSelectedDate(String str) {
        if (str == null) {
            return;
        }
        if (a(str)) {
            this.f14239b.q.set(str);
            return;
        }
        o oVar = this.f14238a;
        if (oVar != null) {
            Snackbar.a(oVar.getRoot(), (CharSequence) getActivity().getResources().getString(R.string.iocl_choose_valid_dob), -1).c();
        }
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.transport.iocl.c.a a() {
        return this.f14239b;
    }

    private static boolean a(String str) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        String[] split = str.split("-");
        try {
            instance2.set(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[0]));
            if (instance2.before(instance)) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.google.android.material.bottomsheet.a aVar, View view) {
        this.f14239b.f14308g.set(Boolean.TRUE);
        this.f14239b.f14310i.set(getActivity().getString(R.string.user_detail_header_create_new));
        this.f14238a.j.setVisibility(8);
        aVar.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        i iVar = (i) f.a(LayoutInflater.from(getContext()), R.layout.iocl_bottom_sheet_confirmation, (ViewGroup) null, false);
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(getActivity(), R.style.IOCLCustomBottomSheetDialogTheme);
        aVar.setContentView(iVar.getRoot());
        BottomSheetBehavior from = BottomSheetBehavior.from((View) iVar.getRoot().getParent());
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                BottomSheetBehavior.this.setState(4);
            }
        });
        from.setState(3);
        aVar.show();
        iVar.f14120b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.dismiss();
            }
        });
        iVar.f14119a.setOnClickListener(new View.OnClickListener(aVar) {
            private final /* synthetic */ a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                e.this.a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (this.f14241d == null) {
            this.f14241d = new net.one97.paytm.common.widgets.e();
            this.f14241d.f49899a = this;
            Bundle bundle = new Bundle();
            bundle.putString("default_dob", TextUtils.isEmpty(this.f14239b.q.get()) ? net.one97.paytm.transport.iocl.b.a.a("dd-MM-yyyy") : this.f14239b.q.get());
            bundle.putString("date_format", "dd-MM-yyyy");
            this.f14241d.setArguments(bundle);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString("default_dob", TextUtils.isEmpty(this.f14239b.q.get()) ? net.one97.paytm.transport.iocl.b.a.a("dd-MM-yyyy") : this.f14239b.q.get());
            bundle2.putString("date_format", "dd-MM-yyyy");
            this.f14241d.setArguments(bundle2);
        }
        if (!this.f14241d.isVisible() && getActivity().getSupportFragmentManager().c(H5Plugin.CommonEvents.DATE_PICKER) == null) {
            this.f14241d.show(getActivity().getSupportFragmentManager(), H5Plugin.CommonEvents.DATE_PICKER);
        }
    }
}
