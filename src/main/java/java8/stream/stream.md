使用 Stream 3步骤：
    1.创建流。
    2.中间操作。
    3.终止操作。


BaseStream         顶级接口

AbstractPipeline   类结构 ，双向链表

    Head
    StatelessOp
    StatefulOp

Sink<T> ：包装中间操作的执行逻辑， 单向链表
Spliterator<T> 分隔器：解析数据源



```java
    abstract static class ChainedReference<T, E_OUT> implements Sink<T> {
    
        // Sink 本质上是个单向链表
        protected final Sink<? super E_OUT> downstream;

        public ChainedReference(Sink<? super E_OUT> downstream) {
            this.downstream = Objects.requireNonNull(downstream);
        }

        @Override
        public void begin(long size) {
            downstream.begin(size);
        }

        @Override
        public void end() {
            downstream.end();
        }

        @Override
        public boolean cancellationRequested() {
            return downstream.cancellationRequested();
        }
    }
```

```java

abstract class AbstractPipeline<E_IN, E_OUT, S extends BaseStream<E_OUT, S>>
        extends PipelineHelper<E_OUT> implements BaseStream<E_OUT, S> {
    private static final String MSG_STREAM_LINKED = "stream has already been operated upon or closed";
    private static final String MSG_CONSUMED = "source already consumed or closed";

    /**
     * Backlink to the head of the pipeline chain (self if this is the source stage).
     * 管道的源阶段，源阶段对象指向自身。
     */
    @SuppressWarnings("rawtypes")
    private final AbstractPipeline sourceStage;

    /**
     * The "upstream" pipeline, or null if this is the source stage.
     * 当前阶段的上个阶段，源阶段对象没有上个阶段，指向null。
     */
    @SuppressWarnings("rawtypes")
    private final AbstractPipeline previousStage;

    /**
     * The next stage in the pipeline, or null if this is the last stage.
     * Effectively final at the point of linking to the next pipeline.
     * 当前阶段的下个阶段，管道最后一个阶段没有下个阶段，指向null。
     */
    @SuppressWarnings("rawtypes")
    private AbstractPipeline nextStage;
    
    /**
     * The operation flags for the intermediate operation represented by this
     * pipeline object.
     * 当前对象所处阶段的标志（源阶段、中间操作阶段或终止操作阶段），本质上就是记录当前对象在整个管道中所在的位置（第一个、中间 或 最后一个）。
     * 详细查看 StreamOpFlag 枚举类。
     */
    protected final int sourceOrOpFlags;
    
    /**
     * The number of intermediate operations between this pipeline object
     * and the stream source if sequential, or the previous stateful if parallel.
     * Valid at the point of pipeline preparation for evaluation.
     * 主要用于解析时定位当前对象所处调用队列深度，本质上是前面待执行阶段对象的个数。
     * 顺序流为前面中间操作的个数，并行流为前面状态操作的个数。
     */
    private int depth;

    /**
     * The combined source and operation flags for the source and all operations
     * up to and including the operation represented by this pipeline object.
     * Valid at the point of pipeline preparation for evaluation.
     * 主要用于解析时，确定当前对象所需要执行的中间操作，是 源阶段标志 和 前面所有中间操作标志 的结合。
     */
    private int combinedFlags;

    /**
     * The source spliterator. Only valid for the head pipeline.
     * Before the pipeline is consumed if non-null then {@code sourceSupplier}
     * must be null. After the pipeline is consumed if non-null then is set to
     * null.
     * 数据源元素分隔器，用于获取单个元素。只有源阶段对象中的才会起作用。
     */
    private Spliterator<?> sourceSpliterator;

    /**
     * The source supplier. Only valid for the head pipeline. Before the
     * pipeline is consumed if non-null then {@code sourceSpliterator} must be
     * null. After the pipeline is consumed if non-null then is set to null.
     * 数据源元素提供器，封装了数据源。只有源阶段对象中的才会起作用。
     */
    private Supplier<? extends Spliterator<?>> sourceSupplier;

    /**
     * True if this pipeline has been linked or consumed
     * 标志管道是链接状态还是终止状态。
     */
    private boolean linkedOrConsumed;

    /**
     * True if there are any stateful ops in the pipeline; only valid for the
     * source stage.
     * 标记管道是否存在状态操作。只有源阶段对象中的才会起作用。
     */
    private boolean sourceAnyStateful;

    /**
     * 关闭流事件。
     */
    private Runnable sourceCloseAction;

    /**
     * True if pipeline is parallel, otherwise the pipeline is sequential; only
     * valid for the source stage.
     * 标记管道是顺序流还是并行流。只有源阶段对象中的才会起作用。
     */
    private boolean parallel;

}

```