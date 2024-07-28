package com.paytm.android.chat.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.imsdk.IMManager;
import com.imsdk.LoginInfo;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.activity.PaytmChatMainActivity;
import com.paytm.android.chat.bean.p4b.KybChannel;
import com.paytm.android.chat.bean.p4b.KybData;
import com.paytm.android.chat.fragment.h;
import com.paytm.android.chat.network.requests.RegistUserRequest;
import com.paytm.android.chat.network.response.ResponseOfRegister;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.ChatConfigUtil;
import com.paytm.android.chat.utils.ImageUtils;
import com.paytm.android.chat.utils.KybDataHelper;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;

public final class d extends h implements com.paytm.android.chat.e.d {

    /* renamed from: a  reason: collision with root package name */
    public static final b f42073a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private List<KybData> f42074b;

    /* renamed from: c  reason: collision with root package name */
    private com.paytm.android.chat.a.h f42075c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f42076d;

    public enum a {
        NO_ACCESS_UI,
        NO_CHAT_AVAILABLE_UI,
        CHAT_DISABLED_UI
    }

    private View a(int i2) {
        if (this.f42076d == null) {
            this.f42076d = new HashMap();
        }
        View view = (View) this.f42076d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f42076d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        k.c(layoutInflater2, "inflater");
        View inflate = layoutInflater2.inflate(R.layout.chat_fragment_kyb_chat, viewGroup, false);
        if (getActivity() != null) {
            k.a((Object) ChatManager.b(), "ChatManager.getInstance()");
            if (!ChatManager.h() || !AppUtilKt.checkIfRegisterIsUptoDateWithVersion()) {
                ChatManager b2 = ChatManager.b();
                ChatManager b3 = ChatManager.b();
                k.a((Object) b3, "ChatManager.getInstance()");
                com.paytm.android.chat.d g2 = b3.g();
                getContext();
                b2.a(g2.b(), (String) null, (String) null, (String) null, com.paytm.android.chat.e.a().a(getContext()), new e(this));
            } else {
                ChatManager.b().a((ChatManager.c) new c(this));
                ChatManager b4 = ChatManager.b();
                ChatManager b5 = ChatManager.b();
                k.a((Object) b5, "ChatManager.getInstance()");
                com.paytm.android.chat.d g3 = b5.g();
                getContext();
                b4.a(g3.b(), (String) null, (String) null, (String) null, com.paytm.android.chat.e.a().a(getContext()), (String) null, new C0696d());
            }
        }
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        KybDataHelper instance = KybDataHelper.getInstance();
        k.a((Object) instance, "KybDataHelper.getInstance()");
        this.f42074b = instance.getKybDataList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_store_list_container);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        ImageView imageView = (ImageView) a(R.id.iv_user_profile);
        if (imageView != null) {
            imageView.setOnClickListener(new f(this));
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_enable_chat);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(new g(this));
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            k.a((Object) activity, "activity");
            if (!activity.isFinishing()) {
                ChatManager b2 = ChatManager.b();
                k.a((Object) b2, "ChatManager.getInstance()");
                k.a((Object) b2.g(), "ChatManager.getInstance().chatGenericListener");
                List<KybData> list = this.f42074b;
                if (list != null) {
                    if (list == null) {
                        k.a();
                    }
                    if (list.size() > 0) {
                        TextView textView = (TextView) a(R.id.tv_chat_title);
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                        ImageView imageView2 = (ImageView) a(R.id.iv_user_profile);
                        if (imageView2 != null) {
                            imageView2.setVisibility(0);
                        }
                        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_store_list_container);
                        if (recyclerView2 != null) {
                            recyclerView2.setVisibility(0);
                        }
                        LinearLayout linearLayout = (LinearLayout) a(R.id.lv_chat_error_layout);
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                        List<KybData> list2 = this.f42074b;
                        if (list2 != null) {
                            RecyclerView recyclerView3 = (RecyclerView) a(R.id.rv_store_list_container);
                            if (recyclerView3 != null) {
                                recyclerView3.removeAllViews();
                            }
                            for (KybData next : list2) {
                                ArrayList arrayList = new ArrayList();
                                for (KybChannel next2 : next.getChannels()) {
                                    if (next2.isChannelEnabled()) {
                                        arrayList.add(next2);
                                    }
                                }
                                next.setChannels(arrayList);
                            }
                            FragmentActivity activity2 = getActivity();
                            if (activity2 == null) {
                                k.a();
                            }
                            k.a((Object) activity2, "activity!!");
                            Context context = activity2;
                            if (list2 != null) {
                                this.f42075c = new com.paytm.android.chat.a.h(context, (ArrayList) list2, this);
                                RecyclerView recyclerView4 = (RecyclerView) a(R.id.rv_store_list_container);
                                if (recyclerView4 != null) {
                                    recyclerView4.setAdapter(this.f42075c);
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */");
                            }
                        }
                    }
                }
                a aVar = a.NO_CHAT_AVAILABLE_UI;
                TextView textView2 = (TextView) a(R.id.tv_chat_title);
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView3 = (ImageView) a(R.id.iv_user_profile);
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                RecyclerView recyclerView5 = (RecyclerView) a(R.id.rv_store_list_container);
                if (recyclerView5 != null) {
                    recyclerView5.setVisibility(8);
                }
                LinearLayout linearLayout2 = (LinearLayout) a(R.id.lv_chat_error_layout);
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                LinearLayout linearLayout3 = (LinearLayout) a(R.id.lv_chat_error_layout);
                TextView textView3 = null;
                TextView textView4 = linearLayout3 != null ? (TextView) linearLayout3.findViewById(R.id.tv_error_info) : null;
                LinearLayout linearLayout4 = (LinearLayout) a(R.id.lv_chat_error_layout);
                if (linearLayout4 != null) {
                    textView3 = (TextView) linearLayout4.findViewById(R.id.tv_enable_chat);
                }
                int i2 = e.f42081a[aVar.ordinal()];
                if (i2 == 1) {
                    if (textView4 != null) {
                        textView4.setText(R.string.chat_access_disabled);
                    }
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                } else if (i2 == 2) {
                    if (textView4 != null) {
                        textView4.setText(R.string.chat_no_chats_available);
                    }
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                } else if (i2 == 3) {
                    if (textView4 != null) {
                        textView4.setText(R.string.chat_chat_disabled);
                    }
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                }
            }
        }
        ChatManager b3 = ChatManager.b();
        k.a((Object) b3, "ChatManager.getInstance()");
        com.paytm.android.chat.d g2 = b3.g();
        getActivity();
        String c2 = g2.c();
        if (!TextUtils.isEmpty(c2)) {
            ImageUtils.displayRoundImageFromUrl((Context) getActivity(), c2, (ImageView) a(R.id.iv_user_profile));
        }
    }

    public static final class c implements ChatManager.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f42077a;

        public final void onSuccess() {
        }

        c(d dVar) {
            this.f42077a = dVar;
        }

        public final void onFailed(int i2, String str) {
            if (i2 == 410 || i2 == 401 || i2 == 403) {
                new NetworkCustomError();
                com.paytm.android.chat.e.a().a(this.f42077a.getActivity(), (String) null, false, true);
            }
        }
    }

    /* renamed from: com.paytm.android.chat.fragment.d$d  reason: collision with other inner class name */
    public static final class C0696d implements IMManager.ConnectCallback {
        public final void onConnected(LoginInfo loginInfo) {
        }

        public final void onFailed(int i2, String str) {
        }

        C0696d() {
        }
    }

    public static final class e implements RegistUserRequest.PFRegistCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f42078a;

        e(d dVar) {
            this.f42078a = dVar;
        }

        public final void onSuccess(ResponseOfRegister responseOfRegister) {
            k.c(responseOfRegister, "responseOfRegister");
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            com.paytm.android.chat.d g2 = b2.g();
            k.a((Object) g2, "ChatManager.getInstance().chatGenericListener");
            SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.LAST_REGISTER_CALLED_FOR_VERSION, g2.a());
            this.f42078a.getActivity();
        }

        public final void onFailure(int i2, String str) {
            k.c(str, "msg");
            if (this.f42078a.getActivity() != null) {
                h.a aVar = h.f42087a;
                String unused = h.f42088b;
                StringBuilder sb = new StringBuilder("registToServer failed[");
                sb.append(i2);
                sb.append("]");
                sb.append(str);
                if (i2 == 410 || i2 == 401 || i2 == 403) {
                    new NetworkCustomError();
                    com.paytm.android.chat.e.a().a(this.f42078a.getActivity(), (String) null, false, true);
                    return;
                }
                Toast.makeText(this.f42078a.getActivity(), R.string.chat_module_toast_chat_register_failed_toast, 0).show();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f42079a;

        f(d dVar) {
            this.f42079a = dVar;
        }

        public final void onClick(View view) {
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.g().a((Context) this.f42079a.getActivity());
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f42080a;

        g(d dVar) {
            this.f42080a = dVar;
        }

        public final void onClick(View view) {
            k.a((Object) ChatManager.b(), "ChatManager.getInstance()");
            this.f42080a.getActivity();
        }
    }

    public final void a(Object obj) {
        if (obj instanceof KybChannel) {
            ChatConfigUtil.Companion.getInstance().getActiveChatFilterConfig().a(((KybChannel) obj).getId());
            Intent intent = new Intent(getContext(), PaytmChatMainActivity.class);
            Context context = getContext();
            if (context != null) {
                context.startActivity(intent);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f42076d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
