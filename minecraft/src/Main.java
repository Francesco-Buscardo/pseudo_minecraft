import Data.Blocks.Exceptions.BlockErrorException;
import Data.UI.MainView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("MINECRAFT");
        Group g = new Group();
        Scene scene1 = new Scene(g);
        scene1.setFill(Paint.valueOf("lightblue"));

        stage.setScene(scene1);
        stage.show();
    }

    public static void main (String[] args) {

        launch(args);

        // CREO UNA MAPPA CASUALE
        map();
        System.out.println();
    }
    // PROCEDURA CHE STAMPA LA MAPPA
    static public void map () {

        MainView M = new MainView();
        M.DisplayMap();
        M.DisplayInventory();
        System.out.println();

        System.out.print("\nEnter row and then column: ");
        Scanner myObj = new Scanner(System.in);
        int row = myObj.nextInt();
        int col = myObj.nextInt();
        try {
            M.move_into_inventory(row, col);
        } catch (BlockErrorException blockErrorException) {
            System.out.println("NOT SMELTABLE BLOCK!");
            blockErrorException.printStackTrace();
        } finally {
            M.DisplayMap();
            M.DisplayInventory();
        }

        /*
        System.out.print("Ins index in cui inserire l'output di furnace: ");
        Scanner s = new Scanner(System.in);
        int indx = s.nextInt();
        M.move_into_inventory_furnace(indx);
        M.DisplayInventory();
        */

        /*
        for (int i = 0 ; i <  1 ; i++) {
            System.out.print("Enter index: ");
            Scanner myObj = new Scanner(System.in);
            int index = myObj.nextInt();
            M.move_into_furnace_inventory(index);
            M.DisplayInventory();
        }
        */

        Scanner s = new Scanner(System.in);
        System.out.print("Ins coord in map per vedere se map[i][j] is pickeable: ");
        int r = s.nextInt();
        int c = s.nextInt();
        try {
            System.out.println(M.gimme_pickable(r, c));
        } catch (BlockErrorException blockErrorException) {
            System.out.println("NOT PICKEABLE BLOCK!");
            blockErrorException.printStackTrace();
        }

        System.out.println("Coord dove ins torch: ");
        //Scanner s = new Scanner(System.in);
        int R = s.nextInt();
        int C = s.nextInt();
        M.setTorchBlock(R, C);
        M.DisplayMap();
    }
}