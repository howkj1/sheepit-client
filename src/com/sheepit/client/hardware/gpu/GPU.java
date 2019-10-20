/*
 * Copyright (C) 2013-2014 Laurent CLOUET
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

package com.sheepit.client.hardware.gpu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sheepit.client.Configuration;
import com.sheepit.client.hardware.gpu.nvidia.Nvidia;
import com.sheepit.client.hardware.gpu.opencl.OpenCL;
import com.sheepit.client.os.OS;
<<<<<<< HEAD
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
=======
import com.sheepit.client.os.Windows;
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee

public class GPU {
	public static List<GPUDevice> devices = null;
	
	public static boolean generate() {
		devices = new LinkedList<GPUDevice>();
<<<<<<< HEAD
		
		OS os = OS.getOS();
		String path = os.getCUDALib();
		if (path == null) {
			System.out.println("GPU::generate no CUDA lib path found");
			return false;
		}
		CUDA cudalib = null;
		try {
			cudalib = (CUDA) Native.loadLibrary(path, CUDA.class);
		}
		catch (java.lang.UnsatisfiedLinkError e) {
			System.out.println("GPU::generate failed to load CUDA lib (path: " + path + ")");
			return false;
		}
		catch (java.lang.ExceptionInInitializerError e) {
			System.out.println("GPU::generate ExceptionInInitializerError " + e);
			return false;
		}
		catch (Exception e) {
			System.out.println("GPU::generate generic exception " + e);
			return false;
		}
		
		int result = CUresult.CUDA_ERROR_UNKNOWN;
		
		result = cudalib.cuInit(0);
		if (result != CUresult.CUDA_SUCCESS) {
			System.out.println("GPU::generate cuInit failed (ret: " + result + ")");
			if (result == CUresult.CUDA_ERROR_UNKNOWN) {
				System.out.println("If you are running Linux, this error is usually due to nvidia kernel module 'nvidia_uvm' not loaded.");
				System.out.println("Relaunch the application as root or load the module.");
				System.out.println("Most of time it does fix the issue.");
			}
			return false;
		}
		
		if (result == CUresult.CUDA_ERROR_NO_DEVICE) {
			return false;
		}
		
		IntByReference count = new IntByReference();
		result = cudalib.cuDeviceGetCount(count);
		
		if (result != CUresult.CUDA_SUCCESS) {
			System.out.println("GPU::generate cuDeviceGetCount failed (ret: " + CUresult.stringFor(result) + ")");
			return false;
		}
		
		HashMap<Integer, GPUDevice> devicesWithPciId = new HashMap<Integer, GPUDevice>(count.getValue());
		for (int num = 0; num < count.getValue(); num++) {
			IntByReference aDevice = new IntByReference();
			
			result =  cudalib.cuDeviceGet(aDevice, num);
			if (result != CUresult.CUDA_SUCCESS) {
				System.out.println("GPU::generate cuDeviceGet failed (ret: " + CUresult.stringFor(result) + ")");
				continue;
			}
			
			IntByReference pciBusId = new IntByReference();
			result =  cudalib.cuDeviceGetAttribute(pciBusId, CUDeviceAttribute.CU_DEVICE_ATTRIBUTE_PCI_BUS_ID, aDevice.getValue());
			if (result != CUresult.CUDA_SUCCESS) {
				System.out.println("GPU::generate cuDeviceGetAttribute for CU_DEVICE_ATTRIBUTE_PCI_BUS_ID failed (ret: " + CUresult.stringFor(result) + ")");
				continue;
			}
			
			byte name[] = new byte[256];
			
			result = cudalib.cuDeviceGetName(name, 256, num);
			if (result != CUresult.CUDA_SUCCESS) {
				System.out.println("GPU::generate cuDeviceGetName failed (ret: " + CUresult.stringFor(result) + ")");
				continue;
			}
			
			LongByReference ram = new LongByReference();
			try {
				result = cudalib.cuDeviceTotalMem_v2(ram, num);
			}
			catch (UnsatisfiedLinkError e) {
				// fall back to old function
				result = cudalib.cuDeviceTotalMem(ram, num);
			}
			
			if (result != CUresult.CUDA_SUCCESS) {
				System.out.println("GPU::generate cuDeviceTotalMem failed (ret: " + CUresult.stringFor(result) + ")");
				return false;
			}
			
			devicesWithPciId.put(pciBusId.getValue(), new GPUDevice(new String(name).trim(), ram.getValue(), "FAKE"));
		}
		
		// generate proper cuda id
		// in theory a set to environment "CUDA_DEVICE_ORDER=PCI_BUS_ID" should be enough but it didn't work
		int i = 0;
		for (Map.Entry<Integer, GPUDevice> entry : devicesWithPciId.entrySet()){
			GPUDevice aDevice = entry.getValue();
			aDevice.setCudaName("CUDA_" + Integer.toString(i));
			devices.add(aDevice);
			i++;
=======
		List<GPUDevice> gpus = new Nvidia().getGpus();
		if (gpus != null) {
			devices.addAll(gpus);
		}
		
		OS os = OS.getOS();
		if (os instanceof Windows) { // opencl detection will crash on Mac (and sometimes on Linux) 
			gpus = new OpenCL().getGpus();
			if (gpus != null) {
				devices.addAll(gpus);
			}
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
		}
		
		return true;
	}
	
	public static List<String> listModels() {
		if (devices == null) {
			generate();
		}
		
		List<String> devs = new LinkedList<String>();
		for (GPUDevice dev : devices) {
			devs.add(dev.getModel());
		}
		return devs;
	}
	
<<<<<<< HEAD
	public static List<GPUDevice> listDevices() {
		if (devices == null) {
			generate();
=======
	public static List<GPUDevice> listDevices(Configuration config) {
		if (devices == null) {
			if (config.isDetectGPUs()) {
				generate();
			}
			else {
				devices = new LinkedList<GPUDevice>();
			}
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
		}
		
		return devices;
	}
	
<<<<<<< HEAD
	public static GPUDevice getGPUDevice(String device_model) {
		if (device_model == null) {
=======
	public static GPUDevice getGPUDevice(String deviceId) {
		if (deviceId == null) {
>>>>>>> 73a98e49f183350391a23ecff48a759a8c434fee
			return null;
		}
		
		if (devices == null) {
			generate();
		}
		
		if (devices == null) {
			return null;
		}
		
		for (GPUDevice dev : devices) {
			if (deviceId.equals(dev.getId()) || deviceId.equals(dev.getOldId())) {
				return dev;
			}
		}
		return null;
	}
}
