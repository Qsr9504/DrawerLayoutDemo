package demo.com.qsr.drawerlayoutdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**************************************
 * FileName : demo.com.qsr.drawerlayoutdemo
 * Author : qsr
 * Time : 2016/8/1 14:58
 * Description : 普通的适配器
 **************************************/
public class GridViewAdapter extends BaseAdapter {
    private List<Bean> beanList;
    private Context context;

    public GridViewAdapter(Context context, List<Bean> beanList) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_sliding_gridview, null);
            viewHolder = new ViewHolder(convertView);
            viewHolder.itemImage = (ImageView) convertView.findViewById(R.id.item_image);
            viewHolder.itemName = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.itemImage.setImageResource(beanList.get(position).getImageId());
        viewHolder.itemName.setText(beanList.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_image)
        ImageView itemImage;
        @Bind(R.id.item_name)
        TextView itemName;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
