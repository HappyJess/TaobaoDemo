package name.iiii.taobaodemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindCallback;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import name.iiii.taobaodemo.R;
import name.iiii.taobaodemo.adapter.HomeCampaignAdapter;
import name.iiii.taobaodemo.bean.BannerPic;
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

    /**
     * 查询数据
     */
    public void queryBannerData() {
        BmobQuery<BannerPic> query = new BmobQuery<BannerPic>();
        //查询playerName叫“比目”的数据
        //query.addWhereEqualTo("playerName", "比目");
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(10);
        //执行查询方法
        query.findObjects(mview.getContext(), new FindListener<BannerPic>() {

            @Override
            public void onSuccess(List<BannerPic> object) {
                //Toast.makeText(HomeFragment.this.getActivity(), "查询成功：共" + object.size() + "条数据。", Toast.LENGTH_SHORT).show();
                for (BannerPic bannerPic : object) {
                    bannerPic.getObjectId();
                    bannerPic.getImgUrl();
                    bannerPic.getKindId();
                    bannerPic.getRedirectUrl();
                    bannerPic.getTextStr();

                    TextSliderView textSliderView = new TextSliderView(HomeFragment.this.getActivity());
                    textSliderView
                            .image(bannerPic.getImgUrl())
                            .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                                @Override
                                public void onSliderClick(BaseSliderView slider) {
                                    Toast.makeText(HomeFragment.this.getActivity(), "不知道", Toast.LENGTH_SHORT).show();
                                }
                            });

                    sliderShow.addSlider(textSliderView);
                }

            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(HomeFragment.this.getActivity(), "查询失败", Toast.LENGTH_SHORT).show();
            }


        });
    }

    private void initEvents() {

        queryBannerData();


        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShow.setCustomAnimation(new test.DescriptionAnimation());
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderShow.setDuration(3000);

        //初始化RecyclerView
        List<HomeCampaign> datas = new ArrayList<>(15);
        HomeCampaign category = new HomeCampaign(1, "热门活动", R.drawable.img_1, R.drawable.img_2, R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(2, "有利可图", R.drawable.img_1, R.drawable.img_2, R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(3, "品牌街", R.drawable.img_1, R.drawable.img_2, R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(4, "金融街", R.drawable.img_1, R.drawable.img_2, R.drawable.img_2);
        datas.add(category);
        category = new HomeCampaign(5, "超值购", R.drawable.img_1, R.drawable.img_2, R.drawable.img_2);
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
