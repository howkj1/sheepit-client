/*
 * Copyright (C) 2015 Laurent CLOUET
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

<<<<<<< HEAD
import java.util.Date;

public class RenderProcess {
	private long start;
	private long end;
	private int remainingDuration;
=======
import lombok.Data;

import java.util.Date;

@Data
public class RenderProcess {
	private long startTime;
	private long endTime;
	private int remainingDuration; // in seconds
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
	private long memoryUsed; // in kB
	private int coresUsed;
	private Process process;
	
	public RenderProcess() {
		process = null;
<<<<<<< HEAD
		start = -1;
		end = -1;
=======
		startTime = -1;
		endTime = -1;
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
		memoryUsed = 0;
		coresUsed = 0;
		remainingDuration = 0;
	}
	
<<<<<<< HEAD
	public void setMemoryUsed(long val) {
		memoryUsed = val;
	}
	
	public long getMemoryUsed() {
		return memoryUsed;
	}
	
	public void setCoresUsed(int val) {
		coresUsed = val;
	}
	
	public int getCoresUsed() {
		return coresUsed;
	}
	
	public long getStartTime() {
		return start;
	}
	
	public long getEndTime() {
		return end;
	}
	
=======
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
	/**
	 * 
	 * @return duration in seconds
	 */
	public int getDuration() {
<<<<<<< HEAD
		if (start != -1 && end != -1) {
			return (int) ((end - start) / 1000);
		}
		else if (start != -1) {
			return (int) ((new Date().getTime() - start) / 1000);
=======
		if (startTime != -1 && endTime != -1) {
			return (int) ((endTime - startTime) / 1000);
		}
		else if (startTime != -1) {
			return (int) ((new Date().getTime() - startTime) / 1000);
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
		}
		return 0;
	}
	
<<<<<<< HEAD
	/**
	 * 
	 * @return duration in seconds
	 */
	public int getRemainingDuration() {
		return remainingDuration;
	}
	
	public void setRemainingDuration(int val) {
		remainingDuration = val;
	}
	
	public void finish() {
		end = new Date().getTime();
=======
	public void finish() {
		endTime = new Date().getTime();
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
		process = null;
	}
	
	public void start() {
<<<<<<< HEAD
		start = new Date().getTime();
=======
		startTime = new Date().getTime();
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
	}
	
	public int exitValue() {
		int value = 0;
		if (process == null) {
			return -1;
		}
		try {
			value = process.exitValue();
		}
		catch (IllegalThreadStateException e) {
			// the process is not finished yet
			value = 0;
		}
		catch (Exception e) {
			// actually is for java.io.IOException: GetExitCodeProcess error=6, The handle is invalid
			// it was not declared throwable
			
			// the process is not finished yet
			value = 0;
		}
		return value;
	}
<<<<<<< HEAD
	
	public void setProcess(Process val) {
		process = val;
	}
	
	public Process getProcess() {
		return process;
	}
=======
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
}
