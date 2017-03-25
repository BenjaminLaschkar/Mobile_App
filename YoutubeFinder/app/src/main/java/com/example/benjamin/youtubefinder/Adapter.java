package com.example.benjamin.youtubefinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.R.attr.thumbnail;

/**
 * Created by Benjamin on 25/03/2017.
 */

public class Adapter extends BaseAdapter {

    private List<Response.ItemsBean> mVideoitem;
    private Context mContext;

    public Adapter(Context mContext, List<Response.ItemsBean> mVideoitem)
    {
        this.mContext = mContext;
        this.mVideoitem = mVideoitem;
    }
    @Override
    public int getCount() {
        return mVideoitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mVideoitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parents)
    {
        LayoutInflater flat = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View views = flat.inflate(R.layout.adapter_layout, parents, false);
        Response.ItemsBean item = (Response.ItemsBean) getItem(pos);

        ImageView imageView = (ImageView) views.findViewById(R.id.imageView);
        TextView titre = (TextView) views.findViewById(R.id.titre);
        TextView description = (TextView) views.findViewById(R.id.description);
        TextView chaine = (TextView) views.findViewById(R.id.chaine);
        TextView id = (TextView) views.findViewById(R.id.id); // Nom de variable pas terrible ici

        titre.setText(item.getSnippet().getTitle());
        id.setText(item.getId().getVideoId());
        description.setText(item.getSnippet().getDescription());
        chaine.setText(item.getSnippet().getChannelTitle());
        String imageUrl = item.getSnippet().getThumbnails().getHigh().getUrl();
        Picasso.with(mContext).load(imageUrl).into(imageView);
        return views;
    }


}
