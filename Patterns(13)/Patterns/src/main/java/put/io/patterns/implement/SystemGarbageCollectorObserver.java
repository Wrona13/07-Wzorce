package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver{
    @Override
    public void update(SystemState SystemStatus) {
        System.out.println("> Check garbage...");

        if (SystemState.getAvailableMemory() < 200.00) {
            System.out.println("> Running garbage collector...");
        }
    }
}
