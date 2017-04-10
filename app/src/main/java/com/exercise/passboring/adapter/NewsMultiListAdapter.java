package com.exercise.passboring.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.dl7.recycler.adapter.BaseMultiItemQuickAdapter;
import com.dl7.recycler.adapter.BaseViewHolder;
import com.exercise.passboring.R;
import com.exercise.passboring.adapter.item.NewsMultiItem;
import com.exercise.passboring.api.NewsUtils;
import com.exercise.passboring.api.bean.NewsInfo;
import com.exercise.passboring.utils.DefIconFactory;
import com.exercise.passboring.utils.ImageLoader;
import com.exercise.passboring.utils.ListUtils;
import com.exercise.passboring.utils.StringUtils;
import com.exercise.passboring.widget.RippleView;
import com.flyco.labelview.LabelView;

import java.util.List;

/**
 * 项目名称：PassBoring
 * 类描述：新闻列表适配器
 * 创建人：小豪
 * 创建时间：2017/3/22 16:46
 * 修改人：小豪
 * 修改时间：2017/3/22 16:46
 * 修改备注：
 */

public class NewsMultiListAdapter extends BaseMultiItemQuickAdapter<NewsMultiItem> {

    public NewsMultiListAdapter(Context context, List<NewsMultiItem> data) {
        super(context, data);
    }

    public NewsMultiListAdapter(Context context) {
        super(context);
    }

    @Override
    protected void attachItemType() {
        addItemType(NewsMultiItem.ITEM_TYPE_NORMAL, R.layout.adapter_news_list);
        addItemType(NewsMultiItem.ITEM_TYPE_PHOTO_SET, R.layout.adapter_news_photo_set);
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsMultiItem item) {
        switch (item.getItemType()) {
            case NewsMultiItem.ITEM_TYPE_NORMAL:
                _handleNewsNormal(holder, item.getNewsBean());
                break;
            case NewsMultiItem.ITEM_TYPE_PHOTO_SET:
                _handleNewsPhotoSet(holder, item.getNewsBean());
                break;
        }
    }

    /**
     * 处理正常的新闻
     *
     * @param holder
     * @param item
     */
    private void _handleNewsNormal(final BaseViewHolder holder, final NewsInfo item) {
        ImageView newsIcon = holder.getView(R.id.iv_icon);
        ImageLoader.loadCenterCrop(mContext, item.getImgsrc(), newsIcon, DefIconFactory.provideIcon());
        holder.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_source, StringUtils.clipNewsSource(item.getSource()))
                .setText(R.id.tv_time, item.getPtime());
        // 设置标签
        if (NewsUtils.isNewsSpecial(item.getSkipType())) {
            LabelView labelView = holder.getView(R.id.label_view);
            labelView.setVisibility(View.VISIBLE);
            labelView.setText("专题");
        } else {
            holder.setVisible(R.id.label_view, false);
        }
        // 波纹效果
        RippleView rippleLayout = holder.getView(R.id.item_ripple);
        rippleLayout.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                if (NewsUtils.isNewsSpecial(item.getSkipType())) {
//                    SpecialActivity.launch(mContext, item.getSpecialID());
                } else {
                    // 旧的实现方式和网易的比较相近，感兴趣的可以切换看看
//                    NewsDetailActivity.launch(mContext, item.getPostid());
//                    NewsArticleActivity.launch(mContext, item.getPostid());
                }
            }
        });
    }

    /**
     * 处理图片的新闻
     *
     * @param holder
     * @param item
     */
    private void _handleNewsPhotoSet(BaseViewHolder holder, final NewsInfo item) {
        ImageView[] newsPhoto = new ImageView[3];
        newsPhoto[0] = holder.getView(R.id.iv_icon_1);
        newsPhoto[1] = holder.getView(R.id.iv_icon_2);
        newsPhoto[2] = holder.getView(R.id.iv_icon_3);
        holder.setVisible(R.id.iv_icon_2, false).setVisible(R.id.iv_icon_3, false);
        ImageLoader.loadCenterCrop(mContext, item.getImgsrc(), newsPhoto[0], DefIconFactory.provideIcon());
        if (!ListUtils.isEmpty(item.getImgextra())) {
            for (int i = 0; i < Math.min(2, item.getImgextra().size()); i++) {
                newsPhoto[i + 1].setVisibility(View.VISIBLE);
                ImageLoader.loadCenterCrop(mContext, item.getImgextra().get(i).getImgsrc(),
                        newsPhoto[i + 1], DefIconFactory.provideIcon());
            }
        }
        holder.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_source, StringUtils.clipNewsSource(item.getSource()))
                .setText(R.id.tv_time, item.getPtime());
        // 波纹效果
        RippleView rippleLayout = holder.getView(R.id.item_ripple);
        rippleLayout.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
//                PhotoSetActivity.launch(mContext, item.getPhotosetID());
            }
        });
    }
}
