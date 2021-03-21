public class Main {
    public static void main(String[] args) {
        try {
            checkArray(creatingAnArray());
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }

    }
    /**
     * Сalculating the sum of all array elements 4х4
     *
     * @param arr1 4x4 string array
     * @throws MyArrayDataException if the value of the array cell is incorrect
     * @throws MyArraySizeException with wrong array size
     *
     * */
    public static void checkArray(String[][] arr1) throws MyArraySizeException, MyArrayDataException{
        int sumOfArrayElements = 0;
        if (arr1.length != 4){
            throw new MyArraySizeException("столб не соответсвует размеру");
        }
            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i].length != 4 ){
                    throw new MyArraySizeException("строка не соотвествует рамзеру");
                }
                for (int j = 0; j < arr1[i].length; j++) {
                    try{
                        sumOfArrayElements += Integer.parseInt(arr1[i][j]);
                    }catch (NumberFormatException e){
                        System.out.println("некорректая ячейка массива: [" + i + "][" + j + "]");
                        throw new MyArrayDataException();
                    }

                }
            }
        System.out.println("Сумма всех элементов массива 4х4: " + sumOfArrayElements);
        }
/**
 *
 * Creating an array
 *
 * */
    public static String [][] creatingAnArray(){
        String [][] arr1 = {
                {"1", "3", "3","4"},
                {"1", "3", "3","4"},
                {"1", "3", "3","4"},
                {"1", "3", "3","4"},

        };
        return arr1;
    }
}
