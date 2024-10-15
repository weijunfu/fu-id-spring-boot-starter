package io.github.weijunfu.id.codec;

/**
 * 编码接口
 * @author ijunfu
 * @version 1.0.0
 * @since 1.0.1
 */
public interface Encoder<T, E> {

    /**
     *
     * @author ijunfu
     * @version 1.0.0
     * @param	data 待编码数据
     * @return  E 编码后的数据
     */
    E encode(T data);
}
