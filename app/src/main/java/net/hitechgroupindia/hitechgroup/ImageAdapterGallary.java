package net.hitechgroupindia.hitechgroup;

/**
 * Created by QServer on 3/2/2016.
 */


    import android.content.Context;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.GridView;
    import android.widget.ImageView;

    public class ImageAdapterGallary extends BaseAdapter {

        private Context mContext;

        // Keep all Images in array
        Integer[] mThumbIds = {
                R.drawable.gallery1, R.drawable.gallery2,  R.drawable.gallery3, R.drawable.gallery4, R.drawable.gallery5,
                R.drawable.gallery6, R.drawable.gallery7

        };

        // Constructor
        public ImageAdapterGallary(Context c){
            mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return mThumbIds[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(265, 265));
            return imageView;
        }

    }

