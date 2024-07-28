package net.one97.paytm.oauth.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class ba extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56399a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f56400b;

    /* renamed from: c  reason: collision with root package name */
    private b f56401c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f56402d;

    public interface b {
        void a_(String str);
    }

    private View a(int i2) {
        if (this.f56402d == null) {
            this.f56402d = new HashMap();
        }
        View view = (View) this.f56402d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56402d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ba a(Bundle bundle) {
            k.c(bundle, "bundle");
            ba baVar = new ba();
            baVar.setArguments(bundle);
            return baVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_permission_dialog, viewGroup, false);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.PermissionDialogFragmentStyle);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnGrantPermissions);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_cancel);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        Bundle arguments = getArguments();
        this.f56400b = arguments != null ? arguments.getString("permissionstate") : null;
        String str = this.f56400b;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -707913088) {
                if (hashCode != 1102167595) {
                    if (hashCode == 1901043637 && str.equals("location")) {
                        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_header);
                        if (roboTextView2 != null) {
                            roboTextView2.setText(getString(R.string.header_grant_location_permission));
                        }
                        RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_description);
                        if (roboTextView3 != null) {
                            roboTextView3.setText(getString(R.string.desc_one_location_permission));
                        }
                        RoboTextView roboTextView4 = (RoboTextView) a(R.id.tv_description1);
                        if (roboTextView4 != null) {
                            roboTextView4.setText(getString(R.string.desc_two_location_permission));
                        }
                        a("location_intent_popup_loaded");
                    }
                } else if (str.equals("sms_state")) {
                    RoboTextView roboTextView5 = (RoboTextView) a(R.id.tv_header);
                    if (roboTextView5 != null) {
                        roboTextView5.setText(getString(R.string.grant_sms_permission));
                    }
                    RoboTextView roboTextView6 = (RoboTextView) a(R.id.tv_description);
                    if (roboTextView6 != null) {
                        roboTextView6.setText(getString(R.string.sms_state_permission_body));
                    }
                    RoboTextView roboTextView7 = (RoboTextView) a(R.id.tv_description1);
                    if (roboTextView7 != null) {
                        roboTextView7.setVisibility(8);
                    }
                    a("send_sms_intent_popup_loaded");
                }
            } else if (str.equals("phone_state")) {
                RoboTextView roboTextView8 = (RoboTextView) a(R.id.tv_header);
                if (roboTextView8 != null) {
                    roboTextView8.setText(getString(R.string.grant_phone_permission));
                }
                RoboTextView roboTextView9 = (RoboTextView) a(R.id.tv_description);
                if (roboTextView9 != null) {
                    roboTextView9.setText(getString(R.string.phone_state_permission_body));
                }
                RoboTextView roboTextView10 = (RoboTextView) a(R.id.tv_description1);
                if (roboTextView10 != null) {
                    roboTextView10.setText(getString(R.string.lbl_protect_account_from_unauthorized_access));
                }
                a("phone_state_intent_popup_loaded");
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnGrantPermissions;
        if (valueOf != null && valueOf.intValue() == i2) {
            if (this.f56401c != null) {
                b bVar = this.f56401c;
                if (bVar == null) {
                    k.a("permissionlistener");
                }
                bVar.a_(this.f56400b);
            }
            String str = this.f56400b;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -707913088) {
                    if (hashCode != 1102167595) {
                        if (hashCode == 1901043637 && str.equals("location")) {
                            a("location_intent_allow");
                        }
                    } else if (str.equals("sms_state")) {
                        a("send_sms_intent_allow");
                    }
                } else if (str.equals("phone_state")) {
                    a("phone_state_intent_allow");
                }
            }
            dismissAllowingStateLoss();
            return;
        }
        int i3 = R.id.tv_cancel;
        if (valueOf != null && valueOf.intValue() == i3) {
            String str2 = this.f56400b;
            if (str2 != null) {
                int hashCode2 = str2.hashCode();
                if (hashCode2 != -707913088) {
                    if (hashCode2 != 1102167595) {
                        if (hashCode2 == 1901043637 && str2.equals("location")) {
                            a("location_intent_deny");
                        }
                    } else if (str2.equals("sms_state")) {
                        a("send_sms_intent_deny");
                    }
                } else if (str2.equals("phone_state")) {
                    a("phone_state_intent_deny");
                }
            }
            dismissAllowingStateLoss();
        }
    }

    public final void a(b bVar) {
        k.c(bVar, "listener");
        this.f56401c = bVar;
    }

    private static void a(String str) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "login_signup", str, (ArrayList<String>) null, (String) null, "/login-signup", p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56402d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
