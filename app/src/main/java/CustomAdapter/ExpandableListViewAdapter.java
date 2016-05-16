package CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.deathlove.formygirl.R;

import java.util.List;

import BeanModel.WholeDayModel;

/**
 * Created by Death丶Love on 2016/5/12.
 */
public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<WholeDayModel> list;
    private Context context;

    public ExpandableListViewAdapter(Context context, List<WholeDayModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition) != null ? list.get(groupPosition).getList().size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        WholeDayModel model = list.get(groupPosition);
        GroupViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.axis_group_item,null);
            holder = new GroupViewHolder();
            holder.tv = ((TextView) convertView.findViewById(R.id.AxisGroupItem_tv));
            convertView.setTag(holder);
        }else{
            holder = ((GroupViewHolder) convertView.getTag());
        }
        holder.tv.setText(model.getDayTime());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    
    class GroupViewHolder{
        TextView tv;
    }
    
    class ChildViewHolder{
        TextView AxisChildItemTime_tv,AxisChildItemKind_tv,AxisChildItemContent_tv_tv;
    }
}
