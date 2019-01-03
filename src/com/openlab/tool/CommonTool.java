package com.openlab.tool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class CommonTool {

	public static long getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return Long.parseLong(newDate+result);
    }
}
