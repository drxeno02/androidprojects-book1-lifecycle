/** Project and code provided by Leonard Tatum, A.K.A DRXeno
 * For any questions or comments regarding the use of this code
 * or issues please contact LJTATUM@HOTMAIL.COM
 * ONLINE MOBILE TUTORIALS: ljtatum.blog.com/
 * CODEBASE: http://ljtatum.blog.com/codebase_two/ 
 * Reference Link: http://developer.android.com/training/basics/activity-lifecycle/index.html */

package com.blog.ljtatum.drxenolifecycle.util;

import android.os.Handler;
import android.widget.TextView;

import java.util.List;

public class PrintUtil {

	private static CycleTracker mCycleTracker = CycleTracker.getInstance();

	/*
	 * This method prints out the lifecycle state of each Activity A/B/C. There
	 * is an added time delay around a wrapped Handler
	 * 
	 * @param viewMethods TextView to list out the lifecycle methods called
	 * @param viewCycle TextView to list out the cycle of all Activity classes
	 */
	public static void printCycle(final TextView viewMethods,
			final TextView viewCycle) {
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				// Get the stack of Activity lifecycle methods called and print
				// to TextView
				StringBuilder sbMethods = new StringBuilder();
				List<String> listMethods = mCycleTracker.getMethodList();
				for (String method : listMethods) {
					sbMethods.insert(0, method + "\r\n");
				}
				if (viewMethods != null) {
					viewMethods.setText(sbMethods.toString());
				}

				// Get the status of all Activity classes and print to TextView
				StringBuilder sbCycle = new StringBuilder();
				for (String key : mCycleTracker.keySet()) {
					sbCycle.insert(0, key + ": " + mCycleTracker.getCycle(key)
							+ "\n");
				}
				if (viewCycle != null) {
					viewCycle.setText(sbCycle.toString());
				}
			}
		}, 750);
	}
}
