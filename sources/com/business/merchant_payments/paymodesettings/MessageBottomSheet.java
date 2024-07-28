package com.business.merchant_payments.paymodesettings;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.ResolveIssueListener;
import com.business.merchant_payments.databinding.MpFragmentMessageSheetBinding;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;

public class MessageBottomSheet extends CustomBottomSheetDialogFragment {
    public MpFragmentMessageSheetBinding mBinding;
    public ResolveIssueListener mListener;

    public void setListener(ResolveIssueListener resolveIssueListener) {
        this.mListener = resolveIssueListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (MpFragmentMessageSheetBinding) f.a(layoutInflater, R.layout.mp_fragment_message_sheet, viewGroup, false);
        if (getArguments() != null && getArguments().getBoolean("FAILURE")) {
            this.mBinding.image.setImageDrawable(b.a(getContext(), R.drawable.mp_ic_error_new));
        }
        return this.mBinding.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
    }

    private void initUI() {
        this.mBinding.tvDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ResolveIssueListener resolveIssueListener = MessageBottomSheet.this.mListener;
                if (resolveIssueListener != null) {
                    resolveIssueListener.finishActivity();
                }
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (!TextUtils.isEmpty(arguments.getString("title"))) {
                this.mBinding.tvTitle.setText(arguments.getString("title"));
            }
            if (!TextUtils.isEmpty(arguments.getString("message"))) {
                this.mBinding.tvSubTitle.setText(arguments.getString("message"));
            }
        }
    }
}
