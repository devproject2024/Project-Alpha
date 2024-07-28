package com.paytm.business.merchantprofile.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.databinding.f;
import com.business.common_module.utilities.d;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.databinding.PrFragmentMessageSheetBinding;

public class MessageBottomSheet extends CustomBottomSheetDialogFragment {
    public PrFragmentMessageSheetBinding mBinding;
    public ResolveIssueListener mListener;

    public interface ResolveIssueListener extends d {
        void finishActivity();
    }

    public void setListener(ResolveIssueListener resolveIssueListener) {
        this.mListener = resolveIssueListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (PrFragmentMessageSheetBinding) f.a(layoutInflater, R.layout.pr_fragment_message_sheet, viewGroup, false);
        if (!(getContext() == null || getArguments() == null || !getArguments().getBoolean("FAILURE"))) {
            this.mBinding.image.setImageDrawable(b.a(getContext(), R.drawable.pr_ic_error));
        }
        return this.mBinding.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
    }

    private void initUI() {
        this.mBinding.tvDone.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MessageBottomSheet.this.lambda$initUI$0$MessageBottomSheet(view);
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

    public /* synthetic */ void lambda$initUI$0$MessageBottomSheet(View view) {
        ResolveIssueListener resolveIssueListener = this.mListener;
        if (resolveIssueListener != null) {
            resolveIssueListener.finishActivity();
        }
    }
}
