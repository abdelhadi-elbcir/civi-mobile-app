package ma.civi.app.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ma.civi.app.R;
import ma.civi.app.adapters.EducationAdapter;
import ma.civi.app.models.Education;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EducationFragment extends Fragment {

    private EditText etDegree, etInstitution, etStartYear, etEndYear;
    private Button btnAddEducation, btnNext;
    private RecyclerView rvEducation;
    private EducationAdapter adapter;
    private List<Education> educationList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);

        // Initialize UI components
        etDegree = view.findViewById(R.id.etDegree);
        etInstitution = view.findViewById(R.id.etInstitution);
        etStartYear = view.findViewById(R.id.etStartYear);
        etEndYear = view.findViewById(R.id.etEndYear);
        btnAddEducation = view.findViewById(R.id.btnAddEducation);
        btnNext = view.findViewById(R.id.btnNext);
        rvEducation = view.findViewById(R.id.rvEducation);

        // Set up RecyclerView and Adapter
        educationList = new ArrayList<>();
        adapter = new EducationAdapter(educationList);
        rvEducation.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEducation.setAdapter(adapter);

        // Add education to list on button click
        btnAddEducation.setOnClickListener(v -> {
            String degree = etDegree.getText().toString().trim();
            String institution = etInstitution.getText().toString().trim();
            String startYear = etStartYear.getText().toString().trim();
            String endYear = etEndYear.getText().toString().trim();

            if (degree.isEmpty() || institution.isEmpty() || startYear.isEmpty() || endYear.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Education education = new Education(degree, institution, startYear, endYear);
                educationList.add(education);
                adapter.notifyDataSetChanged();
                clearInputFields();
            }
        });

        btnNext.setOnClickListener(v -> {
            Fragment expFragment = new ExperienceFragment(); // Replace with your fragment class
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, expFragment); // Ensure your container ID is correct
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }

    private void clearInputFields() {
        etDegree.setText("");
        etInstitution.setText("");
        etStartYear.setText("");
        etEndYear.setText("");
    }
}
