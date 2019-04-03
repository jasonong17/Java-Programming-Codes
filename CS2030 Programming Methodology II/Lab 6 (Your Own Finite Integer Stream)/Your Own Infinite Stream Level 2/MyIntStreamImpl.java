import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.function.IntConsumer;
class MyIntStreamImpl implements MyIntStream{

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