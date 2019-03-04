import java.util.Random;

class GoalGenerator{
  
  private String goal;
  private String goalObject;  // the object of a "do the goal" -sentence type (eg. "goal" is the object in this case)
  
  public String getGoal(){
    return goal;
  }
  
  //Sets goal with randomized variables
  public void generateGoal(){
    String verb = "";
    String objective = "";
    String[] verbOptions = new String[]{"Destroy", "Get", "Kiss", "Become", "Save" };
    String[] objectiveOptions = new String[]{"money", "a princess", "a gnome", "a cat", "a robot", "the world"};
    Random rand = new Random();
    int verbN = rand.nextInt(verbOptions.length);
    int objN = rand.nextInt(objectiveOptions.length);
    goalObject = objectiveOptions[objN];
    goal = verbOptions[verbN] + " " + objectiveOptions[objN];
  }
  
  public String getGoalObject(){
    return goalObject;
  }
}