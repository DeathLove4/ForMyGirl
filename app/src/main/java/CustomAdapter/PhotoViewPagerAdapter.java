package CustomAdapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Death丶Love on 2016/5/6.
 */
public class PhotoViewPagerAdapter extends PagerAdapter {
    private List<ImageView> list;

    public PhotoViewPagerAdapter(List<ImageView> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
       // return list != null ? list.size() : 0;
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position%list.size()));
        return list.get(position%list.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position%list.size()));
    }
}
