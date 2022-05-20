package com.example.yogatrain.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yogatrain.Adapters.LibAdapter;
import com.example.yogatrain.HomeActivity;
import com.example.yogatrain.LibModel;
import com.example.yogatrain.R;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {



    List<LibModel> list=new ArrayList<>();
    LibAdapter adapter;
    RecyclerView rv;
    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_library, container, false);
        HomeActivity.Rl.setBackgroundColor(Color.parseColor("#ffbbbb"));
        rv=view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        list.add(new LibModel("Push-ups","1. Get down on all fours, placing your hands slightly wider than your shoulders. \n" +
                "2. Straighten your arms and legs. \n" +
                "3. Lower your body until your chest nearly touches the floor. \n" +
                "4. Pause, then push yourself back up. \n" +
                "5. Repeat.  \n",R.drawable.push_up));

        list.add(new LibModel("Lotus","1.Sit on the floor with your legs straight out in front of you, back straight and arms at your sides.\n" +
                "2. Bend your right knee and bring it into your chest. Gently pull your right ankle to the crease of your left hip\n" +
                "3.Bend your left knee and pull into your chest, resting it in the hip crease. Rest your hands on your knees with palms facing the sky.\n",R.drawable.lotus));
        list.add(new LibModel("Warrior 1","1.From Adho Mukha Svanasana (Downward-Facing Dog Pose), step your right foot forward so your toes are in line with your fingertips, and shift your foot slightly to the right.\n" +
                "\n" +
                "2.Bend your front knee 90 degrees. Your thigh should be approximately parallel to the floor, your knee stacked\n" +
                " \n" +
                "3.over your ankle, and  your right outer hip pinned back.\n" +
                "Pivot your left heel to the floor so your foot forms a 45-degree angle to the side of the mat.  Align your left heel with your right heel, or place the feet slightly wider for more stability.\n" +
                "\n" +
                "4.Press your left thighbone back so your left knee is straight.\n" +
                "\n" +
                "5.As you inhale, raise your torso and reach up with the arms, hands shoulder-distance apart and palms facing each other. Allow your shoulder blades to open out and up, away from your spine and toward your outer armpits. \n" +
                "\n" +
                "6.Rotate your biceps back, and firm your triceps into your midline. You may bring your palms together and look up at your thumbs.\n" +
                "\n" +
                "7.Keep pressing your left femur back while releasing your tailbone toward the floor. Draw your lower belly back and up away from your right thigh.\n" +
                "\n" +
                "8.Hold for 5–10 breaths.\n" +
                "\n" +
                "9.Release your hands to the floor, step back to Downward-Facing Dog, and repeat on the other side.\n",R.drawable.warrior1));
        list.add(new LibModel("Warrior II","1. Face the long side of your mat with your arms stretched\n" +
                " straight out from your shoulders and your feet parallel \n" +
                "to each other in a wide stance. You want your ankles \n" +
                "beneath your wrists.\n" +
                "\n" +
                "2. Turn your right foot and knee to face the front of the\n" +
                " mat.\n" +
                "\n" +
                "3. Angle your left toes slightly in toward the upper left \n" +
                "corner of the mat.\n" +
                "\n" +
                "4. Bend your right knee and stack it over your right ankle.\n" +
                "\n" +
                "5.Distribute your weight evenly between both legs. Press\n" +
                "down through the outer edge of your back foot.\n" +
                "\n" +
                "6.Keep the crown of your head stacked over your pelvis and\n" +
                " your shoulders over your hips.\n" +
                "\n" +
                "7. Reach strongly through both arms toward the front and \n" +
                "back of the mat and turn your head to look past your right \n" +
                "fingertips.\n" +
                "\n" +
                "8. Stay here for 5–10 breaths.\n" +
                "\n" +
                "9. To come out of the pose, exhale as you press down\n" +
                "through your feet, then inhale and straighten your legs. \n" +
                "Return your feet to parallel facing the left long side of the mat.\n" +
                "\n" +
                "10. Repeat on the other side.\n",R.drawable.warrior2));
        list.add(new LibModel("Tree","1.Stand in Tadasana. Spread your toes, press your feet into the mat and firm your leg muscles. Raise your front hip points toward your lower ribs to gently lift in your lower belly.\n" +
                "\n" +
                "2.Inhale deeply, lifting your chest, and exhale as you draw your shoulder blades down your back. Look straight ahead at a steady gazing spot.\n" +
                "\n" +
                "3.Place your hands on your hips and raise your right foot high onto your left thigh or shin. Avoid making contact with the knee.\n" +
                "\n" +
                "4.Press your right foot and left leg into each other.\n" +
                "\n" +
                "5.Check that your pelvis is level and squared to the front.\n" +
                "\n" +
                "6.When you feel steady, place your hands into Anjali Mudra at the heart or stretch your arms overhead like branches reaching into the sun.\n" +
                "\n" +
                "7.Hold for several breaths, then step back into Mountain Pose and repeat on the other side.\n",R.drawable.tree));
        list.add(new LibModel("DownDog","1.Come onto your hands and knees, with your hands a tiny bit in front of your shoulders and your knees directly below your hips. Spread your palms, rooting down through all four corners of your hands, and turn your toes under.\n" +
                "\n" +
                "2.Exhale and lift your knees from the floor, at first keeping your knees slightly bent and your heels lifted off the floor. Lengthen your tailbone away from the back of your pelvis, lift the sitting bones toward the ceiling, and draw your inner legs from your inner ankles up through your groins.\n" +
                "\n" +
                "3.On an exhalation, push your top thighs back and stretch your heels toward the floor. Straighten your knees without locking them.\n" +
                "\n" +
                "4.Firm your outer arms and press the bases of your index fingers actively into the floor. Lift along your inner arms from the wrists to the tops of the shoulders. Firm your shoulder blades against your back, then widen them and draw them toward your tailbone. Keep your head between your upper arms.\n" +
                "\n" +
                "5.Stay in the pose for 10 or more breaths, then bend your knees on an exhalation and lower yourself into Child’s Pose\n",R.drawable.dog));

        list.add(new LibModel("Cobra ","1. Lie on your belly.\n" +
                "\n" +
                "2. Come onto your forearms, with your elbows directly under your shoulders and parallel to each other.\n" +
                "\n" +
                "3. Stretch your legs straight back, about hip-width apart.\n" +
                "\n" +
                "4. Spread your toes wide and press the tops of your feet into your mat.\n" +
                "\n" +
                "5. Firm your legs, and roll your inner thighs up, your outer thighs down. Press your tailbone toward your feet, lengthening your lower back.\n" +
                "\n" +
                "6. Press down into your forearms to lift your chest up.\n",R.drawable.yoga));


        adapter=new LibAdapter(list,getContext());
        rv.setAdapter(adapter);



        return view;
    }
}