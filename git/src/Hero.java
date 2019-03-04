public class Hero extends Character{
  
  private String goal;
  private String goalObject;
  
  public void setGoal(String s){
    goal = s;
  }
  public String doTheGoal(){ //using this name because it's more intuitive to use in story generation
    return goal;
  }
  
  public String getGoalObject(){
    return goalObject;
  }
  public void setGoalObject(String s){
    goalObject =s;
  }
  
}