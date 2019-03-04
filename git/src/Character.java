/* For creating and handling different kinds of characters
 * */
public class Character{
  protected String age;
  protected String name;
  protected String gender;
  protected String species;
  protected String pronounXe;
  protected String pronounXir;
  protected String pronounXem;
  
  // Age getsetters
  public void setAge(String i){
    age = i;
  }
  public String getAge(){
    return age;
  }
  
  // Name getsetters
  public void setName(String s){
    name = s;
  }
  public String getName(){
    return name;
  }
  
  // Gender getsetters
  public void setGender(String s){
    gender = s;
  }
  public String getGender(){
    return gender;
  }
  
  // Pronoun getsetters based on character gender
  public void setPronouns(){
    if(gender=="male"){
      pronounXe = "he";
      pronounXir = "his";
      pronounXem = "him";
    }
    if(gender=="female"){
      pronounXe = "she";
      pronounXir = "her";
      pronounXem = "her";
    }
    if(gender=="non-binary"){
      pronounXe = "xe";
      pronounXir = "xir";
      pronounXem = "xem";
    }
    else{
      System.out.println("Gender not selected or incorrect");
    }
  }
  public String getXe(){
    return pronounXe;
  }
  public String getXir(){
    return pronounXir;
  }
  public String getXem(){
    return pronounXem;
  }
      
  
  // Species getsetters
  public void setSpecies(String s){
    species = s;
  }
  public String getSpecies(){
    return species;
  }
  
    // Calculates character's age group based on age
  public String getAgeGroup(){
    String ageGroup = "";
    int ageInt;
    try {
      ageInt = Integer.parseInt(age);
    }
    catch (NumberFormatException e)
    {
      ageInt = 20;
      System.out.println("Error: NumberFormatException occured. Character ageGroup set to adult.");
    }
    
    if(ageInt <= 4){
      ageGroup = "baby";
    }
    if(ageInt > 4 && ageInt <= 12){
      ageGroup = "child";
    }
    if(ageInt > 12 && ageInt <= 25){
      ageGroup = "teen";
    }
    if(ageInt > 25 && ageInt <= 64){
      ageGroup = "adult";
    }
    if(ageInt > 64 && ageInt <= 120){
      ageGroup = "elder";
    }
    if(ageInt > 120){
      ageGroup = "antique";
    }
    
    return ageGroup;
  }
  
}