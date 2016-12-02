package com.graphdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = (GraphView)findViewById(R.id.my_graph);
        LineGraphSeries<DataPoint> series=new LineGraphSeries<>();
        BarGraphSeries<DataPoint>seriesBar = new BarGraphSeries<>();

        for (int i = 0; i <11 ; i++) {
            //scroll to end - разрешить прокручивать до конца
            //silent разрешить перерисовывать
            series.appendData(new DataPoint(i,i*i),true,10,false);
            seriesBar.appendData(new DataPoint(i,i+i+i),true,10,false);

        }

        graph.addSeries(series);
        graph.addSeries(seriesBar);


        seriesBar.setSpacing(1);
        seriesBar.setDataWidth(1);
        //отвечает за окно в котором видим график
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(10);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxY(150.0);
        graph.getViewport().setMinY(0.0);
        //цвет графика
        series.setColor(Color.RED);
        //толщина
        series.setThickness(7);


        //можно масштабировать
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScrollableY(true);
    }
}
