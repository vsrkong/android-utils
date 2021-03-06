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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <br> Description:日期数据格式化
 * <p>
 * <br> Created by shixinzhang on 17/4/21.
 * <p>
 * <br> Email: shixinzhang2016@gmail.com
 * <p>
 * <a  href="https://about.me/shixinzhang">About me</a>
 */

public final class DateUtils {
    private DateUtils() {
    }

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 返回当前时间的 Calendar，你可以使用  Calendar.get(int field) 方法获取具体的年/月/日/时/分/秒/，
     * <p>
     * 比如这样：
     * <p>
     * int hour = calendar.get(Calendar.HOUR_OF_DAY)
     * <p>
     * int minute = calendar.get(Calendar.MINUTE);
     *
     * @return
     */
    public static Calendar getCurrentCalendar() {
        Calendar instance = Calendar.getInstance(Locale.CHINA);
        instance.setTimeInMillis(System.currentTimeMillis());
        return instance;
    }

    public static String getMMdd(long time) {
        return new SimpleDateFormat("MMdd", Locale.getDefault()).format(new Date(time));
    }

    public static String getMMddhhmmss(long time) {
        return new SimpleDateFormat("MMddHHmmss", Locale.getDefault()).format(new Date(time));
    }

    public static String getYMdHms(long time) {
        return new SimpleDateFormat(DEFAULT_PATTERN, Locale.getDefault()).format(new Date(time));
    }


    /**
     * YEAR = 1
     * WEEK_OF_MONTH = 4
     * WEEK_OF_YEAR = 3
     * DAY_OF_MONTH = 5
     * HOUR_OF_DAY = 11 (24-hour)
     * MINUTE = 12
     * SECOND = 13
     *
     * @param field
     * @return
     */
    public static int getCurrentField(int field) {
        return DateUtils.getCurrentCalendar().get(field);
    }

    /**
     * 获取当前日期格式化
     *
     * @return
     */
    public static String getCurrentTime() {
        return getDateString(System.currentTimeMillis());
    }

    /**
     * 常用的格式化为：年月日时分秒
     *
     * @param timeMillis
     * @return
     */
    public static String getDateString(long timeMillis) {
        return new SimpleDateFormat(DEFAULT_PATTERN, Locale.getDefault()).format(new Date(timeMillis));
    }

    /**
     * 格式化为：月日
     *
     * @param timeMillis
     * @return
     */
    public static String getMonthDay(long timeMillis) {
        return new SimpleDateFormat("MM-dd", Locale.getDefault()).format(new Date(timeMillis));
    }

    /**
     * 格式化为：月日到小时
     *
     * @param timeMillis
     * @return
     */
    public static String getMonthToHour(long timeMillis) {
        return new SimpleDateFormat("MM-dd HH", Locale.getDefault()).format(new Date(timeMillis));
    }

    /**
     * 格式化为：月日小时分
     *
     * @param timeMillis
     * @return
     */
    public static String getMonthToMinute(long timeMillis) {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(new Date(timeMillis));
    }

    /**
     * 格式化为：月日小时分秒
     *
     * @param timeMillis
     * @return
     */
    public static String getMonthToSeconds(long timeMillis) {
        return new SimpleDateFormat("MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(timeMillis));
    }

    /**
     * 获取当天 + 小时和分钟 转换成的毫秒数
     *
     * @param hourOfDay
     * @param minute
     * @return
     */
    public static long getTimeInMillisecond(int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);

        return calendar.getTimeInMillis();
    }
}
