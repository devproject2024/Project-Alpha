package net.one97.paytm.transport.iocl_v1.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.s;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.a;
import net.one97.paytm.transport.iocl_v1.activity.AJRIOCLHomeActivity;
import net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl_v1.b.c;
import net.one97.paytm.transport.iocl_v1.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;
import net.one97.paytm.transport.iocl_v1.others.CJRSmsReceiver;

public class h extends Fragment implements View.OnClickListener, View.OnTouchListener, Response.ErrorListener, Response.Listener {

    /* renamed from: a  reason: collision with root package name */
    protected RoboTextView f14369a;

    /* renamed from: b  reason: collision with root package name */
    protected Button f14370b;

    /* renamed from: c  reason: collision with root package name */
    protected RoboTextView f14371c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f14372d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f14373e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f14374f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f14375g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public EditText f14376h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public EditText f14377i;
    /* access modifiers changed from: private */
    public EditText j;
    /* access modifiers changed from: private */
    public TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public TextView n;
    /* access modifiers changed from: private */
    public TextView o;
    /* access modifiers changed from: private */
    public TextView p;
    private GestureDetector q = null;
    private ProgressDialog r;
    /* access modifiers changed from: private */
    public IOCLCommonResponse s;
    private TextWatcher t = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f14372d.setPadding(20, 0, 0, 0);
            String trim = h.this.f14373e.getText().toString().trim();
            if (trim.length() >= 2) {
                EditText b2 = h.this.f14373e;
                StringBuilder sb = new StringBuilder();
                sb.append(trim.charAt(0));
                b2.setText(sb.toString());
                EditText d2 = h.this.f14374f;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(trim.charAt(1));
                d2.setText(sb2.toString());
            } else if (i3 == 0) {
                if (charSequence.length() == 1) {
                    h.this.f14373e.setFocusableInTouchMode(false);
                    h.this.f14373e.setLongClickable(false);
                    h.this.f14373e.setClickable(false);
                    h.this.k.setVisibility(8);
                    h.this.f14374f.requestFocus();
                    h.this.f14374f.setSelection(h.this.f14374f.getText().toString().length());
                }
            } else if (i3 != 1) {
                h.this.f14374f.requestFocus();
                h.this.f14374f.setSelection(h.this.f14374f.getText().toString().length());
            } else if (charSequence.length() == 0) {
                h.this.k.setVisibility(0);
                h.this.f14373e.requestFocus();
                h.this.f14373e.setFocusableInTouchMode(true);
            }
        }
    };
    private TextWatcher u = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String trim = h.this.f14374f.getText().toString().trim();
            if (trim.length() >= 2) {
                EditText d2 = h.this.f14374f;
                StringBuilder sb = new StringBuilder();
                sb.append(trim.charAt(0));
                d2.setText(sb.toString());
                EditText f2 = h.this.f14375g;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(trim.charAt(1));
                f2.setText(sb2.toString());
            } else if (i3 == 0) {
                if (charSequence.length() == 1) {
                    h.this.f14373e.setFocusableInTouchMode(false);
                    h.this.f14373e.setLongClickable(false);
                    h.this.l.setVisibility(8);
                    h.this.f14374f.setFocusableInTouchMode(false);
                    h.this.f14374f.setLongClickable(false);
                    h.this.f14374f.setClickable(false);
                    h.this.f14375g.requestFocus();
                    h.this.f14375g.setSelection(h.this.f14375g.getText().toString().length());
                }
            } else if (i3 != 1) {
                h.this.f14375g.requestFocus();
                h.this.f14375g.setSelection(h.this.f14375g.getText().toString().length());
            } else if (charSequence.length() == 0) {
                h.this.l.setVisibility(0);
                h.this.f14373e.setFocusableInTouchMode(true);
                h.this.f14373e.requestFocus();
                h.this.f14373e.setSelection(h.this.f14373e.getText().toString().length());
            } else {
                h.this.f14374f.setFocusableInTouchMode(true);
                h.this.f14374f.requestFocus();
                h.this.f14374f.setSelection(h.this.f14374f.getText().toString().length());
            }
        }
    };
    private TextWatcher v = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String trim = h.this.f14375g.getText().toString().trim();
            if (trim.length() >= 2) {
                EditText f2 = h.this.f14375g;
                StringBuilder sb = new StringBuilder();
                sb.append(trim.charAt(0));
                f2.setText(sb.toString());
                EditText h2 = h.this.f14376h;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(trim.charAt(1));
                h2.setText(sb2.toString());
            } else if (i3 == 0) {
                if (charSequence.length() == 1) {
                    h.this.f14373e.setFocusableInTouchMode(false);
                    h.this.f14373e.setLongClickable(false);
                    h.this.f14374f.setFocusableInTouchMode(false);
                    h.this.f14374f.setLongClickable(false);
                    h.this.m.setVisibility(8);
                    h.this.f14375g.setLongClickable(false);
                    h.this.f14375g.setClickable(false);
                    h.this.f14376h.requestFocus();
                    h.this.f14376h.setSelection(h.this.f14376h.getText().toString().length());
                    h.this.f14375g.setFocusableInTouchMode(false);
                }
            } else if (i3 != 1) {
                h.this.f14376h.requestFocus();
                h.this.f14376h.setSelection(h.this.f14376h.getText().toString().length());
            } else if (charSequence.length() == 0) {
                h.this.m.setVisibility(0);
                h.this.f14374f.setFocusableInTouchMode(true);
                h.this.f14374f.requestFocus();
                h.this.f14374f.setSelection(h.this.f14374f.getText().toString().length());
            } else {
                h.this.f14375g.setFocusableInTouchMode(true);
                h.this.f14375g.requestFocus();
                h.this.f14375g.setSelection(h.this.f14375g.getText().toString().length());
            }
        }
    };
    private TextWatcher w = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            String trim = h.this.f14376h.getText().toString().trim();
            if (trim.length() >= 2) {
                EditText h2 = h.this.f14376h;
                StringBuilder sb = new StringBuilder();
                sb.append(trim.charAt(0));
                h2.setText(sb.toString());
                EditText j = h.this.f14377i;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(trim.charAt(1));
                j.setText(sb2.toString());
            } else if (i3 == 0) {
                if (charSequence.length() == 1) {
                    h.this.f14373e.setFocusableInTouchMode(false);
                    h.this.f14373e.setLongClickable(false);
                    h.this.f14374f.setFocusableInTouchMode(false);
                    h.this.f14374f.setLongClickable(false);
                    h.this.f14375g.setFocusableInTouchMode(false);
                    h.this.f14375g.setLongClickable(false);
                    h.this.n.setVisibility(8);
                    h.this.f14376h.setLongClickable(false);
                    h.this.f14376h.setClickable(false);
                    h.this.f14377i.requestFocus();
                    h.this.f14377i.setSelection(h.this.f14377i.getText().toString().length());
                    h.this.f14376h.setFocusableInTouchMode(false);
                }
            } else if (i3 != 1) {
                h.this.f14377i.requestFocus();
                h.this.f14377i.setSelection(h.this.f14377i.getText().toString().length());
            } else if (charSequence.length() == 0) {
                h.this.n.setVisibility(0);
                h.this.f14375g.setFocusableInTouchMode(true);
                h.this.f14375g.requestFocus();
                h.this.f14375g.setSelection(h.this.f14375g.getText().toString().length());
            } else {
                h.this.f14376h.setFocusableInTouchMode(true);
                h.this.f14376h.requestFocus();
                h.this.f14376h.setSelection(h.this.f14376h.getText().toString().length());
            }
        }
    };
    private TextWatcher x = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f14377i.setError((CharSequence) null);
            String trim = h.this.f14377i.getText().toString().trim();
            if (trim.length() >= 2) {
                EditText j = h.this.f14377i;
                StringBuilder sb = new StringBuilder();
                sb.append(trim.charAt(0));
                j.setText(sb.toString());
                EditText l = h.this.j;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(trim.charAt(1));
                l.setText(sb2.toString());
            } else if (i3 == 0) {
                if (charSequence.length() == 1) {
                    h.this.f14373e.setFocusableInTouchMode(false);
                    h.this.f14373e.setLongClickable(false);
                    h.this.f14374f.setFocusableInTouchMode(false);
                    h.this.f14374f.setLongClickable(false);
                    h.this.f14375g.setLongClickable(false);
                    h.this.f14375g.setFocusableInTouchMode(false);
                    h.this.f14376h.setFocusableInTouchMode(false);
                    h.this.f14376h.setLongClickable(false);
                    h.this.o.setVisibility(8);
                    h.this.f14377i.setFocusableInTouchMode(false);
                    h.this.f14377i.setLongClickable(false);
                    h.this.f14377i.setClickable(false);
                    h.this.j.requestFocus();
                    h.this.j.setSelection(h.this.j.getText().toString().length());
                }
            } else if (i3 != 1) {
                h.this.j.requestFocus();
                h.this.j.setSelection(h.this.j.getText().toString().length());
            } else if (charSequence.length() == 0) {
                h.this.o.setVisibility(0);
                h.this.f14376h.setFocusableInTouchMode(true);
                h.this.f14376h.requestFocus();
                h.this.f14376h.setSelection(h.this.f14376h.getText().toString().length());
            } else {
                h.this.f14377i.setFocusableInTouchMode(true);
                h.this.f14377i.requestFocus();
                h.this.f14377i.setSelection(h.this.f14377i.getText().toString().length());
            }
        }
    };
    private TextWatcher y = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (h.this.j.getText().toString().length() >= 2) {
                h.this.j.requestFocus();
            } else if (i3 == 0) {
                if (charSequence.length() == 1) {
                    h.this.p.setVisibility(8);
                    h.this.j.requestFocus();
                    h.this.j.setSelection(h.this.j.getText().toString().length());
                }
            } else if (i3 == 1 && charSequence.length() == 0) {
                h.this.p.setVisibility(0);
                h.this.f14377i.requestFocus();
                h.this.f14377i.setSelection(h.this.f14377i.getText().toString().length());
                h.this.f14377i.setFocusableInTouchMode(true);
            }
        }
    };

    public void onErrorResponse(VolleyError volleyError) {
    }

    public void onResponse(Object obj) {
    }

    public static h a(Bundle bundle) {
        h hVar = new h();
        hVar.setArguments(bundle);
        return hVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.s = getArguments() == null ? null : (IOCLCommonResponse) getArguments().getSerializable("common_response");
        return layoutInflater.inflate(R.layout.fragment_iocl_validate_otp_v1, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getWindow().setSoftInputMode(16);
        this.f14369a = (RoboTextView) getView().findViewById(R.id.fragment_otp_resend);
        this.f14371c = (RoboTextView) getView().findViewById(R.id.text_heading_otp_sent);
        this.f14371c.setText(String.format(getString(R.string.validate_otp_heading), new Object[]{this.s.getUser().getMobile()}));
        this.f14372d = (LinearLayout) getView().findViewById(R.id.otp_layout);
        this.f14373e = (EditText) getView().findViewById(R.id.et_value_1);
        this.f14374f = (EditText) getView().findViewById(R.id.et_value_2);
        this.f14375g = (EditText) getView().findViewById(R.id.et_value_3);
        this.f14376h = (EditText) getView().findViewById(R.id.et_value_4);
        this.f14377i = (EditText) getView().findViewById(R.id.et_value_5);
        this.j = (EditText) getView().findViewById(R.id.et_value_6);
        this.k = (TextView) getView().findViewById(R.id.tv_value_1);
        this.l = (TextView) getView().findViewById(R.id.tv_value_2);
        this.m = (TextView) getView().findViewById(R.id.tv_value_3);
        this.n = (TextView) getView().findViewById(R.id.tv_value_4);
        this.o = (TextView) getView().findViewById(R.id.tv_value_5);
        this.p = (TextView) getView().findViewById(R.id.tv_value_6);
        this.f14373e.addTextChangedListener(this.t);
        this.f14374f.addTextChangedListener(this.u);
        this.f14375g.addTextChangedListener(this.v);
        this.f14376h.addTextChangedListener(this.w);
        this.f14377i.addTextChangedListener(this.x);
        this.j.addTextChangedListener(this.y);
        this.f14369a.setOnClickListener(this);
        this.f14369a.setOnClickListener(this);
        this.f14370b = (Button) getView().findViewById(R.id.button_submit);
        this.f14370b.setOnClickListener(this);
        this.f14374f.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (h.this.f14374f.getText().length() == 1) {
                    h.this.f14374f.setText("");
                    return false;
                }
                h.this.f14373e.setText("");
                h.this.f14373e.requestFocus();
                h.this.f14373e.setFocusableInTouchMode(true);
                return false;
            }
        });
        this.f14375g.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (h.this.f14375g.getText().length() == 1) {
                    h.this.f14375g.setText("");
                    return false;
                }
                h.this.f14374f.setText("");
                h.this.f14373e.requestFocus();
                h.this.f14374f.setFocusableInTouchMode(true);
                h.this.f14373e.setFocusableInTouchMode(true);
                h.this.f14373e.setSelection(h.this.f14373e.getText().toString().length());
                return false;
            }
        });
        this.f14376h.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (h.this.f14376h.getText().length() == 1) {
                    h.this.f14376h.setText("");
                    return false;
                }
                h.this.f14375g.setText("");
                h.this.f14374f.requestFocus();
                h.this.f14375g.setFocusableInTouchMode(true);
                h.this.f14374f.setSelection(h.this.f14374f.getText().toString().length());
                h.this.f14374f.setFocusableInTouchMode(true);
                return false;
            }
        });
        this.f14377i.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (h.this.f14377i.getText().length() == 1) {
                    h.this.f14377i.setText("");
                    return false;
                }
                h.this.f14376h.setText("");
                h.this.f14375g.requestFocus();
                h.this.f14376h.setFocusableInTouchMode(true);
                h.this.f14375g.setSelection(h.this.f14375g.getText().toString().length());
                h.this.f14375g.setFocusableInTouchMode(true);
                return false;
            }
        });
        this.j.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (h.this.j.getText().length() == 1) {
                    h.this.j.setText("");
                } else {
                    h.this.f14377i.setText("");
                    h.this.f14376h.requestFocus();
                    h.this.f14376h.setSelection(h.this.f14376h.getText().toString().length());
                    h.this.f14376h.setFocusableInTouchMode(true);
                }
                return true;
            }
        });
        AJRIOCLHomeActivity aJRIOCLHomeActivity = (AJRIOCLHomeActivity) getActivity();
        try {
            if (!aJRIOCLHomeActivity.isFinishing()) {
                if (!s.a() || s.d((Context) aJRIOCLHomeActivity)) {
                    if (aJRIOCLHomeActivity.f14392a == null) {
                        aJRIOCLHomeActivity.f14392a = new CJRSmsReceiver();
                        aJRIOCLHomeActivity.f14392a.f14457a = aJRIOCLHomeActivity;
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                        intentFilter.setPriority(1000);
                        aJRIOCLHomeActivity.registerReceiver(aJRIOCLHomeActivity.f14392a, intentFilter);
                        StringBuilder sb = new StringBuilder();
                        sb.append(aJRIOCLHomeActivity.getClass().getSimpleName());
                        sb.append(" : register");
                        b.j();
                    }
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
        a.c().sendOpenScreenEvent(getActivity(), "/iocl-xtrarewards-otp");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_submit) {
            String str = this.f14373e.getText().toString().trim() + this.f14374f.getText().toString().trim() + this.f14375g.getText().toString().trim() + this.f14376h.getText().toString().trim() + this.f14377i.getText().toString().trim() + this.j.getText().toString().trim();
            if (str == null || TextUtils.isEmpty(str) || str.length() < 6) {
                Toast.makeText(getActivity(), getString(R.string.enter_otp), 0).show();
            } else if (b.c((Context) getActivity())) {
                c.a aVar = c.f14416a;
                c.a.a(getActivity(), "iocl_xtrarewards", "otp_proceed", "/iocl-xtrarewards-otp", "");
                if (b.c((Context) getActivity())) {
                    if (b.r((Context) getActivity())) {
                        this.f14370b.setClickable(false);
                        this.f14370b.setEnabled(false);
                        this.s.getRewards().setOtp(str);
                        String string = getString(R.string.verifying_otp);
                        if (this.r == null) {
                            this.r = ProgressDialog.show(getActivity(), (CharSequence) null, string, true, false);
                        }
                        try {
                            net.one97.paytm.transport.iocl_v1.b.b.a(getContext(), (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                    h.this.a();
                                    IOCLBaseModel iOCLBaseModel = (IOCLBaseModel) iJRPaytmDataModel;
                                    if (!"FAILURE".equalsIgnoreCase(iOCLBaseModel.getStatus())) {
                                        ((IOCLBaseActivity) h.this.getActivity()).a((Object) iJRPaytmDataModel);
                                        h.this.getActivity().finish();
                                    } else if (iOCLBaseModel.getStatusMessage() != null && iOCLBaseModel.getStatusMessage().equalsIgnoreCase("AUTH FAILED")) {
                                        ((IOCLBaseActivity) h.this.getActivity()).e();
                                    } else if (iOCLBaseModel.getStatusMessage() != null) {
                                        b.a((Context) (IOCLBaseActivity) h.this.getActivity(), iOCLBaseModel.getStatusMessage(), false);
                                    }
                                    h.this.f14370b.setClickable(true);
                                    h.this.f14370b.setEnabled(true);
                                }

                                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                    h.this.a();
                                    if ((networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410) && h.this.getActivity() != null) {
                                        ((IOCLBaseActivity) h.this.getActivity()).f();
                                    }
                                    h.this.f14370b.setClickable(true);
                                    h.this.f14370b.setEnabled(true);
                                }
                            }, this.s);
                            return;
                        } catch (Exception unused) {
                        }
                    } else {
                        ((IOCLBaseActivity) getActivity()).f();
                        return;
                    }
                }
                this.f14370b.setClickable(true);
                this.f14370b.setEnabled(true);
            } else {
                getString(R.string.iocl_no_connection);
                b.a((Context) (IOCLBaseActivity) getActivity(), getString(R.string.iocl_no_internet), false);
            }
        } else if (id != R.id.fragment_otp_resend) {
        } else {
            if (!b.c((Context) getActivity())) {
                getString(R.string.iocl_no_connection);
                b.a((Context) (IOCLBaseActivity) getActivity(), getString(R.string.iocl_no_internet), false);
            } else if (b.r((Context) getActivity())) {
                this.f14373e.setText("");
                this.f14374f.setText("");
                this.f14375g.setText("");
                this.f14376h.setText("");
                this.f14377i.setText("");
                this.j.setText("");
                this.f14373e.requestFocus();
                this.f14373e.setFocusable(true);
                c.a aVar2 = c.f14416a;
                c.a.a(getActivity(), "iocl_xtrarewards", "resend_otp_clicked", "/iocl-xtrarewards-otp", "");
                if (b.c((Context) getActivity())) {
                    this.f14369a.setClickable(false);
                    this.f14369a.setEnabled(false);
                    if (this.r == null) {
                        this.r = ProgressDialog.show(getActivity(), (CharSequence) null, getString(R.string.resending_otp), true, false);
                    }
                    try {
                        net.one97.paytm.transport.iocl_v1.b.b.a(getContext(), (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                h.this.a();
                                if (iJRPaytmDataModel instanceof IOCLBaseModel) {
                                    IOCLBaseModel iOCLBaseModel = (IOCLBaseModel) iJRPaytmDataModel;
                                    iOCLBaseModel.getResponse().setRewards(h.this.s.getRewards());
                                    if (iOCLBaseModel.getStatus().equals("SUCCESS")) {
                                        IOCLCommonResponse unused = h.this.s = iOCLBaseModel.getResponse();
                                    } else {
                                        b.a((Context) (IOCLBaseActivity) h.this.getActivity(), iOCLBaseModel.getStatusMessage(), false);
                                    }
                                }
                                h.this.f14369a.setClickable(true);
                                h.this.f14369a.setEnabled(true);
                            }

                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                h.this.a();
                                if ((networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410) && h.this.getActivity() != null) {
                                    ((IOCLBaseActivity) h.this.getActivity()).f();
                                }
                                h.this.f14369a.setClickable(true);
                                h.this.f14369a.setEnabled(true);
                            }
                        }, this.s.getRewards().getPoints());
                        return;
                    } catch (Exception unused2) {
                    }
                }
                this.f14369a.setClickable(true);
                this.f14369a.setEnabled(true);
            } else {
                ((IOCLBaseActivity) getActivity()).f();
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onResume() {
        super.onResume();
        this.f14373e.post(new Runnable() {
            public final void run() {
                h.this.f14373e.requestFocus();
                ((InputMethodManager) h.this.getActivity().getSystemService("input_method")).showSoftInput(h.this.f14373e, 1);
            }
        });
    }

    public void onPause() {
        a();
        super.onPause();
    }

    public void onDetach() {
        a();
        super.onDetach();
    }

    public void onStop() {
        ((AJRIOCLHomeActivity) getActivity()).a();
        net.one97.paytm.transport.iocl_v1.b.b.a(getActivity());
        a();
        super.onStop();
    }

    public void onDestroy() {
        a();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        ProgressDialog progressDialog = this.r;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.r.dismiss();
            this.r = null;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.q.onTouchEvent(motionEvent);
        return true;
    }
}
