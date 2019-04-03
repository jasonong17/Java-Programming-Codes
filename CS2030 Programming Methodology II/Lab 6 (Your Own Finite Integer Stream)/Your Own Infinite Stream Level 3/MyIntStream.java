import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
interface MyIntStream{

    static MyIntStream of(int... values){
        MyIntStreamImpl result = new MyIntStreamImpl();

        result.arr = new int[values.length];
        for(int i = 0; i < values.length; i++){
            result.arr[i] = values[i];
        }
        return result;
    }

    static MyIntStream range(int start, int end){
        if(end <= start){
            return MyIntStream.of();
        }
        else{
            int[] arr = new int[end-start];
            for(int i = start; i < end; i++){
                arr[i-start] = i;
            }
            return MyIntStream.of(arr);
        }
    }

    static MyIntStream rangeClosed(int start, int end){
        if(end < start){
            return MyIntStream.of();
        }
        else{
            int[] arr = new int[(end+1)-start];
            for(int i = start; i <= end; i++){
                arr[i-start] = i;
            }
            return MyIntStream.of(arr);
        }
     }
    
    long count();
    int sum();
    OptionalDouble average();
    OptionalInt max();
    OptionalInt min();
    MyIntStream limit(int maxSize);
    MyIntStream distinct();
    MyIntStream filter(IntPredicate predicate);
    MyIntStream map(IntUnaryOperator mapper);
    void forEach(IntConsumer action);
    public String toString();
}