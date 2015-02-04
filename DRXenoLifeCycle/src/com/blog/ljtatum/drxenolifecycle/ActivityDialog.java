/** Project and code provided by Leonard Tatum, A.K.A DRXeno
 * For any questions or comments regarding the use of this code
 * or issues please contact LJTATUM@HOTMAIL.COM
 * ONLINE MOBILE TUTORIALS: ljtatum.blog.com/
 * CODEBASE: http://ljtatum.blog.com/codebase_two/ 
 * Reference Link: http://developer.android.com/training/basics/activity-lifecycle/index.html */

package com.blog.ljtatum.drxenolifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;

public class ActivityDialog extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
    }

    public void finishDialog(View v) {
        ActivityDialog.this.finish();
    }
}