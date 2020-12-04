package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import java.util.List;
import java.util.ArrayList;

public class SystemMonitor {

    private final SystemInfo si;
    private final HardwareAbstractionLayer hal;
    private final OperatingSystem os;
    private SystemState lastSystemState = null;
    private final List <SystemStateObserver> observers = new ArrayList <SystemStateObserver>();


    public SystemMonitor(){
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();

    }
    public void addSystemStateObserver(SystemStateObserver observer){
        observers.add(observer);
    }
    public void removeSystemStateObserver(SystemStateObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(SystemStateObserver observer : this.observers){ observer.update(this.lastSystemState);}
    }

    public void probe(){

        // Get current state of the system resources
        double cpuLoad = hal.getProcessor().getSystemCpuLoad()*100;
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).length;

        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);

        // Run garbage collector when out of memory
        if (SystemState.getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }

        // Increase CPU cooling if the temperature is to high
        if (SystemState.getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }
        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory,usbDevices);
        notifyObservers();
    }

    public SystemState getLastSystemState() {
        return lastSystemState;
    }
}
