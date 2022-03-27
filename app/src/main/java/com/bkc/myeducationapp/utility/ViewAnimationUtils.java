package com.bkc.myeducationapp.utility;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

/**
 * Created by SXL_01 on 27/11/17.
 */

public class ViewAnimationUtils {

    /**
     * used for animate view for expand.
     *
     * @param v
     */
    public static void expand(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targtetHeight = v.getMeasuredHeight();

        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targtetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

//        change expand animation time according to your requirement
//        int duration = (int) (targtetHeight / v.getContext().getResources().getDisplayMetrics().density) * 4;
        int duration = (int) (targtetHeight / v.getContext().getResources().getDisplayMetrics().density);
        a.setDuration(duration);
        v.startAnimation(a);
    }

    /**
     * used for animate view for collapse.
     *
     * @param v
     */
    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

//        change collapse animation time according to your requirement
//        int duration = (int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density) * 4;
        int duration = (int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density);
        a.setDuration(duration);
        v.startAnimation(a);
    }

    public static void animateViewVisibility(final View view, final int visibility) {
        try {
            // cancel running animations and remove and listeners
            view.animate().cancel();
            view.animate().setListener(null);

            // animate making view visible
            if (visibility == View.VISIBLE) {
                view.setVisibility(visibility);
                view.animate().setDuration(1000).alpha(1f).start();
            }
            // animate making view hidden (HIDDEN or INVISIBLE)
            else {
                view.animate().setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (view != null) {
                            view.setVisibility(visibility);
                        }
                    }
                }).setDuration(1000).alpha(0f).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * make every word first character capital.
     *
     * @param text
     * @return
     */
    public static String capitalisedAllWords(String text) {

        try {
            if (TextUtils.isEmpty(text)) {
                return "";
            } else {
                text = text.trim();
            }

            // split words
            String[] words = text.split(" ");
            StringBuilder sb = new StringBuilder();

            for (String word : words) {

                if (word.trim().length() >= 2) {
                    sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
                } else if (word.trim().length() == 1) {
                    sb.append(Character.toUpperCase(word.charAt(0))).append(" ");
                }
            }
            return sb.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * make first word first character capital only.
     *
     * @param text
     * @return
     */
    public static String capitalisedFirstWordOnly(String text) {

        try {
            String word = "";

            if (TextUtils.isEmpty(text)) {
                return "";
            } else {
                word = text.trim();
            }

            StringBuilder sb = new StringBuilder();

            if (word.trim().length() >= 2) {
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
            } else if (word.trim().length() == 1) {
                sb.append(Character.toUpperCase(word.charAt(0))).append(" ");
            }
            return sb.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}