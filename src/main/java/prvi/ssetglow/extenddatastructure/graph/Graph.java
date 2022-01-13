package prvi.ssetglow.extenddatastructure.graph;

import java.util.LinkedList;

/**
 * @program: extend-data-structure
 * @packageName: prvi.ssetglow.extenddatastructure.graph
 * @className: Graph
 * @description:
 * @author: SsetGlow
 * @date: 2022-01-13 10:16
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
