package co.techFlow.auto_start_flutter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.*;

/** AutoStartFlutterPlugin */
public class AutoStartFlutterPlugin
    implements FlutterPlugin, MethodCallHandler {
        private static final String TAG = "AutoStartFlutterPlugin";

    private MethodChannel channel;
    private Context context;

    @Override
    public void onAttachedToEngine(
        @NonNull FlutterPluginBinding flutterPluginBinding
    ) {
        Log.d(TAG, "Plugin being attached to engine");
        onAttach(
            flutterPluginBinding.getApplicationContext(),
            flutterPluginBinding.getBinaryMessenger()
        );
        channel = new MethodChannel(
            flutterPluginBinding.getBinaryMessenger(),
            "com.techflow.co/auto_start_flutter"
        );
        channel.setMethodCallHandler(this);
    }

    private void onAttach(
        Context applicationContext,
        BinaryMessenger messenger
    ) {
        Log.d(TAG, "onAttach called with context");
        this.context = applicationContext;
        channel = new MethodChannel(
            messenger,
            "com.techflow.co/auto_start_flutter"
        );
        channel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        Log.d(TAG, "Method called: " + call.method);
        if (call.method.equals("permit-auto-start")) {
            addAutoStartup();
        } else if (call.method.equals("isAutoStartPermission")) {
            String manufacturer = android.os.Build.MANUFACTURER;
            Log.d(TAG, "Checking auto start permission for manufacturer: " + manufacturer);
            if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("poco".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("redmi".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("letv".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("oppo".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("letv".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("honor".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("huawei".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("samsung".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("oneplus".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("nokia".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("asus".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else if ("realme".equalsIgnoreCase(manufacturer)) {
                result.success(true);
            } else {
                result.success(false);
            }
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        Log.d(TAG, "Plugin being detached from engine");
        channel.setMethodCallHandler(null);
    }

    private void addAutoStartup() {
        try {
            Log.d(TAG, "Attempting to add app to auto startup");
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            String manufacturer = android.os.Build.MANUFACTURER;
            Log.d(TAG, "Device manufacturer: " + manufacturer);
            if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.miui.securitycenter",
                        "com.miui.permcenter.autostart.AutoStartManagementActivity"
                    )
                );
            } else if ("poco".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.miui.securitycenter",
                        "com.miui.permcenter.autostart.AutoStartManagementActivity"
                    )
                );
            } else if ("redmi".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.miui.securitycenter",
                        "com.miui.permcenter.autostart.AutoStartManagementActivity"
                    )
                );
            } else if ("letv".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.letv.android.letvsafe",
                        "com.letv.android.letvsafe.AutobootManageActivity"
                    )
                );
            } else if ("oppo".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.coloros.safecenter",
                        "com.coloros.safecenter.permission.startup.StartupAppListActivity"
                    )
                );
            } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.vivo.permissionmanager",
                        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
                    )
                );
            } else if ("letv".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.letv.android.letvsafe",
                        "com.letv.android.letvsafe.AutobootManageActivity"
                    )
                );
            } else if ("honor".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.huawei.systemmanager",
                        "com.huawei.systemmanager.optimize.process.ProtectActivity"
                    )
                );
            } else if ("huawei".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.huawei.systemmanager",
                        "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"
                    )
                );
            } else if ("samsung".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.samsung.android.lool",
                        "com.samsung.android.sm.battery.ui.BatteryActivity"
                    )
                );
            } else if ("oneplus".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.oneplus.security",
                        "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity"
                    )
                );
            } else if ("nokia".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.evenwell.powersaving.g3",
                        "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity"
                    )
                );
            } else if ("asus".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.asus.mobilemanager",
                        "com.asus.mobilemanager.autostart.AutoStartActivy"
                    )
                );
            } else if ("realme".equalsIgnoreCase(manufacturer)) {
                intent.setComponent(
                    new ComponentName(
                        "com.oplus.battery",
                        "com.oplus.startupapp.view.StartupAppListActivity"
                    )
                );
            }

            List<ResolveInfo> list = context
                .getPackageManager()
                .queryIntentActivities(
                    intent,
                    PackageManager.MATCH_DEFAULT_ONLY
                );
                Log.d(TAG, "Found " + list.size() + " activities that can handle the intent");
            if (list.size() > 0) {
                context.startActivity(intent);
                Log.d(TAG, "Starting auto start permission activity");
            }
            } catch (Exception e) {
                Log.e(TAG, "Error when trying to start auto startup settings", e);
            }
    }
}
