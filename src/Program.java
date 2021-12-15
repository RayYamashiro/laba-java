import java.io.*;
import java.util.*;
import Forest.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import modules_for_the_program.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class Program extends Application
{
    public static void main (String [] args)
    {

        Prog a = new Prog();
        Logs logs = new Logs();
        Settings s = new Settings();
        User user = new User();
        Date date = new Date();
        Predators p = new Predators();
        Herbivores h = new Herbivores();
        Grass g = new Grass();
        Trees t = new Trees();



        launch(args);


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

        // для Hashmap
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


    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Line Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Portfolio 1");

        series1.getData().add(new XYChart.Data("Jan", 23));
        series1.getData().add(new XYChart.Data("Feb", 14));
        series1.getData().add(new XYChart.Data("Mar", 15));
        series1.getData().add(new XYChart.Data("Apr", 24));
        series1.getData().add(new XYChart.Data("May", 34));
        series1.getData().add(new XYChart.Data("Jun", 36));
        series1.getData().add(new XYChart.Data("Jul", 22));
        series1.getData().add(new XYChart.Data("Aug", 45));
        series1.getData().add(new XYChart.Data("Sep", 43));
        series1.getData().add(new XYChart.Data("Oct", 17));
        series1.getData().add(new XYChart.Data("Nov", 29));
        series1.getData().add(new XYChart.Data("Dec", 25));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Portfolio 2");
        series2.getData().add(new XYChart.Data("Jan", 33));
        series2.getData().add(new XYChart.Data("Feb", 34));
        series2.getData().add(new XYChart.Data("Mar", 25));
        series2.getData().add(new XYChart.Data("Apr", 44));
        series2.getData().add(new XYChart.Data("May", 39));
        series2.getData().add(new XYChart.Data("Jun", 16));
        series2.getData().add(new XYChart.Data("Jul", 55));
        series2.getData().add(new XYChart.Data("Aug", 54));
        series2.getData().add(new XYChart.Data("Sep", 48));
        series2.getData().add(new XYChart.Data("Oct", 27));
        series2.getData().add(new XYChart.Data("Nov", 37));
        series2.getData().add(new XYChart.Data("Dec", 29));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Portfolio 3");
        series3.getData().add(new XYChart.Data("Jan", 44));
        series3.getData().add(new XYChart.Data("Feb", 35));
        series3.getData().add(new XYChart.Data("Mar", 36));
        series3.getData().add(new XYChart.Data("Apr", 33));
        series3.getData().add(new XYChart.Data("May", 31));
        series3.getData().add(new XYChart.Data("Jun", 26));
        series3.getData().add(new XYChart.Data("Jul", 22));
        series3.getData().add(new XYChart.Data("Aug", 25));
        series3.getData().add(new XYChart.Data("Sep", 43));
        series3.getData().add(new XYChart.Data("Oct", 44));
        series3.getData().add(new XYChart.Data("Nov", 45));
        series3.getData().add(new XYChart.Data("Dec", 44));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3);

        stage.setScene(scene);
        stage.show();
    }
}
