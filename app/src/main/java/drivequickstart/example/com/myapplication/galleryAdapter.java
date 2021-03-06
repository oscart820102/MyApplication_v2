package drivequickstart.example.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

class galleryAdapter extends BaseAdapter {
    Context mContext;
    private int selectItem;
    private ArrayList<CustomImage> customImages;
    private int drawable1[] = new int[]{R.mipmap.x11, R.mipmap.h2};
    private List<Bitmap> bitmap= new ArrayList<>();

    public galleryAdapter(Context mContext, ArrayList<CustomImage> customImages) {
        this.mContext = mContext;
        this.customImages = customImages;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub  
        return customImages.size();          //这里的目的是可以让图片循环浏览
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub  
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub  
        return position;
    }

    public void setSelectItem(int selectItem) {

        if (this.selectItem != selectItem) {
            this.selectItem = selectItem;
            notifyDataSetChanged();
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub  
        ImageView imageView = new ImageView(mContext);
        imageView.setImageBitmap(DbBitmapUtility.getImage(customImages.get(position).getImageByte()));
//取余，让图片循环浏览

        if (selectItem == position) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.my_scale_action);    //实现动画效果
            imageView.setLayoutParams(new Gallery.LayoutParams(250, 250));
            imageView.startAnimation(animation);  //选中时，这是设置的比较大
        } else {
            imageView.setLayoutParams(new Gallery.LayoutParams(75, 90));
//未选中  
        }
        return imageView;
    }

}  