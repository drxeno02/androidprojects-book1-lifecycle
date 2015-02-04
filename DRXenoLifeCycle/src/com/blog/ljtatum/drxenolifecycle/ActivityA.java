/** Project and code provided by Leonard Tatum, A.K.A DRXeno
 * For any questions or comments regarding the use of this code
 * or issues please contact LJTATUM@HOTMAIL.COM
 * ONLINE MOBILE TUTORIALS: ljtatum.blog.com/
 * CODEBASE: http://ljtatum.blog.com/codebase_two/ 
 * Reference Link: http://developer.android.com/training/basics/activity-lifecycle/index.html */

package com.blog.ljtatum.drxenolifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blog.ljtatum.drxenolifecycle.util.CycleTracker;
import com.blog.ljtatum.drxenolifecycle.util.PrintUtil;

public class ActivityA extends Activity {

	// Define method variables
	private String mActivityName;
    private TextView mCycleView;
    private TextView mCycleUpdateView;
    private CycleTracker mCycleTracker = CycleTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mActivityName = getString(R.string.activity_a_label);
        mCycleView = (TextView)findViewById(R.id.cycle_view_a);
        mCycleUpdateView = (TextView)findViewById(R.id.cycle_update_a);
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_create));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
    }
 
    @Override
    protected void onStart() {
        super.onStart();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_start));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity A: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_restart));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity A: onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_resume));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity A: onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_pause));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity A: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_stop));
        Toast.makeText(getApplicationContext(), "Activity A: onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_destroy));
        mCycleTracker.clear();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityDialog.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }

    public void startActivityC(View v) {
        Intent intent = new Intent(ActivityA.this, ActivityC.class);
        startActivity(intent);
    }

    
    /* To familiarize yourself with errors, see what happens when you attempt 
     * to finish on an Activity that isn't referenced. Change the line 
     * "ActivityA.this.finish()" to "ActivityB.this.finish()" or 
     * "ActivityC.this.finish". It is important to learn and recognize various 
     * errors. This will bring up a java.land.IllegalStateException. Meaning that 
     * the system is unable to find the appropriate method view, because you are 
     * referencing the wrong one */
    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }

}