/*
Remember that stacks/queues/linkedlists all work super similarly to arraylists, so i bet you $10 you could reference earlier HW if you get stuck....

1. Take the stack I created and find the maximum and minimum value
2. Find out how many elements were in the stack

3. Find the middle value of the linkedlist I created

4. Implement a real life example of any of the structures and do at least 3 operations to it
*/

import java.util.LinkedList;
import java.util.Stack;

public class datastructuresdebug {
    public static void main(String[] args) {
        Stack<Integer> stax = new Stack<>();
        
        stax.push(70);
        stax.push(34);
        stax.push(807);
        stax.push(61);
        stax.push(28);
        stax.push(563);
        stax.push(492);
        stax.push(386);

        int stackMax = stax.get(0);
        int stackMin = stax.get(0);
        int index = 0;
        for (int num: stax){
            stackMax = (stackMax < num ? num : stackMax);
            stackMin = (stackMin > num ? num : stackMin);
            index += 1;
        }
        System.out.println(stackMax);
        System.out.println(stackMin);
        
        LinkedList<Integer> linky = new LinkedList<>();

        linky.add(30);
        linky.add(40);
        linky.add(50);
        //linky.add(25);
        linky.add(10);
        linky.add(20);
        

        int middleValue = linky.get((linky.size()/2));
        //System.out.print(middleValue);
        System.out.print(medianVal(linky));
        //for (int num: linky){
        //    System.out.print(num);
        //}
    }
    public static float medianVal(LinkedList<Integer> linky){
        linky = ensureOrder(linky);
        float median;
        int half = linky.size()/2;
        if (linky.size() %2 == 0){
            float together = linky.get(half) +linky.get(half - 1);
            median = together/2;
        }else{
            median = linky.get(half);
        }
        return(median);
    }
    public static LinkedList<Integer> ensureOrder(LinkedList<Integer> linky){
        LinkedList<Integer> rtnLinky = new LinkedList<>(); //This took me a week IDFK HOW!!?!?!?!?
        for (int i = 0; i < linky.size(); i+=1){
           for (int j = 0; j < linky.size(); j+=1){
                int tempVal = linky.get(i);
                if (linky.get(j) > linky.get(i)){
                    linky.set(i, linky.get(j));
                    linky.set(j, tempVal);
                }
           }
        }
        return(linky);
    }
}
