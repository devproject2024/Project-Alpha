package net.one97.paytm.hotel4.view.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.FragmentActivity;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.i.g;

public final class p extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final a f28930b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    boolean f28931a;

    /* renamed from: c  reason: collision with root package name */
    private String f28932c;

    /* renamed from: d  reason: collision with root package name */
    private String f28933d;

    /* renamed from: e  reason: collision with root package name */
    private String f28934e;

    /* renamed from: f  reason: collision with root package name */
    private int f28935f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f28936g;

    public interface b {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.f28932c = arguments.getString("dialog_text");
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            this.f28933d = arguments2.getString("primary_text");
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                k.a();
            }
            this.f28934e = arguments3.getString("secondary_text");
            Bundle arguments4 = getArguments();
            if (arguments4 == null) {
                k.a();
            }
            this.f28935f = arguments4.getInt("drawable_resource", 0);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        c.a aVar = new c.a(activity);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            k.a();
        }
        LayoutInflater layoutInflater = activity2.getLayoutInflater();
        k.a((Object) layoutInflater, "activity!!.getLayoutInflater()");
        View inflate = layoutInflater.inflate(R.layout.h4_fragment_hotel_yes_no_dialog_box, (ViewGroup) null);
        k.a((Object) inflate, "inflater.inflate(R.layou…_yes_no_dialog_box, null)");
        androidx.appcompat.app.c a2 = aVar.a(inflate).a();
        k.a((Object) a2, "builder.setView(view).create()");
        View findViewById = inflate.findViewById(R.id.dialog_image);
        if (findViewById != null) {
            ImageView imageView = (ImageView) findViewById;
            if (this.f28935f == 0) {
                imageView.setVisibility(8);
            } else {
                FragmentActivity activity3 = getActivity();
                if (activity3 == null) {
                    k.a();
                }
                imageView.setImageDrawable(androidx.core.content.b.a((Context) activity3, this.f28935f));
            }
            View findViewById2 = inflate.findViewById(R.id.yes_button_dialog_box);
            if (findViewById2 != null) {
                TextView textView = (TextView) findViewById2;
                textView.setText(this.f28933d);
                textView.setOnClickListener(new c(this));
                View findViewById3 = inflate.findViewById(R.id.no_button_dialog_box);
                if (findViewById3 != null) {
                    TextView textView2 = (TextView) findViewById3;
                    textView2.setText(this.f28934e);
                    textView2.setOnClickListener(new d(this));
                    View findViewById4 = inflate.findViewById(R.id.dialog_text);
                    if (findViewById4 != null) {
                        ((TextView) findViewById4).setText(this.f28932c);
                        return a2;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.ImageView");
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f28937a;

        c(p pVar) {
            this.f28937a = pVar;
        }

        public final void onClick(View view) {
            k.c(view, "view");
            if (this.f28937a.f28936g == null) {
                k.a();
            }
            if (this.f28937a.f28931a) {
                p.b(this.f28937a);
            }
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f28938a;

        d(p pVar) {
            this.f28938a = pVar;
        }

        public final void onClick(View view) {
            k.c(view, "view");
            if (this.f28938a.f28936g == null) {
                k.a();
            }
            if (this.f28938a.f28931a) {
                p.b(this.f28938a);
            }
        }
    }

    public final void onDetach() {
        super.onDetach();
        this.f28936g = null;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void b(p pVar) {
        Dialog dialog = pVar.getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }
}
