package cimdata.android.dez2017.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cimdata.android.dez2017.recyclerview.R;
import cimdata.android.dez2017.recyclerview.activities.MainActivity;
import cimdata.android.dez2017.recyclerview.models.AnimalImages;

/**
 * Created by Student on 13.12.2017.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ListViewHolder> {

    LayoutInflater layoutInflater;
    AnimalImages[] animalImages;
    Context context;

    public ListViewAdapter(Context context, AnimalImages[] images) {
        this.animalImages = images;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView = layoutInflater.inflate(
                R.layout.list_view_item,    // Das Layout, dass eine Zelle anzeigt
                parent,
                false);         // Mit true klappt es nicht
        return new ListViewHolder(context,listView);
    }





    // Hier verknüpfen wir die Daten
    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        AnimalImages currentImage = animalImages[position];
        holder.displayData(currentImage);
    }
    @Override
    public int getItemCount() {

        return animalImages.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView titleText;
        private ImageView image;
        private Context context;

        public ListViewHolder(Context context,View itemView) {
            super(itemView);

            this.titleText = itemView.findViewById(R.id.txt_vlist_title);
            this.image = itemView.findViewById(R.id.img_vlist_image);
            this.context = context;
        }
        public void displayData(AnimalImages animalimage){
            int drawableId = context.getResources().getIdentifier(animalimage.getImageName(),
                    "drawable",
                    context.getPackageName()
                    );


            titleText.setText(animalimage.getName());
            image.setImageResource(drawableId);
        }




    }


}
