package net.one97.paytm.transport.iocl_v1.a;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.databinding.f;
import androidx.lifecycle.z;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import java.util.Calendar;
import net.one97.paytm.common.widgets.a.d;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.a.m;
import net.one97.paytm.iocl.a.q;
import net.one97.paytm.transport.iocl_v1.c.b;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;

public class e extends a implements View.OnClickListener, d {

    /* renamed from: a  reason: collision with root package name */
    q f14349a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.transport.iocl_v1.c.a f14350b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.transport.iocl_v1.c.d f14351c;

    /* renamed from: d  reason: collision with root package name */
    a f14352d;

    /* renamed from: e  reason: collision with root package name */
    net.one97.paytm.common.widgets.e f14353e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public z<IOCLCommonResponse> f14354f = new z<IOCLCommonResponse>() {
        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.transport.iocl_v1.c.d dVar = e.this.f14351c;
            if (!(dVar.a() == null || dVar.a().getUser() == null)) {
                dVar.f14443g.set(dVar.a().getUser().getName());
                dVar.m.set(dVar.a().getUser().getGender());
                dVar.k.set(dVar.a().getUser().getDob());
                dVar.f14445i.set(dVar.a().getUser().getPincode());
            }
            e.this.f14351c.f14434b.removeObserver(e.this.f14354f);
            e.this.b();
        }
    };

    public interface a {
        void a();
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
        this.f14352d = new a() {
            public final void a() {
                e.a(e.this);
            }
        };
        if (getActivity() != null) {
            this.f14351c = new net.one97.paytm.transport.iocl_v1.c.d(this.f14352d, getActivity().getApplication(), getActivity());
            this.f14351c.f14434b.observe(this, this.f14354f);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14349a = (q) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.iocl_user_detail_fragment_v1, viewGroup, false);
        if (getActivity() != null) {
            this.f14349a.a(this.f14351c);
            this.f14351c.p.observe(this, new z<String>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        e.this.f14349a.f14159b.setText(str);
                    }
                }
            });
            this.f14350b = new net.one97.paytm.transport.iocl_v1.c.a(getActivity().getApplication());
            this.f14350b.f14432d.observe(this, new z<String>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        e.this.f14349a.f14160c.setText(str);
                    }
                }
            });
            this.f14349a.f14160c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    e.c(e.this);
                }
            });
        }
        return this.f14349a.getRoot();
    }

    public void setSelectedDate(String str) {
        if (str == null) {
            return;
        }
        if (a(str)) {
            this.f14351c.k.set(str);
            return;
        }
        q qVar = this.f14349a;
        if (qVar != null) {
            Snackbar.a(qVar.getRoot(), (CharSequence) getActivity().getResources().getString(R.string.iocl_choose_valid_dob), -1).c();
        }
    }

    /* access modifiers changed from: protected */
    public final b a() {
        return this.f14351c;
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

    static /* synthetic */ void a(e eVar) {
        if (eVar.f14353e == null) {
            eVar.f14353e = new net.one97.paytm.common.widgets.e();
            eVar.f14353e.f49899a = eVar;
            Bundle bundle = new Bundle();
            bundle.putString("default_dob", TextUtils.isEmpty(eVar.f14351c.k.get()) ? net.one97.paytm.transport.iocl_v1.b.a.a("dd-MM-yyyy") : eVar.f14351c.k.get());
            bundle.putString("date_format", "dd-MM-yyyy");
            eVar.f14353e.setArguments(bundle);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString("default_dob", TextUtils.isEmpty(eVar.f14351c.k.get()) ? net.one97.paytm.transport.iocl_v1.b.a.a("dd-MM-yyyy") : eVar.f14351c.k.get());
            bundle2.putString("date_format", "dd-MM-yyyy");
            eVar.f14353e.setArguments(bundle2);
        }
        if (!eVar.f14353e.isVisible() && eVar.getActivity().getSupportFragmentManager().c(H5Plugin.CommonEvents.DATE_PICKER) == null) {
            eVar.f14353e.show(eVar.getActivity().getSupportFragmentManager(), H5Plugin.CommonEvents.DATE_PICKER);
        }
    }

    static /* synthetic */ void c(e eVar) {
        final m mVar = (m) f.a(LayoutInflater.from(eVar.getContext()), R.layout.iocl_bottom_sheet_gender_v1, (ViewGroup) null, false);
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(eVar.getActivity());
        aVar.setContentView(mVar.getRoot());
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) mVar.getRoot().getParent());
        mVar.f14138c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (i2 == R.id.rd_female) {
                    net.one97.paytm.transport.iocl_v1.c.a aVar = e.this.f14350b;
                    aVar.f14430b.set(Boolean.TRUE);
                    aVar.f14429a.set(Boolean.FALSE);
                    aVar.f14431c.set(Boolean.FALSE);
                    aVar.f14432d.setValue(aVar.getApplication().getString(R.string.female));
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14137b, 1);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14139d, 0);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14140e, 0);
                } else if (i2 == R.id.rd_male) {
                    net.one97.paytm.transport.iocl_v1.c.a aVar2 = e.this.f14350b;
                    aVar2.f14430b.set(Boolean.FALSE);
                    aVar2.f14429a.set(Boolean.TRUE);
                    aVar2.f14431c.set(Boolean.FALSE);
                    aVar2.f14432d.setValue(aVar2.getApplication().getString(R.string.iocl_male));
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14137b, 0);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14139d, 1);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14140e, 0);
                } else if (i2 == R.id.rd_other) {
                    net.one97.paytm.transport.iocl_v1.c.a aVar3 = e.this.f14350b;
                    aVar3.f14430b.set(Boolean.FALSE);
                    aVar3.f14429a.set(Boolean.FALSE);
                    aVar3.f14431c.set(Boolean.TRUE);
                    aVar3.f14432d.setValue(aVar3.getApplication().getString(R.string.label_other));
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14137b, 0);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14139d, 0);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14140e, 1);
                } else {
                    net.one97.paytm.transport.iocl_v1.c.a aVar4 = e.this.f14350b;
                    aVar4.f14430b.set(Boolean.FALSE);
                    aVar4.f14429a.set(Boolean.FALSE);
                    aVar4.f14431c.set(Boolean.FALSE);
                    aVar4.f14432d.setValue("");
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14137b, 0);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14139d, 0);
                    net.one97.paytm.transport.iocl_v1.c.a.a(mVar.f14140e, 0);
                }
            }
        });
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
            }
        });
        from.setState(3);
        aVar.show();
        mVar.getRoot().findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aVar.dismiss();
            }
        });
        if (TextUtils.isEmpty(eVar.f14349a.f14160c.getText().toString())) {
            return;
        }
        if (eVar.getString(R.string.iocl_male).equalsIgnoreCase(eVar.f14349a.f14160c.getText().toString())) {
            mVar.f14139d.setChecked(true);
        } else if (eVar.getString(R.string.female).equalsIgnoreCase(eVar.f14349a.f14160c.getText().toString())) {
            mVar.f14137b.setChecked(true);
        } else if (eVar.getString(R.string.label_other).equalsIgnoreCase(eVar.f14349a.f14160c.getText().toString())) {
            mVar.f14140e.setChecked(true);
        }
    }
}
