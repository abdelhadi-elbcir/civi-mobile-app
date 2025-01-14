package ma.civi.app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ma.civi.app.R;
import ma.civi.app.adapters.ExperienceAdapter;
import ma.civi.app.models.Experience;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class ExperienceFragment extends Fragment {

    private EditText etJobTitle, etCompanyName, etStartDate, etEndDate, etDescription;
    private Button btnAddExperience, btnNext;
    private RecyclerView rvExperience;
    private ExperienceAdapter adapter;
    private List<Experience> experienceList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_experience, container, false);

        etJobTitle = view.findViewById(R.id.etJobTitle);
        etCompanyName = view.findViewById(R.id.etCompanyName);
        etStartDate = view.findViewById(R.id.etStartDate);
        etEndDate = view.findViewById(R.id.etEndDate);
        etDescription = view.findViewById(R.id.etDescription);
        btnAddExperience = view.findViewById(R.id.btnAddExperience);
        btnNext = view.findViewById(R.id.btnNext);
        rvExperience = view.findViewById(R.id.rvExperience);

        experienceList = new ArrayList<>();
        adapter = new ExperienceAdapter(experienceList);
        rvExperience.setLayoutManager(new LinearLayoutManager(getContext()));
        rvExperience.setAdapter(adapter);

        btnAddExperience.setOnClickListener(v -> {
            String jobTitle = etJobTitle.getText().toString();
            String companyName = etCompanyName.getText().toString();
            String startDate = etStartDate.getText().toString();
            String endDate = etEndDate.getText().toString();
            String description = etDescription.getText().toString();

            if (jobTitle.isEmpty() || companyName.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || description.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Experience experience = new Experience(jobTitle, companyName, startDate, endDate, description);
                experienceList.add(experience);
                adapter.notifyDataSetChanged();
            }
        });

        btnNext.setOnClickListener(v -> {
            // Pass data or navigate to the next fragment
        });

        return view;
    }
}
