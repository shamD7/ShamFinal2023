package sham.dawod.shamfinal2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class addDish extends AppCompatActivity
{
    private TextInputEditText etMealName;
    private TextInputEditText etMealPrice;
    private TextInputEditText etMealIngred;
    private Spinner spnrMeals;
    private ImageButton MealImage;
    private Button btnSaveM;
    private Button btnCancelM;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meal);
        etMealName=findViewById(R.id.etMealName);
        etMealPrice=findViewById(R.id.etMealPrice);
        etMealIngred=findViewById(R.id.etMealIngredients);
        spnrMeals=findViewById(R.id.spnrMeals);
        MealImage=findViewById(R.id.MealImage);
        btnSaveM=findViewById(R.id.btnSaveM);
        btnCancelM=findViewById(R.id.btnCancelM);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meal);
        //spnr2 وضع مؤشر الصفة على الكائن المرئي الموجود بواجهة المستعمل
        spnrMeals=findViewById(R.id.spnrMeals);
        //spnr3 بناء الوسيط وتحديد واجهة تنسيق لمعطى واحد
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr4 data source مصدر معطيات (ممكن ان يكون قائمة من قاعدة بيانات مثلا)
        String []ar={"Appetizers","Main dish","Dessert","Drink",};
        //spnr5 تحديد المعطيات للوسيط
        adapter.addAll(ar);
        //spnr6 ربط الكائن المرئي بالوسيط
        spnrMeals.setAdapter(adapter);
    }



}