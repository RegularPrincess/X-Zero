package PlayingPlace;

/**
 * Created by user on 22.01.2015.
 */
public class PlaceForNullX extends Place {
    private static final int SIZE_PLACE_FOR_NULL_X = 3;

    public PlaceForNullX(){
        super(SIZE_PLACE_FOR_NULL_X);
    }

// Кладет в заданную по координатам клетку поля 0 или 1
    public boolean setValue(int i, int j, int value){
       if (value == 0 || value == 1){
           if (getValue(i, j) != 0 && getValue(i, j) != 1) {
               super.setValue(i, j, value);
               return true;
           }else{
               System.out.println("Ячейка занята");
               return false;

           }
       }else{
           System.out.println("Введите 0 или 1");
           return false;
       }
    }

// Подсчитывает сумму в строке
    private int sumStr(int i){
        if(checing(i, 1)) {
            int s = 0;
            for (int j = 0; j < SIZE_PLACE_FOR_NULL_X; j++) {
                s = s + super.getValue(i, j);
            }
            return s;
        }else{
            return -1;
        }
    }

// Подсчитывает сумму в столбце
    private int sumCol(int j){
        if (checing(1, j)) {
            int s = 0;
            for (int i = 0; i < SIZE_PLACE_FOR_NULL_X; i++) {
                s = s + super.getValue(i, j);
            }
            return s;
        }else{
            return  -1;
        }
    }

// Подсчитывает сумму в правой диагонали
    private int sumDigRig(){
        int s = 0;
        for (int i = 0; i < SIZE_PLACE_FOR_NULL_X; i++){
            s = s + super.getValue(i, i);
        }
        return s;
    }

// Подсчитывает сумму в левой диагонали
    private int sumDigleft(){
        int s = 0;
        for (int i = 0; i < SIZE_PLACE_FOR_NULL_X; i++){
            s = s + super.getValue(i, SIZE_PLACE_FOR_NULL_X - i - 1);
        }
        return s;
    }

// Проверяет победил ли игрок
    private boolean scaning (int player) {
        int z = SIZE_PLACE_FOR_NULL_X;
        if (player == 0 || player == 1) {
            if (sumCol(0) == player * z || sumCol(1) == player * z || sumCol(2) == player * z) {
                return true;
            } else {
                if (sumDigleft() == player * z || sumDigRig() == player * z) {
                    return true;
                } else {
                    if (sumStr(0) == player * z || sumStr(1) == player * z  || sumStr(2) == player * z) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }else{
            System.out.print("player not found");
            return false;
        }
    }

    public void print(){
        for (int i = 0; i < SIZE_PLACE_FOR_NULL_X; i++){
            for (int j = 0; j < SIZE_PLACE_FOR_NULL_X; j++){
                switch (getValue(i, j)){
                    case DEFAULT_VALUE:
                        System.out.print("[ ]");
                        break;
                    case 0:
                        System.out.print("[0]");
                        break;
                    case 1:
                        System.out.print("[X]");
                        break;
                }
            }
            System.out.println();
        }
    }

    public boolean win0(){
        if (scaning(0)){
            return true;
        }else return false;
    }

    public boolean win1(){
        if (scaning(1)){
            return true;
        }else return false;
    }
}