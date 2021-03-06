package com.dtalk.dd.ui.widget.circle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dtalk.dd.R;
import com.dtalk.dd.http.moment.Moment;
import com.dtalk.dd.utils.StringUtils;

/**
 * Created by Donal on 16/7/29.
 */
public class LongtxtCircleRenderView extends BaseCircleRenderView {
    ImageView imgCover;
    TextView tvTitle;

    public LongtxtCircleRenderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public static LongtxtCircleRenderView inflater(Context context,ViewGroup viewGroup){
        int resource = R.layout.circle_longtxt_item;
        LongtxtCircleRenderView longtxtCircleRenderView = (LongtxtCircleRenderView) LayoutInflater.from(context).inflate(resource, viewGroup, false);
        longtxtCircleRenderView.setParentView(viewGroup);
        return longtxtCircleRenderView;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imgCover = (ImageView) findViewById(R.id.imgCover);
        tvTitle = (TextView) findViewById(R.id.tvContent);
    }

    @Override
    public void render(Moment moment, Context ctx) {
        super.render(moment, ctx);
        getContent().setText(moment.title);
        if (StringUtils.notEmpty(moment.title)) {
            getContent().setVisibility(VISIBLE);
        }
        else {
            getContent().setVisibility(GONE);
        }
        setImageGlide(ctx, moment.cover, imgCover);
        tvTitle.setText(moment.title);
    }

    public ViewGroup getParentView() {
        return parentView;
    }

    public void setParentView(ViewGroup parentView) {
        this.parentView = parentView;
    }

}
