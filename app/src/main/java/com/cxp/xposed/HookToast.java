package com.cxp.xposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 文 件 名: HookToast
 * 创 建 人: CXP
 * 创建日期: 2018-04-13 13:31
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class HookToast implements IXposedHookLoadPackage  {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.cxp.xposed")) {

            Class clazz = lpparam.classLoader.loadClass("com.cxp.xposed.MainActivity");

            XposedHelpers.findAndHookMethod(clazz, "toastMessage", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    XposedBridge.log("哈哈哈");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    param.setResult("你已被劫持！");
                }
            });
        }
    }
}
