package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.business.merchant_payments.utility.MPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class H5DatePlugin extends H5SimplePlugin {
    private static final int HOUR_MINUTE = 0;
    private static final String TAG = "H5DatePlugin";
    private static final int YEAR = 4;
    private static final int YEAR_MONTH = 3;
    private static final int YEAR_MONTH_DAY = 1;
    private static final int YEAR_MONTH_DAY_HOUR_MINUTE = 2;

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.DATE_PICKER);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!H5Plugin.CommonEvents.DATE_PICKER.equals(h5Event.getAction())) {
            return true;
        }
        datePicker(h5Event, h5BridgeContext);
        return true;
    }

    private void datePicker(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        int i2 = H5Utils.getInt(param, "mode");
        String string = H5Utils.getString(param, "minDate", "");
        String string2 = H5Utils.getString(param, "maxDate", "");
        String string3 = H5Utils.getString(param, "beginDate");
        boolean z = H5Utils.getBoolean(param, "isIDCard", false);
        String str = i2 == 0 ? "HH:mm:ss" : i2 == 1 ? "yyyy-MM-dd" : i2 == 2 ? "yyyy-MM-dd HH:mm:ss" : i2 == 3 ? "yyyy-MM" : i2 == 4 ? "yyyy" : null;
        Calendar parseDate = parseDate(string, str);
        Calendar parseDate2 = parseDate(string2, str);
        Calendar parseDate3 = parseDate(string3, str);
        if (parseDate3 == null) {
            parseDate3 = Calendar.getInstance();
        }
        Calendar calendar = parseDate3;
        e eVar = new e();
        if (i2 == 0) {
            showTimeDialog(h5Event, calendar, parseDate, parseDate2, h5BridgeContext, z, eVar);
        } else {
            showDateDialog(h5Event, calendar, parseDate, parseDate2, z, i2 == 2, h5BridgeContext, eVar, i2);
        }
    }

    private void showDateDialog(H5Event h5Event, Calendar calendar, Calendar calendar2, Calendar calendar3, boolean z, boolean z2, H5BridgeContext h5BridgeContext, e eVar, int i2) {
        DatePickerDialog datePickerDialog;
        Calendar calendar4 = calendar;
        final H5BridgeContext h5BridgeContext2 = h5BridgeContext;
        int i3 = i2;
        Activity activity = h5Event.getActivity();
        if (activity != null && !activity.isFinishing()) {
            final Calendar calendar5 = calendar2;
            final Calendar calendar6 = calendar3;
            final boolean z3 = z2;
            final e eVar2 = eVar;
            final H5Event h5Event2 = h5Event;
            final Calendar calendar7 = calendar;
            final H5BridgeContext h5BridgeContext3 = h5BridgeContext;
            final boolean z4 = z;
            final int i4 = i2;
            AnonymousClass1 r1 = new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    StringBuilder sb;
                    Calendar calendar;
                    if (!(calendar5 == null || (calendar = calendar6) == null)) {
                        if (calendar.get(1) <= i2) {
                            i2 = calendar6.get(1);
                        } else if (calendar5.get(1) >= i2) {
                            i2 = calendar5.get(1);
                        }
                    }
                    int i5 = i3 + 1;
                    if (i5 >= 10) {
                        sb = new StringBuilder();
                    }
                    sb.append(i5);
                    String sb2 = sb.toString();
                    String concat = i4 < 10 ? "0".concat(String.valueOf(i4)) : String.valueOf(i4);
                    if (z3) {
                        e eVar = eVar2;
                        eVar.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, (Object) i2 + "/" + sb2 + "/" + concat + " ");
                        H5DatePlugin.this.showTimeDialog(h5Event2, calendar7, calendar5, calendar6, h5BridgeContext3, z4, eVar2);
                        return;
                    }
                    int i6 = i4;
                    if (i6 == 4) {
                        eVar2.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, (Object) String.valueOf(i2));
                    } else if (i6 == 3) {
                        e eVar2 = eVar2;
                        eVar2.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, (Object) i2 + "/" + sb2);
                    } else {
                        e eVar3 = eVar2;
                        eVar3.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, (Object) i2 + "/" + sb2 + "/" + concat);
                    }
                    h5BridgeContext3.sendBridgeResult(eVar2);
                }
            };
            new DatePickerDialog(activity, r1, calendar4.get(1), calendar4.get(2), calendar4.get(5)) {
                /* access modifiers changed from: protected */
                public void onStop() {
                }
            };
            DatePickerDialog datePickerDialog2 = datePickerDialog;
            datePickerDialog2.setTitle(H5Environment.getResources().getString(R.string.h5_choosedate));
            datePickerDialog2.setCancelable(false);
            datePickerDialog2.setButton(-2, H5Environment.getResources().getString(R.string.h5_datecancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    h5BridgeContext2.sendBridgeResult("error", "11");
                    dialogInterface.dismiss();
                }
            });
            if (z) {
                final e eVar3 = eVar;
                datePickerDialog2.setButton(-3, H5Environment.getResources().getString(R.string.h5_datevalid), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        eVar3.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, (Object) H5Environment.getResources().getString(R.string.h5_longterm));
                        h5BridgeContext2.sendBridgeResult(eVar3);
                        dialogInterface.dismiss();
                    }
                });
            }
            try {
                DatePicker datePicker = datePickerDialog2.getDatePicker();
                if (calendar2 != null) {
                    datePicker.setMinDate(calendar2.getTimeInMillis());
                }
                if (calendar3 != null) {
                    datePicker.setMaxDate(calendar3.getTimeInMillis());
                }
            } catch (Throwable th) {
                H5Log.e(TAG, "set min or max date exception.", th);
            }
            try {
                DatePicker datePicker2 = datePickerDialog2.getDatePicker();
                if (i3 == 3) {
                    datePicker2.findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(8);
                } else if (i3 == 4) {
                    datePicker2.findViewById(Resources.getSystem().getIdentifier("day", "id", "android")).setVisibility(8);
                    datePicker2.findViewById(Resources.getSystem().getIdentifier(MPConstants.PaymentSummaryRange.MONTH, "id", "android")).setVisibility(8);
                }
            } catch (Exception e2) {
                H5Log.e(TAG, "set date mode exception", e2);
            }
            try {
                datePickerDialog2.show();
            } catch (Exception e3) {
                H5Log.e(TAG, "show date dialog exception.", e3);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showTimeDialog(H5Event h5Event, Calendar calendar, Calendar calendar2, Calendar calendar3, H5BridgeContext h5BridgeContext, boolean z, e eVar) {
        Calendar calendar4 = calendar;
        final H5BridgeContext h5BridgeContext2 = h5BridgeContext;
        Activity activity = h5Event.getActivity();
        if (activity != null && !activity.isFinishing()) {
            final e eVar2 = eVar;
            final H5BridgeContext h5BridgeContext3 = h5BridgeContext;
            final H5Event h5Event2 = h5Event;
            final Calendar calendar5 = calendar2;
            final Calendar calendar6 = calendar3;
            AnonymousClass5 r1 = new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                    StringBuilder sb;
                    H5BridgeContext h5BridgeContext;
                    H5BridgeContext h5BridgeContext2;
                    String string = eVar2.getString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    StringBuilder sb2 = new StringBuilder(string);
                    sb2.append(i2 + AppConstants.COLON + i3 + ":00");
                    Calendar access$100 = H5DatePlugin.this.parseDate(sb2.toString(), TextUtils.isEmpty(string) ? "HH:mm:ss" : "yyyy/MM/dd HH:mm:ss");
                    if (access$100 != null || (h5BridgeContext2 = h5BridgeContext3) == null) {
                        Calendar calendar = calendar5;
                        if (calendar != null && calendar.getTimeInMillis() > access$100.getTimeInMillis()) {
                            H5Log.d(H5DatePlugin.TAG, "set selected date as min date");
                            access$100 = calendar5;
                        }
                        Calendar calendar2 = calendar6;
                        if (calendar2 != null && calendar2.getTimeInMillis() < access$100.getTimeInMillis()) {
                            H5Log.d(H5DatePlugin.TAG, "set selected date as max date");
                            access$100 = calendar6;
                        }
                        if (access$100 != null || (h5BridgeContext = h5BridgeContext3) == null) {
                            StringBuilder sb3 = new StringBuilder();
                            if (!TextUtils.isEmpty(string)) {
                                int i4 = access$100.get(1);
                                int i5 = access$100.get(2);
                                int i6 = access$100.get(5);
                                int i7 = i5 + 1;
                                if (i7 >= 10) {
                                    sb = new StringBuilder();
                                }
                                sb.append(i7);
                                String sb4 = sb.toString();
                                String valueOf = String.valueOf(i6);
                                if (i6 < 10) {
                                    valueOf = "0".concat(valueOf);
                                }
                                sb3.append(i4 + "/" + sb4 + "/" + valueOf + " ");
                            }
                            int i8 = access$100.get(11);
                            int i9 = access$100.get(12);
                            String concat = i8 < 10 ? "0".concat(String.valueOf(i8)) : String.valueOf(i8);
                            String concat2 = i9 < 10 ? "0".concat(String.valueOf(i9)) : String.valueOf(i9);
                            sb3.append(concat + AppConstants.COLON + concat2 + ":00");
                            eVar2.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, (Object) sb3.toString());
                            H5Log.e(H5DatePlugin.TAG, sb2.toString());
                            h5BridgeContext3.sendBridgeResult(eVar2);
                            return;
                        }
                        h5BridgeContext.sendError(h5Event2, H5Event.Error.INVALID_PARAM);
                        return;
                    }
                    h5BridgeContext2.sendError(h5Event2, H5Event.Error.INVALID_PARAM);
                }
            };
            AnonymousClass6 r12 = new TimePickerDialog(activity, r1, calendar.get(11), calendar.get(12), true) {
                /* access modifiers changed from: protected */
                public void onStop() {
                }
            };
            r12.setTitle(H5Environment.getResources().getString(R.string.h5_choosetime));
            r12.setCancelable(false);
            r12.setButton(-2, H5Environment.getResources().getString(R.string.h5_datecancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    h5BridgeContext2.sendBridgeResult("error", "11");
                    dialogInterface.dismiss();
                }
            });
            if (z) {
                final e eVar3 = eVar;
                r12.setButton(-3, H5Environment.getResources().getString(R.string.h5_datevalid), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        eVar3.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, (Object) H5Environment.getResources().getString(R.string.h5_longterm));
                        h5BridgeContext2.sendBridgeResult(eVar3);
                        dialogInterface.dismiss();
                    }
                });
            }
            try {
                r12.show();
            } catch (Exception e2) {
                H5Log.e(TAG, "show time dialog exception.", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public Calendar parseDate(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            Calendar instance = Calendar.getInstance();
            try {
                instance.setTime(simpleDateFormat.parse(str));
                return instance;
            } catch (ParseException e2) {
                H5Log.e(TAG, "exception detail", e2);
            }
        }
        return null;
    }
}
