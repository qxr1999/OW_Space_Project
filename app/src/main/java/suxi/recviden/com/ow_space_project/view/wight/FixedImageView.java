package suxi.recviden.com.ow_space_project.view.wight;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

/**
 * 作者: Created by Revicden
 * 时间: On 2018/12/5  18:39
 * 邮箱: 18235420811@163.com
 */
@SuppressLint("AppCompatCustomView")
public class FixedImageView extends ImageView{
    //屏高
    int mScreenHeight;

    public FixedImageView(Context context) {
        this(context,null);
    }

    public FixedImageView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FixedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取总宽度,是包含padding值
        int i = MeasureSpec.getSize(widthMeasureSpec);
        View.MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(i,this.mScreenHeight);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mScreenHeight = getScreenWidthHeight(context)[1];
    }

    private int[] getScreenWidthHeight(Context context) {
        int[] ints = new int[2];
        if (context==null) {
            return ints;
        }
        //修改屏幕分辨率
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //获取屏幕尺寸赋值给displayMetrics
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        ints[0] = widthPixels;
        ints[1] = heightPixels;
        return ints;
    }


}
