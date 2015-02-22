/** Project and code provided by Leonard Tatum
 * For any questions or comments regarding the use of this code
 * or issues please contact LJTATUM@HOTMAIL.COM
 * ONLINE MOBILE TUTORIALS: ljtatum.blog.com/
 * GITHUB: https://github.com/drxeno02/androidprojects-book1-lifecycle */

package com.blog.ljtatum.drxenolifecycle.util;

import java.util.*;

public class CycleTracker {
	private Map<String, String> mCycleMap;
	private List<String> mMethodList;
	private static CycleTracker ourInstance = new CycleTracker();
	private static final String STATUS_SUFFIX = "ed";

	public static CycleTracker getInstance() {
		return ourInstance;
	}

	private CycleTracker() {
		mCycleMap = new LinkedHashMap<String, String>();
		mMethodList = new ArrayList<String>();
	}

	public List<String> getMethodList() {
		return mMethodList;
	}

	public void clear() {
		mMethodList.clear();
		mCycleMap.clear();
	}

	// Sets up the display of cycle in view e.g. "Activity A | onStop()" or
	// "Activity A | onStart()" or "Activity B | onResume()"
	public void setCycle(String activityName, String cycle) {
		mMethodList.add(activityName + " " + "|" + cycle + "()");
		if (mCycleMap.containsKey(activityName)) {
			mCycleMap.remove(activityName);
		}			
		mCycleMap.put(activityName, cycle);
	}

	// Final results of the Activities' lifecycle, has it stopped or resumed.
	// Strings have been manipulated for spelling corrections
	public String getCycle(String activityName) {
		String cycle = mCycleMap.get(activityName);
		cycle = cycle.substring(2, cycle.length());

		// String manipulation to ensure that the lifecycle value is spelled correctly
		if (cycle.endsWith("e")) {
			cycle = cycle.substring(0, cycle.length() - 1); // Create the word "Resum(-e)+ed"
		}
		if (cycle.endsWith("p")) {
			cycle = cycle + "p"; // Create the word "stop(p)+ed"
		}
		cycle = cycle + STATUS_SUFFIX;
		return cycle;
	}

	public Set<String> keySet() {
		return mCycleMap.keySet();
	}
}
