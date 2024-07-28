package com.travel.train.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainLoginActivity;
import com.travel.train.j.w;

public class ao extends am {

    /* renamed from: a  reason: collision with root package name */
    public View f26910a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26911b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f26912c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26913d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f26914e;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_t_train_assis_reset_password_dialog, (ViewGroup) null, false);
        this.f26910a = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.train_assist_back_button);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ao.this.a(view);
            }
        });
        this.f26911b = (TextView) inflate.findViewById(R.id.train_assist_title_textview);
        String b2 = w.a(getActivity().getApplicationContext()).b("registered_user_id", "", false);
        if (!TextUtils.isEmpty(b2)) {
            this.f26911b.setText(getResources().getString(R.string.train_assist_reset_password_for, new Object[]{"\"" + b2 + "\""}));
        }
        final EditText editText = (EditText) inflate.findViewById(R.id.train_assist_reset_password_edittext);
        editText.requestFocus();
        ((TextView) inflate.findViewById(R.id.train_assist_reset_textview)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ((AJRTrainLoginActivity) ao.this.getActivity()).a(editText.getText().toString(), false);
            }
        });
        this.f26912c = (LinearLayout) inflate.findViewById(R.id.auto_retry_info_layout);
        this.f26914e = (TextView) inflate.findViewById(R.id.auto_retry_cancel_button);
        this.f26913d = (TextView) inflate.findViewById(R.id.auto_retry_description_text);
        this.f26914e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                new Handler().post(new Runnable() {
                    public final void run() {
                        ao.this.a();
                    }
                });
            }
        });
        this.f26911b.setVisibility(0);
        this.f26912c.setVisibility(8);
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 1);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (!arguments.getBoolean("dismiss-dialog", false)) {
                a();
            } else {
                String string = arguments.getString("train-number");
                if (TextUtils.isEmpty(string)) {
                    a(arguments.getString("train-email"), true);
                } else {
                    a(string, false);
                }
            }
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (getActivity() instanceof AJRTrainLoginActivity) {
            ((AJRTrainLoginActivity) getActivity()).a();
        }
    }

    public final void a(String str, boolean z) {
        LinearLayout linearLayout;
        if (!TextUtils.isEmpty(str) && (linearLayout = this.f26912c) != null && this.f26911b != null && this.f26913d != null) {
            linearLayout.setVisibility(0);
            this.f26911b.setVisibility(8);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("Email Id ");
            } else {
                sb.append("mobile no. ");
            }
            sb.append(str);
            this.f26913d.setText(getString(R.string.please_wait_we_re_auto_trying_with_mobile_no_n_s, sb.toString()));
        }
    }

    public final void a() {
        LinearLayout linearLayout = this.f26912c;
        if (linearLayout != null && this.f26911b != null) {
            linearLayout.setVisibility(8);
            this.f26911b.setVisibility(0);
        }
    }
}
