package co.techFlow.auto_start_flutter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
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

    private MethodChannel channel;
    private Context context;

    @Override
    public void onAttachedToEngine(
        @NonNull FlutterPluginBinding flutterPluginBinding
    ) {
        onAttach(
            flutterPluginBinding.getApplicationContext(),
            flutterPluginBinding.getBinaryMessenger()
        );
    }

    private void onAttach(
        Context applicationContext,
        BinaryMessenger messenger
    ) {
        this.context = applicationContext;
        channel = new MethodChannel(
            messenger,
            "com.techflow.co/auto_start_flutter"
        );
        channel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        try {
            if (call.method.equals("permit-auto-start")) {
                boolean success = addAutoStartup();
                result.success(success);
            } else if (call.method.equals("isAutoStartPermission")) {
                String manufacturer = android.os.Build.MANUFACTURER;
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
        } catch (Exception e) {
            Log.e(
                "AutoStartFlutterPlugin",
                "Error in method call: " + e.getMessage(),
                e
            );
            result.error("ERROR", e.getMessage(), e.toString());
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }

    /**
     * Opens battery optimization settings for the app package
     * @return true if succeeded, false otherwise
     */
    private boolean openBatteryOptimizationSettings() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                
                List<ResolveInfo> list = context.getPackageManager()
                    .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                
                if (list.size() > 0) {
                    context.startActivity(intent);
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e("AutoStartFlutterPlugin", "Error opening battery optimization for package: " + e.getMessage(), e);
        }
        return false;
    }
    private boolean addAutoStartup() {
        try {
            if (context == null) {
                Log.e("AutoStartFlutterPlugin", "Context is null");
                return false;
            }

            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            String manufacturer = android.os.Build.MANUFACTURER;

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
                        "com.coloros.safecenter",
                        "com.coloros.safecenter.permission.startup.StartupAppListActivity"
                    )
                );
            } else {
                Log.w(
                    "AutoStartFlutterPlugin",
                    "Unsupported manufacturer: " + manufacturer
                );
                return false;
            }

            List<ResolveInfo> list = context
                .getPackageManager()
                .queryIntentActivities(
                    intent,
                    PackageManager.MATCH_DEFAULT_ONLY
                );

                if (list.size() > 0) {
                    context.startActivity(intent);
                    return true;
                } else {
                    Log.w("AutoStartFlutterPlugin", "No matching activity found for manufacturer: " + manufacturer);
                    
                    // Try with alternative approaches based on manufacturer
                    if ("realme".equalsIgnoreCase(manufacturer) || "oppo".equalsIgnoreCase(manufacturer)) {
                        try {
                            // Try alternative OPPO/Realme path
                            intent = new Intent();
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setComponent(new ComponentName(
                                "com.coloros.oppoguardelf",
                                "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"
                            ));
                            list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                            if (list.size() > 0) {
                                context.startActivity(intent);
                                return true;
                            }
                            
                            // Try general battery settings
                            intent = new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                            return true;
                        } catch (Exception e) {
                            Log.e("AutoStartFlutterPlugin", "Error with fallback intent: " + e.getMessage(), e);
                        }
                    } else {
                        try {
                            // For other manufacturers, try to open battery optimization settings
                            intent = new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                            return true;
                        } catch (Exception e) {
                            Log.e("AutoStartFlutterPlugin", "Error opening battery optimization settings: " + e.getMessage(), e);
                        }
                    }
                    return false;
                }                } else {
                        // Try to open app-specific battery optimization settings first
                        if (openBatteryOptimizationSettings()) {
                            return true;
                        }
                        
                        try {
                            // For other manufacturers, try to open general battery optimization settings
                            intent = new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                            return true;
                        } catch (Exception e) {
                            Log.e("AutoStartFlutterPlugin", "Error opening battery optimization settings: " + e.getMessage(), e);
                        }
                    }
            return false;
        }
    }
}
