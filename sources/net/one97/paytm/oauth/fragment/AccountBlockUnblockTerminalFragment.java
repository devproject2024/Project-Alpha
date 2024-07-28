package net.one97.paytm.oauth.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.navigation.d;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.TerminalPageState;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class AccountBlockUnblockTerminalFragment extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56048a = {y.a((t) new u(y.b(AccountBlockUnblockTerminalFragment.class), "args", "<v#0>"))};

    /* renamed from: b  reason: collision with root package name */
    private boolean f56049b;

    /* renamed from: c  reason: collision with root package name */
    private TerminalPageState f56050c = TerminalPageState.DEFAULT;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56051d;

    public final View a(int i2) {
        if (this.f56051d == null) {
            this.f56051d = new HashMap();
        }
        View view = (View) this.f56051d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56051d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56051d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_account_block_terminal, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        RoboTextView roboTextView;
        super.onActivityCreated(bundle);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnCall);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_homepage);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        g dVar = new d(y.b(j.class), new a(this));
        this.f56049b = ((j) dVar.getValue()).a();
        TerminalPageState b2 = ((j) dVar.getValue()).b();
        k.a((Object) b2, "args.netOne97PaytmOauthUtilsTerminalPageState");
        this.f56050c = b2;
        if (!this.f56049b) {
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_description);
            if (roboTextView3 != null) {
                roboTextView3.setText(getString(R.string.lbl_unblock_account_desc));
            }
            ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnCall);
            if (progressViewButton2 != null) {
                progressViewButton2.setButtonText(getString(R.string.lbl_call_unblock));
            }
        }
        if (this.f56050c == TerminalPageState.IS_LIMIT_EXCEED) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imageView);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R.drawable.ic_verification_limit_exceed);
            }
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.tv_header);
            if (roboTextView4 != null) {
                roboTextView4.setText(getString(R.string.lbl_attempts_exceeded));
            }
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.tv_description);
            if (roboTextView5 != null) {
                roboTextView5.setText(getString(R.string.lbl_attempts_exceed_description));
            }
            RoboTextView roboTextView6 = (RoboTextView) a(R.id.tv_description_2);
            if (roboTextView6 != null) {
                roboTextView6.setVisibility(0);
            }
            RoboTextView roboTextView7 = (RoboTextView) a(R.id.tv_description_3);
            if (roboTextView7 != null) {
                roboTextView7.setVisibility(0);
            }
            if (this.f56049b && (roboTextView = (RoboTextView) a(R.id.tv_description_3)) != null) {
                roboTextView.setText(getString(R.string.lbl_block_account_desc));
            }
        } else if (!this.f56049b && this.f56050c == TerminalPageState.IS_ACCOUNT_ACTIVE) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.imageView);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_account_unblocked_successfully);
            }
            RoboTextView roboTextView8 = (RoboTextView) a(R.id.tv_header);
            if (roboTextView8 != null) {
                roboTextView8.setText(getString(R.string.lbl_account_active));
            }
            RoboTextView roboTextView9 = (RoboTextView) a(R.id.tv_description);
            if (roboTextView9 != null) {
                roboTextView9.setText(getString(R.string.lbl_account_active_description_text));
            }
        } else if (!this.f56049b && this.f56050c == TerminalPageState.IS_RECENTLY_BLOCKED) {
            RoboTextView roboTextView10 = (RoboTextView) a(R.id.tv_header);
            if (roboTextView10 != null) {
                roboTextView10.setText(getString(R.string.lbl_could_not_process_request_header));
            }
            RoboTextView roboTextView11 = (RoboTextView) a(R.id.tv_description);
            if (roboTextView11 != null) {
                roboTextView11.setText(getString(R.string.lbl_account_recently_blocked_description));
            }
        } else if (this.f56049b && this.f56050c == TerminalPageState.IS_ACCOUNT_BLOCKED) {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.imageView);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setImageResource(R.drawable.ic_account_blocked_successfully);
            }
            RoboTextView roboTextView12 = (RoboTextView) a(R.id.tv_header);
            if (roboTextView12 != null) {
                roboTextView12.setText(getString(R.string.lbl_account_already_blocked_header));
            }
            RoboTextView roboTextView13 = (RoboTextView) a(R.id.tv_description);
            if (roboTextView13 != null) {
                roboTextView13.setText(getString(R.string.lbl_account_already_blocked_desc));
            }
        }
        if (!this.f56049b) {
            String[] strArr = new String[3];
            strArr[0] = "";
            RoboTextView roboTextView14 = (RoboTextView) a(R.id.tv_header);
            CharSequence charSequence = null;
            strArr[1] = String.valueOf(roboTextView14 != null ? roboTextView14.getText() : null);
            RoboTextView roboTextView15 = (RoboTextView) a(R.id.tv_description);
            if (roboTextView15 != null) {
                charSequence = roboTextView15.getText();
            }
            strArr[2] = String.valueOf(charSequence);
            v.a("/unblock_failure", "diy_unblock", "unblock_failure_page_loaded", kotlin.a.k.d(strArr), 16);
        }
    }

    public static final class a extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.$this_navArgs = fragment;
        }

        public final Bundle invoke() {
            Bundle arguments = this.$this_navArgs.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException("Fragment " + this.$this_navArgs + " has null arguments");
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnCall;
        if (valueOf != null && valueOf.intValue() == i2) {
            if (!this.f56049b) {
                v.a("/unblock_failure", "diy_unblock", "call_cst_clicked", (ArrayList) null, 24);
            }
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:".concat(this.f56049b ? "1800120130" : "1204456456")));
            startActivity(intent);
            return;
        }
        int i3 = R.id.tv_homepage;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (!this.f56049b) {
                v.a("/unblock_failure", "diy_unblock", "go_to_home_clicked", (ArrayList) null, 24);
            }
            OauthModule.b().openHomePage(requireContext(), false, "", false);
        }
    }
}
