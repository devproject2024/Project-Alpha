package net.one97.paytm.recharge.metro.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;

public class l extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f63401a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    String f63402b;

    /* renamed from: c  reason: collision with root package name */
    TextView f63403c;

    /* renamed from: d  reason: collision with root package name */
    TextView f63404d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
        if (getArguments() != null) {
            this.f63401a = getArguments().getStringArrayList("messageList");
            this.f63402b = getArguments().getString("title");
            return;
        }
        throw new RuntimeException("Arguments required");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_metro_show_penalty_dialog, (ViewGroup) null, false);
        this.f63403c = (TextView) inflate.findViewById(R.id.txt_title_penalty);
        this.f63404d = (TextView) inflate.findViewById(R.id.penalty_detail);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_btn_ok);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.close_button);
        this.f63403c.setText(this.f63402b);
        ArrayList<String> arrayList = this.f63401a;
        if (arrayList != null && arrayList.size() > 0) {
            this.f63404d.setText(this.f63401a.get(0));
        }
        textView.setOnClickListener(this);
        imageView.setOnClickListener(this);
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.txt_btn_ok) {
            dismiss();
        } else if (id == R.id.close_button) {
            dismiss();
        }
    }
}
