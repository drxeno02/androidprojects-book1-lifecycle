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

public class ActivityC extends Activity {
	
	// Define variables
	private String mActivityName;
    private TextView mCycleView;
    private TextView mCycleUpdateView;
    private CycleTracker mCycleTracker = CycleTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        mActivityName = getString(R.string.activity_c_label);
        mCycleView = (TextView)findViewById(R.id.cycle_view_c);
        mCycleUpdateView = (TextView)findViewById(R.id.cycle_update_c);
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_create));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_start));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity C: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_restart));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity C: onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_resume));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity C: onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_pause));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity C: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_stop));
        Toast.makeText(getApplicationContext(), "Activity C: onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_destroy));
        Toast.makeText(getApplicationContext(), "Activity C: onDestroy()", Toast.LENGTH_SHORT).show();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityDialog.class);
        startActivity(intent);
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityB.class);
        startActivity(intent);
    }

    /* To familiarize yourself with errors, see what happens when you attempt 
     * to finish on an Activity that isn't referenced. Change the line 
     * "ActivityC.this.finish()" to "ActivityB.this.finish()" or 
     * "ActivityA.this.finish". It is important to learn and recognize various 
     * errors. This will bring up a java.land.IllegalStateException. Meaning that 
     * the system is unable to find the appropriate method view, because you are 
     * referencing the wrong one */
    public void finishActivityC(View v) {
        ActivityC.this.finish();
    }

}