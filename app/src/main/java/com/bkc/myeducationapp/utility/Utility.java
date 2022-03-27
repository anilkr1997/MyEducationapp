package com.bkc.myeducationapp.utility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;



import com.bkc.myeducationapp.R;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.Context.WINDOW_SERVICE;

public class Utility {

public static final String GETALLCOURCES="getCourse";
public static final String IMG_BASE_URL = "https://online.omitec.org/elearn-api2/";
public static final String PDF_BASE_URL = "https://online.omitec.org/Course";

    public static final String VIEW_DATE_FORMAT = "dd-MM-yyyy";
    public static final String POST_DATE_TIME_FORMAT = "dd MMMM,yyyy HH:mm aaa";
    public static final String SERVER_DATE_FORMAT = "yyyy-MM-dd";
    public static final String FILE_DATE_FORMAT = "yyyy_MM_dd_hh_mm_ss";
    public static final String DAY_FORMAT = "EEE";
    public static final String NEWS_FORMAT = "dd MMMM, yyyy";
    public static final String ADD_SHOP_FORMAT = "ddMMyyyy_HHmmss";

    public static final String NEW_DATE_FORMAT = "EEEE,dd MMMM";

    public static final String WEEKDAY_FORMAT = "EEEE";

    public static final String TIME_FORMAT = "HH:mm:ss";

    public static String formatDate(String date, String initDateFormat, String endDateFormat) {
        SimpleDateFormat formatter;
        Date initDate;
        try {

            initDate = new SimpleDateFormat(initDateFormat).parse(date);
            formatter = new SimpleDateFormat(endDateFormat);
        } catch (ParseException e) {
            return date;
        }
        return formatter.format(initDate);
    }

    public static String getDayFromDate(String date) {
        SimpleDateFormat formatter;
        Date initDate;
        try {

            initDate = new SimpleDateFormat(SERVER_DATE_FORMAT).parse(date);
            formatter = new SimpleDateFormat(DAY_FORMAT);
        } catch (ParseException e) {
            return date;
        }
        return formatter.format(initDate);
    }

    public static Date getDateObject(String date) {
        try {
            return new SimpleDateFormat(SERVER_DATE_FORMAT).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String valideteupto() {
        String uptovalide = "";
        try {
            Date today = new Date();
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String curent_dateToStr = format.format(today);
            Calendar cal = Calendar.getInstance();

            today = format.parse(curent_dateToStr);
            cal.setTime(today);
            cal.add(Calendar.DATE, 2);
            uptovalide = format.format(cal.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return uptovalide;
    }

    public static String todaydate() {
        String curent_dateToStr = "";
        Date today = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        curent_dateToStr = format.format(today);
        return curent_dateToStr;
    }
    public static int getDisplayWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getDisplayHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    //calculate height for the banner
    public static int calculateHeight(int value, int percentage) {
        return (int) ((percentage / 100.0f) * value);
    }




    public static final int BLACK_COLOR = 0;
    public static final int WHITE_COLOR = 1;
    public static final int ACCENT_COLOR = 2;



    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    public static final int BOTTOM = 3;

    public static void setDrawbleOnTextViewWithBound(Context context, int imageResource, TextView textView, int direction, int drawablePadding) {
        Drawable drawable = ContextCompat.getDrawable(context, imageResource);
        int pixelDrawableSize = (int) Math.round(textView.getLineHeight()); // Or the percentage you like (0.8, 0.9, etc.)
        drawable.setBounds(0, 0, pixelDrawableSize, pixelDrawableSize); // setBounds(int left, int top, int right, int bottom), in this case, drawable is a square image
        textView.setCompoundDrawablePadding(drawablePadding);
        switch (direction) {
            case LEFT:
                textView.setCompoundDrawables(
                        drawable, //left
                        null, //top
                        null, //right
                        null //bottom
                );


                break;
            case RIGHT:
                textView.setCompoundDrawables(
                        null, //left
                        null, //top
                        drawable, //right
                        null //bottom
                );
                break;
            case TOP:
                textView.setCompoundDrawables(
                        null, //left
                        drawable, //top
                        null, //right
                        null //bottom
                );
                break;
            case BOTTOM:
                textView.setCompoundDrawables(
                        null, //left
                        null, //top
                        null, //right
                        drawable //bottom
                );
                break;
        }
    }

    public static String getTwoDecimalDigits(double v) {
//        DecimalFormat formater = new DecimalFormat("#.##");
        DecimalFormat formater = new DecimalFormat("#.#");
        return formater.format(v);
    }

    public static SpannableString getTempuratureString(String stringFormat, double value) {
        String stringValue = getTwoDecimalDigits(value);
        SpannableString styledString = new SpannableString(String.format(stringFormat, stringValue));
        if (value > 45 || value < 5) {
            // change text color
            styledString.setSpan(new ForegroundColorSpan(Color.RED), styledString.length() - stringValue.length() - 2, styledString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return styledString;
    }

    public static SpannableString getWindString(String stringFormat, double value) {
        String stringValue = getTwoDecimalDigits(value);
        SpannableString styledString = new SpannableString(String.format(stringFormat, stringValue));
        if (value >= 30.00) {
            // change text color
            styledString.setSpan(new ForegroundColorSpan(Color.RED), styledString.length() - stringValue.length() - 4, styledString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return styledString;
    }

    public static String getExtension(String filePath) {
        int strLength = filePath.lastIndexOf(".");
        if (strLength > 0)
            return filePath.substring(strLength + 1).toLowerCase();
        return null;
    }

    public static String getCurrentDate(String format) {
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(c);
    }


    /**
     * Create a File for saving an image or video
     */
    public static File getOutputMediaFile(Context context) {

        switch (Environment.getExternalStorageState()) {
            case Environment.MEDIA_MOUNTED:
                // To be safe, you should check that the SDCard is mounted
                // using Environment.getExternalStorageState() before doing this.
                File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                        + "/Android/data/"
                        + context.getPackageName()
                        + "/Files");

                // This location works best if you want the created images to be shared
                // between applications and persist after your app has been uninstalled.

                // Create the storage directory if it does not exist
                if (!mediaStorageDir.exists()) {
                    if (!mediaStorageDir.mkdirs()) {
                        return null;
                    }
                }
                // Create a media file name
                String timeStamp = new SimpleDateFormat(ADD_SHOP_FORMAT).format(new Date());
                File mediaFile;
                String mImageName = "img_" + timeStamp + ".jpg";
                mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
                return mediaFile;

            default:
              //  ((BaseActivity) context).showMessage(context.getString(R.string.there_some_problem_with_storage_device));
                return null;
        }

    }

    /**
     * decode file.
     *
     * @param f
     * @return
     */
    public static String decodeFile(File f) {

        String path = f.getAbsolutePath();
//        decode large file here.
        String decodeImgPath = null;
        Bitmap scaledBitmap = null;

        int DESIRED_WIDTH = 1200;
        int DESIRED_HEIGHT = 1600;

        try {
            // Part 1: Decode image
            Bitmap unscaledBitmap = ScalingUtilities.decodeFile(path, DESIRED_WIDTH, DESIRED_HEIGHT, ScalingUtilities.ScalingLogic.FIT);

            if (!(unscaledBitmap.getWidth() <= DESIRED_WIDTH && unscaledBitmap.getHeight() <= DESIRED_HEIGHT)) {
                // Part 2: Scale image
                scaledBitmap = ScalingUtilities.createScaledBitmap(unscaledBitmap, DESIRED_WIDTH, DESIRED_HEIGHT, ScalingUtilities.ScalingLogic.FIT);
            } else {
                unscaledBitmap.recycle();
                return path;
            }

            // Store to tmp file

            scaledBitmap = ExifUtil.rotateBitmap(path, scaledBitmap);

            decodeImgPath = f.getAbsolutePath();

            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(f);
                scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
                fos.flush();
                fos.close();

            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (Exception e) {

                e.printStackTrace();
            }

            scaledBitmap.recycle();

        } catch (Exception e) {

            e.printStackTrace();
        }


        if (decodeImgPath == null) {
            return path;
        } else {
            return decodeImgPath;
        }
    }

    public static boolean isServiceRunning(String serviceClassName, Context context) {
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals(serviceClassName)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Return date in specified format.
     *
     * @param milliSeconds Date in milliseconds
     * @param dateFormat   Date format
     * @return String representing date in specified format
     */
    public static String getDate(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public static float dpToPx(Resources r, int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }



    public static String addOneDay(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(SERVER_DATE_FORMAT);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
        c.add(Calendar.DATE, 1);  // number of days to add
        return sdf.format(c.getTime());
    }

    public static Bitmap addWaterMark(Resources res, Bitmap source, int opacity) {
        int w, h;
        Canvas c;
        Paint paint;
        Bitmap bmp, watermark;
        Matrix matrix;
        float scale;
        RectF r;
        w = source.getWidth();
        h = source.getHeight();
        // Create the new bitmap
        bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);
        // Copy the original bitmap into the new one
        c = new Canvas(bmp);
        c.drawBitmap(source, 0, 0, paint);
        // Load the watermark
        watermark = BitmapFactory.decodeResource(res, R.drawable.ic_accent_heavy_rain);
        // Scale the watermark to be approximately 40% of the source image height
        scale = (float) (((float) h * 0.40) / (float) watermark.getHeight());
        // Create the matrix
        matrix = new Matrix();
        matrix.postScale(scale, scale);
        // Determine the post-scaled size of the watermark
        r = new RectF(0, 0, watermark.getWidth(), watermark.getHeight());
        matrix.mapRect(r);
        // Move the watermark to the bottom right corner
        matrix.postTranslate(w - r.width(), r.height());
        //Opacity of the watermark
        paint.setAlpha(30);
        // Draw the watermark
        c.drawBitmap(watermark, matrix, paint);
        // Free up the bitmap memory
        watermark.recycle();
        return bmp;
    }

    public static Bitmap addWaterMarkPattern(Resources res, Bitmap source, int opacity) {
        int w, h;
        Canvas c;
        Paint paint;
        Bitmap bmp, watermark;
        Matrix matrix;
        float scale;
        RectF r;
        w = source.getWidth();
        h = source.getHeight();
        // Create the new bitmap
        bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);
        // Copy the original bitmap into the new one
        c = new Canvas(bmp);
        c.drawBitmap(source, 0, 0, paint);
        // Load the watermark
        watermark = BitmapFactory.decodeResource(res, R.drawable.ic_accent_heavy_rain);

        float left = 0, top = 0;
        float bgTileWidth = watermark.getWidth();
        float bgTileHeight = watermark.getHeight();

        paint.setAlpha(opacity);
        while (left < w) {
            while (top < h) {
                c.drawBitmap(watermark, left, top, paint);
                top += bgTileHeight;
            }
            left += bgTileWidth;
            top = 0;
        }
        // Free up the bitmap memory
        watermark.recycle();
        return bmp;
    }

    public static File lastFileModified(String dir) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;
        if (files != null)
            for (File file : files) {
                if (file.lastModified() > lastMod) {
                    choice = file;
                    lastMod = file.lastModified();
                }
            }
        return choice;
    }

    /*
       check application is in background or not
        */
    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static double getFileSizeMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024);
    }

    public static double getFileSizeKiloBytes(File file) {
        return (double) file.length() / 1024;
    }

    public static long getFileSizeBytes(File file) {
        return file.length();
    }

    /*
    Check whether the text is in english or not
     */
    public static String ENGLISH_PATTERN = ".*[a-zA-Z]+.*";

    public static boolean isEnglishText(String text) {

        if (text.matches(ENGLISH_PATTERN))
            return true;
        else
            return false;
    }

    public static Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return null;
        }
    }


}
