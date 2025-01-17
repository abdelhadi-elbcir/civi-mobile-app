package ma.civi.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ma.civi.app.R;
import ma.civi.app.adapters.SkillsAdapter;

import java.util.ArrayList;
import java.util.List;

public class SkillsFragment extends Fragment {

    private EditText etSkill;
    private Button btnAddSkill, btnGenerateResume;
    private RecyclerView rvSkills;
    private SkillsAdapter adapter;
    private List<String> skillsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills, container, false);

        // Initialize UI components
        etSkill = view.findViewById(R.id.etSkill);
        btnAddSkill = view.findViewById(R.id.btnAddSkill);
        btnGenerateResume = view.findViewById(R.id.btnGenerateResume);
        rvSkills = view.findViewById(R.id.rvSkills);

        // Initialize data list and adapter
        skillsList = new ArrayList<>();
        adapter = new SkillsAdapter(skillsList);
        rvSkills.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSkills.setAdapter(adapter);

        // Handle Add Skill button click
        btnAddSkill.setOnClickListener(v -> {
            String skill = etSkill.getText().toString().trim();
            if (skill.isEmpty()) {
                Toast.makeText(getContext(), "Please enter a skill", Toast.LENGTH_SHORT).show();
            } else {
                skillsList.add(skill);
                adapter.notifyDataSetChanged();
                etSkill.setText(""); // Clear input after adding
            }
        });

        // Handle Generate Resume button click
        btnGenerateResume.setOnClickListener(v -> {
            // TODO: Implement PDF generation functionality
            Toast.makeText(getContext(), "Resume generation is not implemented yet", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
