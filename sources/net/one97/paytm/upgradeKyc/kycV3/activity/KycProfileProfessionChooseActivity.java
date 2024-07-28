package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upgradeKyc.R;

public final class KycProfileProfessionChooseActivity extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f66130a = -1;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f66131b;

    private View a(int i2) {
        if (this.f66131b == null) {
            this.f66131b = new HashMap();
        }
        View view = (View) this.f66131b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66131b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onClick(View view) {
        if (k.a((Object) view, (Object) (Button) a(R.id.fragment_edit_profession_save_btn))) {
            RadioGroup radioGroup = (RadioGroup) a(R.id.profession_rg);
            k.a((Object) radioGroup, "profession_rg");
            this.f66130a = ((RadioGroup) a(R.id.profession_rg)).indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
            if (this.f66130a != -1) {
                Intent intent = new Intent();
                intent.putExtra("profession", this.f66130a);
                setResult(-1, intent);
                finish();
                return;
            }
            Toast.makeText(this, "Please Select A Profession", 0).show();
        } else if (k.a((Object) view, (Object) (ImageView) a(R.id.profession_iv_back_button))) {
            onBackPressed();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_profession_pb);
        if (getIntent() != null && getIntent().hasExtra("profession")) {
            this.f66130a = getIntent().getIntExtra("profession", -1);
            if (this.f66130a != -1) {
                View childAt = ((RadioGroup) a(R.id.profession_rg)).getChildAt(this.f66130a);
                if (childAt != null) {
                    ((RadioButton) childAt).setChecked(true);
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.RadioButton");
                }
            }
        }
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.profession_iv_back_button)).setOnClickListener(onClickListener);
        ((Button) a(R.id.fragment_edit_profession_save_btn)).setOnClickListener(onClickListener);
    }
}
