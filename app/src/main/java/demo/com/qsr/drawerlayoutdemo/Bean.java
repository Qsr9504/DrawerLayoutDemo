package demo.com.qsr.drawerlayoutdemo;

import android.media.Image;
import android.widget.ImageView;

/**************************************
 * FileName : demo.com.qsr.drawerlayoutdemo
 * Author : qsr
 * Time : 2016/8/1 14:59
 * Description :
 **************************************/
public class Bean {
    private int imageId;
    private String name;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bean() {

    }

    public Bean(int imageId, String name) {

        this.imageId = imageId;
        this.name = name;
    }
}
