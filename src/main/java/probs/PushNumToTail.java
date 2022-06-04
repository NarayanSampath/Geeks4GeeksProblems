// Write a code to shift zeroes to the end of the array var array =[4,0,1,0,6] Output [4,1,6,0,0]
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("new arrayList = "+pushZeroToLast(Arrays.asList(4,0,1,0,6)));
    }
  private static List<Integer> pushZeroToLast(List<Integer> array){
    List<Integer> newArrayList = new ArrayList<>();
      for(int i=0;i<array.size();i++){
        if(array.get(i)!=0){
          newArrayList.add(array.get(i));
        }
      }
      if(newArrayList.size()<array.size()){
        for(int i=newArrayList.size();i<array.size();i++){
          newArrayList.add(0);
        }
      }
    return newArrayList;
   }
}
