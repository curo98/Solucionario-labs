package autonoma.pe.practice.utils;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.Spannable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ActionBarUtils {

    private static final int TITLE_SIZE = 15;
    private static final int SUBTITLE_SIZE = 11;

    public static void setCustomTitle(AppCompatActivity activity, String title, String subtitle) {
        String uppercaseTitle = title.toUpperCase();
        String uppercaseSubtitle = (subtitle != null) ? subtitle.toUpperCase() : null;

        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getSpannableString(uppercaseTitle, TITLE_SIZE));
            if (uppercaseSubtitle != null) {
                actionBar.setSubtitle(getSpannableString(uppercaseSubtitle, SUBTITLE_SIZE));
            }
        }
    }

    private static CharSequence getSpannableString(String text, int textSize) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new AbsoluteSizeSpan(textSize, true), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return spannableString;
    }
}
