  import java.util.*;

public class Tools{
  
  public String capitalizeFirstLetter(String s){
    String capitalizedS = s.substring(0, 1).toUpperCase() + s.substring(1);
    return capitalizedS;
  }
  
  //Removes articles and other needless first words from a word (a, an etc) (only works on two word strings)
  public String removeArticles(String s){
    String noArticles = "";
    String[] splitS = s.split(" ");
    /*for(int i=2; i<splitS.length; i++){
      noArticles += splitS[i];
      noArticles += " ";
      if(i==splitS.length-1){
        noArticles = noArticles.substring(0, noArticles.length()-1);
      }*/
    noArticles = splitS[1];
    return noArticles;
  }
  
}