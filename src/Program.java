import java.io.*;
import java.util.*;
import Forest.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import modules_for_the_program.*;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class Program extends Application
{
    public static void main (String [] args)
    {
        launch(args);
//        Prog a = new Prog();
//        Logs logs = new Logs();
//        Settings s = new Settings();
//        User user = new User();
//        Date date = new Date();
//        Predators p = new Predators();
//        Herbivores h = new Herbivores();
//        Grass g = new Grass();
//        Trees t = new Trees();




        /*
        a.LogsFileCheckCreation();
        a.UserFileCheckCreation();
        a.LogsFileCheckFilling();
        a.UserFileCheckFilling();
        a.getFlagLogsFileNonEmpty();
        a.getFlagUsersFileNonEmpty();
        a.SettingFileCheckCreation();
        s.ReadFile(s);
        p.PredatorsReadDatabase();
        h.HerbivoresReadDatabase();
        g.GrassReadDatabase();
        t.TreesReadDatabase();
        if(s.getLogs() == true) {
            logs.WriteToLog("***** Начало работы программы  " + " " + date.toString() + " " + "*****" + " \n");
        }
        if(a.getFlagUsersFileNonEmpty() == false ) {
            user.CreateUser(user,s);
        }
        user.ReadDatabase();
        s.ReadFile(s);
        s.PrintSettingFile();
        a.EnterMenu(user,s);
        s.SettingMenu(user, s);
        while (true) {
            a.MainMenu(user , s ,p ,h ,g , t);
        }
        //user.CreateUser();
        //user.PrintToDatabase();
        //user.ReadDatabase();
        //System.out.println(user.toString());

         */

//        // для Hashmap
//        p.Laba4(10);
//        p.Laba4(100);
//        p.Laba4(1000);
//        p.Laba4(10000);
//        p.Laba4(100000);
//        // для ArrayList
//        g.Laba4_list(10);
//        g.Laba4_list(100);
//        g.Laba4_list(1000);
//        g.Laba4_list(10000);
//        g.Laba4_list(100000);
////
//
  }

    @Override
    public void start(Stage stage)  {

        stage.setTitle("Line Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
         final NumberAxis yAxis = new NumberAxis();

        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();
         xAxis.setLabel("Elements");
        final LineChart<String,Number> lineChart2 =
                new LineChart<String,Number>(xAxis2,yAxis2);
         final LineChart<String,Number> lineChart1 =
                new LineChart<String,Number>(xAxis,yAxis);


//        final LineChart<String,Number> lineChart3 =
//                new LineChart<String,Number>(xAxis,yAxis);
//        final LineChart<String,Number> lineChart4 =
//                new LineChart<String,Number>(xAxis,yAxis);
        lineChart2.setTitle("Анализ HashMap и ArrayList");
        lineChart1.setTitle("Анализ HashMap и ArrayList");

//        lineChart3.setTitle("Анализ HashMap и ArrayList");
//        lineChart4.setTitle("Анализ HashMap и ArrayList");

        XYChart.Series series7 = new XYChart.Series();
        series7.setName("HashMap/общее время добавления");
        series7.getData().add(new XYChart.Data("10", 15900));
        series7.getData().add(new XYChart.Data("100", 63400));
        series7.getData().add(new XYChart.Data("1000", 227200));
        series7.getData().add(new XYChart.Data("10000", 2472500));
        series7.getData().add(new XYChart.Data("100000", 19367400));

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("HashMap/среднее время добавления");

//        series1.getData().add(new XYChart.Data("10", 1590));
//        series1.getData().add(new XYChart.Data("100", 634));
//        series1.getData().add(new XYChart.Data("1000", 227));
//        series1.getData().add(new XYChart.Data("10000", 247));
//        series1.getData().add(new XYChart.Data("100000", 193));

        series1.getData().add(new XYChart.Data("10", 15900));
        series1.getData().add(new XYChart.Data("100", 63400));
        series1.getData().add(new XYChart.Data("1000", 227200));
        series1.getData().add(new XYChart.Data("10000", 2472500));
        series1.getData().add(new XYChart.Data("100000", 19367400));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("ArrayList/среднее время добавления");
        series2.getData().add(new XYChart.Data("10", 840));
        series2.getData().add(new XYChart.Data("100", 149));
        series2.getData().add(new XYChart.Data("1000", 121));
        series2.getData().add(new XYChart.Data("10000", 103));
        series2.getData().add(new XYChart.Data("100000", 88));


        XYChart.Series series3 = new XYChart.Series();
        series3.setName("HashMap/среднее время удаления");
        series3.getData().add(new XYChart.Data("10", 14600));
        series3.getData().add(new XYChart.Data("100", 2590));
        series3.getData().add(new XYChart.Data("1000", 795));
        series3.getData().add(new XYChart.Data("10000", 603));
        series3.getData().add(new XYChart.Data("100000", 388));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("ArrayList/среднее время удаления");
        series4.getData().add(new XYChart.Data("10", 196800));
        series4.getData().add(new XYChart.Data("100", 6310));
        series4.getData().add(new XYChart.Data("1000", 21009));
        series4.getData().add(new XYChart.Data("10000", 19781));
        series4.getData().add(new XYChart.Data("100000", 241256));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("HashMap/общее время удаления");
        series5.getData().add(new XYChart.Data("10", 14600));
        series5.getData().add(new XYChart.Data("100", 25900));
        series5.getData().add(new XYChart.Data("1000", 79500));
        series5.getData().add(new XYChart.Data("10000", 603200));
        series5.getData().add(new XYChart.Data("100000", 3881300));

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("ArrayList/общее время удаления");
        series6.getData().add(new XYChart.Data("10", 196800));
        series6.getData().add(new XYChart.Data("100", 63100));
        series6.getData().add(new XYChart.Data("1000", 2100900));
        series6.getData().add(new XYChart.Data("10000", 19781600));
        series6.getData().add(new XYChart.Data("100000", 241256580));



        XYChart.Series series8 = new XYChart.Series();
        series8.setName("ArrayList/общее время добавления");
        series8.getData().add(new XYChart.Data("10", 8400));
        series8.getData().add(new XYChart.Data("100", 14900));
        series8.getData().add(new XYChart.Data("1000", 121000));
        series8.getData().add(new XYChart.Data("10000", 1032200));
        series8.getData().add(new XYChart.Data("100000", 8830600));


        Scene scene  = new Scene(lineChart2,800,800);

        lineChart2.getData().addAll(series1, series2);


        stage.setScene(scene);

        stage.show();
    }
}
