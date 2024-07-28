package net.one97.paytm.phoenix.util;

import android.os.Build;
import com.paytm.contactsSdk.database.Tables;
import kotlin.g.b.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f59640a = new f();

    public static final String a(String... strArr) {
        k.c(strArr, "values");
        return "parameters are expected but not given or invalid.";
    }

    private f() {
    }

    public static final String a(String str) {
        k.c(str, "permissionToCheck");
        switch (str.hashCode()) {
            case -1928411001:
                if (str.equals("android.permission.READ_CALENDAR")) {
                    return "calendar";
                }
                return null;
            case -1888586689:
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    return "location";
                }
                return null;
            case -1238066820:
                if (str.equals("android.permission.BODY_SENSORS")) {
                    return "body_sensors";
                }
                return null;
            case -1164582768:
                if (str.equals("android.permission.READ_PHONE_NUMBERS")) {
                    return "read_phone_numbers";
                }
                return null;
            case -406040016:
                if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    return "storage";
                }
                return null;
            case -63024214:
                if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    return "location";
                }
                return null;
            case -5573545:
                if (str.equals("android.permission.READ_PHONE_STATE")) {
                    return "read_phone_state";
                }
                return null;
            case 214526995:
                if (str.equals("android.permission.WRITE_CONTACTS")) {
                    return Tables.CONTACTS;
                }
                return null;
            case 463403621:
                if (str.equals("android.permission.CAMERA")) {
                    return "camera";
                }
                return null;
            case 603653886:
                if (str.equals("android.permission.WRITE_CALENDAR")) {
                    return "calendar";
                }
                return null;
            case 1271781903:
                if (str.equals("android.permission.GET_ACCOUNTS")) {
                    return "get_accounts";
                }
                return null;
            case 1365911975:
                if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    return "storage";
                }
                return null;
            case 1831139720:
                if (str.equals("android.permission.RECORD_AUDIO")) {
                    return "record_audio";
                }
                return null;
            case 1977429404:
                if (str.equals("android.permission.READ_CONTACTS")) {
                    return Tables.CONTACTS;
                }
                return null;
            default:
                return null;
        }
    }

    public static final String[] b(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2125976984:
                    if (str.equals("record_audio")) {
                        return new String[]{"android.permission.RECORD_AUDIO"};
                    }
                    break;
                case -1884274053:
                    if (str.equals("storage")) {
                        return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
                    }
                    break;
                case -1441860353:
                    if (str.equals("access_fine_location")) {
                        return new String[]{"android.permission.ACCESS_FINE_LOCATION"};
                    }
                    break;
                case -1367751899:
                    if (str.equals("camera")) {
                        return new String[]{"android.permission.CAMERA"};
                    }
                    break;
                case -730465904:
                    if (str.equals("read_external_storage")) {
                        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
                    }
                    break;
                case -567451565:
                    if (str.equals(Tables.CONTACTS)) {
                        return new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
                    }
                    break;
                case -178324674:
                    if (str.equals("calendar")) {
                        return new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
                    }
                    break;
                case -94789412:
                    if (str.equals("read_contacts")) {
                        return new String[]{"android.permission.READ_CONTACTS"};
                    }
                    break;
                case 56505959:
                    if (str.equals("write_external_storage")) {
                        return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
                    }
                    break;
                case 80355434:
                    if (str.equals("access_coarse_location")) {
                        return new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
                    }
                    break;
                case 80560732:
                    if (!str.equals("body_sensors") || Build.VERSION.SDK_INT < 20) {
                        return null;
                    }
                    return new String[]{"android.permission.BODY_SENSORS"};
                case 234765999:
                    if (str.equals("get_accounts")) {
                        return new String[]{"android.permission.GET_ACCOUNTS"};
                    }
                    break;
                case 294337479:
                    if (str.equals("read_calendar")) {
                        return new String[]{"android.permission.READ_CALENDAR"};
                    }
                    break;
                case 410756275:
                    if (str.equals("write_contacts")) {
                        return new String[]{"android.permission.WRITE_CONTACTS"};
                    }
                    break;
                case 799883166:
                    if (str.equals("write_calendar")) {
                        return new String[]{"android.permission.WRITE_CALENDAR"};
                    }
                    break;
                case 1370921258:
                    if (str.equals("microphone")) {
                        return new String[]{"android.permission.RECORD_AUDIO"};
                    }
                    break;
                case 1405866384:
                    if (!str.equals("read_phone_numbers") || Build.VERSION.SDK_INT < 26) {
                        return null;
                    }
                    return new String[]{"android.permission.READ_PHONE_NUMBERS"};
                case 1467490647:
                    if (str.equals("read_phone_state")) {
                        return new String[]{"android.permission.READ_PHONE_STATE"};
                    }
                    break;
                case 1901043637:
                    if (str.equals("location")) {
                        return new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
                    }
                    break;
            }
        }
        return null;
    }
}
