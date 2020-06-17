package com.shuanger.springbootexample.idGenerator;

public interface IdGenerator<T> {

    /**
     * ID生成
     * @param dependence
     * @return
     */
    String generate(T dependence);

}
