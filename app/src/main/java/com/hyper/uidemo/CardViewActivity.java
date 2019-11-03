package com.hyper.uidemo;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends Activity {
  private List<Image> images;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recycler_view_activity);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    images = new ArrayList<Image>();
    images.add(new Image(R.drawable.cat_128px, "Cat1"));
    images.add(new Image(R.drawable.cat_128px, "Cat2"));
    images.add(new Image(R.drawable.cat_128px, "Cat3"));
    images.add(new Image(R.drawable.cat_128px, "Cat4"));
    images.add(new Image(R.drawable.cat_128px, "Cat5"));
    images.add(new Image(R.drawable.cat_128px, "Cat6"));
    images.add(new Image(R.drawable.cat_128px, "Cat7"));
    images.add(new Image(R.drawable.cat_128px, "Cat8"));
    images.add(new Image(R.drawable.cat_128px, "Cat9"));
    images.add(new Image(R.drawable.cat_128px, "Cat10"));
    images.add(new Image(R.drawable.cat_128px, "Cat11"));
    images.add(new Image(R.drawable.cat_128px, "Cat12"));
    images.add(new Image(R.drawable.cat_128px, "Cat13"));
    images.add(new Image(R.drawable.cat_128px, "Cat14"));
    images.add(new Image(R.drawable.cat_128px, "Cat15"));
    images.add(new Image(R.drawable.cat_128px, "Cat16"));
    images.add(new Image(R.drawable.cat_128px, "Cat17"));
    images.add(new Image(R.drawable.cat_128px, "Cat18"));
    images.add(new Image(R.drawable.cat_128px, "Cat19"));
    images.add(new Image(R.drawable.cat_128px, "Cat20"));
    images.add(new Image(R.drawable.cat_128px, "Cat21"));
    images.add(new Image(R.drawable.cat_128px, "Cat22"));

    //recyclerView.setLayoutManager(new LinearLayoutManager(CardViewActivity.this));
    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    recyclerView.addItemDecoration(new ImageItemDecoration(20));

    recyclerView.setAdapter(new ImageAdapter());
  }

  class ImageItemDecoration extends RecyclerView.ItemDecoration {
    int space;

    //custmozed space
    public ImageItemDecoration(int space) {
      this.space = space;
    }

    /**
     * @param outRect outside space
     * @param view    outside layout view
     * @param parent  parent container of card
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
      super.getItemOffsets(outRect, view, parent, state);
      if (parent.getChildAdapterPosition(view) % 2 == 0) {
        outRect.top = 50;
      } else {
        outRect.top = space;
      }
      outRect.bottom = space;
      outRect.left = space;
      outRect.right = space;
    }
  }

  class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(CardViewActivity.this).inflate(R.layout.card_view, null);
      return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
      Image image = images.get(position);
      holder.image.setImageResource(image.getId());
      holder.text.setText(image.getName());
    }

    @Override
    public int getItemCount() {
      return images.size();
    }
  }

  class ImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView text;

    public ImageViewHolder(View itemView) {
      super(itemView);
      this.image = (ImageView) itemView.findViewById(R.id.cardViewItemImage);
      this.text = (TextView) itemView.findViewById(R.id.cardViewItemText);
    }
  }

  class Image {
    private int id;
    private String name;

    public Image(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
