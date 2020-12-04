package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver {
    int old_usb=0;
    boolean usb_init=false;
    @Override
    public void update(SystemState lastSystemState) {
        int new_usb=lastSystemState.getUsbDevices();
        if(!usb_init){
            old_usb=new_usb;
            usb_init=true;
        }
        else{
            if(old_usb!=new_usb){
                System.out.println(String.format("usb dev changed: from %d to %d", old_usb,new_usb));
                old_usb=new_usb;
            }
        }


    }
}
