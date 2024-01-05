package priv.ssetglow.extenddatastructure.baisc;

/**
 * @author SsetGlow
 * @date 2024-01-02 周二 09:08
 * @since 1.0.0
 **/
public class SortExecutor {

    public void bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; ++i) {
            for (int j = i + 1; j < data.length; ++j) {
                if (data[i] > data[j]) change(data[i], data[j]);
            }
        }
    }

    public void selectSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            //把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
            for (int j = i + 1; j < data.length; j++) {
                //如果后面比较的数比记录的最小的数小
                if (data[j] < data[min]) {
                    //记录最小的那个数的下标
                    min = j;
                }
            }
            //如果最小的数和当前遍历数的下标不一致，说明下标为min的数比当前遍历的数更小
            if (i != min) {
                change(data[i], data[min]);
            }
        }
    }

    public void insertSort(int[] data) {

    }

    private void change(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }

}
