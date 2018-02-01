package com.project.cx.processcontrol.util;

import com.squareup.otto.Bus;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public class EventUtil {
    private static Bus bus=new Bus();

    //private static Bus bus;

/*    public static Bus getInstance(){
        if(bus==null){
            bus=new Bus();
        }
        return bus;
    }*/

    public static void register(Object context){
        bus.register(context);
    }
    public static void unregister(Object context){
        bus.unregister(context);
    }
    public static void sendEvent(Object object){
        bus.post(object);
    }

}
