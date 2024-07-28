package net.one97.paytm.dynamic.module.feed;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.ui.feed.sheroes.SheroesActivity;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.u;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.t;

public class SheroesInitFragment extends Fragment implements SheroesActivity.c {
    private FrameLayout container;
    private Context context;
    private TextView dataError;
    private final int fragmentId = 12345;
    private boolean isUserLoggedIn = false;
    private TextView loginButton;
    private ImageView loginImage;
    private TextView loginText;
    private boolean mOnReumeCalled = false;

    public void onAttach(Context context2) {
        super.onAttach(context2);
        a.a(context2);
        this.context = context2;
        InboxFeedDataProvider.INSTANCE.initSheroes(context2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.sheroes_fragment_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.loginImage = (ImageView) view.findViewById(R.id.feed_login_image);
        this.loginButton = (TextView) view.findViewById(R.id.feed_login);
        this.loginText = (TextView) view.findViewById(R.id.feed_login_text);
        this.container = (FrameLayout) view.findViewById(R.id.container);
        this.dataError = (TextView) view.findViewById(R.id.feed_error);
    }

    private void setVisibilityVisible() {
        this.loginImage.setVisibility(0);
        this.loginButton.setVisibility(0);
        this.loginText.setVisibility(0);
        this.container.setVisibility(4);
    }

    private void setVisibilityInVisible() {
        this.loginImage.setVisibility(4);
        this.loginButton.setVisibility(4);
        this.loginText.setVisibility(4);
        this.container.setVisibility(0);
        InboxFeedHelper.INSTANCE.loginSheroes(this.context, this);
    }

    private void onLoginClicked(Context context2) {
        b bVar = b.f34268c;
        b.a(context2);
    }

    private void switchFragment() {
        InboxFeedHelper.INSTANCE.loginSheroes(this.context, this);
    }

    public void onResume() {
        super.onResume();
        if (t.b(this.context) != null && !this.isUserLoggedIn) {
            setVisibilityInVisible();
            this.isUserLoggedIn = true;
        }
        if (!this.mOnReumeCalled) {
            if (t.b(this.context) == null) {
                setVisibilityVisible();
                this.loginImage.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        SheroesInitFragment.this.lambda$onResume$0$SheroesInitFragment(view);
                    }
                });
                this.loginButton.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        SheroesInitFragment.this.lambda$onResume$1$SheroesInitFragment(view);
                    }
                });
            } else {
                switchFragment();
            }
            this.mOnReumeCalled = true;
        }
    }

    public /* synthetic */ void lambda$onResume$0$SheroesInitFragment(View view) {
        onLoginClicked(view.getContext());
    }

    public /* synthetic */ void lambda$onResume$1$SheroesInitFragment(View view) {
        onLoginClicked(view.getContext());
    }

    public void getSheroesFragment(Fragment fragment) {
        if (isAdded()) {
            if (fragment != null) {
                getChildFragmentManager().a().a(this.container.getId(), fragment, "sheroes").c();
                return;
            }
            this.dataError.setVisibility(0);
            this.dataError.setText(this.context.getString(R.string.feed_server_error));
            this.dataError.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, androidx.core.content.b.a(this.context, (int) R.drawable.feed_no_data), (Drawable) null, (Drawable) null);
            this.dataError.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SheroesInitFragment.this.lambda$getSheroesFragment$2$SheroesInitFragment(view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getSheroesFragment$2$SheroesInitFragment(View view) {
        j jVar = j.f35397a;
        if (j.e(this.context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                InboxFeedHelper.INSTANCE.loginSheroes(this.context, this);
                return;
            }
            return;
        }
        Toast.makeText(this.context, R.string.feed_no_internet, 0).show();
    }
}
