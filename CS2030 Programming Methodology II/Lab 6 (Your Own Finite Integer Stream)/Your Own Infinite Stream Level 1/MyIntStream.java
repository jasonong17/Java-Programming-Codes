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
    
    public String toString();
}