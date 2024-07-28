package net.one97.paytm.recharge.common.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import java.text.DecimalFormat;
import net.one97.paytm.i.g;
import net.one97.paytm.recharge.R;

public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public static String f61127a = "total_amount";

    /* renamed from: b  reason: collision with root package name */
    public static String f61128b = "plan_amount";

    /* renamed from: c  reason: collision with root package name */
    double f61129c;

    /* renamed from: d  reason: collision with root package name */
    double f61130d;

    /* renamed from: e  reason: collision with root package name */
    C1182a f61131e;

    /* renamed from: net.one97.paytm.recharge.common.fragment.a$a  reason: collision with other inner class name */
    public interface C1182a {
        void ao_();

        void c();
    }

    public static a a(double d2, double d3) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putDouble(f61127a, d2);
        bundle.putDouble(f61128b, d3);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments().containsKey(f61127a)) {
            this.f61129c = getArguments().getDouble(f61127a);
        }
        if (getArguments().containsKey(f61128b)) {
            this.f61130d = getArguments().getDouble(f61128b);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.den_otc_dialoge, (ViewGroup) null);
        C1182a aVar = this.f61131e;
        if (aVar != null) {
            aVar.c();
        }
        TextView textView = (TextView) inflate.findViewById(R.id.tv_plan_amount);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_otc_amount);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_net_amount);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_otc_message);
        double d2 = this.f61129c - this.f61130d;
        DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
        try {
            textView.setText(decimalFormat.format(this.f61130d));
        } catch (ArithmeticException e2) {
            q.d(e2.getMessage());
        }
        try {
            textView2.setText(" " + decimalFormat.format(d2));
        } catch (ArithmeticException e3) {
            q.d(e3.getMessage());
        }
        try {
            textView3.setText(decimalFormat.format(this.f61129c));
        } catch (ArithmeticException e4) {
            q.d(e4.getMessage());
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_cancel);
        Button button = (Button) inflate.findViewById(R.id.otc_btn_proceed);
        String string = getContext().getString(R.string.proceed_to_pay_otc, new Object[]{new DecimalFormat("#,###,###.00").format(this.f61129c)});
        String string2 = getContext().getString(R.string.otc_dialog_txt, new Object[]{decimalFormat.format(d2)});
        if (!TextUtils.isEmpty(string2)) {
            textView4.setText(string2);
        }
        button.setText(string);
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a aVar = a.this;
                aVar.dismiss();
                if (aVar.f61131e != null) {
                    aVar.f61131e.ao_();
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.dismiss();
            }
        });
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof C1182a) {
            this.f61131e = (C1182a) parentFragment;
        } else if (context instanceof C1182a) {
            this.f61131e = (C1182a) context;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f61131e = null;
    }
}
