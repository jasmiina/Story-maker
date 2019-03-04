/* For handling the story instances the user creates
 */
public class StoryAttributes{
  
  private String genre;
  private String setting;
  private String time;
  private String stranger;
  
  public void setGenre(String s){
    genre = s;
  }
  public String getGenre(){
    return genre;
  }
  
  public String getTime(){
    return time;
  }
  public void setTime(String s){
    time = s;
  }
  
  public void setSetting(String s){
    setting = s;
  }
  public String getSetting(){
    return setting;
  }
  
  public void setStranger(String s){
    stranger = s;
  }
  public String getStranger(){
    return stranger;
  }
}