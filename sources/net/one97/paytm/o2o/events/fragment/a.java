package net.one97.paytm.o2o.events.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import net.one97.paytm.i.f;
import net.one97.paytm.o2o.events.R;

public final class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f73769a;

    /* renamed from: b  reason: collision with root package name */
    private String f73770b;

    private a() {
    }

    public static a a(String str, String str2) {
        a aVar = new a();
        aVar.f73769a = str;
        aVar.f73770b = str2;
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = 0;
        View inflate = layoutInflater.inflate(R.layout.event_summary_tracking_bottom_sheet, viewGroup, false);
        ((AppCompatImageView) inflate.findViewById(R.id.crossButton)).setOnClickListener(this);
        ((TextView) inflate.findViewById(R.id.id_text)).setText(this.f73769a);
        TextView textView = (TextView) inflate.findViewById(R.id.id_awb_button);
        if (TextUtils.isEmpty(this.f73770b)) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        textView.setOnClickListener(this);
        return inflate;
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.crossButton) {
            dismiss();
        } else if (view.getId() == R.id.id_awb_button) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label", this.f73770b));
            Toast.makeText(getContext(), "Copied", 0).show();
        }
    }
}
