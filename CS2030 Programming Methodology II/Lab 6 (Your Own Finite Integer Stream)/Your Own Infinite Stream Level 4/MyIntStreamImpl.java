package cs2030.mystream;

import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.HashSet;
import java.util.ArrayList;
public class MyIntStreamImpl implements MyIntStream{

    public int[] arr;

    public MyIntStreamImpl(){
    }

    public long count(){
        long num = 0;
        for(int i = 0; i < arr.length; i++){
            num++;
        }
        return num;
    }

    public int sum(){
        int total = 0;
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
        }
        return total;
    }

    public OptionalDouble average(){
        if(count() < 1){
            return OptionalDouble.empty();
        }
        else{
            OptionalDouble avg = OptionalDouble.of((double)sum() / count());
            return avg;
        }
    }

    public OptionalInt max(){
        if(arr.length < 1){
            return OptionalInt.empty();
        }
        else{
            OptionalInt maximum = OptionalInt.of(arr[arr.length-1]);
            return maximum;
        }
    }

    public OptionalInt min(){
        if(arr.length < 1){
            return OptionalInt.empty();
        }
        else{
            OptionalInt minimum = OptionalInt.of(arr[0]);
            return minimum;
        }
    }

    public MyIntStream limit(int maxSize){
        int[] newArr = new int[maxSize];

        for(int i = 0; i < maxSize; i++){
            newArr[i] = arr[i];
        }
        return MyIntStream.of(newArr);
    }

    public MyIntStream distinct(){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        int count = 0;
        int[] newArr = new int[set.size()];
        for(int i: set){
            newArr[count] = i;
            count++;
        }
        return MyIntStream.of(newArr);
    }

    public MyIntStream filter(IntPredicate predicate){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++){
            if(predicate.test(arr[i])){
                list.add(arr[i]);
            }
        }
        int count = 0;
        int[] newArr = new int[list.size()];
        for(int i: list){
            newArr[count] = i;
            count++;
        }
        return MyIntStream.of(newArr);
    }

    public MyIntStream map(IntUnaryOperator mapper){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++){
            int newValue = mapper.applyAsInt(arr[i]);
            list.add(newValue);
        }
        int count = 0;
        int[] newArr = new int[list.size()];
        for(int i: list){
            newArr[count] = i;
            count++;
        }
        return MyIntStream.of(newArr);
    }

    public int reduce(int identity, IntBinaryOperator op){
        if(arr.length < 1){
            return identity;
        }
        else if(arr.length == 1){
            return op.applyAsInt(identity, arr[0]);
        }
        else{
            int result = op.applyAsInt(identity, arr[0]);
            for(int i = 1; i < arr.length; i++){
                result = op.applyAsInt(result, arr[i]);
            }
            return result;
        }
    }

    public OptionalInt reduce(IntBinaryOperator op){
        if(arr.length < 1){
            return OptionalInt.empty();
        }
        else if(arr.length == 1){
            OptionalInt result = OptionalInt.of(arr[0]);
            return result;
        }
        else{
            int result = op.applyAsInt(arr[0], arr[1]);
            for(int i = 2; i < arr.length; i++){
                result = op.applyAsInt(result, arr[i]);
            }
            return OptionalInt.of(result);
        }
    }

    public void forEach(IntConsumer action){
        for(int i = 0; i < arr.length; i++){
            action.accept(arr[i]);
        }
    }

    @Override
    public String toString(){
        String result = "[";
        for(int i = 0; i < arr.length; i++){
            if(arr.length < 2){
                result += arr[i];
            }
            else{
                result += arr[i];
                if(i != arr.length - 1){
                    result += ", ";
                }
            }
        }
        result += "]";
        return result;
    }
}