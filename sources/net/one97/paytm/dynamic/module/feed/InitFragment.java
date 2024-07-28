package net.one97.paytm.dynamic.module.feed;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitcompat.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.List;
import net.one97.paytm.feed.repository.models.Category;
import net.one97.paytm.feed.ui.feed.FeedFragment;

public class InitFragment extends Fragment {
    private static String TAG = "FeedFragment";
    private String classpath = "net.one97.paytm.feed.ui.feed.FeedFragment";
    private final int fragmentId = 123;
    private boolean init = false;

    public void onAttach(Context context) {
        super.onAttach(context);
        a.a(context);
        if (getActivity() != null) {
            this.init = InboxFeedDataProvider.INSTANCE.initFeedModule(getActivity().getApplication());
            new FeedModuleManager().init(getActivity().getApplication());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setId(123);
        try {
            frameLayout.setBackgroundColor(-1);
        } catch (Exception unused) {
            frameLayout.setBackgroundColor(-1);
        }
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.init) {
            switchFragment((FrameLayout) view.findViewById(123));
        } else if (view instanceof FrameLayout) {
            TextView textView = new TextView(view.getContext());
            textView.setText("Something went wrong. We are fixing it, please check later!");
            textView.setTextColor(-16777216);
            textView.setGravity(17);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            layoutParams.leftMargin = 20;
            layoutParams.rightMargin = 20;
            ((FrameLayout) view).addView(textView, layoutParams);
        }
    }

    private void switchFragment(FrameLayout frameLayout) {
        new Bundle().putBoolean("expanded", true);
        Fragment feedFragment = getFeedFragment();
        if (feedFragment != null) {
            getChildFragmentManager().a().b(frameLayout.getId(), feedFragment, "feed").c();
        }
    }

    private Fragment getFeedFragment() {
        Fragment feedFragment = InboxFeedDataProvider.INSTANCE.getFeedFragment();
        if (getArguments() != null) {
            if (getArguments().getString("category", "").equalsIgnoreCase("following")) {
                FeedFragment.a aVar = FeedFragment.f34877i;
                String o = FeedFragment.C;
                FeedFragment.a aVar2 = FeedFragment.f34877i;
                Category category = new Category(o, FeedFragment.C, "", "");
                Bundle bundle = new Bundle();
                bundle.putBoolean("isFromUpdate", getArguments().getBoolean("isFromUpdate", false));
                FeedFragment.a aVar3 = FeedFragment.f34877i;
                bundle.putParcelable(FeedFragment.y, category);
                feedFragment.setArguments(bundle);
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("IS_FRESH_INSTALL", getArguments().getBoolean("IS_FRESH_INSTALL", false));
                bundle2.putBoolean("isFromUpdate", getArguments().getBoolean("isFromUpdate", false));
                feedFragment.setArguments(bundle2);
            }
            int i2 = getArguments().getInt(CLPConstants.ARGUMENT_KEY_POSITION, -1);
            if (i2 == 0 || i2 == 1 || i2 == -1) {
                feedFragment.setUserVisibleHint(false);
            } else {
                feedFragment.setUserVisibleHint(true);
            }
        } else {
            feedFragment.setUserVisibleHint(false);
        }
        new StringBuilder("Fragment :: ").append(feedFragment);
        return feedFragment;
    }

    public void onResume() {
        super.onResume();
        setHintForFeed(true);
    }

    public void onPause() {
        super.onPause();
    }

    private void setHintForFeed(boolean z) {
        if (isAdded()) {
            List<Fragment> d2 = getChildFragmentManager().f3424a.d();
            for (int i2 = 0; i2 < d2.size(); i2++) {
                d2.get(i2).setUserVisibleHint(z);
            }
        }
    }
}
