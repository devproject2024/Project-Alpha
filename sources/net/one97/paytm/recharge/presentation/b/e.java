package net.one97.paytm.recharge.presentation.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.presentation.b.g;

public final class e extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64758a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static c f64759e;

    /* renamed from: b  reason: collision with root package name */
    private CJRAutomaticSubscriptionItemModel f64760b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f64761c;

    /* renamed from: d  reason: collision with root package name */
    private String f64762d;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f64763f;

    public enum b {
        PAUSE,
        RESUME,
        DELETE
    }

    public interface c {
        void a(int i2, b bVar);
    }

    private View a(int i2) {
        if (this.f64763f == null) {
            this.f64763f = new HashMap();
        }
        View view = (View) this.f64763f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64763f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomImpsBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        Integer num = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("selected_automatic_subscribed_item") : null;
        if (serializable != null) {
            this.f64760b = (CJRAutomaticSubscriptionItemModel) serializable;
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                num = Integer.valueOf(arguments2.getInt("key_current_status"));
            }
            this.f64761c = num;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_more_options, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r2, android.os.Bundle r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r2, r0)
            super.onViewCreated(r2, r3)
            int r2 = net.one97.paytm.recharge.automatic.R.id.ic_close
            android.view.View r2 = r1.a((int) r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r3 = r1
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
            int r2 = net.one97.paytm.recharge.automatic.R.id.txt_pause_resume
            android.view.View r2 = r1.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r0 = "txt_pause_resume"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            java.lang.Integer r0 = r1.f64761c
            if (r0 != 0) goto L_0x0028
            goto L_0x0031
        L_0x0028:
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x0031
            int r0 = net.one97.paytm.recharge.automatic.R.string.label_resume_automatic
            goto L_0x0033
        L_0x0031:
            int r0 = net.one97.paytm.recharge.automatic.R.string.label_pause_automatic
        L_0x0033:
            java.lang.String r0 = r1.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel r2 = r1.f64760b
            if (r2 == 0) goto L_0x006a
            java.util.List r2 = r2.getHistory()
            if (r2 == 0) goto L_0x006a
            java.util.Collection r2 = (java.util.Collection) r2
            r0 = 1
            if (r2 == 0) goto L_0x0054
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r2 = 0
            goto L_0x0055
        L_0x0054:
            r2 = 1
        L_0x0055:
            if (r2 != r0) goto L_0x006a
            int r2 = net.one97.paytm.recharge.automatic.R.id.payment_history_section
            android.view.View r2 = r1.a((int) r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            java.lang.String r0 = "payment_history_section"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            r0 = 8
            r2.setVisibility(r0)
            goto L_0x0075
        L_0x006a:
            int r2 = net.one97.paytm.recharge.automatic.R.id.payment_history_section
            android.view.View r2 = r1.a((int) r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r2.setOnClickListener(r3)
        L_0x0075:
            int r2 = net.one97.paytm.recharge.automatic.R.id.pause_resume_section
            android.view.View r2 = r1.a((int) r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r2.setOnClickListener(r3)
            int r2 = net.one97.paytm.recharge.automatic.R.id.delete_automatic_section
            android.view.View r2 = r1.a((int) r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r2.setOnClickListener(r3)
            android.os.Bundle r2 = r1.getArguments()
            r3 = 0
            if (r2 == 0) goto L_0x0098
            java.lang.String r0 = "service_paytype"
            java.lang.String r3 = r2.getString(r0, r3)
        L_0x0098:
            r1.f64762d = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.b.e.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        j jVar = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        ImageView imageView = (ImageView) a(R.id.ic_close);
        k.a((Object) imageView, "ic_close");
        int id = imageView.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            dismissAllowingStateLoss();
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.payment_history_section);
        k.a((Object) constraintLayout, "payment_history_section");
        int id2 = constraintLayout.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            Context context = getContext();
            if (!(context instanceof FragmentActivity)) {
                context = null;
            }
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            if ((fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null) != null) {
                g.a aVar = g.f64772a;
                CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = this.f64760b;
                g gVar = new g();
                Bundle bundle = new Bundle();
                bundle.putSerializable("selected_automatic_subscribed_item", cJRAutomaticSubscriptionItemModel);
                gVar.setArguments(bundle);
                Context context2 = getContext();
                if (!(context2 instanceof FragmentActivity)) {
                    context2 = null;
                }
                FragmentActivity fragmentActivity2 = (FragmentActivity) context2;
                if (fragmentActivity2 != null) {
                    jVar = fragmentActivity2.getSupportFragmentManager();
                }
                if (jVar == null) {
                    k.a();
                }
                gVar.show(jVar, g.class.getSimpleName());
                dismissAllowingStateLoss();
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.pause_resume_section);
        k.a((Object) constraintLayout2, "pause_resume_section");
        int id3 = constraintLayout2.getId();
        if (valueOf != null && valueOf.intValue() == id3) {
            Integer num = this.f64761c;
            int i2 = (num != null && num.intValue() == 0) ? 1 : 0;
            c cVar = f64759e;
            if (cVar != null) {
                Integer num2 = this.f64761c;
                cVar.a(i2, (num2 != null && num2.intValue() == 0) ? b.RESUME : b.PAUSE);
            }
            dismissAllowingStateLoss();
            Integer num3 = this.f64761c;
            if (num3 != null && num3.intValue() == 1) {
                try {
                    if (getContext() != null) {
                        net.one97.paytm.recharge.automatic.c.a.a aVar2 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                        Context context3 = getContext();
                        if (context3 == null) {
                            k.a();
                        }
                        k.a((Object) context3, "context!!");
                        a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                        String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                        a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                        String t = net.one97.paytm.recharge.automatic.b.a.a.w;
                        String str4 = this.f64762d;
                        if (str4 == null) {
                            str3 = "";
                        } else {
                            str3 = str4;
                        }
                        net.one97.paytm.recharge.automatic.c.a.a.a(context3, a2, t, "", str3, (Object) null, (Object) null, 96);
                    }
                } catch (Throwable unused) {
                }
            } else {
                Integer num4 = this.f64761c;
                if (num4 != null && num4.intValue() == 0) {
                    try {
                        if (getContext() != null) {
                            net.one97.paytm.recharge.automatic.c.a.a aVar5 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                            Context context4 = getContext();
                            if (context4 == null) {
                                k.a();
                            }
                            k.a((Object) context4, "context!!");
                            a.C1160a aVar6 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                            String a3 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                            a.C1160a aVar7 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                            String u = net.one97.paytm.recharge.automatic.b.a.a.x;
                            String str5 = this.f64762d;
                            if (str5 == null) {
                                str2 = "";
                            } else {
                                str2 = str5;
                            }
                            net.one97.paytm.recharge.automatic.c.a.a.a(context4, a3, u, "", str2, (Object) null, (Object) null, 96);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
        } else {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.delete_automatic_section);
            k.a((Object) constraintLayout3, "delete_automatic_section");
            int id4 = constraintLayout3.getId();
            if (valueOf != null && valueOf.intValue() == id4) {
                c cVar2 = f64759e;
                if (cVar2 != null) {
                    cVar2.a(-1, b.DELETE);
                }
                dismissAllowingStateLoss();
                try {
                    if (getContext() != null) {
                        net.one97.paytm.recharge.automatic.c.a.a aVar8 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                        Context context5 = getContext();
                        if (context5 == null) {
                            k.a();
                        }
                        k.a((Object) context5, "context!!");
                        a.C1160a aVar9 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                        String a4 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                        a.C1160a aVar10 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                        String v = net.one97.paytm.recharge.automatic.b.a.a.y;
                        String str6 = this.f64762d;
                        if (str6 == null) {
                            str = "";
                        } else {
                            str = str6;
                        }
                        net.one97.paytm.recharge.automatic.c.a.a.a(context5, a4, v, "", str, (Object) null, (Object) null, 96);
                    }
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64763f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
