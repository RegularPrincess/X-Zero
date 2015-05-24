package PlayingPlace;

/**
 * Created by user on 28.12.2014.
 */
public class Place {
    public final char DEFAULT_VALUE = 8;

    public final static int SIZE_PLACE = 3;

    private int place[][];

    private int sizePlace;

    public int getSizePlace() {
        return sizePlace;
    }

// Конструктор поля заданного размера
    public Place(int sizePlace){
        if (sizePlace >= SIZE_PLACE) {
            place = new int[sizePlace][sizePlace];
            for (int i = 0; i < sizePlace; i++) {
                for (int j = 0; j < sizePlace; j++) {
                    place[i][j] = DEFAULT_VALUE;
                }
            }
            this.sizePlace = sizePlace;
        }else{
            System.out.print("Укажите размер больший или равный дефолтному(" + SIZE_PLACE + ")");
            System.exit(-1);
        }
    }

// Конструктор по умолчанию
    public Place(){
        this(SIZE_PLACE);
    }

// Проверяет, существует ли клетка с указанными координатами
    public boolean checing(int i, int j){
        if (i < sizePlace && i >=0 && j < sizePlace && j >= 0) {
            return true;
        }
        else{
             System.out.println("Выход за пределы поля!");
             return false;
            }
        }

// Узнать что лежит в заданной клетке
    public int getValue(int i, int j){
        if (checing(i, j)){
            return place[i][j];
        }else{
            return -1;
        }
    }

// Положить в заданную ячейку поля
    public boolean setValue(int i, int j, int value){
        if (checing(i, j)){
            place[i][j] = value;
            return true;
        }else
            return false;
    }

// Распечатывает поле
    public void print() {
        for (int i = 0; i < sizePlace; i++){
            for(int j = 0; j < sizePlace; j++){
                System.out.print("[" + place[i][j] + "]");
            }
            System.out.println();
        }
    }

// Очистка игрового поля
    public void cleanPlace(){
        for (int i = 0; i < sizePlace; i++) {
            for (int j = 0; j < sizePlace; j++) {
                place[i][j] = DEFAULT_VALUE;
            }
        }
    }
}