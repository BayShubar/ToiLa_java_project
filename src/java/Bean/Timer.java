/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;

/**
 *
 * @author Yerke
 */
public class Timer implements Serializable{
    private String leftTime;
    private long creationTime;
    public Timer(){
        creationTime = 0;
    }

    public String getLeftTime() {
        if(creationTime == 0)
            return "";
        long time = System.currentTimeMillis()- this.creationTime;
        time = (1800-((time/1000)%1800))/60;
        return " "+time + "min";
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    
}
