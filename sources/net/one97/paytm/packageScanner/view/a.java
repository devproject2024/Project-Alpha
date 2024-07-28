package net.one97.paytm.packageScanner.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.b.d;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f57044a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f57045b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f57046c;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.uninstall_remote_app_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.proceed_layout);
        k.a((Object) findViewById, "view.findViewById(R.id.proceed_layout)");
        this.f57044a = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.instruction_unistall_view);
        k.a((Object) findViewById2, "view.findViewById(R.id.instruction_unistall_view)");
        this.f57045b = (LinearLayout) findViewById2;
        LinearLayout linearLayout = this.f57044a;
        if (linearLayout == null) {
            k.a("proceedUnistallView");
        }
        linearLayout.setOnClickListener(new C1064a(this));
        Context context = getContext();
        if (context != null) {
            for (int i2 = 0; i2 < 4; i2++) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.unistall_instruction_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.title1);
                TextView textView2 = (TextView) inflate.findViewById(R.id.title2);
                View findViewById3 = inflate.findViewById(R.id.line1);
                View findViewById4 = inflate.findViewById(R.id.line2);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.circleImv);
                if (i2 == 0) {
                    k.a((Object) imageView, "imgCircle");
                    imageView.setBackground(b.a(context, (int) R.drawable.uninstall_circle_green));
                    k.a((Object) findViewById3, AddEditGstinViewModelKt.BODY_PARAM_LINE1);
                    findViewById3.setVisibility(8);
                    k.a((Object) textView, "title1");
                    textView.setText(getString(R.string.instruction_text1));
                    k.a((Object) textView2, "title2");
                    textView2.setText(getString(R.string.instruction_text1_hindi));
                } else if (i2 == 1) {
                    k.a((Object) textView, "title1");
                    textView.setText(getString(R.string.instruction_text2));
                    k.a((Object) textView2, "title2");
                    textView2.setText(getString(R.string.instruction_text2_hindi));
                } else if (i2 == 2) {
                    k.a((Object) textView, "title1");
                    textView.setText(getString(R.string.instruction_text3));
                    k.a((Object) textView2, "title2");
                    textView2.setText(getString(R.string.instruction_text3_hindi));
                } else if (i2 == 3) {
                    k.a((Object) textView, "title1");
                    textView.setText(getString(R.string.instruction_text4));
                    k.a((Object) textView2, "title2");
                    textView2.setText(getString(R.string.instruction_text4_hindi));
                    k.a((Object) findViewById4, AddEditGstinViewModelKt.BODY_PARAM_LINE2);
                    findViewById4.setVisibility(8);
                }
                LinearLayout linearLayout2 = this.f57045b;
                if (linearLayout2 == null) {
                    k.a("instructionLayoutView");
                }
                linearLayout2.addView(inflate);
            }
        }
    }

    /* renamed from: net.one97.paytm.packageScanner.view.a$a  reason: collision with other inner class name */
    static final class C1064a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57047a;

        C1064a(a aVar) {
            this.f57047a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f57047a);
            this.f57047a.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        try {
            if (aVar.getContext() != null) {
                d.a().a(aVar.getContext(), "Uninstall_clicked", (ArrayList<String>) null);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57046c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
