package com.alipay.mobile.nebulacore.util;

import android.os.Looper;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.business.merchant_payments.utility.StringUtility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingUtil {
    private static final boolean DBG = false;
    private static final String TAG = "PingUtil";
    private static final Pattern TIME_PATTERN = Pattern.compile(".*?time=(.*?\\s)ms");

    private static void log(String str) {
    }

    public static PingResult ping(String str, int i2) {
        int i3 = i2;
        log("ping() host:".concat(String.valueOf(str)));
        if (Looper.myLooper() == null || !Looper.getMainLooper().equals(Looper.myLooper())) {
            PingResult pingResult = new PingResult();
            if (!TextUtils.isEmpty(str) && i3 > 0) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    Process exec = runtime.exec("/system/bin/ping -w " + i3 + " -c " + i3 + " " + str);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    Float[] fArr = new Float[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        fArr[i4] = Float.valueOf(0.0f);
                    }
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.contains(" bytes from ")) {
                            Matcher matcher = TIME_PATTERN.matcher(readLine);
                            int i7 = i5;
                            while (matcher.find()) {
                                try {
                                    String group = matcher.group(1);
                                    if (i7 < i3) {
                                        int i8 = i7 + 1;
                                        try {
                                            fArr[i7] = Float.valueOf(Float.parseFloat(group));
                                            i7 = i8;
                                        } catch (IllegalStateException e2) {
                                            e = e2;
                                            i7 = i8;
                                            H5Log.e(TAG, "exception detail", e);
                                        } catch (NumberFormatException e3) {
                                            e = e3;
                                            i7 = i8;
                                            H5Log.e(TAG, "exception detail", e);
                                        } catch (IndexOutOfBoundsException e4) {
                                            e = e4;
                                            i7 = i8;
                                            H5Log.e(TAG, "exception detail", e);
                                        }
                                    }
                                } catch (IllegalStateException e5) {
                                    e = e5;
                                    H5Log.e(TAG, "exception detail", e);
                                } catch (NumberFormatException e6) {
                                    e = e6;
                                    H5Log.e(TAG, "exception detail", e);
                                } catch (IndexOutOfBoundsException e7) {
                                    e = e7;
                                    H5Log.e(TAG, "exception detail", e);
                                }
                            }
                            i5 = i7;
                        }
                        stringBuffer.append(readLine + StringUtility.NEW_LINE);
                        i6++;
                    }
                    bufferedReader.close();
                    if (i6 > 0) {
                        Matcher matcher2 = Pattern.compile("^PING\\b[^(]*\\(([^)]*)\\)\\s([^.]*)\\..*?^(\\d+\\sbytes).*?icmp_seq=(\\d+).*?ttl=(\\d+).*?time=(.*?)ms.*?(\\d+)\\spackets\\stransmitted.*?(\\d+)\\sreceived.*?(\\d+%)\\spacket\\sloss.*?time\\s(\\d+ms).*?=\\s([^\\/]*)\\/([^\\/]*)\\/([^\\/]*)\\/(.*?)\\sms", 42).matcher(stringBuffer.toString());
                        int i9 = 0;
                        while (matcher2.find()) {
                            for (int i10 = 0; i10 < matcher2.groupCount() + 1; i10++) {
                                log("regex[" + i9 + "][" + i10 + "] = " + matcher2.group(i10));
                            }
                            try {
                                pingResult.ipAddr = matcher2.group(1);
                                float f2 = 0.0f;
                                for (int i11 = 0; i11 < i3; i11++) {
                                    f2 += fArr[i11].floatValue();
                                }
                                pingResult.avgConsumedTimeMs = f2 / ((float) i3);
                                pingResult.numSendPkt = Integer.valueOf(matcher2.group(7)).intValue();
                                pingResult.numReceivedPkt = Integer.valueOf(matcher2.group(8)).intValue();
                                pingResult.timePerRound = fArr;
                                pingResult.loss = matcher2.group(9);
                                i9++;
                            } catch (NumberFormatException e8) {
                                H5Log.e(TAG, "exception detail", e8);
                                return pingResult;
                            }
                        }
                    }
                    log("exitValue ".concat(String.valueOf(exec.waitFor())));
                    return pingResult;
                } catch (InterruptedException e9) {
                    log("Exception:".concat(String.valueOf(e9)));
                } catch (IOException e10) {
                    H5Log.e(TAG, "exception detail", e10);
                    log("Exception:".concat(String.valueOf(e10)));
                }
            }
            return pingResult;
        }
        throw new IllegalThreadStateException("ping shouldn't be invoked in MainThread!");
    }

    public static final class PingResult {
        public float avgConsumedTimeMs = -1.0f;
        public String ipAddr;
        public String loss;
        public int numReceivedPkt;
        public int numSendPkt;
        public Float[] timePerRound;

        public final String toString() {
            return "PingResult\n\n target IP:" + this.ipAddr + "\nconsumed:" + this.avgConsumedTimeMs + "ms\nnumber of packet(s) sent:" + this.numSendPkt + "\nnumber of package(s) received:" + this.numReceivedPkt + "\nloss:" + this.loss + StringUtility.NEW_LINE;
        }

        public final boolean success() {
            return this.avgConsumedTimeMs != -1.0f;
        }
    }
}
