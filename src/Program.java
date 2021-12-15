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


    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Line Chart Sample");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Количество элементов");
        yAxis.setLabel("Время");
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Анализ HashMap и ArrayList");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("HashMap/среднее время добавления");

        series1.getData().add(new XYChart.Data(10, 689210));
        series1.getData().add(new XYChart.Data(100, 6372));
        series1.getData().add(new XYChart.Data(1000, 4810));
        series1.getData().add(new XYChart.Data(10000, 5035));
        series1.getData().add(new XYChart.Data(100000, 606));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("ArrayList/среднее время добавления");
        series2.getData().add(new XYChart.Data(10, 15399));
        series2.getData().add(new XYChart.Data(100, 683));
        series2.getData().add(new XYChart.Data(1000, 627));
        series2.getData().add(new XYChart.Data(10000, 380));
        series2.getData().add(new XYChart.Data(100000, 418));


        XYChart.Series series3 = new XYChart.Series();
        series3.setName("HashMap/среднее время удаления");
        series3.getData().add(new XYChart.Data(10, 22200));
        series3.getData().add(new XYChart.Data(100, 7270));
        series3.getData().add(new XYChart.Data(1000, 4810));
        series3.getData().add(new XYChart.Data(10000, 5035));
        series3.getData().add(new XYChart.Data(100000, 9550));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("ArrayList/среднее время удаления");
        series4.getData().add(new XYChart.Data(10, 186300));
        series4.getData().add(new XYChart.Data(100, 4769));
        series4.getData().add(new XYChart.Data(1000, 28119));
        series4.getData().add(new XYChart.Data(10000, 26258));
        series4.getData().add(new XYChart.Data(100000, 120603));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("HashMap/общее время удаления");
        series5.getData().add(new XYChart.Data(10, 22200));
        series5.getData().add(new XYChart.Data(100, 72700));
        series5.getData().add(new XYChart.Data(1000, 481099));
        series5.getData().add(new XYChart.Data(10000, 5035400));
        series5.getData().add(new XYChart.Data(100000, 95507600));

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("ArrayList/общее время удаления");
        series6.getData().add(new XYChart.Data(10, 186300));
        series6.getData().add(new XYChart.Data(100, 47699));
        series6.getData().add(new XYChart.Data(1000, 2811999));
        series6.getData().add(new XYChart.Data(10000, 26258400));
        series6.getData().add(new XYChart.Data(100000, 1206035500));

        XYChart.Series series7 = new XYChart.Series();
        series7.setName("HashMap/общее время добавления");
        series7.getData().add(new XYChart.Data(10, 6892100));
        series7.getData().add(new XYChart.Data(100, 637200));
        series7.getData().add(new XYChart.Data(1000, 3791200));
        series7.getData().add(new XYChart.Data(10000, 11183900));
        series7.getData().add(new XYChart.Data(100000, 60635200));

        XYChart.Series series8 = new XYChart.Series();
        series8.setName("ArrayList/общее время добавления");
        series8.getData().add(new XYChart.Data(10, 153999));
        series8.getData().add(new XYChart.Data(100, 68300));
        series8.getData().add(new XYChart.Data(1000, 627601));
        series8.getData().add(new XYChart.Data(10000, 3801799));
        series8.getData().add(new XYChart.Data(100000, 41892400));
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1, series2, series3, series4);

        stage.setScene(scene);
        stage.show();
    }
}
