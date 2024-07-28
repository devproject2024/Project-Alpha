package net.one97.paytm.landingpage.fragment;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import net.one97.paytm.deeplink.m;
import net.one97.paytm.dynamicModule.CommonDynamicFragment;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.i.h;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.c.f;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.json.JSONArray;

public class FJRUpdatesFragment extends h implements f {
    public static boolean isViaDeeplink = false;
    /* access modifiers changed from: private */
    public AppBarLayout appbar;
    /* access modifiers changed from: private */
    public Context context;
    private int currentTabPosition;
    private InboxFragmentAdapter inboxFragmentAdapter;
    private boolean isMovedToInboxForFirstTime = false;
    /* access modifiers changed from: private */
    public TabLayout tabLayout;
    /* access modifiers changed from: private */
    public ArrayList<String> tabs;
    private ViewPager viewPager;

    public void onAttach(Context context2) {
        super.onAttach(context2);
        this.context = context2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_inbox, (ViewGroup) null);
        this.viewPager = (ViewPager) inflate.findViewById(R.id.viewpager);
        this.tabLayout = (TabLayout) inflate.findViewById(R.id.tabs);
        this.appbar = (AppBarLayout) inflate.findViewById(R.id.appbar);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        this.appbar.setExpanded(true);
        m mVar = m.f50358c;
        m.a((f) this);
    }

    public void onPause() {
        super.onPause();
        m mVar = m.f50358c;
        m.c();
    }

    private void initFeed(Application application) {
        try {
            Class<?> cls = Class.forName("net.one97.paytm.dynamic.module.feed.FeedModuleManager");
            cls.getDeclaredMethod("init", new Class[]{Application.class}).invoke(cls.newInstance(), new Object[]{application});
        } catch (InstantiationException e2) {
            e2.getMessage();
            q.b(e2.getMessage());
        } catch (IllegalAccessException e3) {
            e3.getMessage();
            q.b(e3.getMessage());
        } catch (ClassNotFoundException e4) {
            e4.getMessage();
            q.b(e4.getMessage());
        } catch (NoSuchMethodException e5) {
            e5.getMessage();
            q.b(e5.getMessage());
        } catch (InvocationTargetException e6) {
            e6.getMessage();
            q.b(e6.getMessage());
        }
    }

    public void scrollToTop() {
        if (this.viewPager.getCurrentItem() == getFeedFragmentPosition()) {
            m mVar = m.f50358c;
            m.a(this.context, 2);
        }
    }

    private void initViewPager() {
        if (isAdded()) {
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 == null || viewPager2.getAdapter() == null) {
                this.inboxFragmentAdapter = new InboxFragmentAdapter(getChildFragmentManager());
                this.viewPager.setAdapter(this.inboxFragmentAdapter);
                this.tabLayout.setupWithViewPager(this.viewPager);
                for (int i2 = 0; i2 < this.tabLayout.getTabCount(); i2++) {
                    this.tabLayout.a(i2).a(getTabView(i2));
                }
                this.tabLayout.a((TabLayout.b) new TabLayout.c() {
                    public final void onTabSelected(TabLayout.f fVar) {
                        TextView textView = (TextView) FJRUpdatesFragment.this.tabLayout.a(fVar.f36765e).f36766f.findViewById(R.id.updates_title_text);
                        textView.setTypeface(Typeface.create("sans-serif", 1));
                        FJRUpdatesFragment.this.appbar.setExpanded(true);
                        if (fVar.f36765e == FJRUpdatesFragment.this.getFeedFragmentPosition()) {
                            m mVar = m.f50358c;
                            m.a(FJRUpdatesFragment.this.context, 0);
                        }
                        m mVar2 = m.f50358c;
                        Context access$300 = FJRUpdatesFragment.this.context;
                        m.a(access$300, "inbox_top_nav_" + textView.getText().toString());
                    }

                    public final void onTabUnselected(TabLayout.f fVar) {
                        for (int i2 = 0; i2 < FJRUpdatesFragment.this.tabs.size(); i2++) {
                            TextView textView = (TextView) FJRUpdatesFragment.this.tabLayout.a(i2).f36766f.findViewById(R.id.updates_title_text);
                            textView.setTextColor(b.c(FJRUpdatesFragment.this.context, R.color.inbox_tab_unselected));
                            textView.setTypeface(Typeface.create("sans-serif", 0));
                        }
                        if (fVar.f36765e == FJRUpdatesFragment.this.getFeedFragmentPosition()) {
                            m mVar = m.f50358c;
                            m.a(FJRUpdatesFragment.this.context, 1);
                        }
                    }

                    public final void onTabReselected(TabLayout.f fVar) {
                        if (fVar.f36765e == FJRUpdatesFragment.this.getFeedFragmentPosition()) {
                            m mVar = m.f50358c;
                            m.a(FJRUpdatesFragment.this.context, 2);
                        }
                    }
                });
            }
        }
    }

    private View getTabView(int i2) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.inbox_tab_title_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.updates_title_text);
        textView.setText(this.tabs.get(i2));
        if (i2 == 0) {
            textView.setTypeface(Typeface.create("sans-serif", 1));
        } else {
            textView.setTextColor(b.c(this.context, R.color.inbox_tab_unselected));
        }
        return inflate;
    }

    public void setCurrentTabPosition(int i2) {
        this.currentTabPosition = i2;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getActivity().getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(Color.parseColor("#eef5f6"));
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
            }
        } catch (Throwable th) {
            q.b(th.getMessage());
        }
    }

    public void onTabSwitched(int i2, int i3) {
        if (this.inboxFragmentAdapter != null) {
            m mVar = m.f50358c;
            m.a(this.context, i3 == i2, getChildFragmentManager());
        } else {
            isViaDeeplink = true;
        }
        try {
            if (!this.isMovedToInboxForFirstTime) {
                this.isMovedToInboxForFirstTime = true;
                m mVar2 = m.f50358c;
                Context context2 = this.context;
                m.a(context2, "inbox_top_nav_" + this.tabs.get(0));
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void expandAppBar() {
        this.appbar.setExpanded(true);
    }

    public void collapseAppBar() {
        this.appbar.setExpanded(false);
    }

    public class InboxFragmentAdapter extends o {
        public InboxFragmentAdapter(j jVar) {
            super(jVar, 1);
        }

        public Fragment getItem(int i2) {
            if (i2 == FJRUpdatesFragment.this.getFeedFragmentPosition()) {
                Bundle bundle = new Bundle();
                bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
                return CommonDynamicFragment.newInstance(bundle, "feed", "net.one97.paytm.dynamic.module.feed.InitFragment", "");
            } else if (i2 == FJRUpdatesFragment.this.getFollowingFragmentPosition()) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("category", "following");
                bundle2.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
                if (!DynamicModuleManager.getInstance().isInstalled("feed")) {
                    return CommonDynamicFragment.newInstance(bundle2, "feed", "net.one97.paytm.dynamic.module.feed.InitFragment", "");
                }
                Fragment access$600 = FJRUpdatesFragment.this.getIntallDDFragment("net.one97.paytm.dynamic.module.feed.InitFragment");
                access$600.setArguments(bundle2);
                return access$600;
            } else if (i2 == FJRUpdatesFragment.this.getGameFragmentPosition()) {
                Bundle bundle3 = new Bundle();
                bundle3.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
                if (!DynamicModuleManager.getInstance().isInstalled("feed")) {
                    return CommonDynamicFragment.newInstance(bundle3, "feed", "net.one97.paytm.dynamic.module.games.GamesInitFragment", "");
                }
                Fragment access$6002 = FJRUpdatesFragment.this.getIntallDDFragment("net.one97.paytm.dynamic.module.games.GamesInitFragment");
                if (access$6002 != null) {
                    access$6002.setArguments(bundle3);
                }
                return access$6002;
            } else if (i2 == FJRUpdatesFragment.this.getMerchantFragmentPosition()) {
                if (!DynamicModuleManager.getInstance().isInstalled("channel")) {
                    return CommonDynamicFragment.newInstance(new Bundle(), "channel", "net.one97.paytm.dynamic.module.channel.InitFragment", "");
                }
                return FJRUpdatesFragment.this.getIntallDDFragment("net.one97.paytm.dynamic.module.channel.InitFragment");
            } else if (i2 == FJRUpdatesFragment.this.getMerchantNearbyFragmentPosition()) {
                if (!DynamicModuleManager.getInstance().isInstalled("channel")) {
                    return CommonDynamicFragment.newInstance(new Bundle(), "channel", "net.one97.paytm.dynamic.module.channel.InitFragment", "");
                }
                return FJRUpdatesFragment.this.getIntallDDFragment("net.one97.paytm.dynamic.module.channel.InitFragment");
            } else if (i2 != FJRUpdatesFragment.this.getSheroesFragmentPosition()) {
                return null;
            } else {
                if (!DynamicModuleManager.getInstance().isInstalled("feed")) {
                    return CommonDynamicFragment.newInstance(new Bundle(), "feed", "net.one97.paytm.dynamic.module.feed.SheroesInitFragment", "");
                }
                return FJRUpdatesFragment.this.getIntallDDFragment("net.one97.paytm.dynamic.module.feed.SheroesInitFragment");
            }
        }

        public int getCount() {
            return FJRUpdatesFragment.this.getTabCount();
        }

        public CharSequence getPageTitle(int i2) {
            return (CharSequence) FJRUpdatesFragment.this.tabs.get(i2);
        }
    }

    /* access modifiers changed from: private */
    public int getFeedFragmentPosition() {
        return this.tabs.indexOf("For You");
    }

    /* access modifiers changed from: private */
    public int getSheroesFragmentPosition() {
        return this.tabs.indexOf("Sheroes");
    }

    /* access modifiers changed from: private */
    public int getGameFragmentPosition() {
        return this.tabs.indexOf("Games");
    }

    /* access modifiers changed from: private */
    public int getMerchantFragmentPosition() {
        return this.tabs.indexOf("Store");
    }

    /* access modifiers changed from: private */
    public int getMerchantNearbyFragmentPosition() {
        return this.tabs.indexOf("Nearby Stores");
    }

    /* access modifiers changed from: private */
    public int getFollowingFragmentPosition() {
        return this.tabs.indexOf("Following");
    }

    /* access modifiers changed from: private */
    public int getTabCount() {
        ArrayList<String> arrayList = this.tabs;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getGameFragmentIndex() {
        return getGameFragmentPosition();
    }

    private ArrayList<String> getTabTitles() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            c.a();
            JSONArray jSONArray = new JSONArray(c.a("InboxTabsV12", (String) null));
            new StringBuilder("Gender is +").append(com.paytm.utility.b.ae(this.context));
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString = jSONArray.optString(i2);
                if (optString.equalsIgnoreCase("sheroes")) {
                    c.a();
                    if (!c.a("feed_sheroes_login", false) && !"f".equalsIgnoreCase(com.paytm.utility.b.ae(this.context))) {
                    }
                }
                arrayList.add(optString);
            }
            if (arrayList.size() > 2) {
                this.tabLayout.setTabMode(0);
            } else {
                this.tabLayout.setTabMode(1);
            }
            if (arrayList.size() != 0) {
                return arrayList;
            }
            throw new RuntimeException("get default tabs");
        } catch (Exception e2) {
            new StringBuilder("Exception is +").append(e2.getMessage());
            q.b(e2.getMessage());
            return new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.updatestab_withNews)));
        }
    }

    public Fragment getCurrentFragmentItem() {
        InboxFragmentAdapter inboxFragmentAdapter2;
        if (this.viewPager == null || (inboxFragmentAdapter2 = this.inboxFragmentAdapter) == null || inboxFragmentAdapter2.getCount() <= 0) {
            return null;
        }
        Fragment fragment = (Fragment) this.inboxFragmentAdapter.instantiateItem(this.viewPager, getGameFragmentPosition());
        if (net.one97.paytm.deeplink.o.a(fragment)) {
            return fragment;
        }
        return null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setUpViewPager();
        if (getActivity() != null && (getActivity() instanceof AJRMainActivity)) {
            ((AJRMainActivity) getActivity()).c();
        }
        setUpObserver();
    }

    private void setUpObserver() {
        m.f50357b.addObserver(new Observer() {
            public final void update(Observable observable, Object obj) {
                FJRUpdatesFragment.this.lambda$setUpObserver$0$FJRUpdatesFragment(observable, obj);
            }
        });
    }

    public /* synthetic */ void lambda$setUpObserver$0$FJRUpdatesFragment(Observable observable, Object obj) {
        try {
            String[] split = obj.toString().split("/");
            if (!(this.context == null || getActivity() == null || !(getActivity() instanceof AJRMainActivity))) {
                ((AJRMainActivity) getActivity()).b();
            }
            if (this.context != null && getActivity() != null && split.length > 2 && split[3].startsWith("feed")) {
                this.tabLayout.a(getFeedFragmentPosition()).d();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void setUpViewPager() {
        this.tabs = getTabTitles();
        initViewPager();
    }

    public void onDetach() {
        super.onDetach();
        m.f50357b.deleteObservers();
    }

    /* access modifiers changed from: private */
    public Fragment getIntallDDFragment(String str) {
        Fragment fragment;
        InstantiationException e2;
        IllegalAccessException e3;
        ClassNotFoundException e4;
        try {
            fragment = (Fragment) Class.forName(str).newInstance();
            try {
                if (getArguments() != null && getArguments().getBoolean("IS_FRESH_INSTALL", false)) {
                    fragment.setUserVisibleHint(true);
                }
            } catch (InstantiationException e5) {
                e2 = e5;
                q.b(e2.getMessage());
                return fragment;
            } catch (IllegalAccessException e6) {
                e3 = e6;
                q.b(e3.getMessage());
                return fragment;
            } catch (ClassNotFoundException e7) {
                e4 = e7;
                q.b(e4.getMessage());
                return fragment;
            }
        } catch (InstantiationException e8) {
            e2 = e8;
            fragment = null;
            q.b(e2.getMessage());
            return fragment;
        } catch (IllegalAccessException e9) {
            e3 = e9;
            fragment = null;
            q.b(e3.getMessage());
            return fragment;
        } catch (ClassNotFoundException e10) {
            e4 = e10;
            fragment = null;
            q.b(e4.getMessage());
            return fragment;
        }
        return fragment;
    }
}
