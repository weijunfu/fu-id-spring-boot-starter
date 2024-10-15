package io.github.weijunfu.id.codec;

/**
 * 编码接口
 * @author ijunfu
 * @version 1.0.0
 * @since 1.0.1
 */
public interface Decoder<T, E> {

    /**
     * 解码方法
     * @author ijunfu
     * @version 1.0.0
     * @param   encoded 待解码字符串
     * @return  E 解码后的数据
     */
    E decode(T encoded);

}
