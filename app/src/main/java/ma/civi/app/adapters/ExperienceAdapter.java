package ma.civi.app.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ma.civi.app.R;
import ma.civi.app.models.Experience;

import java.util.List;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder> {

    private final List<Experience> experienceList;

    public ExperienceAdapter(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    @NonNull
    @Override
    public ExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_experience, parent, false);
        return new ExperienceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienceViewHolder holder, int position) {
        Experience experience = experienceList.get(position);
        holder.tvJobTitle.setText(experience.getJobTitle());
        holder.tvCompanyName.setText(experience.getCompanyName());
        holder.tvDates.setText(String.format("%s - %s", experience.getStartDate(), experience.getEndDate()));
        holder.tvDescription.setText(experience.getDescription());
    }

    @Override
    public int getItemCount() {
        return experienceList.size();
    }

    public static class ExperienceViewHolder extends RecyclerView.ViewHolder {
        TextView tvJobTitle, tvCompanyName, tvDates, tvDescription;

        public ExperienceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJobTitle = itemView.findViewById(R.id.tvJobTitle);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvDates = itemView.findViewById(R.id.tvDates);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
