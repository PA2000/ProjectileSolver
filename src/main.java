import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.Math;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class main extends Application implements EventHandler <ActionEvent> {

    Stage window;
    Scene scene1, scene2, scene3;
    Label welcomeMsg, velMsg, angleMsg, solMsg, showSol, GSolMsg, GShowSol;
    Label pMassMsg, oMassMsg, pRadiusMsg, disPlanMsg; //PLANET MASS(M), OBJECT MASS(m), PLANET RADIUS(R), DISTANCE FROM PLANET(r)
    TextField showVel, showAngle;
    TextField showPMass, showOMass, showPRadius, showDisPlan;
    Button projectile, gravitation;
    Button findRange, findMaxHeight, findTime;
    Button findOrbVel, findEscVel, findWeight;
    Button backFP, backG; //backFromProjectile, backFromGrav

    public static double g = 9.80665;
    public static double G = .00000000006672;


    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Physics Solver");
        String css = main.class.getResource("Infinity.css").toExternalForm();

        //First line for the main menu window
        HBox menuLayout1 = new HBox(10);
        welcomeMsg = new Label("WELCOME TO THE PHYSICS SOLVER. CLICK THE SOLVER THAT YOU WANT");
        menuLayout1.getChildren().add(welcomeMsg);
        menuLayout1.setAlignment(Pos.CENTER);

        //Second line for the main menu window
        HBox menuLayout2 = new HBox(10);
        projectile = new Button("Projectile Motion Solver");
        projectile.setOnAction(this);
        gravitation = new Button("Gravitation Solver");
        gravitation.setOnAction(this);
        menuLayout2.getChildren().addAll(projectile, gravitation);
        menuLayout2.setAlignment(Pos.CENTER);

        //Adding the first and second line to scene1 - the full main menu
        VBox menuLayout = new VBox(40);
        menuLayout.getChildren().addAll(menuLayout1, menuLayout2);
        menuLayout.setAlignment(Pos.CENTER);
        scene1 = new Scene(menuLayout, 450, 200);

        //First line for the projectile solver window
        HBox projectLayout1 = new HBox(10);
        velMsg = new Label("Enter Velocity");
        showVel = new TextField();
        projectLayout1.getChildren().addAll(velMsg, showVel);
        projectLayout1.setAlignment(Pos.CENTER);

        //Second line for the projectile solver window
        HBox projectLayout2 = new HBox(10);
        angleMsg = new Label("Enter Angle");
        showAngle = new TextField();
        projectLayout2.getChildren().addAll(angleMsg, showAngle);
        projectLayout2.setAlignment(Pos.CENTER);

        //Third line for the projectile solver window
        HBox projectLayout3 = new HBox(10);
        findMaxHeight = new Button("Find Max Height");
        findMaxHeight.setOnAction(this);
        findTime = new Button("Find Time");
        findTime.setOnAction(this);
        findRange = new Button("Find Horizontal Range");
        findRange.setOnAction(this);
        projectLayout3.getChildren().addAll(findMaxHeight, findTime, findRange);
        projectLayout3.setAlignment(Pos.CENTER);

        //Fourth line for the projectile solver window
        HBox projectLayout4 = new HBox(10);
        solMsg = new Label("Solution: ");
        projectLayout4.getChildren().addAll(solMsg);
        projectLayout4.setAlignment(Pos.CENTER);

        //Fifth Line of the projectile solver window
        HBox projectLayout5 = new HBox();
        showSol = new Label();
        showSol.setStyle("-fx-font-size: 25pt");
        projectLayout5.getChildren().addAll(showSol);
        projectLayout5.setAlignment(Pos.CENTER);

        //Back Button for Projectile Window
        HBox projectLayoutB = new HBox();
        backFP = new Button("Back to Main Menu");
        backFP.setOnAction(this);
        projectLayoutB.getChildren().add(backFP);
        projectLayoutB.setAlignment(Pos.CENTER);

        //Adding the 4 lines and back to full projectile solver
        VBox projectLayoutA = new VBox(20);
        projectLayoutA.getChildren().addAll(projectLayout1,projectLayout2,projectLayout3,projectLayout4, projectLayout5);
        VBox projectLayout = new VBox(30);
        projectLayout.getChildren().addAll(projectLayoutA, projectLayoutB);
        scene2 = new Scene(projectLayout, 350, 300);
        scene2.getStylesheets().addAll(css);

        //First Line of Gravitation
        HBox gravLayout1 = new HBox(10);
        pMassMsg = new Label("Enter the planet's mass:");
        showPMass = new TextField();
        gravLayout1.getChildren().addAll(pMassMsg, showPMass);
        gravLayout1.setAlignment(Pos.CENTER);

        //Second Line of Gravitation
        HBox gravLayout2 = new HBox(10);
        oMassMsg = new Label("Enter the object's mass:");
        showOMass = new TextField();
        gravLayout2.getChildren().addAll(oMassMsg, showOMass);
        gravLayout2.setAlignment(Pos.CENTER);

        //Third Line of Gravitation
        HBox gravLayout3 = new HBox(10);
        pRadiusMsg = new Label("Enter the planet's radius:");
        showPRadius = new TextField();
        gravLayout3.getChildren().addAll(pRadiusMsg, showPRadius);
        gravLayout3.setAlignment(Pos.CENTER);

        //Fourth Line of Gravitation
        HBox gravLayout4 = new HBox(10);
        disPlanMsg = new Label("Enter the distance from the planet:");
        showDisPlan = new TextField();
        gravLayout4.getChildren().addAll(disPlanMsg, showDisPlan);
        gravLayout4.setAlignment(Pos.CENTER);

        //Fifth Line of Gravitation
        HBox gravLayout5 = new HBox(10);
        findOrbVel = new Button("Find Orbital Velocity");
        findOrbVel.setOnAction(this);
        findEscVel = new Button("Find Escape Velocity");
        findEscVel.setOnAction(this);
        findWeight = new Button("Find Weight");
        findWeight.setOnAction(this);
        gravLayout5.getChildren().addAll(findOrbVel, findEscVel, findWeight);
        gravLayout5.setAlignment(Pos.CENTER);

        //Sixth Line of Gravitation
        HBox gravLayout6 = new HBox(10);
        GSolMsg = new Label("Solution:");
        gravLayout6.getChildren().addAll(GSolMsg);
        gravLayout6.setAlignment(Pos.CENTER);

        //Sixth Line of Gravitation
        HBox gravLayout7 = new HBox();
        GShowSol = new Label();
        GShowSol.setStyle("-fx-font-size: 25pt");
        gravLayout7.getChildren().addAll(GShowSol);
        gravLayout7.setAlignment(Pos.CENTER);

        //Back Button
        HBox gravLayoutB = new HBox();
        backG = new Button("Back to Main Menu");
        backG.setOnAction(this);
        gravLayoutB.getChildren().add(backG);
        gravLayoutB.setAlignment(Pos.CENTER);

        //Adding the 4 lines and back to full grav solver
        VBox gravLayoutA = new VBox(20);
        gravLayoutA.getChildren().addAll(gravLayout1,gravLayout2,gravLayout3,gravLayout4, gravLayout5, gravLayout6, gravLayout7);
        VBox gravLayout = new VBox(40);
        gravLayout.getChildren().addAll(gravLayoutA, gravLayoutB);
        scene3 = new Scene(gravLayout, 370, 400);
        scene3.getStylesheets().addAll(css);

        window.centerOnScreen();
        scene1.getStylesheets().addAll(css);
        window.setScene(scene1);
        window.show();
    }

    public void handle(ActionEvent e) {
        if(e.getSource() == projectile) {
            window.setScene(scene2);
        }
        if(e.getSource() == backFP) {
            window.setScene(scene1);
        }
        if(e.getSource() == gravitation) {
            window.setScene(scene3);
        }
        if(e.getSource() == backG) {
            window.setScene(scene1);
        }
        if(e.getSource() == findMaxHeight) {
            Double vel = Double.parseDouble(showVel.getText().toString());
            Double angle = Double.parseDouble(showAngle.getText().toString());
            Double hVel = Math.pow(vel, 2);
            Double hAngle = Math.pow(Math.sin(Math.toRadians(angle)),2);
            Double height = (hVel * hAngle)/(2*g);
            String solHeight = height.toString();
            showSol.setText(solHeight);
        }
        if(e.getSource() == findTime) {
            Double vel = Double.parseDouble(showVel.getText().toString());
            Double angle = Double.parseDouble(showAngle.getText().toString());
            Double time = (2*vel*Math.sin(Math.toRadians(angle)))/g;
            String solTime = time.toString();
            showSol.setText(solTime);
        }
        if(e.getSource() == findRange) {
            Double vel = Double.parseDouble(showVel.getText().toString());
            Double angle = Double.parseDouble(showAngle.getText().toString());
            Double rVel = Math.pow(vel, 2);
            Double rAngle = Math.sin(Math.toRadians(2*angle));
            Double range = (rVel * rAngle)/(g);
            String solRange = range.toString();
            showSol.setText(solRange);
        }
        if(e.getSource() == findOrbVel) {
            Double M = Double.parseDouble(showPMass.getText().toString());
            Double r = Double.parseDouble(showDisPlan.getText().toString());
            Double orbVel = Math.sqrt((G*M)/r);
            String solOrbVel = orbVel.toString();
            GShowSol.setText(solOrbVel);
        }
        if(e.getSource() == findEscVel) {
            Double M = Double.parseDouble(showPMass.getText().toString());
            Double R = Double.parseDouble(showPRadius.getText().toString());
            Double escVel = Math.sqrt((2*G*M)/R);
            String solEscVel = escVel.toString();
            GShowSol.setText(solEscVel);
        }
        if(e.getSource() == findWeight) {
            Double M = Double.parseDouble(showPMass.getText().toString());
            Double m = Double.parseDouble(showOMass.getText().toString());
            Double R = Double.parseDouble(showPRadius.getText().toString());
            Double r = Double.parseDouble(showDisPlan.getText().toString());
            Double weight = Math.sqrt((G*M*m)/Math.pow((R+r),2));
            String solWeight = weight.toString();
            GShowSol.setText(solWeight);
        }
    }

}
