class MyIntStreamImpl implements MyIntStream{

    public static int[] arr;

    public MyIntStreamImpl(){
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