package Utils;

import java.sql.Timestamp;

import org.testng.Reporter;

public class ReporterLog {
	boolean val = true;
	
	public void info(String msg,boolean state){
        Reporter.log(new Timestamp(System.currentTimeMillis())+" [info]  "+msg,state);
    }
	
    public void verify(String msg,boolean state){
           Reporter.log(new Timestamp(System.currentTimeMillis())+" [Verify]  "+msg,state);
    }
    
    public void warning(String msg,boolean state){
        Reporter.log(new Timestamp(System.currentTimeMillis())+" [error]  "+msg,state);
        
    }
}
