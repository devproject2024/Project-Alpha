package net.one97.paytm.paymentsBank.form15g.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import net.one97.paytm.common.widgets.CJRFlowLayout;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<TextView> f18401a;

    /* renamed from: b  reason: collision with root package name */
    int f18402b = -1;

    /* renamed from: c  reason: collision with root package name */
    SharedPreferences f18403c;

    /* renamed from: d  reason: collision with root package name */
    public a f18404d;

    /* renamed from: e  reason: collision with root package name */
    private String f18405e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18401a = new ArrayList<>();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_fg_select_financial_year, viewGroup, false);
        CJRFlowLayout cJRFlowLayout = (CJRFlowLayout) inflate.findViewById(R.id.fl_financial_year_cont);
        this.f18403c = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f18405e = getArguments().getString("FINANCIAL_YEAR");
        ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.a(view);
            }
        });
        String[] strArr = new String[10];
        Integer valueOf = Integer.valueOf(Integer.parseInt(((FGHStatusModel) getArguments().getSerializable("FORM15GH_STATUS")).getResponse().getFinancialYr().split("-")[0]) - 1);
        for (int i2 = 0; i2 < 10; i2++) {
            strArr[i2] = valueOf + "-" + (valueOf.intValue() + 1);
            if (!TextUtils.isEmpty(this.f18405e) && this.f18405e.equalsIgnoreCase(strArr[i2])) {
                this.f18402b = i2;
            }
            valueOf = Integer.valueOf(valueOf.intValue() - 1);
        }
        for (int i3 = 0; i3 < 10; i3++) {
            View inflate2 = getLayoutInflater().inflate(R.layout.pb_fg_item_financial_year, (ViewGroup) null);
            TextView textView = (TextView) inflate2.findViewById(R.id.tv_financial_year);
            this.f18401a.add(textView);
            if (this.f18402b == i3) {
                textView.setBackgroundResource(R.drawable.pb_fg_blue_back_radious);
                textView.setTextColor(getResources().getColor(R.color.white));
            }
            textView.setText(strArr[i3]);
            textView.setOnClickListener(new View.OnClickListener(textView) {
                private final /* synthetic */ TextView f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    c.this.a(this.f$1, view);
                }
            });
            cJRFlowLayout.addView(inflate2);
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (getDialog() != null) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(TextView textView, View view) {
        int i2 = this.f18402b;
        if (i2 != -1) {
            TextView textView2 = (TextView) this.f18401a.get(i2).findViewById(R.id.tv_financial_year);
            textView2.setBackgroundResource(R.drawable.pb_fg_white_back_radious);
            textView2.setTextColor(getResources().getColor(R.color.blue_dot));
        }
        textView.setBackgroundResource(R.drawable.pb_fg_blue_back_radious);
        textView.setTextColor(getResources().getColor(R.color.white));
        if (view instanceof TextView) {
            this.f18402b = this.f18401a.indexOf(view);
            TextView textView3 = (TextView) view;
            this.f18404d.dateCallback(textView3.getText().toString());
            this.f18405e = textView3.getText().toString();
            SharedPreferences.Editor edit = this.f18403c.edit();
            edit.putString("FINANCIAL_YEAR", this.f18405e);
            edit.apply();
            dismiss();
        }
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}
