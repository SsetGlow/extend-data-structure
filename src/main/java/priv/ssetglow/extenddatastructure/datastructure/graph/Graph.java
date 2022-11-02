package priv.ssetglow.extenddatastructure.datastructure.graph;

import java.util.LinkedList;

/**
 * @author SsetGlow
 * @date 2022-01-13 10:16
 * @since 0.1
 **/
public class Graph<T> {
    private Integer size;
    private LinkedList<T>[] nodes;

    public Graph(int size) {
        this.size = size;
        for (int i = 0; i < size; ++i) {
            nodes[i] = new LinkedList<>();
        }
    }
}
