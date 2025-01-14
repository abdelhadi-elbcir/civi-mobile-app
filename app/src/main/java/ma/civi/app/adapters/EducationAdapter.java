package ma.civi.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ma.civi.app.R;
import ma.civi.app.models.Education;

import java.util.List;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.EducationViewHolder> {

    private final List<Education> educationList;

    public EducationAdapter(List<Education> educationList) {
        this.educationList = educationList;
    }

    @NonNull
    @Override
    public EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_education, parent, false);
        return new EducationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EducationViewHolder holder, int position) {
        Education education = educationList.get(position);
        holder.tvDegree.setText(education.getDegree());
        holder.tvInstitution.setText(education.getInstitution());
        holder.tvYears.setText(String.format("%s - %s", education.getStartYear(), education.getEndYear()));
    }

    @Override
    public int getItemCount() {
        return educationList.size();
    }

    public static class EducationViewHolder extends RecyclerView.ViewHolder {
        TextView tvDegree, tvInstitution, tvYears;

        public EducationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDegree = itemView.findViewById(R.id.tvDegree);
            tvInstitution = itemView.findViewById(R.id.tvInstitution);
            tvYears = itemView.findViewById(R.id.tvYears);
        }
    }
}
