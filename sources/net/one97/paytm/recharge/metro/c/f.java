package net.one97.paytm.recharge.metro.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class f extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f63325a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f63326b;

    /* renamed from: c  reason: collision with root package name */
    public a f63327c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f63328d;

    /* renamed from: e  reason: collision with root package name */
    private String f63329e;

    /* renamed from: f  reason: collision with root package name */
    private String f63330f;

    /* renamed from: g  reason: collision with root package name */
    private int f63331g = -1;

    /* renamed from: h  reason: collision with root package name */
    private CJRActiveMetroTicketModel f63332h;

    /* renamed from: i  reason: collision with root package name */
    private CJRActiveMetroTicketQRItemModel f63333i;
    private int j;
    private d k;
    private boolean l;
    private HashMap m;

    public interface a {
        void a();

        void a(View view, CJRActiveMetroTicketModel cJRActiveMetroTicketModel);

        void b(int i2);
    }

    public f() {
        c.a aVar = c.f63576a;
        this.j = c.f63581f;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            boolean z = false;
            if (arguments != null && arguments.containsKey("show_Cancel_option_Metro")) {
                Bundle arguments2 = getArguments();
                Boolean valueOf = arguments2 != null ? Boolean.valueOf(arguments2.getBoolean("show_Cancel_option_Metro", false)) : null;
                if (valueOf == null) {
                    k.a();
                }
                this.f63328d = valueOf.booleanValue();
            }
            Bundle arguments3 = getArguments();
            this.f63329e = arguments3 != null ? arguments3.getString(StringSet.operator) : null;
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                z = arguments4.getBoolean("is_cancellable");
            }
            this.l = z;
            Bundle arguments5 = getArguments();
            this.f63330f = arguments5 != null ? arguments5.getString("metroTicketVariant", (String) null) : null;
            Bundle arguments6 = getArguments();
            int i2 = -1;
            if (arguments6 != null) {
                i2 = arguments6.getInt("extra_intent_item_position", -1);
            }
            this.f63331g = i2;
            Bundle arguments7 = getArguments();
            Serializable serializable = arguments7 != null ? arguments7.getSerializable("extra.ticket") : null;
            if (!(serializable instanceof CJRActiveMetroTicketModel)) {
                serializable = null;
            }
            this.f63332h = (CJRActiveMetroTicketModel) serializable;
            Bundle arguments8 = getArguments();
            Serializable serializable2 = arguments8 != null ? arguments8.getSerializable("extra.qr.code") : null;
            if (!(serializable2 instanceof CJRActiveMetroTicketQRItemModel)) {
                serializable2 = null;
            }
            this.f63333i = (CJRActiveMetroTicketQRItemModel) serializable2;
            c.a aVar = c.f63576a;
            this.j = c.a.a(this.f63332h);
            if (getContext() != null) {
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                this.k = new d(context);
                return;
            }
            return;
        }
        throw new RuntimeException("Argument expected");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f63334a;

        b(f fVar) {
            this.f63334a = fVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f63334a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.clearFlags(2);
        }
        new Handler().postDelayed(new b(this), 300);
        return layoutInflater.inflate(R.layout.layout_metro_need_help_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.cancel_my_ticket);
        k.a((Object) findViewById, "view.findViewById<Relati…t>(R.id.cancel_my_ticket)");
        this.f63325a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.layout_unable_to_exit);
        k.a((Object) findViewById2, "view.findViewById<Relati…id.layout_unable_to_exit)");
        this.f63326b = (RelativeLayout) findViewById2;
        if (!this.f63328d) {
            RelativeLayout relativeLayout = this.f63325a;
            if (relativeLayout == null) {
                k.a("cancelMyTicketLayout");
            }
            relativeLayout.setVisibility(8);
            View findViewById3 = view.findViewById(R.id.view_divider);
            k.a((Object) findViewById3, "view.findViewById<View>(R.id.view_divider)");
            findViewById3.setVisibility(8);
        } else {
            View findViewById4 = view.findViewById(R.id.txtCancel);
            k.a((Object) findViewById4, "view.findViewById<TextView>(R.id.txtCancel)");
            TextView textView = (TextView) findViewById4;
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.metro_mumbai_cancel, new Object[]{this.f63329e});
            } else {
                str = null;
            }
            textView.setText(str);
        }
        View.OnClickListener onClickListener = this;
        ((ImageView) view.findViewById(R.id.img_dialog_close)).setOnClickListener(onClickListener);
        RelativeLayout relativeLayout2 = this.f63326b;
        if (relativeLayout2 == null) {
            k.a("unableToExitLayout");
        }
        relativeLayout2.setOnClickListener(onClickListener);
        RelativeLayout relativeLayout3 = this.f63325a;
        if (relativeLayout3 == null) {
            k.a("cancelMyTicketLayout");
        }
        relativeLayout3.setOnClickListener(onClickListener);
        if (!this.l) {
            View findViewById5 = view.findViewById(R.id.view_divider);
            k.a((Object) findViewById5, "view.findViewById<View>(R.id.view_divider)");
            findViewById5.setVisibility(8);
            View findViewById6 = view.findViewById(R.id.cancel_my_ticket);
            k.a((Object) findViewById6, "view.findViewById<View>(R.id.cancel_my_ticket)");
            findViewById6.setVisibility(8);
        }
    }

    public final void onClick(View view) {
        a aVar;
        a aVar2;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.img_dialog_close;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            a aVar3 = this.f63327c;
            if (aVar3 != null) {
                aVar3.a();
                return;
            }
            return;
        }
        int i3 = R.id.layout_unable_to_exit;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.cancel_my_ticket;
            if (valueOf != null && valueOf.intValue() == i4 && !net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this)) {
                dismiss();
                d dVar = this.k;
                if (dVar != null) {
                    c.a aVar4 = c.f63576a;
                    String a2 = c.a.a(this.f63330f);
                    c.a aVar5 = c.f63576a;
                    String a3 = c.a.a(this.j);
                    String str = ab.f61496a;
                    k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
                    d.a(dVar, a2, "cancel_metro_qr_ticket_clicked", (Object) null, a3, str, (Object) null, (Object) null, 100);
                }
                if (this.f63331g != -1 && this.f63332h != null && this.f63333i != null && (aVar = this.f63327c) != null) {
                    if (this.f63325a == null) {
                        k.a("cancelMyTicketLayout");
                    }
                    int i5 = this.f63331g;
                    if (this.f63332h == null) {
                        k.a();
                    }
                    if (this.f63333i == null) {
                        k.a();
                    }
                    aVar.b(i5);
                }
            }
        } else if (!com.paytm.utility.b.c(getContext())) {
            Context context = getContext();
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            String string = context2.getString(R.string.title_connection_problem);
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            com.paytm.utility.b.a(context, string, context3.getString(R.string.msg_connection_problem));
        } else if (!net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this)) {
            dismiss();
            d dVar2 = this.k;
            if (dVar2 != null) {
                c.a aVar6 = c.f63576a;
                String a4 = c.a.a(this.f63330f);
                c.a aVar7 = c.f63576a;
                String a5 = c.a.a(this.j);
                String str2 = ab.f61496a;
                k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
                d.a(dVar2, a4, "unable_to_exit_station_clicked", (Object) null, a5, str2, (Object) null, (Object) null, 100);
            }
            if (this.f63331g != -1 && this.f63332h != null && this.f63333i != null && (aVar2 = this.f63327c) != null) {
                RelativeLayout relativeLayout = this.f63326b;
                if (relativeLayout == null) {
                    k.a("unableToExitLayout");
                }
                View view2 = relativeLayout;
                CJRActiveMetroTicketModel cJRActiveMetroTicketModel = this.f63332h;
                if (cJRActiveMetroTicketModel == null) {
                    k.a();
                }
                if (this.f63333i == null) {
                    k.a();
                }
                aVar2.a(view2, cJRActiveMetroTicketModel);
            }
        }
    }

    public final void a(boolean z) {
        this.f63328d = z;
        RelativeLayout relativeLayout = this.f63325a;
        if (relativeLayout == null) {
            k.a("cancelMyTicketLayout");
        }
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
