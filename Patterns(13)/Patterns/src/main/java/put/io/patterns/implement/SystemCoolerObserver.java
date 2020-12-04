package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver{
    @Override
    public void update(SystemState lastSystemStatus) {
        System.out.println("> Check temperature...");

        if (SystemState.getCpuTemp() > 35.00) {
            System.out.println("> Increase Cooling ...");
        }
    }
}