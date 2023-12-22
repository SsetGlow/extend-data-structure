package priv.ssetglow.extenddatastructure.random;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import priv.ssetglow.extenddatastructure.datastructure.tree.BinaryTree;
import priv.ssetglow.extenddatastructure.datastructure.tree.node.BinaryTreeNode;
import priv.ssetglow.extenddatastructure.random.bean.RandomBean;
import priv.ssetglow.extenddatastructure.random.bean.RandomNode;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static java.math.RoundingMode.HALF_DOWN;
import static priv.ssetglow.extenddatastructure.common.Constants.BIG_DECIMAL_SCALE;

/**
 * @author SsetGlow
 * @date 2021-11-15 09:21
 * @since 0.1
 * <p>
 * random executor
 * for all random beans extend {@link RandomBean}
 * if all probabilities' sum < 1, may return the first element of the randomBeanLists
 **/
public class RandomExecutor {

    private static BinaryTree<RandomNode> TREE = null;

    @Contract("_->_")
    public static <T extends RandomBean> Optional<T> listRandom(@NotNull List<T> randomBeanList) throws RuntimeException {
        if (randomBeanList.isEmpty()) {
            return Optional.empty();
        }
        BigDecimal probability = BigDecimal.valueOf(Math.random()).setScale(BIG_DECIMAL_SCALE.numberValue.intValue(), HALF_DOWN);
        AtomicReference<T> targetBeanReference = new AtomicReference<>();
        AtomicReference<BigDecimal> currentProbability = new AtomicReference<>(BigDecimal.ZERO);
        randomBeanList.forEach(randomBean -> {
            if (targetBeanReference.get() != null) {
                return;
            }
            currentProbability.updateAndGet(n -> n.add(randomBean.getProbability()));
            if (probability.compareTo(currentProbability.get()) <= 0 && targetBeanReference.get() == null) {
                targetBeanReference.set(randomBean);
            }
        });
        //when randomBeanList is not empty, ensure it will get a randomBean
        return targetBeanReference.get() != null ? Optional.of(targetBeanReference.get()) : Optional.of(randomBeanList.get(0));
    }

    @Contract("_->_")
    public static <T extends RandomBean> Optional<T> mapRandom(@NotNull List<T> randomBeanList) throws RuntimeException {
        if (randomBeanList.isEmpty()) {
            return Optional.empty();
        }
        Map<Integer, RandomNode> randomMap = new HashMap<>(1 << 3);
        //build tree
        for (int index = 0; index < randomBeanList.size(); ++index) {
            randomMap.put(index, index == 0 ? new RandomNode(BigDecimal.ZERO, randomBeanList.get(index).getProbability()) : new RandomNode(randomMap.get(index - 1).getEnd(), randomMap.get(index - 1).getEnd().add(randomBeanList.get(index).getProbability())));
        }
        BigDecimal target = BigDecimal.valueOf(Math.random()).setScale(BIG_DECIMAL_SCALE.numberValue.intValue(), HALF_DOWN);
        int targetIndex = 0;
        for (int index = 0; index < randomMap.size(); ++index) {
            RandomNode node = randomMap.get(index);
            if (node.getBegin().compareTo(target) <= 0 && node.getEnd().compareTo(target) >= 0) {
                targetIndex = index;
                break;
            }
        }
        return Optional.of(randomBeanList.get(targetIndex));
    }

    @Contract("_->_")
    public static <T extends RandomBean> Optional<T> treeRandom(@NotNull List<T> randomBeanList) throws RuntimeException {
        if (randomBeanList.isEmpty()) {
            return Optional.empty();
        }
        //tree just init
        if (null == TREE || TREE.size == 0) {
            treeify(randomBeanList);
            return doTreeRandom(randomBeanList);
        }
        if (TREE.size == randomBeanList.size()) {
            return doTreeRandom(randomBeanList);
        }
        treeify(randomBeanList);
        return doTreeRandom(randomBeanList);
    }

    @Contract("_->_")
    private static <T extends RandomBean> Optional<T> doTreeRandom(@NotNull List<T> randomBeanList) {
        BigDecimal probability = BigDecimal.valueOf(new Random().nextDouble());
        BinaryTreeNode<RandomNode> treeNode = TREE.find(new RandomNode(probability, probability));
        if (null == treeNode) {
            return Optional.of(randomBeanList.get(0));
        }
        return Optional.of(randomBeanList.get(treeNode.getElement().getIndex()));
    }

    @Contract("_->_")
    private static <T extends RandomBean> void treeify(@NotNull List<T> randomBeanList) {
        RandomNode[] nodes = new RandomNode[randomBeanList.size()];
        RandomBean firstBean = randomBeanList.get(0);
        nodes[0] = new RandomNode(0, BigDecimal.ZERO, firstBean.getProbability());
        for (int i = 1; i < randomBeanList.size(); ++i) {
            RandomBean current = randomBeanList.get(i);
            RandomNode last = nodes[i - 1];
            nodes[i] = new RandomNode(i, last.getBegin().add(current.getProbability()), last.getEnd().add(current.getProbability()));
        }
        TREE = new BinaryTree<>();
        for (RandomNode node : nodes) {
            TREE.insert(node);
        }
    }

}
