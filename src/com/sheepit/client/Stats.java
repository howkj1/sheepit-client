/*
 * Copyright (C) 2016 Laurent CLOUET
 * Author Laurent CLOUET <laurent.clouet@nopnop.net>
 *
 * This program is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.sheepit.client;

public class Stats {
	private int remainingFrame;
	private int creditsEarned;
	private int creditsEarnedSession;
<<<<<<< HEAD
	private int waitingProject;
	private int connectedMachine;
	
	public Stats(int frame, int credits, int creditsSession, int waitings, int machines) {
		remainingFrame = frame;
		creditsEarned = credits;
		creditsEarnedSession = creditsSession;
=======
	private int renderableProject;
	private int waitingProject;
	private int connectedMachine;
	
	public Stats(int frame, int credits, int creditsSession, int renderables, int waitings, int machines) {
		remainingFrame = frame;
		creditsEarned = credits;
		creditsEarnedSession = creditsSession;
		renderableProject = renderables;
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
		waitingProject = waitings;
		connectedMachine = machines;
	}
	
	public Stats() {
		remainingFrame = 0;
		creditsEarned = 0;
		creditsEarnedSession = 0;
<<<<<<< HEAD
=======
		renderableProject = 0;
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
		waitingProject = 0;
		connectedMachine = 0;
	}
	
	public int getRemainingFrame() {
		return remainingFrame;
	}
	
	public int getCreditsEarnedDuringSession() {
		return creditsEarnedSession;
	}
	
	public int getCreditsEarned() {
		return creditsEarned;
	}
	
<<<<<<< HEAD
=======
	public int getRenderableProject() {
		return renderableProject;
	}
	
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
	public int getWaitingProject() {
		return waitingProject;
	}
	
	public int getConnectedMachine() {
		return connectedMachine;
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return "Stats [remainingFrame=" + remainingFrame + ", creditsEarned=" + creditsEarned + ", creditsEarnedSession=" + creditsEarnedSession + ", waitingProject=" + waitingProject + ", connectedMachine=" + connectedMachine + "]";
=======
		return "Stats [remainingFrame=" + remainingFrame + ", creditsEarned=" + creditsEarned + ", creditsEarnedSession=" + creditsEarnedSession + ", renderableProject=" + renderableProject + ", waitingProject=" + waitingProject + ", connectedMachine=" + connectedMachine + "]";
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
	}
}
