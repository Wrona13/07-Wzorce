package put.io.patterns.implement;

public class SystemState {

    // CPU load in percentage
    private double cpu = 0.0;

    // CPU temperature in C
    private static double cpuTemp = 0.0;

    // available memory in Mega Bytes
    private static double memory = 0.0;

    // number of USB devices
    private int usbDevices = 0;


    public SystemState(double cpu, double cpuTemp, double memory, int usbDevices) {
        this.cpu = cpu;
        this.cpuTemp = cpuTemp;
        this.memory = memory;
        this.usbDevices = usbDevices;
    }

    public double getCpu() {
        return cpu;
    }

    public static double getAvailableMemory() {
        return memory;
    }


    public int getUsbDevices() {
        return usbDevices;
    }


    public static double getCpuTemp() {
        return cpuTemp;
    }
}
