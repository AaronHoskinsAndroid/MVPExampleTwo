package examples.aaronhoskins.com.mvpexample.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import examples.aaronhoskins.com.mvpexample.R;
import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.RandomUserResults;
import examples.aaronhoskins.com.mvpexample.model.datasource.randomuser.Result;


public class RandomUserResultsRecyclerViewAdapter
        extends RecyclerView.Adapter<RandomUserResultsRecyclerViewAdapter.ViewHolder> {

    RandomUserResults randomUserResults;

    public RandomUserResultsRecyclerViewAdapter(RandomUserResults randomUserResults) {
        this.randomUserResults = randomUserResults;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.random_user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result currentBindingResult = randomUserResults.getResults().get(position);
        Glide
                .with(holder.itemView)
                .load(currentBindingResult.getPicture().getThumbnail())
                .into(holder.imgRandomUserImage);
        holder.tvUserName.setText(currentBindingResult.getName().getFirst());
        holder.tvUserEmail.setText(currentBindingResult.getEmail());
        holder.tvUserDateOfBirth.setText(currentBindingResult.getDob().getDate());


    }

    @Override
    public int getItemCount() {
        return randomUserResults.getResults().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRandomUserImage;
        TextView tvUserName;
        TextView tvUserEmail;
        TextView tvUserDateOfBirth;
        public ViewHolder(View itemView)  {
            super(itemView);
            imgRandomUserImage = itemView.findViewById(R.id.imgRandomUser);
           tvUserName = itemView.findViewById(R.id.tvUserName);
           tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
           tvUserDateOfBirth = itemView.findViewById(R.id.tvDateOfBirth);
        }


    }
}
