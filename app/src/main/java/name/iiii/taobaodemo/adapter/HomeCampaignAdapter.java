package name.iiii.taobaodemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import name.iiii.taobaodemo.R;
import name.iiii.taobaodemo.bean.HomeCampaign;

/**
 * Created by Administrator on 2016/1/12.
 */
public class HomeCampaignAdapter extends RecyclerView.Adapter<HomeCampaignAdapter.ViewHolder> {
    private static int VIEW_TYPE_L = 0;
    private static int VIEW_TYPE_R = 1;
    private LayoutInflater mInflater;
    private List<HomeCampaign> mDatas;

    public HomeCampaignAdapter(List<HomeCampaign> datas){
        mDatas = datas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_R){
            return  new ViewHolder(mInflater.inflate(R.layout.template_home_cardview,parent,false));
        }
        return new ViewHolder(mInflater.inflate(R.layout.template_home_cardview2,parent,false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HomeCampaign category = mDatas.get(position);
        holder.textTitle.setText(category.getTitle());
        holder.cpOne.setImageResource(R.drawable.img_1);
        holder.cpTwo.setImageResource(R.drawable.img_2);
        holder.cpThree.setImageResource(R.drawable.img_2);
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return VIEW_TYPE_R;
        }else {
            return VIEW_TYPE_L;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        ImageView cpOne,cpTwo,cpThree;
        public ViewHolder(View itemView){
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            cpOne = (ImageView) itemView.findViewById(R.id.imgview_big);
            cpTwo = (ImageView) itemView.findViewById(R.id.imgview_small_top);
            cpThree = (ImageView) itemView.findViewById(R.id.imgview_small_bottom);
        }
    }


}
