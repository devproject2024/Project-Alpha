package com.paytm.android.chat.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.imsdk.CPCSendbirdWrapper;
import com.imsdk.Datawrapper;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.e;
import com.paytm.android.chat.activity.APCChatActivity;
import com.paytm.android.chat.activity.ChatSearchActivity;
import com.paytm.android.chat.activity.PaytmChatSettingsActivity;
import com.paytm.android.chat.b;
import com.paytm.android.chat.base.a;
import com.paytm.android.chat.bean.FriendBean;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.SendContactBean;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.bean.UserType;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.d;
import com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.f;
import com.paytm.android.chat.fragment.c;
import com.paytm.android.chat.fragment.f;
import com.paytm.android.chat.network.response.HomeChips;
import com.paytm.android.chat.receiver.NetworkReceiver;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.CPCMessagePreviewUtilsKt;
import com.paytm.android.chat.utils.CPCMessageUtilsKt;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.ChatConfigUtil;
import com.paytm.android.chat.utils.ChatNotificationHelper;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.FileUtils;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.view.ChatHeadView;
import com.paytm.android.chat.view.ChatSwipeRefreshLayout;
import com.paytm.utility.q;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBirdException;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;

public class c extends a implements NetworkReceiver.a {
    /* access modifiers changed from: private */
    public EditText A;
    /* access modifiers changed from: private */
    public ImageView B;
    /* access modifiers changed from: private */
    public ImageView C;
    private boolean D = false;
    /* access modifiers changed from: private */
    public ContactManager E;
    /* access modifiers changed from: private */
    public TextView F;
    private TextView G;
    /* access modifiers changed from: private */
    public TextView H;
    private ArrayList<com.paytm.android.chat.contact.a> I;
    private com.paytm.android.chat.e.a J;
    /* access modifiers changed from: private */
    public RelativeLayout K;
    /* access modifiers changed from: private */
    public int L = 0;
    /* access modifiers changed from: private */
    public boolean M = true;
    private boolean N = true;
    private List<String> O = new ArrayList();
    /* access modifiers changed from: private */
    public List<ChatGroupChannelDataModel> P = new ArrayList();
    private f Q;
    private View R;
    private boolean S = false;
    private ArrayList<SelectContactsBean> T = new ArrayList<>();
    private io.reactivex.rxjava3.b.c U;
    /* access modifiers changed from: private */
    public b V;
    private ChatRepository W;
    private InputFilter.LengthFilter X = new InputFilter.LengthFilter(25);
    private final int Y = 1000;
    private long Z = 0;

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f42041a;
    private View.OnKeyListener aa = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || i2 != 4 || !c.this.A.isFocusable()) {
                return false;
            }
            c.this.f42041a.setFocusable(true);
            c.this.f42041a.setFocusableInTouchMode(true);
            c.this.f42041a.requestFocus();
            return true;
        }
    };
    private b.C0693b ab = new b.C0693b() {
        public final void a(List<Object> list, h.b bVar, int i2, List<FriendBean> list2, int i3) {
            if (!c.this.isDetached() && c.this.getActivity() != null) {
                q.b("onChatHomeListLoad");
                c cVar = c.this;
                List unused = cVar.P = cVar.V.f41763c;
                Parcelable onSaveInstanceState = c.this.x.getLayoutManager().onSaveInstanceState();
                e d2 = c.this.y;
                int size = list2.size();
                d2.f41069h = i3;
                d2.f41070i = size;
                d2.f41068g.clear();
                d2.f41068g.addAll(list);
                bVar.a((RecyclerView.a) d2);
                c.this.x.getLayoutManager().onRestoreInstanceState(onSaveInstanceState);
                c.this.x.setVisibility(0);
                int unused2 = c.this.L = i2;
                if (c.this.L > 0) {
                    androidx.core.widget.e.a(c.this.C, (ColorStateList) null);
                    c.this.C.setEnabled(true);
                    c.this.C.setVisibility(0);
                } else {
                    c.this.C.setVisibility(8);
                }
                if (c.this.M && c.this.getContext() != null) {
                    ChatAnalyticsHelperKt.fireChatHomeLoadEvent(c.this.getContext(), "Channel Listing", i3, c.this.L, c.this.t.size() > 0, c.this.t.size(), list2.size() > 0);
                    boolean unused3 = c.this.M = false;
                }
                c.this.z.setRefreshing(false);
                c.this.K.setVisibility(0);
                c.this.b(false);
                c.b(c.this, list2);
                c cVar2 = c.this;
                c.c(cVar2, cVar2.P);
            }
        }

        public final void a(List<Object> list, h.b bVar, String str) {
            if (!c.this.isDetached() && c.this.getActivity() != null) {
                q.b("onSearch");
                c.this.y.a(list, bVar);
                c.this.x.smoothScrollToPosition(0);
                if (list.size() == 0) {
                    c.this.x.setVisibility(4);
                    c.this.F.setVisibility(0);
                    TextView n = c.this.F;
                    n.setText("No chat result found for '" + str + "'");
                } else {
                    c.this.F.setVisibility(8);
                    c.this.x.setVisibility(0);
                }
                c.this.K.setVisibility(8);
            }
        }
    };
    private boolean ac = false;
    /* access modifiers changed from: private */
    public Handler ad = new Handler();

    /* renamed from: b  reason: collision with root package name */
    ImageButton f42042b;

    /* renamed from: c  reason: collision with root package name */
    RelativeLayout f42043c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public ChatHeadView f42044d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayout f42045e;

    /* renamed from: f  reason: collision with root package name */
    NetworkReceiver f42046f;

    /* renamed from: g  reason: collision with root package name */
    boolean f42047g = false;

    /* renamed from: h  reason: collision with root package name */
    View f42048h;

    /* renamed from: i  reason: collision with root package name */
    View f42049i;
    View j;
    LinearLayout k;
    LinearLayout l;
    LinearLayout m;
    LinearLayout n;
    ChatHeadView o;
    ChatHeadView p;
    TextView q;
    TextView r;
    TextView s;
    ArrayList<HomeChips> t = new ArrayList<>();
    Map<String, SendContactBean> u = new HashMap();
    boolean v = false;
    ImageView w;
    /* access modifiers changed from: private */
    public RecyclerView x;
    /* access modifiers changed from: private */
    public e y;
    /* access modifiers changed from: private */
    public ChatSwipeRefreshLayout z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Throwable th) throws Throwable {
    }

    public static c a(boolean z2) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putBoolean("EXTRA_SHOW_BACK_BUTTON", z2);
        cVar.setArguments(bundle);
        return cVar;
    }

    private void h() {
        try {
            this.f42048h.setVisibility(8);
            this.f42049i.setVisibility(8);
            this.j.setVisibility(8);
            this.G.setText("New Chat");
        } catch (Exception unused) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ConstraintLayout constraintLayout;
        View inflate = layoutInflater.inflate(R.layout.chat_fragment_group_channel_list, viewGroup, false);
        setRetainInstance(true);
        this.E = ContactManager.getInstance();
        this.f42048h = inflate.findViewById(R.id.ll_group_channel_blank);
        this.f42049i = inflate.findViewById(R.id.layoutMerchantOnboarding);
        this.j = inflate.findViewById(R.id.layoutMerchantUpcomingOnboarding);
        this.x = (RecyclerView) inflate.findViewById(R.id.recycler_group_channel_list);
        this.z = (ChatSwipeRefreshLayout) inflate.findViewById(R.id.swipe_layout_group_channel_list);
        this.A = (EditText) inflate.findViewById(R.id.friend_search_edit);
        this.A.setFilters(new InputFilter[]{this.X});
        this.K = (RelativeLayout) inflate.findViewById(R.id.ll_btn_new_chat);
        this.G = (TextView) inflate.findViewById(R.id.textChatButton);
        this.w = (ImageView) inflate.findViewById(R.id.contects_list);
        this.f42041a = (RelativeLayout) inflate.findViewById(R.id.friend_search_lin);
        this.f42042b = (ImageButton) inflate.findViewById(R.id.btn_search);
        this.f42043c = (RelativeLayout) inflate.findViewById(R.id.friend_search_bg);
        this.F = (TextView) inflate.findViewById(R.id.tv_no_results);
        this.R = inflate.findViewById(R.id.layoutLoader);
        this.k = (LinearLayout) inflate.findViewById(R.id.ll_new_friend);
        this.l = (LinearLayout) inflate.findViewById(R.id.layout_group_chat_contact);
        this.o = (ChatHeadView) inflate.findViewById(R.id.image_group_chat_contact_image1);
        this.m = (LinearLayout) inflate.findViewById(R.id.ll_contact_image2);
        this.p = (ChatHeadView) inflate.findViewById(R.id.image_group_chat_contact_image2);
        this.n = (LinearLayout) inflate.findViewById(R.id.ll_friend_count_container);
        this.q = (TextView) inflate.findViewById(R.id.tv_friend_count);
        this.s = (TextView) inflate.findViewById(R.id.tv_new_friend_noti);
        this.r = (TextView) inflate.findViewById(R.id.tv_view);
        this.C = (ImageView) inflate.findViewById(R.id.btnChatMarkasspam);
        if (ChatConfigUtil.Companion.getInstance().isP4B()) {
            inflate.findViewById(R.id.friend_search).setVisibility(8);
        }
        this.f42045e = (LinearLayout) inflate.findViewById(R.id.network_error);
        this.f42044d = (ChatHeadView) inflate.findViewById(R.id.myProfileImage);
        this.H = (TextView) inflate.findViewById(R.id.btn_cancel_search);
        this.H.setVisibility(4);
        View findViewById = inflate.findViewById(R.id.btnBack);
        if (findViewById != null) {
            if (this.S) {
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener(findViewById) {
                    private final /* synthetic */ View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        c.this.a(this.f$1, view);
                    }
                });
                Fragment parentFragment = getParentFragment();
                if ((parentFragment instanceof i) && (constraintLayout = (ConstraintLayout) ((i) parentFragment).a(R.id.header)) != null) {
                    f.a((View) constraintLayout, false);
                }
            } else {
                findViewById.setVisibility(8);
            }
        }
        this.H.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.d();
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.b(view);
            }
        });
        this.f42042b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!AppUtilKt.hasPermission(c.this.getActivity(), "android.permission.READ_CONTACTS")) {
                    c.this.a();
                    return;
                }
                ChatAnalyticsHelperKt.fireToolbarIconClickEvent(c.this.requireContext(), "Search Icon Click", c.this.P.size(), c.this.L, c.this.t.size() > 0, c.this.t.size(), c.this.y != null && c.this.y.f41070i > 0);
                c.this.f42041a.setVisibility(0);
                Animation loadAnimation = AnimationUtils.loadAnimation(c.this.getActivity(), R.anim.chat_search_lyt_enter_anim);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(c.this.getActivity(), R.anim.chat_profile_icon_exit_anim);
                loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        c.this.f42044d.setVisibility(8);
                        c.this.H.setVisibility(0);
                        com.paytm.android.chat.view.kpswitch.b.a.a((View) c.this.A);
                    }
                });
                c.this.f42041a.clearAnimation();
                c.this.f42044d.clearAnimation();
                c.this.f42041a.startAnimation(loadAnimation);
                c.this.f42044d.startAnimation(loadAnimation2);
            }
        });
        inflate.findViewById(R.id.btn_chat_settings).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.startActivity(new Intent(cVar.getActivity(), PaytmChatSettingsActivity.class));
                ChatAnalyticsHelperKt.fireToolbarIconClickEvent(c.this.requireContext(), "Settings Icon Click", c.this.P.size(), c.this.L, c.this.t.size() > 0, c.this.t.size(), c.this.y != null && c.this.y.f41070i > 0);
            }
        });
        this.B = (ImageView) inflate.findViewById(R.id.tv_friend_search_exit);
        this.z.setHeaderView(j());
        this.z.setFooterView(j());
        this.z.setTargetScrollWithLayout(true);
        this.z.setOnPullRefreshListener(new ChatSwipeRefreshLayout.b() {
            public final void a() {
                q.b("### onRefresh");
                c.this.c(true);
            }

            public final void b() {
                c.this.z.setHeaderView(c.this.j());
            }
        });
        this.z.setOnPushLoadMoreListener(new ChatSwipeRefreshLayout.c() {
            public final void a() {
                b k = c.this.V;
                CharSequence charSequence = k.f41766f;
                boolean z = true;
                if (charSequence == null || p.a(charSequence)) {
                    z = false;
                } else {
                    k.a(k.f41766f).b(io.reactivex.rxjava3.i.a.b()).b(new b.e(k)).a(io.reactivex.rxjava3.i.a.b()).a(new b.f(k), (g<? super Throwable>) b.g.f41785a);
                }
                if (!z) {
                    c.this.z.setLoadMore(false);
                }
            }

            public final void b() {
                c.this.z.setFooterView(c.this.j());
            }
        });
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick()) {
                        c.this.k();
                        c.this.f42041a.setFocusable(true);
                        c.this.f42041a.setFocusableInTouchMode(true);
                        c.this.f42041a.requestFocus();
                    }
                }
            });
        }
        this.K.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.f42047g = true;
                if (!AppUtilKt.hasPermission(cVar.getActivity(), "android.permission.READ_CONTACTS")) {
                    c.this.a();
                    return;
                }
                c.this.f42047g = false;
                if (FastClickUtil.isFastClick()) {
                    c.this.k();
                    c.this.f42041a.setFocusable(true);
                    c.this.f42041a.setFocusableInTouchMode(true);
                    c.this.f42041a.requestFocus();
                    if (c.this.y != null && c.this.getContext() != null) {
                        ChatAnalyticsHelperKt.fireToolbarIconClickEvent(c.this.requireContext(), "New Chat CTA Click", c.this.P.size(), c.this.L, c.this.t.size() > 0, c.this.t.size(), c.this.y != null && c.this.y.f41070i > 0);
                    }
                }
            }
        });
        if (getActivity() != null) {
            this.y = new e(getActivity());
            this.x.setItemAnimator((RecyclerView.f) null);
            this.x.setLayoutManager(new LinearLayoutManager(getContext()));
            this.x.setAdapter(this.y);
            this.y.f41066e = new e.h() {
                public final void a(SelectContactsBean selectContactsBean) {
                    if (selectContactsBean.getSendContactBean().getContactPhone() != null && !"".equals(selectContactsBean.getSendContactBean().getContactPhone())) {
                        SyncContactBean searchContactByPhone = c.this.E.searchContactByPhone(selectContactsBean.getSendContactBean().getContactPhone());
                        if (c.this.getActivity() != null && !c.this.getActivity().isFinishing() && !c.this.getActivity().isDestroyed()) {
                            if (searchContactByPhone != null) {
                                APCChatActivity.a aVar = APCChatActivity.f41472g;
                                APCChatActivity.a.a(c.this.getActivity(), searchContactByPhone.getChannelUrl(), selectContactsBean.getSendContactBean().getContactPhone(), selectContactsBean.getSendContactBean().getContactName(), false);
                            } else {
                                APCChatActivity.a aVar2 = APCChatActivity.f41472g;
                                APCChatActivity.a.a(c.this.getActivity(), "", selectContactsBean.getSendContactBean().getContactPhone(), selectContactsBean.getSendContactBean().getContactName(), false);
                            }
                        }
                        com.paytm.android.chat.view.kpswitch.b.a.b(c.this.f42041a);
                        c.this.ad.postDelayed(new Runnable() {
                            public final void run() {
                                c.this.f42041a.setFocusable(true);
                                c.this.f42041a.setFocusableInTouchMode(true);
                                c.this.f42041a.requestFocus();
                            }
                        }, 1000);
                    }
                }
            };
        }
        this.y.f41064c = new e.j() {
            public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, Integer num) {
                c cVar = c.this;
                String channelUrl = chatGroupChannelDataModel.getChannelUrl();
                boolean z = false;
                if (cVar.getFragmentManager() != null && !cVar.getFragmentManager().o && cVar.getActivity() != null && !cVar.getActivity().isFinishing() && !cVar.getActivity().isDestroyed()) {
                    APCChatActivity.a aVar = APCChatActivity.f41472g;
                    APCChatActivity.a.a(cVar.getActivity(), channelUrl, (String) null, (String) null, false);
                }
                if (c.this.getContext() != null) {
                    Context context = c.this.getContext();
                    int intValue = num.intValue();
                    if (c.this.L > 0) {
                        z = true;
                    }
                    ChatAnalyticsHelperKt.fireChatOpenEvent(context, intValue, z, chatGroupChannelDataModel);
                }
            }
        };
        this.y.f41065d = new e.k() {
            /* access modifiers changed from: private */
            public static /* synthetic */ void a(Throwable th) throws Throwable {
            }

            public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z, int i2) {
                GroupChannel a2 = com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl());
                if (a2 != null && c.this.getActivity() != null) {
                    if (z) {
                        ChatManager.b().f40994f.totalPinnedLocalChannelCount().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g(a2, z, chatGroupChannelDataModel, i2) {
                            private final /* synthetic */ GroupChannel f$1;
                            private final /* synthetic */ boolean f$2;
                            private final /* synthetic */ ChatGroupChannelDataModel f$3;
                            private final /* synthetic */ int f$4;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                            }

                            public final void accept(Object obj) {
                                c.AnonymousClass10.this.a(this.f$1, this.f$2, this.f$3, this.f$4, (Integer) obj);
                            }
                        }, (g<? super Throwable>) $$Lambda$c$10$K5gM4Hh7udvfUf24f4DQXr8Rng.INSTANCE);
                        return;
                    }
                    ChatManager.b().f40994f.updateLocalChannelPinnedState(a2.getUrl(), z);
                    ChatAnalyticsHelperKt.firePinChatEvent(c.this.getActivity(), z, chatGroupChannelDataModel, i2, c.this.L);
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a(GroupChannel groupChannel, boolean z, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, Integer num) throws Throwable {
                if (num.intValue() < 3) {
                    ChatManager.b().f40994f.updateLocalChannelPinnedState(groupChannel.getUrl(), z);
                    ChatAnalyticsHelperKt.firePinChatEvent(c.this.getActivity(), z, chatGroupChannelDataModel, i2, c.this.L);
                    return;
                }
                Toast.makeText(c.this.getActivity(), R.string.chat_channel_pin_count_info, 1).show();
            }

            public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, String str, int i2) {
                c.a(c.this, chatGroupChannelDataModel, !chatGroupChannelDataModel.isPushEnabled(), str, i2);
            }

            public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel, int i2) {
                if (com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl()) != null) {
                    com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl()).resetMyHistory(new GroupChannel.GroupChannelResetMyHistoryHandler(com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl())) {
                        public final void onResult(SendBirdException sendBirdException) {
                            if (sendBirdException == null) {
                                q.b("### resetMyHistory");
                                ChatManager.b().f40994f.deleteLocalChannel(r2.getUrl());
                                if (!c.this.getActivity().isFinishing() && !c.this.getActivity().isDestroyed()) {
                                    FileUtils.deleteCacheFile(c.this.getActivity(), r2.getUrl());
                                }
                            }
                        }
                    });
                }
                if (chatGroupChannelDataModel.getLastMessage() != null) {
                    ChatAnalyticsHelperKt.fireDeleteChatEvent(c.this.requireContext(), chatGroupChannelDataModel, i2 + 1, c.this.L);
                }
            }
        };
        this.y.f41067f = new e.i() {
            public final void a(FriendBean friendBean, int i2) {
                ChatAnalyticsHelperKt.fireFriendsClickedEvent(c.this.getContext(), String.valueOf(i2), friendBean.getPreviewText(), c.this.P.size(), c.this.L, c.this.t.size() > 0, c.this.t.size());
                APCChatActivity.a aVar = APCChatActivity.f41472g;
                Context context = c.this.getContext();
                k.c(context, "context");
                if (friendBean != null) {
                    Intent intent = new Intent(context, APCChatActivity.class);
                    intent.putExtra("friend", friendBean);
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                }
            }
        };
        this.A.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().trim().isEmpty()) {
                    c.this.F.setVisibility(8);
                    c.this.B.setVisibility(8);
                } else {
                    c.this.B.setVisibility(0);
                    c.this.k.setVisibility(8);
                }
                b k = c.this.V;
                k.f41768h = editable.toString().trim();
                k.f41769i.onNext(new b.a((List) null, (List) null, (Map) null, 7));
            }
        });
        this.B.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.A.setText("");
            }
        });
        this.A.setOnKeyListener(this.aa);
        ChatManager.b().d();
        this.W = ChatManager.b().f40994f;
        this.I = new ArrayList<>();
        return inflate;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.S = arguments.getBoolean("EXTRA_SHOW_BACK_BUTTON", false);
        }
        this.f42046f = new NetworkReceiver();
        this.f42046f.f42304a = this;
        this.V = new b(getContext(), this.ab);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, View view2) {
        com.paytm.android.chat.view.kpswitch.b.a.b(view);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.DONT_SHOW_MARK_AS_READ, false)) {
            i();
        } else if (getActivity() != null) {
            f fVar = this.Q;
            if (fVar != null) {
                fVar.dismiss();
            }
            f.a aVar = f.f42082a;
            this.Q = f.a.a(new g() {
                public final void onMarkAsReadConfirmationContinueClicked(boolean z) {
                    c.this.d(z);
                }
            });
            this.Q.show(getChildFragmentManager(), (String) null);
        }
        Context requireContext = requireContext();
        int size = this.P.size();
        int i2 = this.L;
        boolean z2 = this.t.size() > 0;
        int size2 = this.t.size();
        e eVar = this.y;
        ChatAnalyticsHelperKt.fireToolbarIconClickEvent(requireContext, "Mark As Read Click", size, i2, z2, size2, eVar != null && eVar.f41070i > 0);
    }

    private void i() {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setEnabled(false);
            androidx.core.widget.e.a(this.C, ColorStateList.valueOf(androidx.core.content.b.c(getContext(), R.color.color_E8EDF3)));
        }
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.b(this.P).a(new g() {
            public final void accept(Object obj) {
                c.this.a((Boolean) obj);
            }
        }, (g<? super Throwable>) new g() {
            public final void accept(Object obj) {
                c.this.c((Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) throws Throwable {
        ImageView imageView;
        if (!bool.booleanValue() && (imageView = this.C) != null) {
            imageView.setEnabled(true);
            androidx.core.widget.e.a(this.C, (ColorStateList) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Throwable th) throws Throwable {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setEnabled(true);
            androidx.core.widget.e.a(this.C, (ColorStateList) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(boolean z2) {
        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.DONT_SHOW_MARK_AS_READ, z2);
        i();
    }

    public final void d() {
        this.A.setText("");
        com.paytm.android.chat.view.kpswitch.b.a.b(this.A);
        Handler handler = new Handler();
        this.K.setVisibility(0);
        handler.postDelayed(new Runnable() {
            public final void run() {
                c cVar = c.this;
                Animation loadAnimation = AnimationUtils.loadAnimation(cVar.getActivity(), R.anim.chat_search_lyt_exit_anim);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(cVar.getActivity(), R.anim.chat_profile_icon_enter_anim);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        c.this.f42041a.setVisibility(8);
                    }
                });
                loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        c.this.H.setVisibility(4);
                        c.this.f42044d.setVisibility(0);
                    }
                });
                cVar.f42041a.clearAnimation();
                cVar.f42044d.clearAnimation();
                cVar.f42041a.startAnimation(loadAnimation);
                cVar.f42044d.startAnimation(loadAnimation2);
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public View j() {
        return LayoutInflater.from(this.z.getContext()).inflate(R.layout.chat_layout_swipe_refresh_head, (ViewGroup) null);
    }

    /* access modifiers changed from: private */
    public void k() {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            startActivity(new Intent(getActivity(), ChatSearchActivity.class));
        }
    }

    private boolean l() {
        if (getActivity() == null || androidx.core.content.b.a((Context) getActivity(), "android.permission.READ_CONTACTS") != -1) {
            return true;
        }
        SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.view_friends_clicked_on_onboarding, false);
        return false;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 2019) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            if (getActivity() != null) {
                Toast.makeText(getActivity(), getResources().getString(R.string.chat_module_need_contact_permission), 0).show();
            }
        } else if (this.f42047g) {
            this.f42047g = false;
            k();
        } else {
            this.V.a();
            ChatAnalyticsHelperKt.fireContactPermissionConfirmEvent(requireContext(), "Contact Permission Confirm", this.P.size(), this.L, this.t.size() > 0, this.t.size());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view != null && m()) {
            view.findViewById(R.id.header).setVisibility(0);
            view.findViewById(R.id.contects_list).setVisibility(8);
        }
        View view2 = this.R;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        b bVar = this.V;
        y.a(new b.s(bVar)).b(new b.t(bVar)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(new b.u(bVar), (g<? super Throwable>) b.v.f41800a);
        this.V.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Datawrapper datawrapper) throws Throwable {
        boolean z2 = datawrapper instanceof Datawrapper.Success;
        Boolean valueOf = z2 ? Boolean.valueOf(((CPCSendbirdWrapper.ConnectionStatus) ((Datawrapper.Success) datawrapper).getData()).isImmediate()) : null;
        if (z2 && ((CPCSendbirdWrapper.ConnectionStatus) ((Datawrapper.Success) datawrapper).getData()).getStatus()) {
            c(valueOf != null && !valueOf.booleanValue());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.ad;
        if (handler != null) {
            handler.removeCallbacksAndMessages(0);
            this.ad = null;
        }
    }

    public void onResume() {
        super.onResume();
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.a(false);
        b bVar = this.V;
        io.reactivex.rxjava3.b.c cVar = bVar.f41767g;
        if (cVar != null) {
            cVar.dispose();
        }
        bVar.f41767g = bVar.f41762b.getLocalChannelsForDisplay().a(new b.h(bVar)).a(new b.i(bVar)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(new b.j(bVar), (g<? super Throwable>) b.k.f41789a);
        bVar.j = bVar.f41769i.toFlowable(io.reactivex.rxjava3.a.a.LATEST).a(new b.l(bVar)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new b.m(bVar), (g<? super Throwable>) b.n.f41792a);
        this.U = this.W.listenConnectionManagement("CONNECTION_HANDLER_GROUP_CHANNEL_LIST").b(new g() {
            public final void accept(Object obj) {
                c.this.a((Datawrapper) obj);
            }
        });
        ChatNotificationHelper.INSTANCE.clearAllNotification(getContext());
        requireActivity().registerReceiver(this.f42046f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        Context context = getContext();
        if (!(context == null || this.f42044d == null)) {
            String nickname = SharedPreferencesUtil.getNickname();
            String myProfilePic = AppUtilKt.getMyProfilePic(context);
            if (ChatConfigUtil.Companion.getInstance().isP4B()) {
                d dVar = ChatManager.b().f40989a;
                getActivity();
                myProfilePic = dVar.c();
            }
            this.f42044d.setUI(myProfilePic, nickname);
            if (this.f42041a.getVisibility() != 0) {
                this.f42044d.setVisibility(0);
            }
            this.f42044d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    c.this.a(view);
                }
            });
        }
        if (l()) {
            this.V.a();
        }
    }

    public void onPause() {
        super.onPause();
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.a(true);
        b bVar = this.V;
        io.reactivex.rxjava3.b.c cVar = bVar.f41767g;
        if (cVar != null) {
            cVar.dispose();
        }
        io.reactivex.rxjava3.b.c cVar2 = bVar.j;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        io.reactivex.rxjava3.b.c cVar3 = this.U;
        if (cVar3 != null) {
            cVar3.dispose();
        }
        requireActivity().unregisterReceiver(this.f42046f);
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public final boolean e() {
        if (this.f42041a.getVisibility() != 0) {
            return false;
        }
        if (this.A.getText().toString().trim().length() > 0) {
            this.A.setText("");
            return true;
        }
        d();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List a(List list, List list2, List list3) throws Throwable {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list3.iterator();
        while (it2.hasNext()) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) it2.next();
            if (chatGroupChannelDataModel.getLastMessage() == null) {
                arrayList.add(chatGroupChannelDataModel);
            } else if (chatGroupChannelDataModel.getLastMessagePreview() == null || TextUtils.isEmpty(chatGroupChannelDataModel.getLastMessagePreview().getPreviewText())) {
                arrayList.add(chatGroupChannelDataModel);
                list.add(chatGroupChannelDataModel);
            }
        }
        if (!this.N || list2.size() <= 0) {
            return kotlin.a.k.a(arrayList, $$Lambda$c$jM_ho8O3tQ64FBgZqvL4iyJfE5s.INSTANCE);
        }
        this.N = false;
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        boolean z2 = !MessageDBHelperKt.getNonAdminMessagesForChannelByUrl(chatGroupChannelDataModel.getChannelUrl()).isEmpty();
        if (MessageDBHelperKt.getPreviewTextNotEmptyMessagesByChannelUrl(chatGroupChannelDataModel.getChannelUrl()).isEmpty()) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List c(List list) throws Throwable {
        io.reactivex.rxjava3.a.h.a(list).a(new io.reactivex.rxjava3.d.h() {
            public final Object apply(Object obj) {
                return c.this.d((List) obj);
            }
        }).b();
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List d(List list) throws Throwable {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) it2.next();
            if (!this.O.contains(chatGroupChannelDataModel.getChannelUrl())) {
                this.O.add(chatGroupChannelDataModel.getChannelUrl());
                CPCMessageUtilsKt.fetchLatestMessagesFromProvider(chatGroupChannelDataModel, new BaseChannel.GetMessagesHandler(chatGroupChannelDataModel) {
                    private final /* synthetic */ ChatGroupChannelDataModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onResult(List list, SendBirdException sendBirdException) {
                        c.this.a(this.f$1, list, sendBirdException);
                    }
                });
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ChatGroupChannelDataModel chatGroupChannelDataModel, List list, SendBirdException sendBirdException) {
        if (sendBirdException == null && list != null && !list.isEmpty()) {
            com.paytm.android.chat.d.a.a aVar = com.paytm.android.chat.d.a.a.f41891a;
            if (com.paytm.android.chat.d.a.a.a(chatGroupChannelDataModel.getChannelUrl()) != null) {
                com.paytm.android.chat.d.a.a aVar2 = com.paytm.android.chat.d.a.a.f41891a;
                MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.a.a(chatGroupChannelDataModel.getChannelUrl()), (List<? extends BaseMessage>) list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    BaseMessage baseMessage = (BaseMessage) it2.next();
                    if (!(baseMessage instanceof AdminMessage)) {
                        try {
                            com.paytm.android.chat.d.a.a aVar3 = com.paytm.android.chat.d.a.a.f41891a;
                            ChatMessageDataModel chatMessageDataModelFromMessageEntity = MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(MessageDBHelperKt.getChatMessageEntity(com.paytm.android.chat.d.a.a.a(chatGroupChannelDataModel.getChannelUrl()), baseMessage), false);
                            chatGroupChannelDataModel.setLastMessage(chatMessageDataModelFromMessageEntity);
                            chatGroupChannelDataModel.setLastmessageId(Long.valueOf(chatMessageDataModelFromMessageEntity.messageId));
                            chatGroupChannelDataModel.setLastMessageType(chatMessageDataModelFromMessageEntity.messageType);
                            chatGroupChannelDataModel.setLastMessagePreview(CPCMessagePreviewUtilsKt.getMessagePreview(baseMessage));
                            this.W.updateLocalChannel(chatGroupChannelDataModel).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (this.P.size() != 0 || this.D) {
            View view = this.R;
            if (view != null) {
                view.setVisibility(8);
            }
            com.paytm.android.chat.e.a aVar = this.J;
            if (aVar != null) {
                aVar.a();
            }
            if (this.P.size() > 0) {
                a(1);
                return;
            }
            e eVar = this.y;
            if (eVar != null && eVar.f41070i > 0) {
                a(1);
            } else if (z2) {
                a(-1);
            } else {
                a(0);
            }
        } else if (z2) {
            a(-1);
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        if (this.ac) {
            return;
        }
        if (!this.D || z2) {
            this.ac = true;
            this.W.fetchChannelList().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(new io.reactivex.rxjava3.d.h() {
                public final Object apply(Object obj) {
                    return c.this.b((List) obj);
                }
            }).a(io.reactivex.rxjava3.android.b.a.a()).a(new g() {
                public final void accept(Object obj) {
                    c.this.a((List) obj);
                }
            }, (g<? super Throwable>) new g() {
                public final void accept(Object obj) {
                    c.this.a((Throwable) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ac b(List list) throws Throwable {
        return this.W.updateLocalChannel((List<ChatGroupChannelDataModel>) list).a(y.a(list));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list) throws Throwable {
        this.ac = false;
        this.D = true;
        if (list.size() == 0) {
            b(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Throwable th) throws Throwable {
        this.ac = false;
        b(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2, String str, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2) throws Throwable {
        if (!z2) {
            Toast.makeText(com.paytm.android.chat.c.a(), String.format(com.paytm.android.chat.c.a(R.string.chat_module_toast_mute_user_success, "%s has been muted."), new Object[]{String.valueOf(str)}), 0).show();
            if (getActivity() != null) {
                ChatAnalyticsHelperKt.fireMuteChatEvent(getActivity(), true, getActivity().getLocalClassName(), chatGroupChannelDataModel, i2 + 1, this.L);
                return;
            }
            return;
        }
        Toast.makeText(com.paytm.android.chat.c.a(), String.format(com.paytm.android.chat.c.a(R.string.chat_module_toast_unmute_user_success, "%s has been unmuted."), new Object[]{String.valueOf(str)}), 0).show();
        if (getActivity() != null) {
            ChatAnalyticsHelperKt.fireMuteChatEvent(getActivity(), false, getActivity().getLocalClassName(), chatGroupChannelDataModel, i2 + 1, this.L);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z2, Throwable th) throws Throwable {
        if (!z2) {
            Toast.makeText(com.paytm.android.chat.c.a(), com.paytm.android.chat.c.a(R.string.chat_module_toast_mute_user_failed, "Mute user failed."), 0).show();
        } else {
            Toast.makeText(com.paytm.android.chat.c.a(), com.paytm.android.chat.c.a(R.string.chat_module_toast_unmute_user_failed, "Cancel mute user failed."), 0).show();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof com.paytm.android.chat.e.a) {
            this.J = (com.paytm.android.chat.e.a) getParentFragment();
        } else if (context instanceof com.paytm.android.chat.e.a) {
            this.J = (com.paytm.android.chat.e.a) context;
        }
    }

    private boolean m() {
        if (getArguments() != null) {
            return getArguments().getBoolean("is_fragment_flow", false);
        }
        return false;
    }

    public final void f() {
        this.f42045e.setVisibility(8);
    }

    public final void g() {
        this.f42045e.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        int i3 = 0;
        if (i2 == 0) {
            try {
                UserMetaData currentUserMetaData = AppUtilKt.getCurrentUserMetaData();
                if (currentUserMetaData != null && (currentUserMetaData.getUserType() == UserType.MERCHANT || currentUserMetaData.getUserType() == UserType.CHANNEL)) {
                    this.f42049i.setVisibility(0);
                } else if (!SharedPreferencesUtil.getBoolean(SharedPreferencesUtil.Key.view_friends_clicked_on_onboarding, false)) {
                    this.f42048h.setVisibility(0);
                } else if (l()) {
                    a(1);
                } else {
                    this.f42048h.setVisibility(0);
                }
                this.G.setText("Start Chat");
            } catch (Exception unused) {
            }
            this.f42042b.setVisibility(8);
            this.z.setVisibility(8);
            this.w.setVisibility(8);
            this.F.setVisibility(8);
            RelativeLayout relativeLayout = this.K;
            if (!ChatConfigUtil.Companion.getInstance().chatConfig.f41773a.f41777a) {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        } else if (i2 == 1) {
            this.f42042b.setVisibility(0);
            this.z.setVisibility(0);
            if (!m()) {
                this.w.setVisibility(8);
            }
            this.F.setVisibility(8);
            h();
            RelativeLayout relativeLayout2 = this.K;
            if (!ChatConfigUtil.Companion.getInstance().chatConfig.f41773a.f41777a) {
                i3 = 8;
            }
            relativeLayout2.setVisibility(i3);
            this.k.setVisibility(8);
        } else {
            this.f42042b.setVisibility(8);
            this.F.setVisibility(8);
            this.z.setVisibility(8);
            this.w.setVisibility(8);
            h();
            RelativeLayout relativeLayout3 = this.K;
            if (!ChatConfigUtil.Companion.getInstance().chatConfig.f41773a.f41777a) {
                i3 = 8;
            }
            relativeLayout3.setVisibility(i3);
        }
    }

    public final void b() {
        if (getActivity() != null && androidx.core.content.b.a((Context) getActivity(), "android.permission.READ_CONTACTS") == -1 && Build.VERSION.SDK_INT >= 23) {
            if (androidx.core.content.b.a((Context) getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.a((Context) getActivity(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 2019);
            } else {
                requestPermissions(new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2019);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d dVar;
        Context context = getContext();
        if (!(context == null || (dVar = ChatManager.b().f40989a) == null || !com.paytm.utility.b.r(context))) {
            dVar.a(context);
        }
        Context requireContext = requireContext();
        int size = this.P.size();
        int i2 = this.L;
        boolean z2 = this.t.size() > 0;
        int size2 = this.t.size();
        e eVar = this.y;
        ChatAnalyticsHelperKt.fireToolbarIconClickEvent(requireContext, "Profile Icon Click", size, i2, z2, size2, eVar != null && eVar.f41070i > 0);
    }

    static /* synthetic */ void b(c cVar, List list) {
        if (cVar.f42048h.getVisibility() == 0) {
            int size = list.size();
            if (size == 0) {
                cVar.k.setVisibility(8);
            } else if (size == 1) {
                cVar.k.setVisibility(0);
                cVar.m.setVisibility(8);
                cVar.n.setVisibility(8);
                cVar.o.setUI(((FriendBean) list.get(0)).getPhoto(), ((FriendBean) list.get(0)).getName());
                TextView textView = cVar.s;
                textView.setText(list.size() + " of your friend is on Paytm chat.\nConnect with them today!");
            } else if (size != 2) {
                cVar.k.setVisibility(0);
                cVar.m.setVisibility(0);
                cVar.n.setVisibility(0);
                cVar.o.setUI(((FriendBean) list.get(0)).getPhoto(), ((FriendBean) list.get(0)).getName());
                cVar.p.setUI(((FriendBean) list.get(1)).getPhoto(), ((FriendBean) list.get(1)).getName());
                TextView textView2 = cVar.q;
                textView2.setText("+" + String.valueOf(list.size() - 2));
                TextView textView3 = cVar.s;
                textView3.setText(list.size() + " of your friends are on Paytm chat.\nConnect with them today!");
            } else {
                cVar.k.setVisibility(0);
                cVar.m.setVisibility(0);
                cVar.n.setVisibility(8);
                cVar.o.setUI(((FriendBean) list.get(0)).getPhoto(), ((FriendBean) list.get(0)).getName());
                cVar.p.setUI(((FriendBean) list.get(1)).getPhoto(), ((FriendBean) list.get(1)).getName());
                TextView textView4 = cVar.s;
                textView4.setText(list.size() + " of your friends are on Paytm chat.\nConnect with them today!");
            }
            cVar.r.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    c.this.a(1);
                    ChatAnalyticsHelperKt.fireViewFriendsClickedEvent(c.this.getContext(), c.this.P.size(), c.this.L, c.this.t.size() > 0, c.this.t.size());
                    SharedPreferencesUtil.saveBoolean(SharedPreferencesUtil.Key.view_friends_clicked_on_onboarding, true);
                }
            });
            return;
        }
        cVar.a(1);
    }

    static /* synthetic */ void c(c cVar, List list) {
        ArrayList arrayList = new ArrayList();
        y.a(list).b(new io.reactivex.rxjava3.d.h(arrayList, list) {
            private final /* synthetic */ List f$1;
            private final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object apply(Object obj) {
                return c.this.a(this.f$1, this.f$2, (List) obj);
            }
        }).b(new io.reactivex.rxjava3.d.h() {
            public final Object apply(Object obj) {
                return c.this.c((List) obj);
            }
        }).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g(arrayList) {
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                this.f$0.isEmpty();
            }
        }, (g<? super Throwable>) $$Lambda$c$Rln7htuMKrIZfuoZ6ACxNLzNoYY.INSTANCE);
    }

    static /* synthetic */ void a(c cVar, ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z2, String str, int i2) {
        if (chatGroupChannelDataModel != null && com.paytm.android.chat.d.a.b.a(chatGroupChannelDataModel.getChannelUrl()) != null) {
            cVar.W.setChannelPushPreferences(chatGroupChannelDataModel, z2).a(io.reactivex.rxjava3.android.b.a.a()).a(new io.reactivex.rxjava3.d.a(z2, str, chatGroupChannelDataModel, i2) {
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ ChatGroupChannelDataModel f$3;
                private final /* synthetic */ int f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    c.this.a(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            }, new g(z2) {
                private final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    c.a(this.f$0, (Throwable) obj);
                }
            });
        }
    }
}
