package ma.civi.app.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import ma.civi.app.R;

public class PersonalInfoFragment extends Fragment {

    private EditText etName, etEmail, etPhone, etAddress;
    private Button btnSavePersonalInfo, btnGoToEducation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);

        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etAddress = view.findViewById(R.id.etAddress);
        btnSavePersonalInfo = view.findViewById(R.id.btnSavePersonalInfo);
        btnGoToEducation = view.findViewById(R.id.btnGoToEducation);

        btnSavePersonalInfo.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String address = etAddress.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Personal information saved", Toast.LENGTH_SHORT).show();
                // Pass or store the data (e.g., ViewModel, SharedPreferences, etc.)
            }
        });

        btnGoToEducation.setOnClickListener(v -> {
            Fragment educationFragment = new EducationFragment(); // Replace with your fragment class
            FragmentTransaction transaction = requireFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, educationFragment); // Ensure your container ID is correct
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }
}
