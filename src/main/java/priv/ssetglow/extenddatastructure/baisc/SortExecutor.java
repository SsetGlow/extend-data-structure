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
                if (data[i] > data[j]) swap(data[i], data[j]);
            }
        }
    }

    public void selectSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(data[i], data[min]);
            }
        }
    }

    public void insertSort(int[] data) {
        int i, j, k;
        for (i = 1; i < data.length; i++) {
            for (j = i - 1; j >= 0; j--)
                if (data[j] < data[i]) break;
            if (j != i - 1) {
                int temp = data[i];
                for (k = i - 1; k > j; k--)
                    data[k + 1] = data[k];
                data[k + 1] = temp;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }

}
