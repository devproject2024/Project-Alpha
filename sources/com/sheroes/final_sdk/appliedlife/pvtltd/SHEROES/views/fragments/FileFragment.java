package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitcompat.a;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.SheroesThumbor;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.TouchImageViewNew;
import com.squareup.a.b;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FileFragment extends Fragment {
    TextView footerView;
    /* access modifiers changed from: private */
    public boolean isStatusBarVisible;
    public CommonUtil.Callback mCallBack;
    TouchImageViewNew mImgDisplay;
    ProgressBar progressBar;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string = getArguments().getString("imageUrl");
        String string2 = getArguments().getString(ViewHolderFactory.TYPE_SEAL_TRUST);
        View inflate = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_sheroes_pinchable_image, viewGroup, false);
        this.mImgDisplay = (TouchImageViewNew) inflate.findViewById(R.id.sheroes_imgDisplay);
        this.progressBar = (ProgressBar) inflate.findViewById(R.id.sheroes_progress_bar);
        this.footerView = (TextView) inflate.findViewById(R.id.sheroes_footer);
        Canvas canvas = new Canvas();
        int maximumBitmapHeight = canvas.getMaximumBitmapHeight() / 8;
        try {
            b a2 = SheroesThumbor.getInstance().a(URLEncoder.encode(string, AppConstants.UTF_8)).a(canvas.getMaximumBitmapWidth() / 8, maximumBitmapHeight);
            b.a aVar = b.a.NORMAL;
            if (a2.f33757e) {
                a2.k = aVar;
                string = a2.a("no_upscale()", b.a(b.c.WEBP)).a();
                this.progressBar.setVisibility(0);
                w.a().a(string).a((ImageView) this.mImgDisplay, (e) new e() {
                    public void onSuccess() {
                        FileFragment.this.progressBar.setVisibility(8);
                    }

                    public void onError(Exception exc) {
                        FileFragment.this.progressBar.setVisibility(8);
                    }
                });
                if (CommonUtil.isNotEmpty(string2)) {
                    this.footerView.setVisibility(0);
                    this.footerView.setText(string2);
                } else {
                    this.footerView.setVisibility(8);
                }
                this.isStatusBarVisible = true;
                return inflate;
            }
            throw new IllegalStateException("Image must be resized first in order to apply 'fit-in'.");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        final Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.sheroes_toolbar);
        this.mImgDisplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View decorView = FileFragment.this.getActivity().getWindow().getDecorView();
                if (FileFragment.this.isStatusBarVisible) {
                    decorView.setSystemUiVisibility(3332);
                    toolbar.animate().translationY((float) (-toolbar.getBottom())).setInterpolator(new AccelerateInterpolator()).start();
                    FileFragment.this.footerView.animate().translationY((float) FileFragment.this.footerView.getHeight()).setInterpolator(new AccelerateInterpolator()).start();
                    if (FileFragment.this.mCallBack != null) {
                        FileFragment.this.mCallBack.callBack(FileFragment.this.isStatusBarVisible);
                    }
                } else {
                    decorView.setSystemUiVisibility(1280);
                    toolbar.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).start();
                    FileFragment.this.footerView.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).start();
                    if (FileFragment.this.mCallBack != null) {
                        FileFragment.this.mCallBack.callBack(FileFragment.this.isStatusBarVisible);
                    }
                }
                FileFragment fileFragment = FileFragment.this;
                boolean unused = fileFragment.isStatusBarVisible = !fileFragment.isStatusBarVisible;
            }
        });
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }

    public void setUserVisibleHint(boolean z) {
        TouchImageViewNew touchImageViewNew;
        super.setUserVisibleHint(z);
        if (!z && (touchImageViewNew = this.mImgDisplay) != null) {
            touchImageViewNew.resetZoom();
        }
    }

    public static FileFragment newInstance(String str, String str2) {
        FileFragment fileFragment = new FileFragment();
        Bundle bundle = new Bundle();
        bundle.putString("imageUrl", str);
        if (CommonUtil.isNotEmpty(str2)) {
            bundle.putString(ViewHolderFactory.TYPE_SEAL_TRUST, str2);
        }
        fileFragment.setArguments(bundle);
        return fileFragment;
    }
}
