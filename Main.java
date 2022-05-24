import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class MyClass {

  public static String stringRotation(String target, int rotation) {

    if (rotation > target.length()) //avoid exception
      rotation = 0;
    
    String lastCharacters = target.substring(target.length()-rotation);  //capturing characters to be rotated 
    String newTarget = target.substring(0, target.length()-rotation);  //capturing string minus rotated characters 
  
    String rotatedString = lastCharacters + newTarget;

    return rotatedString;
  }

  public static HashMap<Integer,Integer> aboveBelow(int[] ints, int comparison) {

    HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();
 
    List<Integer> intList = Arrays.stream(ints)        
                                    .boxed()
                                    .collect(Collectors.toList());  //convert to list
 
    List<Integer> above = intList.stream().filter(str -> str > comparison).collect(Collectors.toList());  //using stream to filter by our compairson value
    List<Integer> below = intList.stream().filter(str -> str < comparison).collect(Collectors.toList());

    int sizeAbove = above.size();
    int sizeBelow = below.size();
 
    myMap.put(sizeAbove,sizeBelow); 

    myMap.forEach((key, value) -> System.out.println("above: " + key + "  below: " + value));
  
   return myMap;
  }
}
  


public class Main {
  public static void main(String[] args) {

    String input = "MyString";
    int rotation = 8;
    System.out.println(MyClass.stringRotation(input,rotation));

    
    int [] nums = {10,5,3,568,4,1,95,64};
    int val = 6;
    MyClass.aboveBelow(nums,val);
  }
 }
