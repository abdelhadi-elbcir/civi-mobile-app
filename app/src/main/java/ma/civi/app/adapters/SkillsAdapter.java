package ma.civi.app.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ma.civi.app.R;

import java.util.List;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder> {

    private final List<String> skillsList;

    public SkillsAdapter(List<String> skillsList) {
        this.skillsList = skillsList;
    }

    @NonNull
    @Override
    public SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skill, parent, false);
        return new SkillsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsViewHolder holder, int position) {
        String skill = skillsList.get(position);
        holder.tvSkill.setText(skill);
    }

    @Override
    public int getItemCount() {
        return skillsList.size();
    }

    public static class SkillsViewHolder extends RecyclerView.ViewHolder {
        TextView tvSkill;

        public SkillsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSkill = itemView.findViewById(R.id.tvSkill);
        }
    }
}
