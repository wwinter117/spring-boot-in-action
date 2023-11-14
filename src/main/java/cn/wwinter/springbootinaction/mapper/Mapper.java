package cn.wwinter.springbootinaction.mapper;

/**
 * ClassName: Mapper
 * Package: cn.wwinter.springbootinaction.mapper
 * Description:
 * Datetime: 2023/11/13
 * Author: zhangdd
 */
public interface Mapper<A, B> {
    B mapperTo(A a);

    A mapperFrom(B b);
}
