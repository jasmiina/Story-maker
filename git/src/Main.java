import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font; 
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.geometry.Pos;
import javafx.scene.paint.Color; 
import java.io.Console;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javafx.util.converter.IntegerStringConverter;
import javafx.stage.Popup;

/** Runs the application
 */
public class Main extends Application{
  
  private static Stage primaryStage;
  Popup popup = new Popup(); 
  
  /**
   * Components that hold story attributes
   */
  StoryAttributes story = new StoryAttributes();
  private Hero hero = new Hero();
  private SecChar villain = new SecChar();
  
  public static void main (String[] args){
    launch(args);
  }
  
  // Starts the application
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Storymaker");
    
    //Sets up popup
    VBox vbox = new VBox();
    Label label = new Label("Please choose required options before continuing.");  
    //label.setStyle(" -fx-background-color: white;"); 
    /*label.setMinWidth(80); 
    label.setMinHeight(50);*/
    Button closePopup = new Button("Ok");
    closePopup.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              popup.hide();
            }
        });
    vbox.getChildren().addAll(label, closePopup);
    vbox.setSpacing(20);
    vbox.setAlignment(Pos.CENTER);
    vbox.setStyle(" -fx-background-color: white;"); 
    popup.getContent().addAll(vbox); 
    
    primaryStage.setScene(makeWelcomeScene(primaryStage));
    primaryStage.show();
    }
    
  // Makes the first scene where user chooses the genre (drama not in use in current version)
    public Scene makeWelcomeScene(Stage primaryStage){
       Text welcome = new Text("Welcome! Please choose a genre for your story:");
        //welcome.setFont(new Font(30));
        
        /*ToggleButton btnDrama = new ToggleButton();
        btnDrama.setText("Drama");*/
        ToggleButton btnHorror = new ToggleButton();
        btnHorror.setText("Horror");
        ToggleButton btnRomance = new ToggleButton();
        btnRomance.setText("Romance");
        ToggleButton btnDetective = new ToggleButton();
        btnDetective.setText("Adventure");
        final ToggleGroup group = new ToggleGroup();
        //btnDrama.setToggleGroup(group);
        btnRomance.setToggleGroup(group);
        btnHorror.setToggleGroup(group);
        btnDetective.setToggleGroup(group);
        HBox genreBtns = new HBox();
        genreBtns.getChildren().addAll(/*btnDrama,*/ btnHorror, btnRomance, btnDetective);
        genreBtns.setSpacing(10);
        genreBtns.setAlignment(Pos.CENTER);
        
      Button nextBtn = new Button("Next");
      nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(story.getGenre() != null){ // To test if a genre has been selected, if not scene won't change until it's chosen
                primaryStage.setScene(makeSettingScene(primaryStage));
              }
              else{
                popup.show(primaryStage);
              }
            }
        });
        
        VBox root = new VBox();
        root.getChildren().addAll(welcome, genreBtns, nextBtn);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        Scene scene =new Scene(root, 700, 600);
        
        try{
        /*btnDrama.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               if(btnDrama.isSelected()==false){
                //settingDescription.setText(" ");
                story.setGenre(null);
              }
              else{
                story.setGenre("drama");
                System.out.println("Genre: "+story.getGenre());
              }
            }
        });*/
        btnHorror.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(btnHorror.isSelected()==false){
                //settingDescription.setText(" ");
                story.setGenre(null);
              }
              else{
                story.setGenre("horror");
                System.out.println("Genre: "+story.getGenre());
              }
            }
        });
        btnRomance.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(btnRomance.isSelected()==false){
                //settingDescription.setText(" ");
                story.setGenre(null);
              }
              else{
                story.setGenre("romance");
                System.out.println("Genre: "+story.getGenre());
              }
            }
        });
        btnDetective.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(btnDetective.isSelected()==false){
                //settingDescription.setText(" ");
                story.setGenre(null);
              }
              else{
                story.setGenre("adventure");
                System.out.println("Genre: "+story.getGenre());
              }
            }
        });
        } catch (Exception e){
         e.printStackTrace();
      }
        
        return scene;
    }
    
    // Second scene for setting selection
    public Scene makeSettingScene(Stage primaryStage){
      Text text1 = new Text("The genre of your story is now "+ story.getGenre() +"!");
      Text text2 = new Text("Next you can choose where your story takes place.");
      
      Text settingDescription = new Text();
      
      ToggleButton tglPalace = new ToggleButton("A palace");
      ToggleButton tglForest = new ToggleButton("A forest");
      ToggleButton tglApartment = new ToggleButton("A town");
      final ToggleGroup group = new ToggleGroup();
      tglForest.setToggleGroup(group);
      tglPalace.setToggleGroup(group);
      tglApartment.setToggleGroup(group);
      HBox settingBtns = new HBox();
      settingBtns.getChildren().addAll(tglPalace, tglForest, tglApartment);
      settingBtns.setSpacing(20);
      settingBtns.setAlignment(Pos.CENTER);
      
       tglForest.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(tglForest.isSelected()==false){
                settingDescription.setText(" ");
                story.setSetting(null);
              }
              else{
                settingDescription.setText("A forest");
                story.setSetting("a forest");
              }
            }
        });
       tglPalace.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(tglPalace.isSelected()==false){
                settingDescription.setText(" ");
                story.setSetting(null);
              }
              else{
                settingDescription.setText("A palace");
                story.setSetting("a palace");
              }
            }
        });
       tglApartment.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(tglApartment.isSelected()==false){
                settingDescription.setText(" ");
                story.setSetting(null);
              }
              else{
                settingDescription.setText("A town");
                story.setSetting("a town");
              }
            }
        });
      
      Button nextBtn = new Button("Next");
      nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(story.getSetting() != null){
                primaryStage.setScene(makeTimeScene(primaryStage));
              }
              else{
                popup.show(primaryStage);
              }
            }
        });
      
       VBox root = new VBox();
        root.getChildren().addAll(text1, text2, settingBtns,/* settingDescription,*/ nextBtn);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        
        Scene scene =new Scene(root, 700, 600);
        return scene;
    }
   
    // Third scene to select the time period
    public Scene makeTimeScene(Stage primaryStage){
      Text text1 = new Text("And what time period is your story set in?");
      
      ToggleButton pastBtn = new ToggleButton("A long time ago");
      /*ToggleButton middleAgesBtn = new ToggleButton("The Middle Ages");
      ToggleButton victorianBtn = new ToggleButton("The Victorian Era");*/
      ToggleButton presentBtn = new ToggleButton("The present");
      ToggleButton futureBtn = new ToggleButton("The future");
      final ToggleGroup group = new ToggleGroup();
      pastBtn.setToggleGroup(group);
      presentBtn.setToggleGroup(group);
      futureBtn.setToggleGroup(group);
      HBox settingBtns = new HBox();
      settingBtns.getChildren().addAll(pastBtn, presentBtn, futureBtn);
      settingBtns.setSpacing(20);
      settingBtns.setAlignment(Pos.CENTER);
      
      pastBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(pastBtn.isSelected()==false){
                story.setTime(null);
              }
              else{
                story.setTime("past");
              }
            }
        });
      presentBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(presentBtn.isSelected()==false){
                story.setTime(null);
              }
              else{
                story.setTime("present");
              }
            }
        });
      futureBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(futureBtn.isSelected()==false){
                story.setTime(null);
              }
              else{
                story.setTime("future");
              }
            }
        });
      
      Button nextBtn = new Button("Next");
      nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              if(story.getTime() != null){
                primaryStage.setScene(makeFirstCharacterScene(primaryStage));
              }
              else{
                popup.show(primaryStage);
              }
            }
        });
      
      VBox root = new VBox();
        root.getChildren().addAll(text1, settingBtns, nextBtn);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        
        Scene scene =new Scene(root, 700, 600);
        return scene;
    }
    
    // Creates character creation scene for hero
    public Scene makeFirstCharacterScene(Stage primaryStage){
      Text text1 = new Text("Great! So your story takes place in "+ story.getSetting()+", it's set in the "+ story.getTime()+" and the genre is "+story.getGenre()+".");
      Text text2 = new Text("Now it's time to create some characters.");
      Text text3 = new Text("First, create the main character of your story.");
      
      //Panel for name creation TODO: make box shorter, make accept only text input
      Label nameLabel = new Label("Name:");
      TextField nameField = new TextField ();
      nameField.setText("Karen");
      VBox name = new VBox();
      name.getChildren().addAll(nameLabel, nameField);
      name.setSpacing(10);
      
      //Panel for age TODO make box shorter
      Label ageLabel = new Label("Age:");
      TextField ageField = new TextField();
      VBox age = new VBox();
      age.getChildren().addAll(ageLabel, ageField);
      age.setSpacing(10);
      TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter(), 20, new IntegerFilter()); //To get only integer input
      //formatter.valueProperty().bindBidirectional(myIntegerProperty);
      ageField.setTextFormatter(formatter);
      
      //Panel for species
      Label speciesLabel = new Label("Species");
      ComboBox<String> speciesBox = new ComboBox<String>();
      speciesBox.getItems().addAll( "A human", "A gnome", "A robot", "A cat");
      speciesBox.setValue("A human");
      VBox species = new VBox();
      species.getChildren().addAll(speciesLabel, speciesBox);
      species.setSpacing(10);
      
      // Panel for gender NOT IN USE
      Label genderLabel = new Label("Gender:");
      final ToggleGroup genderGroup = new ToggleGroup();
      RadioButton nonBinary = new RadioButton("Non-binary");
      nonBinary.setToggleGroup(genderGroup);
      nonBinary.setSelected(true);
      RadioButton male = new RadioButton("Male");
      male.setToggleGroup(genderGroup);
      RadioButton female = new RadioButton("Female");
      female.setToggleGroup(genderGroup);
      VBox gender = new VBox();
      gender.getChildren().addAll(genderLabel, nonBinary, male, female);
      
      //Options for goal selection
      Label goalLabel = new Label("Goal:");
      Button randomizeGoal = new Button("Randomize");
      GoalGenerator goalGenerator = new GoalGenerator();
      Text goalText = new Text();
      VBox goal = new VBox();
      goal.setSpacing(10);
      goal.getChildren().addAll(goalLabel, goalText, randomizeGoal);
      randomizeGoal.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              goalGenerator.generateGoal();
              goalText.setText(goalGenerator.getGoal());
              }
        });
      
      // Grid to display all the option panels
      GridPane characterOptions = new GridPane();
      characterOptions.setAlignment(Pos.CENTER);
      characterOptions.setHgap(20);
      characterOptions.setVgap(20);
      characterOptions.add(name, 0, 0);
      characterOptions.add(age, 0, 1);
      characterOptions.add(species, 1, 0);
      characterOptions.add(goal, 1, 1);
      
      Button nextBtn = new Button("Done");
      nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              hero.setName(nameField.getText());//make first character uppercase
              hero.setAge(ageField.getText());
              hero.setSpecies(speciesBox.getValue().toLowerCase());
              RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle(); hero.setGender(selectedGender.getText().toLowerCase());
              hero.setGoal(goalText.getText().toLowerCase());
              hero.setGoalObject(goalGenerator.getGoalObject());
              if(nameField.getText().isEmpty() || ageField.getText().isEmpty() || goalText.getText().isEmpty()){
                popup.show(primaryStage);
              }
              else{
                primaryStage.setScene(makeVillainScene(primaryStage));
                System.out.println(hero.getName() + hero.getAge() + hero.getGender() + hero.getAgeGroup() + hero.getSpecies() + " Goal: "+ hero.doTheGoal());
              }
            }
        });
                         
      VBox root = new VBox();
      root.getChildren().addAll(text1, text2, text3, characterOptions, nextBtn);
      root.setSpacing(20);
      root.setAlignment(Pos.CENTER);
        
      Scene scene =new Scene(root, 700, 600);
      return scene;
    }
    
    // Character creation scene for villain/secondary character
    public Scene makeVillainScene(Stage primaryStage){
      
      Text text1 = new Text("Looking good! Now create a villain.");
      
      //Panel for name creation TODO: make box shorter, make accept only text input
      Label nameLabel = new Label("Name:");
      TextField nameField = new TextField ();
      nameField.setText("Larry");
      VBox name = new VBox();
      name.getChildren().addAll(nameLabel, nameField);
      name.setSpacing(10);
      
      //Panel for age TODO make box shorter
      Label ageLabel = new Label("Age:");
      TextField ageField = new TextField();
      VBox age = new VBox();
      age.getChildren().addAll(ageLabel, ageField);
      age.setSpacing(10);
      TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter(), 50, new IntegerFilter()); //To get only integer input
      //formatter.valueProperty().bindBidirectional(myIntegerProperty);
      ageField.setTextFormatter(formatter);
      
      //Panel for species
      Label speciesLabel = new Label("Species");
      ComboBox<String> speciesBox = new ComboBox<String>();
      speciesBox.getItems().addAll( "A human", " A gnome", "A robot", "A cat");
      speciesBox.setValue("A human");
      VBox species = new VBox();
      species.getChildren().addAll(speciesLabel, speciesBox);
      species.setSpacing(10);    
      
      // Panel for gender NOT IN USE
      Label genderLabel = new Label("Gender:");
      final ToggleGroup genderGroup = new ToggleGroup();
      RadioButton nonBinary = new RadioButton("Non-binary");
      nonBinary.setToggleGroup(genderGroup);
      nonBinary.setSelected(true);
      RadioButton male = new RadioButton("Male");
      male.setToggleGroup(genderGroup);
      RadioButton female = new RadioButton("Female");
      female.setToggleGroup(genderGroup);
      VBox gender = new VBox();
      gender.getChildren().addAll(genderLabel, nonBinary, male, female);
      
      //Panel that asks what this characters feelings are towards the hero
      Label feelLabel = new Label("Feelings towards main character:");
      ComboBox<String> feelBox = new ComboBox<String>();
      feelBox.getItems().addAll( "Hates", "Loves", "Wants to eat");
      feelBox.setValue("Hates");
      VBox feels = new VBox();
      species.getChildren().addAll(feelLabel, feelBox);
      species.setSpacing(10);  
      
      // Grid to display all the option panels
      GridPane characterOptions = new GridPane();
      characterOptions.setAlignment(Pos.CENTER);
      characterOptions.setHgap(20);
      characterOptions.setVgap(20);
      characterOptions.add(name, 0, 0);
      characterOptions.add(age, 0, 1);
      characterOptions.add(species, 1, 0);
      characterOptions.add(feels, 1, 1);
      
      Button nextBtn = new Button("Done");
      nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              villain.setName(nameField.getText());//make first character uppercase
              villain.setAge(ageField.getText());
              villain.setSpecies(speciesBox.getValue().toLowerCase());
              RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle(); villain.setGender(selectedGender.getText().toLowerCase());
              villain.setFeels(feelBox.getValue().toLowerCase());
              if(nameField.getText().isEmpty() || ageField.getText().isEmpty()){
                popup.show(primaryStage);
              }
              else{
                primaryStage.setScene(createStoryScene(primaryStage));
              }
            }
        });
      
      VBox root = new VBox();
      root.getChildren().addAll(text1, characterOptions, nextBtn);
      root.setSpacing(20);
      root.setAlignment(Pos.CENTER);
        
      Scene scene =new Scene(root, 700, 600);
      return scene;
    }
    
    //Creates scene where StoryGenerator is called
    public Scene createStoryScene(Stage primaryStage){
      
      Text text0 = new Text("So here's to recap:");
      Text text1 = new Text("Your story takes place in "+ story.getSetting()+", it's set in the "+ story.getTime()+" and the genre is "+story.getGenre()+".");
      Text text2 = new Text("The main character is "+hero.getSpecies()+" named "+hero.getName()+".");
      Text text3 = new Text("The villain is "+villain.getSpecies()+" called "+villain.getName()+" who "+villain.getFeels()+ " "+hero.getName()+".");
      Text text4 = new Text("You have one last thing to choose...");
      Text text5 = new Text(" ");
      Text text6 = new Text(" ");
      
      Label choiceLabel = new Label("I choose:");
      ComboBox<String> choiceBox = new ComboBox<String>();
      choiceBox.getItems().addAll( "A bunny", "A lion", "A bee");
      choiceBox.setValue("A bunny");
      HBox feels = new HBox();
      feels.getChildren().addAll(choiceLabel, choiceBox);
      feels.setSpacing(10);
      feels.setAlignment(Pos.CENTER);
      
      Button generator = new Button("Generate");
      generator.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              story.setStranger(choiceBox.getValue().toLowerCase());
              
              StoryGenerator sg = new StoryGenerator(story, hero, villain);
              String generatedStory = sg.generateStory();
              showStory(generatedStory);
              
              primaryStage.setScene(showStory(generatedStory));
            }
        });
      
      VBox root = new VBox();
      root.getChildren().addAll(text0, text1, text2, text3, text4, feels, generator, text5,text6);
      root.setSpacing(20);
      root.setAlignment(Pos.CENTER);
        
      Scene scene =new Scene(root, 700, 600);
      return scene;
    }
    
    // Shows the generated story
    public Scene showStory(String generatedStory){
      
      Text storyText = new Text(generatedStory);
      storyText.setFont(new Font(22));
      storyText.setWrappingWidth(650);
      storyText.setTextAlignment(TextAlignment.CENTER);
      storyText.setLineSpacing(2);
      
      ScrollPane scroll = new ScrollPane();
      scroll.setContent(storyText);
      scroll.setFitToWidth(true);
      scroll.setFitToHeight(true);
      
      Text text1 = new Text("");
      
      Button saveB = new Button("Save story");
      saveB.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
              FileChooser fileChooser = new FileChooser();
              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
              fileChooser.getExtensionFilters().add(extFilter);
              File file = fileChooser.showSaveDialog(primaryStage);
           
              try{
                 if (file != null) {
                 writeStoryToFile(generatedStory, file);
                 }
              }catch (IOException e){
                e.printStackTrace();
              }
              //text1.setText("Your story has been saved.");
            }
        });
      
      VBox root = new VBox();
      root.getChildren().addAll(scroll, saveB, text1);
      root.setSpacing(20);
      root.setAlignment(Pos.CENTER);
      
      Scene scene =new Scene(root, 700, 600);
      return scene;
    }
    
    // Writes storyString to file
    public void writeStoryToFile(String storyString, File file)  throws IOException{
        PrintWriter writer;
         writer = new PrintWriter(file);
         writer.println(storyString);
         writer.close();
       } 
     // Creates the final scene where story is shown
    /*public Scene createStoryScene(Stage primaryStage, StoryGenerator sg){
      
      Text text1 = new Text(sg.generateStory());
      
      VBox root = new VBox();
      root.getChildren().addAll(text1);
      root.setSpacing(20);
      root.setAlignment(Pos.CENTER);
        
      Scene scene =new Scene(root, 700, 600);
      return scene;
    }*/
    }
