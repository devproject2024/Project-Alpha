package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.g.a;
import net.one97.paytm.recharge.presentation.c.a;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class e implements net.one97.paytm.recharge.automatic.g.c {

    /* renamed from: a  reason: collision with root package name */
    public Activity f61616a;

    /* renamed from: b  reason: collision with root package name */
    public j f61617b;

    /* renamed from: c  reason: collision with root package name */
    public a f61618c;

    /* renamed from: d  reason: collision with root package name */
    public String f61619d;

    /* renamed from: e  reason: collision with root package name */
    public Long f61620e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f61621f;

    /* renamed from: g  reason: collision with root package name */
    public int f61622g = -1;

    /* renamed from: h  reason: collision with root package name */
    public BottomSheetBehavior.a f61623h;

    public interface a {
        void an_();

        void ap_();

        void aq_();

        void ar_();
    }

    public e(Activity activity, String str, j jVar, Long l, a aVar) {
        k.c(activity, "context");
        k.c(str, "rechargeNumber");
        k.c(jVar, "childManager");
        k.c(aVar, "listener");
        this.f61616a = activity;
        this.f61617b = jVar;
        this.f61618c = aVar;
        this.f61619d = str;
        this.f61620e = l;
        a.C1163a aVar2 = net.one97.paytm.recharge.automatic.g.a.f60288a;
        net.one97.paytm.recharge.automatic.g.a a2 = a.C1163a.a(activity, this);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        a2.a("check_subscription", str, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
        this.f61623h = new b();
    }

    public final void a(boolean z, Integer num) {
        Activity activity = this.f61616a;
        if (activity != null) {
            if (activity == null) {
                k.a();
            }
            if (!activity.isFinishing()) {
                Activity activity2 = this.f61616a;
                if (activity2 == null) {
                    k.a();
                }
                if (!activity2.isDestroyed()) {
                    if (!z) {
                        a aVar = this.f61618c;
                        if (aVar != null) {
                            aVar.aq_();
                        }
                    } else if (this.f61617b != null) {
                        a aVar2 = this.f61618c;
                        if (aVar2 != null) {
                            aVar2.ar_();
                        }
                        a.C1163a aVar3 = net.one97.paytm.recharge.automatic.g.a.f60288a;
                        int a2 = net.one97.paytm.recharge.automatic.g.a.f60289g;
                        if (num != null && num.intValue() == a2) {
                            a.C1278a aVar4 = net.one97.paytm.recharge.presentation.c.a.f64795a;
                            Activity activity3 = this.f61616a;
                            if (activity3 == null) {
                                k.a();
                            }
                            Context context = activity3;
                            Activity activity4 = this.f61616a;
                            if (activity4 == null) {
                                k.a();
                            }
                            String string = activity4.getString(R.string.automatic_already_set);
                            k.a((Object) string, "mContext!!.getString(R.s…ng.automatic_already_set)");
                            Activity activity5 = this.f61616a;
                            if (activity5 == null) {
                                k.a();
                            }
                            String string2 = activity5.getString(R.string.available_subscribed_by_someone_else);
                            k.a((Object) string2, "mContext!!.getString(R.s…bscribed_by_someone_else)");
                            CharSequence charSequence = string2;
                            Activity activity6 = this.f61616a;
                            if (activity6 == null) {
                                k.a();
                            }
                            String string3 = activity6.getString(R.string.ok_re);
                            k.a((Object) string3, "mContext!!.getString(R.string.ok_re)");
                            com.google.android.material.bottomsheet.b a3 = a.C1278a.a(context, string, charSequence, string3, new c(this), this.f61623h);
                            j jVar = this.f61617b;
                            if (jVar == null) {
                                k.a();
                            }
                            a3.show(jVar, net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
                            return;
                        }
                        a.C1278a aVar5 = net.one97.paytm.recharge.presentation.c.a.f64795a;
                        Activity activity7 = this.f61616a;
                        if (activity7 == null) {
                            k.a();
                        }
                        Context context2 = activity7;
                        Activity activity8 = this.f61616a;
                        if (activity8 == null) {
                            k.a();
                        }
                        String string4 = activity8.getString(R.string.automatic_already_set);
                        k.a((Object) string4, "mContext!!.getString(R.s…ng.automatic_already_set)");
                        Activity activity9 = this.f61616a;
                        if (activity9 == null) {
                            k.a();
                        }
                        String string5 = activity9.getString(R.string.available_subscribed_by_user);
                        k.a((Object) string5, "mContext!!.getString(R.s…lable_subscribed_by_user)");
                        CharSequence charSequence2 = string5;
                        Activity activity10 = this.f61616a;
                        if (activity10 == null) {
                            k.a();
                        }
                        String string6 = activity10.getString(R.string.manage_settings);
                        k.a((Object) string6, "mContext!!.getString(R.string.manage_settings)");
                        com.google.android.material.bottomsheet.b a4 = a.C1278a.a(context2, string4, charSequence2, string6, new d(this), this.f61623h);
                        j jVar2 = this.f61617b;
                        if (jVar2 == null) {
                            k.a();
                        }
                        a4.show(jVar2, net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
                    }
                }
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f61624a;

        c(e eVar) {
            this.f61624a = eVar;
        }

        public final void onClick(View view) {
            a aVar = this.f61624a.f61618c;
            if (aVar != null) {
                aVar.ap_();
            }
            View.OnClickListener onClickListener = this.f61624a.f61621f;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f61625a;

        d(e eVar) {
            this.f61625a = eVar;
        }

        public final void onClick(View view) {
            View.OnClickListener onClickListener;
            k.a((Object) view, "it");
            int id = view.getId();
            if (id == R.id.action_button) {
                View.OnClickListener onClickListener2 = this.f61625a.f61621f;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                a aVar = this.f61625a.f61618c;
                if (aVar != null) {
                    aVar.an_();
                }
            } else if (id == R.id.close && (onClickListener = this.f61625a.f61621f) != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public final void a() {
        a aVar = this.f61618c;
        if (aVar != null) {
            aVar.aq_();
        }
    }

    public static final class b extends BottomSheetBehavior.a {
        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
        }

        b() {
        }
    }
}
