package ma.civi.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import ma.civi.app.fragments.PersonalInfoFragment;
import ma.civi.app.fragments.EducationFragment;
import ma.civi.app.fragments.ExperienceFragment;
import ma.civi.app.fragments.SkillsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the first fragment (Personal Info) when the activity starts
        if (savedInstanceState == null) {
            loadFragment(new PersonalInfoFragment());
        }
    }

    /**
     * Method to load a fragment into the main container
     * @param fragment Fragment to load
     */
    public void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    /**
     * Method to navigate to the next fragment based on user flow
     * @param step Current step (to determine which fragment to load next)
     */
    public void navigateToNext(int step) {
        Fragment nextFragment;
        switch (step) {
            case 1: // From PersonalInfoFragment to EducationFragment
                nextFragment = new EducationFragment();
                break;
            case 2: // From EducationFragment to ExperienceFragment
                nextFragment = new ExperienceFragment();
                break;
            case 3: // From ExperienceFragment to SkillsFragment
                nextFragment = new SkillsFragment();
                break;
            default: // Default is PersonalInfoFragment
                nextFragment = new PersonalInfoFragment();
                break;
        }
        loadFragment(nextFragment);
    }
}
