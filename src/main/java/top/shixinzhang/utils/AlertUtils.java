/*
 * Copyright (c) 2017. shixinzhang (shixinzhang2016@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.shixinzhang.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Description:
 * <br> 提示工具类
 * <p>
 * <br> Created by shixinzhang on 17/5/9.
 * <p>
 * <br> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public class AlertUtils {
    private static Toast mToast;

    public static void toastShort(@NonNull Context context, String msg) {
        toast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void toastLong(Context context, String msg) {
        toast(context, msg, Toast.LENGTH_LONG);
    }

    /**
     * 普通的吐司提示
     *
     * @param context
     * @param msg
     * @param duration
     */
    private static void toast(@Nullable final Context context, final String msg, final int duration) {
        if (context == null) {
            throw new IllegalArgumentException("[AlertUtils] Context can't be null!");
        }
        if (TextUtils.isEmpty(msg)) {
            return;
        }
//        duration = duration == Toast.LENGTH_SHORT ? Toast.LENGTH_SHORT : Toasts.LENGTH_LONG;

        try {
            if (mToast == null) {
                mToast = Toast.makeText(context, msg, duration);
            } else {
                mToast.setText(msg);
            }
            mToast.show();
        } catch (Exception subThreadUpdateViewException) {  //子线程更新 UI
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, msg, duration).show();
                }
            });
        }
    }
}
