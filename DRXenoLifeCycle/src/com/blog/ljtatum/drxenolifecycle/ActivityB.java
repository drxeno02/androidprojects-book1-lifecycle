/** Project and code provided by Leonard Tatum
 * For any questions or comments regarding the use of this code
 * or issues please contact LJTATUM@HOTMAIL.COM
 * ONLINE MOBILE TUTORIALS: ljtatum.blog.com/
 * GITHUB: https://github.com/drxeno02/androidprojects-book1-lifecycle */

package com.blog.ljtatum.drxenolifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blog.ljtatum.drxenolifecycle.util.CycleTracker;
import com.blog.ljtatum.drxenolifecycle.util.PrintUtil;

public class ActivityB extends Activity {

	// Define variables
	private String mActivityName;
    private TextView mCycleView;
    private TextView mCycleUpdateView;
    private CycleTracker mCycleTracker = CycleTracker.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mActivityName = getString(R.string.activity_b_label);
        mCycleView = (TextView)findViewById(R.id.cycle_view_b);
        mCycleUpdateView = (TextView)findViewById(R.id.cycle_update_b);
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_create));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
    }
 
    @Override
    protected void onStart() {
        super.onStart();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_start));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity B: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_restart));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity B: onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_resume));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity B: onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_pause));
        PrintUtil.printCycle(mCycleView, mCycleUpdateView);
        Toast.makeText(getApplicationContext(), "Activity B: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_stop));
        Toast.makeText(getApplicationContext(), "Activity B: onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCycleTracker.setCycle(mActivityName, getString(R.string.on_destroy));
        Toast.makeText(getApplicationContext(), "Activity B: onDestroy()", Toast.LENGTH_SHORT).show();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityDialog.class);
        startActivity(intent);
    }

    public void startActivityA(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityC(View v) {
        Intent intent = new Intent(ActivityB.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityB(View v) {
        ActivityB.this.finish();
    }

}