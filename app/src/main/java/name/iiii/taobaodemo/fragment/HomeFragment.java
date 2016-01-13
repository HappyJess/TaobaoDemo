package name.iiii.taobaodemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

import name.iiii.taobaodemo.R;
import name.iiii.taobaodemo.adapter.HomeCampaignAdapter;
import name.iiii.taobaodemo.bean.HomeCampaign;

public class HomeFragment extends Fragment {
    private View mview;
    private SliderLayout sliderShow;

    private RecyclerView mRecyclerView;
    private HomeCampaignAdapter mAdapter;

    //private PagerIndicator custom_indicator;
    ArrayList<View> viewContainter = new ArrayList<View>();
    ArrayList<String> titleContainer = new ArrayList<String>();
    public String TAG = "tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        initEvents();

        return mview;
    }


    private void initViews() {
        sliderShow = (SliderLayout) mview.findViewById(R.id.slider);
        //custom_indicator = (PagerIndicator) mview.findViewById(R.id.custom_indicator);
        mRecyclerView = (RecyclerView) mview.findViewById(R.id.recyclerview);
    }

    private void initEvents() {
        TextSliderView textSliderView1 = new TextSliderView(this.getActivity());
        textSliderView1
                .image("http://pic.58pic.com/58pic/16/34/57/33X58PIC4up_1024.jpg")
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(HomeFragment.this.getActivity(), "第一屏", Toast.LENGTH_SHORT).show();
                    }
                });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2
                .image("http://pic.58pic.com/58pic/12/60/40/49W58PICgrS.jpg")
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(HomeFragment.this.getActivity(), "第二屏", Toast.LENGTH_SHORT).show();
                    }
                });

        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3
                .image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg")
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(HomeFragment.this.getActivity(), "第三屏", Toast.LENGTH_SHORT).show();
                    }
                });

        sliderShow.addSlider(textSliderView1);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);

        //sliderShow.setCustomIndicator(custom_indicator);
        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setCustomAnimation(new test.DescriptionAnimation());
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderShow.setDuration(3000);

        //初始化RecyclerView
        List<HomeCampaign> datas = new ArrayList<>(15);
        HomeCampaign category = new HomeCampaign(1,"热门活动",R.drawable.img_1,R.drawable.img_2,R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(2,"有利可图",R.drawable.img_1,R.drawable.img_2,R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(3,"品牌街",R.drawable.img_1,R.drawable.img_2,R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(4,"金融街",R.drawable.img_1,R.drawable.img_2,R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(5,"超值购",R.drawable.img_1,R.drawable.img_2,R.drawable.img_2);
        datas.add(category);

        mAdapter = new HomeCampaignAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
