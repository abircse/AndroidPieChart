package abircse.androidpiechart.androidpiechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // dummy value for pie chart
    Float value[] = {10.5F,2.10F,5.0F,19.2F};
    String name[] = {"FOOD","MEDICAL","TRAVEL","PARTY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupPiceChar();


    }

        //---- Method for maintain Pie chart
    private void setupPiceChar() {

        List<PieEntry> pieEntries = new ArrayList<>();

        for (int i = 0 ; i < value.length; i++)
        {
            pieEntries.add(new PieEntry(value[i],name[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries,"EXPENSE PIE");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setSliceSpace(4);


        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);

        // get chart
        PieChart chart = findViewById(R.id.piechat);
        chart.setData(data);
        chart.setDescription(null);
        chart.getLegend().setEnabled(false);
        chart.setCenterText("Expense Tracker");
        chart.setCenterTextSize(15);
        chart.setCenterTextColor(R.color.colorPrimary);


        chart.invalidate();



    }
}
