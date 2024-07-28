package net.one97.paytm.chat;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.viewpager.widget.ViewPager;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.fragment.i;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.chat.ChatImplProvider;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.t;

public final class ChatInitFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private i f49562a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f49563b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f49564c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f49565d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f49566e;

    /* renamed from: f  reason: collision with root package name */
    private View f49567f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f49568g = true;

    /* renamed from: h  reason: collision with root package name */
    private final ChatInitFragment$mAppLoginStateReceiver$1 f49569h = new ChatInitFragment$mAppLoginStateReceiver$1(this);

    /* renamed from: i  reason: collision with root package name */
    private HashMap f49570i;

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        androidx.localbroadcastmanager.a.a.a(context).a(this.f49569h, new IntentFilter("action_update_login_status"));
    }

    /* access modifiers changed from: private */
    public final void a() {
        FragmentActivity activity = getActivity();
        if (activity != null && com.paytm.utility.a.p(getActivity()) && !TextUtils.isEmpty(com.paytm.utility.a.a((Context) getActivity()))) {
            ChatImplProvider.a aVar = ChatImplProvider.f49553a;
            Application application = activity.getApplication();
            k.a((Object) application, "application");
            ChatImplProvider.a.a(application);
            k.a((Object) ChatManager.b(), "ChatManager.getInstance()");
            if (!ChatManager.h()) {
                k.a((Object) activity, "this");
                Context context = activity;
                k.c(context, "context");
                ChatManager.b();
                ChatManager.f();
                String j = com.paytm.utility.b.j(context);
                CharSequence charSequence = j;
                if (charSequence == null || charSequence.length() == 0) {
                    j = com.paytm.utility.a.b(context);
                }
                String a2 = com.paytm.utility.a.a(context);
                try {
                    k.a((Object) a2, "id");
                    SharedPreferencesUtil.saveLong(SharedPreferencesUtil.Key.PF_ID, Long.parseLong(a2));
                } catch (Exception | NumberFormatException unused) {
                }
                SharedPreferencesUtil.saveNickname(j);
                SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_PROFILE_MOBILE_NUMBER, com.paytm.utility.a.b(context));
                SharedPreferencesUtil.saveProfileImg(com.paytm.utility.b.D(context));
                SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_TOKEN, t.b(context));
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.init_chat_fragment_stub, viewGroup, false);
    }

    public final void onResume() {
        ViewPager viewPager;
        super.onResume();
        q.d("onResume: isVisible: " + isVisible());
        i iVar = this.f49562a;
        if (iVar != null) {
            iVar.setUserVisibleHint(isVisible());
        }
        if (isVisible()) {
            int i2 = 0;
            if (this.f49568g) {
                this.f49568g = false;
                this.f49567f = ((ViewStub) getView().findViewById(net.one97.paytm.R.id.viewStub)).inflate();
                View view = this.f49567f;
                this.f49563b = view != null ? (ImageView) view.findViewById(R.id.btnBack) : null;
                View view2 = this.f49567f;
                this.f49564c = view2 != null ? (RoboTextView) view2.findViewById(R.id.btnLogin) : null;
                View view3 = this.f49567f;
                this.f49565d = view3 != null ? (ViewGroup) view3.findViewById(R.id.layoutLogin) : null;
                View view4 = this.f49567f;
                this.f49566e = view4 != null ? (ViewGroup) view4.findViewById(R.id.chat_container) : null;
                b();
                RoboTextView roboTextView = this.f49564c;
                if (roboTextView != null) {
                    roboTextView.setOnClickListener(new a(this));
                }
                ImageView imageView = this.f49563b;
                if (imageView != null) {
                    imageView.setOnClickListener(new b(this));
                }
            }
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            map.put("event_category", "all-chats-screen");
            map.put("event_action", "Paytm Home Swiped Left");
            map.put("event_label", String.valueOf(com.paytm.utility.a.p(getActivity())));
            map.put("event_label2", "9.1.3 | android");
            net.one97.paytm.j.a.b(hashMap, GAUtil.CUSTOM_EVENT);
            ViewGroup viewGroup = this.f49566e;
            if (viewGroup != null && getChildFragmentManager().c(viewGroup.getId()) == null && (getActivity() instanceof AJRMainActivity)) {
                FragmentActivity activity = getActivity();
                if (!(activity instanceof AJRMainActivity)) {
                    activity = null;
                }
                AJRMainActivity aJRMainActivity = (AJRMainActivity) activity;
                if (!(aJRMainActivity == null || (viewPager = aJRMainActivity.f52664b) == null)) {
                    i2 = viewPager.getCurrentItem();
                }
                if (!com.paytm.utility.a.p(getActivity()) || TextUtils.isEmpty(com.paytm.utility.a.a((Context) getActivity())) || i2 == 0) {
                    c();
                    b();
                    return;
                }
                a();
                ViewGroup viewGroup2 = this.f49566e;
                if (viewGroup2 != null) {
                    i.a aVar = i.f42094a;
                    this.f49562a = new i();
                    i iVar2 = this.f49562a;
                    if (iVar2 != null) {
                        getChildFragmentManager().a().b(viewGroup2.getId(), iVar2, "chat").c();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        boolean p = com.paytm.utility.a.p(getContext());
        ViewGroup viewGroup = this.f49566e;
        int i2 = 0;
        if (viewGroup != null) {
            viewGroup.setVisibility(p ? 0 : 8);
        }
        ViewGroup viewGroup2 = this.f49565d;
        if (viewGroup2 != null) {
            if (p) {
                i2 = 8;
            }
            viewGroup2.setVisibility(i2);
        }
    }

    public final void onDetach() {
        Context context = getContext();
        if (context != null) {
            androidx.localbroadcastmanager.a.a.a(context).a((BroadcastReceiver) this.f49569h);
        }
        super.onDetach();
    }

    /* access modifiers changed from: private */
    public final void c() {
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        List<Fragment> d2 = childFragmentManager.f3424a.d();
        k.a((Object) d2, "childFragmentManager.fragments");
        if (d2 != null && d2.size() > 0) {
            for (Fragment a2 : d2) {
                getChildFragmentManager().a().a(a2).c();
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatInitFragment f49571a;

        a(ChatInitFragment chatInitFragment) {
            this.f49571a = chatInitFragment;
        }

        public final void onClick(View view) {
            this.f49571a.startActivity(new Intent(this.f49571a.requireContext(), AJRAuthActivity.class));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatInitFragment f49572a;

        b(ChatInitFragment chatInitFragment) {
            this.f49572a = chatInitFragment;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f49572a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f49570i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
