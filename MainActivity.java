package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    private static final String TAG = "Whack-A-Mole!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        TextView score = (TextView)findViewById(R.id.score);
        score.setText("0");
        updateScore();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Button left = (Button)findViewById(R.id.left);
        Button center = (Button)findViewById(R.id.center);
        Button right = (Button)findViewById(R.id.right);
        Random ran = new Random();

        int randomLocation = ran.nextInt(3);
        if(randomLocation == 0){
            left.setText("*");
            center.setText("O");
            right.setText("O");

        }
        else if(randomLocation == 1){
            left.setText("O");
            center.setText("*");
            right.setText("O");
        }
        else{
            left.setText("O");
            center.setText("O");
            right.setText("*");
        }

    }

    public void updateScore()
    {
        final Button left = (Button)findViewById(R.id.left);
        final Button center = (Button)findViewById(R.id.center);
        final Button right = (Button)findViewById(R.id.right);
        final TextView score = (TextView)findViewById(R.id.score);
        final int[] count = {0};
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Left Button Clicked!");
                if(left.getText() == "*"){
                    Log.v(TAG, "Hit, Score added!");
                    count[0] += 1;
                }
                else{
                    Log.v(TAG, "Missed, Score deducted!");
                    count[0] -= 1;
                }
                score.setText(String.valueOf(count[0]));
                setNewMole();
            }
        });
        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Middle Button Clicked!");
                if(center.getText() == "*"){
                    Log.v(TAG, "Hit, Score added!");
                    count[0] += 1;
                }
                else{
                    Log.v(TAG, "Missed, Score deducted!");
                    count[0] -= 1;
                }
                score.setText(String.valueOf(count[0]));
                setNewMole();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Right Button Clicked!");
                if(right.getText() == "*"){
                    Log.v(TAG, "Hit, Score added!");
                    count[0] += 1;
                }
                else{
                    Log.v(TAG, "Missed, Score deducted!");
                    count[0] -= 1;
                }
                score.setText(String.valueOf(count[0]));
                setNewMole();
            }
        });

    }
}
