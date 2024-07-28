package net.one97.paytm.wallet.splitbill.c;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import net.one97.paytm.i.h;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBSearchContactListActivity;

public class k extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f72215a;

    /* renamed from: b  reason: collision with root package name */
    private Button f72216b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f72217c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f72217c = activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_start_splitbill_fragment, (ViewGroup) null);
        this.f72215a = (ImageView) inflate.findViewById(R.id.split_back_button);
        this.f72215a.setOnClickListener(this);
        this.f72216b = (Button) inflate.findViewById(R.id.split_new_bill);
        this.f72216b.setOnClickListener(this);
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.split_back_button) {
            getActivity().finish();
        } else if (id == R.id.split_new_bill) {
            Intent intent = new Intent(this.f72217c, SBSearchContactListActivity.class);
            intent.putExtra("show_group_widget", false);
            intent.putExtra("non_group_bill", true);
            this.f72217c.startActivity(intent);
        }
    }
}
